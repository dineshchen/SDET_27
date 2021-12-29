package AssignmentTestScriptOrganization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.autodesk.ObjectRepository.CreateNewOrganizationsPage;
import com.crm.autodesk.ObjectRepository.HomePage;
import com.crm.autodesk.ObjectRepository.LoginPage;
import com.crm.autodesk.ObjectRepository.OrganizationInfoPage;
import com.crm.autodesk.ObjectRepository.OrganizationsPage;
import com.crm.autodesk.genericutility.ExcelUtility;
import com.crm.autodesk.genericutility.FileUtility;
import com.crm.autodesk.genericutility.JavaUtility;
import com.crm.autodesk.genericutility.WebDriverutility;

public class OrganizationWithAssignedToUserAsAdministrator {

	public static void main(String[] args) throws Throwable {

		FileUtility fLib=new FileUtility();
		ExcelUtility eLib=new ExcelUtility();
		JavaUtility jLib=new JavaUtility();
		WebDriverutility wdLib=new WebDriverutility();
		

		
		String browser=fLib.getPropertyKeyValue("browser");
		String url=fLib.getPropertyKeyValue("url");
		String username=fLib.getPropertyKeyValue("username");
		String password=fLib.getPropertyKeyValue("password");
		
		int randomNum=jLib.getRanDomNumber();
		String orgName=eLib.getDataFromExcel("Org", 4, 2)+randomNum;
		
		WebDriver driver;
		if(browser.equals("FireFox"))
		{
			driver=new FirefoxDriver();
		}else if(browser.equals("Edge"))
		{
			driver=new EdgeDriver();
		}else {
			driver= new ChromeDriver();
		}
		driver.get(url);
		wdLib.waitForPageToLoad(driver);
		
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);

		
		HomePage hp=new HomePage(driver);
		hp.clickOnOrganizationsLink();
		
		
		OrganizationsPage op=new OrganizationsPage(driver);
		op.clickOnCreateOrg();
		
		CreateNewOrganizationsPage cnop=new CreateNewOrganizationsPage(driver);

        cnop.createOrg(orgName);
        cnop.createOrgWithDescription("[ CAM** ] abc - Campaign Information   Updated today");
		
        OrganizationInfoPage oip=new OrganizationInfoPage(driver);
        
		String wb=oip.getOrgInfo();
		if(wb.contains("abc")) {
			System.out.println("Required msg is added"+"\t "+wb);
		}else
		{
			System.out.println("Required msg is not added");
		}
	    
	    
	    hp.logout(driver);
	   
		
		
		
	}

}
