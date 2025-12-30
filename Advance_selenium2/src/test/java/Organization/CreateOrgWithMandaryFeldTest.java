package Organization;

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

import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.JavaUtils;

public class CreateOrgWithMandaryFeldTest
{
	@Test
public void CreateOrgWithManFel() throws InterruptedException, IOException
{
			WebDriver driver=null;
			//		//create random number
			//		Random ran = new Random();
			//		int random = ran.nextInt(500);

			//read data from property file
			FileUtiles flib = new FileUtiles();
			Excelutiles elib = new Excelutiles();
			JavaUtils jlib = new JavaUtils();

             //reading the browser details from property file
			String BROWSER=flib.ReadTheDataFromThePropertyFile("browser");
			String URL=flib.ReadTheDataFromThePropertyFile("url");
			String USERNAME=flib.ReadTheDataFromThePropertyFile("username");
			String PASSWORD=flib.ReadTheDataFromThePropertyFile("password");

			//		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commontestdata.properties");
			//		Properties pObj = new Properties();
			//		pObj.load(fis);
			//		

			//		String BROWSER = pObj.getProperty("browser");
			//		String URL = pObj.getProperty("url");
			//		String USERNAME = pObj.getProperty("username");
			//		String PASSWORD = pObj.getProperty("password");

			//read data from Excel File
	       String OrgName=elib.readSingleDataFromEXcel("Organization", 0, 1)+jlib.getRandomno();
	       String INDD=elib.readSingleDataFromEXcel("Organization", 1, 1);

//			FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TP30 propertyfile.xlsx");
//			Workbook wb = WorkbookFactory.create(fi);
//			Sheet sh = wb.getSheet("Organization");
//			String org = sh.getRow(0).getCell(1).getStringCellValue()+random;
//			String IDD = sh.getRow(1).getCell(1).getStringCellValue();
	

			//launch the browser
			if(BROWSER.equalsIgnoreCase("chrome")) {
				driver = new ChromeDriver();
			}
			else if(BROWSER.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
			}
			else if(BROWSER.equalsIgnoreCase("edge")) {
				driver=new EdgeDriver();
			}
			//maximize the window
			driver.manage().window().maximize();

			//wait for page load
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

			//enter url
			driver.get(URL);


			//login to application
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();

			//step1:	Click on 'ORGANIZATIONS' link
			driver.findElement(By.linkText("Organizations")).click();

			//step2:	click on 'create Organization' Lookup image
			driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

			//step3:	Enter mandatory fields with valid data
			driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName);

			//step4:	click on 'Save' button
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();


			Thread.sleep(2000);


			//Click on 'Sign Out'
			//click on adminstrator icon
			driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();

			//mousehover on 'signout' link and click on that
			WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));

			//
			Actions act = new Actions(driver);
			act.moveToElement(signout).click().perform();

            driver.quit();
		}
	}


