package com.qa.testscripts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_DemoFrames_001 extends TestBase{


	@Test(priority=1,enabled=false)
	public void framesByIndex() {
		List<WebElement> AllFrames = driver.findElements(By.tagName("frame"));

		int size = AllFrames.size();
		for(int i=0 ; i<size ;i++) {
			WebDriver frame = driver.switchTo().frame(i);
			System.out.println(frame.getTitle());
			int links = frame.findElements(By.tagName("a")).size();			
			System.out.println("Count of hyperlinks present on frame " +i + " are : " + links);
			driver.switchTo().defaultContent();
		}

	}

	@Test(priority=2,enabled=false)
	public void frameByName() throws InterruptedException {

		WebDriver frame = driver.switchTo().frame("packageListFrame");
		System.out.println(frame.getTitle());

		List<WebElement> AllLinks = frame.findElements(By.tagName("a"));
		System.out.println("Count of hyperlinks present on the frame are : " + AllLinks.size());
		for(WebElement link:AllLinks) {
			System.out.println(link.getText());
		}
		WebElement awtLink = frame.findElement(By.linkText("java.awt"));
		boolean displayed = awtLink.isDisplayed();
		if(displayed) {
			System.out.println("Element is present on the frame");
			awtLink.click();
			Thread.sleep(5000);
		}
		driver.switchTo().defaultContent();
	}

	@Test(priority=3)
	public void frameByElement() throws InterruptedException {

		WebElement ele = driver.findElement(By.xpath("//frame[@src='allclasses-frame.html']"));

		WebDriver frame = driver.switchTo().frame(ele);
		System.out.println(frame.getTitle());

		List<WebElement> AllLinks = frame.findElements(By.tagName("a"));
		System.out.println("Count of hyperlinks present on the frame are : " + AllLinks.size());
		
		
		frame.findElement(By.linkText("Applet")).click();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
	}

}
