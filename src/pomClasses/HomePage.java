package pomClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	private WebDriver driver;
	
	@FindBy(xpath = "//a[text()='Sign In']")
	private WebElement signInButton;
	@FindBy(name = "keyword")
	private WebElement searchField;
	@FindBy(name = "searchProducts")
	private WebElement searchButton;
	@FindBy(xpath = "//div[id='SidebarContent']//a[1]")
	private WebElement sideBarFishLink;
	@FindBy(xpath = "//div[id='QuickLinks']//a[2]")
	private WebElement topBarDogLink;
	@FindBy(css = "area[alt='Reptiles']")
	private WebElement reptileImageLink;
	@FindBy(xpath = "//title")
	private WebElement titleElement;
	@FindBy(xpath = "//a[text()='My Account']")
	private List<WebElement> myAccountLink;	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public SignInPage clickSignInButton() {
		signInButton.click();
		return new SignInPage(driver);
	}
	
	public void setSearchFieldString(String searchString) {
		searchField.sendKeys(searchString);
	}
	
	//public ItemPage clickSearchButton()
	
	public FishProductListPage clickSideBarFishLink() {
		sideBarFishLink.click();
		return new FishProductListPage(driver);
	}
	
	public String getTitleString() {
		return titleElement.getText();
	}
	
	public boolean myAccountButtonExists() {
		return myAccountLink.size() > 0;
	}	
}
