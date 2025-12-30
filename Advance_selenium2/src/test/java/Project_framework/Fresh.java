package Project_framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.JavaUtils;

public class Fresh 
{

public static void main(String[] args) throws IOException, InterruptedException
{
	//WebDriver driver= null;

	//created object for javautiles to access the random num method 
	JavaUtils ju = new JavaUtils();
	ju.getRandomno();
	
	//created object for excelutils
	Excelutiles eu= new Excelutiles();
	String orgname = eu.readSingleDataFromEXcel("Organization", 0, 1)+ju.getRandomno();
	Thread.sleep(2000);
	 String  INDD = eu.readSingleDataFromEXcel("Organization", 1, 1);

	
	
	
	//creating object for fileutiles
	FileUtiles fu = new FileUtiles();
	
	// in the property file we have give the browser name, url, un, pass, we are reading that data 
	//for fileutils
	String browser = fu.ReadTheDataFromThePropertyFile("Browser");
	String url = fu.ReadTheDataFromThePropertyFile("Url");
	String username = fu.ReadTheDataFromThePropertyFile("username");
	String password = fu.ReadTheDataFromThePropertyFile("password");
	
	//Because the actual browser depends on the value of BROWSER we passed in the property file
	//Checks if BROWSER is "chrome" (case-insensitive), If true, Opens  Chrome.
	
	//launch the browser
//			if(browser.equalsIgnoreCase("chrome")) {
//				driver = new ChromeDriver();
//			}
//			else if(browser.equalsIgnoreCase("firefox")) {
//				driver = new FirefoxDriver();
//			}
//			else if(browser.equalsIgnoreCase("edge")) {
//				driver=new EdgeDriver();
//			}
		

			Thread.sleep(2000);
			WebDriver driver = new ChromeDriver();

			//maximize the window
			driver.manage().window().maximize();

			//wait for page load
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			//enter url
			driver.get("http://localhost:8888/");

			//step1:login to application, username and password we have passed in the .property file, 
			//fileutile will read those values
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("user_password")).sendKeys(password);
			driver.findElement(By.id("submitButton")).click();
			
			
			 //read data from Excel File
			//String orgname = eu.readSingleDataFromEXcel("Organizations", 0, 1)+ju.getRandomno();
				 //String  INDD = eu.readSingleDataFromEXcel("Organizations", 1, 1);
				 
			

			
			//step2:	Click on 'ORGANIZATIONS' link
			driver.findElement(By.linkText("Organizations")).click();

			//step3:	click on 'create Organization' Lookup image
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

			//step4:	Enter mandatory fields with valid data
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
			
			//step5:click on 'Industry' dropdown and select 'Healthcare' from dropdown
 WebElement dropdown = driver.findElement(By.xpath("//select[@name='industry']"));
 dropdown.click();
Select sel= new Select(dropdown);

sel.selectByContainsVisibleText(INDD);
	     
	  //step6:	click on 'Save' button
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			//Click on 'Sign Out'
			//click on adminstrator icon
	           Actions act= new Actions(driver);
WebElement admini = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
			act.moveToElement(admini).perform();
			
			//mousehover on 'signout' link and click on that
			WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
		act.moveToElement(signout).click().perform();
		
		
			
			driver.quit();
			
			


			
			

			
			
			




	
}
}
