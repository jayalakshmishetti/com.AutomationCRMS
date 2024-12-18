package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	public LogoutPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//td[@class='small'])[2]")
	private WebElement selectUser;

	public WebElement getSelectUser() {
		return selectUser;
	}
	
	@FindBy(linkText="Sign Out")
	private WebElement signoutLink;

	public WebElement getSignoutLink() {
		return signoutLink;
	}
}
