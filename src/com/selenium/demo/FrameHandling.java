package com.selenium.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FrameHandling {
	
	public static void main(String args[]) throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Bhargavi\\Documents\\Selenium-Work\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://ui.cogmento.com/");
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.findElement(By.name("email")).sendKeys("gbhargavi@gmail.com");
		
		driver.findElement(By.name("password")).sendKeys("Dheeraj@2005");
		driver.findElement(By.xpath("//div[contains(text(),'Login')]")).click();
		
		//driver.findElement(By.xpath("//span[contains(text(),'Contacts')]")).click();
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[contains(text(),'Contacts')]"))).build().perform();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body/div[@id='ui']/div[1]/div[1]/div[3]/button[1]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.name("first_name")).clear();
		driver.findElement(By.name("first_name")).sendKeys("John");
		driver.findElement(By.name("last_name")).sendKeys("smith");
		driver.findElement(By.xpath("//div[@id='dashboard-toolbar']/div[2]/div/button[@class='ui linkedin button']")).click();
		//driver.quit();
	}

}
