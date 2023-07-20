package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReptilesProductListPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='RP-LI-02']")
	private WebElement iguanaItemListLink;
	
	public ReptilesProductListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public IguanaItemListPage clickIguanaItemListLink() {
		iguanaItemListLink.click();
		return new IguanaItemListPage(driver);
	}
}
