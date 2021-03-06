package com.fpix.BusinessFunctions.Lern;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fpix.accelerators.lernwise.ActionEngine;
import com.fpix.base.Lern.TestBase;
import com.fpix.objectrepository.lernwise.LoginPage;
import com.fpix.utilities.Lern.TestUtilities;

public class BusinessFunctions extends ActionEngine{
	public Properties prop;
	public FileInputStream ip;
	//public  String URL;

	
	@Test(dataProviderClass = TestUtilities.class, dataProvider = "dp")
	public void login(String firstName, String LastName, String password, String email) throws Throwable{
		
		
/*if(!(TestUtilities.isTestRunnable("openAccountTest", excel))){
			
			throw new SkipException("Skipping the test "+"openAccountTest".toUpperCase()+ "as the Run mode is NO");
		}*/
		log.debug("Login Test");
		driver.findElement(By.xpath(OR.getProperty("txtPhoneNumber"))).clear();
		type("txtPhoneNumber", "8765432121");
		click("btnProceed");
		type("txtPasscode1","1");
		type("txtPasscode2","2");
		type("txtPasscode3","3");
		type("txtPasscode4","4");
		click("btnSubmit");
		Thread.sleep(2000);
		driver.findElement(By.xpath(OR.getProperty("firstName"))).clear();
		type("firstName",firstName);
		driver.findElement(By.xpath(OR.getProperty("LastName"))).clear();
		type("LastName",LastName);
		driver.findElement(By.xpath(OR.getProperty("password"))).clear();
		type("password",password);
		driver.findElement(By.xpath(OR.getProperty("email"))).clear();
		type("email",email);
		//assertEquals(isElementPresent(By.xpath(OR.getProperty("btnProceed"))), "true");
		click("back");
		
		//assertTrue(isElementPresent(By.xpath(OR.getProperty("email"))));
		log.debug("Phonenumber verified");
	}

public void verifyLogin(String Phno) throws Throwable{
	try{
		//launchLern();
		type(LoginPage.txtPhoneNumber, "Phone", Phno);
		//isElementPresent(LoginPage.btnProceed, "Proceed button", result);
		click(LoginPage.btnProceed, "Proceed button");
		
	} catch (Exception e) {
		e.printStackTrace();
		//getResult(result);
	//type(LoginPage.txtPhoneNumber, "Phone", phNo);
}
}} 