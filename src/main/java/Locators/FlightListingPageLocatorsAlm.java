package Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.BaseClass;

public class FlightListingPageLocatorsAlm extends BaseClass {

	@FindBy(css = "div[class='sc-dHmInP kjFPYO']")
	public WebElement txtFilters;

	@FindBy(xpath = "//span[text()='Stops']")
	public WebElement txtStops;

	@FindBy(css = "label[type=checkbox]")
	public List<WebElement> checkBoxes;
	
	@FindBy(xpath = "//span[contains(@data-testid,'StopsLabel')]")
	public WebElement txtValidateStop;

	@FindBy(xpath = "//button[contains(@data-testid,'__SelectFlightButton')]")
	public List<WebElement> btnSelectFlight;

	@FindBy(xpath = "//div[contains(@data-testid,'__PriceLabel')]")
	public List<WebElement> txtPriceFlight;
	
	@FindBy(css="div[class='poj0qx-3 kDBAgW']")
	public WebElement txtBottomPage;
	
	@FindBy(xpath = "//button[text()='done']")
	public WebElement btnDone;

	@FindBy(id = "sortBy-price:asc")
	public WebElement radioBtnCheapest;

	@FindBy(xpath = "//span[text()='Cheapest']")
	public WebElement btnSort;
	
	@FindBy(css = "#root > div.sc-bMVAic.giXnex.sc-fjdhpX.ehqOdj.container > div.sc-dTLGrV.hHKjin.sc-dqBHgY.fJPQKI.row > div.sc-fHSTwm.fyvIxW.sc-VigVT.fIhGog.col-3 > div > div:nth-child(2) > div.sc-dRFtgE.juUoGn > div.sc-hUfwpO.eZbUfW > span:nth-child(1)")
	public WebElement textLowPrice;
	
	@FindBy(css = "#root > div.sc-bMVAic.giXnex.sc-fjdhpX.ehqOdj.container > div.sc-dTLGrV.hHKjin.sc-dqBHgY.fJPQKI.row > div.sc-fHSTwm.fyvIxW.sc-VigVT.fIhGog.col-3 > div > div:nth-child(2) > div.sc-dRFtgE.juUoGn > div.sc-hUfwpO.eZbUfW > span:nth-child(2)")
	public WebElement textHighPrice;


	public FlightListingPageLocatorsAlm() {
		PageFactory.initElements(driver, this);
	}

}
