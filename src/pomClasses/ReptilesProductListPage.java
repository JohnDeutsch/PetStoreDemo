package pomClasses;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReptilesProductListPage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='RP-LI-02']")
	private WebElement iguanaItemListLink;
	
	public ReptilesProductListPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public IguanaItemListPage clickIguanaItemListLink() {
		// this product list page takes longer to load its elements than the others
		new WebDriverWait(driver, Duration.ofSeconds(20))
		.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='RP-LI-02']")));
		iguanaItemListLink.click();
		return new IguanaItemListPage(driver);
	}
}
