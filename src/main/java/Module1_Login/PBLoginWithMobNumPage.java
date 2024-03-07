package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBLoginWithMobNumPage {
@FindBy(xpath="//input[@id='mobileNo']") private WebElement mobNum;
@FindBy(xpath="//button[text()='Sign in with Password']")private WebElement loginWithPwd;
//button[text()='LOGIN WITH PASSWORD']
public PBLoginWithMobNumPage(WebDriver driver)
{
PageFactory.initElements(driver,this);	
}
public void inpPBLoginWithMobNumPageMobNum (String MobNumber) {
	
mobNum.sendKeys(MobNumber);

}
public void ClickPBLoginWithMobNumPageloginWithPwd () {
	loginWithPwd.click();
}

}
