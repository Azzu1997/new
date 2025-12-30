package Project_framework.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UploadTheFile1 
{
	public static void main(String[] args) throws InterruptedException
	{
	WebDriver	driver =new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	
	//maximize window
	driver.manage().window().maximize();
	SearchContext host = driver.findElement(By.id("shadow_host")).getShadowRoot();
	WebElement textfield = host.findElement(By.cssSelector("input[type='text']"));
	textfield.sendKeys("Azmat");

	host.findElement(By.cssSelector("input[type='file']")).sendKeys("C:\\\\Users\\\\shaik\\\\OneDrive\\\\Desktop");
	Thread.sleep(2000);
	driver.quit();
}
}
