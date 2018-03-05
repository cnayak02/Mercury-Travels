package zenmi.Abcd.executer;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import zenmi.Abcd.generic.Xls_Reader;
import zenmi.Abcd.seleniumCore.ActionDriver;

public class DriveXL extends ActionDriver {
	Properties OR;
	public DriveXL(WebDriver driver) throws Exception {
		super(driver);
		 OR = new Properties();
			String path = "./src/zenmi/Abcd/uimap/OR.properties";
			File file = new File(path);
			OR.load(new FileInputStream(file));
		}
	public enum Actions {
		click,input,VerifyElement,Select
	}
	
	public void ReadxlAction(String path, String testcaseName){
		Xls_Reader xls=new Xls_Reader(path);
		int row= xls.getRowCount(testcaseName);
		int col=xls.getColumnCount(testcaseName);
		for(int i=2;i<=row;i++){
	    String flag=xls.getCellData(testcaseName, 0, i);
		String Action=xls.getCellData(testcaseName, 1, i);
		String Element=xls.getCellData(testcaseName, 2, i);
		String ElementDec=xls.getCellData(testcaseName, 3, i);
		String Value=xls.getCellData(testcaseName, 4, i);
		String Verify=xls.getCellData(testcaseName, 5, i);
		String Result=xls.getCellData(testcaseName, 6, i);
		String []s1=Element.split("_");
		String locaotor=s1[1];
		String locatorValue=OR.getProperty(Element);
		if (flag.equalsIgnoreCase("yes")) {
			switch (Actions.valueOf(Action)) {
			case click:
				click(locaotor, locatorValue);
				if (ActionStatus) {
					xls.setCellData(testcaseName, "Result", i, "PASS");
				}
				else{
					xls.setCellData(testcaseName,"Result", i, "FAIL");
				}
					
				break;
			case input:
				input(locaotor, locatorValue, Value);
				if (ActionStatus) {
					xls.setCellData(testcaseName, "Result", i, "PASS");
				}
				else{
					xls.setCellData(testcaseName,"Result", i, "FAIL");
				}
				break;
			case VerifyElement:
				VerifyElement(locaotor,locatorValue);
				if (ActionStatus) {
					xls.setCellData(testcaseName, "Result", i, "PASS");
				}
				else{
					xls.setCellData(testcaseName,"Result", i, "FAIL");
				}
				break;
			case Select:
				Select(locaotor, locatorValue, Value);
				if (ActionStatus) {
					xls.setCellData(testcaseName, "Result", i, "PASS");
				}
				else{
					xls.setCellData(testcaseName,"Result", i, "FAIL");
				}
				break;
				
			}
		}
		  }
		
			}
		
	public static void main(String[] args) {
		
		
}
	}
