package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.util.TestBase;

public class HomePage extends TestBase {
	//Page library
	// PageFactory - OR
	@FindBy(xpath = "//td[contains(text(),'Demo User')]")
	WebElement userNameLable;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	//Initialize Page factory
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLable.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		return null;
		
	}
	
	
	

}
