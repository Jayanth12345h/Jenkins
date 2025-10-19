package com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TC_Login extends BaseClass {

	@Test
	public void login() {
		WebElement signup = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
		signup.click();
		WebElement loginemail = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
		loginemail.sendKeys("harshajay446#gmail.com");
		
		
		
	}

}
