package acme.testing.any.chirps;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class AnyListChirpsTest extends TestHarness {
	
	@ParameterizedTest
	@CsvFileSource(resources = "/any/chirp/chirp.csv", encoding = "utf-8", numLinesToSkip = 1)
	@Order(10)
	public void checkAnyListChirpsTest(final int recordIndex, final String title, 
		final String author, final String description, final String email,  final String creationMoment) {

		super.clickOnMenu("Anonymous", "List Chirps");
		super.checkListingExists();
		super.sortListing(4, "asc"); 
		
		
		super.checkColumnHasValue(recordIndex, 0, title);
		super.checkColumnHasValue(recordIndex, 1, author);
		super.checkColumnHasValue(recordIndex, 2, description);
		super.checkColumnHasValue(recordIndex, 3, email);
		super.checkColumnHasValue(recordIndex, 4, creationMoment);
		
	
		
	}
	
	

}
