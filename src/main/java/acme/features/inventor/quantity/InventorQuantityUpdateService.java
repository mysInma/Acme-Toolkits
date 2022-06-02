package acme.features.inventor.quantity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkits.Item;
import acme.entities.toolkits.ItemType;
import acme.entities.toolkits.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Errors;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractUpdateService;
import acme.roles.Inventor;

@Service
public class InventorQuantityUpdateService implements AbstractUpdateService<Inventor,Quantity>{	
	
	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorQuantityRepository repository;


	// AbstractListService<Inventor, Artifact> interface ---------------------------
	

	@Override
	public boolean authorise(final Request<Quantity> request) {
		assert request != null;
		
		final Integer quantityId = request.getModel().getInteger("id");
		final Toolkit toolkit = this.repository.findToolkitByQuantityId(quantityId);
		final Integer activeId = request.getPrincipal().getActiveRoleId();
		
		return (!toolkit.getPublished() && toolkit.getInventor().getId()==activeId);	
	}
	
	@Override
	public void bind(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		request.bind(entity, errors, "value");
		
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;		

		final Item item = this.repository.findItemByQuantityId(entity.getId());

		
		request.unbind(entity, model, "value", "item.name");
		model.setAttribute("item.name", item.getName());
		model.setAttribute("item.code", item.getCode());
		model.setAttribute("item.technology", item.getTechnology());
		model.setAttribute("item.price", item.getPrice());
		model.setAttribute("item.description", item.getDescription());
		model.setAttribute("item.type", item.getType());
		model.setAttribute("item.link", item.getLink());
		model.setAttribute("published", entity.getToolkit().getPublished());
	}

	@Override
	public Quantity findOne(final Request<Quantity> request) {
		assert request != null;
		
		Integer id;
		Quantity quantity;
		id = request.getModel().getInteger("id");
		quantity = this.repository.findQuantityById(id);
		
		return quantity;
	}


	@Override
	public void validate(final Request<Quantity> request, final Quantity entity, final Errors errors) {
		assert request != null;
		assert entity != null;
		assert errors != null;
		
		if(entity.getItem().getType() == ItemType.TOOL) {
			errors.state(request, entity.getValue()<=1, "*", "inventor.quantity.form.error.only-1-type-of-tool-allowed");
		}
	}

	@Override
	public void update(final Request<Quantity> request, final Quantity entity) {
		assert request != null;
		assert entity != null;
		

		this.repository.save(entity);
		
	}

}