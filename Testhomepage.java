package LumaProject;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Testhomepage {

	public static void main(String[] args) {
		WebDriver driver;

	    @BeforeAll
	    public static void setUp() {
	        System.setProperty("webdriver.chrome.driver", "D:\\Testing\\chomedriver-win64");
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
	    public void testHomePageLoadsSuccessfully() {
	        String expectedUrl = "https://magento.softwaretestingboard.com/";
	        String actualUrl = driver.getCurrentUrl();
	        assertTrue(actualUrl.equals(expectedUrl), ("Homepage failed to load successfully");
	    }

	    @Test
	    public void testMainNavigationLinksClickable() {
	        String[] navigationLinks = {"Home", "Products", "Categories"};
	        for (String linkText : navigationLinks) {
	            WebElement link = driver.findElement(By.linkText("https://magento.softwaretestingboard.com/women.html"));
	            assertTrue(link.isDisplayed() && link.isEnabled(), linkText + " link is not clickable");
	            link.click();
	            assertTrue(driver.getCurrentUrl().contains(linkText.toLowerCase()), "Failed to navigate to " + linkText + " page");
	            driver.navigate().back();
	        }
	    }

	    @Test
	    public void testFeaturedProductsDisplayed() {
	        List<WebElement> featuredProducts = driver.findElements(By.className("featured-product"));
	        assertTrue(featuredProducts.size() > 0, ("No featured products displayed on the homepage");
	    }

	    @Test
	    public void testSearchBarFunctional() {
	        String searchQuery = "Kurta";
	        WebElement searchBar = driver.findElement(By.id("search"));
	        searchBar.sendKeys(searchQuery);
	        searchBar.submit();
	        assertTrue(driver.getCurrentUrl().contains("search=" + searchQuery), "Search bar is not functional");
	    }
	}

	}

