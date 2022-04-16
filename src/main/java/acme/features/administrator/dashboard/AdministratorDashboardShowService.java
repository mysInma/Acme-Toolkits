package acme.features.administrator.dashboard;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;

import acme.entities.patronages.PatronageStatus;
import acme.forms.AdministratorDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Administrator;
import acme.framework.services.AbstractShowService;

@Service
public class AdministratorDashboardShowService implements AbstractShowService<Administrator, AdministratorDashboard> {
	
	@Autowired
	protected AdministratorDashboardRepository repository;
	
	@Override
	public boolean authorise(final Request<AdministratorDashboard> request) {
		assert request != null;

		return true;
	}

	@Override
	public AdministratorDashboard findOne(final Request<AdministratorDashboard> request) {
		AdministratorDashboard result;
		result = new AdministratorDashboard();
		
		final Integer totalNumberOfComponents = this.repository.totalNumberOfComponents();
		
		final Map<Pair<String, String>, Double> averageRetailPriceOfComponentsByTechnologyCurrency = new HashMap<Pair<String,String>, Double>();
		final List<String> averageRetailPriceOfComponents = this.repository.averageRetailPriceOfComponentsByTechnologyCurrency();
		
		for(final String item: averageRetailPriceOfComponents) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final String currency = split[0];
			final String technology = split[2];
			final Pair<String, String> key = Pair.of(currency, technology);
			averageRetailPriceOfComponentsByTechnologyCurrency.put(key, amount);
		}
		
		final Map<Pair<String, String>, Double> deviationRetailPriceOfComponentsByTechnologyCurrency = new HashMap<Pair<String,String>, Double>();
		final List<String> deviationRetailPriceOfComponents = this.repository.deviationRetailPriceOfComponentsByTechnologyCurrency();
		
		for(final String item: deviationRetailPriceOfComponents) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final String currency = split[0];
			final String technology = split[2];
			final Pair<String, String> key = Pair.of(currency, technology);
			deviationRetailPriceOfComponentsByTechnologyCurrency.put(key, amount);
		}
		
		final Map<Pair<String, String>, Double> minimumRetailPriceOfComponentsByTechnologyCurrency = new HashMap<Pair<String,String>, Double>();
		final List<String> minimumRetailPriceOfComponents = this.repository.minimumRetailPriceOfComponentsByTechnologyCurrency();
		
		for(final String item: minimumRetailPriceOfComponents) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final String currency = split[0];
			final String technology = split[2];
			final Pair<String, String> key = Pair.of(currency, technology);
			minimumRetailPriceOfComponentsByTechnologyCurrency.put(key, amount);
		}
		
		final Map<Pair<String, String>, Double> maximumRetailPriceOfComponentsByTechnologyCurrency = new HashMap<Pair<String,String>, Double>();
		final List<String> maximumRetailPriceOfComponents = this.repository.maximumRetailPriceOfComponentsByTechnologyCurrency();
		
		for(final String item: maximumRetailPriceOfComponents) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final String currency = split[0];
			final String technology = split[2];
			final Pair<String, String> key = Pair.of(currency, technology);
			maximumRetailPriceOfComponentsByTechnologyCurrency.put(key, amount);
		}
		
		result.setTotalNumberOfComponents(totalNumberOfComponents);
		result.setAverageRetailPriceOfComponentsByTechnologyCurrency(averageRetailPriceOfComponentsByTechnologyCurrency);
		result.setDeviationRetailPriceOfComponentsByTechnologyCurrency(deviationRetailPriceOfComponentsByTechnologyCurrency);
		result.setMinimumRetailPriceOfComponentsByTechnologyCurrency(minimumRetailPriceOfComponentsByTechnologyCurrency);
		result.setMaximumRetailPriceOfComponentsByTechnologyCurrency(maximumRetailPriceOfComponentsByTechnologyCurrency);
		
		final Integer totalNumberOfTools = this.repository.totalNumberOfTools();
		
		final Map<String, Double> averageRetailPriceOfToolsByCurrency = new HashMap<String, Double>();
		final List<String> averageRetailPriceOfTools = this.repository.averageRetailPriceOfToolsByCurrency();
		
		for(final String item: averageRetailPriceOfTools) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final String currency = split[0];
			averageRetailPriceOfToolsByCurrency.put(currency, amount);
		}
		
		final Map<String, Double> deviationRetailPriceOfToolsByCurrency = new HashMap<String, Double>();
		final List<String> deviationRetailPriceOfTools = this.repository.deviationRetailPriceOfToolsByCurrency();
		
		for(final String item: deviationRetailPriceOfTools) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final String currency = split[0];
			deviationRetailPriceOfToolsByCurrency.put(currency, amount);
		}
		
		final Map<String, Double> minimumRetailPriceOfToolsByCurrency = new HashMap<String, Double>();
		final List<String> minimumRetailPriceOfTools = this.repository.minimumRetailPriceOfToolsByCurrency();
		
		for(final String item: minimumRetailPriceOfTools) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final String currency = split[0];
			minimumRetailPriceOfToolsByCurrency.put(currency, amount);
		}
		
		final Map<String, Double> maximumRetailPriceOfToolsByCurrency = new HashMap<String, Double>();
		final List<String> maximumRetailPriceOfTools = this.repository.maximumRetailPriceOfToolsByCurrency();
		
		for(final String item: maximumRetailPriceOfTools) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final String currency = split[0];
			maximumRetailPriceOfToolsByCurrency.put(currency, amount);
		}
		
		result.setTotalNumberOfTools(totalNumberOfTools);
		result.setAverageRetailPriceOfToolsByCurrency(averageRetailPriceOfToolsByCurrency);
		result.setDeviationRetailPriceOfToolsByCurrency(deviationRetailPriceOfToolsByCurrency);
		result.setMinimumRetailPriceOfToolsByCurrency(minimumRetailPriceOfToolsByCurrency);
		result.setMaximumRetailPriceOfToolsByCurrency(maximumRetailPriceOfToolsByCurrency);
		
		final Map<PatronageStatus, Integer> totalNumberOfPatronagesByStatus = new EnumMap<>(PatronageStatus.class);
		final List<String> totalNumberOfPatronages = this.repository.totalNumberOfPatronagesByStatus();
		
		for(final String item: totalNumberOfPatronages) {
			final String[] split = item.split(",");
			final Integer amount = Integer.valueOf(split[1]);
			final PatronageStatus status = PatronageStatus.valueOf(split[0]);
			totalNumberOfPatronagesByStatus.put(status, amount);
		}
		
		final Map<PatronageStatus, Double> averagePatronagesBudgetByStatus = new EnumMap<>(PatronageStatus.class);
		final List<String> averagePatronagesBudget = this.repository.averagePatronagesBudgetByStatus();
		
		for(final String item: averagePatronagesBudget) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final PatronageStatus status = PatronageStatus.valueOf(split[0]);
			averagePatronagesBudgetByStatus.put(status, amount);
		}
		
		final Map<PatronageStatus, Double> deviationPatronagesBudgetByStatus = new EnumMap<>(PatronageStatus.class);
		final List<String> deviationPatronagesBudget = this.repository.deviationPatronagesBudgetByStatus();
		
		for(final String item: deviationPatronagesBudget) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final PatronageStatus status = PatronageStatus.valueOf(split[0]);
			deviationPatronagesBudgetByStatus.put(status, amount);
		}
		
		final Map<PatronageStatus, Double> minimumPatronagesBudgetByStatus = new EnumMap<>(PatronageStatus.class);
		final List<String> minimumPatronagesBudget = this.repository.minimumPatronagesBudgetByStatus();
		
		for(final String item: minimumPatronagesBudget) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final PatronageStatus status = PatronageStatus.valueOf(split[0]);
			minimumPatronagesBudgetByStatus.put(status, amount);
		}
		
		final Map<PatronageStatus, Double> maximumPatronagesBudgetByStatus = new EnumMap<>(PatronageStatus.class);
		final List<String> maximumPatronagesBudget = this.repository.maximumPatronagesBudgetByStatus();
		
		for(final String item: maximumPatronagesBudget) {
			final String[] split = item.split(",");
			final Double amount = Double.parseDouble(split[1]);
			final PatronageStatus status = PatronageStatus.valueOf(split[0]);
			maximumPatronagesBudgetByStatus.put(status, amount);
		}
		
		result.setTotalNumberOfPatronagesByStatus(totalNumberOfPatronagesByStatus);
		result.setAveragePatronagesBudgetByStatus(averagePatronagesBudgetByStatus);
		result.setDeviationPatronagesBudgetByStatu(deviationPatronagesBudgetByStatus);
		result.setMinimumPatronagesBudgetByStatus(minimumPatronagesBudgetByStatus);
		result.setMaximumPatronagesBudgetByStatus(maximumPatronagesBudgetByStatus);
		
		return result;
	}

	@Override
	public void unbind(final Request<AdministratorDashboard> request, final AdministratorDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, 
			"totalNumberOfComponents", 
			"averageRetailPriceOfComponentsByTechnologyCurrency",
			"deviationRetailPriceOfComponentsByTechnologyCurrency", 
			"minimumRetailPriceOfComponentsByTechnologyCurrency",
			"maximumRetailPriceOfComponentsByTechnologyCurrency", 
			"totalNumberOfTools", 
			"averageRetailPriceOfToolsByCurrency",
			"deviationRetailPriceOfToolsByCurrency", 
			"minimumRetailPriceOfToolsByCurrency",
			"maximumRetailPriceOfToolsByCurrency", 
			"totalNumberOfPatronagesByStatus", 
			"averagePatronagesBudgetByStatus",
			"deviationPatronagesBudgetByStatu", 
			"minimumPatronagesBudgetByStatus",
			"maximumPatronagesBudgetByStatus");
	}

}
