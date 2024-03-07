package Module2_ClaimsTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;

import Module1_Login.PBHomePage;
import Module1_Login.PBLogOutFromAppPage;
import Module1_Login.PBLoginWithMobNumPage;
import Module1_Login.PBLoginWithPwdPage;

import Module2_Claims.ClaimPage;

public class PBClaimsTest extends BaseClass
{
	
	PBLoginWithMobNumPage login;
	PBLoginWithPwdPage Pwd;
	PBHomePage home;
	ClaimPage claim;
	
	 PBLogOutFromAppPage logout;
	 int TCID;
	 @BeforeClass
	 public void OpenBrowser() throws EncryptedDocumentException, IOException 
	 {
	 		
	 		
	 	    initializeBrowser();
	 		login=new PBLoginWithMobNumPage(driver);
	 		 Pwd=new PBLoginWithPwdPage(driver);
	 		
	 		 logout =new PBLogOutFromAppPage(driver);  
	 		 home=new PBHomePage(driver);
	 		claim =new ClaimPage (driver);
	 }
	 @BeforeMethod
	 public void loginToApp() throws EncryptedDocumentException, IOException 
	 {
	 		login.inpPBLoginWithMobNumPageMobNum(UtilityClass.readDataFromPF("mobNum"));
	 		login.ClickPBLoginWithMobNumPageloginWithPwd();
	 		Pwd.inpPBLoginWithPwdPagePwd(UtilityClass.readDataFromPF("pwd"));
	 		Pwd.ClickPBLoginWithPwdPageloginWithPwd();
	 		
	 }
@Test(priority = 1)
public void ClickOnClaim() throws InterruptedException 
{
	TCID=105;
	home.clickOnMenuBtnFromPB();
	home.SwitchToChildWindow();
	claim.OpenOptionPBClaimPage();
	
	claim.ClickKnowmoreaboutfiling();
	
	claim.getPageTitle();
//	String title = driver.getTitle();
//	
//	System.out.println(title);
	System.out.println(driver.getTitle());
}

@AfterMethod
public void logOutFromApp(ITestResult s1) throws IOException 
{
		
		
	if(s1.getStatus()==ITestResult.FAILURE)
	{
		UtilityClass.captureSS(driver, TCID);
	}
	else
	{
		logout.ClicLogOutBtn();
	}
	
}
	@AfterClass
public void closeBrowser() throws InterruptedException 
{
		Thread.sleep(3000);
		driver.quit();
		
	
}
}
