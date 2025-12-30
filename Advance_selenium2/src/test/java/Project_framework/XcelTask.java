package Project_framework;


	import java.io.IOException;
	import java.time.Duration;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.edge.EdgeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.support.ui.Select;

import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.JavaUtils;

	public class XcelTask 
	{
		public static void main(String[] args) throws IOException, InterruptedException {
			
			WebDriver driver = null;
			
			//created object for all the classes
			FileUtiles fUtil = new FileUtiles();  //in FileUtiles class   we have path of the xcel file
			Excelutiles excUtil = new Excelutiles();  //In
			JavaUtils javUtils = new JavaUtils();			
			
			 String BROWSER = fUtil.ReadTheDataFromThePropertyFile("browser");
			 String URL = fUtil.ReadTheDataFromThePropertyFile("url");
			 String USERNAME = fUtil.ReadTheDataFromThePropertyFile("username");
			 String PASSWORD = fUtil.ReadTheDataFromThePropertyFile("password");
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
			 
			 driver.manage().window().maximize();
				driver.get(URL);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
			 
//			 Random ran =  new Random();
//			 int random = ran.nextInt(500);
			 
			 String Org = excUtil.readSingleDataFromEXcel("Organization", 0, 1)+javUtils.getRandomno();
			 String ind = excUtil.readSingleDataFromEXcel("Organization", 1, 1);
//			 FileInputStream fis1 = new FileInputStream(".\\src\\test\\resources\\VTigerProIfo.xlsx");
//			 Workbook wb = WorkbookFactory.create(fis1);
//			 Sheet sh = wb.getSheet("Organization");
//			 String Org = sh.getRow(0).getCell(1).getStringCellValue()+random;
//			 String ind = sh.getRow(1).getCell(1).getStringCellValue();
			    driver.findElement(By.xpath("//a[text()='Organizations']")).click();
				driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
				driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(Org);
				WebElement Idustry = driver.findElement(By.xpath("//select[@name='industry']"));
				Select s = new Select(Idustry);
				s.selectByContainsVisibleText(ind);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				 String actuall = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				 System.out.println(Org);
				 System.out.println(actuall);
				 if(actuall.contains(Org)) {
					 System.out.println("successfull");
				 }
				 else
				 {
					 System.out.println("fail");
				}
				 driver.findElement(By.xpath("//a[text()='Contacts']")).click();
					driver.findElement(By.xpath("//img[@alt='Create Contact...']")).click();
					driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("g");
					driver.findElement(By.xpath("//img[@alt='Select']")).click();
					
					String HostID = driver.getWindowHandle();
					Set<String> allIDs = driver.getWindowHandles();
					//Iterator<String> it = windows.iterator();
					for(String ID:allIDs)
						if (!ID.equals(HostID)) {
					        driver.switchTo().window(ID);   // switch to child
					    }
					driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(Org);
					Select s1 = new Select(driver.findElement(By.xpath(" //select[@name='search_field']")));
					s1.selectByContainsVisibleText("Organization Name");
					driver.findElement(By.name("search")).click();
					driver.findElement(By.xpath("//a[text()='"+Org+"']")).click();
					driver.switchTo().window(HostID);
//					WebDriverWait w = new WebDriverWait(driver,Duration.ofSeconds(10));
//					w.until(ExpectedConditions.elementToBeSelected(By.xpath("//input[@title='Save [Alt+S]']")));
					driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
					driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
					driver.findElement(By.linkText("Sign Out")).click();
					driver.quit();

}
	}
