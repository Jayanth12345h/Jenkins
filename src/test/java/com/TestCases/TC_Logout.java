package com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Logout extends TC_Login {

	@Test // (dependsOnMethods = {"TC_Login.login"})
	public void verify_logout() {
		WebElement signup = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
		signup.click();
		WebElement loginemail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		loginemail.sendKeys("harshajay446@gmail.com");

		WebElement loginpassword = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
		loginpassword.sendKeys("jay@123");

		WebElement loginbtn = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
		loginbtn.click();

		WebElement loggedinmsg = driver.findElement(
				By.xpath("//li[.//*[contains(., 'Logged in as')] or contains(normalize-space(.), 'Logged in as')]"));
		Assert.assertTrue(loggedinmsg.isDisplayed(), " Logged in as not displayed");
		System.out.println(loggedinmsg.getText());
		WebElement logout = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
		logout.click();
	}
}
