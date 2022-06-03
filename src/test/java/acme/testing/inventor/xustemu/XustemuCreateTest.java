
package acme.testing.inventor.xustemu;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class XustemuCreateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/xustemu/createPositiveComponent.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveComponentTest(final int recordIndex, final String code, final String subject, final String summary, final String startDate, final String finishDate, final String creationMoment, final String amount) {
		super.signIn("inventor01", "inventor01");

		super.clickOnMenu("Inventor", "Xustemu list");
		super.checkListingExists();

		super.clickOnButton("Create");
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("subject", subject);
		super.fillInputBoxIn("summary", summary);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("creationMoment", creationMoment);
		super.fillInputBoxIn("amount", amount);

		super.clickOnSubmit("Create");

		super.clickOnMenu("Inventor", "Xustemu list");
		super.checkListingExists();
		super.sortListing(2, "asc");
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 2, subject);
		super.clickOnListingRecord(recordIndex);

		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("subject", subject);
		super.checkInputBoxHasValue("summary", summary);
		super.checkInputBoxHasValue("startDate", startDate);
		super.checkInputBoxHasValue("finishDate", finishDate);
		super.fillInputBoxIn("creationMoment", creationMoment);
		super.checkInputBoxHasValue("amount", amount);

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/xustemu/CreateNegativeComponent.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(20)
	public void negativeComponentTest(final int recordIndex, final String code, final String subject, final String summary, final String startDate, final String finishDate, final String amount, final String creationMoment) {

		super.signIn("inventor01", "inventor01");

		super.clickOnMenu("Inventor", "Xustemu list");
		super.clickOnButton("Create");
		super.checkFormExists();

		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("subject", subject);
		super.fillInputBoxIn("summary", summary);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("amount", amount);
		super.fillInputBoxIn("creationMoment", creationMoment);
		super.clickOnSubmit("Create");

		super.checkErrorsExist();

		super.signOut();
	}

	@Test
	@Order(30)
	public void hackingTest() {
		super.checkNotLinkExists("Account");
		super.navigate("/inventor/xustemu/create");
		super.checkPanicExists();

		super.signIn("administrator", "administrator");
		super.navigate("/inventor/xustemu/create");
		super.checkPanicExists();
		super.signOut();

		super.signIn("patron01", "patron01");
		super.navigate("/inventor/xustemu/create");
		super.checkPanicExists();
		super.signOut();
	}

}
