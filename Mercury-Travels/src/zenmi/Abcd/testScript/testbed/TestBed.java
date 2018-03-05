package zenmi.Abcd.testScript.testbed;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import zenmi.Abcd.executer.DriveXL;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBed {

	String URL;
	public static Logger log= Logger.getLogger("TestBed");
	boolean isinitialize=false;
	static Properties config;
	public WebDriver driver;
	public enum browserName
	{
		firefox,
		ie,
		chrome
	}
	
	@BeforeSuite
	public void BeforeSuite() throws Exception{
		if (!isinitialize) {
			BasicConfigurator.configure();
			DOMConfigurator.configure("Log4j.xml");
			log.info("log is initilized");
			isinitialize=true;
             config = new Properties();
			String path = "./src/zenmi/Abcd/config/config.properties";
			File file = new File(path);
			config.load(new FileInputStream(file));
		}
	
		}
	
		@BeforeClass
		public void BeforeClass(){
		switch (browserName.valueOf(config.getProperty("browser"))) 
			{
			case firefox:
				System.out.println("Opening firefox");
				System.setProperty("webdriver.firefox.marionette", "./driver/chromedriver.exe");
				driver = new FirefoxDriver();
				URL=config.getProperty("url");
				
				
				break;
			case ie:
				System.out.println("Opening ie");
				System.setProperty("webdriver.ie.driver","./drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				URL=config.getProperty("url");
				break;
			case chrome:
				System.out.println("Opening Chrome");
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				driver = new ChromeDriver();
				 URL=config.getProperty("url");
				
				break;

			default:
				break;
				
				
		
			}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(URL);
		}
	
		@AfterClass
		
		public void AfterClass(){
		//driver.close();
}
		} 
		



