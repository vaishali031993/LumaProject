package LumaProject;

import static org.testng.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Producttesting {


WebDriver driver;

@Before
public static void setUp() {
    System.setProperty("webdriver.chrome.driver", "D:\\Testing\\chromedriver-win64");
}

@Before
public void initializeDriver() {
    driver = new ChromeDriver();
    driver.get("https://magento.softwaretestingboard.com/"); // Navigate to the homepage
}

@After
public void tearDown() {
    driver.quit();
}

@Test
public void testProductDetailsPageNavigation() {
    HomePage homePage = new HomePage(driver);
    ProductDetailsPage productDetailsPage = homePage.clickOnProduct(); 
    assertTrue(productDetailsPage.isProductDetailsPageDisplayed());
}

@Test
public void testProductDetailsDisplayedCorrectly() {
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    assertTrue(productDetailsPage.areProductDetailsDisplayedCorrectly());
}

@Test
public void testProductImageZoom() {
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    assertTrue(productDetailsPage.isProductImageZoomable());
}

@Test
public void testAddToCartButtonFunctionality() {
    ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);
    productDetailsPage.clickAddToCartButton();
    assertTrue(productDetailsPage.isProductAddedToCart());
}
}