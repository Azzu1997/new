package Project_framework.Tasks;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Olympics
{
public static void main(String[] args) 
{
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
driver.get("https://www.bbc.com/sport/olympics/paris-2024/BK3MTEAM3/results");
driver.manage().window().maximize();

//xpath to print all the options in dropdown
List<WebElement> options = driver.findElements(By.xpath("//select[@data-testid='select']/option"));

//for each loop to print all the names in the dropdown
for(WebElement option:options)
{
	System.out.println(option.getText());
}

driver.findElement(By.xpath("//select[@data-testid='select']/option[text() = 'Athletics']")).click();
System.out.println("List of contries");

List<WebElement> allcountries = driver.findElements(By.xpath("//div[@class='ssrcss-1n8wi18-SecondaryName e1dg50ic0']"));
for(WebElement con: allcountries)
{
	System.out.println(con.getText());
}


driver.quit();

 
 
}
}
