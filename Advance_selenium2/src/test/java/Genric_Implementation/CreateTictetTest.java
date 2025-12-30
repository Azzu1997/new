package Genric_Implementation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.JavaUtils;
import Generic_libraries.WebDriverUtiles;

public class CreateTictetTest
{
	public static void main(String[] args) throws IOException, InterruptedException 
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
	
	driver.findElement(By.xpath("//a[@href='index.php?module=HelpDesk&action=index']")).click();
	
	   
}
}
