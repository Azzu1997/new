package Advance_selenium;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Table.Cell;

public class AddDataToXcelTest {
		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			FileInputStream fi=new FileInputStream(".\\src\\test\\resources\\ResourceFile\\TestData.xlsx");
			Workbook wb = WorkbookFactory.create(fi);
//			fi.close();
			Sheet sh=wb.createSheet("rough");
			Row row=sh.createRow(0);
			Cell cel = (Cell) row.createCell(0);
			((org.apache.poi.ss.usermodel.Cell) cel).setCellValue("TestYantra");
			
			FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\ResourceFile\\TestData.xlsx");
			wb.write(fos);
//			System.out.println("Hi");
			wb.close();	
		}
	}

