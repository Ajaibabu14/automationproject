package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class skillrarydemoapppage {
	
	@FindBy(xpath="//a[@class=\"navbar-brand\"]")
	private WebElement pageheader;
	
	@FindBy(id="course")
	private WebElement coursetab;
	
	
	@FindBy(xpath="//span/a[text()='Selenium Training']")
	private WebElement seleniumtraininglink;
	
	@FindBy(name="addresstype")
	private WebElement categoryDD;
	
	@FindBy(xpath="//a[text()='Contact Us']")
	private WebElement contactuslink;
	
	//initialization
	public skillrarydemoapppage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}
	//utiilization
	
	public String getPageHeader()
	{
		
		return pageheader.getText();
		
	}
	
	public void mouseMovestocourse(WebDriverUtility web)
	
	{
	     web.moveto(coursetab);	
       
	}
	public void clickseleniumtraining()
	{
		seleniumtraininglink.click();
		
		
	}
	public void selectcategory(WebDriverUtility web,int index)
	{
		web.dropdown(categoryDD, index);
		
	}
	
	public void getcontactlink()
	{
		contactuslink.click();
	}
	
	
	
	
	
	

}
