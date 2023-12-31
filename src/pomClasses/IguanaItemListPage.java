package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IguanaItemListPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='EST-13']")
	private WebElement greenAdultIguanaItemLink;
	@FindBy(xpath = "//a[text()='Add to Cart']")
	private WebElement addToCartButton;
	
	public IguanaItemListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public GreenAdultIguanaItemPage clickGreenAdultIguanaItemLink() {
		greenAdultIguanaItemLink.click();
		return new GreenAdultIguanaItemPage(driver);
	}
	
	public ShoppingCartPage clickAddToCartButton() {
		addToCartButton.click();
		return new ShoppingCartPage(driver);
	}
}
