package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	@FindBy(name = "username")
	WebElement username;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(xpath = "//button[normalize-space()='Login']")
	WebElement loginbtn;

	@FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
	WebElement dropdownmenu;

	@FindBy(xpath = "//a[text()='Logout']")
	WebElement logoutbtn;

	@FindBy(xpath = "//input[@name='username']/ancestor::div[contains(@class,'oxd-input-group')]//span[text()='Required']")
	WebElement usernameerrormsg;

	@FindBy(xpath = "//input[@name='password']/ancestor::div[contains(@class, 'oxd-input-group')]//span[text()='Required']")
	WebElement passworderrormsg;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterusername(String user) {
		username.sendKeys(user);
	}

	public void enterpassword(String pass) {
		password.sendKeys(pass);
	}

	public void clickonlogin() {
		loginbtn.click();
	}

	public void clickonmenu() {
		dropdownmenu.click();
	}

	public void clickonlogout() {
		logoutbtn.click();
	}

	public boolean username_errormsgdisplayed() {
		return usernameerrormsg.isDisplayed();
	}

	public boolean password_errormsgdisplayed() {
		return passworderrormsg.isDisplayed();
	}

}
