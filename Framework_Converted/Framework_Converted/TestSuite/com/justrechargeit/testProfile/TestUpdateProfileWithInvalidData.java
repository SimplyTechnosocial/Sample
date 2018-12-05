package com.justrechargeit.testProfile;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.justrechargeit.base.TestBase;
import com.justrechargeit.subscripts.ProfileMethods;
import com.justrechargeit.utility.DataProviderClass;

public class TestUpdateProfileWithInvalidData extends TestBase{

	static String fileLocation=".//TestData//Login.xlsx";
	static String sheetName="Profile";
	
	@BeforeClass
	public void setupDataProvidere()
	{
		DataProviderClass.setUp(fileLocation, sheetName, "UpdateProfileWithInvalidData");

	}


	@BeforeMethod
	@Parameters("Browser")
	public void setupMethod(@Optional("chrome")String browser)
	{
		setBrowser(browser);
		launchWebsite();
		redirectLogin();
		loginValid();
		
	}
	
	@Test(dataProvider="xlsData", dataProviderClass=DataProviderClass.class)
	public void VerifyHelpTextProfile(String testCaseName,String name,String address,String city, String state, String pincode, String DOB, String mobile, String actionField) throws Exception
	{
		ProfileMethods.navigateToProfile();
		ProfileMethods.editProfileInformation();
		ProfileMethods.UpdateProfileData(name, address, city, state, pincode, DOB, mobile);
		captureScreenshot(sheetName);
		
		//Verify error message for Blank Name
		if(actionField.equalsIgnoreCase("Blank_Name"))
		{
		Assert.assertEquals(driver.findElement(errorMsgNameProfile).getText(),expErrorBlankNameProfile);
		}
		
		//Verify error message for Invalid Name
		if(actionField.equalsIgnoreCase("Invalid_Name"))
		{
		Assert.assertEquals(driver.findElement(errorMsgNameProfile).getText(),expErrorInvalidNameProfile);
		}	
		
		//Verify error message for Blank Address
		if(actionField.equalsIgnoreCase("Blank_Address"))
		{
		Assert.assertEquals(driver.findElement(errorMsgAddressProfile).getText(),expErrorBlankAddressProfile);
		}	
		
		//Verify error message for Blank City
		if(actionField.equalsIgnoreCase("Blank_City"))
		{
		Assert.assertEquals(driver.findElement(errorMsgCityProfile).getText(),expErrorBlankCityProfile);
		}
		
		//Verify error message for Invalid City
		if(actionField.equalsIgnoreCase("Invalid_City"))
		{
		Assert.assertEquals(driver.findElement(errorMsgNameProfile).getText(),expErrorBlankCityProfile);
		}
		
		//Verify error message for Blank State
		if(actionField.equalsIgnoreCase("Blank_State"))
		{
		Assert.assertEquals(driver.findElement(errorMsgStateProfile).getText(),expErrorBlankStateProfile);
		}
		
		//Verify error message for Blank Pincode
		if(actionField.equalsIgnoreCase("Blank_Pincode"))
		{
		Assert.assertEquals(driver.findElement(errorMsgPinCodeProfile).getText(),expErrorBlankPinCodeProfile);
		}	
		
		//Verify error message for Invalid Pincode
		if(actionField.equalsIgnoreCase("Invalid_Pincode"))
		{
		Assert.assertEquals(driver.findElement(errorMsgStateProfile).getText(),expErrorInvalidPinCodeProfile);
		}	
		
		//Verify error message for Blank Mobile
		if(actionField.equalsIgnoreCase("Blank_Mobile"))
		{
		Assert.assertEquals(driver.findElement(errorMsgMobileProfile).getText(),expErrorBlankMobileProfile);
		}
		
		//Verify error message for Invalid Mobile
		if(actionField.equalsIgnoreCase("Invalid_Mobile"))
		{
		Assert.assertEquals(driver.findElement(errorMsgMobileProfile).getText(),expErrorInvalidMobileProfile);
		}	
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
