package com.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


@Test

public class TC_SearchProduct extends BaseClass {

	public void verify_searchproduct_functionality() throws InterruptedException {
		WebElement searchproducts = driver.findElement(By.xpath("//a[@href='/products']"));
		searchproducts.click();

		driver.findElement(By.id("search_product")).sendKeys("tshirts");
		Thread.sleep(5000);
		driver.findElement(By.id("submit_search")).click();

		WebElement searchedproducts = driver.findElement(By.xpath("//h2[normalize-space()='Searched Products']"));

		Assert.assertTrue(searchedproducts.isDisplayed(), "serached product title is not displayed");

	}

}
