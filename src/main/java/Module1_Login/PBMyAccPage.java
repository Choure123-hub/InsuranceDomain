package Module1_Login;

import java.util.ArrayList;
import java.util.Set;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBMyAccPage {
	 @FindBy(xpath="//p[text()='Profile']") private WebElement Profile;

   @FindBy(xpath="//input[@name='personName']") private WebElement fullName;

  
   WebDriver driver1;
   public PBMyAccPage(WebDriver driver) 
   {
	PageFactory.initElements(driver, this);
}
   
   public void ClickPBMyAccPageProfile() {
	   Profile.click();
	  String text = Profile.getText();
	  System.out.println(text);
}
  
   public String getPNPBMyAccPageProfileName() 
   {
	   String actPN= fullName.getAttribute("value");
	   return actPN;
	   
	   
//	   String actPN= fullName.getAttribute("value");
//		
//		if(actPN.equals(expPN))
//		{
//			System.out.println("Pass");
//		}
//		else
//		{
//			System.out.println("Fail");
//		}
		
}
}
