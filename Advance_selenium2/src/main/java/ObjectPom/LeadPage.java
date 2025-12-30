package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadPage 
{
@FindBy(xpath = "//img[@title='Create Lead...']")
private WebElement leadlooupimg;


public LeadPage(WebDriver driver)
{
PageFactory.initElements(driver, this);	
}

public WebElement getleadlooupimg()
{
	return leadlooupimg;
}

//bussiness logic
public void leadlookup() 
{
	leadlooupimg.click();
}
}
