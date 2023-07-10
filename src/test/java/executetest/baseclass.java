package executetest;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import genericLibraries.Excelutility;
import genericLibraries.IConstantPath;
import genericLibraries.Propertiesutility;
import genericLibraries.WebDriverUtility;
import genericLibraries.javautility;
import pom.Contactuspage;
import pom.Seleniumtrainingpage;
import pom.SkillraryHomepage;
import pom.Testingpage;
import pom.skillrarydemoapppage;

public class baseclass {
	
	protected  Propertiesutility property;
	protected Excelutility excel;
	protected javautility jutil;
	protected WebDriverUtility  web;
	protected WebDriver driver;
	 
	protected SkillraryHomepage home;
	protected skillrarydemoapppage demo;
	protected Seleniumtrainingpage selenium;
	protected Testingpage testing;
	protected Contactuspage contact;
	
	
	@BeforeClass
	public void classconf() {
		property=new Propertiesutility();
		excel=new Excelutility();
		jutil=new javautility();
		web=new WebDriverUtility();
		
		property.propertiesinitialization(IConstantPath.Properties_path);
		
		excel.excelInit(IConstantPath.Excel_path);
		
		
	}
	
	@BeforeMethod
	public void methodconf() {
		driver=web.launchbrowser(property.readdatafromproperties("browser"));
		web.MaximizeBrowser();
		web.Navigatetoapp(property.readdatafromproperties("url"));
		web.waituntillelementfound(Long.parseLong(property.readdatafromproperties("time")));
		
		
	    home=new SkillraryHomepage(driver);	
	    demo=new skillrarydemoapppage(driver);
	    
	    selenium=new Seleniumtrainingpage(driver);
	    testing=new Testingpage(driver);
	    contact=new Contactuspage(driver);
	}
	@AfterMethod
	public void methodTearDown()
	{
		web.quitAllwindows();
		
	}
	
	
	@AfterClass
	public void classTearDown(){
		excel.closeexcel();
		
		
    
	}

}

