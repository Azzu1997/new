package Test_NG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataPrividerStoreDate 
{
@Test(dataProviderClass = StoreSetOfData.class, dataProvider="store_products")
public void geThedata(String PName, int price)
{
	System.out.println(PName+" --->"+price);
	
}
@Test(dataProviderClass = StoreSetOfData.class, dataProvider="excelData")
public void geThedata(String Trainers, String Subject)
{
	System.out.println(Trainers+" --->"+Subject);
	
}



}
