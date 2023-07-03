package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseConfirmationPage {
	@FindBy(xpath=("//td[2]"))
    WebElement purchaseid;
	
	 public PurchaseConfirmationPage(WebDriver driver){
	
	PageFactory.initElements(driver, this);
}

	public WebElement getPurchaseid() {
		return purchaseid;
	}
	 
}
