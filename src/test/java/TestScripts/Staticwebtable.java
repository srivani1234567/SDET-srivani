package TestScripts;

import java.awt.List;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.generic.ExcelUtility;
import com.generic.FileUtility;
import com.generic.WebdriverUtilities;

public class Staticwebtable {
	FileUtility fu=new FileUtility();
	WebdriverUtilities wd= new WebdriverUtilities();
	ExcelUtility e=new ExcelUtility();
	@Test
	public void Stwebtable() throws IOException {
		String seleniumdevurl = fu.readdatafrompropertiesfile("seleniumdevurl");
		 String type = e.readdatafromExcel("EXCELTESTDATASHEET", 12, 3);
		WebDriver driver = new ChromeDriver();
		driver.get(seleniumdevurl);
		wd.implicitwait(driver);
		wd.maximizebrowser(driver);
		
		
		
       	java.util.List<WebElement> wb = driver.findElements(By.xpath("//table[@class='data-list']//tr/td[1]"));
       	
       	for(WebElement w:wb) {
       	String lang	= w.getText();
       	System.out.println(lang);
       	if(lang.equalsIgnoreCase(type)) 
       	{
       		WebElement lan = driver.findElement(By.xpath("//table[@class='data-list']//tbody//tr[3]//td[2]"));
       		System.out.println(lan);
       	}
       	}

		
	}

	}


