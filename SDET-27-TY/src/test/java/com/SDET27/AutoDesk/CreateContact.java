package com.SDET27.AutoDesk;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.crm.autodesk.ObjectRepository.ContactInfoPage;
import com.crm.autodesk.ObjectRepository.ContactsPage;
import com.crm.autodesk.ObjectRepository.CreateContactPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.genericutility.BaseClass;

@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)
public class CreateContact extends BaseClass {
@Test(groups="SmokeSuite")
	
@Parameters("browser")
public void CreateContacts() throws Throwable {
		
		
	
	int ranDomnum = jLib.getRanDomNumber();
		
		//get data from excel
		String lastName = eLib.getDataFromExcel("Org", 1, 2) + ranDomnum;	
		//String lastn = eLib.getDataFromExcel("Org", 1, 3);
		
		
		//navigate to organization module
    	HomePage hp = new HomePage(driver);
    	hp.clickOnContactsLink();
    	
    	//click on create Contact button
    	ContactsPage cp =  new ContactsPage(driver);
    	cp.clickOnCreateContact();
    	
    	//Enter all the details and create new Contact
    	CreateContactPage ccp = new CreateContactPage(driver);
    	ccp.CreateContact(lastName);
    	
    	//Verify Contact name in header of msg	
    	ContactInfoPage cip =  new ContactInfoPage(driver);
    	String Act_mgs = cip.getConInfo();
    	
    	Assert.assertTrue(Act_mgs.contains(lastName));
    	System.out.println("contact created successfully");
}
}
