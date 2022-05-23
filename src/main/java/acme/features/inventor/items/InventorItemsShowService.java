package acme.features.inventor.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkits.Item;
import acme.features.authenticated.moneyExchange.AuthenticatedMoneyExchangePerformService;
import acme.features.authenticated.systemConfiguration.AuthenticatedSystemConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorItemsShowService implements AbstractShowService<Inventor, Item> {

	@Autowired
	protected InventorItemsRepository repository;
	
	@Autowired
	protected AuthenticatedSystemConfigurationRepository systemConfigurationRepository;
	
	@Autowired
	protected AuthenticatedMoneyExchangePerformService exchangeService;
	
	@Override
	public boolean authorise(final Request<Item> request) {
		assert request != null;
		
		boolean result;
		
		final int id = request.getModel().getInteger("id");
		final Item item = this.repository.findOneById(id);
		final int myId = request.getPrincipal().getActiveRoleId();
		
		result = (item.getId() == myId || item.getInventor().getId() == myId);
		
		return result;
	}

	@Override
	public Item findOne(final Request<Item> request) {
		assert request != null;
		Item result;
		int id;
		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);
		return result;
	}

	@Override
	public void unbind(final Request<Item> request, final Item entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;
		
		//final int inventorId;
		
		//inventorId = entity.getInventor().getUserAccount().getId();
		request.unbind(entity, model, "name", "code", "technology", "description", "price", "type", "published", "link");
		
		model.setAttribute("inventorFullName", entity.getInventor().getUserAccount().getIdentity().getFullName());
		model.setAttribute("inventorName", entity.getInventor().getUserAccount().getIdentity().getName());
		model.setAttribute("inventorSurname", entity.getInventor().getUserAccount().getIdentity().getSurname());
		model.setAttribute("inventorEmail", entity.getInventor().getUserAccount().getIdentity().getEmail());
		model.setAttribute("exchangePrice", this.exchangeService
        	.computeMoneyExchange(entity.getPrice(), this.systemConfigurationRepository.findSystemConfiguration().getSystemCurrency()).getTarget());
		
		
		
	}
}
