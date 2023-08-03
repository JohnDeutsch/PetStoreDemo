package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BulldogItemListPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='EST-6']")
	private WebElement maleAdultBulldogItemLink;
	
	public BulldogItemListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public MaleAdultBulldogItemPage clickMaleAdultBulldogItemLink() {
		maleAdultBulldogItemLink.click();
		return new MaleAdultBulldogItemPage(driver);
	}
}
