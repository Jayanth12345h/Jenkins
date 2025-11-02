package com.TestCases;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC_Spicejet {

	WebDriver driver;

	@Test
	public void spicejetcheck() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.amazon.in/");

		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("mobiles", Keys.ENTER);

		List<WebElement> list = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		System.out.println(list.size());

		String parentId = driver.getWindowHandle();
		System.out.println(parentId + driver.getTitle());

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getText());

		}
		list.get(0).click();
		Set<String> set = driver.getWindowHandles();
		for (String child : set) {
			if (!child.equals(parentId)) {
				driver.switchTo().window(child);
				driver.findElement(By.id("bylineInfo")).click();
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src = ts.getScreenshotAs(OutputType.FILE);
				File targ = new File(".\\Screenshots\\apple.png");
				//FileUtils.copyFile(src, targ);
				//FileUtils.copyFile(src, targ);
				
			}
			
		}
		driver.switchTo().window(parentId);
		
	}

}
