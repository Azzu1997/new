package Project_framework.Tasks;


	import java.time.Duration;

import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;

	public class Slider 
	{
	    public static void main(String[] args) throws InterruptedException {
	  WebDriver driver = new ChromeDriver();
	   driver.get("https://testautomationpractice.blogspot.com/");
	   driver.manage().window().maximize();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	   
	   
	   Thread.sleep(3000);
	   
	  //moving to the element
	  Actions actions = new Actions(driver);
actions.moveToElement(driver.findElement(By.xpath("//h2[text()='Dynamic Web Table']"))).perform();
   
     
     
 WebElement slider = driver.findElement(By.xpath("//div[@id='slider-range']"));
 
//text to print

 WebElement label = driver.findElement(By.xpath("//input[@id='amount']")); 

      // Move slider by 50px horizontally
 actions.clickAndHold(slider).moveByOffset(50, 0).release().perform();
 
Thread.sleep(1000);  // wait for text update

System.out.println("Updated text: " + label.getText());

driver.quit();
  }
	}


