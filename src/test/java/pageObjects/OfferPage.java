package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	
	public WebDriver driver;
	
	public OfferPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	By search = By.xpath("//input[@type='search']");
	By productName = By.xpath("//tr/td[1]");
	
	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}
	
	public String getOfProductName() {
		return driver.findElement(productName).getText();
	}

}
