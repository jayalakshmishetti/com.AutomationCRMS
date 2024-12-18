package GenericPackage;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import POM.LoginPage;
import POM.LogoutPage;

public class BaseClass {
	public WebDriver driver=null;
	PropertyFile p = new PropertyFile();
	WebDriverUtility w=new WebDriverUtility();
	public static WebDriver sdriver;
	
	@BeforeSuite
	public void beforeSuiteConfig() {
		Reporter.log("Database connection is started", true);
	}	
	
	@BeforeClass
	public void toLaunchBrowser() throws IOException {		
		String BROWSER = p.toReadDataFromPropertyFile("BROWSER");
		if(BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();			
		}
		sdriver=driver;
		Reporter.log("Browser is launched",true);
		w.toMaximize(driver);
		Reporter.log("Browser is maximized",true);
		w.wait_tillpageloads(driver);
	}
	
	@BeforeMethod
	public void navigateToURL() throws IOException {
		String URL = p.toReadDataFromPropertyFile("URL");
		String USERNAME = p.toReadDataFromPropertyFile("USER");
		String PASSWORD = p.toReadDataFromPropertyFile("PASSWORD");
		driver.get(URL);
		
		LoginPage w=new LoginPage(driver);
		w.getUserNameTextField().sendKeys(USERNAME);
		w.getPasswordTextField().sendKeys(PASSWORD);
		w.getLoginButton().click();
		Reporter.log("Browser is navigated to application",true);
	}
	
	@AfterMethod
	public void logoutFromApplication() throws InterruptedException {
		LogoutPage logout=new LogoutPage(driver);		
		WebElement ele = logout.getSelectUser();
		Thread.sleep(2000);
		w.toperformMouseHover(driver, ele);
		Thread.sleep(2000);
		logout.getSignoutLink().click();
		Thread.sleep(2000);
		Reporter.log("Logged out from the application", true);
	}
	
	@AfterClass
	public void toCloseBrowser() {
		driver.quit();
	}
	
	@AfterSuite
	public void afterSuiteConfig() {
		Reporter.log("Database connection flushed out or removed", true);
	}
}
