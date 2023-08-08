package pomClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//div[@id='QuickLinks']//a[2]")
	private WebElement topBarDogLink;
	@FindBy(xpath = "//td[text()='FI-SW-02']")
	private WebElement toothlessTigerSharkProductID;
	@FindBy(xpath = "//td[text()='FI-SW-02']//following-sibling::td[6]//a")
	private WebElement toothlessTigerSharkRemoveButton;
	@FindBy(xpath = "//td[text()='K9-BD-01']")
	private WebElement maleAdultBulldogProductID;
	@FindBy(xpath = "//td[text()='K9-BD-01']//following-sibling::td[6]//a")
	private WebElement maleAdultBulldogRemoveButton;
	@FindBy(xpath = "//b[text()='Your cart is empty.']")
	private List<WebElement> emptyCartMessage;
	
	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public DogsProductListPage clickTopBarDogLink() {
		topBarDogLink.click();
		return new DogsProductListPage(driver);
	}	
	
	public String getToothlessTigerSharkProductIDString() {
		return toothlessTigerSharkProductID.getText();
	}
	
	public ShoppingCartPage clickToothlessTigerSharkRemoveButton() {
		toothlessTigerSharkRemoveButton.click();
		return new ShoppingCartPage(driver);
	}
	
	public String getMaleAdultBulldogProductIDString() {
		return maleAdultBulldogProductID.getText();
	}
	
	public ShoppingCartPage clickMaleAdultBulldogRemoveButton() {
		maleAdultBulldogRemoveButton.click();
		return new ShoppingCartPage(driver);
	}
	
	public boolean emptyCartMessageExists() {
		return emptyCartMessage.size() > 0;
	}
}
