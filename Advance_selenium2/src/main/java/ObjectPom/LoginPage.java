package ObjectPom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	//declaration
@FindBy(name="user_name")
private WebElement username;

@FindBy(name="user_password")
private WebElement password;

@FindBy(id="submitButton")
private WebElement submitbutton;

//initilization
// Parameterized constructor 
public LoginPage(WebDriver driver)
{
	PageFactory.initElements( driver, this );
}
//utilization
//here we are using get() method for security
public WebElement getusername()
{
	return username;
}
public WebElement getpassword()
{
	return password;
}
public WebElement submitbutton()
{
	return submitbutton;
}
//bussiness logic
public void LoginToApp(String Username, String Password)
{
	username.sendKeys(Username);
	password.sendKeys(Password);
	submitbutton.click();
}


}
