package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PBPoliciesPage 
{
@FindBy(xpath="//p[text()='Policies']")private WebElement polic;
@FindBy(xpath="//p[text()='Bhagvan']")private WebElement titile;
@FindBy(xpath="(//img[@alt='banner1'])[3]")private WebElement slider;


public PBPoliciesPage (WebDriver driver) 
{
	PageFactory.initElements(driver, this);
	
}
public void clickOnPolicies() 
{
	polic.click();
}
public void Policiesgettitle() 
{
	String text = titile.getText();
	System.out.println(text);
}
public void clickOnSlider() throws InterruptedException 
{
	slider.click();
	
	Thread.sleep(3000);
	
}
}
