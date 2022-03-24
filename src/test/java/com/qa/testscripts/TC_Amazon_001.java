package com.qa.testscripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_Amazon_001 {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		// Open the browser
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.contains("Amazon")) {
			System.out.println("Amazon page is loaded");
		}
		
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(5000);
		//System.out.println(driver.getPageSource()); // HTML page sources
		
		System.out.println(driver.getWindowHandle()); // window id of the browser instance.
		
		//driver.getWindowHandles(); // window ids of all the browser tab & window at the run session
//		driver.findElement("loator"); // reach the web element present on page using the locator
//		driver.findElements("locator"); // reach the group of element matching a locator
		
		//driver.switchTo().window(""); // switch to a window / tab based on window id
		//driver.switchTo().frame("");  // switch to a frame with the id /name / webelement
		//driver.switchTo().alert(); // switch to alert window
		
		driver.navigate().to("https://www.google.co.in/");
		Thread.sleep(5000);
		driver.navigate().back();
		Thread.sleep(5000);		
		driver.navigate().forward();
		Thread.sleep(5000);
		
		driver.close(); // current browser instance will be closed
	//	driver.quit(); // close all the browser instance , tab / window
	}

}
