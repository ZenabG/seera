package resources;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import java.util.logging.Logger;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class BaseClass extends Utilities {

	public static WebDriver driver;
	public static String URL = null;
	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	protected static ExtentTest test;
	public static Logger log;
	
	@BeforeSuite
	public void beforeS() {
		//extent report logic
		htmlReporter = new ExtentHtmlReporter("./test-extent/extent"+System.currentTimeMillis()+".html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@BeforeTest
	@Parameters({ "browserDriver" })
	// passing optional value as chrome
	public void setUpDriver(@Optional("chrome") String browserDriver) {
		log = Logger.getLogger("global");

		// for setting driver to chrome browser
		if (browserDriver.equalsIgnoreCase("chrome")) {
			System.setProperty(Constants.systemKeyChrome, Constants.systemValueChrome);
			ChromeOptions opt = new ChromeOptions();
			opt.addArguments("--disable-notifications");  //disabling notifications
			driver = new ChromeDriver(opt);
		}

		// for setting driver to firefox browser
		else if (browserDriver.equalsIgnoreCase("firefox")) {
			System.setProperty(Constants.systemKeyFirefox, Constants.systemValueFirefox);
			 FirefoxOptions firefoxOptions = new FirefoxOptions(); 
			 firefoxOptions.addPreference("dom.webnotifications.enabled",false); //disabling notifications
			 driver = new FirefoxDriver(firefoxOptions); 
		}
	}

	@BeforeTest
	@Parameters({ "url" })
	// passing optional value as almosafer website
	public void startBrowser(@Optional("https://www.almosafer.com") String url) {
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		URL = url; // taking the used url value to use later in page classes
		
	}


	@BeforeTest
	public void beforeTest(ITestContext ctx) {
		//extent report logic
			
				htmlReporter.config().setReportName("Test Report"+ctx.getCurrentXmlTest().getSuite().getName());
				htmlReporter.config().setDocumentTitle("Test Report");
				htmlReporter.config().setTheme(Theme.STANDARD);
				
	}
	
	@BeforeMethod
	public void before(ITestResult result) {
		test = extent.createTest(result.getMethod().getMethodName());
	}

	@AfterMethod
	public void killDriver(ITestResult result) throws IOException {
		
		if(result.getStatus()==ITestResult.FAILURE) {
				test.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(screenshot()).build());
			} 
		
		if(result.getStatus()==ITestResult.SKIP)
			test.skip(result.getThrowable().getMessage());

		extent.flush();		
	}
	
	@AfterTest
	public void afterTest() {
		
		driver.quit();
	}

	@AfterSuite
	public void killAllDrivers() {
		try {
			Runtime exec = Runtime.getRuntime();
			exec.exec("taskkill /f /im chromedriver.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	//to take screenshot
	public String screenshot() {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String destFile ="./screenshots/shot"+System.currentTimeMillis()+".jpg";
		
		try {
			FileUtils.copyFile(srcFile, new File(destFile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile;
	}

	//to scroll to the very bottom of the webpage
	public void scrollToBottom() {
		try {
			Object lastHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");

			while (true) {
				((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
				Thread.sleep(2000);

				Object newHeight = ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
				if (newHeight.equals(lastHeight)) {
					break;
				}
				lastHeight = newHeight;
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
