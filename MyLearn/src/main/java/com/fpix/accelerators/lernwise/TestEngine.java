package com.fpix.accelerators.lernwise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class TestEngine {
	
	
	public static Properties prop;
	public static FileInputStream ip;

	public static String URL;
	public void getURL() throws IOException{
		
		prop = new Properties();
		ip = new FileInputStream(
				"C://Users//prashanthi//workspace//Lernwise1//src//com//mySel//config.properties");
		prop.load(ip);
		URL = prop.getProperty(URL);
		
	}
}
