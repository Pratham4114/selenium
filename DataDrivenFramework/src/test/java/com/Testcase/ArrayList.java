package com.Testcase;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Utilities.baseTest;
import com.Utilities.readPropFile;
import com.pageobjects.loginPage;

public class ArrayList extends baseTest
{
	readPropFile prop = new readPropFile();
	@Test
	(dataProvider = "logindata")
	public void logintest(String email, String password)
	{
		loginPage.clickOnLoginLink(driver).click();
		loginPage.enterEmail(driver).sendKeys(email);
		loginPage.enterPassword(driver).sendKeys(password);
		loginPage.submit(driver).click();
	}
	
	@DataProvider(name = "logindata")
	public Object[][] getData() throws Exception
	{
		
		String filepath = prop.readfile("excelFilePath");
		   File file = new File(filepath);
		    FileInputStream fis = new FileInputStream(file);

		    XSSFWorkbook wb = new XSSFWorkbook(fis);
		    XSSFSheet sheet = wb.getSheetAt(0);
		    wb.close();
		    int lastRowNum = sheet.getLastRowNum() ;
		    int lastCellNum = sheet.getRow(0).getLastCellNum();
		    Object[][] obj = new Object[lastRowNum][1];

		    List<Object> list = (List<Object>) new ArrayList();
		    for (int i = 0; i < lastRowNum; i++) 
		    {
		      	      for (int j = 0; j < lastCellNum; j++) 
		      	      {
		        System.out.println(list.add(sheet.getRow(0).getCell(j).toString()));
		        //.put(sheet.getRow(0).getCell(j).toString(), sheet.getRow(i+1).getCell(j).toString());
		        //System.out.println(datamap.keySet());
		      }
		      obj[i][0] = list;
		    }
		    return  obj;
	}

}
