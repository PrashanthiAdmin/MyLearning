package com.fpix.objectrepository.lernwise;

import org.openqa.selenium.By;

public class HomePage {

	public static By chooseAccount(String parentFNOrChildFN){
		By lnkAccount=By.xpath("//h4[contains(text(),'"+parentFNOrChildFN+"')]/preceding-sibling::div");
    	return lnkAccount;
	}
	
	
}
