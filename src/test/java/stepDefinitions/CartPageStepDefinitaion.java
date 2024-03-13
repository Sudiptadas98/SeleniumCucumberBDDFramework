package stepDefinitions;


import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.CartPage;
import utils.TestContextSetup;


public class CartPageStepDefinitaion {

	CartPage cartPage;
	TestContextSetup testContextSetup;
	
	public CartPageStepDefinitaion(TestContextSetup testContextSetup) {
		
		this.testContextSetup = testContextSetup;
		this.cartPage = testContextSetup.pageObjectManager.getCartPage();
	}
	
	@Then("Validate the product name in cart page matches with landing page")
	public void validate_the_product_name_in_cart_page_matches_with_landing_page() {
		
		String CartProductName = cartPage.getProductName().split("-")[0].trim();
		
		Assert.assertEquals(CartProductName, testContextSetup.landproductName);
	}
	
	@And("Verify user has ability to enter promo code and place order")
	public void verify_user_has_ability_to_enter_promo_code_and_place_order() throws InterruptedException {
		Thread.sleep(1000);
		Assert.assertTrue(cartPage.verifyPromoBtn());
		Assert.assertTrue(cartPage.verifyPlaceOrderBtn());
	}
	
}
