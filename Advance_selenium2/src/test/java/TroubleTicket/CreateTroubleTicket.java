package TroubleTicket;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.JavaUtils;
import ObjectPom.Home_page;
import ObjectPom.TroubleTickectLookupImage;
import ObjectPom.TroubleTicketPage;

public class CreateTroubleTicket
{
	
@Test(groups="Regression")
public  void creteTrouble() throws IOException
{
	WebDriver driver= null;
	
	Excelutiles eu= new Excelutiles();
	FileUtiles fu= new FileUtiles();
	JavaUtils ju= new JavaUtils();
	
	
	//getting the browser details from properfiles
	String BROWSER = fu.ReadTheDataFromThePropertyFile("browser");
	String URL = fu.ReadTheDataFromThePropertyFile("url");
	String UESERNAME = fu.ReadTheDataFromThePropertyFile("username");
	String PASSWORD = fu.ReadTheDataFromThePropertyFile("password");
	
	
	
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
	driver.findElement(By.name("user_name")).sendKeys(UESERNAME);
    driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
    driver.findElement(By.id("submitButton")).click();
	
//create an object for pom homepage
    Home_page hp = new Home_page(driver);
    hp.TroubleTickets();
    
    //create an object for 
    TroubleTicketPage tt= new TroubleTicketPage(driver);
    tt.lookupbun();
    
    String troubletitle = eu.readSingleDataFromEXcel("TroubleTicket", 0, 1);
    //create an object troubleLooupImage
    TroubleTickectLookupImage tl= new TroubleTickectLookupImage(driver);
   tl.createtroubleTicket(troubletitle);
    
//signout
  // hp.Signout(driver);
   
   driver.quit();
    
    
    
   
}
}
