package pomClasses;

import java.util.List;

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
	@FindBy(xpath = "//a[text()='Register Now!']")
	private WebElement registerLink;
	@FindBy(css = "ul[class='messages']")
	private List<WebElement> invalidMessage;
	
	public SignInPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUsernameField(String username) {
		usernameField.sendKeys(username);
	}
	
	public void clearPasswordField() {
		passwordField.clear();
	}
	
	public void setPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public HomePage clickLoginButton() {
		loginButton.click();
		return new HomePage(driver);
	}
	
	public RegisterPage clickRegisterLink() {
		registerLink.click();
		return new RegisterPage(driver);
	}
	
	public boolean invalidMessageExists() {
		return invalidMessage.size() > 0;		
	}
}
