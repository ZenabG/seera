package tests;

import org.testng.annotations.Test;

import PageMethods.FlightDetailsPage;
import PageMethods.FlightListingPage;
import resources.BaseClass;
import resources.Constants;

public class Scenario1 extends BaseClass{
	
	@Test
	public void scenario1() {
		homePageLogic home = new homePageLogic();
		FlightListingPage listing = new FlightListingPage();
		FlightDetailsPage details = new FlightDetailsPage();

		home.homePageLogic();
		
		listing.waitForPageToLoad();
		listing.selectStopFilter();
		listing.selectFlight();
		
		details.waitForPageToLoad();
		details.fillContactDetails(Constants.title, Constants.firstName, Constants.lastName, Constants.email, Constants.phoneNumber);

	}

}
