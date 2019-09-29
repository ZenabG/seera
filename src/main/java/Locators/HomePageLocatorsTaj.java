package Locators;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.BaseClass;

public class HomePageLocatorsTaj extends BaseClass{
	
	@FindBy(css="a[data-testid='Header__LanguageSwitch']")
	public WebElement langSelector;
	
	@FindBy(css="a[data-testid='Header__FlightsNavigationTab']")
	public WebElement tabFlight;
	
	@FindBy(css="div[data-testid='FlightSearchBox__RoundTripButton']")
	public WebElement tabRoundTrip;
	
	@FindBy(css="input[data-testid=FlightSearchBox__FromAirportInput]")
	public WebElement txtOrigin;
	
	@FindBy(xpath="//li[contains(@data-testid,'FlightSearchBox__AirportOption')]")
	public List<WebElement> drpDownOrigin_Destination;
	
	@FindBy(css="input[data-testid=FlightSearchBox__ToAirportInput]")
	public WebElement txtDestination;
	
	@FindBy(css="div[data-testid=FlightSearchBox__FromDateButton]")
	public WebElement tabFromDate;
	
	@FindBy(css="select[data-testid='FlightSearchCalendar__YearDropdown']")
	public WebElement calendarYearDropDown;
	
	@FindBy(css="select[data-testid='FlightSearchCalendar__MonthDropdown']")
	public WebElement calendarMonthDropDown;
	
	@FindBy(css="div[class='DayPicker-Day']")
	public List<WebElement> calendarDay;
	
	@FindBy(css="div[data-testid=FlightSearchBox__ToDateButton]")
	public WebElement tabToDate;
	
	@FindBy(css="div[data-testid=FlightSearchBox__PaxDropdown]")
	public WebElement tabPassenger;
	
	@FindBy(css="div[class='sc-1o8lb20-3 iUIjii']")
	public WebElement tabAdultPassenger;
	
	@FindBy(css="div[data-testid=FlightSearchPAXSelection__AdultsCountLabel]")
	public WebElement tabAdultPassengerCount;
	
	@FindBy(css="div[data-testid=FlightSearchPAXSelection__AdultsPlusButton]")
	public WebElement tabAdultPassengerPlus;
	
	@FindBy(css="div[data-testid=FlightSearchBox__CabinTypeDropdown]")
	public WebElement tabCabinClass;
	
	@FindBy(css="div[class='sc-1sn5k4t-3 moszs']")
	public WebElement drpDownCabinClass;
	
	@FindBy(css="div[data-testid=FlightSearchCabinSelection__EconomyOption]")
	public WebElement economyOption;
	
	@FindBy(css="button[data-testid=FlightSearchBox__SearchButton]")
	public WebElement btnSearchFlights;
	
	public HomePageLocatorsTaj() {
		PageFactory.initElements(driver, this);
	}
}
