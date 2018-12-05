package com.justrechargeit.testLogin;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.justrechargeit.base.TestBase;
import com.justrechargeit.subscripts.LoginMethods;
import com.justrechargeit.utility.DataProviderClass;

public class TestLoginWithInvalidData extends TestBase
{
	static String fileLocation=".//TestData//Login.xlsx";
	static String sheetName="Login";
	
	@BeforeClass
	@Parameters("Browser")
	public void setupMethod(@Optional("chrome")String browser)
	{
		setBrowser(browser);
		launchWebsite();
		redirectLogin();
		DataProviderClass.setUp(fileLocation, sheetName, "LoginWithInValidData");
	}
	
	@Test(dataProvider="xlsData",dataProviderClass=DataProviderClass.class)
	public void testMethod(String className,String userName,String password,String actionField) 
	{
		try {
	
			LoginMethods.loginMethod(userName, password);
			if(actionField.equalsIgnoreCase("Wrong_Credentials"))
			{
				captureScreenshot(sheetName);
				Assert.assertEquals(driver.findElement(errorMsgInvalidDetails).getText(), expErrorMsgInvalidCredentials);
		
			}
	
			if(actionField.equalsIgnoreCase("Blank_Credentials"))
			{
			captureScreenshot(sheetName);
			Assert.assertEquals(driver.findElement(errorMsgUserName).getText(), expErrorMsgBlankUser);
			}
			
			if(actionField.equalsIgnoreCase("Wrong_Password"))
			{
				captureScreenshot(sheetName);
				Assert.assertEquals(driver.findElement(errorMsgInvalidDetails).getText(), expErrorMsgInvalidCredentials);
	    	}
			if(actionField.equalsIgnoreCase("Wrong_Email"))
			{
				captureScreenshot(sheetName);
				Assert.assertEquals(driver.findElement(errorMsgUserName).getText(), expErrorMsgInvalidUser);
			}
			

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@AfterMethod
	public void afterMethod() throws Exception
	{
		redirectLogin();	
	}
	
	}
