package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverutility;

public class CreateContactPage extends WebDriverutility { //Step-1-
	
//Step-2-
@FindBy(name="lastname")
private WebElement contactNameEdt;

@FindBy(xpath="//input[@name='account_name']/following-sibling::img")
private WebElement orgNameLookUpImg;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

@FindBy(xpath="//input[@class='crmbutton small create']")
private WebElement searchBtn;

//Step-3-
public CreateContactPage(WebDriver driver) {
	PageFactory.initElements(driver, this);
}


//Step 4-
public WebElement getContactNameEdt() {
	return contactNameEdt;
}

public WebElement getOrgNameLookUpImg() {
	return orgNameLookUpImg;
}

public WebElement getSaveBtn() {
	return saveBtn;
}

//Step 5-
public void CreateContact(String lastName) {
	contactNameEdt.sendKeys(lastName);
	orgNameLookUpImg.click();
	saveBtn.click();
	
	

}


}
