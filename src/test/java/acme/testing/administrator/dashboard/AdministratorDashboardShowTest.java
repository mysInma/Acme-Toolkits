package acme.testing.administrator.dashboard;

import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.data.util.Pair;

import acme.entities.patronages.PatronageStatus;
import acme.testing.TestHarness;

public class AdministratorDashboardShowTest extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/dashboard/dashboard.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final Integer 								totalNumberOfComponents, 
						final Map<Pair<String, String>, Double> 	averageRetailPriceOfComponentsByTechnologyCurrency,
						final Map<Pair<String, String>, Double> 	deviationRetailPriceOfComponentsByTechnologyCurrency,
						final Map<Pair<String, String>, Double> 	minimumRetailPriceOfComponentsByTechnologyCurrency,
						final Map<Pair<String, String>, Double> 	maximumRetailPriceOfComponentsByTechnologyCurrency,
						final Integer 								totalNumberOfTools,
						final Map<String, Double> 					averageRetailPriceOfToolsByCurrency,
						final Map<String, Double> 					deviationRetailPriceOfToolsByCurrency,
						final Map<String, Double> 					minimumRetailPriceOfToolsByCurrency,
						final Map<String, Double> 					maximumRetailPriceOfToolsByCurrency,
						final Map<PatronageStatus, Integer> 		totalNumberOfPatronagesByStatus,
						final Map<PatronageStatus, Double> 			averagePatronagesBudgetByStatus,
						final Map<PatronageStatus, Double>			deviationPatronagesBudgetByStatu,
						final Map<PatronageStatus, Double> 			minimumPatronagesBudgetByStatus,
						final Map<PatronageStatus, Double> 			maximumPatronagesBudgetByStatus) {
		
		super.signIn("administrator", "administrator");

		super.checkFormExists();

		super.signOut();
	}

}
