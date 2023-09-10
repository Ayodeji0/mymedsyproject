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

    @DataProvider(name = "logindata")
    public Object[][] getData(Method m) throws EncryptedDocumentException, IOException {
        String excelSheetName = m.getName();
        File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\MyTestData.xlsx");
        FileInputStream fils = new FileInputStream(f);
        Workbook wb = WorkbookFactory.create(fils);
        Sheet sheetName = wb.getSheet(excelSheetName);
        int totalRows = sheetName.getLastRowNum();
        int totalCols = sheetName.getRow(0).getLastCellNum();

        // Initialize the data array with the correct dimensions
        Object[][] testData = new Object[totalRows][totalCols];

        DataFormatter format = new DataFormatter();
        for (int i = 0; i < totalRows; i++) {
            Row row = sheetName.getRow(i + 1); // Start from 1 to skip the header row
            for (int j = 0; j < totalCols; j++) {
                testData[i][j] = format.formatCellValue(row.getCell(j));
            }
        }

        return testData;
    }
}