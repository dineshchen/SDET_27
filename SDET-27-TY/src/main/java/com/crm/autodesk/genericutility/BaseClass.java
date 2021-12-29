package com.crm.autodesk.genericutility;

import java.sql.Connection;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;

public class BaseClass {

	public DataBaseUtility dLib=new DataBaseUtility();
	public FileUtility fLib=new FileUtility();
	public static JavaUtility jLib=new JavaUtility();
	public WebDriverutility wdLib=new WebDriverutility();
	public ExcelUtility eLib=new ExcelUtility();
	
	public static WebDriver driver;
	public static WebDriver sdriver;
	
	
	@BeforeSuite(groups = {"RegressionSuite","SmokeSuite"})
	public void dbConnection() throws SQLException 
	{
		//dLib.CreateJdbcConnection();
		System.out.println("-------DataBase Connection Sucessful");
	}
	
	//@Parameters("browser")
	@BeforeClass(groups = { "RegressionSuite","SmokeSuite"})
	public void launchBrowser() throws Throwable
	{
	//read the data
		String browser=fLib.getPropertyKeyValue("browser");
		String url=fLib.getPropertyKeyValue("url");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}else if(browser.equalsIgnoreCase("ie"))
		{
			driver=new InternetExplorerDriver();
		}else if(browser.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else
		{
			System.out.println("Invalid Browser");
		}
		
	sdriver=driver;
		wdLib.waitForPageToLoad(driver);
		wdLib.windowMaximize(driver);
		driver.get(url);
		
	}
	@BeforeMethod(groups = {"RegressionSuite","SmokeSuite"})
	public void loginToApp() throws Throwable
	{
		//read the data
		String username=fLib.getPropertyKeyValue("username");
	    String password=fLib.getPropertyKeyValue("password");
			
	    LoginPage lp=new LoginPage(driver);
	    lp.login(username, password);
	    System.out.println("-------Login Successful-------");
	}
	@AfterMethod(groups = {"RegressionSuite","SmokeSuite"})
	public void logoutTheApp() throws Throwable
	{
		HomePage hp=new HomePage(driver);
		hp.logout(driver);
		System.out.println("------Logout is successful------");
	}
	
	@AfterClass(groups = {"RegressionSuite","SmokeSuite"})
	public void closeBrowser()
	{
		driver.quit();
		System.out.println("-------Broser is closed---------");
	}
	
	@AfterSuite(groups = {"RegressionSuite","SmokeSuite"})
	public void closeDbConnection() throws SQLException
	{
		//dLib.closeJdbcConnection(null);
		System.out.println("Database connection is closed");
	}
}
