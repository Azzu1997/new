    package Testing_Practice;

import org.testng.annotations.Test;

import Generic_libraries.BaseClass;

public class DemoTest2 extends BaseClass 
{
@Test
public void practice()
{
	System.out.println("Practice well");
}
public void practice1()
{
	System.out.println("Practice better");
}
public void practice2()
{
	System.out.println("Practice well &better for better life");
}


@Test (groups="Regression")
public void impact()
{
	System.out.println("there is a impacted area in this");
}
}
