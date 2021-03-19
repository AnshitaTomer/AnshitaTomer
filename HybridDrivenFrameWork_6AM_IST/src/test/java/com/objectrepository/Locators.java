package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {

	//public final By PageName_ElementNAme_Type = By.id("email");
	public final By FBlogin_UserName_EditBox = By.name("email");
	public final By FBlogin_Password_EditBox = By.name("pass");
	public final By FBlogin_Login_Button = By.xpath("//*[contains(@id,'u_0_d_')]");
	
	
}
