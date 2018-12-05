package com.justrechargeit.subscripts;
import org.openqa.selenium.WebElement;
import com.justrechargeit.RegisterOR.RegisterOR;
import com.justrechargeit.base.TestBase;


public class RegisterMethods extends TestBase implements RegisterOR{

	static String sheetName="Register";
	
	public static void registerMethod(String NameAccount,String Mobile,String Email,String Password) throws InterruptedException
	{
		//Register Send data
		driver.findElement(txtbxName).sendKeys(NameAccount);
		Thread.sleep(1000);
		driver.findElement(txtbxMobile).sendKeys(Mobile);
		Thread.sleep(1000);
		driver.findElement(txtbxEmail).sendKeys(Email);
		Thread.sleep(1000);
		driver.findElement(txtbxPassword).sendKeys(Password);
		Thread.sleep(1000);
		//Subscribe checkbox
		WebElement OcheckbxSubscribe=driver.findElement(checkbxSubscribe);
		if(OcheckbxSubscribe.isSelected())
		{
			driver.findElement(checkbxSubscribe).click();
		}
		Thread.sleep(1000);
		//TermsConditions checkbox
		WebElement OcheckbxTermsConditions=driver.findElement(checkbxTermsConditions);
		if(OcheckbxTermsConditions.isSelected())
		{

		}
		else
		{
			driver.findElement(checkbxTermsConditions).click();
		}
		Thread.sleep(1000);
		captureScreenshot(sheetName);
		driver.findElement(btnCreateAccount).click();

	}
	public static void invalidRegisterMethodClearAll(String NameAccount,String Mobile,String Email,String Password) throws InterruptedException
	{
		//Clear all values
		driver.findElement(txtbxName).clear();
		Thread.sleep(1000);
		driver.findElement(txtbxMobile).clear();
		Thread.sleep(1000);
		driver.findElement(txtbxEmail).clear();
		driver.findElement(txtbxPassword).clear();
		Thread.sleep(1000);
	}


	
}
