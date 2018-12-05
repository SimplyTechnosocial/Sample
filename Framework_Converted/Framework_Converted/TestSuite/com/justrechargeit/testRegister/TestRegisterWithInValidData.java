package com.justrechargeit.testRegister;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.justrechargeit.base.TestBase;
import com.justrechargeit.subscripts.RegisterMethods;
import com.justrechargeit.utility.DataProviderClass;

public class TestRegisterWithInValidData extends TestBase {
	static String fileLocation=".//TestData//Login.xlsx";
	static String sheetName="Register";

	@BeforeClass
	@Parameters("Browser")
	public void setupMethod(@Optional("chrome")String browser)
	{
		
		setBrowser(browser);
		launchWebsite();
		redirectRegister();		
		counter=0;
		DataProviderClass.setUp(fileLocation, sheetName, "RegisterWithInValidData");
		
	}
	
	@Test(dataProvider="xlsData",dataProviderClass=DataProviderClass.class)
	public void registerWithInvalidData(String className, String name, 
			String mobileNumber, String email, String password, String actionField) throws InterruptedException
	{
	
				RegisterMethods.registerMethod(name, mobileNumber, email, password);
				
				if(actionField.equalsIgnoreCase("Invalid_email"))
				{
				    captureScreenshot(sheetName);
					Assert.assertEquals(driver.findElement(errorRegisterBlankEmail).getText(), expmsgRegisterInvalidEmail);
				}
				
				if(actionField.equalsIgnoreCase("Invalid_Mobile"))
				{
				    captureScreenshot(sheetName);
				    Assert.assertEquals(driver.findElement(errorRegisterBlankMobile).getText(), expmsgRegisterInvalidMobile);
				}
				if(actionField.equalsIgnoreCase("Invalid_Name"))
				{
				    captureScreenshot(sheetName);
					Assert.assertEquals(driver.findElement(errorRegisterBlankName).getText(), expmsgRegisterInvalidName);
				}
				if(actionField.equalsIgnoreCase("Invalid_Password"))
				{
				    captureScreenshot(sheetName);
					Assert.assertEquals(driver.findElement(errorRegisterBlankPassword).getText(), expmsgRegisterInvalidPassword);
				}
				if(actionField.equalsIgnoreCase("Blank_Name"))
				{
				    captureScreenshot(sheetName);
					Assert.assertEquals(driver.findElement(errorRegisterBlankName).getText(), expmsgRegisterBlankName);
				}
	}
	
	@AfterMethod
	public void afterMethod() throws Exception
	{
		driver.findElement(CreateNewAccountLnkHeader).click();
    }
		
}
