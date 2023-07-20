package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManxItemListPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='EST-14']")
	private WebElement taillessManxItemLink;
	
	public ManxItemListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
