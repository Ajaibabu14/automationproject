package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * This class contains elements locators and respective business libraries of testing page
 * @author ajaib
 *
 */
public class Testingpage {
	
	
	//Declaration
	 
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageheader;
	
	@FindBy(id="Python")
	private WebElement pythonimage;
	
	@FindBy(id="cartArea")
	private WebElement cartarea;
	
	@FindBy(xpath="//ul[@class=\"list-socialicons\"]/descendant::i[@class=\"fa fa-facebook\"]")
	private WebElement facebook;
	
	//initialization
	
	public  Testingpage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization
	
	/**
	 * This method returns pageheader text
	 * @return
	 */
	public String getpageheader()
	{
		return pageheader.getText();
	}
	/**
	 * This method returns python image
	 * @return
	 */
	
	public WebElement  getpythonimage()
	{
		return pythonimage;
	}
	
	/**
	 * This method returns cart area elements
	 * @return
	 */
	
	public WebElement getcartarea()
	{
		return cartarea;
		
	}
	
	/**
	 * this method returns facebook icon
	 * @return
	 */
	public WebElement getfacebookicon()
	{
		return facebook;
		
	}
	
	/**
	 * This method is used to click on facebook icon
	 */
	
	public void clickonfacebookicon()
	{
		facebook.click();
	}
	
	
	
	
	
	
	

}
