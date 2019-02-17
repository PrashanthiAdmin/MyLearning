package com.fpix.rough.Lern;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws FileNotFoundException {
		
		Properties OR = new Properties();
		Properties config = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
		//config.load(fis);

	}

}
