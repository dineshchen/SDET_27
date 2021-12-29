package com.SDET27.AutoDesk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.WebDriverutility;

public class DataDrivenTestUsingPropertiesFile {
public static void main(String[] args) throws Throwable {

	FileUtility fLib=new FileUtility();
	WebDriverutility wdLib=new WebDriverutility();
	
//Read data using prop.getProperty("key")	
    String browser =fLib.getPropertyKeyValue("browser");
    String url =fLib.getPropertyKeyValue("url");
    String username=fLib.getPropertyKeyValue("username");
    String password=fLib.getPropertyKeyValue("password");
    
//Launching a web driver
    WebDriver driver = new ChromeDriver();
    driver.get(url);
    driver.manage().window().maximize();
    wdLib.waitForPageToLoad(driver);
    
    LoginPage lp=new LoginPage(driver);
    lp.login(username, password);
	driver.quit();
	
}
}
