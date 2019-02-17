package com.fpix.utilities.Lern;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.fpix.base.Lern.TestBase;

public class TestUtilities extends TestBase {

	public static String screenshotPath;
	public static String screenshotName;
	public static void captureScreenshot() throws IOException {
		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

				
				File scrFile = (File) ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir") + "\\Test-ScreenShots\\" +screenshotName));
}
	

	
	
	@DataProvider(name = "dp")
	public Object[][] getData(Method m){
		
		String sheetName = m.getName();
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getColumnCount(sheetName);
		
		Object[][] data = new Object[rows-1][cols];
		for(int rowNum = 2; rowNum<=rows; rowNum++) {
			for (int colNum = 0; colNum<cols; colNum++) {
				data[rowNum-2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}
	
	
	public static boolean isTestRunnable(String testName, ExcelReader excel){
		
		String sheetName = "TestSuite";
		
		int rows = excel.getRowCount(sheetName);
		
		for(int rowNum = 2; rowNum<=rows; rowNum++){
		String testCase = excel.getCellData(sheetName, "TC_Name", rowNum);
		if(testCase.equalsIgnoreCase(testName)){
			
			String runmode = excel.getCellData(sheetName, "Runnable", rowNum);
			
			if(runmode.equalsIgnoreCase("Y")){
				return true;
			}else{
				return false;
			}
		}
		
	}
		return false;
		}
}
