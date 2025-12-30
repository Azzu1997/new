package Advance_selenium;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ReadingDataFromPropertiesFileTest 
{
		public static void main(String[] args) throws IOException
		{
		//Step1 : create object for physical representation of file
	   FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\ResourceFile\\commondata.properties");
					
					//Step2:Create object for properties file
					Properties pObj=new Properties();
					
					//Step3:load all the keys
					pObj.load(fis);
					
					//Step4: fetch the values using "getPtoperty" method
					String BROWSER = pObj.getProperty("browser");
					String URL=pObj.getProperty("url");
					String USERNAME=pObj.getProperty("username");
					String PASSWORD=pObj.getProperty("password");
					
					//Read all the data
					System.out.println(BROWSER);
					System.out.println(URL);
					System.out.println(USERNAME);
					System.out.println(PASSWORD);
					
					
					WebDriver driver = null;
					//launch the browser
					if(BROWSER.equalsIgnoreCase("chrome")) {
						driver = new ChromeDriver();
					}
					else if(BROWSER.equalsIgnoreCase("firefox")) {
						driver=new FirefoxDriver();
					}
					else if(BROWSER.equalsIgnoreCase("edge")) {
						driver=new EdgeDriver();
					}
					
					//maximize the window and implicit wait
					driver.manage().window().maximize();
					driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
					
					//enter the url
					driver.get(URL);
				
					//pass the username and password data
					driver.findElement(By.name("user_name")).clear();
					driver.findElement(By.name("user_name")).sendKeys(USERNAME);
					driver.findElement(By.name("user_password")).clear();
					driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
					driver.findElement(By.id("submitButton")).click();
				}

	}

