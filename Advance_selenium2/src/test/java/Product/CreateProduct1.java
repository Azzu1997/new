package Product;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.JavaUtils;
import Generic_libraries.WebDriverUtiles;

public class CreateProduct1
{
@Test	
public void ProductTest() throws IOException, InterruptedException 
{
	WebDriver  driver =null;
	
	//create object for non static methods 
	FileUtiles file = new FileUtiles();
	JavaUtils java = new JavaUtils();
   WebDriverUtiles web = new 	WebDriverUtiles();
   Excelutiles excel = new Excelutiles();
   WebDriverUtiles wutil = new WebDriverUtiles();
   
   String BROWSER = file.ReadTheDataFromThePropertyFile("browser");
	 String URL = file.ReadTheDataFromThePropertyFile("url");
	 String USERNAME = file.ReadTheDataFromThePropertyFile("username");
	 String PASSWORD = file.ReadTheDataFromThePropertyFile("password");
   
	 
	 if(BROWSER.equalsIgnoreCase("chrome"))
	 {
       driver = new ChromeDriver();
	 }
else if(BROWSER.equalsIgnoreCase("firefox"))
 {
 driver = new FirefoxDriver();
 }
else if(BROWSER.equalsIgnoreCase("edge"))
{
 driver = new EdgeDriver(); 
}
wutil.maximizeWindow(driver);

driver.get(URL);

String parentID = driver.getWindowHandle();

driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//1.login to the application
driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();

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
		
		//handling the window
		wutil.switchtochildwindow(driver, "Vendors&action");
		
		driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("Startup");
		
		driver.findElement(By.xpath("//input[@name='search']")).click();
		
        //swiching back to parentwindow
		wutil.switchToParentWindow(driver, parentID);
		
		//cick on save button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//validate the confirmtaion mesage
	    String validate = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
	    System.out.println(validate);
	    

	      //Click on 'Sign Out'
			//click on adminstrator icon
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();

			//mousehover on 'signout' link and click on that
			WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
			
			//using webdriver methods
			wutil.mousehoverandclickonEle(driver, signout);
				   
			
		

		
		
	
}
}
