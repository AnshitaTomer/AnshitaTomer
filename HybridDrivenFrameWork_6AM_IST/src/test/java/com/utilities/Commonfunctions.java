package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Commonfunctions extends Staticvariables {

	/************* BrowserDrivers ******************/
	public void chromeBrowserLanuch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public void firefoxBrowserLanuch() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}

	public void edgeBrowserLanuch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	public void operaBrowserLanuch() {
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
	}

	/*********** Send keys ***************/
	public void sendkeysByAnyLocator(By locator, String inputdata) {
		WebElement elelment = driver.findElement(locator);
		if (elelment.isDisplayed()) {
			if (elelment.isEnabled()) {
				// clear(): system will check whether is any existing data available or not?
				// if available, it clear the text
				elelment.clear();
				elelment.sendKeys(inputdata);
			} else {
				System.out.println("Element is not NOT in Enable state, please check the locator");
			}
		} else {
			System.out.println("Element is not displayed, please check the locator");
		}
	}

	/**************** Click ********************/
	public void clickByAnyLocator(By locator) {
		WebElement elelment = driver.findElement(locator);
		if (elelment.isDisplayed()) {
			if (elelment.isEnabled()) {
				elelment.click();
			} else {
				System.out.println("Element is not NOT in Enable state, please check the locator");
			}
		} else {
			System.out.println("Element is not displayed, please check the locator");
		}
	}

	/*********** TimeStamp *************/
	public String currentTimeStamp() {
		Date d = new Date();
		System.out.println(d);
		DateFormat df = new SimpleDateFormat("ddMMMyyyy_HHmmss");
		String timeStamp = df.format(d);
		return timeStamp;
	}

	public void takeScreenshot(String name) throws Exception {
		String pathOfTheScreentostfolder = ".\\screenshots\\";
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(srcFile, new File(pathOfTheScreentostfolder + name + currentTimeStamp() + ".PNG"));

	}

}
