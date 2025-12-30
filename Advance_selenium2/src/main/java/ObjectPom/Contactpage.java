package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Contactpage 
{
//decalration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement conlookup;;
	
	
	
	//paramitarized constructor
		//initilization
	public Contactpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);

	}
	
	//utilization

public WebElement getLookupbtn() {
		return conlookup;
	}
	
	//bussiness logic
	
	public void lookupbutton()
	{
		conlookup.click();
	}
 
 
}
