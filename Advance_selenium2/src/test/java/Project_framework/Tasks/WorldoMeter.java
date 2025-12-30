package Project_framework.Tasks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorldoMeter
{
public static void main(String[] args)
{
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.worldometers.info/geography/countries-of-the-world/");
	driver.manage().window().maximize();
	driver.findElement(By.xpath("//div[@class='shrink-0' ]/descendant::button[@type='button']")).click();
	
	driver.findElement(By.xpath("//a[text()='  Food & Agriculture  ']")).click();
}
}
