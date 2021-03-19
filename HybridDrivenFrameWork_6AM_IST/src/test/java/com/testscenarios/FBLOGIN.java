package com.testscenarios;

import org.testng.annotations.Test;

import com.objectrepository.Locators;

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

public class FBLOGIN {
	//Create a reference of Locators class
	//CLASSNAME ref = NEW CLASSNAME();
	Locators obj = new Locators();
	
	
	WebDriver driver;

	@Test // actual test script
	public void fblogin() throws Exception {
		//get the data from property file
		FileInputStream pathOfThePropertyFile = new FileInputStream(".\\testdata\\inputdata.properties");
		Properties prop = new Properties();
		prop.load(pathOfThePropertyFile);
		
			
		driver.get(prop.getProperty("baseURL"));	
		driver.manage().window().maximize();
	
		driver.findElement(obj.FBlogin_UserName_EditBox).sendKeys(prop.getProperty("UserName"));
		driver.findElement(obj.FBlogin_Password_EditBox).sendKeys(prop.getProperty("Password"));
		driver.findElement(obj.FBlogin_Login_Button).click();

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
