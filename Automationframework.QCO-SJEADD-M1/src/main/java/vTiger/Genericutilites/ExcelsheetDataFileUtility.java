package vTiger.Genericutilites;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This class will read and write the data in to excelsheet
 * @author boga sravani
 *
 */

public class ExcelsheetDataFileUtility {
	/**
	 * This method will read the data from excelsheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String Readthedatafromexcelsheet(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
	FileInputStream fis=new FileInputStream(ConstantUtility.excelfilepath);
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheetname);
	Row r=sh.getRow(rownum);
	Cell c=r.getCell(cellnum);
	String value=c.getStringCellValue();
	book.close();
	return value;
	}
	/**
	 * This method will write the data into excel sheet
	 * @param sheetname
	 * @param rownum
	 * @param cellnum
	 * @param value
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public void Writethedataintoexcelsheet(String sheetname,int rownum,int cellnum,String value) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantUtility.excelfilepath);
		Workbook book=WorkbookFactory.create(fis);
	    Sheet sh=book.createSheet(sheetname);
	    FileOutputStream fos=new FileOutputStream(ConstantUtility.excelfilepath);
	    sh.createRow(rownum).createCell(cellnum).setCellValue(value);
	    book.write(fos);
	    fos.flush();
	    book.close();
	}
	public Object[][]  readMultipledatafromexcelsheet(String sheetname) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(ConstantUtility.excelfilepath);
		Workbook book=WorkbookFactory.create(fis);
		Sheet sh=book.getSheet(sheetname);
		int lastrow=sh.getLastRowNum();
		int lastcell=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastrow][lastcell];
		
		for(int i=0;i<lastrow;i++)
		{
			for(int j=0;j<lastcell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
