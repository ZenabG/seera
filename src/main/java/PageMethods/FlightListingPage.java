package PageMethods;

import java.util.ArrayList;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Locators.FlightListingPageLocatorsAlm;
import Locators.FlightListingPageLocatorsTaj;
import junit.framework.Assert;
import resources.BaseClass;

public class FlightListingPage extends BaseClass {

	FlightListingPageLocatorsTaj locTaj = new FlightListingPageLocatorsTaj();
	FlightListingPageLocatorsAlm locAlm = new FlightListingPageLocatorsAlm();

	// wait for the flight listing page to load
	public void waitForPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 60); // explicit wait
		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			wait.until(ExpectedConditions.visibilityOf(locAlm.txtFilters));
			log.info("Almosafer | Flight Listing page is loaded");
			test.log(Status.INFO, "Almosafer | Flight Listing page is loaded");
		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			wait.until(ExpectedConditions.visibilityOf(locTaj.txtFilters));
			log.info("Tajawal | Flight Listing page is loaded");
			test.log(Status.INFO, "Tajawal | Flight Listing page is loaded");
		}
	}

	// to select the minimum stop filter from Filters on left side
	public void selectStopFilter() {
		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			String stop = null;
			if (locAlm.txtStops.isDisplayed()) {
				for (int i = 0; i < locAlm.checkBoxes.size(); i++) {
					if (locAlm.checkBoxes.get(i).getAttribute("for").equalsIgnoreCase("stop-0")) {
						locAlm.checkBoxes.get(i).click();
						stop = "Direct";
						log.info("Almosafer | Stop Filter 'Direct' is selected");
						test.log(Status.INFO, "Almosafer | Stop Filter 'Direct' is selected");
						break;
					} else if (locAlm.checkBoxes.get(i).getAttribute("for").equalsIgnoreCase("stop-1")) {
						locAlm.checkBoxes.get(i).click();
						stop = "1 Stop";
						log.info("Almosafer | Stop Filter 1 stop is selected");
						test.log(Status.INFO, "Almosafer | Stop Filter 1 is selected");
						break;
					} else if (locAlm.checkBoxes.get(i).getAttribute("for").equalsIgnoreCase("stop-2")) {
						locAlm.checkBoxes.get(i).click();
						stop = "+2 Stops";
						log.info("Almosafer | Stop Filter +2 stops is selected");
						test.log(Status.INFO, "Almosafer | Stop Filter +2 is selected");
						break;
					}

				}
			}
			
			// to validate that the search results is as per the filter selected
			Assert.assertTrue("Search Results is not as per the selected filter for stops", locAlm.txtValidateStop.getText().equalsIgnoreCase(stop));

		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			String stop = null;
			if (locTaj.txtStops.isDisplayed()) {
				for (int i = 0; i < locTaj.checkBoxes.size(); i++) {
					if (locTaj.checkBoxes.get(i).getAttribute("for").equalsIgnoreCase("stop-0")) {
						locTaj.checkBoxes.get(i).click();
						stop = "Direct";
						log.info("Tajawal | Stop Filter 'Direct' is selected");
						test.log(Status.INFO, "Tajawal | Stop Filter 'Direct' is selected");
						break;
					} else if (locTaj.checkBoxes.get(i).getAttribute("for").equalsIgnoreCase("stop-1")) {
						locTaj.checkBoxes.get(i).click();
						stop = "1 Stop";
						log.info("Tajawal | Stop Filter 1 stop is selected");
						test.log(Status.INFO, "Tajawal | Stop Filter 1 is selected");
						break;
					} else if (locTaj.checkBoxes.get(i).getAttribute("for").equalsIgnoreCase("stop-2")) {
						locTaj.checkBoxes.get(i).click();
						stop = "+2 Stops";
						log.info("Tajawal | Stop Filter +2 stops is selected");
						test.log(Status.INFO, "Tajawal | Stop Filter +2 is selected");
						break;
					}

				}
			}
			System.out.println(locAlm.txtValidateStop.getText());
			Assert.assertTrue("Search Results is not as per the selected filter for stops", locTaj.txtValidateStop.getText().equalsIgnoreCase(stop));
		}
	}

	// to click random select flight button from search results
	public void selectFlight() {
		int index = randBetween(0, locTaj.btnSelectFlight.size() - 1);

		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			locAlm.btnSelectFlight.get(index).click();
			log.info("Almosafer | Select Flight button is clicked");
			test.log(Status.INFO, "Almosafer | Select Flight button is clicked");
		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			if (locTaj.btnSelectFlight.get(index).isDisplayed()) {
				locTaj.btnSelectFlight.get(index).click();
				test.log(Status.INFO, "Tajawal | Select Flight button is clicked");
			}
		}
	}

	// to select cheapest button in sort option
	public void selectCheapestSort() {
		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			locAlm.btnSort.click();
			// locAlm.radioBtnCheapest.click();
			locAlm.btnDone.click();
			log.info("Almosafer | Flight search results are sorted by Cheapest");
			test.log(Status.INFO, "Almosafer | Flight search results are sorted by Cheapest");
		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			locTaj.btnSort.click();
			// locTaj.radioBtnCheapest.click();
			locTaj.btnDone.click();
			log.info("Tajawal | Flight search results are sorted by Cheapest");
			test.log(Status.INFO, "Tajawal | Flight search results are sorted by Cheapest");
		}
	}

	// to get price of first flight in search result and last flight on search
	// result and asserting if they are same(Note : rounding values using Math.ceil
	// for selected flight)
	public void comparePrices() {
		
		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			scrollToBottom(); //scrolling to bottom of the page
	
			//converting list of webelements of prices to double as Collection.sort does not work with webelements
			ArrayList<Double> obtainedList = new ArrayList<Double>();
			for (WebElement we : locAlm.txtPriceFlight) {
				obtainedList.add(Double.parseDouble(we.getText()));
			}

			Collections.sort(obtainedList);
			log.info("Almosafer | Fetched list of prices is sorted is ascending order");
			test.log(Status.INFO, "Almosafer | Fetched list of prices is sorted is ascending order");
			
			String firstFlightPrice = DoubleRoundCeil(obtainedList.get(0).toString());
			String lastFlightPrice = DoubleRoundCeil(obtainedList.get(obtainedList.size() - 1).toString());
			
			String lowPriceFilter = SplitCurrencyValueString(locAlm.textLowPrice.getText());
			String highPriceFilter = SplitCurrencyValueString(locAlm.textHighPrice.getText());
			
			Assert.assertEquals("Lowest price on price filter is not equal to first flight price in sort by cheapest search results", firstFlightPrice, lowPriceFilter);
			Assert.assertEquals("Highest price on price filter is not equal to last flight price in sort by cheapest search results", lastFlightPrice, highPriceFilter);
			
			log.info("Almosafer | Compare prices of lowest and highest in price filter to actual search result is equal");
			test.log(Status.INFO, "Almosafer | Compare prices of lowest and highest in price filter to actual search result is equal");

		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			scrollToBottom(); //scrolling to bottom of the page
			
			//converting list of webelements of prices to double as Collection.sort does not work with webelements
			ArrayList<Double> obtainedList = new ArrayList<Double>();
			for (WebElement we : locTaj.txtPriceFlight) {
				obtainedList.add(Double.parseDouble(we.getText().replaceAll(",", "")));
			}

			Collections.sort(obtainedList);
			log.info("Tajawal | Fetched list of prices is sorted is ascending order");
			test.log(Status.INFO, "Tajawal | Fetched list of prices is sorted is ascending order");
			
			String firstFlightPrice = DoubleRoundCeil(obtainedList.get(0).toString());
			String lastFlightPrice = DoubleRoundCeil(obtainedList.get(obtainedList.size() - 1).toString());
			
			String lowPriceFilter = SplitCurrencyValueString(locTaj.textLowPrice.getText());
			String highPriceFilter = SplitCurrencyValueString(locTaj.textHighPrice.getText());
			
			Assert.assertEquals("Lowest price on price filter is not equal to first flight price in sort by cheapest search results", firstFlightPrice, lowPriceFilter);
			Assert.assertEquals("Highest price on price filter is not equal to last flight price in sort by cheapest search results", lastFlightPrice, highPriceFilter);
			
			log.info("Tajawal | Compare prices of lowest and highest in price filter to actual search result is equal");
			test.log(Status.INFO, "Tajawal | Compare prices of lowest and highest in price filter to actual search result is equal");
		}
	}
}
