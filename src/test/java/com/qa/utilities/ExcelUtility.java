package com.qa.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtility {
	
	
	public static FileInputStream fileLoc;
	public static XSSFWorkbook xBook;
	public static XSSFSheet xSheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	// method to fetch the row count
	
	public static int getRowCount(String xFile, String xSheetName) throws IOException
	{
		fileLoc = new FileInputStream(xFile);		
		xBook = new XSSFWorkbook(fileLoc);
		xSheet = xBook.getSheet(xSheetName);		
		int rowCount = xSheet.getLastRowNum();			
		return rowCount;
	}
	
	
	
	// method to fetch cell count from each row
	
	public static int getCellCount(String xFile, String xSheetName, int rowNum) throws IOException {
		fileLoc = new FileInputStream(xFile);		
		xBook = new XSSFWorkbook(fileLoc);
		xSheet = xBook.getSheet(xSheetName);	
		row = xSheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		return cellCount;
		
	}
	
	// method to read the data from every cell in string format.
	
	public static String getCellData(String xFile, String xSheetName, int rowNum, int cellNum) throws IOException {
	
		fileLoc = new FileInputStream(xFile);		
		xBook = new XSSFWorkbook(fileLoc);
		xSheet = xBook.getSheet(xSheetName);
		row = xSheet.getRow(rowNum);
		cell =  row.getCell(cellNum);
		
		
		DataFormatter format = new DataFormatter();
		String cellData = format.formatCellValue(cell);
		
		fileLoc.close();
		xBook.close();
		
		return cellData;
		
	}
	
	

}
