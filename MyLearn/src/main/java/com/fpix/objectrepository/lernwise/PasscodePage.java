package com.fpix.objectrepository.lernwise;

import org.openqa.selenium.By;

public class PasscodePage {

	// txtPhoneNumber = //input[@name='phone']
	// btnProceed = //button[contains(text(),'ssss')]
	public static By txtPasscode1 = By.xpath("//input[@id = 'code1']");
	public static By txtPasscode2 = By.xpath("//input[@id = 'code2']");
	public static By txtPasscode3 = By.xpath("//input[@id = 'code3']");
	public static By txtPasscode4 = By.xpath("//input[@id = 'code4']");
	public static By btnSubmit = By.xpath("//button[contains(text(),'SUBMIT')]");

}
