package com.fpix.objectrepository.lernwise;

import org.openqa.selenium.By;

public class LoginPage {

	
	public static By txtPhoneNumber = By.xpath("//input[@name='phone']");
	public static By btnProceed = By.xpath("//button[contains(text(),'proceed')]");
	public static By txtGetStarted = By.xpath("//h2[contains(text(),'GET STARTED WITH')]");
	public static By txtPhPlaceHolder = By.xpath("//input[contains(@placeholder,'s Mobile Number')]");
	public static By btnClose = By.xpath("//mat-icon[text()='close']");
	public static By btnDisabled = By.xpath("//button[@disabled]");
}
