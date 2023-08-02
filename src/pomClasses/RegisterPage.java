package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	private WebDriver driver;
	
	@FindBy(name = "username")
	private WebElement userIDField;
	@FindBy(name = "password")
	private WebElement passwordField;
	@FindBy(name = "repeatedPassword")
	private WebElement repeatPasswordField;
	@FindBy(name = "account.firstName")
	private WebElement firstNameField;
	@FindBy(name = "account.lastName")
	private WebElement lastNameField;
	@FindBy(name = "account.email")
	private WebElement emailField;
	@FindBy(name = "account.phone")
	private WebElement phoneField;
	@FindBy(name = "account.address1")
	private WebElement address1Field;
	@FindBy(name = "account.address2")
	private WebElement address2Field;
	@FindBy(name = "account.city")
	private WebElement cityField;
	@FindBy(name = "account.state")
	private WebElement stateField;
	@FindBy(name = "account.zip")
	private WebElement zipField;
	@FindBy(name = "account.country")
	private WebElement countryField;
	@FindBy(name = "newAccount")
	private WebElement saveAccountInfoButton;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void setUserIDField(String userID) {
		userIDField.sendKeys(userID);
	}
	
	public void setPasswordField(String password) {
		passwordField.sendKeys(password);
	}
	
	public void setRepeatPasswordField(String repeatPassword) {
		repeatPasswordField.sendKeys(repeatPassword);
	}
	
	public void setFirstNameField(String firstName) {
		firstNameField.sendKeys(firstName);
	}
	
	public void setLastNameField(String lastName) {
		lastNameField.sendKeys(lastName);
	}
	
	public void setEmailField(String email) {
		emailField.sendKeys(email);
	}
	
	public void setPhoneField(String phoneNumber) {
		phoneField.sendKeys(phoneNumber);
	}
	
	public void setAddress1Field(String address1) {
		address1Field.sendKeys(address1);
	}
	
	public void setAddress2Field(String address2) {
		address2Field.sendKeys(address2);
	}
	
	public void setCityField(String city) {
		cityField.sendKeys(city);
	}
	
	public void setStateField(String state) {
		stateField.sendKeys(state);
	}
	
	public void setZipField(String zipcode) {
		zipField.sendKeys(zipcode);
	}
	
	public void setCountryField(String country) {
		countryField.sendKeys(country);
	}
	
	public HomePage clickSaveAccountInfoButton() {
		saveAccountInfoButton.click();
		return new HomePage(driver);
	}
}
