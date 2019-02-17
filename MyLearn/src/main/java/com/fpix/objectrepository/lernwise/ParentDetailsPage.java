package com.fpix.objectrepository.lernwise;

import org.openqa.selenium.By;

public class ParentDetailsPage {

	public static By firstName = By.xpath("//input[@placeholder = 'First Name']");
	public static By LastName = By.xpath("//input[@placeholder = 'Last Name']");
	public static By password = By.xpath("//input[@type= 'password']");
	public static By email = By.xpath("//input[@placeholder= 'Enter your email']");
	public static By gender = By.xpath(" //div[contains(text(),'Male')]");
	public static By btnProceed = By.xpath("//button[contains(text(),'PROCEED')]");
	public static By back = By.xpath("//mat-icon[contains(text(),'keyboard')]");
}
