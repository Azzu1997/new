package Project_framework;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ReadDatafromexcelOrgDropdown 
{
public static void main(String[] args) throws IOException 
{
	
	WebDriver driver = null;
    //create random num
	Random ran=new Random();
	int random = ran.nextInt(500);
	
	//read the data from the property file
	FileInputStream file = new FileInputStream(".\\src\\test\\resources\\TestData.propertyFile");
	Properties pobj = new Properties();
	pobj.load(file);
	
	String Browser = pobj.getProperty("browser");
	String Url = pobj.getProperty("url");
	String Username = pobj.getProperty("username");
	String Password = pobj.getProperty("password");

	//read data from excel file
	FileInputStream file1 = new FileInputStream(".C:\\Users\\shaik\\OneDrive\\Desktop");
	Workbook wb = WorkbookFactory.create(file1);
	Sheet sh = wb.getSheet("Organizations"); // sheet name is organization
	
	String OrgName = sh.getRow(0).getCell(1).getStringCellValue()+random;
	String indDD = sh.getRow(1).getCell(1).getStringCellValue();

	//launch browser
	if(Browser.equalsIgnoreCase("chrome"))
	 {
      driver = new ChromeDriver();
	 }
     else if(Browser.equalsIgnoreCase("firefox"))
     {
     driver = new FirefoxDriver();
     }
    else if(Browser.equalsIgnoreCase("edge"))
    {
     driver = new EdgeDriver(); 
     }

    driver.manage().window().maximize();
	driver.get(Url);
	//wait for load page
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
	//step1: login to application
	driver.findElement(By.name("user_name")).sendKeys(Username);
	driver.findElement(By.name("user_password")).sendKeys(Password);
	driver.findElement(By.id("submitButton")).click();
    
	//step2:click on organization link
	driver.findElement(By.linkText("Organizations")).click();
	
	//step3:Enter mandatory fields with valid data
	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
	
	//step4:enter mandatory fields with valid data
	driver.findElement(By.name("accountname")).sendKeys(OrgName);
	
	//step5:click on 'Industry' dropdown and select 'Healthcare' from dropdown
			WebElement dropdown = driver.findElement(By.xpath("//select[@name='industry']"));
			Select sel = new Select(dropdown);
			sel.selectByContainsVisibleText(indDD);
	
	//step5:click on save button
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	//driver.quit();
}
}
