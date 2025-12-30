package Project_framework;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateOrganizationWithDropdown 
{
	public static void main(String[] args) 
	{
		//create random number bez organization name will not accept duplicates 
		//so that we use  some random numbers next to the company name
//		Random ran=new Random();
//		int random = ran.nextInt();
		
	WebDriver	driver =new ChromeDriver();

	//give the URL
	driver.get("http://localhost:8888/");

	//wait the load
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	//login to application
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();

	//click on organization lookup image
	driver.findElement(By.xpath("//a[@href='index.php?module=Accounts&action=index']")).click();

	//enter madatory fields with valid data
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

	//enter the organization name
	driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("Tekpyramid");


	
	//select industry dropdown
	WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
	Select sel = new Select(industry);
	sel.selectByContainsVisibleText("Healthcare");
	
	//click on save button
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	driver.close();
	
	}
}
