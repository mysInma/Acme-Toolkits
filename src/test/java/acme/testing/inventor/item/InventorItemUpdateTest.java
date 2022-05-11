
package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorItemUpdateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/updateComponent.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveComponentTest(final int recordIndex, final String name, final String code, final String technology, final String description, final String price, final String link, final String type, final String published) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Component list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(1, "asc");

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkSubmitExists("Update");

		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("price", price);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("type", type);
		super.fillInputBoxIn("published", published);

		super.clickOnSubmit("Update");

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
		super.checkInputBoxHasValue("link", link);

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/negativeUpdateComponent.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeComponentTest(final int recordIndex, final String name, final String code, final String technology, final String description, final String price, final String link) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Component list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(1, "asc");

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkSubmitExists("Update");

		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("price", price);
		super.fillInputBoxIn("link", link);

		super.clickOnSubmit("Update");

		super.checkErrorsExist();

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/updateTool.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveToolTest(final int recordIndex, final String name, final String code, final String technology, final String description, final String price, final String link, final String type, final String published) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Tool list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(1, "asc");

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkSubmitExists("Update");

		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("price", price);
		super.fillInputBoxIn("link", link);
		super.fillInputBoxIn("type", type);
		super.fillInputBoxIn("published", published);

		super.clickOnSubmit("Update");
		super.clickOnMenu("Inventor", "Tool list");
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
		super.checkInputBoxHasValue("link", link);

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/negativeUpdateTool.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeToolTest(final int recordIndex, final String name, final String code, final String technology, final String description, final String price, final String link) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Tool list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(1, "asc");

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkSubmitExists("Update");

		super.fillInputBoxIn("name", name);
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("technology", technology);
		super.fillInputBoxIn("description", description);
		super.fillInputBoxIn("price", price);
		super.fillInputBoxIn("link", link);

		super.clickOnSubmit("Update");

		super.checkErrorsExist();

		super.signOut();
	}

}
