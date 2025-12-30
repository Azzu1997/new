package Genric_Implementation;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.JavaUtils;
import Generic_libraries.WebDriverUtiles;

public class CreateOpporturnitiesaccount 
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
	
	//click on oppurtunites link
			driver.findElement(By.xpath("//a[@href='index.php?module=Potentials&action=index']")).click();
			
			//click on create oppurtunities lookup button
			driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
			
			Thread.sleep(3000);
			//inspect the oppurtinie name
			driver.findElement(By.xpath("//input[@name='potentialname']")).sendKeys("Basic");
			
			//click on plue symbol at organization
			driver.findElement(By.xpath("//img[@title='Select']")).click();
			
			//handling the window
			wutil.switchtochildwindow(driver, "Accounts&action");
			
			//inspect the serach box and type the oppurtunites name 
			driver.findElement(By.xpath("//input[@name='search_text']")).sendKeys("Tekpyramid-1071510936");
			
			//inspect the search button 
			driver.findElement(By.xpath("//input[@name='search']")).click();
			
			
			//inspect the "Tekpyramid-1071510936" and perform click action
			driver.findElement(By.xpath("//a[@href='javascript:window.close();']")).click();
		
		    //switch back to parent 
			wutil.switchToParentWindow(driver, parentID);
			
			driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			Thread.sleep(4000);
			
	//validate the message 
			String validate = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
			System.out.println(validate);
			
			  //Click on 'Sign Out'
			//click on adminstrator icon
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();

			//mousehover on 'signout' link and click on that
			WebElement signout = driver.findElement(By.xpath("//a[text()='Sign Out']"));
			
			wutil.mousehoverandclickonEle(driver, signout);

			driver.quit();
			

		
	}
}
