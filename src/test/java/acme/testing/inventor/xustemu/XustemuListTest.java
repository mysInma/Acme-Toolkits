package acme.testing.inventor.xustemu;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class XustemuListTest extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/xustemu/xustemuListComponent.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTestComponents(final int recordIndex, final String code, final String creationMoment, final String Subject) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Xustemu list");

		super.checkListingExists();
		super.checkNotListingEmpty();
	
		super.sortListing(2, "asc");

		
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, creationMoment);
		super.checkColumnHasValue(recordIndex, 2, Subject);

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("creationMoment", creationMoment);
		super.checkInputBoxHasValue("subject", Subject);

	}
	

}