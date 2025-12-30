package Generic_libraries;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.module.Browser;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import ObjectPom.Home_page;
import ObjectPom.LoginPage;
@Listeners(Generic_libraries.ListnerImplementationClass.class)
public class BaseClass 
{
	//we should make it public bcz the basecalss in diffrent pacakge and the script class are in diff pack
	public FileUtiles fu= new FileUtiles();
	public Excelutiles eu= new Excelutiles();
	public WebDriverUtiles wu= new WebDriverUtiles();
	public JavaUtils ju= new JavaUtils();
	public databaseUtiles du = new databaseUtiles();
	
	public WebDriver driver;
	
	//
	public static WebDriver sdriver;
	
	@BeforeSuite 
	public void ConnectToDb() throws SQLException
	{
//		du.createDBRegister();
		System.out.println("connected to DB");
		
	}
	
	//@Parameters("BROWSER")
@BeforeClass
public void launchBrowser() throws IOException
{
	String BROWSER = fu.ReadTheDataFromThePropertyFile("browser");
	String url = fu.ReadTheDataFromThePropertyFile("url");
	
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
	
	sdriver= driver;
	//maximize the window
	wu.maximizeWindow(driver);
	
	//navigate to url
	driver.get(url);
	System.out.println("launch browser");
	
	//wait for load
	wu.waitForPageLoad(driver, 10);
     
}
	//before method
	@BeforeMethod
	public void loginToApp() throws IOException
	{
		String USERNAME = fu.ReadTheDataFromThePropertyFile("username");
		String PASSWORD = fu.ReadTheDataFromThePropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.LoginToApp(USERNAME, PASSWORD);
		System.out.println("*****login to application*****");
		
	}
	
	//after method
	@AfterMethod
	public void logoutfromAccount()
	{
		Home_page hp = new Home_page(driver);
		hp.Signout(driver);
		//System.out.println("******logout from the account*****");
	}
	
	//afterclass
	@AfterClass
	public void CloseBrowser()
	{
		driver.quit();
		System.out.println("close the browser");
	}

@AfterSuite
public void disconnect() throws SQLException
{
//	du.disconnectionDB();
	System.out.println("disconnected to DB");
}


}
