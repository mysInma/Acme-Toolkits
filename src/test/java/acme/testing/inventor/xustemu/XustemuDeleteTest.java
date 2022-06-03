
package acme.testing.inventor.xustemu;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class XustemuDeleteTest extends TestHarness {

		@ParameterizedTest
		@CsvFileSource(resources = "/inventor/xustemu/xustemuListComponent.csv", encoding = "utf-8", numLinesToSkip = 1)
		@Order(10)
		public void positiveComponentTest(final int recordIndex, final String code, final String creationMoment, final String Title) {
	
			super.signIn("inventor01", "inventor01");
			super.clickOnMenu("Inventor", "Xustemu list");
	
			super.checkListingExists();
			super.checkNotListingEmpty();
	
			super.sortListing(2, "asc");
	
			super.checkColumnHasValue(recordIndex, 0, code);
			super.checkColumnHasValue(recordIndex, 1, creationMoment);
			super.checkColumnHasValue(recordIndex, 2, Title);
			super.clickOnListingRecord(recordIndex);
			super.checkFormExists();
	
			super.clickOnSubmit("Delete");
	
			super.checkNotErrorsExist();
	
			super.signOut();
	
		}

		@ParameterizedTest
		@CsvFileSource(resources = "/inventor/xustemu/negativeDeleteComponent.csv", encoding = "utf-8", numLinesToSkip = 1)

		@Order(10)
		public void negativeComponentTest(final int recordIndex, final String code, final String creationMoment, final String subject) {
			super.signIn("inventor01", "inventor01");
			super.clickOnMenu("Inventor", "Xustemu list");

			super.checkListingExists();
			super.checkNotListingEmpty();

			super.sortListing(1, "desc");

			super.checkColumnHasValue(recordIndex, 2, subject);
			super.clickOnListingRecord(recordIndex);
			super.checkFormExists();

			super.checkNotButtonExists("Delete");

			super.checkNotErrorsExist();

			super.signOut();

		}



}
