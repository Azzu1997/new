package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_libraries.WebDriverUtiles;

public class LeadLookUpImgPage extends WebDriverUtiles
{
@FindBy(xpath = "//input[@name='lastname']")
private WebElement lastname;

@FindBy(xpath = "//input[@name='company']")
private WebElement campanyname;

@FindBy(xpath = "//select[@name='industry']")
private WebElement indDD;

@FindBy(xpath = "//input[@title='Save [Alt+S]']")
private WebElement savebtn;




//constructor
public LeadLookUpImgPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getlastname()
{
	return lastname;
}

public WebElement getcomapnyname()
{
	return campanyname;
}

public WebElement getIndDD()
{
	return indDD;
}

public WebElement getsavebtn()
{
	return savebtn;
}
//bussines logic

public void createLead(String lasname, String compname, String indrop)
{
	lastname.sendKeys(lasname);
	campanyname.sendKeys(compname);
	indDD.click();
	indDD.sendKeys(indrop);
	savebtn.click();
	
}
}
