package acme.testing.inventor.patronages;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.entities.patronages.PatronageStatus;
import acme.testing.TestHarness;

public class InventorPatronageAcceptTest  extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/acceptPatronage.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveAcceptTest(final int recordIndex, final PatronageStatus status,final boolean draftMode, 
		final String legalStuff, final String budget, final String link) {

		
		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Patronages list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(0, "asc");

		super.checkColumnHasValue(recordIndex, 0, "PROPOSED");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();

		super.clickOnSubmit("Accept");

		super.checkNotErrorsExist();

		super.signOut();

	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronage/negativeAcceptPatronage.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeAcceptTest(final int recordIndex, final PatronageStatus status,final boolean draftMode, 
		final String legalStuff, final String budget, final String link) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Patronages list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(0, "asc");

		super.checkColumnHasValue(recordIndex, 0, "PROPOSED");
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkNotButtonExists("Accept");

		super.signOut();

	}

}
