package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * This class contains elements locators and respective business libraries of contact us page 
 * @author ajaib
 *
 */
public class Contactuspage {
	
	@FindBy(xpath="//img[contains(@src,'contactus')]")
	private WebElement contactusimage;
	
	@FindBy(name="name")
	private WebElement nameTF;
  
	
	 @FindBy(name="sender")
	 private WebElement gmailTF;
	 
	 @FindBy(name="subject")
	 private WebElement subjectTF;
	 
	 @FindBy(name="message")
	 private WebElement messageTFD;
	 
	 @FindBy(xpath="//button[@class='btn btn-sm btn-primary']")
	 private WebElement sendusbutton;
	 
	 
	 //INITIALIZATION
	 
	 public Contactuspage(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 //utilization
	 
	 /**
	  * This method returns logo
	  * @return
	  */
	 public WebElement getlogo()
	 {
		 return contactusimage;
	 }
	 /**
	  * This method is used to send the details
	  * @param name
	  * @param gmail
	  * @param message
	  * @param subject
	  */
	 
	 public void sendDetails(CharSequence name, CharSequence gmail, CharSequence message, CharSequence subject)
	 {
		 nameTF.sendKeys(name);
		 gmailTF.sendKeys(gmail);
		 subjectTF.sendKeys(subject);
		 messageTFD.sendKeys(message);
		 sendusbutton.click();
		 
		 
	 }
	 
	}
