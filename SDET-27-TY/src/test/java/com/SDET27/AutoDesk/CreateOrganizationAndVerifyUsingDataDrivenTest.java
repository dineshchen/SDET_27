package com.SDET27.AutoDesk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.autodesk.ObjectRepository.CreateNewOrganizationsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverutility;


public class CreateOrganizationAndVerifyUsingDataDrivenTest {

	public static void main(String[] args) throws Throwable {

	FileUtility fLib=new FileUtility();
	JavaUtility jLib=new JavaUtility();
	ExcelUtility eLib=new ExcelUtility();
	WebDriverutility wdLib=new WebDriverutility();
		
	String browser=fLib.getPropertyKeyValue("browser");
	String url=fLib.getPropertyKeyValue("url");
	String username=fLib.getPropertyKeyValue("username");
	String password=fLib.getPropertyKeyValue("password");

	int randomNumber=jLib.getRanDomNumber();

	String orgName=eLib.getDataFromExcel("Org", 1, 2)+randomNumber;
	String industry=eLib.getDataFromExcel("Org", 4, 3);
	String type=eLib.getDataFromExcel("Org", 4, 4);


		
// Launching the browser without hardcode
	WebDriver driver;
	if(browser.equals("edge"))
	{
		driver=new EdgeDriver();
	}
	else if(browser.equals("chrome")){
		driver=new ChromeDriver();
	}
	else if(browser.equals("firefox"))
	{
		driver= new FirefoxDriver();
	} else {
		driver= new ChromeDriver();
	}
	driver.get(url);
	wdLib.waitForPageToLoad(driver);
	
	LoginPage lp=new LoginPage(driver);
	lp.login(username, password);
	
	
// Navigate to Organizations
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganizationsLink();
//Click on Organizations
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrg();
	
//Fetch and alter orgName from EXCEL	
	CreateNewOrganizationsPage cnop=new CreateNewOrganizationsPage(driver);
	cnop.createOrgWithIndustry(orgName, industry, type);
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgName);
//Save the Org	
OrganizationInfoPage oip=new OrganizationInfoPage(driver);
//Fetching the added data	
	String actual_msg = oip.fetchCNFMsg();
	if(actual_msg.contains(orgName))
	{
		System.out.println("One Organization added successfully");
	}
	else {
		System.out.println("Organization is not added");
	}

//signout
	
	
//write Data into EXCEL SHEET
	
	eLib.setDataExcel("Org", 3, 5, "PASS");
	
	eLib.getDataFromExcel("Org", 3, 5);
	System.out.println("added");
	hp.logout(driver);
    driver.quit(); 
}
	

}