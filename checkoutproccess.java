package LumaProject;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class checkoutproccess<HomePage> {

	public static void main(String[] args) {
		
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
	        checkoutPage.reviewOrder();
	        checkoutPage.placeOrder();

	        assertTrue(checkoutPage.isOrderConfirmationPageDisplayed());
	    }
	}

	

}
