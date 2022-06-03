/*
 * EmployerJobUpdateTest.java
 *
 * Copyright (C) 2012-2022 Rafael Corchuelo.
 *
 * In keeping with the traditional purpose of furthering education and research, it is
 * the policy of the copyright owner to permit non-commercial use and redistribution of
 * this software. It has been tested carefully, but it is not guaranteed for any particular
 * purposes. The copyright owner does not offer any warranties or representations, nor do
 * they accept any liabilities with respect to them.
 */

package acme.testing.inventor.xustemu;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import acme.testing.TestHarness;

public class XustemuUpdateTest extends TestHarness {

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/xustemu/updatePositiveComponent.csv", encoding = "utf-8", numLinesToSkip = 1)

	@Order(10)
	public void positiveComponentTest(final int recordIndex, final String code,final String creationMoment, final String subject, final String summary,final String startDate, final String finishDate,final String moreInfo) {

		super.signIn("inventor01", "inventor01");
		super.clickOnMenu("Inventor", "Xustemu list");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(2, "asc");

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkSubmitExists("Update");

		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("subject", subject);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("moreInfo", moreInfo);

		super.clickOnSubmit("Update");

		super.checkListingExists();
		super.checkNotListingEmpty();

		super.sortListing(2, "asc");

		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();

		super.checkInputBoxHasValue("code", code);
		super.checkInputBoxHasValue("creationMoment", creationMoment);
		super.checkInputBoxHasValue("subject", subject);

		super.signOut();
	}

	@ParameterizedTest
	@CsvFileSource(resources = "/inventor/xustemu/updateNegativeComponent.csv", encoding = "utf-8", numLinesToSkip = 1)

	@Order(20)
	public void negativeComponentTest(final int recordIndex, final String code, final String subject, final String summary, final String startDate, final String finishDate, final String moreInfo) {
		super.signIn("inventor01", "inventor01");

		super.clickOnMenu("Inventor", "Xustemu list");
		super.checkListingExists();
		super.checkNotListingEmpty();
		super.sortListing(2, "asc");
		super.checkColumnHasValue(recordIndex, 2, subject);
		super.clickOnListingRecord(recordIndex);
		super.checkFormExists();
		super.checkSubmitExists("Update");
		super.fillInputBoxIn("code", code);
		super.fillInputBoxIn("subject", subject);
		super.fillInputBoxIn("summary", summary);
		super.fillInputBoxIn("startDate", startDate);
		super.fillInputBoxIn("finishDate", finishDate);
		super.fillInputBoxIn("moreInfo", moreInfo);
		super.clickOnSubmit("Update");

		super.checkErrorsExist();

		super.signOut();
	}
	

	
}
