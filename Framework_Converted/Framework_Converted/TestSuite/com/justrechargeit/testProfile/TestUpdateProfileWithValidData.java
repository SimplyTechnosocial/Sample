package com.justrechargeit.testProfile;


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

public class TestUpdateProfileWithValidData extends TestBase {
static String fileLocation=".//TestData//Login.xls";
static String sheetName="Profile";

@BeforeClass
public void setupDataProvidere()
{
	DataProviderClass.setUp(fileLocation, sheetName, "UpdateProfileWithValidData");

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
	if(actionField.equalsIgnoreCase("Correct_Data"))
	{
		Thread.sleep(400);
	driver.findElement(buttonOKSaveConfirmation).click();
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