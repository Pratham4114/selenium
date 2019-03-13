package com.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class selectBrowser 
{
	readPropFile prof = new readPropFile();
	
	public WebDriver driver;
	
	public WebDriver getBrowser() throws Exception
	{
		String browser = prof.readfile("browser");
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","E:/Browsers Driver/GeckoDriver/geckodriver-v0.20.0-win64/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E://Browsers Driver//ChromeDriver//chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else
		{
			System.setProperty("webdriver.ie.driver", "E://Browsers Driver//IEDriver//IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		return driver;
	}
}
