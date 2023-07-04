package com.testscripts;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.generic.BaseClass;
import com.pageobjectmodel.HomePage;
import com.pageobjectmodel.PurchaseConfirmationPage;
import com.pageobjectmodel.PurchasePage;
import com.pageobjectmodel.SelectFlightPage;

public class TestTitle extends BaseClass {
	@Test(priority = 1)
	public void testTitle() {

		String atitle = driver.getTitle();
		String etitle = "Welcome to simple travel agency";

		assertNotEquals(atitle, etitle);


	}
	
	@Test(priority = 2)
	public void testNavigationandLink() throws InterruptedException
	{
		HomePage hp= new HomePage(driver);
		
		hp.getDestlink().click();
		Thread.sleep(2000);
		assertTrue(driver.getCurrentUrl().contains("vacation"),"the url doesn't conatins vacation word");
		System.out.println(driver.getCurrentUrl());
		driver.navigate().back();
		
	}
	@Test(priority = 3)
	public void testpurchaseTicket() throws InterruptedException
	{
		HomePage hp= new HomePage(driver);
			
		
		Select s1= new Select(hp.getDrpCountry());
		s1.selectByVisibleText("Mexico City");
		Thread.sleep(2000);
		
		Select s2 = new Select(hp.getDestCountry());
		s2.selectByVisibleText("London");
		Thread.sleep(3000);
		
		hp.getFindflightsbtn().click();
		
		SelectFlightPage sfp= new SelectFlightPage(driver);
		
		Reporter.log("HI",true);
		
		List<WebElement> prices = sfp.getPrices();
		
		TreeSet<Double> ts= new TreeSet<Double>();
		for(WebElement price:prices)
		{
			String p = price.getText().replaceAll("[^0-9.]","");
			ts.add((Double.valueOf(p)));			//convert  JI string to double by using wrapper class
		}
		
		//System.out.println(ts.first());
		driver.findElement((By.xpath("//td[contains(text(),'"+ts.first()+"')]/..//input[@type='submit']"))).click();
		Thread.sleep(3000);
		String totalCost = driver.findElement(By.xpath("//p[text()='Total Cost: ']/em")).getText();
		System.out.println("Total cost of Tickets: " +totalCost);
		
		PurchasePage pp = new PurchasePage(driver);
		
		Assert.assertTrue(totalCost.matches("\\d{3}\\.\\d{2}"),"Total cost is not in the xxx.xx format");
		pp.getPurchaseflightbtn().click();
		
		PurchaseConfirmationPage pcf=new PurchaseConfirmationPage(driver);
		System.out.println("Purchase Confirmation Id: " +pcf.getPurchaseid().getText());
		
	}

}
