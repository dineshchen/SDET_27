package com.crm.practice;

import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class RetryAnalyzerDemo {
@Test(retryAnalyzer = com.crm.autodesk.genericutility.RetryAnalyzerImplementation.class)

public void retryAnalyzerDemoTest()
{
	Reporter.log("script failed",true);
	System.out.println("RetryAnalyzer");
    Assert.fail();
}
	
	
}
