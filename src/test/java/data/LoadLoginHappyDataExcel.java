package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoadLoginHappyDataExcel {
    
    FileInputStream stream = null;

    public FileInputStream getExcelFileSheet() throws FileNotFoundException {
        // Step 1: Define the Path for the Login Excel File
        String path = System.getProperty("user.dir") + "\\src\\test\\java\\data\\Excel\\loginData.xlsx";
        stream = new FileInputStream(path);
        return stream;
    }

    public Object[][] getExcelFileData() throws IOException { 
        
        // Step 2: Initialize Workbook and Access the Target Sheet
        stream = getExcelFileSheet();
        XSSFWorkbook workbook = new XSSFWorkbook(stream); 
        XSSFSheet loginHappySheet = workbook.getSheet("loginHappyData");
        
        int nRows = loginHappySheet.getLastRowNum() + 1;
        int nCols = 2;

        Object[][] loginHappyData = new Object[nRows][nCols];

        // Step 3: Iterate through Rows and Columns to Read Data
        for (int i = 0; i < nRows; i++) {
            XSSFRow row = loginHappySheet.getRow(i);
            
            for (int j = 0; j < nCols; j++) {
                // Step 4: Extract Cell Value and Store it in the 2D Array
                loginHappyData[i][j] = row.getCell(j).toString();
            }
        }
        
        // Step 5: Close the Workbook and Return the Data Array
        workbook.close();
        return loginHappyData; 
    }

}