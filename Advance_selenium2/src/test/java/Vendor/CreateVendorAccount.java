package Vendor;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.JavaUtils;
import Generic_libraries.WebDriverUtiles;
import ObjectPom.Home_page;
import ObjectPom.VenderPage;
import ObjectPom.VendorLookupPage;

public class CreateVendorAccount 
{
	@Test(groups="Smoke")
	public void CreateVen() throws IOException, InterruptedException 
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
	
	WebElement element = driver.findElement(By.xpath("//a[text()='More']"));
	Actions act = new Actions(driver);
    act.moveToElement(element).click().perform();
	
    
    Home_page hp= new Home_page(driver);
    hp.Vendors();
	
   VenderPage vp= new VenderPage(driver);
    vp.createvendor();
    
   String Vename = excel.readSingleDataFromEXcel("Vendors", 0, 1);
   
   VendorLookupPage vl= new VendorLookupPage(driver);
   vl.CreateVenAcc(Vename);

   
    
	
//	//inspect the more button
//	driver.findElement(By.xpath("//img[@src='themes/softed/images/menuDnArrow.gif']")).click();
//	
//	
//    //click on vendor button
//	driver.findElement(By.xpath("//a[@href='index.php?module=Vendors&action=index']")).click();
//	
//	//clcik on create vendor account
//	driver.findElement(By.xpath("//img[@alt='Create Vendor...']")).click();
//	
//	//pass the vendor name
//	driver.findElement(By.xpath("//input[@name='vendorname']")).sendKeys("MNC");
//	
//	//save the account
//	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
//
//	//print the confirmation message 
//	String validate = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
//	System.out.println(validate);
//	
//	//Click on 'Sign Out'
//	//click on adminstrator icon
driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//
////mousehover on 'signout' link and click on that
WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
//
////here we are using moveover method
wutil.mousehoverandclickonEle(driver, signout);
//	
}
	}

