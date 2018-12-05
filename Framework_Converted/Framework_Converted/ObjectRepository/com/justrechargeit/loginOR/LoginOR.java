package com.justrechargeit.loginOR;

import org.openqa.selenium.By;

public interface LoginOR 
{
  By textboxUserName=By.id("txtUserName");
  By textboxPassword=By.id("txtPasswd");
  By buttonSignIn=By.id("imgbtnSignin");
  
  //WebElement error message
  
  By errorMsgUserName=By.id("MessageCaption2");
  By errorMsgPassword=By.id("MessageCaption3");
  By errorMsgInvalidDetails=By.id("MessageCaption");
  
  //Expected Error Messages
  
  String expErrorMsgBlankUser="Enter your email";
  String expErrorMsgInvalidUser="Enter valid email for login";
  String expErrorMsgBlankPassword="Enter your password";
  String expErrorMsgInvalidPassword ="Login Information is wrong. "
  		+ "Account will be blocked after 5 attempts.";
  String expErrorMsgInvalidCredentials="Invalid Login Id / Password."; 
  
  
  
  
}
