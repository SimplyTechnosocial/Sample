package com.justrechargeit.base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.justrechargeit.ProfileOR.ProfileOR;
import com.justrechargeit.RegisterOR.RegisterOR;
import com.justrechargeit.common.CommonOR;
import com.justrechargeit.loginOR.LoginOR;

public class TestBase implements LoginOR, RegisterOR, CommonOR, ProfileOR{
	public static WebDriver driver;
	public static WebDriverWait wait;
    public static int counter=0;
	
	public static String userName="renukad235@gmail.com";
	public static String password="123456";
		
	public static void setBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".//Tools//chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			wait=new WebDriverWait (driver,30);
		}
		if(browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", ".//Tools//geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
			wait=new WebDriverWait (driver,30);
		}
		if(browser.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", ".//Tools//IEDriverServer.exe");
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			wait=new WebDriverWait (driver,30);
		}
		}
	
	public static void loginValid()
	{
		driver.findElement(textboxUserName).sendKeys(userName);
		driver.findElement(textboxPassword).sendKeys(password);
		driver.findElement(buttonSignIn).click();
	}
	
	public static void launchWebsite()
	{
		driver.get("https://www.justrechargeit.com/");
	}
	
	public static void redirectLogin()
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jriTop_signin9")));
		driver.findElement(SignInlnkHeader).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(textboxUserName));
	}
	
	public static void redirectRegister()
	{
		driver.findElement(CreateNewAccountLnkHeader).click();
		
	}
	
	
	public static String captureScreenshot(String sheetName)
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd MM yy");
		String currentDate = sdf.format(date);
		String dest="C:\\Users\\Mandeep\\workspace\\Framework_Converted\\Screenshots\\"+sheetName+"\\"
				+currentDate+"\\"+sheetName+counter+".png";
							
		File screenshotFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			
			FileUtils.copyFile(screenshotFile, new File(dest));
		}
		catch(Exception e){			
		}
		counter+=1;
		return dest;
		}
}
