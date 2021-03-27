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

public class ScrollIntoWebElement extends Staticvariables {
	Locators obj = new Locators();
	Commonfunctions cfn = new Commonfunctions();

	@Test
	public void f() throws Exception {
		// get the data from property file
		FileInputStream pathOfThePropertyFile = new FileInputStream(".\\testdata\\inputdata.properties");
		Properties prop = new Properties();
		prop.load(pathOfThePropertyFile);

		driver.get("https://shearcircle.com/");
		// Click on register button
		driver.findElement(By.xpath("//*[@class='elementskit-btn ']")).click();
		cfn.implicitWait(10);
		// Enter data
		WebElement element = driver.findElement(By.id("form-field-name"));
		// system will move to the targetted element untill visible
		// ( Scroll down of the page until the element is visible)
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		element.sendKeys("test");

	}

	@AfterMethod
	public void afterMethod() throws Exception {
		Thread.sleep(5000);
		// Give Name of the Class before run
		cfn.takeScreenshot("Give Name of the Class");
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
