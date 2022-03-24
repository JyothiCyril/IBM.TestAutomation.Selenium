package com.qa.testscripts;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

public class TC_ScreenshotDemo extends TestBase{


	@Test
	public void screenshoByElement() throws IOException {
		File src = AmazonOR.getAmazonLogo().getScreenshotAs(OutputType.FILE);

		String Dest = System.getProperty("user.dir")+"/Screenshots/"+ "Logo.png";

		File Target = new File(Dest);

		FileUtils.copyFile(src, Target);

	}

	@Test
	public void screenshotDriver() throws IOException {


		TakesScreenshot ts = (TakesScreenshot) driver;

		File src = ts.getScreenshotAs(OutputType.FILE);
		String Dest = System.getProperty("user.dir")+"/Screenshots/"+ "Driver.png";

		File Target = new File(Dest);
		FileUtils.copyFile(src, Target);
	}

}
