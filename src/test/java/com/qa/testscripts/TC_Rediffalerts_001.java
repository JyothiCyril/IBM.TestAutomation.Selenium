package com.qa.testscripts;

import org.openqa.selenium.Alert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TC_Rediffalerts_001 extends TestBase {
	
	@Test
	public void Loginaction() throws InterruptedException {
		
		RediffOR.getSignInLink().click();
		
		boolean contains = driver.getCurrentUrl().contains("login");
		if(contains) {
			Reporter.log("User is on Login Page",true);
			
			boolean enabled = RediffOR.getSignInBtn().isEnabled();
			if(enabled) {
				RediffOR.getSignInBtn().click(); // trigger the pop window
				// write the code to handle the pop up
				Thread.sleep(3000);
				Alert alert = driver.switchTo().alert();
				Reporter.log(alert.getText(),true);
				alert.accept();
				Thread.sleep(3000);
			}
			
			RediffOR.getUserNameTextField().sendKeys(Prop.getProperty("Uname"));
			RediffOR.getPwdTextField().sendKeys(Prop.getProperty("Pwd"));
			
			boolean selected = RediffOR.getSigInCheckBox().isSelected();
			if(selected) {
				Reporter.log("The check box is selected by Default", true);
				RediffOR.getSigInCheckBox().click();
				Thread.sleep(3000);
			}
			
		}
		
	}

}
