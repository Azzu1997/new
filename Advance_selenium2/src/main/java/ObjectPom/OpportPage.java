package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpportPage 
{
	//decalration
@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
private WebElement lookupbtn;

//initilization
//paramitarized constructor
public OpportPage( WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

//utilization
public WebElement getlookupbtton()
{
	return lookupbtn;
}

//bussiness logic

public void lookupbtn()
{
	lookupbtn.click();
}
}
