package com.crm.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.util.TestBase;

public class LoginPage extends TestBase {
	// PageFactory - OR

		@FindBy(name = "username")
		WebElement username;

		@FindBy(name = "password")
		WebElement password;

		@FindBy(xpath = "//input[@type = 'submit' and @value = 'Login']")
		WebElement login;

		@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
		WebElement signUp;

		@FindBy(xpath = "//img[contains(@src,'https://classic.freecrm.com/img/logo.png')]")
		WebElement logoImg;

		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		// Actions
		public String validateLoginPageTitle() {
			return driver.getTitle();
		}

		public boolean validateCRMImg() {
			return logoImg.isDisplayed();
		}

		public HomePage login(String usn, String pwd) {
			username.sendKeys(usn);
			password.sendKeys(pwd);
			login.click();

			return new HomePage();
		}

}
