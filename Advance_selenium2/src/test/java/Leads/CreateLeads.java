package Leads;

import java.io.IOException;

import org.testng.annotations.Test;

import Generic_libraries.BaseClass;
import Generic_libraries.Excelutiles;
import Generic_libraries.FileUtiles;
import Generic_libraries.JavaUtils;
import ObjectPom.Home_page;
import ObjectPom.LeadLookUpImgPage;
import ObjectPom.LeadPage;

public class CreateLeads extends BaseClass
{
	@Test
	public void createlead() throws IOException
	{
		
	
FileUtiles fu= new FileUtiles();
Excelutiles eu= new Excelutiles();
JavaUtils ju= new JavaUtils();

String lasname = eu.readSingleDataFromEXcel("Leads", 0, 0);
String compname = eu.readSingleDataFromEXcel("Leads", 1, 1);
String indrop = eu.readSingleDataFromEXcel("Leads", 2, 1);

Home_page hp= new Home_page(driver);
hp.Leads();

LeadPage lp= new LeadPage(driver);
lp.leadlookup();

LeadLookUpImgPage lokup= new LeadLookUpImgPage(driver);
lokup.createLead(lasname, compname, indrop);
	}
}
