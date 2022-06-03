package acme.features.any.xustemuDashboard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.form.XustemuDashboard;
import acme.framework.components.models.Model;
import acme.framework.controllers.Request;
import acme.framework.roles.Any;
import acme.framework.services.AbstractShowService;

@Service
public class XustemuDashboradShowService implements AbstractShowService<Any, XustemuDashboard> {


	@Autowired
	protected XustemuDashboradRepository repository;


	@Override
	public boolean authorise(final Request<XustemuDashboard> request) {
		assert request != null;
		boolean result;

		result = request.getPrincipal().hasRole(Any.class);

		return result;
	}

	@Override
	public XustemuDashboard findOne(final Request<XustemuDashboard> request) {
		assert request != null;

		XustemuDashboard result;
		
		
		final Integer						           totalNumberOfToolsWithXustemu;
		totalNumberOfToolsWithXustemu = this.repository.totalNumberOfToolsWithXustemu();
		
		final Integer						           totalNumberOfComponentsWithXustemu;
		totalNumberOfComponentsWithXustemu = this.repository.totalNumberOfComponentsWithXustemu();
		
		
	    final Map<String, Double>    averageAmountOfToolsByCurrency  = new HashMap<>();
	    final Map<String, Double>    deviationAmountOfToolsByCurrency = new HashMap<>();
	    final Map<String, Double>    minimumAmountOfToolsByCurrency = new HashMap<>();
	    final Map<String, Double>    maximumAmountOfToolsByCurrency = new HashMap<>();
	    final Map<String, Double>    averageAmountOfComponentsByCurrency  = new HashMap<>();
	    final Map<String, Double>    deviationAmountOfComponentsByCurrency = new HashMap<>();
	    final Map<String, Double>    minimumAmountOfComponentsByCurrency = new HashMap<>();
	    final Map<String, Double>    maximumAmountOfComponentsByCurrency = new HashMap<>();
	
	    
		final List<Object[]> metricsOfToolsByCurrency = this.repository.findMetricsOfToolsByCurrency();
	    for(final Object[] fila : metricsOfToolsByCurrency) {
			final String currency = (String) fila[0];
			final Double avg = (Double) fila[1];
			final Double stdev = (Double) fila[2];
			final Double min = (Double) fila[3];
			final Double max = (Double) fila[4];
			
			averageAmountOfToolsByCurrency.put(currency, avg);
			deviationAmountOfToolsByCurrency.put(currency, stdev);
			minimumAmountOfToolsByCurrency.put(currency, min);
			maximumAmountOfToolsByCurrency.put(currency, max);
		}
	    
	    final List<Object[]> metricsOfComponentsByCurrency = this.repository.findMetricsOfComponentsByCurrency();
	    for(final Object[] fila : metricsOfComponentsByCurrency) {
			final String currency = (String) fila[0];
			final Double avg = (Double) fila[1];
			final Double stdev = (Double) fila[2];
			final Double min = (Double) fila[3];
			final Double max = (Double) fila[4];
			
			averageAmountOfComponentsByCurrency.put(currency, avg);
			deviationAmountOfComponentsByCurrency.put(currency, stdev);
			minimumAmountOfComponentsByCurrency.put(currency, min);
			maximumAmountOfComponentsByCurrency.put(currency, max);
		}
	    	    
		result = new XustemuDashboard();
		
		result.setTotalNumberOfToolsWithXustemu(totalNumberOfToolsWithXustemu);
		
		result.setTotalNumberOfComponentsWithXustemu(totalNumberOfComponentsWithXustemu);
		
		result.setAverageAmountOfToolsByCurrency(averageAmountOfToolsByCurrency);
		result.setDeviationAmountOfToolsByCurrency(deviationAmountOfToolsByCurrency);
		result.setMinimumAmountOfToolsByCurrency(minimumAmountOfToolsByCurrency);
		result.setMaximumAmountOfToolsByCurrency(maximumAmountOfToolsByCurrency);
		result.setAverageAmountOfComponentsByCurrency(averageAmountOfComponentsByCurrency);
		result.setDeviationAmountOfComponentsByCurrency(deviationAmountOfComponentsByCurrency);
		result.setMinimumAmountOfComponentsByCurrency(minimumAmountOfComponentsByCurrency);
		result.setMaximumAmountOfComponentsByCurrency(maximumAmountOfComponentsByCurrency);
		
		return result;
	}

	@Override
	public void unbind(final Request<XustemuDashboard> request, final XustemuDashboard entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model,
			"totalNumberOfToolsWithXustemu","totalNumberOfComponentsWithXustemu", "averageAmountOfToolsByCurrency", "deviationAmountOfToolsByCurrency", "minimumAmountOfToolsByCurrency", "maximumAmountOfToolsByCurrency", "averageAmountOfComponentsByCurrency", "deviationAmountOfComponentsByCurrency", "minimumAmountOfComponentsByCurrency", "maximumAmountOfComponentsByCurrency");
		
		
		final Set<String> currencies = entity.getDeviationAmountOfComponentsByCurrency().keySet();
		model.setAttribute("currency", currencies);
	}

}