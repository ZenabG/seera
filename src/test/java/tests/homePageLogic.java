package tests;

import PageMethods.HomePage;
import resources.BaseClass;
import resources.Constants;

public class homePageLogic extends BaseClass{
	HomePage home = new HomePage();
	
	void homePageLogic() {
		//checking if the website is set to engligh language or else change it to english
				home.changeLanguage("english");
				
				home.clickOnFlightsTab();
				home.clickOnRoudTripTab();
				//generating random number between 0 and 5 to chose a random origin
				int indexO = randBetween(0,5);
				home.enterOrigin(indexO);
				
				//generating random number between 0 and 5 to chose a random destination
				int indexD = randBetween(0,5);
				home.enterDestination(indexD);
				
				//generating random date for the departure
				String dateDeparture = randomDateGenerator();
				System.out.println(dateDeparture);
				home.departDate(dateDeparture);
				
				//generating random date for the return
				String dateD = randomDateGenerator();
				home.returnDate(dateD);
				
				//select no of passengers for given type (Note: logic added just for adult, more can be added)
				home.selectPassenger(Constants.noOfPassengers,Constants.typeOfPassenger);
				
				//select cabin class of given type (Note: logic added just for economy, more can be added)
				home.selectCabinClass(Constants.cabinClassType);
				
				home.clickSearchFlights();
	}

}
