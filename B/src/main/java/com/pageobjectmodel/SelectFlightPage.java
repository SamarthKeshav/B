package com.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectFlightPage {
@FindBy(xpath="//td[6]")
private List<WebElement>  prices;

public SelectFlightPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}

public List<WebElement> getPrices() {
	return prices;
}



}
