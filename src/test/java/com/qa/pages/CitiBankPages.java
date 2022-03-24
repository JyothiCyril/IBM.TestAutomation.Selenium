package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CitiBankPages {

	WebDriver driver;
	
	
	
	@FindBy(linkText="CITIGROUP.COM")
	WebElement CitiGroupLink;
	
	public WebElement getCitiGroupLink() {
		return CitiGroupLink;
	}
	
	
	@FindBy(linkText="TERMS AND CONDITIONS")
	WebElement TandCLink;
	
	public WebElement getTandCLink() {
		return TandCLink;
	}
	
	
	
	public CitiBankPages(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
	
}
