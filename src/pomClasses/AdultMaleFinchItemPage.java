package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.Unused;

@SuppressWarnings ("unused")
public class AdultMaleFinchItemPage {

	private WebDriver driver;
	
	@FindBy(tagName = "font")
	private WebElement itemName;
	
	
	public AdultMaleFinchItemPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getItemNameText() {
		return itemName.getText();
	}
}
