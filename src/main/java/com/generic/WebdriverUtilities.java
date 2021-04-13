package com.generic;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtilities {
	
	/*Author srivani
	 * Maximize the browser
	 */
	public void maximizebrowser(WebDriver driver) {
		
		driver.manage().window().maximize();
	}
	
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	/*Author srivani
	 * wait till page to be load
	 */
	public void implicitwait(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(IConstance.implicitwait, TimeUnit.SECONDS);
	}
	/*@Author srivani
	 * wait till condtion to be satisfied
	 * @param element
	 */
	
	public void elementclickble(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,IConstance.explicitwait);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/*@Author srivani

	 * wait till element to be visible
	 * @param elemnet
	 * @param driver
	 */

	public void elementvisible(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,IConstance.explicitwait);
		wait.until(ExpectedConditions.visibilityOf(element));

		}
	/*
	 * @Author srivani
	 * select element by visble text
	 * @param  driver
	 * @param element
	 * @param visibletext
	 */
	
	public void selectbyvisibletext(WebDriver driver,WebElement element,String visibletext) {
		Select select=new Select(element);
		select.selectByVisibleText(visibletext);
	}
	
	
	/*
	 *  @Author srivani
	 * select class by index
	 * @param  driver
	 * @param element
	 * @param index

	 */
	public void selectbyindex(WebDriver driver,WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	/*
	 *  @Author srivani
	 * select element by value
	 * @param  driver
	 * @param element
	 * @param value

	 * 
	 */
	public void selectbyvalue(WebDriver driver,WebElement element,String rating) {
		Select select=new Select(element);
		select.selectByValue(rating);
	}
	
	/*
	 * @Author srivani
	 * switch to frame by index
	 * @param  driver
	 * @param index 
	 */
	public void switchtoframebyindex(WebDriver driver,int index) {
		driver.switchTo().frame(index);
	}

	/*	@Author srivani
	 * switch to frame by element
	 * @param  driver
	 * @param element

	 * 
	 */
	public void switchtoframebyelement(WebDriver driver,WebElement element) {
		driver.switchTo().frame(element);
	}

	/*@Author srivani
	 * switch to frame by name
	 * @param  driver
	 * @param name

	 * 
	 */
			
	public void switchtoframebyname(WebDriver driver,String name) {
		driver.switchTo().frame(name);
	}

	/*@Author srivani
	 * switch to mainframe
	 * @param  driver
	 */
	public void switchtodefalutframe(WebDriver driver) {
		driver.switchTo().defaultContent();
	}
	
	/*@Author srivani
	 * switch to parentframe
	 * @param  driver
	 */

	public void switchtoparentframe(WebDriver driver) {
		driver.switchTo().parentFrame();
	}

	
	/*@Author srivani
	 * move to element
	 * @param  driver
	 * @param Destionation
	 */
	public void movetoelement(WebDriver driver,WebElement Destionation) {
		Actions act=new Actions(driver);
		act.moveToElement(Destionation).perform();
		
	}
	/*@Author srivani
	 * element to be drag and drop in destination
	 * @param  driver
	 * @param Des
	 * @param Src
	 */

	
	public void DragandDrop(WebDriver driver,WebElement Src, WebElement Des) {
		Actions act=new Actions(driver);
		act.dragAndDrop(Src, Des).perform();
		
	}

  
	/*@Author srivani
	 * element to be drag and drop by X and Y coordinates
	 * @param  driver
	 * @param dropable
	 * @param Src
	 * pointer interface method need to be use 
	 */

	public void DragandDropBy(WebDriver driver,WebElement Src, WebElement dropable) {
		Point p = dropable.getLocation();
		Actions act=new Actions(driver);
		act.dragAndDropBy(Src, p.getX(), p.getY()).perform();
		
	}
	/*@Author srivani
	 * click on Src and relese on destination
	 * @param  driver
	 * @param dse
	 * @param Src
	 */

	
	public void clickandrelese(WebDriver driver,WebElement Src, WebElement Des) {
		Actions act=new Actions(driver);
		act.clickAndHold(Src).release(Des).build().perform();
		
	}
	
	/*@Author srivani
	 * click on pointed place
	 * @param  driver
	 * @param hight
	 * @param width
	 */

	
	public void movebyoffset(WebDriver driver, int hight, int width) {
		Actions act=new Actions(driver);
       act.moveByOffset(hight, width).click().perform();
	}

	/*@Author srivani
	 * mouse rightclick action
	 * @param  driver
	 * @param element
	 */

	
	public void Rightclick(WebDriver driver,WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
		
	}
	
	
	/*@Author srivani
	 * click on accept button in alertpopup
	 * @param  driver
	 */

	
	public void acceptbyalert(WebDriver driver) {
      Alert alt = driver.switchTo()	.alert();
      alt.accept();
	}
	/*@Author srivani
	 * click on cancel button in alertpopup
	 * @param  driver
	 */

	
	public void dismissbyalert(WebDriver driver) {
	      Alert alt = driver.switchTo()	.alert();
	      alt.dismiss();
		}
	/*@Author srivani
	 * write data in alertpopup
	 * @param  driver
	 * @parm data 
	 */

	public void writedatainpopup(WebDriver driver,String data) {
	      Alert alt = driver.switchTo()	.alert();
	      alt.sendKeys(data);
		}
	/*@Author srivani
	 * fetch the data from alertpopup
	 * @param  driver
	 * @return text
	 */

	
	public String fetechdatainalert(WebDriver driver) {
	      Alert alt = driver.switchTo()	.alert();
	      String text = alt.getText();
	      return text;
		}

	/*@Author srivani
	 * switch to chaildwindow
	 * @param  driver
	 */
	String mainid;
	String id;
	public void switchtochaildwindow(WebDriver driver) {
		mainid = driver.getWindowHandle();
		Set<String> allids = driver.getWindowHandles();
		for(String id:allids) {
			    
			if(!mainid.equals(id)){
				driver.switchTo().window(id);
			}
		}
		
	}
	
	public void switchtomainwindow(WebDriver driver) {

		driver.switchTo().window(mainid);

		
	}

	/**
	 * Wait for element until it is displayed
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitforElement(WebElement element) throws InterruptedException 
	{
		int count=0;
		while(count<40) 
			try{

				element.isDisplayed();
				break;
			}
		catch(Exception e)
		{
			Thread.sleep(500);
			count++;
		}
	}
	/**
	 * Wait for element and once availabel click on it.
	 * @param driver
	 * @param xpath
	 * @throws InterruptedException
	 */
	public void waitandclick(WebDriver driver,String xpath) throws InterruptedException 
	{
		int count=0;
		while(count<40) 
			try{
				driver.findElement(By.xpath(xpath)).click();
				break;
			}
		catch(Exception e)
		{
			Thread.sleep(500);
			count++;
		}
	}

	


	
	


}
