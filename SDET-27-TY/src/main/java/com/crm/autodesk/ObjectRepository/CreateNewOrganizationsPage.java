package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.autodesk.genericutility.WebDriverutility;

public class CreateNewOrganizationsPage extends WebDriverutility { //Step 1- Create a separate class for adding new Organizations page
	
//Step 2-
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement organizationNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDropDown;
	
	@FindBy(name="accounttype")
	private WebElement typeDropDown;
	
	@FindBy(xpath="//input[@value='U']")
	private WebElement radioBtn;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement descriptionTextbox;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="emailoptout")
	private WebElement emailOptCheck;
//Step 3-
	public CreateNewOrganizationsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//Step 4- 
	public WebElement getOrganizationNameEdt() {
		return organizationNameEdt;
	}

	public WebElement getEmailOptCheck() {
		return emailOptCheck;
	}
	public WebElement getDescriptionTextbox() {
		return descriptionTextbox;
	}
	public WebElement getIndustryDropDown() {
		return industryDropDown;
	}

	public WebElement getRadioBtn() {
		return radioBtn;
	}
	public WebElement getTypeDropDown() {
		return typeDropDown;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

//Business Library for create organization
	public void createOrg(String orgName) {
		organizationNameEdt.sendKeys(orgName);
		saveBtn.click();
	}
//Business Library to click on radio button
	public void createOrgWithRadioButtonClick() {
		radioBtn.click();
	}
	public void createOrgWithDescription(String string) {
		descriptionTextbox.sendKeys(string);
		
	}
	public void clickOnEmailOptOut() {
		emailOptCheck.click();
	}
	
//Business Library for create organization with industry dropdown
	public void createOrgWithIndustry(String orgName,String industryType,String type) {
		organizationNameEdt.sendKeys(orgName);
		select(industryDropDown,industryType);
		select(typeDropDown,type);
		saveBtn.click();
		
	}
	public void saveTheOrganizationPage() {
		saveBtn.click();
	}

}
