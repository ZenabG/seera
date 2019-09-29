package PageMethods;

import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import Locators.*;
import resources.BaseClass;

public class HomePage extends BaseClass {

	HomePageLocatorsAlm locAlm = new HomePageLocatorsAlm();
	HomePageLocatorsTaj locTaj = new HomePageLocatorsTaj();
	String DateFrom = null;

	// change language to english of website if it is arabic
	public void changeLanguage(String language) {

		if (language.equalsIgnoreCase("english")) {
			if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
				if (locAlm.drpDownLangSelector.getAttribute("innerText").equalsIgnoreCase("Change language")) {
					System.out.println(locAlm.drpDownLangSelector.isEnabled());
					locAlm.drpDownLangSelector.click();
					locAlm.langSelectorEng.click();
					log.info("Almosafer | Language of the website changed to English");

					test.log(Status.INFO, "Almosafer | Language of the website changed to English");
				}
			} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
				if (locTaj.langSelector.getText().equalsIgnoreCase("English")) {
					locTaj.langSelector.click();
					log.info("Tajawal | Language of the website changed to English");
					test.log(Status.INFO, "Tajawal | Language of the website changed to English");
				}
			}
		}
	}

	// click on flights tab
	public void clickOnFlightsTab() {
		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			locAlm.tabFlight.click();
			log.info("Almosafer | Clicked on flights tab");
			test.log(Status.INFO, "Almosafer | Clicked on flights tab");
		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			locTaj.tabFlight.click();
			log.info("Tajawal | Clicked on flights tab");
			test.log(Status.INFO, "Tajawal | Clicked on flights tab");
		}
	}

	// click on round trip tab
	public void clickOnRoudTripTab() {
		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			locAlm.tabRoundTrip.click();
			log.info("Almosafer | Clicked on Round Trip tab");

			test.log(Status.INFO, "Almosafer | Clicked on Round Trip tab");

		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			locTaj.tabRoundTrip.click();
			log.info("Tajawal | Clicked on Round Trip tab");

			test.log(Status.INFO, "Tajawal | Clicked on Round Trip tab");
		}
	}

	// enter origin in the origin drop down
	public void enterOrigin(int index) {
		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			locAlm.txtOrigin.click();
			locAlm.drpDownOrigin_Destination.get(index).click();
			log.info("Almosafer | Origin of flight booking selected");
			
			test.log(Status.INFO, "Almosafer | Origin of flight booking selected");
			
		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			locTaj.txtOrigin.click();
			locTaj.drpDownOrigin_Destination.get(index).click();
			log.info("Tajawal | Origin of flight booking selected");
			
			test.log(Status.INFO, "Tajawal | Origin of flight booking selected");
		}
	}

	// enter destination in the destination drop down
	public void enterDestination(int index) {
		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			locAlm.txtDestination.click();
			locAlm.drpDownOrigin_Destination.get(index).click();
			log.info("Almosafer | Destination of flight booking selected");
			
			test.log(Status.INFO, "Almosafer | Destination of flight booking selected");
			
		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			locTaj.txtDestination.click();
			locTaj.drpDownOrigin_Destination.get(index).click();
			log.info("Tajawal | Destination of flight booking selected");
			
			test.log(Status.INFO, "Tajawal | Destination of flight booking selected");
			
		}
	}

	// enter departure date
	public void departDate(String date) {
		// putting date value in a static variable to use in 'return' date method
		DateFrom = date;

		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			locAlm.tabFromDate.click();
			selectDate(date);
			log.info("Almosafer | Departure date of flight booking selected");
			
			test.log(Status.INFO, "Almosafer | Departure date of flight booking selected");
			
		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			locTaj.tabFromDate.click();
			selectDate(date);
			log.info("Tajawal | Departure date of flight booking selected");
			
			test.log(Status.INFO, "Tajawal | Departure date of flight booking selected");
		}
	}

	// enter return date
	public void returnDate(String date) {
		// comparing that the 'return' date is after 'departure' date if not then
		// generating a new date
		while (date.compareTo(DateFrom) < 0) {
			date = randomDateGenerator();
		}
		System.out.println(date);

		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			locAlm.tabToDate.click();
			selectDate(date);
			log.info("Almosafer | Return date of flight booking selected");
			
			test.log(Status.INFO, "Almosafer | Return date of flight booking selected");
			
		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			locTaj.tabToDate.click();
			selectDate(date);
			log.info("Tajawal | Return date of flight booking selected");
			
			test.log(Status.INFO, "Tajawal | Return date of flight booking selected");
		}
	}

	// select number of specified passengers for specified passenger type(Note:
	// checking just for adult passenger type, more options can be added)
	public void selectPassenger(int noOfPassengers, String typeOfPassenger) {

		if (typeOfPassenger.equalsIgnoreCase("adult")) {
			if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
				locAlm.tabPassenger.click();
				if (locAlm.tabAdultPassenger.isDisplayed())
					if (Integer.parseInt(locAlm.tabAdultPassengerCount.getText()) < noOfPassengers) {
						int loopCounter = noOfPassengers - Integer.parseInt(locAlm.tabAdultPassengerCount.getText());
						for (int i = 0; i < loopCounter; i++)
							locAlm.tabAdultPassengerPlus.click();
					}
				log.info("Almosafer | " + noOfPassengers + " passengers for " + typeOfPassenger + " category selected");
				
				test.log(Status.INFO, "Almosafer | " + noOfPassengers + " passengers for " + typeOfPassenger + " category selected");
				
			} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
				locTaj.tabPassenger.click();
				if (locTaj.tabAdultPassenger.isDisplayed())
					if (Integer.parseInt(locTaj.tabAdultPassengerCount.getText()) < noOfPassengers) {
						int loopCounter = noOfPassengers - Integer.parseInt(locTaj.tabAdultPassengerCount.getText());
						for (int i = 0; i < loopCounter; i++)
							locTaj.tabAdultPassengerPlus.click();
					}
				log.info("Tajawal | " + noOfPassengers + " passengers for " + typeOfPassenger + " category selected");
				
				test.log(Status.INFO, "Tajawal | " + noOfPassengers + " passengers for " + typeOfPassenger + " category selected");
			}
		}
	}

	// select specified cabin class option(Note: checking just for economy clas
	// type, more options can be added)
	public void selectCabinClass(String classType) {
		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			locAlm.tabCabinClass.click();
			if (locAlm.drpDownCabinClass.isDisplayed())
				if (classType.equalsIgnoreCase("economy"))
					locAlm.economyOption.click();
			log.info("Almosafer | " + classType + " class selected");
			
			test.log(Status.INFO, "Almosafer | " + classType + " class selected");
			
		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			locTaj.tabCabinClass.click();
			if (locTaj.drpDownCabinClass.isDisplayed())
				if (classType.equalsIgnoreCase("economy"))
					locTaj.economyOption.click();
			log.info("Tajawal | " + classType + " class selected");
			
			test.log(Status.INFO, "Tajawal | " + classType + " class selected");
		}
	}

	// click on search flights button
	public void clickSearchFlights() {
		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			locAlm.btnSearchFlights.click();
			log.info("Almosafer | Select flight button on home page is selected");
			
			test.log(Status.INFO, "Almosafer | Select flight button on home page is selected");
			
		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			locTaj.btnSearchFlights.click();
			log.info("Tajawal | Select flight button on home page is selected");
			
			test.log(Status.INFO, "Tajawal | Select flight button on home page is selected");
		}
	}

	// splitting the date to select 'year', 'month' and 'day' on calendar on home
	// page
	private void selectDate(String date) {

		String year = date.split("-")[0];
		String month = date.split("-")[1].replaceFirst("^0+(?!$)", ""); // the date generated has a leading 0 in month
																		// so this will remove it
		String day = date.split("-")[2];

		// year click logic
		locTaj.calendarYearDropDown.click();
		Select selectY = new Select(locTaj.calendarYearDropDown);
		selectY.selectByValue(year);

		// month click logic
		locTaj.calendarMonthDropDown.click();
		Select selectM = new Select(locTaj.calendarMonthDropDown);
		selectM.selectByIndex(Integer.parseInt(month) - 1); // the generated date has month in range 1 to 12 so
															// subtracting by 1 to match the website's months

		// Day Logic
		for (int i = 0; i < locTaj.calendarDay.size(); i++) {
			if (locTaj.calendarDay.get(i).getText().equalsIgnoreCase(day)) {
				locTaj.calendarDay.get(i).click();
			}

		}

	}
}
