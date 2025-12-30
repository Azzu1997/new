package Advance_selenium;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

import com.google.common.collect.Table.Cell;

public class ReadDataFromXcelPractice
{
public static void main(String[] args) throws IOException
{
	//to read the file
	FileInputStream file = new FileInputStream("./src/main/resources/practice.xlsx");
	
	//extracted the workbook from xcel file
	XSSFWorkbook wb = new XSSFWorkbook(file);
	
	//extracted the sheet from the workbook
	XSSFSheet sheet = wb.getSheet("sheet1");
	
	//getting the total no. rows
	int totalRows = sheet.getRow(1).getLastCellNum();

	//getting the totalnum of cells
	int totalCell = sheet.getLastRowNum();
	
	System.out.println("total num of row  : "+ totalRows);
	System.out.println("total num of cells : "+ totalCell);
	
	//outer for loop for printing the rows
	for (int r=0; r<=totalRows; r++)
	{
	XSSFRow currentrow = sheet.getRow(r);
	
	for(int c=0; c<totalCell; c++)
	{
	XSSFCell Cell = currentrow.getCell(c);
	System.out.print(Cell.toString()+"\t");

	}
	
	}
	wb.close();
	file.close();
	
	
	
	
}
}
