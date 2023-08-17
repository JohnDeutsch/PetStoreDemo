package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MaleAdultBulldogItemPage {

	private WebDriver driver;
	
	@FindBy(tagName = "font")
	private WebElement itemName;
	@FindBy(xpath = "//div[@id='LogoContent']//a")
	private WebElement homePageLink;
	@FindBy(xpath = "//a[text()='Add to Cart']")
	private WebElement addToCartButton;
	
	public MaleAdultBulldogItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getItemNameText() {
		return itemName.getText();
	}
	
	public HomePage clickHomePageLink() {
		homePageLink.click();
		return new HomePage(driver);
	}
	
	public ShoppingCartPage clickAddToCartButton() {
		addToCartButton.click();
		return new ShoppingCartPage(driver);
	}
}
