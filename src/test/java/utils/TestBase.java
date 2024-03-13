package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
//		if(browser_maven!=null) {
//			browser = browser_maven;
//		}else browser = browser_properties;
		
		//result = testCondition ? value1 : value2
		String browser = browser_maven!=null ? browser_maven : browser_properties;		
		
		if(driver == null) {
			
			if(browser.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\chromedriver.exe");
			    driver = new ChromeDriver();
			    driver.manage().window().maximize();
			}
			if(browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver", "C:\\Users\\XYZ\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			    driver = new EdgeDriver();
			    driver.manage().window().maximize();
			}

		    driver.get(url);
		}
		
	    return driver;
	}

}
