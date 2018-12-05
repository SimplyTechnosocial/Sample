package com.justrechargeit.utility;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class excelReader {
	String excelPath;
	FileInputStream fis ;
	Workbook workbook ;
	Sheet sheet;
	Row row;
	
	public excelReader(String path) throws Exception 
	{
		fis = new FileInputStream(path);		
		workbook = new HSSFWorkbook(fis);
		fis.close();
	}
	
	public String readCell(String sheetName,int rowNumber, int colNumber ) throws Exception
	{
		//workbook.getSheetIndex(sheetName);  -- This will return -1 if sheet is not present in your worksheet.
		sheet=workbook.getSheet(sheetName);
		row = sheet.getRow(rowNumber);
		if (row==null)
		{
			return "";
		}
		
		Cell cell = row.getCell(colNumber);
		DataFormatter df=new DataFormatter();
		String data=df.formatCellValue(cell);
		//String data =cell.getStringCellValue();
		return data;
		
	}
		public int getRowCount(String sheetName)
		{
			sheet=workbook.getSheet(sheetName);
			int rowNumber=sheet.getLastRowNum();
			return rowNumber+1;			
		}
		public int getColCount(String sheetName)
		{
			sheet=workbook.getSheet(sheetName);
			row=sheet.getRow(0);
			if (row==null)
			{
				return 0;
			}
			
			int colNumber=row.getLastCellNum();
			return colNumber;
		}
		
		
	}
