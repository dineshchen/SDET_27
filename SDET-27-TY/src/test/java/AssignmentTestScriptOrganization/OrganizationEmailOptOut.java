package AssignmentTestScriptOrganization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.autodesk.ObjectRepository.CreateNewOrganizationsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverutility;

public class OrganizationEmailOptOut  {
public static void main(String[] args) throws Throwable {
	

	FileUtility fLib=new FileUtility();
	ExcelUtility eLib=new ExcelUtility();
	JavaUtility jLib=new JavaUtility();
	WebDriverutility wdLib=new WebDriverutility(); 
	
	
	String browser=fLib.getPropertyKeyValue("browser");
	String url=fLib.getPropertyKeyValue("url");
	String username=fLib.getPropertyKeyValue("username");
	String password=fLib.getPropertyKeyValue("password");
	
	WebDriver driver;
	if(browser.equals("Firefox"))
	{
		driver=new FirefoxDriver();
	}else if(browser.equals("Edge"))
	{
		driver=new EdgeDriver();
	}else
	{
		driver=new ChromeDriver();
		
	}
	driver.get(url);
	wdLib.windowMaximize(driver);
	wdLib.waitForPageToLoad(driver);
	
	LoginPage lp =new LoginPage(driver);
	lp.login(username, password);
	
	HomePage hp=new HomePage(driver);
	hp.clickOnOrganizationsLink();
	
	OrganizationsPage op=new OrganizationsPage(driver);
	op.clickOnCreateOrg();
	
	//getting random number from generic library
	int randomNum=jLib.getRanDomNumber();
	
	CreateNewOrganizationsPage cnop=new CreateNewOrganizationsPage(driver);
	
	String orgName=eLib.getDataFromExcel("org", 1, 2) + randomNum;

	cnop.clickOnEmailOptOut();   
	cnop.createOrg(orgName);

	WebElement email=cnop.getEmailOptCheck();

	if(email.isEnabled())
	{
		System.out.println("EmailOptField is Enabled");
	}else {
		System.out.println("EmailOptField is Not Enabled");
	}
hp.logout(driver);
	

}
}


