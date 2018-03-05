package zenmi.Abcd.testScript.testcase;

import org.testng.annotations.Test;

import zenmi.Abcd.executer.DriveXL;
import zenmi.Abcd.testScript.testbed.TestBed;

public class SmokeTest extends TestBed  {
	
	@Test (priority=1)
	public void SmokeTestcase1() throws Exception{
		DriveXL dx=new DriveXL(driver);
		dx.ReadxlAction("./src/zenmi/Abcd/testdata/AutomationText.xlsx","Login");
	}
	@Test (priority=2)
	public void SmokeTestcase2() throws Exception{
		DriveXL dx=new DriveXL(driver);
		    
	}/*
	@Test (priority=3)
	public void SmokeTestcase3(){
		System.out.println(" Running SmokeTestcase3");
		 ActionDriver act= new ActionDriver(driver);
		 act.click("xpath", "//*[@name='outFlight'])[3]");
		 act.click("xpath", "//*[@name='inFlight'])[3]");
		 act.click("name", "reserveFlights");
	}
	@Test (priority=4)
	public void SmokeTestcase4(){
		System.out.println(" Running SmokeTestcase4");
		ActionDriver act= new ActionDriver(driver);
		act.input("name", "passFirst0", "virat");
		act.input("name", "passLast0", "Kohli");
		act.Select("name", "pass.0.meal", "Hindu");
		act.Select("name", "creditCard", "American Express");
		act.input("name", "creditnumber", "123456789");
		act.Select("name", "cc_exp_dt_mn", "06");
		act.Select("name", "cc_exp_dt_yr", "2010");
		act.input("name", "cc_frst_name", "M");
		act.input("name", "cc_mid_name", "S");
		act.input("name", "cc_last_name", "Dhoni");
		act.click("xpath", "//*[@name='ticketLess'])[1]");
		act.clear("name", "billAddress1");
		act.input("name", "billAddress1", "1325 Borregas Ave.");
		act.clear("name", "billCity");
		act.input("name", "billCity", "Sunnyvale");
		act.clear("name", "billState");
		act.input("name", "billState", "CA");
		act.clear("name", "billZip");
		act.input("name", "billZip", "94089");
		act.Select("name", "billCountry", "UNITED STATE);
		act.click("xpath", "//*[@name='ticketLess'])[2]");
		act.clear("name", "delAddress1");
		act.input("name", "delAddress1", "1325 Borregas Ave.");
		act.clear("name", "delCity");
		act.input("name", "delCity", "Sunnyvale");
		act.clear("name", "delState");
		act.input("name", "delState", "CA");
		act.clear("name", "delZip");
		act.input("name", "delZip", "94089");
		act.Select("name", "delCountry", "UNITED STATES");
		act.click("name", "buyFlights");
		
		
		
		
		
		
	}
	public void SmokeTestcase5(){
		System.out.println(" Running SmokeTestcase5");
	}*/
}
