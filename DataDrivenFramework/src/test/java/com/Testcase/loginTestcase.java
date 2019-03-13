package com.Testcase;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Utilities.baseTest;
import com.Utilities.readExcelFile;
import com.pageobjects.loginPage;

public class loginTestcase extends baseTest
{
	readExcelFile er = new readExcelFile();
	
	@Test(dataProvider = "logindata")
	public void logintest(String user, String password)
	{
		loginPage.clickOnLoginLink(driver).click();
		loginPage.enterEmail(driver).sendKeys(user);
		loginPage.enterPassword(driver).sendKeys(password);
		loginPage.submit(driver).click();
	}
	
	@DataProvider(name = "logindata")
	public Object[][] getData() throws Exception
	{
		return er.getExcelData();
		
	}
}
