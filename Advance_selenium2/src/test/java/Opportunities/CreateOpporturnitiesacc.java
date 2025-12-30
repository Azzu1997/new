package Opportunities;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Generic_libraries.BaseClass;
import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.WebDriverUtiles;
import ObjectPom.Home_page;
import ObjectPom.OpportPage;
import ObjectPom.OppuLookUpPage;

public class CreateOpporturnitiesacc extends BaseClass
{
	@Test
	public void CreateOpputu() throws InterruptedException, IOException {
	//creting the object for all the genric class
	FileUtiles fu= new FileUtiles();
	WebDriverUtiles wu= new WebDriverUtiles();
	Excelutiles eu = new Excelutiles();
	

	String oppNa = eu.readSingleDataFromEXcel("Oppurtunities", 0, 1);
	String text = eu.readSingleDataFromEXcel("Oppurtunities", 1, 1);
	
	
	
	
	
//	ChromeDriver driver = new ChromeDriver();
//	//give the URL
//		driver.get("http://localhost:8888/");
//
		Home_page hp= new Home_page(driver);
		hp.Opportunities();
		
		OpportPage Op= new OpportPage(driver);
		Op.lookupbtn();
		
		OppuLookUpPage olook = new OppuLookUpPage(driver);
		olook.CreateOpputur(driver, oppNa,  text);
		
		
		
		
//		//wait the load
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//
//		//login to application
//		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
//		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
//		driver.findElement(By.xpath("//input[@id='submitButton']")).click();
//		
//		//click on oppurtunites link
//		driver.findElement(By.xpath("//a[@href='index.php?module=Potentials&action=index']")).click();
//		
//		//click on create oppurtunities lookup button
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//		
//		Thread.sleep(3000);
//		//inspect the oppurtinie name
//		driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys("Basic");
//		
//		//click on plue symbol at organization
//		driver.findElement(By.xpath("//img[@title='Select']")).click();
//		
//		//handling window 
//		String parenthandle = driver.getWindowHandle();
//		Set<String> allwindow = driver.getWindowHandles();
//		for(String win:allwindow)
//		{
//			driver.switchTo().window(win);
//			String curentwindow = driver.getWindowHandle();
//			if(!(curentwindow.equals(parenthandle)))
//             break;
//		}
//		
//		//select the vendor name
//				driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
//				
//				//switch to parent window
//				driver.switchTo().window(parenthandle);
//				
//				//cick on save button
//				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//				
//				Thread.sleep(3000);
//				
//				//printing the confirmation message
//				System.out.println(driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText());
//				
//				Thread.sleep(5000);
//				//signout
//		         //driver.findElement(By.xpath("//a[text()= 'Sign Out']")).click();
//				
//				driver.quit();
}
}

