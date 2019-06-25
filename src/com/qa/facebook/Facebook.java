package com.qa.facebook;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class Facebook {
	
	WebDriver driver; 
	String URL = "https://www.facebook.com/";
	
	
	@BeforeTest
	public void browserLaunchTest(){
		
		System.setProperty("webdriver.chrome.driver", "G:/Selenium Workspace/PageObjectModel/src/main/java/com/qa/drivers/chromedriver.exe");	
		driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		
	}
	
	@Test(priority = 0)
	@Parameters({"username","password"})
	public void facebookLoginTest(String username, String password){
		
		WebElement emailId = driver.findElement(By.xpath("//input[@name = 'email']"));
		WebElement pass = driver.findElement(By.xpath("//input[@name = 'pass']"));
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type = 'submit']"));
		
		emailId.clear();
		emailId.sendKeys(username);
		
		pass.clear();
		pass.sendKeys(password);
		
		loginBtn.click();
		
	}
	
	@Test(priority = 1)
	public void statusDisplay(){
		
		String status = "Hello World";
		System.out.println(status);
	}
	
	
	@AfterTest
	public void tearDown(){
		
		driver.quit();
	}
	
	

}
