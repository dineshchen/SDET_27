package com.crm.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderPracticeTest {

	@Test(dataProvider = "getData")
	public void readDataFromProviderTest(String name,int qty) {
		System.out.println("Mobile Name--->"+name+"Mobile Quantity"+qty);
	}
@DataProvider
public Object[][] getData()
{
	Object[][] objArr=new Object[3][2];
	
	objArr[0][0]="OnePlus";
	objArr[0][1]=10;
	
	objArr[1][0]="Samsung";
	objArr[1][1]=20;
	
	objArr[2][0]="Nokia";
	objArr[2][1]=30;
	
	return objArr;
	
	
	
}
}
