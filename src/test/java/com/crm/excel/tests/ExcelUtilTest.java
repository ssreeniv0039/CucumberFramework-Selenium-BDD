package com.crm.excel.tests;

import com.crm.excel.utility.Xls_Reader;

public class ExcelUtilTest {

	public static void main(String[] args) {
		Xls_Reader reader = new Xls_Reader("C:\\Users\\shash\\Documents\\Edureka_Workspace\\CucumberTestNGFreeCRM\\src\\main\\java\\com\\crm\\testdata\\RunManager.xlsx");
		String sheetName = "RunManager";

		int rowCount = reader.getRowCount(sheetName);
		System.out.println("No of rows : "+ rowCount);
		
		for(int rowNum = 2; rowNum<=rowCount;rowNum++) {
			String appName = reader.getCellData(sheetName, "Application", rowNum);
			String flag =reader.getCellData(sheetName, "Flag", rowNum);
			  if(flag.equals("Yes")) {
				  runApplicationTest(appName);
			  }
			  else if(flag.equals("No"))
			  {
			  System.out.println("Ignore ApplicationTest"); 
			  } 
		}
	}
	
	public static void runApplicationTest(String appName) {

		  Xls_Reader reader = new Xls_Reader("C:\\Users\\shash\\Documents\\Edureka_Workspace\\CucumberTestNGFreeCRM\\src\\main\\java\\com\\crm\\testdata\\Glass.xlsx");
		  String sheetName = appName;
		  int rowCount = reader.getRowCount(sheetName);
		  for(int rowNum = 2; rowNum<=rowCount;rowNum++){
			 String testCaseFlag = reader.getCellData(sheetName, "FLAG", rowNum);
			 if(testCaseFlag.equals("Yes")) {
				 System.out.println("Run the test case");
			 }else {
				 System.out.println("Ignore test case"); 
			 }
		  } 
		  
	}

}
