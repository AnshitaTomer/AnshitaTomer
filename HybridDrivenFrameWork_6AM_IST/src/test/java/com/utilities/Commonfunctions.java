package com.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Commonfunctions extends Staticvariables {

	/************* BrowserDrivers ******************/
	public void chromeBrowserLanuch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public void firefoxBrowserLanuch() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	public void edgeBrowserLanuch() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	public void operaBrowserLanuch() {
		WebDriverManager.operadriver().setup();
		driver = new OperaDriver();
		driver.manage().window().maximize();
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
	
	public void clickUsingJavaScript(By locator) {
		WebElement elelment = driver.findElement(locator);
		if (elelment.isDisplayed()) {
			if (elelment.isEnabled()) {
				JavascriptExecutor jse = (JavascriptExecutor)driver;
				jse.executeScript("arguments[0].click();", elelment);
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

	/****************** Dropdown selection **************************************/

	public void selectByVisibleText(By locater, String visibleText) {

		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByVisibleText(visibleText);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectByIndex(By locater, int index) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByIndex(index);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectByValue(By locater, String value) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				dropdown.selectByValue(value);
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void printAllDropdownValues(By locater) {
		WebElement element = driver.findElement(locater);

		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {
				Select dropdown = new Select(element);
				List<WebElement> dropdownValues = dropdown.getOptions();
				// Print the size of dropdown values
				System.out.println(dropdownValues.size());
				// Print the dropdown values
				for (WebElement allvalue : dropdownValues) {
					System.out.println(allvalue.getText());
				}
			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}

	public void selectCustomiseOptionFromTheDropdownValues(By locater, String visibleText) {
		WebElement element = driver.findElement(locater);
		if (element.isDisplayed()) {
			// isEnabled()
			if (element.isEnabled()) {

				Select dropdown = new Select(element);
				List<WebElement> dropdownValues = dropdown.getOptions();
				// Print the size of dropdown values
				System.out.println(dropdownValues.size());
				// Print the dropdown values
				for (int i = 0; i < dropdownValues.size(); i++) {
					System.out.println(dropdownValues.get(i).getText());

					// Select Aug option from the dropdown
					if (dropdownValues.get(i).getText().equals(visibleText)) {
						dropdown.selectByIndex(i);
						break;
					}
				}
				System.out.println("Given input is not matching with optional values, please check the input once....");

			} else {
				System.out.println("The webelement is NOT Enabled, please check**************");
			}
		} else {
			System.out.println("The webelement is NOT displayed, please check**************");
		}

	}
	
	
	/************ waits inselenium ***********************/
	public void explicitWait(By locator, int timeinSeconds) {
		WebElement element = driver.findElement(locator);
		// webdriver wait (Explicit wait)
		WebDriverWait ww = new WebDriverWait(driver, timeinSeconds);
		ww.until(ExpectedConditions.visibilityOf(element));
	}

	public void implicitWait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
		System.out.println("Implicit wait method used***");

	}
	
	/******************** Frames Handling *******************/

	public int iframeCount() {
		driver.switchTo().defaultContent();
		JavascriptExecutor exe = (JavascriptExecutor) driver;
		int numberOfFrames = 0;
		numberOfFrames = Integer.parseInt(exe.executeScript("return window.length").toString());
		System.out.println("Number of iframes on the page are: " + numberOfFrames);
		return numberOfFrames;
	}

	public void switchToFrameByInt(int i) {
		driver.switchTo().defaultContent();
		driver.switchTo().frame(i);
	}

	public int loopAllFramesForFindTheElement(By locator) {

		int elementpresenceCount = 0;
		int index = 0;
		int maxFramaecount = iframeCount();// 3
		//system will check the given locator has present on default page?
		// if given locater has present on webpage, then the element size would be '1'
		// else '0'		
		elementpresenceCount = driver.findElements(locator).size();// 0
		while (elementpresenceCount == 0 && index < maxFramaecount) {//T*F=F
			try {
				switchToFrameByInt(index);
				elementpresenceCount = driver.findElements(locator).size();//1
				System.out.println("Try LoopAllframes : " + index + "; Element presence Count: "+ elementpresenceCount);
				if (elementpresenceCount > 0 || index > maxFramaecount) {
					break;
				}
			} catch (Exception abc) {
				System.out.println("Catch LoopAllframes : " + index + "; " + abc);
			}
			index++;
		}
		return elementpresenceCount;
	}


}
