package com.Testcase;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Utilities.baseTest;
import com.Utilities.readPropFile;
import com.pageobjects.loginPage;

public class loginTestcaseUsingMap extends baseTest {
	// readExcelFile er = new readExcelFile();
	readPropFile prop = new readPropFile();

	@Test(dataProvider = "logindata")
	public void logintest(Map<Object, Object> map) {
		loginPage.clickOnLoginLink(driver).click();
		String email = (String) map.get("UserName");
		String password = (String) map.get("Password");
		loginPage.enterEmail(driver).sendKeys(email);
		loginPage.enterPassword(driver).sendKeys(password);
		loginPage.submit(driver).click();
	}

	@DataProvider(name = "logindata")
	public Object[][] getData() throws Exception {
		String filepath = prop.readfile("excelFilePath");
		File file = new File(filepath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		wb.close();
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[lastRowNum][1];

		for (int i = 0; i < lastRowNum; i++) {
			Map<Object, Object> datamap = new HashMap<>();
			for (int j = 0; j < lastCellNum; j++) {
				datamap.put(sheet.getRow(0).getCell(j).toString(), sheet
						.getRow(i + 1).getCell(j).toString());
				// System.out.println(datamap.keySet());
			}
			obj[i][0] = datamap;
		}
		return obj;
	}
}
