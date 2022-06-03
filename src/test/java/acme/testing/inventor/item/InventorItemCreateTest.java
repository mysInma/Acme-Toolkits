
package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemCreateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/createComponent.csv", encoding = "utf-8", numLinesToSkip = 1)
	//@CsvFileSource(resources = "/inventor/item/createTool.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveComponentTest(final int recordIndex, final String name, final String code, final String technology, final String description, final String price, final String link, final String type, final String typeC) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Component list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.clickOnButton("Create");

		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("price", price);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("type", type);

		super.clickOnSubmit("Create");

		super.clickOnMenu("Inventor", "Component list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(0, "asc");

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();

		super.checkInputBoxHasValue("name", name);
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("technology", technology);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("price", price);

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/negativeCreateComponent.csv", encoding = "utf-8", numLinesToSkip = 1)
	//@CsvFileSource(resources = "/inventor/item/negativeCreateTool.csv", encoding = "utf-8", numLinesToSkip = 1)

	@Order(10)
	public void negativeComponentTest(final int recordIndex, final String name, final String code, final String technology, final String description, final String price, final String link, final String type) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Component list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.clickOnButton("Create");

		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("price", price);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("type", type);

		super.clickOnSubmit("Create");
		super.checkErrorsExist();

		super.signOut();
	}



}
