package com.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Pages.LoginPage;

public class TC_Login extends BaseClass {

	@Test(priority = 1)
	public void verify_validlogin() throws InterruptedException {
		LoginPage lp = new LoginPage(driver);
		lp.enterusername("Admin");
		lp.enterpassword("admin123");
		lp.clickonlogin();
		Thread.sleep(5000);
		lp.clickonmenu();
		lp.clickonlogout();

	}

	@Test(priority = 2)
	public void verify_Invalidlogin() {
		LoginPage lp = new LoginPage(driver);
		lp.enterusername("admin");
		lp.enterpassword("admin23");
		lp.clickonlogin();
	}

	@Test(priority = 3)
	public void verify_EmptyloginFields() {
		LoginPage lp = new LoginPage(driver);
		lp.enterusername("");
		lp.enterpassword("");
		lp.clickonlogin();

		Assert.assertTrue(lp.username_errormsgdisplayed(), "username required msg not displayed");
		Assert.assertTrue(lp.password_errormsgdisplayed(), "password required msg not displayed");
	}

}
