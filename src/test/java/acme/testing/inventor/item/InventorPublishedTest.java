
package acme.testing.inventor.item;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorPublishedTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/publishedComponent.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveComponentTest(final int recordIndex, final String name, final String code, final String technology, final String description, final String price, final String link, final String type, final String published) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Component list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(2, "asc");

		super.checkColumnHasValue(recordIndex, 1, published);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();

		super.clickOnSubmit("Publish");

		super.checkNotErrorsExist();

		super.signOut();

	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/negativePublishedComponent.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeComponentTest(final int recordIndex, final String name, final String code, final String technology, final String description, final String price, final String link, final String type, final String published) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Component list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(2, "desc");

		super.checkColumnHasValue(recordIndex, 1, published);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkNotButtonExists("Publish");

		super.signOut();

	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/publishedTool.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveToolTest(final int recordIndex, final String name, final String code, final String technology, final String description, final String price, final String link, final String type, final String published) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Tool list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(1, "asc");

		super.checkColumnHasValue(recordIndex, 1, published);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();

		super.clickOnSubmit("Publish");

		super.checkNotErrorsExist();

		super.signOut();

	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/item/negativePublishedTool.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void negativeToolTest(final int recordIndex, final String name, final String code, final String technology, final String description, final String price, final String link, final String type, final String published) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Tool list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(2, "desc");

		super.checkColumnHasValue(recordIndex, 1, published);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkNotButtonExists("Publish");

		super.signOut();

	}
}
