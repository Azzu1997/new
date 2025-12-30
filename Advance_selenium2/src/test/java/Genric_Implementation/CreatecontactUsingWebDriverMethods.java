package Genric_Implementation;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

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

import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.JavaUtils;
import Generic_libraries.WebDriverUtiles;
import ObjectPom.ContLookupImagePage;
import ObjectPom.Contactpage;

import ObjectPom.Home_page;
import ObjectPom.LoginPage;

public class CreatecontactUsingWebDriverMethods
{
public static void main(String[] args) throws IOException, InterruptedException
{
	 WebDriver driver  = null;
	 
	 //created object for the non static methods
	FileUtiles file = new FileUtiles();
	Excelutiles excUtil = new Excelutiles();
	JavaUtils javUtils = new JavaUtils();
	WebDriverUtiles wutil= new WebDriverUtiles();
	
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
	 
	 //String parentID = driver.getWindowHandle();
	
	 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	 wutil.waitForPageLoad(driver,10);
	 //1.login to the application
//		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//		driver.findElement(By.id("submitButton")).click();
//		
	 
	 //1.to lunch the url
	 driver.get(URL);

	 //2.login into the apnlication
	 LoginPage login = new LoginPage(driver);
      login.LoginToApp(USERNAME, PASSWORD);
      
	
      //3.to click on contact link
      Home_page hm = new Home_page(driver);
      hm.COntcats();
	 
      
      Thread.sleep(3000);
      //4.to create contact account
	 //create object for contactpage
	   Contactpage conn = new Contactpage(driver);
	  conn.lookupbutton();
	  
	
	 
	
	 
		
		 ContLookupImagePage lookup = new ContLookupImagePage(driver);
		 String ExpConName = excUtil.readSingleDataFromEXcel("Contacts", 0, 1)+javUtils.getRandomno();
		String ExpOrgName= excUtil.readSingleDataFromEXcel("Contacts", 1, 1)+javUtils.getRandomno();
		String IDD = excUtil.readSingleDataFromEXcel(ExpOrgName, 0, 0);
	 
		 
  //FileInputStream fis1 = new FileInputStream("\\src\\test\\resources\\test30data.xlsx");
   //Workbook wb = WorkbookFactory.create(fis1);
   //Sheet sh = wb.getSheet("Contacts");
  //int random = 1000;
  //String Contacts = sh.getRow(0).getCell(1).getStringCellValue()+random;




//		 String ind = sh.getRow(1).getCell(1).getStringCellValue();
	//2.click on contact lookup link
	//driver.findElement(By.xpath("//a[@href='index.php?module=Contacts&action=index']")).click();
	
	//clcik on create contact
	//driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	//String parentwin = driver.getWindowHandle();
	
	//since last name is the mandatory field we are passing the name using sendkeys
	//driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("MyContact");
	
	
	//inspect the Pluse sysmbol to add the organization name
	//driver.findElement(By.xpath("//img[@alt='Select']")).click();
	
	Thread.sleep(3000);
	
	//handling window, "Accounts&action" is the expected/next window titile
	
		//wutil.switchtochildwindow(driver, "Accounts&action");
	
	//inspect the serach box and type the contcta name 
//	driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("Tekpyramid-1071510936");
	
	//inspect the search button 
//	driver.findElement(By.xpath("//input[@name='search']")).click();
	
	//inspect the "Tekpyramid-1071510936" and perform click action
//		driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
	
	//String parentID = driver.getWindowHandle();
	//once organization name is  selected get back to the parent window
	//"Contacts&action" is the parent window title
	
	
	//alternate way to swich back to parent window
//wutil.switchToParentWindow(driver, "parentwin");
	
	
	//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	
	//Thread.sleep(4000);
	
	//validate the text
//	String validate = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//	System.out.println(validate);
//
//	
//	      //Click on 'Sign Out'
//			//click on adminstrator icon
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//
//			//mousehover on 'signout' link and click on that
//			WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
//			
//		
//			//Actions act = new Actions(driver);
//			//act.moveToElement(signout).click().perform();
//			
//			
//			//here using the webdriver   method 
//
//wutil.actions(driver);
//wutil.mousehoverandclickonEle(driver, signout);
//
//			driver.quit();
//
//
//	
//	
	
	
	
	

	
}
}
