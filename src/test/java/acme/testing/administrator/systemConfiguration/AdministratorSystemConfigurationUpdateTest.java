package acme.testing.administrator.systemConfiguration;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AdministratorSystemConfigurationUpdateTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/systemConfiguration/update-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveUpdateTest(final int recordIndex, final String systemCurrency, final String acceptedCurrencies, final String strongSpamTerms, 
		final String strongThreshold, final String weakSpamTerms, final String weakThreshold) {

		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Show system configuration");
		super.checkFormExists();
		super.checkSubmitExists("Update Configuration");

		super.fillInputBoxIn("systemCurrency", systemCurrency);
		super.fillInputBoxIn("acceptedCurrencies", acceptedCurrencies);
		super.fillInputBoxIn("strongSpamTerms", strongSpamTerms);
		super.fillInputBoxIn("strongThreshold", strongThreshold);
		super.fillInputBoxIn("weakSpamTerms", weakSpamTerms);
		super.fillInputBoxIn("weakThreshold", weakThreshold);

		super.clickOnSubmit("Update Configuration");

		super.clickOnMenu("Administrator", "Show system configuration");
		super.checkFormExists();

		super.checkInputBoxHasValue("systemCurrency", systemCurrency);
		super.checkInputBoxHasValue("acceptedCurrencies", acceptedCurrencies);
		super.checkInputBoxHasValue("strongSpamTerms", strongSpamTerms);
		super.checkInputBoxHasValue("strongThreshold", strongThreshold);
		super.checkInputBoxHasValue("weakSpamTerms", weakSpamTerms);
		super.checkInputBoxHasValue("weakThreshold", weakThreshold);

		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/administrator/systemConfiguration/update-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeUpdateTest(final int recordIndex, final String systemCurrency, final String acceptedCurrencies, final String strongSpamTerms, 
		final String strongThreshold, final String weakSpamTerms, final String weakThreshold) {

		super.signIn("administrator", "administrator");
		super.clickOnMenu("Administrator", "Show system configuration");
		super.checkFormExists();
		super.checkSubmitExists("Update Configuration");

		super.fillInputBoxIn("systemCurrency", systemCurrency);
		super.fillInputBoxIn("acceptedCurrencies", acceptedCurrencies);
		super.fillInputBoxIn("strongSpamTerms", strongSpamTerms);
		super.fillInputBoxIn("strongThreshold", strongThreshold);
		super.fillInputBoxIn("weakSpamTerms", weakSpamTerms);
		super.fillInputBoxIn("weakThreshold", weakThreshold);

		super.clickOnSubmit("Update Configuration");
		super.checkErrorsExist();

		super.signOut();
	}
}
