package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OganizationPage {
		
	    //declaration
		@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
		private WebElement lookupbtn;
		
		
		//initialization
		public OganizationPage(WebDriver driver){
			PageFactory.initElements(driver, this);
		}
		
		
		//utilization
		public WebElement getlook() {
			return lookupbtn;
		}
		
		//business logic
             public void imgORG() {
			// TODO Auto-generated method stub
			lookupbtn.click();

		}


		


		


		
	}

