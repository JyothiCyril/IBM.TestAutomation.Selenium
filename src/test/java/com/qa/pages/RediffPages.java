package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RediffPages {
	
	WebDriver driver;
	
	
	@FindBy(linkText="Sign in")
	WebElement SignInLink;
	
	public WebElement getSignInLink() {
		return SignInLink;
	}
	
	@FindBy(id="login1")
	WebElement UserNameTextField;
	
	public WebElement getUserNameTextField() {
		return UserNameTextField;
	}
	
	
	@FindBy(id="password")
	WebElement PwdTextField;
	
	public WebElement getPwdTextField() {
		return PwdTextField;
	}
	
	@FindBy(name="remember")
	WebElement SigInCheckBox;
	
	public WebElement getSigInCheckBox() {
		return SigInCheckBox;
	}
	
	
	@FindBy(name="proceed")
	WebElement SignInBtn;
	
	public WebElement getSignInBtn() {
		return SignInBtn;
	}
	
	
	public RediffPages(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

}
