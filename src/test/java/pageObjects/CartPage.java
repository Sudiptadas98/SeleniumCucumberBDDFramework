package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

	public WebDriver driver;
	
	public CartPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By productName = By.xpath("//p[@class='product-name']");
	By promoBtn = By.xpath("//button[@class='promoBtn']");
	By placeOrder = By.xpath("//button[text()='Place Order']");
	
	public String getProductName() {
		
		return driver.findElement(productName).getText();
	}
	
	public boolean verifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();
	}
	
	public boolean verifyPlaceOrderBtn() {
		return driver.findElement(placeOrder).isDisplayed();
	}
}
