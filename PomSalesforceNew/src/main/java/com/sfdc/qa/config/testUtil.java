package com.sfdc.qa.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.format.CellFormat;
import org.apache.poi.ss.format.CellFormatType;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.sfdc.qa.base.TestBase;

public class testUtil extends TestBase{
	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;
	public static String TESTDATA_SHEET_PATH ="/Users/pranalibankar/eclipse-workspace/PomSalesforce/src/main/java/com/sfdc/qa/testData/sdfcTestData.xlsx";

	static Workbook book;
	static Sheet sheet;
	
	public static String[][] getSfdcTestData(String sheetName) throws IOException {
		/*Step 1: Get the XL Path*/
		File xlFile = new File(TESTDATA_SHEET_PATH);

		/*Step2: Access the Xl File*/
		FileInputStream xlDoc = new FileInputStream(xlFile);


		/*Step3: Access the work book */
		XSSFWorkbook wb = new XSSFWorkbook(xlDoc);


		/*Step4: Access the Sheet */
		XSSFSheet sheet = wb.getSheet(sheetName);

		int iRowCount = sheet.getLastRowNum();
		int iColCount = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[iRowCount][iColCount];

		for(int i=0; i<iRowCount; i++){
			for(int j = 0; j<iColCount; j++){
				XSSFCell cell= sheet.getRow(i+1).getCell(j);
				if(cell == null) {
					data[i][j]="";//type cast to string	
				}
				else if(cell.getCellType()==cell.CELL_TYPE_STRING) {
					data[i][j]=cell.getStringCellValue();
				}else if(cell.getCellType()==cell.CELL_TYPE_NUMERIC)  {
					data[i][j]=String.valueOf(cell.getNumericCellValue());//type cast to string
					}else if(cell.getCellType()==cell.CELL_TYPE_BLANK) {
						data[i][j]="";//type cast to string	
					}
			}

		}

		return data;
	}

}
