package Advance_selenium_TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadTheDataFromXMLFile1 
{

	//@Test is an  Annotation
	  @Test
	  public void test2 (XmlTest test )
	  {
	//WebDriver	driver = new  ChromeDriver();
	
	 System.out.println(test.getParameter("browser")); 
	 System.out.println(test.getParameter("url"));
	 System.out.println(test.getParameter("username"));
	 System.out.println(test.getParameter("password"));  
	 
	 



	  }

}
