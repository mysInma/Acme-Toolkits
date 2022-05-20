
package acme.testing.inventor.patronageReports;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPatronageReportTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/patronageReport/patronageReport.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String creationMoment, final String memorandum, final String link, final String patronageStatus, final String patronageCode, final String patronageLegalStuff, final String patronageBudget, final String patronageCreationMoment, final String patronageStartDate, final String patronageFinishDate, final String patronageLink) {

		super.signIn("inventor01", "inventor01");

		super.clickOnMenu("Inventor", "Patronage reports list");
		super.checkListingExists();
		super.sortListing(1, "asc");

		super.checkColumnHasValue(recordIndex, 0, creationMoment);
		super.checkColumnHasValue(recordIndex, 1, memorandum);
		super.checkColumnHasValue(recordIndex, 2, link);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();

		super.checkInputBoxHasValue("creationMoment", creationMoment);
		super.checkInputBoxHasValue("memorandum", memorandum);
		super.checkInputBoxHasValue("link", link);
		//super.checkInputBoxHasValue("patronageStatus", patronageStatus);
		super.checkInputBoxHasValue("patronageCode", patronageCode);
		super.checkInputBoxHasValue("patronageLegalStuff", patronageLegalStuff);
		super.checkInputBoxHasValue("patronageBudget", patronageBudget);
		super.checkInputBoxHasValue("patronageCreationMoment", patronageCreationMoment);
		super.checkInputBoxHasValue("patronageStartDate", patronageStartDate);
		super.checkInputBoxHasValue("patronageFinishDate", patronageFinishDate);
		super.checkInputBoxHasValue("patronageLink", patronageLink);

		super.signOut();
	}
}
