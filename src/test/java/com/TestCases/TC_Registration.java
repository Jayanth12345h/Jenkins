package com.TestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_Registration {

	WebDriver driver;

	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://automationexercise.com/");
		WebElement homeoption = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
		Assert.assertTrue(homeoption.isDisplayed(), "home option is not displayed");
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

	@Test
	public void verify_Registration() {
		WebElement signup = driver.findElement(By.xpath("//a[normalize-space()='Signup / Login']"));
		signup.click();
		WebElement newusersignuptxt = driver.findElement(By.xpath("//h2[text()='New User Signup!']"));
		Assert.assertTrue(newusersignuptxt.isDisplayed(), "newuser signup text is not displayed");

		WebElement name = driver.findElement(By.name("name"));
		name.sendKeys("jayanth");

		WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
		email.sendKeys("harshajay446@gmail.com");

		WebElement signupbtn = driver.findElement(By.xpath("//button[normalize-space()='Signup']"));
		signupbtn.click();

		WebElement enteraccountinfo = driver
				.findElement(By.xpath("//b[normalize-space()='Enter Account Information']"));
		Assert.assertTrue(enteraccountinfo.isDisplayed(), "enter account information is not displayed");

		WebElement gender = driver.findElement(By.id("id_gender1"));
		if (!gender.isSelected()) {
			gender.click();
		}
		WebElement password = driver.findElement(By.id("password"));
		password.clear();
		password.sendKeys("jay@123");

		WebElement day = driver.findElement(By.id("days"));
		Select date = new Select(day);
		date.selectByVisibleText("4");

		WebElement month = driver.findElement(By.id("months"));
		Select select_month = new Select(month);
		select_month.selectByValue("1");

		WebElement year = driver.findElement(By.id("years"));
		Select select_year = new Select(year);
		select_year.selectByIndex(12);

		WebElement newsletter = driver.findElement(By.id("newsletter"));
		if (!newsletter.isSelected()) {
			newsletter.click();
		}
		
		WebElement firstname = driver.findElement(By.id("first_name"));
		firstname.sendKeys("jayanth");
		
		WebElement lastname = driver.findElement(By.id("last_name"));
		lastname.sendKeys("last_name");
		
		WebElement company = driver.findElement(By.id("company"));
		company.sendKeys("Test");
		
		WebElement address1 = driver.findElement(By.id("address1"));
		address1.sendKeys("8-567, hyd");
		
		WebElement countrydropdown = driver.findElement(By.id("country"));
		Select country = new Select(countrydropdown);
		country.selectByVisibleText("India");
		
		WebElement state = driver.findElement(By.id("state"));
		state.sendKeys("Telangana");
		
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Hyderabad");
		
		WebElement zipcode = driver.findElement(By.id("zipcode"));
		zipcode.sendKeys("500089");
		
		WebElement mobilenumber = driver.findElement(By.id("mobile_number"));
		mobilenumber.sendKeys("9876543210");
		
		driver.findElement(By.xpath("//button[normalize-space()='Create Account']")).click();

	}

}
