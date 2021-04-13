package TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.ExcelUtility;
import com.generic.FileUtility;
import com.generic.WebdriverUtilities;

public class Dataprovider {
	
	FileUtility fu=new FileUtility();
	ExcelUtility e=new ExcelUtility();
	WebdriverUtilities wd=new WebdriverUtilities();

	@Test(dataProvider="getdata")
	public void testcity(String src, String Dse) throws InterruptedException, IOException
	{
		String makemytrip=fu.readdatafrompropertiesfile("makemytrip");

		WebDriver driver=new ChromeDriver();
		driver.get(makemytrip);
		wd.implicitwait(driver);
		wd.maximizebrowser(driver);
		//driver.findElement(By.xpath("//div[contains(@class,'displayBlock')]")).click();
		
		//to handle popup
    	wd.movebyoffset(driver, 10, 10);
        driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(src);
		driver.findElement(By.xpath("//div[contains(text(),'"+src+"')]")).click();
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(Dse);
		 driver.findElement(By.xpath("//div[contains(text(),'"+Dse+"')]")).click();

		
		WebElement departure = driver.findElement(By.xpath("//span[text()='DEPARTURE']"));
		wd.elementclickble(driver, departure);

		driver.findElement(By.xpath("//div[@aria-label='Wed Apr 13 2021']")).click();
		driver.close();

	}
	
	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException
	{
		int rowcount = e.getrowcount("Dataprovider");
		Object[][] obj=new Object[rowcount][2];
		int count=0;
		for(int i=0; i<obj.length;i++) {
			
			for(int j=0;j<obj[i].length;j++) {
				
				String data = e.readdatafromExcel("Dataprovider", i, j);
				obj[count][j]=data;
			}
			count++;
		}
		/* int rowcount = e.getrowcount("Dataprovider");
		Object[][] obj=new Object[rowcount][2];
		for(int i=0; i<obj.length; i++)
		{
			obj[i][0]= e.readdatafromExcel("Dataprovider", i, 0);
			obj[i][1]= e.readdatafromExcel("Dataprovider", i, 1);
			
		} 	*/
		
		return obj;
	} 

}
