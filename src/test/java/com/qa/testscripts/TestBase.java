package com.qa.testscripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.qa.pages.AmazonPages;
import com.qa.pages.CitiBankPages;
import com.qa.pages.RediffPages;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	WebDriver driver;
	AmazonPages AmazonOR;
	CitiBankPages CitiBankOR;
	RediffPages RediffOR;
	FileInputStream fileLoc;
	Properties Prop;
	
	@Parameters({"Browser","Url"})
	@BeforeClass
	public void setUp(String Browser, String Url) throws IOException {
		
		fileLoc = new FileInputStream("D:\\Selenium Training\\IBM.TestAutomation.Selenium\\src\\test\\java\\com\\qa\\testdata\\credentials.properties");
		Prop = new Properties();
		Prop.load(fileLoc);
		
		if(Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}else if(Browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}else if(Browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}else if(Browser.equalsIgnoreCase("IE")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		AmazonOR = new AmazonPages(driver);
		CitiBankOR = new CitiBankPages(driver);
		RediffOR = new RediffPages(driver);
		driver.get(Url);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS); // Wait max. 20 sec till page gets loaded.
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	
	public void captureScreenshot(WebDriver driver, String tName) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File Target = new File(System.getProperty("user.dir")+"/Screenshots/"+tName+".png");
		FileUtils.copyFile(Source, Target);
	}
	
	
}
