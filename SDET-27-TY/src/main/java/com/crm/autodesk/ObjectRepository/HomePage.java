package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverutility;

public class HomePage extends WebDriverutility{  //Step 1- Create a separate  class for home page
	
//Step 2-Declaration
	@FindBy(linkText="Organizations")
	private WebElement organizationsLnk;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLnk;
	
	@FindBy(linkText="Products")
	private WebElement productsLnk;
	
	@FindBy(linkText="Documents")
	private WebElement documentsnk;
	
	@FindBy(linkText="Email")
	private WebElement emailLnk;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement troubleticketsLnk;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement 	administratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLnk;
	
//Step 3 - Initialization
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Step 4- Utilization

	public WebElement getOrganizationsLnk() {
		return organizationsLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getOpportunitiesLnk() {
		return opportunitiesLnk;
	}

	public WebElement getProductsLnk() {
		return productsLnk;
	}

	public WebElement getDocumentsnk() {
		return documentsnk;
	}

	public WebElement getEmailLnk() {
		return emailLnk;
	}

	public WebElement getTroubleticketsLnk() {
		return troubleticketsLnk;
	}

	public WebElement getAdministratorImg() {
		return administratorImg;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
//Step 5- Business Library to click on organizations
	public void clickOnOrganizationsLink() {
		organizationsLnk.click();
	}
	
//Step 6- Business Library to click on Contacts
	public void clickOnContactsLink() {
		contactsLnk.click();
	}
	
//Step 7- Business Library for Logout
	public void logout(WebDriver driver) throws Throwable {
		waitAndClick(administratorImg);
		mouseOverOnElement(driver, administratorImg);
		signOutLnk.click();
		
	}
	

	

	
}
