package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_libraries.WebDriverUtiles;

public class Home_page extends WebDriverUtiles
{
	//declartions
	@FindBy(linkText = "Calendar")
	private WebElement CaleLink;
	
	@FindBy(linkText = "Organizations")
	private WebElement OrgLink;
	
	@FindBy(xpath = "//a[@href='index.php?module=Contacts&action=index']")
	private WebElement ContLink;

	@FindBy(linkText = "Opportunities")
	private WebElement OppLink;
	
	@FindBy(linkText = "Products")
	private WebElement ProLink;
	
	@FindBy(linkText = "Documents")
	private WebElement DocLink;
	
	@FindBy(linkText = "Email")
	private WebElement EmailLink;
	
	@FindBy(linkText = "Trouble Tickets")
	private WebElement TroTicLink;


	@FindBy(linkText = "Dashboard")
	private WebElement DashLink;
	
	@FindBy(linkText = "Leads")
	private WebElement LeadLink;
	
	@FindBy(linkText = "Vendors")
	private WebElement VenLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdminstorLink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutLink;
	
	//initilization
	//parmitarized constructor
	public Home_page(WebDriver driver)
	{
		PageFactory.initElements( driver, this);
	}
	
	public WebElement getCaleLink() {
		return CaleLink;
	}

	public WebElement getOrgLink() {
		return OrgLink;
	}

	public WebElement getContLink() {
		return ContLink;
	}

	public WebElement getOppLink() {
		return OppLink;
	}

	public WebElement getProLink() {
		return ProLink;
	}

	public WebElement getDocLink() {
		return DocLink;
	}

	public WebElement getEmailLink() {
		return EmailLink;
	}

	public WebElement getTroTicLink() {
		return TroTicLink;
	}

	public WebElement getDashLink() {
		return DashLink;
	}

	public WebElement getLeadLink() {
		return LeadLink;
	}

	public WebElement getVenLink() {
		return VenLink;
	}

	public WebElement getAdminstorLink() {
		return AdminstorLink;
	}

	public WebElement getSignOutLink() {
		return SignOutLink;
	}

	
	//Bussiness logic
	public void Calendar()
	{
		CaleLink.click();
	}
	
	public void Organizations()
	{
		OrgLink.click();
	}
	public void COntcats()
	{
		ContLink.click();
	}
	
	public void Opportunities()
	{
		OppLink.click();
	}
	public void Products()
	{
		ProLink.click();
	}
	public void Documents()
	{
		DocLink.click();
	}
	public void Email() 
	{
		EmailLink.click();
	}
	public void TroubleTickets()
	{
		TroTicLink.click();
	}
	public void Dashboard()
	{
		DashLink.click();
	}
	public void Leads()
	{
		LeadLink.click();
	}
	public void Vendors()
	{
		VenLink.click();
	}
	
	
	public void Signout(WebDriver driver)
	{
		mouseHover(driver, AdminstorLink	);
		//AdminstorLink.click();
		mousehoverandclickonEle( driver,SignOutLink);
		}
	}