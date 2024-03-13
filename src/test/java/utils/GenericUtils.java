package utils;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GenericUtils {
	
	public WebDriver driver;
	
	public GenericUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public void SwitchWindowToChild() {
	    
	    Set<String> s1 = driver.getWindowHandles();   //set of windows
	    Iterator<String> i1 = s1.iterator();	//set of windows id's
	    String parentWindow = i1.next();	//retrieve parent window id
	    String childWindow = i1.next();		//retrieve child window id
	    
	    driver.switchTo().window(childWindow);	//switch to the window id given
		
	}

}
