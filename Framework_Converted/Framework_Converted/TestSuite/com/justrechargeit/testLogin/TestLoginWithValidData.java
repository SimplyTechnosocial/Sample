package com.justrechargeit.testLogin;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.justrechargeit.base.TestBase;
import com.justrechargeit.subscripts.LoginMethods;
import com.justrechargeit.utility.DataProviderClass;

public class TestLoginWithValidData extends TestBase {
	static String fileLocation=".//TestData//Login.xlsx";
	static String sheetName="Login";
	
	@BeforeClass
	@Parameters("Browser")
	public void setupMethod(@Optional("chrome")String browser)
	{
		setBrowser(browser);
		launchWebsite();
		redirectLogin();
		DataProviderClass.setUp(fileLocation, sheetName, "LoginWithValidData");
	}
	
	@Test(dataProvider="xlsData", dataProviderClass=DataProviderClass.class)
	public void loginWithValidData(String className,String userName,String password,String actionField) throws Exception
	{
		LoginMethods.loginMethod(userName, password);
		Assert.assertEquals(driver.getCurrentUrl(),expUrl);
		captureScreenshot(sheetName+" "+actionField);
		
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.findElement(SignOutLink).click();
		redirectLogin();
	}
	
	
}
