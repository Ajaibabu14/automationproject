package executetest;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AddToCartTest extends baseclass
{
 @Test
 
 public void addtocartTest()
 {
	 SoftAssert soft=new SoftAssert();
	 home.clickgearstab();
	 home.clickskillrarydemoapp();
	 web.switchtochildbrowser();
	 soft.assertTrue(demo.getPageHeader().contains("Ecommerce"));
	 
	 demo.mouseMovestocourse(web);
	 demo.clickseleniumtraining();
	 soft.assertEquals(selenium.getpageheader(),"selenium Training");
	 
	 int initialquantity=Integer.parseInt(selenium.getquantity());
	 selenium.doubleclickplusbutto(web);
	 int finalquantity=Integer.parseInt(selenium.getquantity());
	 
	 soft.assertEquals(finalquantity, finalquantity);
	 
	 selenium.clickaddtocart();
	 web.handleAlert("ok");
	 soft.assertEquals(selenium.getitemaddedmessage(), "item added to cart");
	 soft.assertAll();
	 
	 
	 
 }


	

}
