package acme.features.inventor.toolkits;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.toolkits.Toolkit;
import acme.features.authenticated.moneyExchange.AuthenticatedMoneyExchangePerformService;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.datatypes.Money;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorToolkitShowService implements AbstractShowService<Inventor, Toolkit>{
	
	@Autowired
	protected InventorToolkitRepository repository;
	
	@Autowired
	protected AuthenticatedMoneyExchangePerformService moneyService;
	
	@Override
	public boolean authorise(final Request<Toolkit> request) {
		assert request != null;
		boolean result;
		
		final int id = request.getModel().getInteger("id");
		final Toolkit toolkit = this.repository.findToolkitById(id);
		final int myId = request.getPrincipal().getActiveRoleId();
		
		result = (toolkit.getId() == myId || toolkit.getInventor().getId() == myId);
		
		return result;
	}
	
	@Override
	public Toolkit findOne(final Request<Toolkit> request) {
		assert request != null;

		Toolkit result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findToolkitById(id);

		return result;
	}
	
	@Override
	public void unbind(final Request<Toolkit> request, final Toolkit entity, final Model model) {


		assert request != null;
		assert entity != null;
		assert model != null;
		
		final String systemCurrency= this.repository.systemCurrency();
		
		final Collection<Money> collectedMoneys= this.repository.collectPrices(entity.getId());
		final Double totalPrice=collectedMoneys.stream().mapToDouble(p->this.moneyService.computeMoneyExchange(p,systemCurrency ).getTarget().getAmount()).sum();
		final Money money= new Money();
		money.setAmount(totalPrice);
		money.setCurrency(systemCurrency);
		
		model.setAttribute("totalPrice", money);
		model.setAttribute("toolkitId", entity.getId());
		
		request.unbind(entity, model, "code", "title", "description","notes","link","published");
		
		
	}


}
