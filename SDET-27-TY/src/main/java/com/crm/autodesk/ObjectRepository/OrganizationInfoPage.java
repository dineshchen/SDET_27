package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	@FindBy(xpath="//td[@id='mouseArea_Description']")
	private WebElement descriptionTextMsg;
	
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industry;
	
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement type;
	
	public OrganizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getIndustry() {
		return industry;
	}

	public WebElement getType() {
		return type;
	}

	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	

	public String getOrgInfo()
	{
		return orgHeaderText.getText();
	
	}

	public WebElement getDescriptionTextMsg() {
		return descriptionTextMsg;
	}
	public String fetchCNFMsg() {
		return (orgHeaderText.getText());
	}
	public WebElement getIndustryName() {
		return industry;
		
	}
	public WebElement getTypeName() {
		return type;
		
	}
}
