package pomClasses;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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
	@FindBy(xpath = "//div[@id='SidebarContent']//a[1]")
	private WebElement sideBarFishLink;
	@FindBy(xpath = "//div[@id='QuickLinks']//a[2]")
	private WebElement topBarDogLink;
	@FindBy(xpath = "//div[@id='QuickLinks']//a[4]")
	private WebElement topBarCatLink;
	@FindBy(css = "area[alt='Reptiles']")
	private WebElement reptileImageLink;
	@FindBy(css = "area[alt='Birds']")
	private WebElement birdImageLink;
	@FindBy(xpath = "//a[text()='My Account']")
	private List<WebElement> myAccountLink;	
	
	Actions builder;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		builder = new Actions(driver);
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
	
	public DogsProductListPage clickTopBarDogLink() {
		topBarDogLink.click();
		return new DogsProductListPage(driver);
	}
	
	public ReptilesProductListPage clickReptileImageLink() {
		Action clickReptileImageLink = builder
				.moveToElement(reptileImageLink) // moves to center of the map area
				.moveByOffset(0, 128)	// moves to center of the reptile picture
				.click()
				.build();
		clickReptileImageLink.perform();
		return new ReptilesProductListPage(driver);
	}
	
	public BirdsProductListPage clickBirdImageLink() {
		// moving to and clicking on the center of the map area (large bird that leads to birds product list page)
		Action clickBirdImageLink = builder
				.moveToElement(birdImageLink)
				.click()
				.build();
		clickBirdImageLink.perform();
		return new BirdsProductListPage(driver);
	}
	
	public CatsProductListPage clickTopBarCatLink() {
		topBarCatLink.click();
		return new CatsProductListPage(driver);
	}
	
	public boolean myAccountButtonExists() {
		return myAccountLink.size() > 0;
	}	
}
