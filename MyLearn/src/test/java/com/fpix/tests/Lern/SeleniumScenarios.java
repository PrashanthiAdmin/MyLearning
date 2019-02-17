package com.fpix.tests.Lern;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumScenarios {
	
	public static WebDriver driver;
	
	@Test(groups = {"Functional"})
	public static void openBrowser() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		driver.findElement(By.name("cusid")).sendKeys("53920");					
        driver.findElement(By.name("submit")).submit();	
        
        Alert alert = driver.switchTo().alert();
        Thread.sleep(5000);
        alert.accept();
		
				
		
	}
	
	
	@Test(groups = {"Smoke"})
public static void handlingWindows() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/popup.php");
		
		driver.manage().window().maximize();		
		
		driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();	
		
		String mainWindow = driver.getWindowHandle();
		
		Set<String> s1 = driver.getWindowHandles();
		
		
		Iterator<String> i1 = s1.iterator();
		
		while(i1.hasNext()) {
			
			String childwindow = i1.next();
			
			if(!mainWindow.equalsIgnoreCase(childwindow)) {
				
				driver.switchTo().window(childwindow);
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[contains(@name,'email')]"))
                .sendKeys("gaurav.3n@gmail.com");                			
                
                driver.findElement(By.name("btnLogin")).click();			
                             
		// Closing the Child Window.
                    driver.close();		
			}
		}
		
		driver.switchTo().window(mainWindow);
		
				
		
	}
	
	

}
