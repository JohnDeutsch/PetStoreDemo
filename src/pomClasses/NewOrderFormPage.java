package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewOrderFormPage {

	private WebDriver driver;
	
	@FindBy(name = "newOrder")
	private WebElement continueButton;
	
	public NewOrderFormPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public OrderConfirmPage clickContinueButton() {
		continueButton.click();
		return new OrderConfirmPage(driver);
	}
}
