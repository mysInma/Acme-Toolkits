
package acme.features.inventor.patronageReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.patronages.PatronageReport;
import acme.features.authenticated.moneyExchange.AuthenticatedMoneyExchangePerformService;
import acme.features.authenticated.systemConfiguration.AuthenticatedSystemConfigurationRepository;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Inventor;

@Service
public class InventorPatronageReportShowService implements AbstractShowService<Inventor, PatronageReport> {

	@Autowired
	private InventorPatronageReportRepository				repository;

	@Autowired
	protected AuthenticatedSystemConfigurationRepository	systemConfigurationRepository;

	@Autowired
	protected AuthenticatedMoneyExchangePerformService		exchangeService;


	@Override
	public boolean authorise(final Request<PatronageReport> request) {
		assert request != null;
		boolean result;

		final int id = request.getModel().getInteger("id");
		final PatronageReport patronageReport = this.repository.findPatronageReportById(id);
		final int myId = request.getPrincipal().getActiveRoleId();

		result = (patronageReport.getId() == myId || patronageReport.getPatronage().getInventor().getId() == myId);

		return result;
	}

	@Override
	public PatronageReport findOne(final Request<PatronageReport> request) {
		assert request != null;

		PatronageReport result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findPatronageReportById(id);

		return result;
	}

	@Override
	public void unbind(final Request<PatronageReport> request, final PatronageReport entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "creationMoment", "memorandum", "link");
		model.setAttribute("readonly", true);
		model.setAttribute("patronageId", entity.getPatronage().getId());
		model.setAttribute("patronageStatus", entity.getPatronage().getStatus());
		model.setAttribute("patronageLegalStuff", entity.getPatronage().getLegalStuff());
		model.setAttribute("patronageBudget", entity.getPatronage().getBudget());
		model.setAttribute("patronageCreationMoment", entity.getPatronage().getCreationMoment());
		model.setAttribute("patronageStartDate", entity.getPatronage().getStartDate());
		model.setAttribute("patronageFinishDate", entity.getPatronage().getFinishDate());
		model.setAttribute("patronageLink", entity.getPatronage().getLink());
		model.setAttribute("patronageCode", entity.getPatronage().getCode());
		model.setAttribute("patronageExchangeBudget", this.exchangeService.computeMoneyExchange(entity.getPatronage().getBudget(), this.systemConfigurationRepository.findSystemConfiguration().getSystemCurrency()).getTarget());
	}

}
