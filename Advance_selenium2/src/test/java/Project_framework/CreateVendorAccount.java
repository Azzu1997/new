package Project_framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateVendorAccount 
{
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		//give the URL
			driver.get("http://localhost:8888/");

			//wait the load
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

			//login to application
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			
			//inspect the more button
			driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
			
			
		    //click on vendor button
			driver.findElement(By.xpath("//a[@href='index.php?module=Vendors&action=index']")).click();
			
			//clcik on create vendor account
			driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
			
			//pass the vendor name
			driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys("Carrerstart");
			
			//save the account
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			

			Thread.sleep(3000);
			
			//printing the confirmation message
			System.out.println(driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText());
			
			Thread.sleep(5000);
			//signout
//  driver.findElement(By.xpath("//a[text()= 'Sign Out']")).click();
//			Actions act = new 	Actions(driver);
//            act.moveToElement(signout).click().perform();
			driver.quit();
}
}