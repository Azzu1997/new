package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorLookupPage 
{
		
		@FindBy(xpath = "//input[@name='vendorname']") 
		private WebElement vendorname;
		
		@FindBy(xpath = "//input[@title='Save [Alt+S]']") 
		private WebElement SaveBt;
		
		public VendorLookupPage  (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getVendorname() {
			return vendorname;
		}

		public WebElement getSaveBt() {
			return SaveBt;
		}
		//bussiness logic
		
		public void CreateVenAcc(String Vename)
		{
			vendorname.sendKeys(Vename);
			SaveBt.click();
			
		}
	}

	
