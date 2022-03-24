package com.qa.testscripts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Amazon_004 extends TestBase{

	@Test(groups="UI test")
	public void newUserReg() {

		Actions act = new Actions(driver);

		WebElement ele = AmazonOR.getAccountsandLists();		
		act.moveToElement(ele).build().perform();

		AmazonOR.getstarthereLink().click();
		
		WebDriverWait expWait = new WebDriverWait(driver,40); // 40		
		expWait.until(ExpectedConditions.titleContains("Registration")); // title is generated in 20 sec, other 20 sec will be skipped
		
		String title = driver.getTitle();
		Reporter.log(title,true);
		Assert.assertEquals(title, "Registration");
		
		/*
		boolean contains = driver.getTitle().contains("Registration");

		if(contains) {
			Reporter.log("User is landed on the registration page");
		}else {
			Reporter.log("User is landed on the registration page");
		}*/


	}

}
