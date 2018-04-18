package website;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class openpage extends setup{ 
  @Test
  public void categoryT() throws InterruptedException {
	  driver.get("https://"+pageURL);
	  driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

	  Assert.assertEquals(driver.getTitle(), "Media, Entertainment, Arts, WorldWide | Meaww", "PAGE TITLE IS INCORRECT !!!");
	  
 	  System.out.println("/////////////////////////////////////////// ECLIPSE JENKINS PASS /////////////////////////////////////////////////////////////"); 
  }
}