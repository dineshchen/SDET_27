package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {   //Step 1- Create a separate class for Organizations page
	
//Step 2- 
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchTextEdt;
	
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	
//Step 3-
	public OrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}


//Step 4-

	public WebElement getCreateOrgLookUpImg() {
		return createOrgLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}


	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
//Step 5-
	public void clickOnCreateOrg(){
		createOrgLookUpImg.click();
	}
	
}
