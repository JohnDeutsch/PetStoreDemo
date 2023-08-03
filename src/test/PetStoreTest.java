package test;

import org.testng.annotations.Test;

import pomClasses.AdultMaleFinchItemPage;
import pomClasses.BirdsProductListPage;
import pomClasses.BulldogItemListPage;
import pomClasses.CatsProductListPage;
import pomClasses.DogsProductListPage;
import pomClasses.FinchItemListPage;
import pomClasses.FishProductListPage;
import pomClasses.GreenAdultIguanaItemPage;
import pomClasses.HomePage;
import pomClasses.IguanaItemListPage;
import pomClasses.MaleAdultBulldogItemPage;
import pomClasses.ManxItemListPage;
import pomClasses.ManxSearchResultsPage;
import pomClasses.RegisterPage;
import pomClasses.ReptilesProductListPage;
import pomClasses.SignInPage;
import pomClasses.TaillessManxItemPage;
import pomClasses.TigerSharkItemListPage;
import pomClasses.ToothlessTigerSharkItemPage;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PetStoreTest {
  
	private WebDriver driver;
	
	private String homePageURL = "https://petstore.octoperf.com/actions/Catalog.action";
	
	private String generatedUsername;
	private String password = "password";
	private String firstName = "Joe";
	private String lastName = "Smith";
	private String email = "abc@email.com";
	private String phoneNumber = "1234567890";
	private String address1 = "123 Street";
	private String address2 = "123";
	private String city = "New York";
	private String state = "NY";
	private String zipCode = "12345";
	private String country = "United States";
	
	// item names are split up by words in order to help ignore weird extra spaces and /n's in the html code
	private String fishItemName1 = "Toothless";
	private String fishItemName2 = "Tiger";
	private String fishItemName3 = "Shark";
	private String dogItemName1 = "Male"; 
	private String dogItemName2 = "Adult";
	private String dogItemName3 = "Bulldog";
	private String catItemName1 = "Tailless";
	private String catItemName2 = "Manx";
	private String reptileItemName1 = "Green";
	private String reptileItemName2 = "Adult";
	private String reptileItemName3 = "Iguana";	 
	private String birdItemName1 = "Adult";
	private String birdItemName2 = "Male";
	private String birdItemName3 = "Finch";
	
	private String searchString = "manx";
	
	@BeforeTest
	public void browserSetup() {		
		WebDriverManager.firefoxdriver().setup();		
		driver = new FirefoxDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	//@BeforeTest
	public void generateUsername() {
		// generate a random alphanumeric username
				int leftLimit = 48; // numeral '0'
			    int rightLimit = 122; // letter 'z'
			    int targetStringLength = 12;
			    Random random = new Random();
			    generatedUsername = random.ints(leftLimit, rightLimit + 1)
			    	      .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
			    	      .limit(targetStringLength)
			    	      .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			    	      .toString();
	}
	
	// this test needs to run first since other tests are dependent on the account being created
	// the syntax is @Test (dependsOnMethods = { "verifySignup" })
	//@Test	
	public void verifySignup() {
		// create account on register page
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		SignInPage signInPage = homePage.clickSignInButton();
		RegisterPage registerPage = signInPage.clickRegisterLink();				
	    registerPage.setUserIDField(generatedUsername);
	    registerPage.setPasswordField(password);
	    registerPage.setRepeatPasswordField(password);
	    registerPage.setFirstNameField(firstName);
	    registerPage.setLastNameField(lastName);
	    registerPage.setEmailField(email);
	    registerPage.setPhoneField(phoneNumber);
	    registerPage.setAddress1Field(address1);
	    registerPage.setAddress2Field(address2);
	    registerPage.setCityField(city);
	    registerPage.setStateField(state);
	    registerPage.setZipField(zipCode);
	    registerPage.setCountryField(country);
	    homePage = registerPage.clickSaveAccountInfoButton();	    
	    
	    // check if account creation was successful by logging in
	    signInPage = homePage.clickSignInButton();
	    signInPage.setUsernameField(generatedUsername);
	    signInPage.clearPasswordField();
	    signInPage.setPasswordField(password);	    
	    homePage = signInPage.clickLoginButton();
	    assertTrue(homePage.myAccountLinkExists());
	}
	/*
	@Test
	public void verifyBrowsingFish() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		FishProductListPage fishProductListPage = homePage.clickSideBarFishLink();
		TigerSharkItemListPage tigerSharkItemListPage = fishProductListPage.clickTigerSharkItemLink();
		ToothlessTigerSharkItemPage toothlessTigerSharkItemPage = tigerSharkItemListPage.clickToothlessTigerSharkItemLink();
		String toothlessTigerSharkItemName = toothlessTigerSharkItemPage.getItemNameText();
		assertTrue(toothlessTigerSharkItemName.contains(fishItemName1)
				&& toothlessTigerSharkItemName.contains(fishItemName2)
				&& toothlessTigerSharkItemName.contains(fishItemName3));	
	}
	
	@Test
	public void verifyBrowsingDogs() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		DogsProductListPage dogsProductListPage = homePage.clickTopBarDogLink();
		BulldogItemListPage bulldogItemListPage = dogsProductListPage.clickBulldogItemListLink();
		MaleAdultBulldogItemPage maleAdultBulldogItemPage = bulldogItemListPage.clickMaleAdultBulldogItemLink();
		String maleAdultBulldogItemName = maleAdultBulldogItemPage.getItemNameText();
		assertTrue(maleAdultBulldogItemName.contains(dogItemName1)
				&& maleAdultBulldogItemName.contains(dogItemName2)
				&& maleAdultBulldogItemName.contains(dogItemName3));
	}
	
	@Test
	public void verifyBrowsingCats() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		CatsProductListPage catsProductListPage = homePage.clickTopBarCatLink();
		ManxItemListPage manxItemListPage = catsProductListPage.clickManxItemListLink();
		TaillessManxItemPage taillessManxItemPage = manxItemListPage.clickTaillessManxItemLink();
		String taillessManxItemName = taillessManxItemPage.getItemNameText();
		assertTrue(taillessManxItemName.contains(catItemName1)
				&& taillessManxItemName.contains(catItemName2));
	}
	
	@Test
	public void verifyBrowsingReptiles() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		ReptilesProductListPage reptilesProductListPage = homePage.clickReptileImageLink();
		IguanaItemListPage iguanaItemListPage = reptilesProductListPage.clickIguanaItemListLink();
		GreenAdultIguanaItemPage greenAdultIguanaItemPage = iguanaItemListPage.clickGreenAdultIguanaItemLink();
		String greenAdultIguanaItemName = greenAdultIguanaItemPage.getItemNameText();
		assertTrue(greenAdultIguanaItemName.contains(reptileItemName1)
				&& greenAdultIguanaItemName.contains(reptileItemName2)
				&& greenAdultIguanaItemName.contains(reptileItemName3));
	}
	
	@Test
	public void verifyBrowsingBirds() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		BirdsProductListPage birdsProductListPage = homePage.clickBirdImageLink();
		FinchItemListPage finchItemListPage = birdsProductListPage.clickFinchItemListLink();
		AdultMaleFinchItemPage adultMaleFinchItemPage = finchItemListPage.clickAdultMaleFinchItemLink();
		String adultMaleFinchItemName = adultMaleFinchItemPage.getItemNameText();
		assertTrue(adultMaleFinchItemName.contains(birdItemName1)
				&& adultMaleFinchItemName.contains(birdItemName2)
				&& adultMaleFinchItemName.contains(birdItemName3));
	}*/
	
	@Test
	public void verifySearch() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		homePage.setSearchFieldString(searchString);
		ManxSearchResultsPage manxSearchResultsPage = homePage.clickSearchButton();
		ManxItemListPage manxItemListPage = manxSearchResultsPage.clickManxItemListLink();
		assertTrue(manxItemListPage.manxHeaderExists());
	}
	
	//@Test
	public void verifyAddAndRemove() {
		// add to cart through item list page
		// add to cart through item page
		// remove items in cart
	}
	
	//@Test
	public void verifyItemQuantityUpdate() {
		
	}
	
	//@Test (dependsOnMethods = { "verifySignup" })
	public void verifyOrder() {
		
	}

	@AfterTest
	public void cleanup() {
		driver.quit();
	}

}
