package com.fpix.tests.Lern;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;


import java.util.HashMap;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.By;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.fpix.BusinessFunctions.Lern.BusinessFunctions;
import com.fpix.Utilities.Data_Provider;
import com.fpix.base.Lern.TestBase;
import com.fpix.objectrepository.lernwise.LoginPage;
import com.fpix.utilities.Lern.TestUtilities;

public class LoginScenario extends BusinessFunctions{

	@Test(dataProviderClass = TestUtilities.class, dataProvider = "dp")
	public void login(String firstName, String LastName, String password, String email) throws Throwable{
		
		
if(!(TestUtilities.isTestRunnable("openAccountTest", excel))){
			
			throw new SkipException("Skipping the test "+"openAccountTest".toUpperCase()+ "as the Run mode is NO");
		}

		log.debug("Login Test");
		system.out.println("changes in code");
		log.debug("Login Test1");
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
	
	
	}
