package TestScripts;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebElement;
//import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import GenericPackage.BaseClass;
import GenericPackage.ExcelFile;
import GenericPackage.WebDriverUtility;
import POM.OrganizationsPage;
import POM.WelcomePage;

public class TC02_VTiger_Organizations_test extends BaseClass {
//@Listeners.
	@Test	
	public void contacts() throws EncryptedDocumentException, IOException {
		WelcomePage w = new WelcomePage(driver);
		OrganizationsPage o = new OrganizationsPage(driver);
		WebDriverUtility ww=new WebDriverUtility();
		ExcelFile e = new ExcelFile();
		
		w.getOrganizationsLink().click();
		o.getCreateOrganizationLink().click();
		o.getOrganizationNameTextField().sendKeys(e.toReadDataFromExcelFile("Organizations", 7, 2));
		WebElement industry = o.getIndustryDropdownMenu();
		WebElement type = o.getAccountTypeDropdownMenu();
		//ww.toPerformMultipleSelect("Energy",industry);
		//ww.toPerformMultipleSelect("Customer",type);
		ww.toPerformMultipleSelect(e.toReadDataFromExcelFile("Organizations", 7, 3),industry);
		ww.toPerformMultipleSelect(e.toReadDataFromExcelFile("Organizations", 7, 4),type);
		o.getSaveButton().click();
	}
}
