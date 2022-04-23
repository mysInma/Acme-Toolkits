package acme.testing.any.userAccount;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyUserAccountTest extends TestHarness{
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/userAccount/user-account.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void positiveTest(final int recordIndex, final String name, 
		final String surname,final String email , final String username, final String roles) {
		
		
		super.clickOnMenu("Anonymous","Lists Users");
		super.checkListingExists();
		super.sortListing(0, "asc");
		super.sortListing(1, "asc");
		
		super.checkColumnHasValue(recordIndex, 0, username);
		
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("identity.name", name);
		super.checkInputBoxHasValue("identity.surname", surname);
		super.checkInputBoxHasValue("identity.email", email);

		
		

	}

}
