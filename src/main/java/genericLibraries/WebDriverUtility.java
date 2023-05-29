package genericLibraries;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {
	private WebDriver driver;
	/**
	 * This method is used to launch browser
	 * @param browser
	 * @return 
	 */
	public WebDriver launchbrowser(String browser)
      

	   {
		switch(browser) {
		
		
		case ("chrome"):
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	     break;
		
		case ("firefox"):
			WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
			break;
			
		case ("edge"):
			WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
			break;
			
			default:
				System.out.println("invalid browse data");
		}
		return driver;
	   }
	
	/**
	 * This method is used to maximize the browser
	 */
	public  void MaximizeBrowser()
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to navigate to an application via url
	 * @param url
	 */
	public void Navigatetoapp(String url)
	{
		driver.get(url);
	}
	/**
	 * This method waits untill element, elements found
	 * @param time
	 */
	public void waituntillelementfound(long time)
	{
		driver.manage().timeouts().implicitlyWait(time,TimeUnit.SECONDS);			
			
	}
	/**
	 * This method is used to wait until the  element is displayed
	 * 	 @param time
	 * @param element
	 * @return
	 */

	public WebElement explicitwait(long time,WebElement element)
	{
	
		WebDriverWait wait=new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 * This method is used to wait until the element is enabled
	 * @param element
	 * @param time
	 * @return
	 */
	public WebElement explicitwait(WebElement element,long time)
	{
	
		WebDriverWait wait=new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.elementToBeClickable(element));

}
	/**
	 * This method is used to wait until webpage title is displayed
	 * @param time
	 * @param title
	 * @return
	 */
	public boolean explicitwait(long time,String title)
	{
	
		WebDriverWait wait=new WebDriverWait(driver, time);
		return wait.until(ExpectedConditions.titleContains(title));
	}
	
	/**
	 * This method is used to mouse over to the element
	 * @param element
	 */
	
	public void moveto(WebElement element) {
		
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	
	/***
	 * This method is used to double click on the element
	 * @param element
	 */
	public void doubleclickonelement(WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();				
    }
	
	/**
	 * This method is used to right click on the element
	 * @param element
	 */
	public void rightclick(WebElement element)
	{

		Actions act=new Actions(driver);
		act.contextClick(element).perform();	
	}
	
	/**
	 * This method is used to drag and drop an element to target
	 * @param element
	 * @param target
	 */
	public void draganddropelement(WebElement element, WebElement target) {
		Actions act=new Actions(driver);
		act.dragAndDrop(element, target).perform();	
		
		
	}
	/**
	 * This method is used to select an element from drop down using index
	 * @param element
	 * @param index
	 */
	
	public void dropdown(WebElement element, int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * This method is used to select an element from drop down using value
	 * @param value
	 * @param element
	 */
	
	public void dropdown(String value, WebElement element)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	
	/**
	 * This method is used to select  an element from drop down using visible text
	 * @param element
	 * @param text
	 */
	public void dropdown(WebElement element, String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	/**
	 * This method is used to scroll till element
	 * @param element
	 */
	public void scrolltillelement(Object element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)",element);
	}
	
	/**
	 * This method is used to switch to frame using index
	 * @param index
	 */
	
	public void switchtoframe(int index)
	{
		driver.switchTo().frame(index);
		
	}
	
	/**
	 * This method is used to switch to frame using Id or Name attribute value
	 * @param IdOrName
	 */
	public void switchtoframe(String IdOrName)
	{
		driver.switchTo().frame(IdOrName);
	}
	
	/**
	 * This method is used to switch to frame using frame element
	 * @param frameelement
	 */
	public void switchtoframe(WebElement frameelement)
	{
		driver.switchTo().frame(frameelement);
	}
	
	/**
	 * This method is used to switch back form the frame
	 */
	public void switchbackfromframe()
	
	{
		driver.switchTo().defaultContent();
	}
	
	/**
	 * This method is used to take screenshot of window
	 * @param jutil
	 */
	
    public void takescreenshot(javautility jutil)
    {
       TakesScreenshot ts=(TakesScreenshot)driver;    
       File src = ts.getScreenshotAs(OutputType.FILE);
      File dest=new File("./Screenshot/ss_"+jutil.getCurrentTime()+".png");
      try {
    	  FileUtils.copyFile(src, dest);
		
	} catch (IOException e) {
	e.printStackTrace();
	}
    }
    
    /**
     * this method is used to handle alert
     * @param Status
     */
    public void handleAlert(String Status)
    {
    	Alert a1=driver.switchTo().alert();
    	if(Status.equalsIgnoreCase("ok"))
    	
    		a1.accept();
    	else
    		a1.dismiss();
    }
    
    /**
     * This method is used to switch to chgild browser
     */
    public void switchtochildbrowser()
    {
     Set<String> set = driver.getWindowHandles();
     for(String id : set)
     {
    	 driver.switchTo().window(id);
     }
     
    }
    /**
     * this method is used to close the current window
     */
    public void closecurrentwindow()
    {
    	driver.close();
    }
    /**
     * this method is used to close all windows
     */
    public void quitAllwindows()
    {
    	driver.quit();
    }

	
    	 
     }
      
     

