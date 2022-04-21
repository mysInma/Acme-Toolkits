package acme.forms;

import java.util.Map;

import org.springframework.data.util.Pair;

import acme.entities.patronages.PatronageStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministratorDashboard {
	
	// Attributes -------------------------------------------------------------
	
	protected Integer 								totalNumberOfComponents; 
	protected Map<Pair<String, String>, Double> 	averageRetailPriceOfComponentsByTechnologyCurrency;
	protected Map<Pair<String, String>, Double> 	deviationRetailPriceOfComponentsByTechnologyCurrency;
	protected Map<Pair<String, String>, Double> 	minimumRetailPriceOfComponentsByTechnologyCurrency;
	protected Map<Pair<String, String>, Double> 	maximumRetailPriceOfComponentsByTechnologyCurrency;

	protected Integer 								totalNumberOfTools;
	protected Map<String, Double> 					averageRetailPriceOfToolsByCurrency;
	protected Map<String, Double> 					deviationRetailPriceOfToolsByCurrency;
	protected Map<String, Double> 					minimumRetailPriceOfToolsByCurrency;
	protected Map<String, Double> 					maximumRetailPriceOfToolsByCurrency;

	protected Map<PatronageStatus, Integer> 		totalNumberOfPatronagesByStatus;
	protected Map<PatronageStatus, Double> 			averagePatronagesBudgetByStatus;
	protected Map<PatronageStatus, Double>			deviationPatronagesBudgetByStatu; 
	protected Map<PatronageStatus, Double> 			minimumPatronagesBudgetByStatus;
	protected Map<PatronageStatus, Double> 			maximumPatronagesBudgetByStatus;

}
