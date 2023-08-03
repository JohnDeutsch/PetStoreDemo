package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatsProductListPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='FL-DSH-01']")
	private WebElement manxItemListLink;
	
	public CatsProductListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ManxItemListPage clickManxItemListLink() {
		manxItemListLink.click();
		return new ManxItemListPage(driver);
	}
}
