package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SkillraryHomepage {
	
	private static final WebElement languageIcon = null;


	//declaration
	
	 @FindBy(xpath="//img[@alt='SkillRary']")
	 private WebElement logo;
	 
	 
	 @FindBy(xpath="//ul[contains(@class, 'home_menu')]/li[1]")
	 private WebElement language;
	 
	 @FindBy(xpath="//ul[@class=\"dropdown-menu\"]/descendant::a[text()=' English']")
	 private WebElement english;
	 
	 @FindBy(xpath="//a[text()=' GEARS ']")
	 private WebElement geartab;
	 
	 @FindBy(xpath="//ul[@class='dropdown-menu gear_menu']/descendant::a[text()=' SkillRary Demo APP']")
	 private WebElement skillrarydemoapplink;

	 
	 //initialization
	 public SkillraryHomepage (WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
		 
	 }
	 //utilization
	 public WebElement getlogo()
	 {
       return logo;
	 }
	 
	 public void chooseEnglish()
	 {
		languageIcon.click();
		english.click();
	 }
	 public void clickgearstab()
	 {
		 geartab.click();
	 }
	 public void clickskillrarydemoapp()
	 {
		 skillrarydemoapplink.click();
		 
	 }
	 
	 
}