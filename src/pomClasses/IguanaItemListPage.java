package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IguanaItemListPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='EST-13']")
	private WebElement greenAdultIguanaItemLink;
	
	public IguanaItemListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
