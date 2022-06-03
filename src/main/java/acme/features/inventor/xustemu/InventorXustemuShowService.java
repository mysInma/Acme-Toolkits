
package acme.features.inventor.xustemu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.xustemu.Xustemu;
import acme.features.authenticated.moneyExchange.AuthenticatedMoneyExchangePerformService;
import acme.features.authenticated.systemConfiguration.AuthenticatedSystemConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorXustemuShowService implements AbstractShowService<Inventor, Xustemu> {

	// Internal state ---------------------------------------------------------

	@Autowired
	protected InventorXustemuRepository						repository;

	@Autowired
	protected AuthenticatedSystemConfigurationRepository	systemConfigurationRepository;

	@Autowired
	protected AuthenticatedMoneyExchangePerformService		exchangeService;


	@Override
	public boolean authorise(final Request<Xustemu> request) {
		assert request != null;
		boolean result;

		final int id = request.getModel().getInteger("id");
		final Xustemu xustemu = this.repository.findXustemuById(id);
		final int myId = request.getPrincipal().getActiveRoleId();

		result = (xustemu.getId() == myId || xustemu.getItem().getInventor().getId() == myId);

		return result;
	}

	@Override
	public Xustemu findOne(final Request<Xustemu> request) {
		assert request != null;

		Xustemu result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findXustemuById(id);

		return result;
	}

	@Override
	public void unbind(final Request<Xustemu> request, final Xustemu entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "code", "creationMoment", "subject", "summary", "startDate", "finishDate", "amount", "moreInfo");

		model.setAttribute("codeItem", entity.getItem().getCode());
		model.setAttribute("exchangeBudget", this.exchangeService.computeMoneyExchange(entity.getAmount(), this.systemConfigurationRepository.findSystemConfiguration().getSystemCurrency()).getTarget());

	}

}
