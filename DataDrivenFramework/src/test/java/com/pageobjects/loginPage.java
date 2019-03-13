package com.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage 
{
	
	public static WebElement clickOnLoginLink(WebDriver driver)
	{
		return driver.findElement(By.linkText("Log in"));
	}
	
	public static WebElement enterEmail(WebDriver driver)
	{
		return driver.findElement(By.id("Email"));
	}
	
	public static WebElement enterPassword(WebDriver driver)
	{
		return driver.findElement(By.id("Password"));
	}
	
	public static WebElement submit(WebDriver driver)
	{
		return driver.findElement(By.xpath("//input[@value='Log in']"));
	}

}
