package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class readExcelFile 
{ 
	readPropFile prop = new readPropFile();
	//Logger log = Logger.getLogger(readExcelFile.class);
	FileInputStream fis;
	
	public  FileInputStream getFileInputStream() throws Exception
	{
		    
		String filepath = prop.readfile("excelFilePath");
		File srcfile = new File(filepath);
		try 
		{
			fis = new FileInputStream(srcfile);
		} 
		catch (FileNotFoundException e) 
		{
			//log.fatal("TestData File is not found. terminating process !!! "
			//+ "Check Configuration file for file path of TestData file");
			System.exit(0);	
		}
		return fis;
				
	}
	  
	public Object[][] getExcelData() throws Exception
	{
		fis = getFileInputStream();
			    
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
			    
		int TotalNumberOfRows = (sheet.getLastRowNum()+1);
		int TotalNumberOfCols =2;
			    
		Object[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfCols];
			    
		for (int i = 0; i<TotalNumberOfRows; i++)
		{
			for (int j=0; j<TotalNumberOfCols; j++)
			{
				XSSFRow row = sheet.getRow(i);

			    //String cellData = row.getCell(j).toString();
			    arrayExcelData[i][j] = row.getCell(j).toString();
			}
		}
		wb.close();
		return arrayExcelData;
	}
}


