package Advance_selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;

public class ReadDataFromXcelTest {
		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			
			//identify the path of Xcel file
			FileInputStream fi = new FileInputStream("./src/test/resources/TP30.xls");
			
			//open the file
			Workbook wb=WorkbookFactory.create(fi);
			
			//get the sheet
			Sheet sh = wb.getSheet("Sheet1");
			
			//get the row
			Row row = sh.getRow(0);
			
			
			//get cell
			org.apache.poi.ss.usermodel.Cell cel1 = row.getCell(0);
			String company=cel1.getStringCellValue();
			
			//get bangaluru location
			String location=row.getCell(1).getStringCellValue();
			
			
			System.out.println(company);
			System.out.println(location);
			wb.close();
			
		}

	}

