package com.fpix.tests.Lern;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Parameters {

	public static String filePath = "C://Users//prashanthi//workspace//Lern//src//Testing.xlsx";
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static FileInputStream fis;
	public static String[] tableHeader, data;
	public static HashMap<String, String> tstData = null;

	public static void main(String[] args) throws IOException {

		tstData = getTestData("Login", "TestCase");
		String url = tstData.get("URL");
		String Password = tstData.get("Password");
		System.out.println(url + Password);
	}

	public static HashMap<String, String> getTestData(String sheetName, String tcName) throws IOException {

		fis = new FileInputStream(filePath);
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet(sheetName);

		int rows = sheet.getLastRowNum();
		Row row = sheet.getRow(0);
		int cols = row.getLastCellNum();
		String[] tabHeader = new String[cols];
		String[] data = new String[cols];

		HashMap<String, String> result = new HashMap<String, String>();
		for (int i = 0; i <= cols - 1; i++) {
			tabHeader[i] = row.getCell(i).getStringCellValue();
			// System.out.println(tabHeader[i]);
		}

		for (int j = 1; j <= rows; j++) {
			for (int k = 0; k <= cols - 1; k++) {
				data[k] = sheet.getRow(j).getCell(k).getStringCellValue();
				// System.out.println(data[k]);
			}
		}
		for (int m = 0; m < tabHeader.length; m++) {
			result.put(tabHeader[m], data[m]);

		}

		// System.out.println(result);

		fis.close();
		return result;

	}

}
