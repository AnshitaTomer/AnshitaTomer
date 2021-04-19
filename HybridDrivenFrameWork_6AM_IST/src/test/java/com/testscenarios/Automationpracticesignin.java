package com.testscenarios;
import java.io.FileInputStream;
import java.util.Properties;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.objectrepository.Locators;
import com.utilities.Commonfunctions;
import com.utilities.Staticvariables;



public class Automationpracticesignin extends Staticvariables {
	Locators obj = new Locators();
	Commonfunctions cfn = new Commonfunctions();

	@Test
	public void f() throws Exception {
		
		FileInputStream pathOfThePropertyFile = new FileInputStream(".\\testdata\\inputdata.properties");
		Properties prop = new Properties();
		prop.load(pathOfThePropertyFile);
		
		driver.get(prop.getProperty("AutomationPracticeCreateAccount_URL"));
		driver.manage().window().maximize();
		cfn.sendkeysByAnyLocator(obj.automation_EMAIL_EditBox, prop.getProperty("Automation_email"));
		cfn.sendkeysByAnyLocator(obj.automation_PASSWORD_EditBox, prop.getProperty("Automation_Password"));
		cfn.clickByAnyLocator(obj.automation_LoginButton);
		
		
		
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
