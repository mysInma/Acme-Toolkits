package acme.testing.patron.dashboard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class PatronDashboardShowTest extends TestHarness {

	@Test
	@Order(10)
	public void positive() {
		
		super.signIn("patron01", "patron01");
		
		super.clickOnMenu("Patron", "Dashboard");
		super.checkCurrentPath("/patron/patron-dashboard/show");

		super.checkFormExists();

		super.signOut();
	}
	
}
