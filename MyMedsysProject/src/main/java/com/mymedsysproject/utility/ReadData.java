/**
 * 
 */
package com.mymedsysproject.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;


/**
 * 
 *Author: Ayodeji
  * Date: 2023
 */
public class ReadData {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 */
	  
	  public static void main(String[] args) throws EncryptedDocumentException, IOException {
	        // TODO: Your code here
	    }
        @DataProvider(name ="logindata")
	    public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
        	String excelSheetName = m.getName();// This is to mirror the name of the method and the excel so as to refelct on the data
        	// This method reads the files from the data or excelsheet
	        File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\MyTestData.xlsx");
	        FileInputStream fils = new FileInputStream(f);
	        Workbook wb = WorkbookFactory.create(fils);
	        Sheet sheetName = wb.getSheet(excelSheetName);
	        // This is to get the total rows and column
	        int totalRows = sheetName.getLastRowNum();
	       // This is to get the total rows
	        Row rowCells = sheetName.getRow(0);
	        int  totalCols =  rowCells.getLastCellNum();
	       
	        // This is to format the data to a readable data because data could be integers or string but formating it will make i understandable for the system
	        DataFormatter format = new DataFormatter();
	        String testData[][] = new String [totalRows][totalCols];
	         for(int i=1; i<=totalRows; i++) {
	        	 for(int j=0; j<totalCols;j++) {
	        		 testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
	        				
	        	 }
	         }
	         
	         return testData;
	        
	       
	    }

}
