package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.jdbc.Driver;

public class ProductPage 
{
	
	@FindBy(xpath = "//a[@href='index.php?module=Products&action=index']")
	private WebElement prolink;
	
	
	//paramitarized construtor
	public ProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}


	public WebElement getProlink() {
		return prolink;
	}

	//bussiness logic
	public void productlink()
	{
		prolink.click();
	}

	
}

