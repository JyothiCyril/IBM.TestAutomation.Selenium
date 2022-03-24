package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AmazonPages {
	
	WebDriver driver;
	
	
	@FindBy(id="nav-logo-sprites")
	WebElement AmazonLogo;
	
	public WebElement getAmazonLogo() {
		return AmazonLogo;
	}
	
	@FindBy(linkText="Careers")
	WebElement AmmzonCareersLink;
	
	public WebElement getAmmzonCareersLink() {
		return AmmzonCareersLink;
	}
	
	
	@FindBy(id="searchDropdownBox")
	WebElement Category;
	
	public Select getCategory() {
		Select Cat = new Select(Category);		
		return Cat;
	}
	
	
	@FindBy(id="twotabsearchtextbox")
	WebElement SearchTxtField;
	
	public WebElement getSearchTxtField() {
		return SearchTxtField;
	}
	
	@FindBy(id="nav-search-submit-button")
	WebElement MagnifierBtn;
	
	public WebElement getMagnifierBtn() {
		return MagnifierBtn;
	}
	
	@FindAll(@FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']"))
	List<WebElement> AllItems;
	
	public List<WebElement> getAllItems(){
		return AllItems;
	}
	
	
	@FindBy(id="nav-link-accountList")
	WebElement AccountsandLists;
	
	public WebElement getAccountsandLists() {
		return AccountsandLists;
	}
	
	@FindBy(linkText="Start here.")
	WebElement starthereLink;
	
	public WebElement getstarthereLink() {
		return starthereLink;
	}
	
	
	@FindAll(@FindBy(className="nav_a"))
	List<WebElement> footerLinks;
	
	
	public List<WebElement> getfooterLinks(){
		return footerLinks;
	}
	
	public AmazonPages(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
}

