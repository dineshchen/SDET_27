package com.SDET27.AutoDesk;

import static org.testng.Assert.fail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.CreateNewOrganizationsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.BaseClass;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverutility;

public class CreateContactWithOrgTest extends BaseClass {
@Test(groups="RegressionSuite")
	public void createContactWithOrgTest() throws Throwable {

	
	int randomNumber= jLib.getRanDomNumber();
	
		
		String orgName=eLib.getDataFromExcel("Org", 1, 2)+randomNumber;
		String lastname=eLib.getDataFromExcel("Org", 1, 2)+randomNumber;
		String firstName=eLib.getDataFromExcel("Org", 4, 3)+randomNumber;
		
        
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLink();
		hp.waitForPageToLoad(driver);
		hp.windowMaximize(driver);
		
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		
		CreateNewOrganizationsPage cnop=new CreateNewOrganizationsPage(driver);
		cnop.createOrg(orgName);
		//Assert.fail("Failed");
		
		wdLib.waitForElementToBeClickable(driver, driver.findElement(By.className("dvHeaderText")));
		
		
		hp.clickOnContactsLink();
		
		ContactsPage cp=new ContactsPage(driver) ;
		cp.clickOnCreateContact();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.CreateContact(lastname);
		
		ContactInfoPage cip=new ContactInfoPage(driver);
		
}
}
