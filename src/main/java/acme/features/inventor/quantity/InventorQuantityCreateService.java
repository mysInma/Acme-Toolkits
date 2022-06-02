package acme.features.inventor.quantity;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.base.Objects;

import acme.entities.toolkits.Item;
import acme.entities.toolkits.ItemType;
import acme.entities.toolkits.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractCreateService;
import acme.roles.Inventor;

@Service
public class InventorQuantityCreateService  implements AbstractCreateService<Inventor,Quantity>{

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorQuantityRepository repository;
	
	// AbstractListService<Inventor, Artifact> interface ---------------------------
	
	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		
		final Integer toolkitId = request.getModel().getInteger("toolkitId");
		final Toolkit toolkit = this.repository.findToolkitById(toolkitId);
		final Integer activeId = request.getPrincipal().getActiveRoleId();
		final boolean publishedArtifacts = !this.repository.findPublishedItems().isEmpty();
		
		return (!toolkit.getPublished() && toolkit.getInventor().getId()==activeId && publishedArtifacts);	
	}

	@Override
	public void bind(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		Integer itemId;
		Item item;
		
		itemId = Integer.parseInt((String) request.getModel().getAttribute("item.id"));
		
		if(itemId == 0) {
			itemId = Integer.parseInt((String) request.getModel().getAttribute("item.idProxy"));
		}
		
		item = this.repository.findItemById(itemId);
		

		entity.setItem(item);
		request.bind(entity, errors, "value");
		
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;		
		
		List<Item> publishedItems;	
		publishedItems = this.repository.findPublishedItems();
		
		request.unbind(entity, model, "value", "item.id");
		model.setAttribute("toolkitId", request.getModel().getAttribute("toolkitId"));
		model.setAttribute("items", publishedItems);
		model.setAttribute("published", entity.getToolkit().getPublished());
		
		
	}

	@Override
	public Quantity instantiate(final Request<Quantity> request) {
		assert request != null;

		Integer toolkitId;
		Toolkit toolkit;
		final Item item;
		
		toolkitId = request.getModel().getInteger("toolkitId");
		toolkit = this.repository.findToolkitById(toolkitId);
		item = new Item();
		
		Quantity result;
		result = new Quantity();
		result.setToolkit(toolkit);
		result.setItem(item);

		return result;
	}

	@Override
	public void validate(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(entity.getItem().getType() == ItemType.TOOL) {
			errors.state(request, entity.getValue()<=1, "*", "inventor.quantity.form.error.only-1-type-of-tool-allowed");
		}
		if(!errors.hasErrors("item.id")) {
			final Collection<Quantity> quantities = this.repository.findQuantitiesByToolkitId(entity.getToolkit().getId());
			final Integer itemId = entity.getItem().getId();
			final boolean repeatedArtifact = quantities.stream()
										.anyMatch(x -> Objects.equal(x.getItem().getId(), itemId));
			errors.state(request, !repeatedArtifact, "*", "inventor.quantity.form.error.repeated-item");
			
		}
		
		
	}

	@Override
	public void create(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;
		
		this.repository.save(entity);
	}



}
