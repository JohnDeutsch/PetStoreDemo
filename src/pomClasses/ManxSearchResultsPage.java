package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManxSearchResultsPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Great for reducing mouse populations']")
	private WebElement manxItemListLink;
	
	public ManxSearchResultsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public ManxItemListPage clickManxItemListLink() {
		manxItemListLink.click();
		return new ManxItemListPage(driver);
	}
}
