package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {

	//public final By PageName_ElementNAme_Type = By.id("email");
	public final By FBlogin_UserName_EditBox = By.name("email");
	public final By FBlogin_Password_EditBox = By.name("pass");
	public final By FBlogin_Login_Button = By.xpath("//*[contains(@id,'u_0_d_')]");
	
	//TTD
	public final By TTD_FirstName_EditBox = By.name("fName");
	public final By TTD_LastName_EditBox = By.name("lName");
	public final By TTD_Mobile_EditBox = By.name("mobNo");
	public final By TTD_DOB_Claender = By.id("regdob");
	
	//SeleniumEasyDemo Class
	
	public final By Seleniumeasydemo_textarea_textbox = By.id("textbox");
	public final By Seleniumeasydemo_Generate_button = By.id("create");
	public final By Seleniumeasydemo_Download_hyperlink = By.id("link-to-download");
	
	
	
}
