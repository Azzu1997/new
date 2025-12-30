package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VenderPage 
{
	
	
		@FindBy(xpath = "//img[@alt='Create Vendor...']") 
		private WebElement CreateVendorSym;
		
		public  VenderPage (WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		public WebElement getCreateVendorSym() {
			return CreateVendorSym;
		}
		
		//bussiness logic
		public void createvendor()
		{
			 CreateVendorSym.click();
			
		}
		
	}


