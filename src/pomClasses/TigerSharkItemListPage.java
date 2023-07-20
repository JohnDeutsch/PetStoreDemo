package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TigerSharkItemListPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='EST-3']")
	private WebElement toothlessTigerSharkItemLink;
	
	public TigerSharkItemListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
