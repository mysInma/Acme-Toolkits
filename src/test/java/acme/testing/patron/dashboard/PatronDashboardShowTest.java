package acme.testing.patron.dashboard;

import java.util.Map;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.springframework.data.util.Pair;

import acme.entities.patronages.PatronageStatus;
import acme.testing.TestHarness;

public class PatronDashboardShowTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/patron/dashboard/dashboard.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positive(final Map<PatronageStatus, Integer> 				totalNumberOfPatronagesByStatus,
						final Map<Pair<String, PatronageStatus>, Double> 	averageBudgetOfPatronagesStatusByCurrency,
						final Map<Pair<String, PatronageStatus>, Double> 	deviationBudgetOfPatronagesStatusByCurrency,
						final Map<Pair<String, PatronageStatus>, Double> 	minimumBudgetOfPatronagesStatusByCurrency,
						final Map<Pair<String, PatronageStatus>, Double> 	maximumBudgetOfPatronagesStatusByCurrency) {
		
		super.signIn("patron01", "patron01");

		super.checkFormExists();

		super.signOut();
	}
	
}
