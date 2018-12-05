package com.justrechargeit.testRegister;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.justrechargeit.base.TestBase;
import com.justrechargeit.subscripts.RegisterMethods;
import com.justrechargeit.utility.DataProviderClass;

public class TestRegisterWithValidData extends TestBase{
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
		DataProviderClass.setUp(fileLocation, sheetName, "RegisterWithValidData");
		
	}
	
	@Test(dataProvider="xlsData",dataProviderClass=DataProviderClass.class)
	public void registerWithInvalidData(String className, String name, 
			String mobileNumber, String email, String password, String actionField) throws InterruptedException
	{
		RegisterMethods.registerMethod(name, mobileNumber, email, password);
		Assert.assertEquals(driver.getCurrentUrl(), expUrl);
		captureScreenshot(sheetName);
	}
	
	@AfterMethod
	public void afterMethod()
	{
		driver.findElement(By.linkText("Sign out")).click();
		redirectRegister();
	}	
	
	
}
