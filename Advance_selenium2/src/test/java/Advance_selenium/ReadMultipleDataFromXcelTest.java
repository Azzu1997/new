package Advance_selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadMultipleDataFromXcelTest {
		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			
			FileInputStream fi = new FileInputStream("C:\\Users\\shaik\\OneDrive\\Desktop\\practice.xlsx");
			
			Workbook wb=WorkbookFactory.create(fi);
			
			Sheet sh = wb.getSheet("Sheet1");
			
			//get the total number of row
			int lastRow = sh.getLastRowNum();
			
			//Apply for loop to fetch all the data
			for(int i=0;i<=sh.getLastRowNum();i++) {
				String company = sh.getRow(i).getCell(0).toString();
				String location = sh.getRow(i).getCell(1).getStringCellValue();
				
				System.out.print(company+"  ");
				System.out.println(location+ " ");
			}
		}

	}

