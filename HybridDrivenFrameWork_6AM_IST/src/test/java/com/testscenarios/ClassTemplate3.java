package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.Commonfunctions;
import com.utilities.Staticvariables;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class ClassTemplate3 extends Staticvariables {
	Locators obj = new Locators();
	Commonfunctions cfn = new Commonfunctions();

	@Test
	public void f() throws Exception {
		// get the data from property file
		FileInputStream pathOfThePropertyFile = new FileInputStream(".\\testdata\\inputdata.properties");
		Properties prop = new Properties();
		prop.load(pathOfThePropertyFile);
		
		driver.get(prop.getProperty("Platform_URL"));
		driver.manage().window().maximize();
		cfn.loopAllFramesForFindTheElement(obj.platform_email_EditBox);
		cfn.sendkeysByAnyLocator(obj.platform_email_EditBox, prop.getProperty("Platform_email"));
		cfn.sendkeysByAnyLocator(obj.platform_FName_EditBox, prop.getProperty("Platform_FName"));
		cfn.sendkeysByAnyLocator(obj.platform_LName_EditBox, prop.getProperty("Platform_LName"));
		cfn.sendkeysByAnyLocator(obj.platform_Organization_EditBox, prop.getProperty("Platform_Organization"));
		cfn.sendkeysByAnyLocator(obj.platform_Title_EditBox, prop.getProperty("Platform_Title"));
		
		Thread.sleep(5000);
		WebElement  radio = driver.findElement(By.className("field-label"));
		((JavascriptExecutor)driver).executeScript("arguments[0].click()",radio);
		//cfn.clickByAnyLocator(obj.platform__Subscribe_Button);
		
		cfn.clickByAnyLocator(obj.platform__Submit_Button);
		

	}


	@AfterMethod
	public void afterMethod() throws Exception {
		Thread.sleep(5000);
		cfn.takeScreenshot("ClassTemplate3");
	}

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			cfn.chromeBrowserLanuch();
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
