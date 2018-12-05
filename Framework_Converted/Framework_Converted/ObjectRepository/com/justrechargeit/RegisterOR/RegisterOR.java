package com.justrechargeit.RegisterOR;

import org.openqa.selenium.By;

public interface RegisterOR {
	
	By txtbxName=By.xpath(".//*[@id='signup_name']");
	By txtbxMobile=By.xpath(".//*[@id='signup_mobileno']");
	By txtbxEmail=By.xpath(".//*[@id='signup_email']");
	By txtbxPassword=By.xpath(".//*[@id='signup_password']");
	By checkbxSubscribe=By.xpath(".//*[@id='checkbox1']");
	By checkbxTermsConditions=By.xpath(".//*[@id='checkbox']");
	By btnCreateAccount=By.xpath(".//*[@id='imgbtnSubmit']");
	
	By errorRegisterBlankName=By.xpath(".//*[@id='nameTD']/span");
	By errorRegisterBlankMobile=By.xpath(".//*[@id='mobilenoTD']/span");
	By errorRegisterBlankEmail=By.xpath(".//*[@id='emailTD']/span");
	By errorRegisterBlankPassword=By.xpath("//*[@id='passwordTD']/span"); 
	
	String expUrl="https://www.justrechargeit.com/myaccount_directory.aspx";
	//Error Messages
	String expmsgRegisterBlankName="Enter your name";
	String expmsgRegisterBlankMobile="Enter mobile no.";
	String expmsgRegisterBlankEmail="Enter your email id";
	String expmsgRegisterBlankPassword="Enter your password";
	String expmsgRegisterInvalidName="Enter correct name";
	String expmsgRegisterInvalidMobile="Enter valid 10 digit mobile no.";
	String expmsgRegisterInvalidEmail="Enter valid email id";
	String expmsgRegisterInvalidPassword="Enter 6-digit numeric characters only";

}
