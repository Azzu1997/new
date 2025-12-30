package Advance_selenium_TestNG;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadTheDataXmlTest 
{
	
	//@Test is an  Annotation
  @Test
  public void test(XmlTest test)//test is a method, The method takes an object of type XmlTest as a parameter,<test> tag in TestNG XML
  
  {
	 System.out.println(test.getParameter("browser")); 
	 System.out.println(test.getParameter("url"));
	 System.out.println(test.getParameter("username"));
	 System.out.println(test.getParameter("password"));
  }
 

}
