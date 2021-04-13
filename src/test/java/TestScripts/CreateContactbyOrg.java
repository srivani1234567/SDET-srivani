package TestScripts;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.generic.ExcelUtility;
import com.generic.FileUtility;
import com.generic.JavaUtilities;
import com.generic.WebdriverUtilities;

public class CreateContactbyOrg {
	FileUtility fu=new FileUtility();
	ExcelUtility e=new ExcelUtility();
	WebdriverUtilities wd=new WebdriverUtilities();

	@Test
	public void CCByOrganization() throws IOException, InterruptedException {
		String URL = fu.readdatafrompropertiesfile("url");
		 String UN = fu.readdatafrompropertiesfile("username");
		 String PWD = fu.readdatafrompropertiesfile("password");
		 
		 String beforename = e.readdatafromExcel("EXCELTESTDATASHEET",7 , 3);
		 String name = e.readdatafromExcel("EXCELTESTDATASHEET", 8, 3);
		 String lastname = e.readdatafromExcel("EXCELTESTDATASHEET", 9, 3);
		 String Organizationname = e.readdatafromExcel("EXCELTESTDATASHEET", 10, 3);
		 String phnum = e.readdatafromExcel("EXCELTESTDATASHEET", 11, 3);

	     WebDriver driver=new ChromeDriver();
	     wd.implicitwait(driver);
	     driver.get(URL);
	     wd.maximizebrowser(driver);
	     
	     driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(UN);
	     driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PWD);
	     driver.findElement(By.xpath("//input[@id='submitButton']")).click();
	     
	     
	     String modulelink="Contacts";
	     driver.findElement(By.xpath("//td[@align='center']/a[text()='"+modulelink+"']")).click();
	     
	     String createNew="Create Contact...";
	     driver.findElement(By.xpath("//a/img[@title='"+createNew+"']")).click();
	     
	     WebElement wb1 = driver.findElement(By.xpath("//select[@name='salutationtype']"));
	     wd.selectbyvalue(driver, wb1, beforename);
	     driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(name);
	     driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
        
	     driver.findElement(By.xpath("//input[@name='account_id']/following-sibling::img[@title='Select']")).click();
	     
	     wd.switchtochaildwindow(driver);
		 driver.findElement(By.xpath("//input[@id='search_txt']")).sendKeys(Organizationname);
		 driver.findElement(By.xpath("//input[@name='search']")).click();
		 driver.findElement(By.xpath("//a[text()='TATA motors']")).click();
		 wd.switchtomainwindow(driver);

	     driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phnum);
	     JavascriptExecutor jse=(JavascriptExecutor)driver;
	     jse.executeScript("window.scrollBy(0,4000)");

	     String normalbtn="S";
	     
	     driver.findElement(By.xpath("(//input[@accesskey='"+normalbtn+"'])[last()]")).click();
	     
	     driver.quit();



		
	}

}
