package Module1_LoginTest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.XLUtility;
public class DataDrivenTest extends BaseClass
{
//WebDriver driver;
	
	@BeforeClass
	public void setup() throws IOException
	{
		
		initializeBrowser();
	}
	
	@Test(dataProvider="LoginData")
	public void loginTest(String user,String pwd,String exp) throws InterruptedException
	{
		//driver.get("https://myaccount.policybazaar.com/");
		
		WebElement txtEmail=driver.findElement(By.xpath("//input[@id='mobileNo']"));
		txtEmail.clear();
		txtEmail.sendKeys(user);
		
		driver.findElement(By.xpath("//button[text()='Sign in with Password']")).click();
		
		WebElement txtPassword=driver.findElement(By.xpath("//input[@name='password']"));
		txtPassword.click();
		txtPassword.sendKeys(pwd);
		
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click(); //Login  button
		Thread.sleep(3000);
		//System.out.println(driver.getTitle());
		String exp_title="My Account | Policybazaar";
		String act_title=driver.getTitle();
		
		if(exp.equals("Valid"))
		{
			if(exp_title.equals(act_title))
			{
				//System.out.println(driver.getTitle());
				driver.findElement(By.xpath("//div[@title='Logout']")).click();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		else if(exp.equals("Invalid"))
		{
			if(exp_title.equals(act_title))
			{
				
				driver.findElement(By.xpath("//div[@title='Logout']")).click();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		
	}
	
	@DataProvider(name="LoginData")
	public String [][] getData() throws IOException
	{
		/*String loginData[][]= {
								{"9637515958","Choure@123","Valid"},
								{"9112997072","Choure@123","Invalid"},
								{"9112997072","admin","Invalid"},
								{"9850080854","adm","Invalid"}
							}; */
							
		
		//get the data from excel
		String path=".\\datafiles\\loginData.xlsx";
		XLUtility xlutil=new XLUtility(path);
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",1);	
				
		String loginData[][]=new String[totalrows][totalcols];
			
		
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
			}
				
		} 
		
		return loginData;
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
	
	
	
	

}
