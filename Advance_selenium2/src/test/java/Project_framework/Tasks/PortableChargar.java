package Project_framework.Tasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class PortableChargar 
{
	public static void main(String[] args) throws InterruptedException 
	{
		String expexted_value = "Portable Charger";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//inspect form text and using moveToElement method performing the action
		Actions act=new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//h2[text()='Form']"))).perform();
		
		//
		for (int j=2; ; j++)
		{
			try
			{
				for(int i=1; ; i++)
				{
//xpath of the of the rows in the table 
WebElement element = driver.findElement(By.xpath("(//h2[text()='Pagination Web Table']/..//div/div//tr/td[2])["+i+"]"));
//getting the text and checking the expected value with actual value
String actual = element.getText();
System.out.println(actual);
				if (expexted_value.equals(actual))
				{
					driver.findElement(By.xpath("//td[text()='Portable Charger']/following-sibling::td/input[@type='checkbox']"));
				return;
				}
				}
			}
			catch(Exception e ) 
			{
				driver.findElement(By.xpath("//ul[@id='pagination']/li/a[text()='"+j+"']")).click();
				}
				
				
			
			}
}
	}


