package acme.testing.inventor.toolkits;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitCreateTest extends TestHarness{
	

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/createToolkit.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveToolkitTest(final int recordIndex, final String code, final String title, 
		final String description, final String notes, final String link) {
		

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Toolkit list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.clickOnButton("Create");

		
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("notes", notes);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("published", "false");

		super.clickOnSubmit("Create");

		super.clickOnMenu("Inventor", "Toolkit list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(0, "asc");

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();


		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/negativeCreateToolkit.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeToolkitTest(final int recordIndex, final String code, final String title, 
		final String description, final String notes, final String link) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Toolkit list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.clickOnButton("Create");

		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("title", title);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("notes", notes);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("published", "false");


		super.clickOnSubmit("Create");
		super.checkErrorsExist();

		super.signOut();
	}

	

	

}
