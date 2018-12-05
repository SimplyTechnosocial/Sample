package com.justrechargeit.utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.justrechargeit.base.TestBase;


public class DataProviderClass extends TestBase{

	static excelReader xlsFile=null;
	static String testName=null;
	static String[][] tabArray=null;
	static String className;
	static int newRowIndex;
	
	//set fileLocation, sheetName, className;
		public static void setUp(String fileLocation, String sheetName,String myClassName) {
			
			try {
				xlsFile=new excelReader(fileLocation);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			testName=sheetName;
			className=myClassName;		
			//logger.log(LogStatus.INFO, "Excel Program parameter set up successfully");
		}
		
		//Get data from excel
		
		public static String[][] getData(){
			int rowCount, colCount;
			rowCount=xlsFile.getRowCount(testName);
			colCount=xlsFile.getColCount(testName);
			
			tabArray=new String[rowCount-1][colCount];
			
			newRowIndex=0;
			for(int cellRow=1;cellRow<rowCount;cellRow++)
			{
				try {
					
					if(xlsFile.readCell(testName,cellRow,0).equals(className))
					{
						for(int cellColoumn=0;cellColoumn<colCount;cellColoumn++)
						{
							
				tabArray[newRowIndex][cellColoumn]=xlsFile.readCell(testName,cellRow,cellColoumn);
							
						}
						newRowIndex+=1;
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		//	logger.log(LogStatus.INFO, "Excel Data Read Successfully");
			
			
		String[][] newTabArray=new String[newRowIndex][colCount];
		
		for(int cellRow=0;cellRow<newRowIndex;cellRow++){
			for(int cellColoumn=0;cellColoumn<colCount;cellColoumn++){
				newTabArray[cellRow][cellColoumn]=tabArray[cellRow][cellColoumn];	
			}
		}
		//logger.log(LogStatus.INFO, "Returing 2 dimentional data for "+className);
		return (newTabArray);
		}
		
		//Create dataprovider
		@DataProvider(name="xlsData")
		public static Object[][] createData1(){
			System.out.println("Data");
			Object[][] retObjArr=getData();
			//logger.log(LogStatus.INFO, "Returing 2 Dimentional data objects successfully");	
			return retObjArr;
			}


		
}
