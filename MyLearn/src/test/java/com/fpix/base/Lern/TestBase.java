package com.fpix.base.Lern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
//import org.testng.log4testng.Logger;

import com.fpix.utilities.Lern.ExcelReader;
import com.fpix.utilities.Lern.ExtentManager;
import com.fpix.utilities.Lern.TestUtilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static Properties prop = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\TestData.xlsx");
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	//@BeforeSuite
	public void setUp() {
		BasicConfigurator.configure();
		prop.setProperty("log4j.rootLogger", "WARN");
		PropertyConfigurator.configure(prop);
	if(driver == null)	
		//FileInputStream fis;
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			config.load(fis);
			log.debug("Loaded config file !!!");
	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			
			OR.load(fis);
			log.debug("OR file loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		if(config.getProperty("browser").equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver" , System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver();
			log.debug("Initialised chrome browser");
			
		}
		else if(config.getProperty("browser").equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver" , System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
		else if(config.getProperty("browser").equals("Edge")) {
			System.setProperty("webdriver.edge.driver" , System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
			
		}
		driver.get(config.getProperty("url"));
		driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
	}
	//@AfterSuite
	public void tearDown() {
		
		if(driver != null) {
			driver.quit();
			log.debug("closed browser");
		}
	}
	
	
}
