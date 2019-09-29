package Locators;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.BaseClass;

public class FlightDetailsPageLocatorsTaj extends BaseClass {

	@FindBy(css = "div[class='card-title h5']")
	public WebElement txtEnterDetails;

	@FindBy(css = "input[data-testid=FlightPAX__ContactDetails__EmailInput]")
	public WebElement textBoxEmail;

	@FindBy(css = "select[name='contact.title']")
	public WebElement btnTitleContact;

	@FindBy(xpath = "//li[text()='Ms.']")
	public WebElement drpDownTitleContact;

	@FindBy(name = "contact.firstName")
	public WebElement textBoxFirstName;

	@FindBy(name = "contact.lastName")
	public WebElement textBoxLastName;

	@FindBy(css = "div[data-testid=FlightPAX__ContactDetails__MobileNumberCountryCodeSelector]")
	public WebElement btnCountryCodeSelector;

	@FindBy(css = "div[class='css-kj6f9i-menu react-select_menu']")
	public WebElement drpDownCountryCodeSelector;

	@FindBy(name = "contact.phoneNumber")
	public WebElement textBoxPhoneNumber;

	@FindBy(css="button[data-testid=FlightPAX__ContinueToPaymentButton]")
	public WebElement btnContinueToFinalDetails;
	
	@FindBy(css = "div[data-testid='FlightPAX__Adult1__FirstNameErrorLabel']")
	public WebElement txtEnterFirstNameError;
	
	@FindBy(css = "div[data-testid='FlightPAX__Adult1__LastNameErrorLabel']")
	public WebElement txtEnterLastNameError;

	public FlightDetailsPageLocatorsTaj() {
		PageFactory.initElements(driver, this);
	}

}
