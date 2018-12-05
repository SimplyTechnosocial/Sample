package com.justrechargeit.utility;

import org.testng.annotations.Test;

public class TestExcelProgram 
{
	@Test
	public void testmethod () {
		DataProviderClass.setUp(".//TestData//Login.xlsx","Login","LoginWithInValidData");
		
		String[][] testArray=DataProviderClass.getData();
	
	for(int i=0; i<DataProviderClass.newRowIndex;i++)
	{
		for (int j=0; j<4;j++)
		{
			System.out.print(testArray[i][j]+ "|| ");
			
		}
		System.out.println();
		
	}

	}
	}
