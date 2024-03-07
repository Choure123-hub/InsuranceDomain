package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBLogOutFromAppPage 
{

	@FindBy(xpath="//div[@title='Logout']")private WebElement LogOut;
	
	public PBLogOutFromAppPage(WebDriver driver)
	{
	PageFactory.initElements(driver,this);	
	}
	public void ClicLogOutBtn() 
	{
		LogOut.click();
	}
}
