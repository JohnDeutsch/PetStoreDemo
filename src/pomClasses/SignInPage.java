package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {

	private WebDriver driver;
	
	@FindBy(name = "username")
	private WebElement usernameField;
	@FindBy(name = "password")
	private WebElement passwordField;
	@FindBy(name = "signon")
	private WebElement loginButton;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String username) {
		usernameField.sendKeys(username);
	}
	
	public void setPassword(String password) {
		passwordField.sendKeys(password);
	}
	
	public HomePage clickLoginButton() {
		loginButton.click();
		return new HomePage(driver);
	}
}
