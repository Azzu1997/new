package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTickectLookupImage
{
//declarion
	@FindBy(xpath = "//textarea[@name='ticket_title']")
	private WebElement ticketitle;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;
	
	
	//paramitarized constructor
	public TroubleTickectLookupImage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	private WebElement getticketitle() {
		return ticketitle;
	}
	
	private WebElement getsavebtn()
	{
		return savebtn;
		
	}
	
	//bussiness logic
	public void createtroubleTicket(String troubletitle)
	{
		ticketitle.sendKeys(troubletitle);
		savebtn.click();
	}

}
