package Organization;

import java.io.IOException;
import java.time.Duration;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import Generic_libraries.BaseClass;
import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.JavaUtils;
import Generic_libraries.WebDriverUtiles;
import ObjectPom.ContLookupImagePage;
import ObjectPom.Contactpage;
import ObjectPom.Home_page;
import ObjectPom.LoginPage;
import ObjectPom.OganizationPage;
import ObjectPom.OrgLookImagePage;

public class CreateOrganizationWithDropDown extends BaseClass
{
	//non static method
	@Test
	public void CreateOrgWithManFeilds() throws IOException
	{
	
		
		 //click on organization link
		Home_page hp = new Home_page(driver);
		 hp.Organizations();
		 
		 //click on create organization lookup image
		 OganizationPage op= new  OganizationPage(driver);
		 op.imgORG();
		 
		 
		 String orgname = eu.readSingleDataFromEXcel("Organization", 0, 1)+ju.getRandomno();
		    String IndDD = eu.readSingleDataFromEXcel("Organization", 1, 1);
		    
		    
		OrgLookImagePage ol= new OrgLookImagePage(driver);
		ol.CreateOrg(orgname, IndDD);
		 
	}
//	public void impact()
//	{
//		System.out.println("*******Impacted areas************");
//	}
	
}