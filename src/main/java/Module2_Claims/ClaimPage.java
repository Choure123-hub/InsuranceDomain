package Module2_Claims;

import java.util.ArrayList;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClaimPage 
{

    @FindBy(xpath="//a[text()='Claim ']")private WebElement Claim;
  @FindBy(xpath="(//span[text()='Know more about filing claim'])[1]")private WebElement Knowmoreaboutfiling;

  WebDriver driver1;
  public  ClaimPage(WebDriver driver)
  {
	  PageFactory.initElements(driver, this);
	  driver1=driver;
  }
  public void SwitchToclaimdWindow() 
  {
  Set<String> alllad = driver1.getWindowHandles();	
  ArrayList<String>al=new ArrayList<String>(alllad);
  driver1.switchTo().window(al.get(2));
  

  }
  public void OpenOptionPBClaimPage() 
  {
	Actions act=new Actions(driver1);
			act.moveToElement(Claim).perform();
}
  public void ClickKnowmoreaboutfiling() 
  {
	  Knowmoreaboutfiling.click();
	  Set<String> alllad = driver1.getWindowHandles();	
	  ArrayList<String>al=new ArrayList<String>(alllad);
	  driver1.switchTo().window(al.get(0));
	  
}
  public String getPageTitle()
  {
	  return driver1.getTitle();
	  
	 
  }
//  public void SwitchTomaindWindow() 
//  {
//  Set<String> alllad = driver1.getWindowHandles();	
//  ArrayList<String>al=new ArrayList<String>(alllad);
//  driver1.switchTo().window(al.get(0));
//  
//
//  }
}
