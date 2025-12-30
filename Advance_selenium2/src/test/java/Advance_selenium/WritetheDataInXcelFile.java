package Advance_selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritetheDataInXcelFile
{
public static void main(String[] args) throws EncryptedDocumentException, IOException
{
	//To read the file , we take the inputfile
	FileInputStream fi =new FileInputStream("./src/test/resources/practice.xlsx");
	 Workbook wb = WorkbookFactory.create(fi);
	 Sheet sh = wb.getSheet("Sheet2");

	 
	 Row row = sh.createRow(0);

	 Cell cel = row.createCell(0);
	cel.setCellValue("testyantra");
	
	FileOutputStream fi1 = new FileOutputStream("./src/test/resources/practice.xlsx");
	wb.write(fi1);
	
}

}
