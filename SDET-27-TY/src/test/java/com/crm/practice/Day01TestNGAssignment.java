package com.crm.practice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Day01TestNGAssignment {
@Test(dataProvider = "getData")

public void readDataFromProviderTest(String name,int qty,String colour) {
	System.out.println("Mobile Name--->"+name+"Mobile Quantity"+qty+"Mobile Colour"+colour);
}
@DataProvider
public Object[][] getData()
{
	Object[][] objArr=new Object[5][3];
	
	objArr[0][0]="OnePlus";
	objArr[0][1]=10;
	objArr[0][2]="Black";
	
	objArr[1][0]="Samsung";
	objArr[1][1]=20;
	objArr[1][2]="White";
	
	objArr[2][0]="Nokia";
	objArr[2][1]=30;
	objArr[2][2]="Grey";
	
	objArr[3][0]="Motorola";
	objArr[3][1]=40;
	objArr[3][2]="Blue";
	
	objArr[4][0]="BSNL";
	objArr[4][1]=50;
	objArr[4][2]="Grey";
	
	return objArr;
	
	
}	
}

