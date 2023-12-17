package com.restAPI.apiTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcel {
	public static Object[][]readExcel(String filePath,String sheetName) throws Exception{
		FileInputStream fs =new FileInputStream(filePath);
		Workbook workbook=WorkbookFactory.create(fs);
		org.apache.poi.ss.usermodel.Sheet sheet= workbook.getSheet(sheetName);
		int rowCount=sheet.getPhysicalNumberOfRows();
		int columnCount=sheet.getRow(0).getPhysicalNumberOfCells();
		Object[][]data=new Object[rowCount-1][columnCount];
		
		for(int i=1;i<rowCount;i++) {
			Row row=sheet.getRow(i);
			for(int j=0;j<columnCount;j++) {
		        Cell cell = row.getCell(j);
		        data[i - 1][j] = cell.toString();
		        workbook.close();
		        fs.close();
		        return data;

			}
		}
		
		
		return null;
		
	}

}
