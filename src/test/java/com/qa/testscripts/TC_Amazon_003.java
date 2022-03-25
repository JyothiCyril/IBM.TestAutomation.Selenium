package com.qa.testscripts;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.qa.utilities.ExcelUtility;

public class TC_Amazon_003 extends TestBase{
	// Search an item in amazon website.
	// code is written using Selenium,java, & testng.

	@Test(priority=2, dataProvider="getData")
	public void searchItem(String Category, String ItemName) throws InterruptedException, IOException {
		SoftAssert sAssert = new SoftAssert();
		AmazonOR.getCategory().selectByVisibleText(Category);
		AmazonOR.getSearchTxtField().clear();
		AmazonOR.getSearchTxtField().sendKeys(ItemName);
		AmazonOR.getMagnifierBtn().click();
		Thread.sleep(3000);	
		boolean contains = driver.getTitle().contains(ItemName);

		if(contains) {
			Reporter.log("Title has the search term",true);
			//Assert.assertTrue(contains);
			sAssert.assertTrue(contains);
		}else {
			Reporter.log("Title doesn't have the search term",true);
			captureScreenshot(driver,"searchItem");
			//Assert.assertTrue(contains);
			sAssert.assertTrue(contains);
		}
		Thread.sleep(3000);	
		List<WebElement> allItems = AmazonOR.getAllItems();
		System.out.println("Total no. of items are : " + allItems.size());

		for(WebElement item:allItems) {
			Reporter.log(item.getText(),true);
		}

		sAssert.assertAll();
	}


	@Test(priority=1, enabled=false)
	public void validateTitle() {
		boolean contains = driver.getTitle().contains("Amazon");

		if(contains) {
			Reporter.log("User is landed on the amazon home page",true);
		}else {
			Reporter.log("user is not landed on the amazon home page",true);
		}
	}

	// source the data / input from an object array to a method declared as @Test
	@DataProvider
	public String[][] getData() throws IOException{

		String xFile = "D:\\Selenium Training\\IBM.TestAutomation.Selenium\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";
		String xSheetName = "Sheet1";


		int rowCount = ExcelUtility.getRowCount(xFile, xSheetName);		
		int cellCount = ExcelUtility.getCellCount(xFile, xSheetName, rowCount);


		String[][] data = new String[rowCount][cellCount];

		for(int i=1; i<=rowCount; i++) {
			for(int j=0; j<cellCount; j++) {
				data[i-1][j] = ExcelUtility.getCellData(xFile, xSheetName, i, j);
			}
		}
		
		return data;

		/*

		Object[][] data = new Object[3][2];

		// category
		data[0][0] = "Books";
		data[1][0] = "Electronics";
		data[2][0] = "Appliances";

		// ItemName
		data[0][1] = "Da Vinci Code";
		data[1][1] = "Mobile phones";
		data[2][1] = "Washing machines";

		return data;
		 */
	}

}
