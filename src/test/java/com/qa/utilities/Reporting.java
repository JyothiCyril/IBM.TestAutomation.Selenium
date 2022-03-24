package com.qa.utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlReport;
	public ExtentReports xReports;
	public ExtentTest xTest;
	
	// LoC to configure the extent report.
	// Create a new HTML report on every test execution triggered by testng.xml
	// HTML file should be stored in th reports folder.
	 
	  public void onStart(ITestContext testContext) {
	    
		  String dateStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		  
		  String repName = "Test-Automation-Report-" + dateStamp+ ".html";
		  
		  htmlReport = new ExtentHtmlReporter(System.getProperty("user.dir")+"/Reports/"+repName);
		  htmlReport.config().setDocumentTitle("Automation Test Report");
		  htmlReport.config().setReportName("Functional Testing");
		  htmlReport.config().setTheme(Theme.DARK);
		  htmlReport.config().setAutoCreateRelativePathMedia(true);
	  
		  xReports = new ExtentReports();
		  xReports.attachReporter(htmlReport);
		  xReports.setSystemInfo("QA Name", "JyothiCyril");
		  xReports.setSystemInfo("hostName", "localhost");
		  xReports.setSystemInfo("OS", "Windows");
		  
	  
	  }

	  
	  public void onFinish(ITestContext testContext) {	  
		  
		  xReports.flush();
		  
	  }
	
	
	

	 
	  public void onTestSuccess(ITestResult tr) {
		  
		  xTest = xReports.createTest(tr.getName());
		  xTest.log(Status.PASS, "Test is passed");
		  xTest.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	   
	  }

	  
	  public void onTestFailure(ITestResult tr) {
	    
		  xTest = xReports.createTest(tr.getName());
		  xTest.log(Status.FAIL, "Test is failed");
		  xTest.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		  xTest.log(Status.FAIL, tr.getThrowable());
		  
		  String ssPath = System.getProperty("user.dir")+"/Screenshots/"+tr.getName()+".png";
		  File file = new File(ssPath);
		  
		  if(file.exists()) {
			  try {
				xTest.fail("Screenshot for the test failed is : " + xTest.addScreenCaptureFromPath(ssPath));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		  }
	  
	  
	  }

	  
	  public void onTestSkipped(ITestResult tr) {
		  
		  xTest = xReports.createTest(tr.getName());
		  xTest.log(Status.SKIP, "Test is skipped");
		  xTest.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.AMBER));
		  xTest.log(Status.SKIP, tr.getThrowable());
	  
	  }

	
	

}
