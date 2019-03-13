package com.Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class baseTest 
{
	readPropFile pro = new readPropFile();
	selectBrowser s = new selectBrowser();
	public WebDriver driver;
	
	@BeforeMethod
	public void launchBrowser() throws Exception
	{
		String url = pro.readfile("url");
		driver = s.getBrowser();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
}
