package com.justrechargeit.ProfileOR;

import org.openqa.selenium.By;

public interface ProfileOR {

//Personal details

By txtBoxNameProfile=By.id("cust_name");
By txtBoxAddressProfile=By.id("cust_address");
By txtBoxCityProfile=By.id("cust_city");
By dropdownStateProfile=By.id("ddlState");
By txtBoxPinCodeProfile=By.id("cust_pincode");
By txtBoxDOBProfile=By.id("cust_dob");
By txtBoxMobileProfile=By.id("cust_mobileno");

By buttonSaveInformation=By.id("imgbtnSubmit");
By buttonEditInformation=By.xpath(".//*[@id='first_div']/table/tbody/tr[18]/td[2]/a/img");

//Personal Details Help Text

By helpMsgNameProfile=By.id("cust_name");
By helpMsgAddressProfile=By.id("cust_address");
By helpMsgCityProfile=By.id("cust_city");
By helpMsgPinCodeProfile=By.id("cust_pincode");
By helpMSgMobileProfile=By.id("cust_mobileno");

//Personal Details Error Messages

By errorMsgNameProfile=By.id("nameTD");
By errorMsgAddressProfile=By.id("addressTD");
By errorMsgCityProfile=By.id("CityTD");
By errorMsgStateProfile=By.id("StateTD");
By errorMsgPinCodeProfile=By.id("pincodeTD");
By errorMsgMobileProfile=By.id("mobilenoTD");

//Expected Help Messages

String expHelpMsgNameProfile="Full name as appearing on your bank statement";
String expHelpMsgAddressProfile="Address as appearing on your bank statement";
String expHelpMsgCityProfile="Enter your city";
String expHelpMsgPinCodeProfile="Enter valid pin code";
String expHelpMsgMobileProfile="Enter a valid mobile number. This could be a prepaid or postpaid number.";

//Expected error Messages

String expErrorBlankNameProfile="Enter your name";
String expErrorInvalidNameProfile="Enter valid name";
String expErrorBlankAddressProfile="Enter your address";
String expErrorBlankCityProfile="Enter your city";
String expErrorInvalidCityProfile="Enter valid city";
String expErrorBlankStateProfile="Select a State / Province";
String expErrorBlankPinCodeProfile="Enter your pin code";
String expErrorInvalidPinCodeProfile="Enter valid pin code";
String expErrorBlankMobileProfile="Enter mobile no.";
String expErrorInvalidMobileProfile="Enter valid 10 digit Mobile no.";

//Save Confirmation 

By buttonOKSaveConfirmation=By.xpath("//*[@id=\'content\']/table/tbody/tr[2]/td/span/a/img");
}
