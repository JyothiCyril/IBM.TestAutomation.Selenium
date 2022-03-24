package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_005 extends TestBase{

	@Test(priority=1,groups="UI test")
	public void footerLinks() {
		
		List<WebElement> AllLinks = AmazonOR.getfooterLinks();
		
		int size = AllLinks.size();
		Assert.assertEquals(size,52);
		
		
		
		
	}
	
	@Test(priority=2,dependsOnMethods="footerLinks",groups="UI test")
	public void getLinkNames() {

		List<WebElement> AllLinks = AmazonOR.getfooterLinks();
		for(WebElement link:AllLinks) {
			Reporter.log(link.getText(),true);
		}
	}
	
}
