package com.learnautomation.dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtility {

	static Properties pro;
	
	public static String getValue(String key)
	{
		createInstance();
		return pro.getProperty(key);
	}
	

	public static void createInstance() 
	{	
		if(pro==null)
		{
			System.out.println("LOG-INFO- Creating new session for properties file");
			pro=new Properties();
			try 
			{
				pro.load(new FileInputStream(new File(System.getProperty("user.dir")+"/Config/Config.properties")));
			} 
			catch (FileNotFoundException e) 
			{
				System.out.println("Exception "+e.getMessage());
			} catch (IOException e) 
			{
				System.out.println("Exception "+e.getMessage());
			}
		}
		else
		{
			System.out.println("LOG-INFO-Existing properties object found reusing the same");
		}
	}

}
