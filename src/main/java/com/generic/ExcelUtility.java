package com.generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	/*
	 * @Author Srivani
	 * Read the data from Excel
	 * @param rownum
	 * @param sheetname
	 * @param Cellnum
	 * return data from excel sheet
	 * EncryptedDocumentException, IOException
	 */
	public String readdatafromExcel(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstance.Excelsheetfilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		Row r = sh.getRow(rownum);
		Cell cel = r.getCell(cellnum);
		String stringCellValue = cel.getStringCellValue();
		return stringCellValue;
	}
	
	/*
	 * @Author Srivani
	 * Read the data from Excel
	 * @param file path
	 * @param rownum
	 * @param sheetname
	 * @param Cellnum
	 * return data from excel sheet
	 * EncryptedDocumentException, IOException
	 */
	public String readdatafromExcel( String path, String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(path);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
		Row r = sh.getRow(rownum);
		Cell cel = r.getCell(cellnum);
		String stringCellValue = cel.getStringCellValue();
		return stringCellValue;
	}
	
	/* @Author Srivani
	 * write the data from Excel
	 * @param file path
	 * @param rownum
	 * @param sheetname
	 * @param Cellnum
	 * @param value
	 * IOException
	 * 
	 */
	
	public void writedatainexcel(String sheetname, int rownum, int cellnum, String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(IConstance.Excelsheetfilepath);
		Workbook book = WorkbookFactory.create(fis);
		Sheet sh = book.getSheet(sheetname);
         Row r = sh.getRow(rownum);	
         Cell cel = r.createCell(cellnum);
         cel.setCellValue(value);
		FileOutputStream fos=new FileOutputStream(IConstance.Excelsheetfilepath);
		book.write(fos);
		fos.flush();
	}
	
	/* @Author Srivani
	 * get last row
	 * @param rownum
	 * @param sheetname
	 * @param Cellnum
	 * return count of lastrow
	 * EncryptedDocumentException, IOException 
	 */
     public int getrowcount(String sheetname) throws EncryptedDocumentException, IOException {
    	 
 		FileInputStream fis=new FileInputStream(IConstance.Excelsheetfilepath);
 		Workbook book = WorkbookFactory.create(fis);
 		Sheet sh = book.getSheet(sheetname);
 		int lastRowNum = sh.getLastRowNum();
 		return lastRowNum;

     }

}
