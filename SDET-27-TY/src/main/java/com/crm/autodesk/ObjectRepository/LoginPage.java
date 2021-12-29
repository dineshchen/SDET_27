package com.crm.autodesk.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.autodesk.genericutility.WebDriverutility;

public class LoginPage extends WebDriverutility {  //Step 1-Create a seperate class for a Login webpage

	//Step 2-Identify all the webelements and declare them as private
	@FindBy(name="user_name")
	private WebElement usernameEdt;
	
	@FindBy(name="user_password")
	private WebElement userpasswordEdt;
	
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	
	//Step 3-Initialize the elements using constructor
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	//Step 4-Utilization provides getter methods

	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getUserpasswordEdt() {
		return userpasswordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	//Step 4-Business Library
	public void login(String username,String password)
	{
		usernameEdt.sendKeys(username);
		userpasswordEdt.sendKeys(password);
		loginBtn.click();
	}
}
