package com.crm.AutoDesk.Org;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.autodesk.ObjectRepository.CreateNewOrganizationsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.BaseClass;

@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)
public class CreateOrgTest extends BaseClass {

	@Test(groups = "SmokeSuite",retryAnalyzer=com.crm.autodesk.genericutility.RetryAnalyzerImplementation.class)
	public void createOrgTest() throws Throwable
	{
		SoftAssert sa=new SoftAssert(); 
		//get random number
		int randomNum=jLib.getRanDomNumber();
		
		//read test data from excel
		String orgName=eLib.getDataFromExcel("Org", 1, 2)+randomNum;
		
		//navigate to Organization module
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLink();
		sa.fail();
		
		//click on create organization button
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		Assert.fail();
		//enter all the details &create new organization
		CreateNewOrganizationsPage cnop=new CreateNewOrganizationsPage(driver);
		cnop.createOrg(orgName);
		
		//verify organization name in header of the msg
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String ActMsg=oip.getOrgInfo();
		
	
	sa.assertTrue(ActMsg.contains(orgName));
	Reporter.log("Org created", true);
	sa.assertAll();
	}
	@Test(groups= {"RegressionSuite","SmokeSuite"})
	public void demo()
	{
		System.out.println("demo");
	}
}
