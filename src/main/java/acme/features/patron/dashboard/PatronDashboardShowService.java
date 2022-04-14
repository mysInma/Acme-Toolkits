package acme.features.patron.dashboard;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.entities.patronages.PatronageStatus;
import acme.forms.PatronDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.services.AbstractShowService;
import acme.roles.Patron;

@Service
public class PatronDashboardShowService implements AbstractShowService<Patron, PatronDashboard> {

	@Autowired
	protected PatronDashboardRepository repository;
	
	@Override
	public boolean authorise(final Request<PatronDashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public PatronDashboard findOne(final Request<PatronDashboard> request) {
		
		PatronDashboard result;
		
		result = new PatronDashboard();
		
		final Map<PatronageStatus, Integer> totalNumberOfPatronagesByStatus = new EnumMap<>(PatronageStatus.class);
		
		final Integer numberOfProposedPatronages = this.repository.numberOfProposedPatronages();
		final Integer numberOfAcceptedPatronages = this.repository.numberOfAcceptedPatronages();
		final Integer numberOfDeniedPatronages = this.repository.numberOfDeniedPatronages();
		
		totalNumberOfPatronagesByStatus.put(PatronageStatus.PROPOSED, numberOfProposedPatronages);
		totalNumberOfPatronagesByStatus.put(PatronageStatus.ACCEPTED, numberOfAcceptedPatronages);
		totalNumberOfPatronagesByStatus.put(PatronageStatus.DENIED, numberOfDeniedPatronages);
				
		final Map<Pair<String, PatronageStatus>, Double> averageBudgetOfPatronagesStatusByCurrency = new HashMap<Pair<String,PatronageStatus>, Double>();
		final List<String> averageBudgetByCurrency = this.repository.averageBudgetOfPatronagesStatusByCurrency();
		
		for(final String item: averageBudgetByCurrency) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final String currency = split[0];
			final PatronageStatus status = PatronageStatus.valueOf(split[2]);
			final Pair<String, PatronageStatus> key = Pair.of(currency, status);
			averageBudgetOfPatronagesStatusByCurrency.put(key, amount);
		}
				
		final Map<Pair<String, PatronageStatus>, Double> deviationBudgetOfPatronagesStatusByCurrency = new HashMap<Pair<String,PatronageStatus>, Double>();
		final List<String> deviationBudgetByCurrency = this.repository.deviationBudgetOfPatronagesStatusByCurrency();
		
		for(final String item: deviationBudgetByCurrency) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final String currency = split[0];
			final PatronageStatus status = PatronageStatus.valueOf(split[2]);
			final Pair<String, PatronageStatus> key = Pair.of(currency, status);
			deviationBudgetOfPatronagesStatusByCurrency.put(key, amount);
		}
		
		final Map<Pair<String, PatronageStatus>, Double> minimumBudgetOfPatronagesStatusByCurrency = new HashMap<Pair<String,PatronageStatus>, Double>();
		final List<String> minimumBudgetByCurrency = this.repository.minimumBudgetOfPatronagesStatusByCurrency();
		
		for(final String item: minimumBudgetByCurrency) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final String currency = split[0];
			final PatronageStatus status = PatronageStatus.valueOf(split[2]);
			final Pair<String, PatronageStatus> key = Pair.of(currency, status);
			minimumBudgetOfPatronagesStatusByCurrency.put(key, amount);
		}
		
		final Map<Pair<String, PatronageStatus>, Double> maximumBudgetOfPatronagesStatusByCurrency = new HashMap<Pair<String,PatronageStatus>, Double>();
		final List<String> maximumBudgetByCurrency = this.repository.maximumBudgetOfPatronagesStatusByCurrency();
		
		for(final String item: maximumBudgetByCurrency) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final String currency = split[0];
			final PatronageStatus status = PatronageStatus.valueOf(split[2]);
			final Pair<String, PatronageStatus> key = Pair.of(currency, status);
			maximumBudgetOfPatronagesStatusByCurrency.put(key, amount);
		}
		
		result.setTotalNumberOfPatronagesByStatus(totalNumberOfPatronagesByStatus);
		result.setAverageBudgetOfPatronagesStatusByCurrency(averageBudgetOfPatronagesStatusByCurrency);
		result.setDeviationBudgetOfPatronagesStatusByCurrency(deviationBudgetOfPatronagesStatusByCurrency);
		result.setMinimumBudgetOfPatronagesStatusByCurrency(minimumBudgetOfPatronagesStatusByCurrency);
		result.setMaximumBudgetOfPatronagesStatusByCurrency(maximumBudgetOfPatronagesStatusByCurrency);
		
		return result;
	}

	@Override
	public void unbind(final Request<PatronDashboard> request, final PatronDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, 
			"totalNumberOfPatronagesByStatus", 
			"averageBudgetOfPatronagesStatusByCurrency",
			"deviationBudgetOfPatronagesStatusByCurrency", 
			"minimumBudgetOfPatronagesStatusByCurrency",
			"maximumBudgetOfPatronagesStatusByCurrency");
	}

}
