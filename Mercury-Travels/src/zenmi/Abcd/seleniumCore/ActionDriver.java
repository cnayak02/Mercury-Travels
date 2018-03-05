package zenmi.Abcd.seleniumCore;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.openqa.selenium.support.ui.Select;

public class ActionDriver {
  
	 public WebDriver driver;
	WebElement element;
	Wait<WebDriver> wait;
	Actions act;
	Select sel;
	public boolean ActionStatus;
	public static Logger log = Logger.getLogger("ActionDriver");

	public ActionDriver(WebDriver driver) {
		this.driver = driver;
		wait = new FluentWait<WebDriver>(driver).withTimeout(30, TimeUnit.SECONDS).pollingEvery(1, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);
		act = new Actions(driver);
		
		}

	
	public enum locatorname {
		id, name, xpath, classname, tagname, cssSelector, linktext, partiallinktext
	}

	public void click(String locaotor, String locatorValue) {
		element = findElement(locaotor, locatorValue);
		if (element != null)
			if (element.isDisplayed()) {
				ActionStatus=true;
				element.click();
				System.out.println("click is sucessful");
				log.info("click is sucessful");
			} else {
				System.out.println("Element is present but not enabled to click");
				log.info("Element is present but not enabled to click whose locator is ->" + locaotor
						+ " --> with value -->" + locatorValue);
			}
		else {
			System.out.println("failed to find an element to click");
			log.info(
					"failed to find an element to click with locator-->" + locaotor + " with value -->" + locatorValue);

		}
	}

	public void input(String locaotor, String locatorValue, String textToEnter) {
		element = findElement(locaotor, locatorValue);
		if (element != null)
			if (element.isDisplayed()) {
				ActionStatus=true;
				element.sendKeys(textToEnter);
				System.out.println("element is found and text is enter sucessfully");
				log.info("element is found and text is enter sucessfully");
			} else {
				System.out.println("Element is present but not display to type ");
				log.info("Element is present but not display to type  whose locator is ->" + locaotor+ " --> with value -->" + locatorValue);
			}
		else {
			System.out.println("failed to find an element to type");
			log.info("failed to find an element to type with locator-->" + locaotor + " with value -->" + locatorValue);

		}

	}

	public void mousOever(String locaotor, String locatorValuer) {
		element = findElement(locaotor, locatorValuer);
		if (element != null)
			if (element.isDisplayed()) {
				ActionStatus=true;
				act.moveToElement(element).build().perform();
				System.out.println("element is found and mouse croser is move sucessful");

			} else {
				System.out.println("element is not ptesent to move crosser");
			}
	}

	public void dubleclick(String locaotor, String locatorValuer) {
		element = findElement(locaotor, locatorValuer);
		if (element != null)
			if (element.isDisplayed()) {
				ActionStatus=true;
				act.doubleClick(element).build().perform();
				System.out.println("element is found and dubleclick sucessful");

			} else {
				System.out.println("element is not ptesent to dubleclick");
			}
	}

	public void rightclick(String locaotor, String locatorValuer) {
		element = findElement(locaotor, locatorValuer);
		if (element != null)
			if (element.isDisplayed()) {
				ActionStatus=true;
				act.contextClick(element).build().perform();
				System.out.println("element is found and rightclick sucessful");

			} else {
				System.out.println("element is not ptesent to rightclick");
			}
	}
	public void verifyTextOnElement(String locaotor, String locatorValuer,String exceptedText) {
		element = findElement(locaotor, locatorValuer);
		if (element != null){
			ActionStatus=true;
			String actualText=element.getText();
			if(actualText.equals(exceptedText)){
				System.out.println("Text verification is done");
			}
			else
			{
				System.out.println("Element is present but there is no expected text on it");
			}
			
		}
		else
		{
			System.out.println("failed to find an element to verify text with locator-->" +locaotor+ " with value -->" + locatorValuer );
			
		}
				
			}
	public void Select(String locaotor, String locatorValue, String selecttxt) {
		element = findElement(locaotor, locatorValue);
		if (element != null)
			if (element.isDisplayed()) {
				ActionStatus=true;
			 sel=new Select(element);
			 sel.selectByVisibleText(selecttxt);
			 System.out.println("Selecting element is done");
			}
			else{
				System.out.println("Element is present but There is no text to select");
			}
				
			else{
		System.out.println("failed to find an element to verify text with locator-->" +locaotor+ " with value -->" + locatorValue );
	}
}
	public void clear(String locaotor, String locatorValue) {
		element = findElement(locaotor, locatorValue);
		if (element != null)
			if (element.isDisplayed()) {	
				ActionStatus=true;
				element.clear();
				System.out.println("clear is sucessful");
				log.info("clear is sucessful");
			} else {
				System.out.println("Element is present but not enabled to clear");
				log.info("Element is present but not enabled to clear whose locator is ->" + locaotor
						+ " --> with value -->" + locatorValue);
			}
		else {
			System.out.println("failed to find an element to clear");
			log.info("failed to find an element to clear with locator-->" + locaotor + " with value -->" + locatorValue);

		}
	}
	public void VerifyElement(String locaotor, String locatorValue) {
		element = findElement(locaotor, locatorValue);
		ActionStatus=true;
		Assert.assertNotNull(element,"failed to find an element to Verify");
	}
	public WebElement findElement(String locator, String locatorvalue) {
		WebElement element = null;
		ActionStatus=false;
		try {
			switch (locatorname.valueOf(locator)) {
			case id:
				System.out.println("Finding based on id");
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
				System.out.println("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				log.info("Finding is successful with element locator -> " + locator + "=" + locatorvalue);

				break;
			case name:
				System.out.println("Finding based on name");
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorvalue)));
				System.out.println("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				log.info("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				break;
			case xpath:
				System.out.println("Finding based on xpath");
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorvalue)));
				System.out.println("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				log.info("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				break;
			case cssSelector:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorvalue)));
				System.out.println("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				log.info("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				break;
			case classname:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorvalue)));
				System.out.println("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				log.info("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				break;
			case tagname:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorvalue)));
				System.out.println("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				log.info("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				break;
			case linktext:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorvalue)));
				System.out.println("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				log.info("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				break;
			case partiallinktext:
				element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorvalue)));
				System.out.println("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				log.info("Finding is successful with element locator -> " + locator + "=" + locatorvalue);
				break;
			}
		} catch (Exception e) {
			System.out.println("Failed to find an element with element locator -> " + locator + "=" + locatorvalue);
			log.info("Failed to find an element with element locator -> " + locator + "=" + locatorvalue);

		}
		return element;
	}
}
