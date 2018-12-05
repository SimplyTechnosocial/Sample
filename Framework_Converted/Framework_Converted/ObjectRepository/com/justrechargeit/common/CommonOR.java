package com.justrechargeit.common;

import org.openqa.selenium.By;

public interface CommonOR {

	By SignInlnkHeader=By.id("jriTop_signin9");
	By CreateNewAccountLnkHeader=By.linkText("Create New Account");
	By SignOutLink=By.linkText("Sign out");
	
	By myProfile=By.xpath(".//*[@id='myprofile_tab']/a/div/img");
}
