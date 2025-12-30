package Project_framework.Tasks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class WorldMeter5
{
public static void main(String[] args) 
{
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.worldometers.info/world-population/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	
Actions act = new Actions(driver);
act.moveToElement(driver.findElement(By.xpath("//h2[text()='How many people have ever lived on earth?']"))).click().perform();

//driver.findElement(By.xpath("//div[@class='datatable-wrapper datatable-loading no-footer sortable searchable fixed-columns']//a[text()='  Holy See  ']")).click();
	
}
}
