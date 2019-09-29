package tests;

import org.testng.annotations.Test;

import PageMethods.FlightListingPage;
import resources.BaseClass;

public class Scenario2 extends BaseClass{
	
	@Test
	public void scenario2() {
		homePageLogic home = new homePageLogic();
		FlightListingPage listing = new FlightListingPage();
		
		home.homePageLogic();
		
		listing.waitForPageToLoad();
		listing.selectCheapestSort();
		listing.comparePrices();
	}

}
