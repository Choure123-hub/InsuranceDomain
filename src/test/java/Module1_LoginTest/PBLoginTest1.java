package Module1_LoginTest;

import java.io.IOException;



import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
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
import Module1_Login.PBMyAccPage;
import Module1_Login.PBPoliciesPage;

public class PBLoginTest1 extends BaseClass
{
	
	PBLoginWithMobNumPage login;
	PBLoginWithPwdPage Pwd;
	PBMyAccPage Myacc;
	 PBLogOutFromAppPage logout;
	 PBPoliciesPage policiesIcon ;
	 PBHomePage home;
	
	
	int TCID;
	
	@BeforeClass
public void OpenBrowser() throws EncryptedDocumentException, IOException 
{
		
		
	    initializeBrowser();
		login=new PBLoginWithMobNumPage(driver);
		 Pwd=new PBLoginWithPwdPage(driver);
		 Myacc=new PBMyAccPage(driver);
		 logout =new PBLogOutFromAppPage(driver);  
		  policiesIcon = new PBPoliciesPage(driver);
		home= new PBHomePage(driver);
	
}
	@BeforeMethod
public void loginToApp() throws EncryptedDocumentException, IOException 
{
		login.inpPBLoginWithMobNumPageMobNum(UtilityClass.readDataFromPF("mobNum"));
		login.ClickPBLoginWithMobNumPageloginWithPwd();
		Pwd.inpPBLoginWithPwdPagePwd(UtilityClass.readDataFromPF("pwd"));
		Pwd.ClickPBLoginWithPwdPageloginWithPwd();
		
}
	@Test()
public void verifyProfileName() throws EncryptedDocumentException, IOException 
{
		TCID=102;
		 Myacc.ClickPBMyAccPageProfile();
		// Myacc.verifyPNPBMyAccPageProfileName(sh.getRow(0).getCell(2).getStringCellValue());
		String actPN = Myacc.getPNPBMyAccPageProfileName();
		String expPN=UtilityClass.getTD(0, 2);
		Assert.assertEquals(actPN, expPN,"Failed both result are diff:  ");

}
	@Test()
	public void verifySetOfdata() {
		TCID=103;
		
	}
	@Test()
	public void verifypoliciesName() throws InterruptedException 
	{      policiesIcon.clickOnPolicies();
      policiesIcon.Policiesgettitle(); 
      Thread.sleep(3000);
      policiesIcon.clickOnSlider();
     
	}
	@Test()
	public void ClickMenuBtn() throws InterruptedException 
	{
		home.clickOnMenuBtnFromPB();
		home.SwitchToChildWindow();
		home.clickOnLifeinsurance();
		
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
