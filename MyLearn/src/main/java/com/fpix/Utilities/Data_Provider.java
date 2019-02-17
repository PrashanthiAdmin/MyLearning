package com.fpix.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class Data_Provider {

	
	public static String filePath = "C://Users//prashanthi//workspace//Lern//src//Testing.xls";
	public static 	Workbook workbook;
	public static Sheet sheet;
	//public static FileInputStream fis;
	public static String[] tableHeader, data;
	public static HashMap<String, String> tstData = null;
	static DateFormat dateFormat;

	/*public static void main(String[] args) throws IOException {

		tstData = getTestData("Login", "TestCase");
		String url = tstData.get("URL");
		String Password = tstData.get("Password");
		System.out.println(url + Password);
	}*/

	public static HashMap<String, String> getTestData(String sheetName, String tcName) throws IOException, Throwable {

		//fis = new FileInputStream(filePath);
		workbook = Workbook.getWorkbook(new File(filePath));
		sheet = workbook.getSheet(sheetName);

		int rows = sheet.getRows();
		//Row row = sheet.getRow(0);
		int cols = sheet.getColumns();
		String[] tabHeader = new String[cols];
		String[] data = new String[cols];

		HashMap<String, String> result = new HashMap<String, String>();
		for (int i = 0; i <= cols-1; i++) {
			tabHeader[i] = sheet.getCell(i, 0).getContents();
			// System.out.println(tabHeader[i]);
		}

		for (int j = 1; j <rows; j++) {
			for (int k = 0; k <cols; k++) {
				data[k] = sheet.getCell(k, j).getContents();
				// System.out.println(data[k]);
			}
		}
		for (int m = 0; m < tabHeader.length; m++) {
			result.put(tabHeader[m], data[m]);

		}

		// System.out.println(result);
workbook.close();
		//fis.close();
		return result;

	}
	
	public static String captureScreen(WebDriver driver, String screenName) throws IOException{
	     //dateFormat = new SimpleDateFormat("yyyy_MM_dd SSS");
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		
		String dest = System.getProperty("user.dir")+"//Test-ScreenShots//"+screenName+".png";
		
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		
		return dest;
	}

/*	public static String generateFileName(String result){
		Date date = new Date();
		String fileName = result.getName()+ "_" + dateFormat.format(date);
		return fileName;
		
	}*/

}
