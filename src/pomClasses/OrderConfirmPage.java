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
	
	public boolean checkAllFields(
			String firstNameBilling, 
			String lastNameBilling,
			String address1Billing,
			String address2Billing,
			String cityBilling,
			String stateBilling,
			String zipBilling,
			String countryBilling,
			String firstNameShipping,
			String lastNameShipping,
			String address1Shipping,
			String address2Shipping,
			String cityShipping,
			String stateShipping,
			String zipShipping,
			String countryShipping) {
		boolean firstNameBillingCorrect = getFirstNameBillingString().compareToIgnoreCase(firstNameBilling) == 0;
		boolean lastNameBillingCorrect = getLastNameBillingString().compareToIgnoreCase(lastNameBilling) == 0;
		boolean address1BillingCorrect = getAddress1BillingString().compareToIgnoreCase(address1Billing) == 0;
		boolean address2BillingCorrect = getAddress2BillingString().compareToIgnoreCase(address2Billing) == 0;
		boolean cityBillingCorrect = getCityBillingString().compareToIgnoreCase(cityBilling) == 0;
		boolean stateBillingCorrect = getStateBillingString().compareToIgnoreCase(stateBilling) == 0;
		boolean zipBillingCorrect = getZipBillingString().compareTo(zipBilling) == 0;
		boolean countryBillingCorrect = getCountryBillingString().compareToIgnoreCase(countryBilling) == 0;
		boolean firstNameShippingCorrect = getFirstNameShippingString().compareToIgnoreCase(firstNameShipping) == 0;
		boolean lastNameShippingCorrect = getLastNameShippingString().compareToIgnoreCase(lastNameShipping) == 0;
		boolean address1ShippingCorrect = getAddress1ShippingString().compareToIgnoreCase(address1Shipping) == 0;
		boolean address2ShippingCorrect = getAddress2ShippingString().compareToIgnoreCase(address2Shipping) == 0;
		boolean cityShippingCorrect = getCityShippingString().compareToIgnoreCase(cityShipping) == 0;
		boolean stateShippingCorrect = getStateShippingString().compareToIgnoreCase(stateShipping) == 0;
		boolean zipShippingCorrect = getZipShippingString().compareTo(zipShipping) == 0;
		boolean countryShippingCorrect = getCountryShippingString().compareToIgnoreCase(countryShipping) == 0;
		
		return firstNameBillingCorrect
				&& lastNameBillingCorrect
				&& address1BillingCorrect
				&& address2BillingCorrect
				&& cityBillingCorrect
				&& stateBillingCorrect
				&& zipBillingCorrect
				&& countryBillingCorrect
				&& firstNameShippingCorrect
				&& lastNameShippingCorrect
				&& address1ShippingCorrect
				&& address2ShippingCorrect
				&& cityShippingCorrect
				&& stateShippingCorrect
				&& zipShippingCorrect
				&& countryShippingCorrect;
		
		/*
		return getFirstNameBillingString().compareToIgnoreCase(firstNameBilling) == 0
				&& getLastNameBillingString().compareToIgnoreCase(lastNameBilling) == 0
				&& getAddress1BillingString().compareToIgnoreCase(address1Billing) == 0
				&& getAddress2BillingString().compareToIgnoreCase(address2Billing) == 0
				&& getCityBillingString().compareToIgnoreCase(cityBilling) == 0
				&& getStateBillingString().compareToIgnoreCase(stateBilling) == 0
				&& getZipBillingString().compareTo(zipBilling) == 0
				&& getCountryBillingString().compareToIgnoreCase(countryBilling) == 0
				&& getFirstNameShippingString().compareToIgnoreCase(firstNameShipping) == 0
				&& getLastNameShippingString().compareToIgnoreCase(lastNameShipping) == 0
				&& getAddress1ShippingString().compareToIgnoreCase(address1Shipping) == 0
				&& getAddress2ShippingString().compareToIgnoreCase(address2Shipping) == 0
				&& getCityShippingString().compareToIgnoreCase(cityShipping) == 0
				&& getStateShippingString().compareToIgnoreCase(stateShipping) == 0
				&& getZipShippingString().compareTo(zipShipping) == 0
				&& getCountryShippingString().compareToIgnoreCase(countryShipping) == 0;
		*/
	}
	
	public OrderSubmittedPage clickConfirmButton() {
		confirmButton.click();
		return new OrderSubmittedPage(driver);
	}
}
