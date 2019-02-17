package com.fpix.tests.Lern;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.fpix.BusinessFunctions.Lern.BusinessFunctions;
import com.fpix.base.Lern.TestBase;
import com.fpix.utilities.Lern.TestUtilities;

public class LoginScenario1 extends BusinessFunctions{

	@Test(dataProviderClass = TestUtilities.class, dataProvider = "dp")
	public void login1(String firstName, String LastName, String password, String email) throws Throwable{
		
		log.debug("Login Test");
		driver.findElement(By.xpath(OR.getProperty("txtPhoneNumber"))).clear();
		type("txtPhoneNumber", "8765432121");
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED')]")).click();
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
