package TestScripts;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.generic.ExcelUtility;
import com.generic.FileUtility;
import com.generic.JavaUtilities;
import com.generic.WebdriverUtilities;

public class CreateOrgAndValidate {
	static WebDriver driver;
	JavaUtilities j=new JavaUtilities();
	FileUtility fu=new FileUtility();
	ExcelUtility e=new ExcelUtility();
	WebdriverUtilities wd=new WebdriverUtilities();

    @Test
	public void Orgnization() throws InterruptedException, IOException {
	int randomnum = j.getrandomnum(1000);
	String readdatafromExcel = e.readdatafromExcel("EXCELTESTDATASHEET", 1, 3);
	String orgname=readdatafromExcel+randomnum;
	
	String URL = fu.readdatafrompropertiesfile("url");
	 String UN = fu.readdatafrompropertiesfile("username");
	 String PWD = fu.readdatafrompropertiesfile("password");
	 
	 String phonenum = e.readdatafromExcel("EXCELTESTDATASHEET", 2, 3);
	 String industry = e.readdatafromExcel("EXCELTESTDATASHEET", 3, 3);
	 String rating = e.readdatafromExcel("EXCELTESTDATASHEET", 4, 3);
	 String type = e.readdatafromExcel("EXCELTESTDATASHEET", 5, 3);
	 String Indropdown = e.readdatafromExcel("EXCELTESTDATASHEET", 6, 3);
	 
	 

      driver=new ChromeDriver();
      wd.implicitwait(driver);
     driver.get(URL);
     wd.maximizebrowser(driver);
     
     driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
     driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
     driver.findElement(By.xpath("//input[@id='submitButton']")).click();
     
     
     String modulelink="Organizations";
     driver.findElement(By.xpath("//td[@align='center']/a[text()='"+modulelink+"']")).click();
     
     String createNew="Create Organization...";
     driver.findElement(By.xpath("//a/img[@title='"+createNew+"']")).click();
     
     driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
     driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phonenum);
     
     WebElement industry1= driver.findElement(By.xpath("//select[@name='industry']"));
     wd.selectbyvalue(driver, industry1, industry);
     
     WebElement Rating = driver.findElement(By.xpath("//select[@name='rating']"));
     wd.selectbyvalue(driver, Rating, rating);
     
     WebElement accounttype = driver.findElement(By.xpath("//select[@name='accounttype']"));
    wd.selectbyvalue(driver, accounttype, type);
     
     JavascriptExecutor jse=(JavascriptExecutor)driver;
     jse.executeScript("window.scrollBy(0,4000)");
     
     Thread.sleep(2000);

     String normalbtn="S";
     String xpath="(//input[@accesskey='"+normalbtn+"'])[last()]";
     
     driver.findElement(By.xpath(xpath)).click();
     
     Thread.sleep(2000);
     
     driver.findElement(By.xpath("//td[@align='center']/a[text()='"+modulelink+"']")).click();
     
     
     driver.findElement(By.xpath("//input[@class='txtBox']")).sendKeys(orgname);
     WebElement InDD = driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select[@id='bas_searchfield']"));
     wd.selectbyvalue(driver, InDD, Indropdown);
     
     driver.findElement(By.xpath("//input[@name='submit']")).click();
     Thread.sleep(3000);
     String actualorgname = driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[*]/td[3]/a[@title='Organizations']")).getText();
     System.out.println(actualorgname);
     System.out.println(orgname);
     
      Assert.assertEquals(orgname, actualorgname);
      
      driver.quit();
	}


}
