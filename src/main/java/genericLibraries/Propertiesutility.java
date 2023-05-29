package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
/**
 * This class contains all reusable methods to perform operations on properties file
 * @author ajaib
 *
 */
public class Propertiesutility {
	
    private Properties property;
    /**
     * This method is used to initialize properties file
     * @param filepath
     */
	public void propertiesinitialization(String filepath)
	{
	
		FileInputStream fis=null;
		try {
		fis=new FileInputStream(filepath);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		       property=new Properties();
		try {
			property.load(fis);
			
			
		} catch (IOException e) {
			e.printStackTrace();

	}
	
	}
	/**
	 * This method is used to fetch data from the properties file using key 
	 * @param key
	 * @return
	 */
	public String readdatafromproperties(String key) {
		
		return property.getProperty(key);
			
	}
	/**
	 * This method is used to store data to property file
	 * @param key
	 * @param value
	 * @param filepath
	 * @param comments
	 */
	public void writeToProperties(String key,String value,String filepath,String comments) {
	property.put(key,value);
	FileOutputStream fos=null;
	try {
		fos=new FileOutputStream(filepath);
		
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
		try {
			
		property.store(fos,comments);
		
		}catch(IOException r)   {
			
			r.printStackTrace();
		}
		
	
		
	}
	}
	

