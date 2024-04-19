package LumaProject;

import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class shoppingcart {

	public static void main(String[] args) {
		WebDriver driver;

	    @Before
	    public static void setUp() {
	        System.setProperty("webdriver.chrome.driver", "D:\\\\Testing\\\\chromedriver-win64");
	    }

	    @Before
	    public void initializeDriver() {
	        driver = new ChromeDriver();
	        driver.get("https://magento.softwaretestingboard.com/"); 
	    }

	    @After
	    public void tearDown() {
	        driver.quit();
	    }

	    @Test
	    public void testViewCartContents() {
	        HomePage homePage = new HomePage(driver);
	        ShoppingCartPage cartPage = homePage.clickViewCart(); // Assuming there is a method to click on the cart icon
	        assertTrue(cartPage.areCartContentsDisplayed());
	    }

	    @Test
	    public void testAddProductToCart() {
	        HomePage homePage = new HomePage(driver);
	        homePage.addProductToCart(); // Assuming there is a method to add a product to the cart
	        assertTrue(homePage.isProductAddedToCart());
	    }

	    @Test
	    public void testRemoveProductFromCart() {
	        HomePage homePage = new HomePage(driver);
	        homePage.addProductToCart();
	        ShoppingCartPage cartPage = homePage.clickViewCart();
	        cartPage.removeProductFromCart(); // Assuming there is a method to remove a product from the cart
	        assertTrue(cartPage.isProductRemovedFromCart());
	    }

	    @Test
	    public void testUpdateProductQuantityInCart() {
	        HomePage homePage = new HomePage(driver);
	        homePage.addProductToCart();
	        ShoppingCartPage cartPage = homePage.clickViewCart();
	        cartPage.updateProductQuantityInCart(); // Assuming there is a method to update product quantity in the cart
	        assertTrue(cartPage.isProductQuantityUpdated());
	    }

	    @Test
	    public void testTotalPriceCalculation() {
	        HomePage homePage = new HomePage(driver);
	        homePage.addProductToCart();
	        ShoppingCartPage cartPage = homePage.clickViewCart();
	        assertTrue(cartPage.isTotalPriceCalculatedCorrectly());
	    }

	    @Test
	    public void testInitiateCheckoutFromCart() {
	        HomePage homePage = new HomePage(driver);
	        ShoppingCartPage cartPage = homePage.clickViewCart();
	        CheckoutPage checkoutPage = cartPage.initiateCheckout(); // Assuming there is a method to initiate checkout
	        assertTrue(checkoutPage.isCheckoutPageDisplayed());
	    }
	}

	}

}
