package Project_framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProductCheckBox
{
	public static void main(String[] args) throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		//give the URL
			driver.get("http://localhost:8888/");

			//wait the load
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

			//login to application
			driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys("admin");
			driver.findElement(By.xpath("//input[@id='submitButton']")).click();
			
			//click on product link
			driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();

			//inspected the productname and stroring it in a refvar listofproducts
			List<WebElement> listofproducts = driver.findElements(By.xpath("//a[text()='Raga Watch']"));
		
			for(WebElement ele:listofproducts)
			{
				String mypro = ele.getText();
			System.out.println(mypro);
				if(mypro.equals(mypro))
				{
					System.out.println("Product is created and added to list");
					
				}
				

			}
	
	}
}