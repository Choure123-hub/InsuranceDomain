package LibraryFiles;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class UtilityClass 
{
	
	
	public static String readDataFromPF(String key) throws IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\Bhagwanta Chaure\\eclipse-workspace\\InsuranceDomain\\PropertyFile.properties");
	
	Properties p=new Properties();
	         p.load(file);
	        String value = p.getProperty(key);
	        return value;
	
	}
	public static void captureSS(WebDriver driver,int TCID) throws IOException 
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("C:\\Users\\Bhagwanta Chaure\\eclipse-workspace\\InsuranceDomain\\FailedTCesSS\\TestCaseID"+TCID+".jpg");
	FileHandler.copy(src, dest);
	}
	
	
	
	
	
	
	
public static String getTD(int rowIndex,int cellIndex) throws EncryptedDocumentException, IOException 
{
	FileInputStream file=new FileInputStream("C:\\Users\\Bhagwanta Chaure\\eclipse-workspace\\InsuranceDomain\\TestData\\30thJully.xlsx");
	 Sheet sh = WorkbookFactory.create(file).getSheet("DDF1");
	String value = sh.getRow(rowIndex).getCell(cellIndex).getStringCellValue();
	 return value;
	
}
}
