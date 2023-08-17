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
import pomClasses.NewOrderFormPage;
import pomClasses.OrderConfirmPage;
import pomClasses.OrderSubmittedPage;
import pomClasses.RegisterPage;
import pomClasses.ReptilesProductListPage;
import pomClasses.ShoppingCartPage;
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
	
	private String fishItemName = "Toothless Tiger Shark";
	private String dogItemName = "Male Adult Bulldog"; 
	private String catItemName = "Tailless Manx";
	private String reptileItemName = "Green Adult Iguana";
	private String birdItemName = "Adult Male Finch";
	
	private String searchString = "manx";
	
	private String toothlessTigerSharkProductID = "FI-SW-02";
	private String maleAdultBulldogProductID = "K9-BD-01";
	
	private String greenAdultIguanaQuantity = "2";
	private String cartSubTotal = "$37.00";
	
	private String cardType = "Visa";
	private String cardNumber = "999 9999 9999 9999";
	private String expiryDate = "12/03";
	private String itemID = "EST-19";
	private String description = "Adult Male Finch";
	private String quantity = "1";
	private String price = "$15.50";
	private String totalCost = "$15.50";
	private String total = "Total: $15.50";
	
	@BeforeTest
	public void browserSetup() {		
		WebDriverManager.firefoxdriver().setup();		
		driver = new FirefoxDriver();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	}
	
	@BeforeTest
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
	
	@Test 
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
	    
	    // sign out
	    homePage.clickSignOutButton();
	}
	
	@Test
	public void verifyBrowsingFish() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		FishProductListPage fishProductListPage = homePage.clickSideBarFishLink();
		TigerSharkItemListPage tigerSharkItemListPage = fishProductListPage.clickTigerSharkItemLink();
		ToothlessTigerSharkItemPage toothlessTigerSharkItemPage = tigerSharkItemListPage.clickToothlessTigerSharkItemLink();
		assertTrue(Utility.stringCompareRemoveAllWhiteSpaces(toothlessTigerSharkItemPage.getItemNameText(), fishItemName));	
	}
	
	@Test
	public void verifyBrowsingDogs() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		DogsProductListPage dogsProductListPage = homePage.clickTopBarDogLink();
		BulldogItemListPage bulldogItemListPage = dogsProductListPage.clickBulldogItemListLink();
		MaleAdultBulldogItemPage maleAdultBulldogItemPage = bulldogItemListPage.clickMaleAdultBulldogItemLink();
		assertTrue(Utility.stringCompareRemoveAllWhiteSpaces(maleAdultBulldogItemPage.getItemNameText(), dogItemName));
	}
	
	@Test
	public void verifyBrowsingCats() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		CatsProductListPage catsProductListPage = homePage.clickTopBarCatLink();
		ManxItemListPage manxItemListPage = catsProductListPage.clickManxItemListLink();
		TaillessManxItemPage taillessManxItemPage = manxItemListPage.clickTaillessManxItemLink();
		assertTrue(Utility.stringCompareRemoveAllWhiteSpaces(taillessManxItemPage.getItemNameText(), catItemName));
	}
	
	@Test
	public void verifyBrowsingReptiles() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		ReptilesProductListPage reptilesProductListPage = homePage.clickReptileImageLink();
		IguanaItemListPage iguanaItemListPage = reptilesProductListPage.clickIguanaItemListLink();
		GreenAdultIguanaItemPage greenAdultIguanaItemPage = iguanaItemListPage.clickGreenAdultIguanaItemLink();
		assertTrue(Utility.stringCompareRemoveAllWhiteSpaces(greenAdultIguanaItemPage.getItemNameText(), reptileItemName));
	}
	
	@Test
	public void verifyBrowsingBirds() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		BirdsProductListPage birdsProductListPage = homePage.clickBirdImageLink();
		FinchItemListPage finchItemListPage = birdsProductListPage.clickFinchItemListLink();
		AdultMaleFinchItemPage adultMaleFinchItemPage = finchItemListPage.clickAdultMaleFinchItemLink();
		assertTrue(Utility.stringCompareRemoveAllWhiteSpaces(adultMaleFinchItemPage.getItemNameText(), birdItemName));
	}
	
	@Test
	public void verifySearch() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		homePage.setSearchFieldString(searchString);
		ManxSearchResultsPage manxSearchResultsPage = homePage.clickSearchButton();
		ManxItemListPage manxItemListPage = manxSearchResultsPage.clickManxItemListLink();
		assertTrue(manxItemListPage.manxHeaderExists());
	}
	
	@Test 
	public void verifyAddAndRemove() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		
		// add to cart through item list page
		FishProductListPage fishProductListPage = homePage.clickSideBarFishLink();
		TigerSharkItemListPage tigerSharkItemListPage = fishProductListPage.clickTigerSharkItemLink();
		ShoppingCartPage shoppingCartPage = tigerSharkItemListPage.clickAddToCartButton();
		assertTrue(toothlessTigerSharkProductID.compareTo(shoppingCartPage.getToothlessTigerSharkProductIDString()) == 0);
			
		// add to cart through item page
		DogsProductListPage dogsProductListPage = shoppingCartPage.clickTopBarDogLink();
		BulldogItemListPage bulldogItemListPage = dogsProductListPage.clickBulldogItemListLink();
		MaleAdultBulldogItemPage maleAdultBulldogItemPage = bulldogItemListPage.clickMaleAdultBulldogItemLink();
		shoppingCartPage = maleAdultBulldogItemPage.clickAddToCartButton();
		assertTrue(maleAdultBulldogProductID.compareTo(shoppingCartPage.getMaleAdultBulldogProductIDString()) == 0);
		
		// remove items in cart
		shoppingCartPage = shoppingCartPage.clickToothlessTigerSharkRemoveButton();
		shoppingCartPage = shoppingCartPage.clickMaleAdultBulldogRemoveButton();
		assertTrue(shoppingCartPage.emptyCartMessageExists());
	}
	
	@Test 
	public void verifyItemQuantityUpdate() {
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		ReptilesProductListPage reptilesProductListPage = homePage.clickReptileImageLink();
		IguanaItemListPage iguanaItemListPage = reptilesProductListPage.clickIguanaItemListLink();
		ShoppingCartPage shoppingCartPage = iguanaItemListPage.clickAddToCartButton();
		shoppingCartPage.setGreenAdultIguanaQuantityInputField(greenAdultIguanaQuantity);
		shoppingCartPage.clickUpdateCartButton();
		assertTrue(shoppingCartPage.getSubTotalElementString().contains(cartSubTotal));
		
		// empty the cart
		shoppingCartPage.clickRemoveFirstRowButton();
	}
	
	@Test (dependsOnMethods = { "verifySignup" })
	public void verifyOrder() {
		// must sign in to go to checkout
		driver.get(homePageURL);
		HomePage homePage = new HomePage(driver);
		SignInPage signInPage = homePage.clickSignInButton();
		signInPage.setUsernameField(generatedUsername);
		signInPage.clearPasswordField();
		signInPage.setPasswordField(password);
		homePage = signInPage.clickLoginButton();
		
		// check values in the order confirmation page
		BirdsProductListPage birdsProductListPage = homePage.clickBirdImageLink();
		FinchItemListPage finchItemListPage = birdsProductListPage.clickFinchItemListLink();
		ShoppingCartPage shoppingCartPage = finchItemListPage.clickAddToCartButton();
		NewOrderFormPage newOrderFormPage = shoppingCartPage.clickProceedToCheckoutButton();
		OrderConfirmPage orderConfirmPage = newOrderFormPage.clickContinueButton();

		assertTrue(orderConfirmPage.getFirstNameBillingString().compareToIgnoreCase(firstName) == 0);
		assertTrue(orderConfirmPage.getLastNameBillingString().compareToIgnoreCase(lastName) == 0);
		assertTrue(orderConfirmPage.getAddress1BillingString().compareToIgnoreCase(address1) == 0);
		assertTrue(orderConfirmPage.getAddress2BillingString().compareToIgnoreCase(address2) == 0);
		assertTrue(orderConfirmPage.getCityBillingString().compareToIgnoreCase(city) == 0);
		assertTrue(orderConfirmPage.getStateBillingString().compareToIgnoreCase(state) == 0);
		assertTrue(orderConfirmPage.getZipBillingString().compareToIgnoreCase(zipCode) == 0);
		assertTrue(orderConfirmPage.getCountryBillingString().compareToIgnoreCase(country) == 0);
		assertTrue(orderConfirmPage.getFirstNameShippingString().compareToIgnoreCase(firstName) == 0);
		assertTrue(orderConfirmPage.getLastNameShippingString().compareToIgnoreCase(lastName) == 0);
		assertTrue(orderConfirmPage.getAddress1ShippingString().compareToIgnoreCase(address1) == 0);
		assertTrue(orderConfirmPage.getAddress2ShippingString().compareToIgnoreCase(address2) == 0);
		assertTrue(orderConfirmPage.getCityShippingString().compareToIgnoreCase(city) == 0);
		assertTrue(orderConfirmPage.getStateShippingString().compareToIgnoreCase(state) == 0);
		assertTrue(orderConfirmPage.getZipShippingString().compareToIgnoreCase(zipCode) == 0);
		assertTrue(orderConfirmPage.getCountryShippingString().compareToIgnoreCase(country) == 0);
				
		OrderSubmittedPage orderSubmittedPage = orderConfirmPage.clickConfirmButton();
				
		// check values in the order submitted page
		assertTrue(orderSubmittedPage.getCardTypeString().compareToIgnoreCase(cardType) == 0);
		assertTrue(orderSubmittedPage.getCardNumberString().contains(cardNumber));
		assertTrue(orderSubmittedPage.getExpiryDateString().compareTo(expiryDate) == 0);
		assertTrue(orderSubmittedPage.getFirstNameBillingString().compareToIgnoreCase(firstName) == 0);
		assertTrue(orderSubmittedPage.getLastNameBillingString().compareToIgnoreCase(lastName) == 0);
		assertTrue(orderSubmittedPage.getAddress1BillingString().compareToIgnoreCase(address1) == 0);
		assertTrue(orderSubmittedPage.getAddress2BillingString().compareToIgnoreCase(address2) == 0);
		assertTrue(orderSubmittedPage.getCityBillingString().compareToIgnoreCase(city) == 0);
		assertTrue(orderSubmittedPage.getStateBillingString().compareToIgnoreCase(state) == 0);
		assertTrue(orderSubmittedPage.getZipBillingString().compareToIgnoreCase(zipCode) == 0);
		assertTrue(orderSubmittedPage.getCountryBillingString().compareToIgnoreCase(country) == 0);
		assertTrue(orderSubmittedPage.getFirstNameShippingString().compareToIgnoreCase(firstName) == 0);
		assertTrue(orderSubmittedPage.getLastNameShippingString().compareToIgnoreCase(lastName) == 0);
		assertTrue(orderSubmittedPage.getAddress1ShippingString().compareToIgnoreCase(address1) == 0);
		assertTrue(orderSubmittedPage.getAddress2ShippingString().compareToIgnoreCase(address2) == 0);
		assertTrue(orderSubmittedPage.getCityShippingString().compareToIgnoreCase(city) == 0);
		assertTrue(orderSubmittedPage.getStateShippingString().compareToIgnoreCase(state) == 0);
		assertTrue(orderSubmittedPage.getZipShippingString().compareToIgnoreCase(zipCode) == 0);
		assertTrue(orderSubmittedPage.getCountryShippingString().compareToIgnoreCase(country) == 0);
		assertTrue(orderSubmittedPage.getItemIDString().compareToIgnoreCase(itemID) == 0);
		assertTrue(Utility.stringCompareRemoveAllWhiteSpaces(orderSubmittedPage.getDescriptionString(), description));
		assertTrue(orderSubmittedPage.getQuantityString().compareTo(quantity) == 0);
		assertTrue(orderSubmittedPage.getPriceString().compareTo(price) == 0);
		assertTrue(orderSubmittedPage.getTotalCostString().compareTo(totalCost) == 0);
		assertTrue(orderSubmittedPage.getTotalString().compareTo(total) == 0);
		
		// sign out
		orderSubmittedPage.clickSignoutButton();
	}

	@AfterTest
	public void cleanup() {
		driver.quit();
	}

}
