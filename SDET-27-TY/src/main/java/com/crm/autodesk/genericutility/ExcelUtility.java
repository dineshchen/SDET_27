package com.crm.autodesk.genericutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author Gopinath
 *
 */
public class ExcelUtility {

	/**
	 * It is used to read data from Excel Sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
public String getDataFromExcel (String sheetName,int rowNum,int cellNum) throws Throwable
{
	FileInputStream fis = new FileInputStream("./Data/TestScriptData.xlsx");
	Workbook wb= WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNum);
	String data=row.getCell(cellNum).getStringCellValue();
	wb.close();
	return data; 
		
}
/**
 * It is used to get last row data in particular excel
 * @param sheetName
 * @return
 * @throws Throwable
 */
public int getRowCount(String sheetName) throws Throwable
{
	FileInputStream fis=new FileInputStream("./Data/TestScriptData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	wb.close();
	return sh.getLastRowNum();
	
  }
/**
 * It is used to get number of rows present in the Excel
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @throws Throwable 
 * @throws  
 * @throws  
 */

/**
 * It is used to write data in Excel in required location/cell
 * @param sheetName
 * @param rowNum
 * @param cellNum
 * @param data
 * @throws Throwable
 */
public void setDataExcel(String sheetName,int rowNum,int cellNum,String data) throws Throwable  {
	
	FileInputStream fis = new FileInputStream("./Data/TestScriptData.xlsx");
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh = wb.getSheet(sheetName);
	Row row = sh.getRow(rowNum);
	Cell cell = row.createCell(cellNum);
	cell.setCellValue(data);
	FileOutputStream fos=new FileOutputStream("./Data/TestScriptData.xlsx");
	wb.write(fos);
	wb.close();
}
}
