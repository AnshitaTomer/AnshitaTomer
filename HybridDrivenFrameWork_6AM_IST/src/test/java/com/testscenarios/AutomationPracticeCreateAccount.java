package com.testscenarios;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.Commonfunctions;
import com.utilities.Staticvariables;


public class AutomationPracticeCreateAccount extends Staticvariables {
	Locators obj = new Locators();
	Commonfunctions cfn = new Commonfunctions();

	@Test
	public void f() throws Exception {
		
		FileInputStream pathOfThePropertyFile = new FileInputStream(".\\testdata\\inputdata.properties");
		Properties prop = new Properties();
		prop.load(pathOfThePropertyFile);
		
		driver.get(prop.getProperty("AutomationPracticeCreateAccount_URL"));
		driver.manage().window().maximize();
		
		cfn.sendkeysByAnyLocator(obj.automation_email_EditBox, prop.getProperty("Automation_email"));
		cfn.clickByAnyLocator(obj.automation_CreateAccount_button);
		Thread.sleep(5000);
			
		cfn.clickByAnyLocator(obj.automation_register_botton);
	   String alert=driver.findElement(By.xpath("//*[@class='alert alert-danger']")).getText();
	   System.out.println(alert);
	   Thread.sleep(5000);
		driver.navigate().refresh();
		cfn.clickByAnyLocator(obj.automation_Title_radiobutton);
		cfn.sendkeysByAnyLocator(obj.automation_Fname_EditBox, prop.getProperty("Automation_Fname"));
		cfn.sendkeysByAnyLocator(obj.automation_Lname_EditBox, prop.getProperty("Automation_Lname"));
		cfn.sendkeysByAnyLocator(obj.automation_email_EditBox, prop.getProperty("Automation_email"));
		cfn.sendkeysByAnyLocator(obj.automation_Password_EditBox, prop.getProperty("Automation_Password"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		cfn.clickByAnyLocator(obj.automation_DOB_Claender_Day);
		cfn.implicitWait(10);
		cfn.clickByAnyLocator(obj.automation_DOB_Claender_Month);
		cfn.implicitWait(10);
		cfn.clickByAnyLocator(obj.automation_DOB_Claender_Year);
		cfn.implicitWait(10);
	    cfn.clickByAnyLocator(obj.automation_Newsletter);
	    cfn.clickByAnyLocator(obj.automation_Offers);
	
	    cfn.sendkeysByAnyLocator(obj.automation_FName_EditBox, prop.getProperty("Automation_Fname"));
		cfn.sendkeysByAnyLocator(obj.automation_LName_EditBox, prop.getProperty("Automation_Lname"));
		cfn.sendkeysByAnyLocator(obj.automation_Company_EditBox, prop.getProperty("Automation_Company"));
		cfn.sendkeysByAnyLocator(obj.automation_Address_EditBox, prop.getProperty("Automation_Address"));
		cfn.sendkeysByAnyLocator(obj.automation_City_EditBox, prop.getProperty("Automation_City"));
	    cfn.clickByAnyLocator(obj.automation_State);
	    cfn.sendkeysByAnyLocator(obj.automation_ZipCode, prop.getProperty("Automation_Zipcode"));
	    cfn.sendkeysByAnyLocator(obj.automation_PhoneNo, prop.getProperty("Automation_PhoneNo"));
	    cfn.sendkeysByAnyLocator(obj.automation_Address2_EditBox, prop.getProperty("Automation_Address_2"));
	    //cfn.clickByAnyLocator(obj.automation_register_botton);
	}	
		
	
	@AfterMethod
	public void afterMethod() throws Exception {
		Thread.sleep(5000);
		cfn.takeScreenshot("AutomationPracticeCreateAccount");
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
	
