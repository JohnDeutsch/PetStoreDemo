package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FishProductListPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='FI-SW-02']")
	private WebElement tigerSharkItemListLink;
	
	public FishProductListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public TigerSharkItemListPage clickTigerSharkItemLink() {
		tigerSharkItemListLink.click();
		return new TigerSharkItemListPage(driver);
	}
}
