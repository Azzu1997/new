package Contacts;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_libraries.BaseClass;
import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.JavaUtils;
import Generic_libraries.WebDriverUtiles;
import ObjectPom.ContLookupImagePage;
import ObjectPom.Contactpage;
import ObjectPom.Home_page;

public class CreateContactWithManField extends BaseClass
{
	@Test

		public void CreateCon() throws IOException {
			// TODO Auto-generated method stub
			//launch the browser
			//		Random ran = new Random();
			//		int random = ran.nextInt(500);
			//String expconName ="azmat"+random;	
             FileUtiles fu= new FileUtiles();
             WebDriverUtiles wutil= new WebDriverUtiles(); 
			Excelutiles	elib=new Excelutiles();
               JavaUtils ju = new JavaUtils();
			//FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commontestdata.properties");
			//Properties pObj = new Properties();
			//pObj.load(fis);

//			String BROWSER = fu.ReadTheDataFromThePropertyFile("browser");
//			String URL = fu.ReadTheDataFromThePropertyFile("url");
//			String USERNAME = fu.ReadTheDataFromThePropertyFile("username");
//			String PASSWORD = fu.ReadTheDataFromThePropertyFile("password");

//			String BROWSER = pObj.getProperty("browser");
//			String URL = pObj.getProperty("url");
//			String USERNAME = pObj.getProperty("username");
//			String PASSWORD = pObj.getProperty("password");
			
			
//			FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TP30 propertyfile.xlsx");
//			Workbook wb = WorkbookFactory.create(fi);
//			Sheet sh = wb.getSheet("Contacts");
//			String lastname = sh.getRow(0).getCell(1).getStringCellValue()+random;

//			WebDriver driver=null;
//			if(BROWSER.equalsIgnoreCase("chrome")) {
//				driver = new ChromeDriver();
//			}
//			if(BROWSER.equalsIgnoreCase("firefox")) {
//				driver = new FirefoxDriver();
//			}
//			if(BROWSER.equalsIgnoreCase("edge")) {
//				driver = new EdgeDriver();
//			}

			//maximize the window
			//driver.manage().window().maximize();

			//wait for page load
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

			//enter url
			//driver.get(URL);


			//step1:login to application
//			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//			driver.findElement(By.id("submitButton")).click();
			
			Home_page hp= new Home_page(driver);
			hp.COntcats();;
			
			
			Contactpage cp= new Contactpage(driver);
			cp.lookupbutton();
			
			//read data from Excel
			String contName = elib.readSingleDataFromEXcel("Contacts", 0, 1);

			ContLookupImagePage cLook = new ContLookupImagePage(driver);
			cLook.createonContactNameOrg(contName, driver, contName);
			
			//hp.Signout(driver);
//			//click on adminstrator icon
			//driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
			//
			////mousehover on 'signout' link and click on that
			//WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
			//
			////here we are using moveover method
			//wutil.mousehoverandclickonEle(driver, signout);

//			//step2:Navigation to Homepage click on Contacts link
//			driver.findElement(By.xpath("//a[text()='Contacts']")).click();
//
//			//step3:Click on create contact lookup image 
//			driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
//
//
//			//				step3:Enter 'Last Name' text field
//			driver.findElement(By.name("lastname")).sendKeys(lastname);
//
//			//step6:click on 'Save' button
//			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	
//
//			String actualconname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
//
//			if(actualconname.contains(lastname)) {
//				System.out.println("contacts created successfully");
//			}
//			else {
//				System.out.println("contacts not created");
//			}
//			//Click on 'Sign Out'
//			//click on adminstrator icon
//			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//
//			//mousehover on 'signout' link and click on that
//			WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
//
//			//
//			Actions act = new Actions(driver);
//			act.moveToElement(signout).click().perform();
//
//			driver.quit();
		}
}
