package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericLibraries.WebDriverUtility;

public class Seleniumtrainingpage {
/**
 * This class contains elements locators and respective business libraries of selenium training page
 */
	
	@FindBy(xpath="//h1[@class='page-header']")
	private WebElement pageheader;
	
	@FindBy(id="quantity")
	private WebElement quantity;
	
	@FindBy(id="add")
	private WebElement plusbutton;
	
	@FindBy(xpath="//button[.=' Add to Cart']")
	private WebElement addtocartbutton;
	
	@FindBy(xpath="//div[@id='callo"
			+ "ut']/span")
	private WebElement itemaddedmessage;
	
	// Initialization
	 
	
	public Seleniumtrainingpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//utilization
	
	
	
	/**
	 *  This method returns pageheader text
	 * @return
	 */
	public String getpageheader()
	{
		return pageheader.getText();
	}
	
	/**
	 * this methiod is used to get the quantity of product
	 * @return
	 */
	public String getquantity()
	{
		return quantity.getAttribute("value");
	}
	
	/**]
	 * This method is used to click the plussbutton
	 * @param web
	 */
	public void doubleclickplusbutto(WebDriverUtility web)
	
	{
	  web.doubleclickonelement(plusbutton);
	  
	}
	/**
	 * this method is used to click on addtocartbutton
	 */
	
	public void clickaddtocart()
	{
		addtocartbutton.click();
	}
	
	/**
	 * This method is used to get the conformation message 
	 * @return
	 */
	public String getitemaddedmessage()
	{
		return itemaddedmessage.getText();
	}
	
	
	
}
