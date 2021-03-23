package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.Commonfunctions;
import com.utilities.Staticvariables;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class FBLOGIN extends TTD {
	
	Locators obj = new Locators();
	Commonfunctions cfn = new Commonfunctions();
	
	
	@AfterMethod
	public void afterMethod() throws Exception {
		Thread.sleep(5000);
		cfn.takeScreenshot("FBLOGIN");
	}

	@Test 
	public void fblogin() throws Exception {
		f();
		// get the data from property file
		FileInputStream pathOfThePropertyFile = new FileInputStream(".\\testdata\\inputdata.properties");
		Properties prop = new Properties();
		prop.load(pathOfThePropertyFile);

		driver.get(prop.getProperty("baseURL"));
		driver.manage().window().maximize();

		cfn.sendkeysByAnyLocator(obj.FBlogin_UserName_EditBox, prop.getProperty("UserName"));
		cfn.sendkeysByAnyLocator(obj.FBlogin_Password_EditBox, prop.getProperty("Password"));
		cfn.clickByAnyLocator(obj.FBlogin_Login_Button);

	}

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Please give valid browserName*********");
		}

	}

	@AfterClass // post-condition
	public void afterClass() {
		driver.close();
	}

}
