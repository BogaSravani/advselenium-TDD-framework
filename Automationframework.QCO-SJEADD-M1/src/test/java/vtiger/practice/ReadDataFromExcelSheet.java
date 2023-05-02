package vtiger.practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1:open document in java readable format using fileinputstream
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\testdata.xlsx");
		//step2:create a workbook using workbook factory
		Workbook book=WorkbookFactory.create(fis);
		//step3:get the control of sheet
		Sheet sh=book.getSheet("Organisation");
		//step4:get the control of row
		Row r=sh.getRow(1);
		//step5:get the control of cell
		Cell c=r.getCell(2);
		//step6:read the data inside the cell
		String value=c.getStringCellValue();
		System.out.println(value);
		//step7:close workbook
		book.close();
		
	}

}
