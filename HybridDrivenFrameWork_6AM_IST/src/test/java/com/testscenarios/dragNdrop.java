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

public class dragNdrop extends Staticvariables {
	Locators obj = new Locators();
	Commonfunctions cfn = new Commonfunctions();

	@Test
	public void f() throws Exception {
		// get the data from property file
		FileInputStream pathOfThePropertyFile = new FileInputStream(".\\testdata\\inputdata.properties");
		Properties prop = new Properties();
		prop.load(pathOfThePropertyFile);
		
		driver.get(prop.getProperty("GuruDemo_URL"));
		
		driver.manage().window().maximize();
		cfn.dragandDrop(By.xpath("//*[@id=\"credit2\"]/a"), By.xpath("//*[@id=\"bank\"]/li"));
		cfn.dragandDrop(By.xpath("//*[@id=\"fourth\"]/a"), By.xpath("//*[@id=\"amt7\"]/li"));
		cfn.dragandDrop(By.xpath("//*[@id=\"credit1\"]/a"), By.xpath("//*[@id=\"loan\"]/li"));
		cfn.dragandDrop(By.xpath("//*[@id=\"fourth\"]/a"), By.xpath("//*[@id=\"amt8\"]/li"));
		
		
			}


	@AfterMethod
	public void afterMethod() throws Exception {
		Thread.sleep(5000);
		cfn.takeScreenshot("dragNdrop ");
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
