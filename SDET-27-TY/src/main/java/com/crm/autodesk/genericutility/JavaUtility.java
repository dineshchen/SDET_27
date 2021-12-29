package com.crm.autodesk.genericutility;

import java.util.Date;
import java.util.Random;

/**
 * 
 * @author Gopinath
 *
 */
public class JavaUtility {
	/**
	 * This methosd is used to give random number in required area
	 * @return
	 */
	public int getRanDomNumber() {
		Random random=new Random();
		int intRandom=random.nextInt(10000);
		return intRandom;
	}
	/**
	 * This method is used to fetch the system date & time
	 * @return
	 */
public String getSystemDateAndTime() {
	Date date =new Date();
	return date.toString();
	
}
/**
 * This method is used to get the Date and Time in required Format
 * @return
 */
public String getSystemDateWithFormat() {
	Date date=new Date();
	String DateAndTime=date.toString();
	
	String YYYY=DateAndTime.split(" ")[5];
	String DD=DateAndTime.split("")[2];
	int MM=date.getMonth()+1;
	
	String finalFormat=YYYY+"-"+MM+"-"+DD;
	return finalFormat;
	
	
}
}
