package com.crm.autodesk.genericutility;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * 
 * @author Gopinath
 *
 */
public class WebDriverutility {

	/**
	 *  This method is used to wait for page to be load before identifying synchronized element in HTML DOCUMENT
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
	}
	
	/**
	 * wait for page to load before identifying any Asynchronized [java scripts actions] element
	 *  in the HTML DOCUMENT 
	 * @param driver
	 * 
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) {
		driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);
		}

	/**
	 * used to wait for element to be clickable in GUI & check for specific element for every 500 milliseconds
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver,WebElement element) {
		
		WebDriverWait wait =new WebDriverWait(driver,20); 
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForElementWithCustomTimeOut(WebDriver driver,WebElement element,int pollingTime) throws Throwable {
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.wait(20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 *  used to Switch to Any Window based on Window Title
	 * @param driver
	 * @param partialWindowTitle
	 */
public void switchToWindow(WebDriver driver,String partialWindowTitle) {
	Set<String>set=driver.getWindowHandles();
    Iterator<String>it=set.iterator();
    
    while(it.hasNext())
    {
    	String wID=it.next();
    	driver.switchTo().window(wID);
    	String currentWindowTitle=driver.getTitle();
    	if(currentWindowTitle.contains(partialWindowTitle)) {
    		break;
    	}
    	
    }
    	}
/**
 * used to Switch to Alert Window & click on OK button
 * @param driver
 */
    public void switchToAlertWindowAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
    }
    /**
     * used to Switch to Alert Window & click on Cancel button
     * @param driver
     */
    public void switchToAlertWindowAndCance(WebDriver driver) {
    	driver.switchTo().alert().dismiss();
    }
    /**
     * used to Switch to Frame Window based on index
     * @param driver
     * @param index
     */
    public void switchToFrame(WebDriver driver,int index) {
    	driver.switchTo().frame(index);
    }
    /**
     * used to Switch to Frame Window based on attribute
     * @param driver
     * @param id_name_attribute
     */
    public void switchToFrame(WebDriver driver,String id_name_attribute)
    {
    	driver.switchTo().frame(id_name_attribute);
    }
    /**
     * used to select the value from the dropDown  based on index
     * @param element
     * @param index
     */
    public void select(WebElement element,int index)
    {
    	Select sel=new Select(element);
    	sel.selectByIndex(index);
    }
    public void select(WebElement element,String VisibleText)
    {
    	Select sel=new Select(element);
    	sel.selectByVisibleText(VisibleText);
    }
    /**
     * used to place mouse cursor on specified element
     * @param driver
     * @param element
     */
    public void mouseOverOnElement(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(element).perform();
    }
    /**
     * used to right click  on specified element
     * @param driver
     * @param element
     */
    public void rightClickOnElement(WebDriver driver,WebElement element)
    {
    	Actions act=new Actions(driver);
    	act.moveToElement(element).perform();
    }
    /**
     * used for scroll handling
     * @param driver
     * @param javaScript
     */
    public void executeJavaScript(WebDriver driver,String javaScript) {
    	JavascriptExecutor js=(JavascriptExecutor)driver;
    	js.executeAsyncScript(javaScript, null);
    }
    /**
     * 
     * @param element
     * @throws Throwable
     */
    public void waitAndClick(WebElement element) throws Throwable {
    	int count=0;
    	while(count<20) {
    		try {
    			element.click();
    			break;
    		}catch(Throwable e) {
    			Thread.sleep(1000);
    			count++;
    			
    		}
    	}
}
    /**
     * used to capture screenshot and store in a file with format .png
     * @param driver
     * @param screenshotName
     * @throws Throwable
     */
    public void takeScreenShot(WebDriver driver,String screenshotName) throws Throwable {
    	TakesScreenshot ts= (TakesScreenshot)driver;
    	File src=ts.getScreenshotAs(OutputType.FILE);
    	File dest=new File("./screenshot/"+screenshotName+".PNG");
    	Files.copy(src, dest);
    }
    /**
     * used to handle mouse actions
     * @param driver
     */
    public void passEnterKey(WebDriver driver)
    {
    	Actions act=new Actions(driver);
    	act.sendKeys(Keys.ENTER).perform();
    }
    /**
     * This method is used to maximize the current window
     * @param driver
     */
    public void windowMaximize(WebDriver driver)
    {
    	driver.manage().window().maximize();
    }
}

