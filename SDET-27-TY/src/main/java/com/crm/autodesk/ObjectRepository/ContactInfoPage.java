package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage { //Step-1
	
//Step-2-

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement conHeaderText;
	
//Step-3-
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	
	
//Step-4-
	
	public WebElement getConHeaderText() {
		return conHeaderText;
	}
	
//Step-5-
	public String getConInfo() {
		return(conHeaderText.getText());
		
	}
}
