package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {  //Step 1-

//Step-2-
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createContactLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement searchTextEdt;
	
	@FindBy(name="submit")
	private WebElement searchNowBtn;
	

	
//Step 3-
	public ContactsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
//Step-4-
	public WebElement getCreateContactLookUpImg() {
		return createContactLookUpImg;
	}

	public WebElement getSearchTextEdt() {
		return searchTextEdt;
	}



	public WebElement getSearchNowBtn() {
		return searchNowBtn;
	}
	
//Business Library
	public void clickOnCreateContact() {
		createContactLookUpImg.click();
		
	}
	
	
	
}
