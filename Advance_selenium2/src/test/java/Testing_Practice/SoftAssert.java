package Testing_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SoftAssert 
{
	@Test
	public void SoftAssert()
	{
	SoftAssert sa = new SoftAssert();
	
	System.out.println("-----Step1------");
	System.out.println("-----Step2------");
   Assert.assertEquals("A", "B");
	System.out.println("-----Step3------");

	System.out.println("-----Step4------");

	}
}
