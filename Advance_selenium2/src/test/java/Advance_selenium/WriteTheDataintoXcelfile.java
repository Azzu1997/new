package Advance_selenium;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteTheDataintoXcelfile
{
public static void main(String[] args) throws IOException
{
	 WebDriver driver  = new ChromeDriver();
FileOutputStream file = new  FileOutputStream("./src/test/resources/practice.xlsx");
XSSFWorkbook wb = new XSSFWorkbook();

    //create the sheet with the name data
    XSSFSheet sheet = wb.createSheet("Data");
    
    //create the row 
   XSSFRow row1 = sheet.createRow(0);
   row1.createCell(0).setCellValue("java");
   row1.createCell(1).setCellValue("Versions");
   row1.createCell(2).setCellValue("Automation");
   
   
   //create another row
 XSSFRow row2 = sheet.createRow(1);
 row2.createCell(0).setCellValue("python");
 row2.createCell(1).setCellValue("version");
 row2.createCell(2).setCellValue("Automation");
 
 wb.write(file);
 wb.close();
 file.close();
 
 System.out.println("file is created");
 
     
  
     

}
}
