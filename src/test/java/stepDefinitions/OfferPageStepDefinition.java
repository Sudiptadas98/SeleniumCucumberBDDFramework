package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	
//	public WebDriver driver;
//	public String productShortName;
//	public String landproductName;
	public String ofProductName;
	TestContextSetup testContextSetup;
	
	public OfferPageStepDefinition(TestContextSetup testContextSetup) {
		
		this.testContextSetup = testContextSetup;
	}
	
	@Then("User search for same shortname in offers page")
	public void user_search_for_same_shortname_in_offers_page() throws InterruptedException {
		
		switchToOffersPage();
		//OfferPage offerPage = new OfferPage(testContextSetup.driver);
		OfferPage offerPage = testContextSetup.pageObjectManager.getOfferPage();
		offerPage.searchItem(testContextSetup.productShortName);
	    //testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(testContextSetup.productShortName);
	    Thread.sleep(2000);
	    ofProductName = offerPage.getOfProductName();
	    
	}
	
	@Then("Validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	    
	    Assert.assertEquals(ofProductName, testContextSetup.landproductName);
	}
	
	public void switchToOffersPage() {
		
//		testContextSetup.driver.findElement(By.xpath("//a[@href='#/offers']")).click();
		
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDeals();
	    
//	    Set<String> s1 = testContextSetup.driver.getWindowHandles();
//	    Iterator<String> i1 = s1.iterator();
//	    String parentWindow = i1.next();
//	    String childWindow = i1.next();
//	    testContextSetup.driver.switchTo().window(childWindow);
		
		testContextSetup.genericUtils.SwitchWindowToChild();
		
	}

}
