package Testing_Practice;

import static org.testng.Assert.assertEquals;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_libraries.BaseClass;

@Listeners(Generic_libraries.ListnerImplementationClass.class)
public class RunnerClass extends BaseClass
{
	@Test
public void hardAssert()
{
		//using the equals method given the xpected value, once after giving the equals method in the nx line 
		//values will not be print or worked
	System.out.println("-----Step1------");
	System.out.println("-----Step2------");
   Assert.assertEquals("A", "B");
	System.out.println("-----Step3------");

	System.out.println("-----Step4------");
	Assert.fail();

}
	@Test
	public void m2()
	{
		System.out.println("***********execeute******");
		System.out.println("***********execeutefirst******");
		System.out.println("***********execeutesecond******");
		Assert.assertNotEquals("Azz", "Sil");
		System.out.println("***********execeuteLast******");
     }
	@Test
	public void Vtiger()
	{
		String exp = "vtiger";
		WebDriver driver  = new ChromeDriver();
		driver.get("http://localhost:8888/");
		@Nullable
		String title = driver.getTitle();
		Assert.assertEquals(title, exp);
		System.out.println(title);
		}
	
	
	

	
}
