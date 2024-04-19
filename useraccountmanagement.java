package LumaProject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class useraccountmanagement {

	public static void main(String[] args) {
		WebDriver driver;

	    @BeforeAll
	    public static void setUp() {
	        System.setProperty("webdriver.chrome.driver", "D:\\\\Testing\\\\chromedriver-win64");
	    }

	    @BeforeEach
	    public void initializeDriver() {
	        driver = new ChromeDriver();
	        driver.get("https://magento.softwaretestingboard.com/"); 
	    }

	    @AfterEach
	    public void tearDown() {
	        driver.quit();
	    }

	    @Test
	    public void testUserRegistration() {
	        HomePage homePage = new HomePage(driver);
	        RegisterPage registerPage = homePage.navigateToRegisterPage();
	        registerPage.fillRegistrationForm();
	        registerPage.submitRegistrationForm();

	        assertTrue(registerPage.isRegistrationSuccessful());
	    }

	    @Test
	    public void testUserLogin() {
	        HomePage homePage = new HomePage(driver);
	        LoginPage loginPage = homePage.navigateToLoginPage();
	        loginPage.fillLoginForm(); 
	        loginPage.submitLoginForm();

	        assertTrue(loginPage.isUserLoggedIn());
	    }

	    @Test
	    public void testPasswordReset() {
	        HomePage homePage = new HomePage(driver);
	        ForgotPasswordPage forgotPasswordPage = homePage.navigateToForgotPasswordPage();
	        forgotPasswordPage.enterEmailAddress(); 
	        forgotPasswordPage.submitResetRequest();

	        assertTrue(forgotPasswordPage.isResetPasswordEmailSent());
	    }

	    @Test
	    public void testProfileInformationUpdate() {
	        HomePage homePage = new HomePage(driver);
	        LoginPage loginPage = homePage.navigateToLoginPage();
	        loginPage.fillLoginForm(); 
	        loginPage.submitLoginForm();

	        assertTrue(loginPage.isUserLoggedIn());

	        ProfilePage profilePage = homePage.navigateToProfilePage();
	        profilePage.updateProfileInformation(); 
	        profilePage.saveProfileChanges();

	        assertTrue(profilePage.isProfileInformationUpdated());
	    }
	}

	
