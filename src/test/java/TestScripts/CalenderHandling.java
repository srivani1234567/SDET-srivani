package TestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.generic.ExcelUtility;
import com.generic.FileUtility;
import com.generic.JavaUtilities;
import com.generic.WebdriverUtilities;

public class CalenderHandling {
	JavaUtilities j=new JavaUtilities();
	FileUtility fu=new FileUtility();
	ExcelUtility e=new ExcelUtility();
	WebdriverUtilities wd=new WebdriverUtilities();

	@Test
	public void cHandling() throws IOException {
		String cursysdate = j.getcurrentSystemdate();
		System.out.println(cursysdate);
		String makemytrip=fu.readdatafrompropertiesfile("makemytrip");
		String Source = e.readdatafromExcel("Dataprovider", 3, 0);
		String Dest = e.readdatafromExcel("Dataprovider", 4, 0);
		
		String arr[]=cursysdate.split(" ");
		String var = arr[0];
		String date = arr[2];
		String month = arr[1];
		String year = arr[5];
		
		System.out.println(var+ " "+date+" "+month+" "+year);
  	  
  	  WebDriver driver = new ChromeDriver();
  	
  	     wd.implicitwait(driver);
  	     wd.maximizebrowser(driver);
    	driver.get(makemytrip);
    	 
  	  //to handle pop
    	wd.movebyoffset(driver, 10, 10);
  	 /* Actions a = new Actions(driver);
  	  a.moveByOffset(10,10).click().perform(); */
  	  
  	  driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(Source);
  	  driver.findElement(By.xpath("//div[contains(text(),'BOM')]")).click();
  	  
  	  driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(Dest);
  	  driver.findElement(By.xpath("//div[contains(text(),'PNQ')]")).click();
  	  
  	  
  	  WebElement e = driver.findElement(By.xpath("//span[text()='DEPARTURE']"));
  	  wd.elementclickble(driver, e);
  	  e.click();
  	  
  	  String currentdate = var+" "+month+" "+date+" "+year;
  	  
  	  driver.findElement(By.xpath("//div[@aria-label='"+currentdate+"']")).click();
  	  driver.close();

	}

}
