package LumaProject;

public class searchfunctinality {

	public static void main(String[] args) {
		WebDriver driver;

	    @BeforeAll
	    public static void setUp() {
	        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
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
	    public void testSearchReturnsRelevantResults() {
	        HomePage homePage = new HomePage(driver);
	        SearchResultPage searchResultPage = homePage.searchForQuery("kurta"); 
	        assertTrue(searchResultPage.areSearchResultsDisplayed());
	    }

	    @Test
	    public void testSearchResultsPageDisplaysMatchingProducts() {
	        HomePage homePage = new HomePage(driver);
	        SearchResultPage searchResultPage = homePage.searchForQuery("kurta");  
	        assertTrue(searchResultPage.areMatchingProductsDisplayed("kurta")); 
	    }

	    @Test
	    public void testAdvancedSearchOptionsFunctional() {
	        HomePage homePage = new HomePage(driver);
	        SearchResultPage searchResultPage = homePage.searchForQuery("kurta"); 
	        searchResultPage.applyFilter("price", "asc"); 
	        assertTrue(searchResultPage.isSortingFunctional("500", "asc")); 
	    }
	}

	}


