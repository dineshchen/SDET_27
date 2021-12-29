package com.crm.autodesk.genericutility;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation implements ITestListener{
 
	public void onTestStart(ITestResult result)
	{
		
	}
	public void onTestSuccess(ITestResult result)
	{
		
	}
	public void onTestFailure(ITestResult result)
	{
	//capture the method name
		String methodName=result.getMethod().getMethodName();
		
		//capture the current date
		String CurrentDate=new JavaUtility().getSystemDateWithFormat();
		
		//concatenation for screenshot name
		String screenShotName=methodName+"_"+CurrentDate;
		
		
		try {
			new WebDriverutility().takeScreenShot(BaseClass.sdriver, screenShotName);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void onTestSkipped(ITestResult result) {
		
	}
}
