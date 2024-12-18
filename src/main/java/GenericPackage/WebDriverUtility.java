package GenericPackage;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import POM.ContactsPage;

public class WebDriverUtility {
	ContactsPage c;
	/**
	 * This class contains methods of webdriver
	 */
	/**
	 * This method is used for maximizing
	 * 
	 * @param driver
	 */
	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}

	/**
	 * This method is used for minimizing
	 * 
	 * @param driver
	 */
	public void toMinimize(WebDriver driver) {
		driver.manage().window().minimize();
	}

	/**
	 * This method is used for performing fullscreen
	 * 
	 * @param driver
	 */
	public void tofullScreen(WebDriver driver) {
		driver.manage().window().fullscreen();
	}

	/**
	 * This method performs implicitwait
	 * 
	 * @param driver
	 */
	public void wait_tillpageloads(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
	}

	/**
	 * This method performs based on condition
	 * 
	 * @param driver
	 * @param ele
	 */
	public void wait_tillConditionSatisfies(WebDriver driver, WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOfAllElements(ele));
	}

	/**
	 * This method performs slect by index
	 * 
	 * @param ele
	 * @param index
	 */
	public void toSelectTheElements(WebElement ele, int index) {
		Select s = new Select(ele);
		s.selectByIndex(index);
	}

	/**
	 * This method performs select by value
	 * 
	 * @param ele
	 * @param value
	 */
	public void toSelectTheElements(WebElement ele, String value) {
		Select s = new Select(ele);
		s.selectByValue(value);
	}

	/**
	 * This method performs select by value
	 * 
	 * @param text
	 * @param ele
	 */
	public void toSelectTheElements(String text, WebElement ele) {
		Select s = new Select(ele);
		s.selectByVisibleText(text);
	}

	/**
	 * This method is used to switch from frames using index
	 * 
	 * @param driver
	 * @param index
	 */
	public void toSwitchFromFrames(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	/**
	 * This method is used to switch from frames using values
	 * 
	 * @param driver
	 * @param value
	 */
	public void toSwitchFromFrames(WebDriver driver, String value) {
		driver.switchTo().frame(value);
	}

	/**
	 * This method is used to switch from frames using WebElement
	 * 
	 * @param driver
	 * @param ele
	 */
	public void toSwitchFromFrames(WebDriver driver, WebElement ele) {
		driver.switchTo().frame(ele);
	}

	/**
	 * This method is used to click using Actions class
	 * 
	 * @param driver
	 */
	public void toperformClick(WebDriver driver) {
		Actions a = new Actions(driver);
		a.click().perform();
	}

	/**
	 * This method is used to doubleclick using Actions class
	 * 
	 * @param driver
	 * @param ele
	 */
	public void toperformDoubleClick(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.doubleClick(ele).perform();
	}

	/**
	 * This method is used to perform accept using popup
	 * 
	 * @param driver
	 */
	public void toPerformAlertToAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * This method is used to perform dismiss using popup
	 * 
	 * @param driver
	 */
	public void toPerformAlertToDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used to perform fetching text using popup
	 * 
	 * @param driver
	 */
	public String toPerformAlertToFetchText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}

	/**
	 * This method is ised for switching from windows
	 * 
	 * @param driver
	 */
	public void toperformSwitchingWindows(WebDriver driver) {		
		  String parent = driver.getWindowHandle(); 
		  Set<String> child = driver.getWindowHandles(); child.remove(parent); 
		  for(String windowID:child) {
			  String title = driver.switchTo().window(windowID).getTitle();
			  Reporter.log("inside loop "+title,true); 
			  if(title.contains(windowID))
				  Reporter.log("inside loop "+title.contains(windowID),true); 
			  	break; 
		  }			 
	}
	
	public void toPerformSwitchingFromChildToParent(WebDriver driver, WebElement ele) {
		 String parent = driver.getWindowHandle();
			Set<String> child = driver.getWindowHandles();
			child.remove(parent);
			for (String windowID : child) {
				driver.switchTo().window(windowID);
				ele.click();
				break;
			}
			driver.switchTo().window(parent);
	}

	/**
	 * This method is used to perform action on disabled elements
	 * 
	 * @param driver
	 * @param ele
	 * @param index
	 */
	public void toperformActionOnDisabledElements(WebDriver driver, WebElement ele, int index) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[index].click();", ele);
	}

	public void toperformScreenshotOnWebpage(WebDriver driver, String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		File f = new File(".\\ErrorShots\\" + imgName + ".png");
		// File f=new
		// File("C:\\JLMS\\J-pgms\\com.DemoWebShop\\ErrorShots\\"+imgName+".png");

		FileHandler.copy(scr, f);
	}

	/**
	 * This method is used to mouse hover using Actions class
	 * 
	 * @param driver
	 * @param ele
	 */
	public void toperformMouseHover(WebDriver driver, WebElement ele) {
		Actions a = new Actions(driver);
		a.moveToElement(ele).perform();
	}

	/**
	 * This method is used to using Actions class
	 * 
	 * @param ele
	 */
	public void toPerformMultipleSelect(String text, WebElement ele) {
		Select s = new Select(ele);
		s.selectByValue(text);
	}

}