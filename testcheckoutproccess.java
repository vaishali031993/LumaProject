package LumaProject;

import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testcheckoutproccess {

	public static <HomePage, ShoppingCartPage, CheckoutPage> void main(String[] args) {
		WebDriver driver;

	    @BeforeClass
	    public static void setUp() {
	        System.setProperty("webdriver.chrome.driver", "D:\\Testing\\chromedriver-win64");
	    }

	    @BeforeMethod
	    public void initializeDriver() {
	        driver = new ChromeDriver();
	        driver.get("https://magento.softwaretestingboard.com/");
	        
	    }

	    @After
	    public void tearDown() {
	        driver.quit();
	    }

	    @Test
	    public void testCheckoutProcessSteps() {
	        HomePage homePage = new HomePage(driver);
	        ShoppingCartPage cartPage = homePage.clickViewCart();
	        CheckoutPage checkoutPage = cartPage.initiateCheckout();

	        assertTrue(checkoutPage.isShippingAddressStepDisplayed());
	        checkoutPage.enterShippingAddressDetails(); 
	        checkoutPage.proceedToNextStep();

	        assertTrue(checkoutPage.isPaymentMethodStepDisplayed());
	        checkoutPage.selectPaymentMethod(); 
	        checkoutPage.proceedToNextStep();

	        assertTrue(checkoutPage.isOrderReviewStepDisplayed());
	        checkoutPage.reviewOrder(); // 
	        checkoutPage.placeOrder();

	        assertTrue(checkoutPage.isOrderConfirmationPageDisplayed());
	    }

	    @Test
	    public void testIncompleteInformationErrorMessage() {
	        HomePage homePage = new HomePage(driver);
	        ShoppingCartPage cartPage = homePage.clickViewCart();
	        CheckoutPage checkoutPage = cartPage.initiateCheckout();

	        checkoutPage.enterShippingAddressDetails();
	        checkoutPage.proceedToNextStep();

	        
	        assertTrue(checkoutPage.isIncompleteInformationErrorMessageDisplayed());
	    }

	    @Test
	    public void testInvalidInformationErrorMessage() {
	        HomePage homePage = new HomePage(driver);
	        ShoppingCartPage cartPage = homePage.clickViewCart();
	        CheckoutPage checkoutPage = cartPage.initiateCheckout();

	        checkoutPage.enterShippingAddressDetails();
	        checkoutPage.proceedToNextStep();

	        
	        assertTrue(checkoutPage.isInvalidInformationErrorMessageDisplayed());
	    }
	

	}


}
