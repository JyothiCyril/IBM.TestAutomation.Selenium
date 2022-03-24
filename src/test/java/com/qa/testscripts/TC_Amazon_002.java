package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.qa.pages.AmazonPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Amazon_002 {

	/*
	Test Scenario:
	-------------

		1. Open the browser
		2. Enter the amazon URL
		3. Select Books as Category
		4. Enter / Type Da vinci code in search text field
		5. Click the magnifier button
		6. Check if all the elements related to search item are loaded
		7. Close the browser
		
		*/
	
//	public static void main(String[] args) throws InterruptedException {
	
	@Test
	public void searchItem() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		AmazonPages AmazonOR = new AmazonPages(driver);
		
		driver.get("https://www.amazon.in/");
		// static code : Test Object description is hard coded
		
		/*
		WebElement Category = driver.findElement(By.id("searchDropdownBox"));
		Select cat = new Select(Category);
		cat.selectByVisibleText("Books");		
		
		Thread.sleep(3000);		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Da vinci code");
		Thread.sleep(3000);
		driver.findElement(By.id("nav-search-submit-button")).click();
		Thread.sleep(3000);
		*/
		
		// Dynamic code : using Page Object Model, where the test object description is fetched 
		// from pages / Object Repository.
		
		AmazonOR.getCategory().selectByVisibleText("Books");
		AmazonOR.getSearchTxtField().sendKeys("Da vinci code");
		AmazonOR.getMagnifierBtn().click();
		Thread.sleep(3000);	
		boolean contains = driver.getTitle().contains("Da vinci code");
		
		if(contains) {
			Reporter.log("Title has the search term",true);
		}else {
			Reporter.log("Title doesn't have the search term",true);
		}
		Thread.sleep(3000);	
		List<WebElement> allItems = AmazonOR.getAllItems();
		System.out.println("Total no. of items are : " + allItems.size());
		
		for(WebElement item:allItems) {
			Reporter.log(item.getText(),true);
		}
		Thread.sleep(3000);	
		
		driver.close();
	}

}
