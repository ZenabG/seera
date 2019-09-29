package PageMethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import Locators.FlightDetailsPageLocatorsAlm;
import Locators.FlightDetailsPageLocatorsTaj;
import resources.BaseClass;

public class FlightDetailsPage extends BaseClass {

	FlightDetailsPageLocatorsTaj locTaj = new FlightDetailsPageLocatorsTaj();
	FlightDetailsPageLocatorsAlm locAlm = new FlightDetailsPageLocatorsAlm();

	// using explicit wait for the flight details page to load
	public void waitForPageToLoad() {
		WebDriverWait wait = new WebDriverWait(driver, 60);// explicit wait
		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			wait.until(ExpectedConditions.visibilityOf(locAlm.txtEnterDetails));
			log.info("Almosafer | Flight Details page is loaded");
			test.log(Status.INFO, "Almosafer | Flight Details page is loaded");
		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			wait.until(ExpectedConditions.visibilityOf(locTaj.txtEnterDetails));
			test.log(Status.INFO, "Tajawal | Flight Details page is loaded");
		}
	}

	// to fill contact details at the bottom of the page and click on continue to
	// final details button
	public void fillContactDetails(String title, String firstName, String lastName, String email, String phoneNumber) {
		//adding Thread wait as even after implicit and explicit waits couldn't load flight details page
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		JavascriptExecutor js = (JavascriptExecutor) driver;

		if (URL.equalsIgnoreCase("https://www.almosafer.com")) {
			js.executeScript("arguments[0].scrollIntoView();", locAlm.btnTitleContact);

			locAlm.btnTitleContact.sendKeys(Keys.ENTER);
			locAlm.drpDownTitleContact.click();
			locAlm.textBoxFirstName.sendKeys(firstName);
			locAlm.textBoxLastName.sendKeys(lastName);
			locAlm.textBoxEmail.sendKeys(email);
			locAlm.btnCountryCodeSelector.click();

			// Select select = new Select(locAlm.drpDownCountryCodeSelector);
			// select.selectByIndex(0);

			locAlm.textBoxPhoneNumber.sendKeys(phoneNumber);
			log.info("Almosafer | Added contact details");
			test.log(Status.INFO, "Almosafer | Added contact details");
			
			locAlm.btnContinueToFinalDetails.click();
			log.info("Almosafer | Clicked on Continue To Final Details Button");
			test.log(Status.INFO, "Almosafer | Clicked on Continue To Final Details Button");

			Assert.assertTrue(locAlm.txtEnterFirstNameError.isDisplayed(), "Error Message for filling Travellers form not displayed");

			log.info("Almosafer | Assertion successful, Test passed");
			test.log(Status.INFO, "Almosafer | Assertion successful, Test passed");
			
		} else if (URL.equalsIgnoreCase("https://www.tajawal.com")) {
			js.executeScript("arguments[0].scrollIntoView();", locTaj.btnTitleContact);

			locTaj.btnTitleContact.sendKeys(Keys.ENTER);
			locTaj.drpDownTitleContact.click();
			locTaj.textBoxFirstName.sendKeys(firstName);
			locTaj.textBoxLastName.sendKeys(lastName);
			locTaj.textBoxEmail.sendKeys(email);
			locTaj.btnCountryCodeSelector.click();

			// Select select = new Select(locAlm.drpDownCountryCodeSelector);
			// select.selectByIndex(0);

			locTaj.textBoxPhoneNumber.sendKeys(phoneNumber);
			log.info("Tajawal | Added contact details");
			test.log(Status.INFO, "Tajawal | Added contact details");
			
			locTaj.btnContinueToFinalDetails.click();
			log.info("Tajawal | Clicked on Continue To Final Details Button");
			test.log(Status.INFO, "Tajawal | Clicked on Continue To Final Details Button");

			Assert.assertTrue(locTaj.txtEnterFirstNameError.isDisplayed(), "Error Message for filling Travellers form not displayed");
			
			log.info("Tajawal | Assertion successful, Test passed");
			test.log(Status.INFO, "Almosafer | Assertion successful, Test passed");
		}
	}
}