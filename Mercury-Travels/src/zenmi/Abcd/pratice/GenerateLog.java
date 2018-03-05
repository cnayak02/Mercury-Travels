package zenmi.Abcd.pratice;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class GenerateLog {
	public static Logger log = Logger.getLogger("GenerateLog");
	
	@BeforeSuite
	public void InitilizeLogs()
	{

		BasicConfigurator.configure();
		DOMConfigurator.configure("Log4j.xml");
	
	}
	
	@Test
	public void StartLogs() {
		
		log.info("Message1"); 
		log.info("Message2"); 
		log.info("Message3"); 
		log.info("Message4"); 
		log.info("Message5"); 
		log.info("Message6"); 
		log.info("Message7"); 
		log.info("Message8"); 
	}

}
