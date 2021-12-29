package com.crm.practice;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.crm.autodesk.genericutility.ListnerImplementation.class)
public class SampeTestListener {

	@Test
	public void sampleTestListener() {
		System.out.println("=======Test Start=====");
		
		Assert.assertEquals(false, true);
		
		System.out.println("========Test End=======");
	}
}
