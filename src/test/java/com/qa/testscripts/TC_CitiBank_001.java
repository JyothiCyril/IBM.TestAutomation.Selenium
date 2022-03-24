package com.qa.testscripts;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_CitiBank_001 extends TestBase {
	
	@Test
	public void workingWithWindows() {
		CitiBankOR.getCitiGroupLink().click(); // 2nd window / tab
		CitiBankOR.getTandCLink().click(); // 3rd tab
		
		Set<String> WindID = driver.getWindowHandles();
		Iterator<String> iter = WindID.iterator();
		
		while(iter.hasNext()) {
			String winID = iter.next();
			Reporter.log(winID,true);
			
			WebDriver window = driver.switchTo().window(winID);
			Reporter.log(window.getTitle(),true);
			List<WebElement> Alllinks = window.findElements(By.tagName("a"));
			System.out.println("Count of hyperlinks present on the window "+winID+"  are : " + Alllinks.size());
			
		}
		
	}

}
