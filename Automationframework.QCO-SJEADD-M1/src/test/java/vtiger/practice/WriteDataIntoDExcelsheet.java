package vtiger.practice;

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

public class WriteDataIntoDExcelsheet {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//step1:open the document in java readableformat
		FileInputStream fis=new FileInputStream("C:\\Users\\boga sravani\\OneDrive\\Desktop\\Adv selenium\\testdata.xlsx");
		//step2:create the workbook
		Workbook wb=WorkbookFactory.create(fis);
		//step3:get the control of the sheet
		Sheet sh=wb.getSheet("Contact");
		//step4: create a row
		Row r=sh.createRow(10);
		//step5:cretae a cell
		Cell c=r.createCell(7);
		//step6:set the value into the cell
		c.setCellValue("Batman");
		//step7:create file output stream
		FileOutputStream fos=new FileOutputStream("C:\\Users\\boga sravani\\OneDrive\\Desktop\\Adv selenium\\testdata.xlsx");
		//step8:write the data in cell
		wb.write(fos);
		fos.flush();
		//step9:clsoe the workbook
		wb.close();
		System.out.println("data inserted successfully");
		
		
	}

}
