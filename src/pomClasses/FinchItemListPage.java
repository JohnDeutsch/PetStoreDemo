package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FinchItemListPage {
	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='EST-19']")
	private WebElement adultMaleFinchItemLink;
	@FindBy(xpath = "//a[text()='Add to Cart']")
	private WebElement addToCartButton;
	
	public FinchItemListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public AdultMaleFinchItemPage clickAdultMaleFinchItemLink() {
		adultMaleFinchItemLink.click();
		return new AdultMaleFinchItemPage(driver);
	}

	public ShoppingCartPage clickAddToCartButton() {
		addToCartButton.click();
		return new ShoppingCartPage(driver);
	}
}
