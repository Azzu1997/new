package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_libraries.WebDriverUtiles;

public class OppuLookUpPage extends WebDriverUtiles
{
//decration
	
	
	@FindBy(xpath = "//input[@name='potentialname']")
	private WebElement oppNmae;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement OrgDD;
	
	@FindBy(xpath = "//input[@name='search_text']")
	private WebElement searchtext;
	
	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchbtn;
	
	@FindBy(xpath = "//a[text()='TCS867']")
	private WebElement select;

	
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebtn;


	
	//intilization
	//paramitarized constructor
	public OppuLookUpPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getOppname()
	{
		return oppNmae;
	}
	
	public WebElement getOrgDD()
	{
		return OrgDD;
	}
	
	public WebElement getSearchtxt()
	{
		return searchtext;
	}
	
	public WebElement getsearchbtn()
	{
		return searchbtn;
	}
	
	public WebElement getselect()
	{
		return select;
	}
	
	
	public WebElement getsavebtn()
	{
		return savebtn;
	}
	
	//bussiness logic
	public void CreateOpputur( WebDriver driver,  String oppNa, String text)
	{
		oppNmae.sendKeys(oppNa);
		OrgDD.click();
		 String parent=driver.getWindowHandle();
		 switchtochildwindow(driver, "Accounts&action");
		 searchtext.sendKeys(text);
		 searchbtn.click();
		 select.click();

		 switchToParentWindow(driver, "Potentials&action");
		 savebtn.click();
		 
	}

}
