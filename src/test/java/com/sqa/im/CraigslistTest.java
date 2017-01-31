package com.sqa.im;

import java.io.*;

import org.apache.commons.io.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;

public class CraigslistTest {
	static String baseUrl = "http://sfbay.craigslist.org/";
	static WebDriver driver;
	static int testNum = 0;
	
	public static boolean isElementPresent(By by) {
		try {
			WebElement element = driver.findElement(by);
			return true;
		} catch (Exception e) {
			return false; 
		}
	}

	

	@DataProvider
	public Object[][] dp() {
		return new Object[][] { new Object[] { "qa" }, new Object[] { "automation" }, new Object[] { "qa engineer" },
				new Object[] { "java qa" } };
	}

	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
	}

	public void takeScreenshot(String name) {
		// Takes the screenshot
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Move to Folder Structure
		try {
			FileUtils.copyFile(srcFile, new File("screenshots/" + name + ".png"));
		} catch (IOException e) {
		}
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "dp")
	public void testCraigslist(String keywords) {
		// Use a number count for tests
		this.testNum++;
		// String Title
		System.out.println("Craigslist Test" + this.testNum + ": \"" + keywords + "\"");
		// Go to baseUrl
		this.driver.get(this.baseUrl + "/");
		// Drive the test...
		this.driver.findElement(By.cssSelector("a.jjj > span.txt")).click();
		// Clear search bar field
		this.driver.findElement(By.id("query")).clear();
		// Type the keys into the search field
		this.driver.findElement(By.id("query")).sendKeys(keywords);
		// click submit button
		this.driver.findElement(By.xpath("//button[@type='submit']")).click();
		// Locate WebElement for the text for total and set to string variable
		String resultsCount = driver.findElement(By.className("totalcount")).getText().trim();
		// Click on the first link to go to page
		this.driver.findElement(By.cssSelector("a.result-title.hdrlnk")).click();
		// Take screenshot of the page
		takeScreenshot(this.testNum + "-" + keywords);
	}
}