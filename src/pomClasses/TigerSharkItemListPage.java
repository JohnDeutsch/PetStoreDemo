package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TigerSharkItemListPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='EST-3']")
	private WebElement toothlessTigerSharkItemLink;
	@FindBy(xpath = "//a[text()='Add to Cart']")
	private WebElement addToCartButton;
	
	public TigerSharkItemListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ToothlessTigerSharkItemPage clickToothlessTigerSharkItemLink() {
		toothlessTigerSharkItemLink.click();
		return new ToothlessTigerSharkItemPage(driver);
	}
	
	public ShoppingCartPage clickAddToCartButton() {
		addToCartButton.click();
		return new ShoppingCartPage(driver);
	}
}
