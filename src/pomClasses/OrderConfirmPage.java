package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmPage {

	WebDriver driver;
	
	@FindBy(xpath = "//tbody//tr[3]//td[2]")
	private WebElement firstNameBilling;
	@FindBy(xpath = "//tbody//tr[4]//td[2]")
	private WebElement lastNameBilling;
	@FindBy(xpath = "//tbody//tr[5]//td[2]")
	private WebElement address1Billing;
	@FindBy(xpath = "//tbody//tr[6]//td[2]")
	private WebElement address2Billing;
	@FindBy(xpath = "//tbody//tr[7]//td[2]")
	private WebElement cityBilling;
	@FindBy(xpath = "//tbody//tr[8]//td[2]")
	private WebElement stateBilling;
	@FindBy(xpath = "//tbody//tr[9]//td[2]")
	private WebElement zipBilling;
	@FindBy(xpath = "//tbody//tr[10]//td[2]")
	private WebElement countryBilling;
	
	@FindBy(xpath = "//tbody//tr[12]//td[2]")
	private WebElement firstNameShipping;
	@FindBy(xpath = "//tbody//tr[13]//td[2]")
	private WebElement lastNameShipping;
	@FindBy(xpath = "//tbody//tr[14]//td[2]")
	private WebElement address1Shipping;
	@FindBy(xpath = "//tbody//tr[15]//td[2]")
	private WebElement address2Shipping;
	@FindBy(xpath = "//tbody//tr[16]//td[2]")
	private WebElement cityShipping;
	@FindBy(xpath = "//tbody//tr[17]//td[2]")
	private WebElement stateShipping;
	@FindBy(xpath = "//tbody//tr[18]//td[2]")
	private WebElement zipShipping;
	@FindBy(xpath = "//tbody//tr[19]//td[2]")
	private WebElement countryShipping;
	@FindBy(xpath = "//a[text()='Confirm']")
	private WebElement confirmButton;
	
	public OrderConfirmPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getFirstNameBillingString() {
		return firstNameBilling.getText();
	}
	
	public String getLastNameBillingString() {
		return lastNameBilling.getText();
	}
	
	public String getAddress1BillingString() {
		return address1Billing.getText();
	}
	
	public String getAddress2BillingString() {
		return address2Billing.getText();
	}
	
	public String getCityBillingString() {
		return cityBilling.getText();
	}
	
	public String getStateBillingString() {
		return stateBilling.getText();
	}
	
	public String getZipBillingString() {
		return zipBilling.getText();
	}
	
	public String getCountryBillingString() {
		return countryBilling.getText();
	}

	public String getFirstNameShippingString() {
		return firstNameShipping.getText();
	}
	
	public String getLastNameShippingString() {
		return lastNameShipping.getText();
	}
	
	public String getAddress1ShippingString() {
		return address1Shipping.getText();
	}
	
	public String getAddress2ShippingString() {
		return address2Shipping.getText();
	}
	
	public String getCityShippingString() {
		return cityShipping.getText();
	}
	
	public String getStateShippingString() {
		return stateShipping.getText();
	}
	
	public String getZipShippingString() {
		return zipShipping.getText();
	}
	
	public String getCountryShippingString() {
		return countryShipping.getText();
	}
	
	public OrderSubmittedPage clickConfirmButton() {
		confirmButton.click();
		return new OrderSubmittedPage(driver);
	}
}
