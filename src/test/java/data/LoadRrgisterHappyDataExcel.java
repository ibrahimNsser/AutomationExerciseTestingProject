package data;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.crypto.dsig.spec.XSLTTransformParameterSpec;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LoadRrgisterHappyDataExcel {
FileInputStream stream =null;
public FileInputStream getExcelFileSheet() throws FileNotFoundException {
String path =System.getProperty("user.dir")+"/src/test/java/data/Excel/RegisterData.xlsx";
	stream=new FileInputStream(path);
	
	return stream;
}
public Object[][] getExcelFileData() throws IOException{
	
	stream=getExcelFileSheet();
	XSSFWorkbook workbook =new XSSFWorkbook(stream);
	XSSFSheet RegisterHappySheet=workbook.getSheet("RegisterHappyData");
int nRows=RegisterHappySheet.getLastRowNum()+1;
int nCols =17;

Object [][]RrgisterHappyData=new Object[nRows][nCols];

DataFormatter formatter = new DataFormatter();

for (int i=0; i<nRows ;i++) {
	XSSFRow row=RegisterHappySheet.getRow(i);
	for (int j = 0; j < nCols; j++) {
	
        XSSFCell cell = row.getCell(j);
        
       
        if (cell == null || cell.getCellType() == CellType.BLANK) {
            RrgisterHappyData[i][j] = ""; 
        } else {
        	RrgisterHappyData[i][j] = formatter.formatCellValue(cell); 
     
        }
}
}

workbook.close();
return RrgisterHappyData;
}

}
