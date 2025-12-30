package Test_NG;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;

public class Dp_GenricTest
{
	@Test(dataProvider="getdata")
	public void execute (String trainers, String subjects)
	{
		System.out.println(trainers+ "...>>..."+ subjects );
	}
	
	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException
	{
		Excelutiles eu= new Excelutiles();
        Object[][] value = eu.ReadMutipleSetOfData("Dataprovider");
		return value;
		
	}
	

}
