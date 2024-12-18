package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement createContactLink;

	public WebElement getCreateContactLink() {
		return createContactLink;
	}
	
	@FindBy(name="lastname")
	private WebElement lastNameTextField;

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[2]")
	private WebElement saveContactButton;

	public WebElement getSaveContactButton() {
		return saveContactButton;
	}
	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement accountIdLink;

	public WebElement getAccountIdLink() {
		return accountIdLink;
	}
	
	@FindBy(linkText="Pentagon")
	private WebElement accountNameLink;

	public WebElement getAccountNameLink() {
		return accountNameLink;
	}
}
