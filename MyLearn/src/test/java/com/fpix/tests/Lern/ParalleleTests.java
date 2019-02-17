package com.fpix.tests.Lern;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ParalleleTests {

	@Test
	 public void getFirefox(){
	                //System.setProperty("webdriver.gecko.driver", "geckodriver.exe path");
	 System.setProperty("webdriver.gecko.driver", "C:\\Users\\PRASHANTHI\\udemy\\Lern\\src\\test\\resources\\executables\\geckodriver.exe");
	                System.out.println("GetFirefox Method is running on Thread : " + Thread.currentThread().getId());
	 WebDriver driver = new FirefoxDriver();
	 driver.get("http://www.SoftwareTestingMaterial.com");
	 driver.close();
	 }
	 
	 @Test
	 public void getChorme(){
	                //System.setProperty("webdriver.chrome.driver", "chromedriver.exe path");
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\PRASHANTHI\\udemy\\Lern\\src\\test\\resources\\executables\\chromedriver.exe");
	                System.out.println("GetChrome Method is running on Thread : " + Thread.currentThread().getId());
	 WebDriver driver = new ChromeDriver();
	 driver.get("http://www.SoftwareTestingMaterial.com");
	 driver.close();
	 }
}
