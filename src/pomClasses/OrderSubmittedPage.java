package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderSubmittedPage {

	WebDriver driver;
	
	@FindBy(xpath = "//tbody//tr[3]//td[2]")
	private WebElement cardType;
	@FindBy(xpath = "//tbody//tr[4]//td[2]")
	private WebElement cardNumber;
	@FindBy(xpath = "//tbody//tr[5]//td[2]")
	private WebElement expiryDate;
	
	@FindBy(xpath = "//tbody//tr[7]//td[2]")
	private WebElement firstNameBilling;
	@FindBy(xpath = "//tbody//tr[8]//td[2]")
	private WebElement lastNameBilling;
	@FindBy(xpath = "//tbody//tr[9]//td[2]")
	private WebElement address1Billing;
	@FindBy(xpath = "//tbody//tr[10]//td[2]")
	private WebElement address2Billing;
	@FindBy(xpath = "//tbody//tr[11]//td[2]")
	private WebElement cityBilling;
	@FindBy(xpath = "//tbody//tr[12]//td[2]")
	private WebElement stateBilling;
	@FindBy(xpath = "//tbody//tr[13]//td[2]")
	private WebElement zipBilling;
	@FindBy(xpath = "//tbody//tr[14]//td[2]")
	private WebElement countryBilling;
	
	@FindBy(xpath = "//tbody//tr[16]//td[2]")
	private WebElement firstNameShipping;
	@FindBy(xpath = "//tbody//tr[17]//td[2]")
	private WebElement lastNameShipping;
	@FindBy(xpath = "//tbody//tr[18]//td[2]")
	private WebElement address1Shipping;
	@FindBy(xpath = "//tbody//tr[19]//td[2]")
	private WebElement address2Shipping;
	@FindBy(xpath = "//tbody//tr[20]//td[2]")
	private WebElement cityShipping;
	@FindBy(xpath = "//tbody//tr[21]//td[2]")
	private WebElement stateShipping;
	@FindBy(xpath = "//tbody//tr[22]//td[2]")
	private WebElement zipShipping;
	@FindBy(xpath = "//tbody//tr[23]//td[2]")
	private WebElement countryShipping;
	
	@FindBy(xpath = "//tbody//tr[26]//td//table//tbody//tr[2]//td[1]//a")
	private WebElement itemID;
	@FindBy(xpath = "//tbody//tr[26]//td//table//tbody//tr[2]//td[2]")
	private WebElement description;
	@FindBy(xpath = "//tbody//tr[26]//td//table//tbody//tr[2]//td[3]")
	private WebElement quantity;
	@FindBy(xpath = "//tbody//tr[26]//td//table//tbody//tr[2]//td[4]")
	private WebElement price;
	@FindBy(xpath = "//tbody//tr[26]//td//table//tbody//tr[2]//td[5]")
	private WebElement totalCost;
	@FindBy(xpath = "//tbody//tr[26]//td//table//tbody//tr[3]//th")
	private WebElement total;
	
	@FindBy(xpath = "//a[text()='Sign Out']")
	private WebElement signOutButton;
	
	public OrderSubmittedPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getCardTypeString() {
		return cardType.getText();
	}
	
	public String getCardNumberString() {
		return cardNumber.getText();
	}
	
	public String getExpiryDateString() {
		return expiryDate.getText();
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
	
	public String getItemIDString() {
		return itemID.getText();
	}
	
	public String getDescriptionString() {
		return description.getText();
	}
	
	public String getQuantityString() {
		return quantity.getText();
	}
	
	public String getPriceString() {
		return price.getText();
	}
	
	public String getTotalCostString() {
		return totalCost.getText();
	}
	
	public String getTotalString() {
		return total.getText();
	}
	
	public HomePage clickSignoutButton() {
		signOutButton.click();
		return new HomePage(driver);
	}
}
