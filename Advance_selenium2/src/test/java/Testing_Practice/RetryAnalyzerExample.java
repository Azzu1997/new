package Testing_Practice;

import org.testng.annotations.Test;

import Generic_libraries.BaseClass;
import Generic_libraries.RetryAnalyzer;

public class RetryAnalyzerExample extends BaseClass
{
	@Test
public void sample_m1()
{
System.out.println("----Smaple_m1-----");
}
	
	@Test(retryAnalyzer =Generic_libraries.RetryAnalyzer.class)

public void sample_m2()
{
System.out.println("----Smaple_m2-----");
}
}
