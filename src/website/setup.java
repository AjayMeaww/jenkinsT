package website;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.Logs;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class setup {
	WebDriver driver;
	String pageURL = "meaww.com";    //devarticle.meaww.com    //meaww.com
//	String pageURL = "staging.meaww.com";
//	String pageURL = "devarticle.meaww.com";
//	String pageURL = "devdaiquiri.meaww.com";
//	String pageURL = "ads.meaww.com";
	
	//category
	int articlecat;
	int subarticlecat;
	WebElement footerlogo;
	String nextposthref;
	String inauthorURL;   //author
	WebElement twitterwidget;
	int teindex;
	String tetxt;
	String catwidhf;
	
	String testmethod;
	
  @BeforeMethod
  public void beforeMethod() {
  }

  @AfterMethod
  public void afterMethod() {
  }

  @BeforeClass
  public void beforeClass() {
	  String os = System.getProperty("os.name").toLowerCase();
      if (os.contains("mac")) {
          System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/chromedriver");
      }else {
    	  System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
      } 
      ChromeOptions ops = new ChromeOptions();
      ops.addArguments("--incognito", "--start-maximized");  
      //ops.addArguments("--incognito", "--start-maximized", "headless");  
      driver = new ChromeDriver(ops);  
      //JavascriptExecutor js = (JavascriptExecutor) driver;  // used for zoom in/out
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  System.out.println("");
	  System.out.println("CONSOLE LOG PAGE: "+ driver.getCurrentUrl());
	  System.out.println("");
	  System.out.println("////////////////////////// CONSOLE LOG  CONSOLE LOG  CONSOLE LOG  CONSOLE LOG  CONSOLE LOG /////////////////////////////////////////");
	  consoleLog();
	  System.out.println("////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
//	  driver.quit();
  }

  @BeforeTest
  public void beforeTest() {
  }

  @AfterTest
  public void afterTest() {
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Start Time: " + Calendar.getInstance().getTime());
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("End Time: " + Calendar.getInstance().getTime());
  }
	 
  public void consoleLog() throws InterruptedException {
/*      LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
      for (LogEntry entry : logEntries) {
          System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
      }*/
	    Options manage = driver.manage();
	    Logs logs = manage.logs();
	    Set<String> availableLogTypes = logs.getAvailableLogTypes();
	    //System.out.println(availableLogTypes);
	    availableLogTypes.stream().forEach(logType -> {
	        //System.out.println("logType=" + logType);
	        LogEntries logEntries = logs.get(logType);
	        List<LogEntry> all = logEntries.getAll(); 
	        all.forEach(entry -> {
	        	/*System.out.println(entry.getLevel());
	            System.out.println(entry.getMessage());
	            System.out.println(entry.getTimestamp());
	            System.out.println(entry.toMap());
	            System.out.println(entry);*/
	        	//System.out.println(entry.getLevel()+"   |   "+entry.getMessage()+"   |   "+ driver.getCurrentUrl());
	        });
	        //List<LogEntry> filter = logEntries.filter(Level.SEVERE);
	        List<LogEntry> filter = logEntries.filter(Level.ALL);
	        //filter.forEach(System.out::println);    
	        filter.forEach(entry -> {
	        	//System.out.println(entry.getLevel()+"   |   "+entry.getMessage()+"   |   "+ driver.getCurrentUrl());
	        	if (entry.getMessage().contains("meaww.com")) {
		        	System.out.println(entry.getLevel()+"   |   "+entry.getMessage()+"   |   "+ driver.getCurrentUrl());	
	        	}  
	        });
	    });  
  }
//-------------------------------------------
}
