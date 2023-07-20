package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DogsProductListPage {

private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='K9-BD-01']")
	private WebElement bulldogItemListLink;
	
	public DogsProductListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public BulldogItemListPage clickBulldogItemListLink() {
		bulldogItemListLink.click();
		return new BulldogItemListPage(driver);
	}
}
