package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
/**
 * 
 * @author Gopinath
 *
 */
public class FileUtility {
/**
 * This method is used to get string key from properties file to java
 * @param key
 * @return
 * @throws Throwable
 */
	public String getPropertyKeyValue(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./Data/CommonData.properties");
		Properties prop=new Properties();
		prop.load(fis);
		String value=prop.getProperty(key);
		return value;
	}
	
}




























