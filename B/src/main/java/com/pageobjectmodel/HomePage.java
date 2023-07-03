package com.pageobjectmodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.generic.BaseClass;

public class HomePage extends BaseClass {

		@FindBy(xpath=("//select[@name='fromPort']"))
	    WebElement drpCountry;
	    @FindBy(xpath=("//select[@name='toPort']"))
	    WebElement destCountry;
	    @FindBy(xpath=("//input[@type='submit']"))
	    WebElement findflightsbtn; 
	    @FindBy(xpath=("//a[text()='destination of the week! The Beach!']"))
	    WebElement destlink;
	    public HomePage(WebDriver driver){
	        PageFactory.initElements(driver, this);
	    }
		public WebElement getDrpCountry() {
			return drpCountry;
		}
		public WebElement getDestCountry() {
			return destCountry;
		}
		public WebElement getFindflightsbtn() {
			return findflightsbtn;
		}
		public WebElement getDestlink() {
			return destlink;
		}
	    
	    
}
