package Module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PBLoginWithPwdPage {
@FindBy(xpath="//input[@name='password']") private WebElement Pwd;
 @FindBy(xpath="//button[text()='LOGIN']")private WebElement loginWithPwd;
 
 public PBLoginWithPwdPage (WebDriver driver) {
	PageFactory.initElements(driver, this);
}
 public void inpPBLoginWithPwdPagePwd(String Password) {
	Pwd.sendKeys(Password);
	
}
 public void ClickPBLoginWithPwdPageloginWithPwd() {
	 loginWithPwd.click();
}
}
