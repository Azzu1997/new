package Test_NG;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class StoreSetOfData 
{
//@dataprovider is a annotation
@DataProvider(name= "Credential")
//a non static method the return type is object
public Object [][] Credential()
{
	Object[][] obj= new Object[2][2];
	obj[0][1]= "admin";
	obj[1][1]= "admin";
	
	obj[1][0]= "admin";
	obj[1][1]= "password";
    return obj;
	
}

@DataProvider(name= "store_products")
public Object [][] store_products()
{
 Object[][] obj = new Object[2][2];
 obj[0][0]= "laptop";
 obj[0][1]= 50000;
 
obj[1][0]= "mobile";
obj[1][1]= 10000;
return obj;
}	
	@DataProvider
	public Object[][] excelData() throws EncryptedDocumentException, IOException
	{
		FileInputStream file = new FileInputStream("./src/test/resources/TP30.xls");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh = wb.getSheet("Dataprovider");
		int rowCount = sh.getLastRowNum()+1;
		int celcount = sh.getRow(0).getLastCellNum();
		
		//Array to print all 
		Object[][] obj = new  Object[rowCount][celcount];
		
		//FOr rows
		for(int i=0; i<rowCount; i++)
		{
			for(int j=0; j<celcount; j++)
			{
			obj[i][j]	=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}
	
}


