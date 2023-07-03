package com.generic;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
static
{
	WebDriverManager.chromedriver().setup();
	WebDriverManager.firefoxdriver().setup();
	WebDriverManager.edgedriver().setup();
	
}
// objects created in different pages can be given here
Lib l=new Lib();
	    public static Properties prop;
	    public static WebDriver driver;
	    @Parameters("browser")
	    @BeforeTest
	    public static void launchApp(@Optional ("chrome")String browser) throws Throwable {
	       
			if (browser.equals("chrome")) {
	            driver=new ChromeDriver();
	        } else if (browser.equals("firefox")){
	            driver=new FirefoxDriver();
	        } else if (browser.equals("edge")){
	            driver=new EdgeDriver();
	        }
	}
	@BeforeMethod
	public void openSite() throws Throwable{
	     //Library class of generic package
	    String url= l.getPropertyData("url");
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	@AfterMethod
	public void Logout() {
			
			
	}


	@AfterTest
	public void closeServer(){
	    driver.quit();

	}

	}

