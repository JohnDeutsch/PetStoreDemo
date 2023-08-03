package pomClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManxItemListPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='EST-14']")
	private WebElement taillessManxItemLink;
	@FindBy(xpath = "//h2[text()='Manx']")
	private List<WebElement> manxHeader;
	
	public ManxItemListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public TaillessManxItemPage clickTaillessManxItemLink() {
		taillessManxItemLink.click();
		return new TaillessManxItemPage(driver);
	}
	
	public boolean manxHeaderExists() {
		return manxHeader.size() > 0;
	}
}
