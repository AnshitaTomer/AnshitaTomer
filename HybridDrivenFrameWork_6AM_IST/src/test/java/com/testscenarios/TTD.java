package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.Commonfunctions;
import com.utilities.Staticvariables;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class TTD extends Staticvariables {
	Locators obj = new Locators();
	Commonfunctions cfn = new Commonfunctions();

	@AfterMethod
	public void afterMethod() throws Exception {
		cfn.takeScreenshot("TTD");
	}

	@Test
	public void f() throws Exception {
		// get the data from property file
		FileInputStream pathOfThePropertyFile = new FileInputStream(".\\testdata\\inputdata.properties");
		Properties prop = new Properties();
		prop.load(pathOfThePropertyFile);
		// actual functional Steps

		driver.get(prop.getProperty("TTD_URL"));

		cfn.sendkeysByAnyLocator(obj.TTD_FirstName_EditBox, prop.getProperty("FirstName"));
		cfn.sendkeysByAnyLocator(obj.TTD_LastName_EditBox, prop.getProperty("LastName"));
		cfn.sendkeysByAnyLocator(obj.TTD_Mobile_EditBox, prop.getProperty("Mobile"));
		cfn.clickByAnyLocator(obj.TTD_DOB_Claender);

		// implicitwait: Page load wait statement
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Month selection
		cfn.selectByVisibleText(obj.TTD_DOB_Claender_Month, prop.getProperty("DOB_Month"));
		cfn.implicitWait(10);
		// Month selection
		cfn.selectByVisibleText(obj.TTD_DOB_Claender_Year, "1984");
		cfn.implicitWait(10);
		// Date picker
		cfn.clickByAnyLocator(By.linkText("14"));
		cfn.implicitWait(10);


		// Click on Female option on Gender
		driver.findElement(By.xpath("(//input[@name='gender'])[2]")).click();

		driver.findElement(By.name("address1")).sendKeys("s terra verde ct");
		driver.findElement(By.name("address2")).sendKeys("mountain house");
		driver.findElement(By.name("cityS")).sendKeys("tracy");
		driver.findElement(By.name("zipCode")).sendKeys("95391");
		Select abc = new Select(driver.findElement(By.name("countryS")));
		abc.selectByVisibleText("India");
		Select mn = new Select(driver.findElement(By.name("stateS")));
		mn.selectByVisibleText("Tamil Nadu");
		Select fgh = new Select(driver.findElement(By.name("proofS")));
		fgh.selectByVisibleText("Driving License");
		driver.findElement(By.name("proofId")).sendKeys("479238940");
		driver.findElement(By.name("emailId")).sendKeys("nancyj");
		driver.findElement(By.name("password")).sendKeys("jane");
		driver.findElement(By.name("repassword")).sendKeys("jane");
	}

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			cfn.firefoxBrowserLanuch();
		} else if (browserName.equalsIgnoreCase("edge")) {
			cfn.edgeBrowserLanuch();
		} else {
			System.out.println("Please give valid browserName*********");
		}
	}

	@AfterClass
	public void afterClass() {
		// close the browser
		driver.quit();
	}

}
