package acme.testing.inventor.toolkits;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class InventorToolkitTest  extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/toolkit/toolkit.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String code, final String title, 
		final String description, final String notes, final String link, final String totalPrice, final String published) { 
		
		super.signIn("inventor01", "inventor01");
		
		super.clickOnMenu("Inventor","Toolkit list");
		super.checkListingExists();
		super.sortListing(0, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, code);
		super.checkColumnHasValue(recordIndex, 1, title);
		super.checkColumnHasValue(recordIndex, 2, description);
		super.checkColumnHasValue(recordIndex, 3, published);
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("notes", notes);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("totalPrice", totalPrice);
		super.checkInputBoxHasValue("published", published);
    
		
		super.clickOnButton("Tool");
		super.checkListingExists();
		super.clickOnButton("Return");
		super.clickOnButton("Component");
		super.checkListingExists();
		

	}

}
