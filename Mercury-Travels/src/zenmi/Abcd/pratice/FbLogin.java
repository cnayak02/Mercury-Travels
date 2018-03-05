package zenmi.Abcd.pratice;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import zenmi.Abcd.seleniumCore.ActionDriver;

public class FbLogin {
	public static Logger log = Logger.getLogger("FbLogin ");

	public static void main(String[] args) {
		 BasicConfigurator.configure();
		 DOMConfigurator.configure("Log4j.xml");
		System.setProperty("webdriver.firefox.marionette","D:\\Selenium\\project\\FrameWork\\src\\hybrid\\drivers\\geckodriver.exe");
		log.info("initialize the Browser");
	    WebDriver driver=new FirefoxDriver();
	    log.info("load Url");
	    driver.get("https://www.facebook.com/");
		log.info("create instance of ActionDriver ");
	    ActionDriver actDriver = new ActionDriver(driver);
	    log.info("Now i am in UserName field");
	   actDriver.input("xpath","(//input[@class='inputtext'])[1]","cnayak096@gmail.com");
	    log.info("Now i am in Password  field");
        actDriver.input("xpath","(//input[@class='inputtext'])[2]","9938710433");
	    log.info("Now i am in Login btn");
        actDriver.click("xpath","//input[@type='submit']");
        //actDriver.mousOever("id", "day");

	}

}
