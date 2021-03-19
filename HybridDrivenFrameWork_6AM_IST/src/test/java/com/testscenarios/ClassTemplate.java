package com.testscenarios;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class ClassTemplate {
	WebDriver driver;

	@Test
	public void f() throws Exception {
		// get the data from property file
		FileInputStream pathOfThePropertyFile = new FileInputStream(".\\testdata\\inputdata.properties");
		Properties prop = new Properties();
		prop.load(pathOfThePropertyFile);
		// actual functional Steps
	}

	@AfterMethod
	public void afterMethod() {
		// take screenshot
	}

	@Parameters("browserName")
	@BeforeClass
	public void beforeClass(@Optional("chrome") String browserName) {
		if (browserName.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ".//browserdrivers//chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\browserdrivers\\geckodriver.exe");
			driver = new FirefoxDriver();

		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", ".\\browserdrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
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
