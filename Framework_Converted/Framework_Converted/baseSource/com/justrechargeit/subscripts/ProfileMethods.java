package com.justrechargeit.subscripts;

import org.openqa.selenium.support.ui.Select;
import com.justrechargeit.base.TestBase;

public class ProfileMethods extends TestBase {
	
public static String sheetName="Profile";
	
	public static void UpdateProfileData(String name,String address, String city, String state, String pincode, String DOB, String mobile) throws Exception
	{	
		driver.findElement(txtBoxNameProfile).clear();
		driver.findElement(txtBoxNameProfile).sendKeys(name);
		
		driver.findElement(txtBoxAddressProfile).clear();
		driver.findElement(txtBoxAddressProfile).sendKeys(address);
		
		driver.findElement(txtBoxCityProfile).clear();
		driver.findElement(txtBoxCityProfile).sendKeys(city);
		
		Select stateDropdown=new Select(driver.findElement(dropdownStateProfile));
		
		if(state.equals(""))
		{
			stateDropdown.selectByIndex(0);
		}
		else
		{
		stateDropdown.selectByVisibleText(state);
		}
		
		driver.findElement(txtBoxPinCodeProfile).clear();	
		driver.findElement(txtBoxPinCodeProfile).sendKeys(pincode);
		
		// if DOB is not updated already then disabled attribute will not be there
		// hence exception will be thrown and catch statement will fill date
		// if DOB is already updated then date field becomes disabled hence ignore sending date
		try {
			if (driver.findElement(txtBoxDOBProfile).getAttribute("disabled").equalsIgnoreCase("disabled"))
			{}
		
		} catch (NullPointerException e) {
			
			driver.findElement(txtBoxDOBProfile).sendKeys(DOB);
		}
		
		
		
		driver.findElement(txtBoxMobileProfile).clear();
		driver.findElement(txtBoxMobileProfile).sendKeys(mobile);
		captureScreenshot(sheetName);
		driver.findElement(buttonSaveInformation).click();
		captureScreenshot(sheetName);
	}

	public static void navigateToProfile()
	{
	driver.findElement(myProfile).click();
	captureScreenshot(sheetName);
	}
	
	public static void editProfileInformation()
	{
		driver.findElement(buttonEditInformation).click();
		captureScreenshot(sheetName);
	}
}
