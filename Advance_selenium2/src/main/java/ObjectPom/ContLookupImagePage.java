package ObjectPom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_libraries.WebDriverUtiles;

public class ContLookupImagePage extends WebDriverUtiles
{
	//declaration
	
	
		@FindBy(name="lastname")
	       private WebElement lastName;

		@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgLookupImg;

		@FindBy(name="search_text")
	    private WebElement searchText;

		@FindBy(name="search")
		private WebElement search;
		
		@FindBy(xpath="//a[@href='javascript:window.close();']")
		private List<WebElement> allOrg;
		
		@FindBy(xpath="//input[@title='Save [Alt+S]']")
		private WebElement save;
		
		//initialization
		public ContLookupImagePage(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		
		//utilization
         public WebElement getLastName() {
			return lastName;
		}

		public WebElement getorgLookup() {
			return orgLookupImg;
		}

		public WebElement getSearchText() {
			return searchText;
		}
		public WebElement getSearch() {
			return search;
		}
		
	    public List<WebElement> getAllOrg() {
			return allOrg;
		}

		public WebElement getSave() {
			return save;
		}
		
		
		//business logic
		public void createonContactNameOrg(String contName,WebDriver driver,String text) {
			lastName.sendKeys(contName);
		
			orgLookupImg.click();
			
			String parentId = driver.getWindowHandle();
			switchtochildwindow(driver,"Accounts&action");
		
			searchText.sendKeys(text);
		
			search.click();
			for(WebElement win:allOrg)
			{
				String actualOrg = win.getText();
				if(actualOrg.equals(text)) {
					win.click();
					break;
				}
			}
		
			switchToParentWindow(driver, parentId);
		
			save.click();
		}
}


		