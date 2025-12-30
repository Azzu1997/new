package Project_framework.Tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class UploadTheFile 
{
	public static void main(String[] args) throws InterruptedException
	{
	WebDriver	driver =new ChromeDriver();
	driver.get("https://testautomationpractice.blogspot.com/");
	
	//maximize window
	driver.manage().window().maximize();

	//blog is in nested shadow, fist we are finding the host of the 1st shadow root
	//SearchContext shadowhost0 = driver.findElement(By.cssSelector("div[id='shadow_host']")).getShadowRoot();
	
	//later we are finding the host the 2nd shadow root
	//SearchContext shadowroot1 = shadowhost0.findElement(By.className("div[id='nested_shadow_host']")).getShadowRoot();
	
	Thread.sleep(3000);
	
	// 1. Locate main shadow host
	WebElement shadowHost = driver.findElement(By.cssSelector("#shadow_host"));

	// 2. Enter shadow root
	SearchContext shadowRoot = shadowHost.getShadowRoot();
	shadowHost.findElement(By.cssSelector("input[type='file']"));

	// 3. Locate the file input inside the shadow DOM
	//WebElement fileInput = shadowRoot.findElement(By.cssSelector("input[type='file']"));
	
	Thread.sleep(4000);
	//scrolling it the elemnt
		WebElement element = driver.findElement(By.cssSelector("input[type='file']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).perform();
		
		Thread.sleep(4000);
      // 4. Upload file
	   //fileInput.sendKeys("C:\\Users\\shaik\\OneDrive\\Desktop");

	
	
	
	
	
//driver.quit();
	
	
	}
	
}