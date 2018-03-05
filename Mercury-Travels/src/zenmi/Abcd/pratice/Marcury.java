package zenmi.Abcd.pratice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import zenmi.Abcd.seleniumCore.ActionDriver;

public class Marcury {
     WebDriver driver;
	public static void main(String[] args) {
		
		System.setProperty("webdriver.firefox.marionette","./drivers/geckodriver.exe");
	    WebDriver driver=new FirefoxDriver();
	    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	    driver.get("http://newtours.demoaut.com/");
	    ActionDriver act= new ActionDriver(driver);
	    act.input("name", "userName", "mercury");
	    act.input("name", "password", "mercury");
	    act.click("name", "login");
	    act.Select("name", "fromPort", "Frankfurt");
	}

}
