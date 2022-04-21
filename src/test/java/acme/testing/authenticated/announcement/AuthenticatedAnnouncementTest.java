package acme.testing.authenticated.announcement;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AuthenticatedAnnouncementTest extends TestHarness{

	@ParameterizedTest
	@CsvFileSource(resources = "/authenticated/announcement/announcement-list.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void announcementTest(final int recordIndex, final String creationMoment, final String title, 
		final String description, final String critical, final String link) {

		super.signIn("patron01", "patron01");
		super.navigateHome();
		
		super.clickOnMenu("Authenticated", "List announcements");
		super.checkListingExists();
		
		
		super.checkColumnHasValue(recordIndex, 0, creationMoment);
		super.checkColumnHasValue(recordIndex, 1, critical);
		super.checkColumnHasValue(recordIndex, 2, title);
		
		
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkInputBoxHasValue("title", title);
		super.checkInputBoxHasValue("description", description);
		super.checkInputBoxHasValue("link", link);
		super.checkInputBoxHasValue("critical", critical);
		
		
		super.signOut();
	}

}
