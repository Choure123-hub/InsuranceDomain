package Module2_Claims;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBHomePage {
	@FindBy(xpath="//img[@class='logo-large']")private WebElement Menubtn;
	 @FindBy(xpath="(//p[text()='Term Insurance'])[2]")private WebElement Lifeinsurance;
	  WebDriver driver1;
	   public PBHomePage(WebDriver driver) 
	   {
		PageFactory.initElements(driver, this);
		driver1=driver;
	}
	   public void clickOnMenuBtnFromPB() throws InterruptedException {
		   Menubtn.click();
		   Thread.sleep(3000);
		  
	}
	   public void clickOnLifeinsurance() {
		 Lifeinsurance.click();
		 Set<String> alllad = driver1.getWindowHandles();	
		   ArrayList<String>al=new ArrayList<String>(alllad);
		   driver1.switchTo().window(al.get(0));

	}
	   
	   public void SwitchToChildWindow() 
	   {
	   Set<String> alllad = driver1.getWindowHandles();	
	   ArrayList<String>al=new ArrayList<String>(alllad);
	   driver1.switchTo().window(al.get(1));

	   }   
}
