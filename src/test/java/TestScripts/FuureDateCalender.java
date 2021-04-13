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
import com.generic.WebdriverUtilities;

public class FuureDateCalender {
	
	FileUtility fu=new FileUtility();
	ExcelUtility e=new ExcelUtility();
	WebdriverUtilities wd=new WebdriverUtilities();


	@Test
	public void FuturedateCal() throws InterruptedException, IOException {
		String makemytrip=fu.readdatafrompropertiesfile("makemytrip");
		String Source = e.readdatafromExcel("Dataprovider", 3, 0);
		String Dest = e.readdatafromExcel("Dataprovider", 4, 0);

  	    WebDriver driver = new ChromeDriver();
  	    wd.implicitwait(driver);
  	    wd.maximizebrowser(driver);
    	driver.get(makemytrip);
    	 
  	  //to handle pop
    	wd.movebyoffset(driver, 10, 10);

  	  
  	  driver.findElement(By.xpath("//input[@id='fromCity']")).sendKeys(Source);
  	  driver.findElement(By.xpath("//div[contains(text(),'BOM')]")).click();
  	  
  	  driver.findElement(By.xpath("//input[@id='toCity']")).sendKeys(Dest);
  	  driver.findElement(By.xpath("//div[contains(text(),'PNQ')]")).click();
  	  
  	  
  	  WebElement e = driver.findElement(By.xpath("//span[text()='DEPARTURE']"));
  	  wd.elementclickble(driver, e);
  	  e.click();
      
  	  int count=0;
  	  
  	  while(count<11) 
  	  {
  		   try
  		   {
  			   driver.findElement(By.xpath("//div[@aria-label='Mon Oct 17 2021']")).click();
  			   break;
  		   }
  		   catch(Exception e1) {
  			 
  			   driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
  			 Thread.sleep(1000);
  			   count++;
  		   }
  		 
  	  }
  	  System.out.println(count);

     driver.quit();
	}

}
