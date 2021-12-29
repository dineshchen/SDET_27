package com.crm.AutoDesk.Org;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.CreateNewOrganizationsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverutility;


public class CreateOrgWithIndustriesAndType extends BaseClass {

	@Test(groups="RegressionSuite")
	public void createOrgWithIndustriesTest() throws Throwable {
		
//getting random number using generic library 
         int randomNum=jLib.getRanDomNumber();
		
//getting values from excel sheet
		String orgName=eLib.getDataFromExcel("Org", 1, 2) + randomNum;
		String lname=eLib.getDataFromExcel("Org", 4, 5);
		String industries=eLib.getDataFromExcel("Org", 4, 3);
		String type=eLib.getDataFromExcel("Org", 4, 4);
        
        
        HomePage hp=new HomePage(driver);
        hp.clickOnOrganizationsLink();
        
        OrganizationsPage op=new OrganizationsPage(driver);
        op.clickOnCreateOrg();
        
        CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
        cnop.createOrgWithIndustry(orgName, industries, type);
        
        OrganizationInfoPage oip=new OrganizationInfoPage(driver);
        String act_msg=oip.getOrgInfo();
        
        SoftAssert sa=new SoftAssert();
        sa.assertTrue(act_msg.contains("abc"));
        
        WebElement act_ind = oip.getIndustryName();
        System.out.println(act_ind);
        sa.assertTrue(act_ind.equals("ind"));
        
        WebElement actType=oip.getTypeName();
        System.out.println(actType);
        Assert.assertTrue(actType.equals(type));
        
        
       sa.assertAll();
	}
}
