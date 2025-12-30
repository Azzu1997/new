package Project_framework.Tasks;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks 
{
public static void main(String[] args) throws IOException
{
WebDriver	driver =new ChromeDriver();
driver.get("https://testautomationpractice.blogspot.com/");

//get all the broken links
List<WebElement> alllinks = driver.findElements(By.tagName("//a"));

//print all the links
System.out.println("total number of links :"+alllinks.size());

    int noofbrokenlinkks=0;

//get all the href values
for(WebElement linkelement:alllinks)
{
	@Nullable
	String hrefAttributeValue = linkelement.getAttribute("href"); //href is in string format
	//href is empty just skip it, if not empty continue
	if (hrefAttributeValue==null || hrefAttributeValue.isEmpty())
	{
		System.out.println("href attribute is null or empty it is not possibel to check");
		continue;
	}
	try {
		
	
	//converting string href  into URL
    URL linkurl = new URL(hrefAttributeValue);
    
    //open the connection to server
    HttpsURLConnection conn = (HttpsURLConnection) linkurl.openConnection();
    
    //connect to server
    conn.connect();
    
    if (conn.getResponseCode()>=400)
    {
    	System.out.println(hrefAttributeValue + "====> Brokenlinks");
    	noofbrokenlinkks++;
    }
    else
    {
    	System.out.println(hrefAttributeValue ="====>  not Brokenlinks ");
    }
	}
	catch (Exception e)
	{
		System.out.println("number of broken: " + noofbrokenlinkks);
	}
driver.quit();
}




}
}
