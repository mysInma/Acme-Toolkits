package acme.testing.authenticated.systemConfiguration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedSystemConfigurationShowTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources =  "/authenticated/systemConfiguration/systemConfigurationShow.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void systemConfigShowTest(final String systemCurrency, final String acceptedCurrencies) {
		super.signIn("inventor01", "inventor01");

		super.clickOnMenu("Authenticated", "Show system configuration");
		
		super.checkFormExists();
		super.checkInputBoxHasValue("systemCurrency", systemCurrency);
		super.checkInputBoxHasValue("acceptedCurrencies", acceptedCurrencies);
		
		super.signOut();
	}
}
