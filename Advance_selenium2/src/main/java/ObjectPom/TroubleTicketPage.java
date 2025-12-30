package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TroubleTicketPage
{
//initilization
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement lookupbun;

//paramitarized constructor
//declaration
 public TroubleTicketPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}



//utilization
public WebElement getlookupbtn()
{
	return lookupbun;
}
public void lookupbun()
{
	lookupbun.click();
}
}

