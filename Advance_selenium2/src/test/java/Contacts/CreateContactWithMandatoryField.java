package Contacts;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.JavaUtils;

public class CreateContactWithMandatoryField 
{
	@Test
public void CreateConwithMand()throws InterruptedException, IOException 
{
	WebDriver driver=null;

	
		// TODO Auto-generated method stub
//		Random ran = new Random();
//		int random = ran.nextInt(500);

//String exporgName ="AllStates"+random;	
//String expconName ="Azmat"+random;	
		
		FileUtiles flib = new FileUtiles();
		Excelutiles elib = new Excelutiles();
		JavaUtils jlib = new JavaUtils();
		
		String BROWSER = flib.ReadTheDataFromThePropertyFile("browser");
		String URL = flib.ReadTheDataFromThePropertyFile("url");
		String USERNAME = flib.ReadTheDataFromThePropertyFile("username");
		String PASSWORD = flib.ReadTheDataFromThePropertyFile("password");

//FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\commontestdata.properties");
//Properties pObj = new Properties();
//pObj.load(fis);
		
		String expconName = elib.readSingleDataFromEXcel("Contacts", 0, 1)+jlib.getRandomno();
		String exporgName = elib.readSingleDataFromEXcel("Contacts", 1, 1)+jlib.getRandomno();
	    String IDD=elib.readSingleDataFromEXcel("Contacts", 2, 1);

//String BROWSER = pObj.getProperty("browser");
//String URL = pObj.getProperty("url");
//String USERNAME = pObj.getProperty("username");
//String PASSWORD= pObj.getProperty("password");

//FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\TP30 propertyfile.xlsx");
//Workbook wb = WorkbookFactory.create(fi);
//Sheet sh = wb.getSheet("Contacts");
//String expconName = sh.getRow(0).getCell(1).getStringCellValue()+random;
//String exporgName = sh.getRow(1).getCell(1).getStringCellValue()+random;
//String IDD = sh.getRow(2).getCell(1).getStringCellValue();


//launch the browser
if(BROWSER.equalsIgnoreCase("chrome")) {
 driver = new ChromeDriver();
}
if(BROWSER.equalsIgnoreCase("firefox")) {
	 driver = new FirefoxDriver();
	}
if(BROWSER.equalsIgnoreCase("edge")) {
	 driver = new EdgeDriver();
	}

//maximize the window
driver.manage().window().maximize();

//wait for page load
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

//enter url
driver.get(URL);


//step1:login to application
driver.findElement(By.name("user_name")).sendKeys(USERNAME);
driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
driver.findElement(By.id("submitButton")).click();


//step2:Navigation to Homepage click on Organization link
//driver.findElement(By.linkText("Organizations")).click();


//step3:Click on create organization lookup image
//driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

//step4:Enter all mandatory fields with valid data
//driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(exporgName);

//step5:click on 'Industry' dropdown and select 'Healthcare' from dropdown
WebElement dropdown = driver.findElement(By.name("industry"));
Select sel = new Select(dropdown);
sel.selectByVisibleText(IDD);

//step6:	click on 'Save' button
//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

Thread.sleep(2000);
//String actualorgname = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

//validate exp result
//if(actualorgname.contains(exporgName)) {
//	System.out.println("organizations created successfully");
//}
//else {
//	System.out.println("organization is not created");
//}

Thread.sleep(2000);
//step2:Navigation to Homepage click on Contacts link
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		
			//step3:Click on create contact lookup image 
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		
		String parentwindow = driver.getWindowHandle();
		
//		step3:Enter 'Last Name' text field
		driver.findElement(By.name("lastname")).sendKeys(expconName);
		
//		step4:click on 'Organization Name' Lookup image
		driver.findElement(By.name("account_name")).click();
		
////		step5:click on 'Organization Name' in search field
	driver.findElement(By.xpath("//img[@title='Select']")).click();
//		
		Set<String> allwindow = driver.getWindowHandles();
		
//		Iterator<String> it = allwindow.iterator();
//		while(it.hasNext()) {
//			String wid = it.next();
//			@Nullable
//			String currenttitle = driver.switchTo().window(wid).getTitle();
//			if(currenttitle.contains("Accounts&action")) {
//				break;
//		}
//	}
		for( String win:allwindow) {
			driver.switchTo().window(win);
			String currentwindowHandle = driver.getWindowHandle();
			if(!currentwindowHandle.equals(parentwindow)) {

				break;
			}
		}
		
//		step5:Click on 'Organization Name'
		driver.findElement(By.name("search_text")).sendKeys(exporgName,Keys.ENTER);
		//driver.findElement(By.name("search_text")).click();
        driver.findElement(By.xpath("//a[@href='javascript:window.close();' and text()='"+exporgName+"']")).click();

	Thread.sleep(2000);
	
	driver.switchTo().window(parentwindow);

//		step6:click on 'Save' button
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();	
	
		
		String actual = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();

		//validate exp result
		if(actual.contains(exporgName)) {
			System.out.println("organizations created successfully");
		}
		else {
			System.out.println("organization is not created");
		}

		//Click on 'Sign Out'
		//click on adminstrator icon
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();

		//mousehover on 'signout' link and click on that
		WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));

		//
		Actions act = new Actions(driver);
		act.moveToElement(signout).click().perform();

		//close the browser
		driver.quit();
}
}


