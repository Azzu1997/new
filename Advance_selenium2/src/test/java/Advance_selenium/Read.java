package Advance_selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Read 
{
public static void main(String[] args) throws EncryptedDocumentException, IOException {
	FileInputStream file = new FileInputStream(".\\src\\test\\resources\\test30data.xlsx");
	Workbook wb = WorkbookFactory.create(file);
	Sheet sh = wb.getSheet("Sheet1");
     int lastrow = sh.getLastRowNum();
    
}
}
