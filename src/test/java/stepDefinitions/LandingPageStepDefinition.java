package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
//	public WebDriver driver;
//	public String productShortName;
//	public String landproductName;
//	public String ofProductName;
	LandingPage landingPage;
	TestContextSetup testContextSetup;

	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {
//	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\XYZ\\Documents\\chromedriver.exe");
//	    testContextSetup.driver = new ChromeDriver();
//	    testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
//	    testContextSetup.driver.manage().window().maximize();
	}
	
	@When("^User search with shortname (.+) and extracted actual name of product$")
	public void user_search_with_shortname_and_extracted_actual_name_of_product(String shortName) throws InterruptedException {
		testContextSetup.productShortName = shortName;
		
		//LandingPage landingPage = new LandingPage(testContextSetup.driver);
		//LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(shortName);
		//testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
	    Thread.sleep(2000);
	    testContextSetup.landproductName = landingPage.getProductName().split("-")[0].trim();
	    System.out.println(testContextSetup.landproductName + " is extracted from Home page");
	}
	
	@Then("^User add (.+) more items of product and add them to cart$")
	public void user_add_more_items_of_product_and_add_them_to_cart(Integer productCount) throws InterruptedException {
		
		//LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.clickAddButton(productCount);
		
		Thread.sleep(1000);
		landingPage.clickOnAddToCartButton();
	}
	
	@And("Open the cart and proceed to checkout")
	public void Open_the_cart_and_proceed_to_checkout() throws InterruptedException {

		//LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.proccedToCheckout();
	}
	
	
}
