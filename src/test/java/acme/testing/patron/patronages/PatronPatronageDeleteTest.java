package acme.testing.patron.patronages;

import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class PatronPatronageDeleteTest extends TestHarness {
	
	@Test
	public void positiveTest() {
		super.signIn("patron01", "patron01");
		super.clickOnMenu("Patron", "Patronages list");
		
		super.checkListingExists();
		super.checkNotListingEmpty();
		
		super.clickOnListingRecord(0);
		
		final String deleted = super.getCurrentPath();
		
		super.checkFormExists();
		
		super.clickOnSubmit("Delete");
		
		super.clickOnMenu("Patron", "Patronages list");
		
		super.checkListingExists();
		super.checkNotListingEmpty();
		
		super.clickOnListingRecord(0);
		
		final String notDeleted = super.getCurrentPath();
		
		assert deleted != notDeleted;
		
		super.signOut();
	}
	
}
