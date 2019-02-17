package com.fpix.accelerators.lernwise;

import java.io.File;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.fpix.Utilities.Data_Provider;
import com.fpix.base.Lern.TestBase;
import com.fpix.utilities.Lern.TestUtilities;
import com.relevantcodes.extentreports.LogStatus;

import net.sourceforge.htmlunit.corejs.javascript.ErrorReporter;


public class ActionEngine extends TestBase {

	public static WebDriver driver;
	public Properties prop;
	public FileInputStream ip;
	public static String url;
	
	public void ExplicitWaitOnElementToBeclickable(By locator){
		
		try{
			
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(locator));
		}catch(Throwable e){
			
		}
	}
	
	public boolean click(By locator, String locatorName){
		
		ExplicitWaitOnElementToBeclickable(locator);
		boolean flag =  false;
		
		try{
			
			driver.findElement(locator).click();
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}/*finally {
			if (!flag) {
				failureReport("Click", "Unable to clicked on " + locatorName);
				return true;
			} else if (b && flag) {
				SuccessReport("Click", "Successfully clicked on " + locatorName);

			}*/
			
		return flag;
		
		
	}
	
	
public boolean type(By locator, String locatorName, String testdata){

		
		ExplicitWaitOnElementToBeclickable(locator);
		boolean flag =  false;
		
		try{
			driver.findElement(locator).clear();
			Thread.sleep(1000);
			driver.findElement(locator).sendKeys(testdata);
			flag = true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return flag;
		
		
	}

public boolean launchUrl() throws Throwable {
	
	boolean flag = false;
	//String Url1="";
	try {
		
		driver.navigate().to(url);
		
		flag = true;
		return true;
	} catch (Exception e) {
		return false;
	} 
}

public boolean isElementPresent(By by) {
	
	try{
		driver.findElement(by);
	
	return true;
}catch(NoSuchElementException e) {
	return false;
}

}


public void click(String locator) throws Throwable{
	
	try{driver.findElement(By.xpath(OR.getProperty(locator))).click();
	test.log(LogStatus.INFO, "clicking on :" +locator);
	}
	catch(Exception e){
		TestUtilities.captureScreenshot();
		
		//extent
		
		test.log(LogStatus.FAIL, " Failed with exception : "+e.getMessage());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtilities.screenshotName));
		

		
		rep.endTest(test);
		rep.flush();
	}
}



public void type(String locator, String value){
	
	driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
	//if(test == null){
	test.log(LogStatus.INFO, "Typing in :" +locator);
//}
}

@BeforeSuite
public  void initDriver() throws Throwable {

	prop = new Properties();
	ip = new FileInputStream(
			"C://Users//prashanthi//workspace//Lern//src//main//java//com//Lern//config.properties");
	prop.load(ip);
	url = prop.getProperty("URL");
	System.setProperty("webdriver.chrome.driver", "D:\\Selenium\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.navigate().to(url);
	
}

@AfterSuite
public void tearDown(){
	
	driver.close();
}
public static String capture(WebDriver driver,String screenShotName) throws IOException
{
    TakesScreenshot ts = (TakesScreenshot)driver;
    File source = ts.getScreenshotAs(OutputType.FILE);
    String dest = System.getProperty("user.dir") +"\\ErrorScreenshots\\"+screenShotName+".png";
    File destination = new File(dest);
    FileUtils.copyFile(source, destination);        
                 
    return dest;
}



	
public boolean isElementPresent(By by, String locatorName,ITestResult result) throws Throwable {
	boolean flag = false;
	try {
		driver.findElement(by);
		flag = true;
		return true;
	} catch (org.openqa.selenium.NoSuchElementException e) {
		//getResult(result);
		return false;
	} /*finally {
		if (!flag) {
			//failureReport("Element Present ", locatorName + " is not present on the page");
			//onTestFailure(result);
		} else if (b && flag) {
			getResult(result);
		}

	}*/
}







}
