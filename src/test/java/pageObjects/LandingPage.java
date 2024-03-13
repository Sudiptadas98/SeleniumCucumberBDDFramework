package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By search = By.xpath("//input[@type='search']");
	By productName = By.xpath("//h4[@class='product-name']");
	By topDeals = By.xpath("//a[@href='#/offers']");
	By addButton = By.xpath("//a[@class='increment']");
	By addToCartButton = By.xpath("//button[text() = 'ADD TO CART']");
	By clickCartButton = By.xpath("//a[@class='cart-icon']");
	By proceedToCheckoutbtn = By.xpath("//button[text()='PROCEED TO CHECKOUT']");

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName() {
		
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDeals() {
		driver.findElement(topDeals).click();
	}
	
	public void clickAddButton(Integer count) throws InterruptedException {
		for(int i=0; i<count; i++) {
			driver.findElement(addButton).click();
			
			Thread.sleep(500);
		}
	}
	
	public void clickOnAddToCartButton() {
		driver.findElement(addToCartButton).click();
	}
	
	public void proccedToCheckout() throws InterruptedException {
		driver.findElement(clickCartButton).click();
		Thread.sleep(500);
		driver.findElement(proceedToCheckoutbtn).click();
	}
}
