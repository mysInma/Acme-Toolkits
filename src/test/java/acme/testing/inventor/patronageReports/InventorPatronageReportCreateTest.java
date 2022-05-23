
package acme.testing.inventor.patronageReports;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportCreateTest extends TestHarness {

	// Test cases ------------------------------

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/create-positive.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String memorandum, final String link, final String confirmation, final String patronageCode, final String patronageLegalStuff, final String patronageBudget, final String patronageCreationMoment,
		final String patronageStartDate, final String patronageFinishDate, final String patronageLink) {
		super.signIn("inventor01", "inventor01");

		super.clickOnMenu("Inventor", "Patronage reports list");
		super.checkListingExists();

		super.clickOnButton("Create patronage report");

		super.checkFormExists();

		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmit("Create Patronage Report");

		super.clickOnMenu("Inventor", "Patronage reports list");
		super.checkListingExists();
		super.sortListing(0, "desc");
		super.checkColumnHasValue(recordIndex, 1, memorandum);
		super.checkColumnHasValue(recordIndex, 2, link);
		super.clickOnListingRecord(recordIndex);

		super.checkFormExists();
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("patronageCode", patronageCode);
		super.checkInputBoxHasValue("patronageLegalStuff", patronageLegalStuff);
		super.checkInputBoxHasValue("patronageBudget", patronageBudget);
		super.checkInputBoxHasValue("patronageCreationMoment", patronageCreationMoment);
		super.checkInputBoxHasValue("patronageStartDate", patronageStartDate);
		super.checkInputBoxHasValue("patronageFinishDate", patronageFinishDate);
		super.checkInputBoxHasValue("patronageLink", patronageLink);
		
		super.signOut();
	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/create-negative.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeTest(final int recordIndex, final String memorandum, final String link, final String confirmation) {
		super.signIn("inventor01", "inventor01");

		super.clickOnMenu("Inventor", "Patronage reports list");
		super.checkListingExists();

		super.clickOnButton("Create patronage report");

		super.checkFormExists();

		super.fillInputBoxIn("memorandum", memorandum);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("confirmation", confirmation);
		super.clickOnSubmit("Create Patronage Report");
		
		super.checkErrorsExist();
		
		super.signOut();
	}
	
	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/patronage-report/create");
		super.checkPanicExists();
		
		super.signIn("patron01", "patron01");
		super.navigate("/inventor/patronage-report/create");
		super.checkPanicExists();
		super.signOut();
	}

}
