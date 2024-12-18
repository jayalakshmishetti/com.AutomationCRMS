package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
	public WelcomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Contacts")
	private WebElement contactLink;

	public WebElement getContactLink() {
		return contactLink;
	}
	
	@FindBy(linkText="Organizations")
	private WebElement organizationsLink;

	public WebElement getOrganizationsLink() {
		return organizationsLink;
	}
	
}
