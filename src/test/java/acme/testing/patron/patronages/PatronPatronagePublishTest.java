package acme.testing.patron.patronages;

import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class PatronPatronagePublishTest extends TestHarness {
	
	@Test
	public void positivePublishTest() {
		super.signIn("patron01", "patron01");
		super.clickOnMenu("Patron", "Patronages list");
		
		super.checkListingExists();
		super.checkNotListingEmpty();
		
		super.clickOnListingRecord(0);
		
		super.checkFormExists();
		
		super.clickOnSubmit("Publish");
		
		super.clickOnMenu("Patron", "Patronages list");
		
		super.checkListingExists();
		super.checkNotListingEmpty();
		
		super.clickOnListingRecord(0);
		
		super.checkNotButtonExists("Publish");
		
		super.signOut();
	}
	
}
