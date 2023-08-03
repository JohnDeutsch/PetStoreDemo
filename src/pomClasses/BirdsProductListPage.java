package pomClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BirdsProductListPage {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='AV-SB-02']")
	private WebElement finchItemListLink;
	
	public BirdsProductListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public FinchItemListPage clickFinchItemListLink() {		
		// this product list page takes longer to load its elements than the others
		new WebDriverWait(driver, Duration.ofSeconds(20))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='AV-SB-02']")));
		finchItemListLink.click();
		return new FinchItemListPage(driver);
	}
}
