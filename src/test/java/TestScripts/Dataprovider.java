package TestScripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.generic.ExcelUtility;

public class Dataprovider {
	
	ExcelUtility e= new ExcelUtility();
	@Test(dataProvider="getdata")
	public void testcity(String src, String Dse) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//div[contains(@class,'displayBlock ')]")).click();
		
		/*Actions act=new Actions(driver);
		act.moveByOffset(10, 10).click().perform(); */

		
		driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(src);
		driver.findElement(By.xpath("//p[contains(text(),'"+src+"')]")).click(); 
		driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(Dse);
		driver.findElement(By.xpath("//p[contains(text(),'"+Dse+"')]")).click();
		
		driver.findElement(By.xpath("//span[text()='DEPARTURE']")).click();
		driver.findElement(By.xpath("//div[@aria-label='Wed Apr 07 2021']")).click();
		driver.close();

	}
	
/*	@DataProvider
	public Object[][] getdata() throws EncryptedDocumentException, IOException {
		
	int lastrow = e.getrowcount(sheetname)
		Object[][] obj=new Object[lastrow][2];
		for(int i=0; i<lastrow.length; i++) {
			
			
		} 
		return obj;
	} */

}
