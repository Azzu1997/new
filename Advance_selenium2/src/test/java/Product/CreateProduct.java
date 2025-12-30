package Product;

import java.io.IOException;

import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import Generic_libraries.BaseClass;
import ObjectPom.Home_page;
import ObjectPom.ProductLokupPage;
import ObjectPom.ProductPage;

public class CreateProduct extends BaseClass
{
	

		@Test(groups="regression")
		public void CreateProduct() throws IOException, InterruptedException {
//			WebDriver driver=null;
//			
//				
//				propetiesUtile pLib = new propetiesUtile();
//				excelUtiles eLib=new excelUtiles();
//				javaUtiles jLib=new javaUtiles();
//				WebDRiverUtiles wlib=new WebDRiverUtiles();
				
				String expVendor="pagar";
				String expProduct="laptop";
				
//				String BROWSER = pLib.readDataproprty("browser");
//				String URL = pLib.readDataproprty("url");
//				String USERNAME = pLib.readDataproprty("username");
//				String PASSWORD = pLib.readDataproprty("password");
//				
//				System.out.println(BROWSER);
//				 System.out.println(URL);
//				 System.out.println(USERNAME);
//				 System.out.println(PASSWORD);
//				 
				//excel

					 String vendName =eu.readSingleDataFromEXcel("Products",0,0)+ju.getRandomno();
					 String prodName =eu.readSingleDataFromEXcel("Products",0,1)+ju.getRandomno();
					      
//					       System.out.println(vendName);
//					       System.out.println(prodName);
				
				  //launch the browser 
//			       if(BROWSER.equalsIgnoreCase("chrome"))
//			   	{
//			   		driver = new ChromeDriver();
//			   	}
//			   	else if (BROWSER.equalsIgnoreCase("edge"))
//			   	{
//			   		driver =new EdgeDriver();
//			   	}
//			   	else if (BROWSER.equalsIgnoreCase("firefox")) 
//			   	{
//			   		driver =new FirefoxDriver();
//			   	}
//				//maximize window
//				wlib.maximizeWindow(driver);
//				
//				//enter url
//				driver.get(URL);
//				
//				//handle parent window
//			//	String parentId=driver.getWindowHandle();
//				
//				//wait for page load
//				wlib.waitForPageLoad(driver, 10);
//				
				//step1:login to application
//				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
//				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
//				driver.findElement(By.id("submitButton")).click();
//				LoginPage login = new LoginPage(driver);
//				login.logintoHome(USERNAME, PASSWORD);
//				
				
		//step2:click on product link
//driver.findElement(By.xpath("//a[@href='index.php?module=Products&action=index']")).click();
					 Home_page hp = new Home_page(driver);
						hp.Products();
				
		  //step3:click on product lookup image
		//driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
//						ProductPage p = new ProductPage(driver)	;
//						p.productlink();
		
			//step4:enter the product name
//driver.findElement(By.name("productname")).sendKeys(expProduct);
ProductLokupPage plook= new ProductLokupPage(driver);
plook.createproductNameVendor(prodName, driver, expVendor);
				//step5:click on vendor lookup image
			//driver.findElement(By.xpath("//input[@name='vendor_name']/following-sibling::img[@src='themes/softed/images/select.gif']")).click();
				   
				
				
				//child window
			//	wlib.handlewindows(driver, "Vendors&action");
				
				
				
				//step6:clcik on search button
		//	  driver.findElement(By.name("search_text")).click();
				
			  //step7:enter the vendor name
		//	  driver.findElement(By.name("search_text")).sendKeys(expVendor);
				
			  //step7:click on search now button
		//	  driver.findElement(By.xpath("//input[@type='button']")).click();
				
			  
			 // driver.findElement(By.xpath("//a[text()='pagar']")).click();
			  
			//parent window  
			//wlib.parentWindowId(driver, parentId);
			 
			  
			//  wlib.switchToParentWindow(driver, "Products&action");
			  
//			 driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
			
			
			//confirmation
//			  String actual = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
//			  if(actual.contains(expProduct)) {
//				  System.out.println("product is matching");
//			  }
//			  else {
//				  System.out.println("product not matching");
//			  }
					 //Thread.sleep(5000);
			// allConnfirmationPage confirm = new allConnfirmationPage(driver);
			//  confirm.ConfirmMsg(expProduct);
	//
			//  Thread.sleep(5000);
			  //signup
//				wlib.mouseHover(driver,driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")));
//				wlib.movetoElementclick(driver,driver.findElement(By.linkText("Sign Out")));
			 // Thread.sleep(3000);
			  
//				hp.ClickSignOutbtn(driver);
			  
				//driver.quit();
					
					 
			}
	}

