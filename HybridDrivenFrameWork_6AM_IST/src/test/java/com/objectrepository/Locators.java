package com.objectrepository;

import org.openqa.selenium.By;

public class Locators {

	public final By FBlogin_CreateNewAccount = null;
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
	
	//classtemplate2
	public final By ISO_Button = By.xpath("//tr/td/a[@name='P-2Alist']");
	
	
		
		public final By TTD_DOB_Claender_Month =By.xpath("//select[@title='Change the month']");
		public final By TTD_DOB_Claender_Year =By.xpath("//select[@title='Change the year']");
		
		
		//nyiso
		public final By nyiso_Zonal_Link = By.name("P-24Alist");
		public final By nyiso_LastUpdated_Date = By.xpath("//table[@width='450']/tbody/tr[8]/td[2]/span");
		public By FBlogin_Login_NewAccount;
		
		
		//platform Q
		public final By platform_email_EditBox= By.id("796743_3523pi_796743_3523");
		public final By platform_FName_EditBox = By.name("796743_3525pi_796743_3525");
		public final By platform_LName_EditBox = By.name("796743_3527pi_796743_3527");
		public final By platform_Organization_EditBox = By.id("796743_3529pi_796743_3529");
		public final By platform_Title_EditBox = By.id("796743_5099pi_796743_5099");
		public final By platform__Submit_Button = By.xpath("//input[@type='submit']");
		public final By platform__Subscribe_Button = By.className("field-label");
		
		
		
		//automation practice create account
		public final By automation_email_EditBox = By.name("email_create");
		public final By automation_CreateAccount_button = By.name("SubmitCreate");
		public final By automation_Title_radiobutton = By.xpath("//*[@id='uniform-id_gender2']");
		public final By automation_Fname_EditBox = By.id("customer_firstname");
		public final By automation_Lname_EditBox = By.id("customer_lastname");
		public final By automation_Email_EditBox = By.name("email");
		public final By automation_register_botton = By.xpath("//*[@name='submitAccount']");
		public final By automation_error = By.xpath("//*[@class='alert alert-danger']");
		public final By automation_Password_EditBox = By.name("passwd");
		public final By automation_DOB_Claender_Day =By.xpath("//*[@id='days']/option[28]");
        public final By automation_DOB_Claender_Month =By.xpath("//*[@id='months']/option[5]");
		public final By automation_DOB_Claender_Year =By.xpath("//*[@id='years']/option[28]");
		public final By automation_Newsletter = By.xpath("//*[@id='uniform-newsletter']/span");
		public final By automation_Offers = By.xpath("//*[@id='uniform-optin']/span");
		public final By automation_FName_EditBox = By.id("firstname");
		public final By automation_LName_EditBox = By.id("lastname");
		public final By automation_Company_EditBox = By.id("company");
		
		public final By automation_Address_EditBox = By.id("address1");
		public final By automation_City_EditBox = By.id("city");
		public final By automation_State = By.xpath("//*[@id='id_state']/option[46]");
		public final By automation_ZipCode = By.id("postcode");
	    public final By automation_PhoneNo = By.id("phone_mobile");
	    public final By automation_Address2_EditBox = By.name("alias");
	    public final By automation_EMAIL_EditBox = By.id("email");
	    public final By automation_PASSWORD_EditBox  = By.id("passwd");
	    public final By automation_LoginButton = By.xpath("//*[@id='SubmitLogin']/span");
	    
	    
	    ///toyota finance
	    public final By toyota_cookies_button = By.id("tgbgdpr-overlay-agree");//*[@id="codeweaversModels"]
	    public final By toyota_finance_button = By.xpath("//*[@id='ctaBar']/a[4]/span[1]");
	    public final By toyota_select_car = By.xpath("//*[@id='codeweaversModels']/option[7]");
	    
	    
}
