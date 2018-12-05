package com.justrechargeit.testProfile;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.justrechargeit.base.TestBase;
import com.justrechargeit.subscripts.ProfileMethods;


public class TestVerifyHelpTextForProfileFields extends TestBase{

	static String fileLocation=".//TestData//Login.xlsx";
	static String sheetName="Profile";
	

	@BeforeMethod
	@Parameters("Browser")
	public void setupMethod(@Optional("chrome")String browser)
	{
		setBrowser(browser);
		launchWebsite();
		redirectLogin();
		loginValid();
		
	}
	
	@Test
	public void VerifyHelpTextProfile() 
	{
		
		ProfileMethods.navigateToProfile();
		ProfileMethods.editProfileInformation();
		
		SoftAssert softAssert=new SoftAssert();
		
		//Verify help text for Name Field
		driver.findElement(txtBoxNameProfile).click();
		captureScreenshot(sheetName);
		softAssert.assertEquals(driver.findElement(helpMsgNameProfile).getText(), expHelpMsgNameProfile);		
		
		//Verify help text for Address Field
		driver.findElement(txtBoxAddressProfile).click();
		captureScreenshot(sheetName);
		softAssert.assertEquals(driver.findElement(helpMsgAddressProfile).getText(), expHelpMsgAddressProfile);
	
		//Verify help text for City Field
		driver.findElement(txtBoxCityProfile).click();
		captureScreenshot(sheetName);
		softAssert.assertEquals(driver.findElement(helpMsgCityProfile).getText(), expHelpMsgCityProfile);
		
		//Verify help text for Pincode Field
		driver.findElement(txtBoxPinCodeProfile).click();
		captureScreenshot(sheetName);
		softAssert.assertEquals(driver.findElement(helpMsgPinCodeProfile).getText(), expHelpMsgPinCodeProfile);
		
		//Verify help text for Mobile Field
		driver.findElement(txtBoxMobileProfile).click();
		captureScreenshot(sheetName);
		softAssert.assertEquals(driver.findElement(helpMSgMobileProfile).getText(), expHelpMsgMobileProfile);
	
		softAssert.assertAll();
	
	}
	
	@AfterMethod
	public void AfterMethod(ITestResult result)
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			captureScreenshot(sheetName);
			
		}
	driver.close();
	}
}
