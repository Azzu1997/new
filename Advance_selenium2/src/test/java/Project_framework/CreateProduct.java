package Project_framework;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import Generic_libraries.WebDriverUtiles;

public class CreateProduct 
{
public static void main(String[] args) throws InterruptedException
{
	WebDriverUtiles wu= new WebDriverUtiles();
	ChromeDriver driver = new ChromeDriver();
	//give the URL
		driver.get("http://localhost:8888/");

		//wait the load
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		//login to application
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
		
		//click on product link
		driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
		
		//click on create product
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		//pass the productname
		driver.findElement(By.xpath("//input[@name='productname']")).sendKeys("Silar");
		
		//insepect the vendor textfiled
		driver.findElement(By.xpath("//input[@name='vendor_name']")).click();
		
		//inspect the plus symbol of the vendor
		driver.findElement(By.xpath("//img[@alt='Select']")).click();
		
		//switch to vendor page
		String Parenthwindow= driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		
		for(String win: allwindows)
		{
			driver.switchTo().window(win);
			String CurrentWindowid = driver.getWindowHandle();
			if (!(CurrentWindowid.equals(Parenthwindow)))
				break;
			}
		
		//select the vendor name
		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		
		//switch to parent window
		driver.switchTo().window(Parenthwindow);
		
		//cick on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		//printing the confirmation message
		//System.out.println(driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText());
		String actual = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		wu.waitUntilEleToBeVisible(driver, 10, driver.findElement(By.xpath("//span[@class='lvtHeaderText']")));
		
		
	Thread.sleep(3000);
		//signout
         driver.findElement(By.xpath("//a[text()= 'Sign Out']")).click();
		
         //actions
//		Actions act = new 	Actions(driver);
//		act.moveToElement(signout).click().perform();

         driver.quit();

		
		
}
}
