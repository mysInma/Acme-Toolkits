package acme.testing.administrator.dashboard;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import acme.testing.TestHarness;

public class AdministratorDashboardShowTest extends TestHarness {
	
	@Test
	@Order(10)
	public void positive() {
		
		super.signIn("administrator", "administrator");
		
		super.clickOnMenu("Administrator", "Dashboard");
		super.checkCurrentPath("/administrator/administrator-dashboard/show");

		super.checkFormExists();

		super.signOut();
	}

}
