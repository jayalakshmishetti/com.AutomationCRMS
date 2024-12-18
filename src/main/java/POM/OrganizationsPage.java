package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {
	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createOrganizationLink;

	public WebElement getCreateOrganizationLink() {
		return createOrganizationLink;
	}
	
	@FindBy(name="accountname")
	private WebElement organizationNameTextField;

	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveButton;

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	@FindBy(name="industry")
	private WebElement industryDropdownMenu;

	public WebElement getIndustryDropdownMenu() {
		return industryDropdownMenu;
	}
	
	@FindBy(name="accounttype")
	private WebElement accountTypeDropdownMenu;

	public WebElement getAccountTypeDropdownMenu() {
		return accountTypeDropdownMenu;
	}
}
