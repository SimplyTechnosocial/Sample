package com.justrechargeit.subscripts;

import com.justrechargeit.base.TestBase;

public class LoginMethods extends TestBase 
{
	public static String sheetName="Login";
	
	public static void loginMethod(String userName,String password) throws Exception
	{
		driver.findElement(textboxUserName).sendKeys(userName);
		driver.findElement(textboxPassword).sendKeys(password);
		captureScreenshot(sheetName);
		driver.findElement(buttonSignIn).click();
		Thread.sleep(1000);
		//logger.log(LogStatus.INFO, "Login credential filled successfully");
	}
	public static void invalidLoginMethodClearAll(String userName,String password) throws Exception
	{
		Thread.sleep(1000);	
		driver.findElement(textboxUserName).clear();
		driver.findElement(textboxPassword).clear();

	}
}
