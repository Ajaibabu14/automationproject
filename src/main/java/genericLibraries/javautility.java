package genericLibraries;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * This class contains reusable methods of java
 * @author ajaib
 *
 */
public class javautility {
	/**
	 * This method generates random numberwithin the limit
	 * @param limit
	 * @return
	 */
	public int generateRandomNumber() {
		Random random=new Random();
		return random.nextInt();
		
	}
	/**
	 * This method gets system time in specified format
	 * @return
	 */
	public String getCurrentTime() {
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("dd-_MM-yy_hh_mm_ss");
		return sdf.format(date);
	}

}
