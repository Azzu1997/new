package Project_framework;

import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CreateContactUsingOrganization
{
	public static void main(String[] args) throws InterruptedException 
	{
		
		
		
		
		//create random number bez organization name will not accept duplicates 
		//so that we use use some random numbers next to the company name
Random ran=new Random();
int random = ran.nextInt();
 String exporname = "Tekpyramid"+random;
 String exconname = "Azmat"+random;

		
	WebDriver	driver =new ChromeDriver();

	//give the URL
	driver.get("http://localhost:8888/");

	//wiat the load
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

	//login to application
	driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id='submitButton']")).click();

	//click on contact lookup link
	driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();

	//click on contact image 
driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

//since last name is the mandatory field we are passing the name using sendkeys
driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(exconname);

//inspect the   organization name
driver.findElement(By.xpath("//input[@name='account_name']")).click();

//inspect the Pluse sysmbol to add the organization name
driver.findElement(By.xpath("//img[@alt='Select']")).click();

//to handle multiple windows
String parentHandle = driver.getWindowHandle();
Set<String> allwindowid = driver.getWindowHandles();
for(String win:allwindowid)
{
	 driver.switchTo().window(win);
	String CurrentWindowid = driver.getWindowHandle();
	if (!(CurrentWindowid.equals(parentHandle)))
		break;
	}
//inspect the organization name 
driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();


//cureently we are in organization page to switch back to the contact page switch to parent window
driver.switchTo().window(parentHandle);

Thread.sleep(3000);

//inspect the save button
driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
Thread.sleep(3000);
//signout
//driver.findElement(By.xpath("//a[text()= 'Sign Out']")).click();

driver.quit();
}
}