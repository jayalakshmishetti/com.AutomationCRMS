package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericPackage.BaseClass;
import GenericPackage.ExcelFile;
import GenericPackage.WebDriverUtility;
import POM.ContactsPage;
import POM.WelcomePage;

public class TC01_VTiger_Contacts_test extends BaseClass {
//@Listeners(GenericPackage.ITestListenerClass.class)
	@Test
	public void contacts() throws EncryptedDocumentException, IOException, InterruptedException {
		WelcomePage w = new WelcomePage(driver);
		ContactsPage c = new ContactsPage(driver);
		WebDriverUtility wu = new WebDriverUtility();
		ExcelFile e = new ExcelFile();

		w.getContactLink().click();
		c.getCreateContactLink().click();
		c.getLastNameTextField().sendKeys(e.toReadDataFromExcelFile("Contacts", 4, 2));
		c.getAccountIdLink().click();
		
		
		WebElement orgName = c.getAccountNameLink();
		wu.toPerformSwitchingFromChildToParent(driver, orgName);
		Assert.fail(); //to take screenshots
		c.getSaveContactButton().click();
	}
}
