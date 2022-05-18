package acme.testing.patron.patronages;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class PatronPatronageCreateTest extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positivePatronageTest(final int recordIndex,
									  final String code,
									  final String legalStuff,
									  final String creationMoment,
									  final String startDate,
									  final String finishDate,
									  final String budget,
									  final String link,
									  final String inventor) {
		super.signIn("patron01", "patron01");
		super.clickOnMenu("Patron", "Patronages list");
		
		super.checkListingExists();
		super.checkNotListingEmpty();
		
		super.clickOnButton("Create");
		
		super.checkFormExists();
		
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("legalStuff", legalStuff);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("inventor", inventor);
		
		super.clickOnSubmit("Create");
		
		super.clickOnMenu("Patron", "Patronages list");
		
		super.checkListingExists();
		super.checkNotListingEmpty();
		super.sortListing(0, "desc");

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("legalStuff", legalStuff);
		super.checkInputBoxHasValue("creationMoment", creationMoment);
		super.checkInputBoxHasValue("startDate", startDate);
		super.checkInputBoxHasValue("finishDate", finishDate);
		super.checkInputBoxHasValue("budget", budget);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("inventor", inventor);

		super.signOut();
		
		
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/patron/patronage/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativePatronageTest(final int recordIndex,
									  final String code,
									  final String legalStuff,
									  final String creationMoment,
									  final String startDate,
									  final String finishDate,
									  final String budget,
									  final String link,
									  final String inventor) {
		super.signIn("patron01", "patron01");
		super.clickOnMenu("Patron", "Patronages list");
		
		super.checkListingExists();
		super.checkNotListingEmpty();
		
		super.clickOnButton("Create");
		
		super.checkFormExists();
		
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("legalStuff", legalStuff);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("budget", budget);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("inventor", inventor);
		
		super.clickOnSubmit("Create");
		
		super.checkFormExists();
		super.checkErrorsExist();

		super.signOut();
		
		
	}

}
