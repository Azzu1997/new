package ObjectPom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_libraries.WebDriverUtiles;

	public class ProductLokupPage extends WebDriverUtiles {
		//declaration
		
		@FindBy(xpath = "//img[@title='Create Product...']")
		private WebElement produlink;
		
			@FindBy(name="productname")
			private WebElement productName;
			
			@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
			private WebElement vendorLookUpImg;
			
			@FindBy(name="search_text")
			private WebElement seachtext;
			
			@FindBy (name="search")
			private WebElement search;
			
			@FindBy(xpath="//a[@href='javascript:window.close();']")
			private List<WebElement> allvend;
			
			@FindBy(xpath="//input[@title='Save [Alt+S]']")
			private WebElement savebtn;
			
			//initialization
			 public ProductLokupPage(WebDriver driver){
				PageFactory.initElements(driver, this);
			}

			
			//utilization
			 
			 public WebElement getPrdolink()
			 {
					return produlink;

			 }
			public WebElement getProductName() {
				return productName;
			}

			public WebElement getVendorImage() {
				return vendorLookUpImg;
			}
			public WebElement getSeachText() {
				return seachtext;
			}


			public WebElement getSearch() {
				return search;
			}
			public List<WebElement> getAllvend() {
				return allvend;
			}

			public WebElement getSavebtn() {
				return savebtn;
			}
			
			//business logic
			public void createProduct(String proName) {
				productName.sendKeys(proName);
				savebtn.click();
			}
			
			
			
			//business logic
			public void createproductNameVendor(String pName,WebDriver driver,String text) {
				produlink.click();
				productName.sendKeys(pName);
			
				vendorLookUpImg.click();
				
				 String parent=driver.getWindowHandle();
				 switchtochildwindow(driver,"Vendors&action");
			
				seachtext.sendKeys(text);
			
				search.click();
				
				for(WebElement win:allvend) {
				    String vendname = win.getText();
				    if(vendname.equals(text)) {
				    	win.click();
				    	break;
				    }
				    }
			  switchToParentWindow(driver, parent);
			savebtn.click();
			}
			
	}