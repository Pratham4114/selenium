package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class readPropFile 
{
	String propPath = "E://Prathamesh//DataDrivenFramework//Properties File//DDconfigfile.properties";
	
	Properties pro = new Properties();
	
	public String readfile(String key) throws Exception
	{
		File file = new File(propPath);
		FileInputStream fis = new FileInputStream(file);
		pro.load(fis);
		return pro.getProperty(key);
	}
}
