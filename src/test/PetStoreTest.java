package test;

import org.testng.annotations.Test;

import pomClasses.HomePage;
import pomClasses.RegisterPage;
import pomClasses.SignInPage;

import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertFalse;
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
	
	// this test needs to run first since other tests are dependent on the account being created
	// the syntax is @Test (dependsOnMethods = { "verifySignup" })
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
	    assertTrue(homePage.myAccountButtonExists());
	}
	
	@Test
	public void verifyBrowsing() {
		
	}
	
	@Test
	public void verifySearch() {
		
	}
	
	@Test
	public void verifyAddAndRemove() {
		
	}
	
	@Test
	public void verifyItemQuantityUpdate() {
		
	}
	
	@Test void verifyOrder() {
		
	}

	@AfterTest
	public void cleanup() {
		driver.quit();
	}

}
