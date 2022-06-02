package acme.features.inventor.quantity;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkits.Quantity;
import acme.entities.toolkits.Toolkit;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.helpers.CollectionHelper;
import acme.framework.services.AbstractListService;
import acme.roles.Inventor;

@Service
public class InventorQuantityListService implements AbstractListService<Inventor, Quantity>{
	
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
		
		return (toolkit.getInventor().getId()==activeId);	
	}

	@Override
	public Collection<Quantity> findMany(final Request<Quantity> request) {
		
		final Integer toolkitId = request.getModel().getInteger("toolkitId");
		return this.repository.findQuantitiesByToolkitId(toolkitId);
		
	}

	@Override
	public void unbind(final Request<Quantity> request, final Collection<Quantity> entities, final Model model) {
		assert request != null;
		assert !CollectionHelper.someNull(entities);
		assert model != null;
		
		int toolkitId;
		Toolkit toolkit;
		final boolean showCreate;
		final boolean publishedItems;
		
		toolkitId = request.getModel().getInteger("toolkitId");
		toolkit = this.repository.findToolkitById(toolkitId);
		showCreate  = (request.isPrincipal(toolkit.getInventor()) && !toolkit.getPublished());
		publishedItems = !this.repository.findPublishedItems().isEmpty();
		
		model.setAttribute("toolkitId", toolkitId);
		model.setAttribute("showCreate", showCreate);
		model.setAttribute("publishedItems", publishedItems);
	}

	@Override
	public void unbind(final Request<Quantity> request, final Quantity entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		final String itemName = entity.getItem().getName();
		
		request.unbind(entity, model, "value", "item");
		model.setAttribute("item.name", itemName);
		
	}

}
