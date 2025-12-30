package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mysql.cj.jdbc.Driver;

import Generic_libraries.WebDriverUtiles;

	public class OrgLookImagePage extends WebDriverUtiles
	
	{
           //declaration
			@FindBy(name="accountname")
			private WebElement orgName;
			
			@FindBy(name="industry")
			private WebElement indDD;
			
			@FindBy(id ="search_txt")
			private WebElement searchtxt;
			
			@FindBy(name="search")
			private WebElement searchbtn;
			
			@FindBy(xpath="//input[@title='Save [Alt+S]']")
			private WebElement save;
			
			//initialization
			public OrgLookImagePage(WebDriver driver)
			{
				PageFactory.initElements(driver, this);
			}
			//utilization
			
			public WebElement getOrgName() {
				return orgName;
			}
			
			public WebElement getInDD() {
				return indDD;
			}
			public WebElement getSave() {
				return save;
			}
			public WebElement getsearchtxt() {
				return searchtxt;
			}
			public WebElement searchbtnnn() {
				return searchbtn;
			}
			
			//BUssiness logic
			public void CreateOrg(String Org, String indDD)
			{
				orgName.sendKeys(Org);
				
				//indDD.sendKeys(indDD);
				
			}
				

				
	
//			public void Industry(String Industry )
//			{
//				indDD.sendKeys(Industry);
//			}
//		
//			
//			public void Savtebtn()
//			{
//				save.click();
//			}
//			public void seacrchtxt(String name) {
//				searchtxt.sendKeys(name);
//			}
//			public void searchbutton() {
//				searchbtn.click();
//			}
	}