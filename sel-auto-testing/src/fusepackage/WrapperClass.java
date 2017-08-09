package fusepackage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.server.handler.FindElements;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WrapperClass {
	RemoteWebDriver driver;
	String strng = null;
	String part = null;
	String product = null;
	String text = null;
	String trimtext = null;
	String text1=null;
	String refvalue = null;
	String actvalue = null;
	String a =null;
	String p =null;
	String name = null;
	String title =null;
	String time = null;
	/**
	 * Launch the desired browser and click the URL
	 * 
	 * @param Browser
	 * @param URL
	 * @throws InterruptedException 
	 */
	public void launchBroswer(String Browser, String URL) {
		if (Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver",".\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (Browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver", ".\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * Function used to pass the Web element ID and Value to entered in text box
	 * 
	 * @param id
	 *            = Web Element ID
	 * @param sendvalue
	 *            = Value entered in Text Box
	 * @throws IOException
	 */
	public void sendvaluebyid(String id, String sendvalue) throws IOException {
		try {
			driver.findElementById(id).clear();
			driver.findElement(By.id(id)).sendKeys(sendvalue);
			
		} catch (NoSuchElementException expType) {

			expType.printStackTrace();

		} catch (NotFoundException expType) {

			expType.printStackTrace();
		} catch (WebDriverException expType) {

			expType.printStackTrace();
		} catch (Exception expType) {

			expType.printStackTrace();
		} finally {
			takesnapshot(id);
		}
	}
	public void refreshpage() throws IOException {
		try {
			driver.navigate().refresh();
			
		} catch (Exception expType) {

			expType.printStackTrace();
	}
	}
	public void sendvaluebyeid(String id, String sendvalue) throws IOException {
		try {
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(sendvalue);
			driver.findElement(By.id(id)).sendKeys(Keys.ENTER);
			
		} catch (NoSuchElementException expType) {

			expType.printStackTrace();

		} catch (NotFoundException expType) {

			expType.printStackTrace(); 
		} catch (WebDriverException expType) {

			expType.printStackTrace();
		} catch (Exception expType) {

			expType.printStackTrace();
		} finally {
			takesnapshot(id);
		}
	}
		

	public void sendvaluebyidnum(String id, Integer i) throws IOException {
		try {
			String t = i.toString();
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(t);
			
		} catch (NoSuchElementException expType) {

			expType.printStackTrace();

		} catch (NotFoundException expType) {

			expType.printStackTrace();
		} catch (WebDriverException expType) {

			expType.printStackTrace();
		} catch (Exception expType) {

			expType.printStackTrace();
		} finally {
			takesnapshot(id);
		}
	}
	public void sendvaluebyidbignum(String id, long i) throws IOException {
		try {
			String t = Long.toString(i);			
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(t);
			
		} catch (NoSuchElementException expType) {

			expType.printStackTrace();

		} catch (NotFoundException expType) {

			expType.printStackTrace();
		} catch (WebDriverException expType) {

			expType.printStackTrace();
		} catch (Exception expType) {

			expType.printStackTrace();
		} finally {
			takesnapshot(id);
		}
	}
	/**
	 * Function used to pass the Web element Name and Value to entered in text
	 * box
	 * 
	 * @param name=
	 *            Web Element name
	 * @param sendvalue
	 *            = Value entered in Text Box
	 * @throws IOException
	 */
	public void sendvaluebyname(String name, String sendvalue) throws IOException {
//		try {
			driver.findElement(By.name(name)).clear();
			driver.findElement(By.name(name)).sendKeys(sendvalue);
//		} catch (NoSuchElementException expType) {
//
//			expType.printStackTrace();
//
//		} catch (NotFoundException expType) {
//
//			expType.printStackTrace();
//		} catch (WebDriverException expType) {
//
//			expType.printStackTrace();
//		} catch (Exception expType) {
//
//			expType.printStackTrace();
//		} finally {
//			takesnapshot(name);
//		}
	}

	/**
	 * Function used to pass the Web element X-path and Value to entered in text
	 * box
	 * 
	 * @param xpath=
	 *            Web Element's X-path
	 * @param sendvalue
	 *            = Value entered in Text Box
	 * @throws IOException
	 */
	public void sendvaluebyxpath(String xpath, String sendvalue) throws IOException {
//		try {
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(sendvalue);
//		} catch (NoSuchElementException expType) {
//
//			expType.printStackTrace();
//
//		} catch (NotFoundException expType) {
//
//			expType.printStackTrace();
//		} catch (WebDriverException expType) {
//
//			expType.printStackTrace();
//		} catch (Exception expType) {
//
//			expType.printStackTrace();
//		} finally {
//			takesnapshot(sendvalue);
//		}
	}
	public void sendwoutclvaluebyxpath(String xpath, String sendvalue) throws IOException {
//		try {
			driver.findElement(By.xpath(xpath)).sendKeys(sendvalue);
//		} catch (NoSuchElementException expType) {
//
//			expType.printStackTrace();
//
//		} catch (NotFoundException expType) {
//
//			expType.printStackTrace();
//		} catch (WebDriverException expType) {
//
//			expType.printStackTrace();
//		} catch (Exception expType) {
//
//			expType.printStackTrace();
//		} finally {
//			takesnapshot(sendvalue);
//		}
	}
	public void sendvalueenterbyxpath(String xpath, String sendvalue) throws IOException {
//		try {
			WebElement se = driver.findElement(By.xpath(xpath));
			se.clear();
			se.sendKeys(sendvalue);
			se.sendKeys(Keys.ENTER);
//		} catch (NoSuchElementException expType) {
//
//			expType.printStackTrace();
//
//		} catch (NotFoundException expType) {
//
//			expType.printStackTrace();
//		} catch (WebDriverException expType) {
//
//			expType.printStackTrace();
//		} catch (Exception expType) {
//
//			expType.printStackTrace();
//		} finally {
//			takesnapshot(sendvalue);
//		}
	}

	
	public void sendpartvaluebyxpathanddownclick(String xpath,String sendvalue) throws IOException, InterruptedException {
//		try {
			WebElement we = driver.findElement(By.xpath(xpath));
			we.sendKeys(sendvalue);
            Actions builder = new Actions(driver);
            Thread.sleep(2000);
            Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
			mouseOverHome.perform();
//		} catch (NoSuchElementException expType) {
//
//			expType.printStackTrace();
//
//		} catch (NotFoundException expType) {
//
//			expType.printStackTrace();
//		} catch (WebDriverException expType) {
//
//			expType.printStackTrace();
//		} catch (Exception expType) {
//
//			expType.printStackTrace();
//		} finally {
//			takesnapshot(sendvalue);
//		}
	}
	public void sendproductvaluebyxpathanddownclick(String xpath,String sendvalue) throws IOException, InterruptedException {
//		try {
			WebElement we = driver.findElement(By.xpath(xpath));
			we.sendKeys(sendvalue);
			Thread.sleep(2000);
            Actions builder = new Actions(driver);
            Action mouseOverHome = builder.click(we).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
			mouseOverHome.perform();
//		} catch (NoSuchElementException expType) {
//
//			expType.printStackTrace();
//
//		} catch (NotFoundException expType) {
//
//			expType.printStackTrace();
//		} catch (WebDriverException expType) {
//
//			expType.printStackTrace();
//		} catch (Exception expType) {
//
//			expType.printStackTrace();
//		} finally {
//			takesnapshot(sendvalue);
//		}
	}
	public void sendvaluebyxpathand2downclick(String xpath, String sendvalue) throws IOException {
//		try {
			WebElement we = driver.findElement(By.xpath(xpath));
			we.sendKeys(sendvalue);
            Actions builder = new Actions(driver);
            Action mouseOverHome = builder.click(we).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
			mouseOverHome.perform();
//		} catch (NoSuchElementException expType) {
//
//			expType.printStackTrace();
//
//		} catch (NotFoundException expType) {
//
//			expType.printStackTrace();
//		} catch (WebDriverException expType) {
//
//			expType.printStackTrace();
//		} catch (Exception expType) {
//
//			expType.printStackTrace();
//		} finally {
//			takesnapshot(sendvalue);
//		}
	}
	/**
	 * Function used to pass the Web element Tag name and Value to entered in
	 * text box
	 * 
	 * @param Tagname
	 *            = Tag Name of the Web Element
	 * @param sendvaluesendvalue
	 *            = Value entered in Text Box
	 * @throws IOException
	 */
	public void sendvaluebyTagname(String Tagname, String sendvalue) throws IOException {
		try {
			driver.findElement(By.tagName(Tagname)).clear();
			driver.findElement(By.tagName(Tagname)).sendKeys(sendvalue);
		} catch (NoSuchElementException expType) {

			expType.printStackTrace();

		} catch (NotFoundException expType) {

			expType.printStackTrace();
		} catch (WebDriverException expType) {

			expType.printStackTrace();
		} catch (Exception expType) {

			expType.printStackTrace();
		} finally {
			takesnapshot(Tagname);
		}
	}

	/**
	 * Function used to pass the Web element Class Name and Value to entered in
	 * text box
	 * 
	 * @param classname=
	 *            Class Name of the Web Element
	 * @param sendvaluesendvalue
	 *            = Value entered in Text Box
	 * @throws IOException
	 */
	public void sendvaluebyclassname(String classname, String sendvalue) throws IOException {
		try {
			driver.findElement(By.className(classname)).clear();
			driver.findElement(By.className(classname)).sendKeys(sendvalue);
		} catch (NoSuchElementException expType) {

			expType.printStackTrace();

		} catch (NotFoundException expType) {

			expType.printStackTrace();
		} catch (WebDriverException expType) {

			expType.printStackTrace();
		} catch (Exception expType) {

			expType.printStackTrace();
		} finally {
			takesnapshot(classname);
		}
	}

	/**
	 * Function used to pass the Web element Class Name and Value to entered in
	 * text box
	 * 
	 * @param selector
	 * @param sendvalue
	 * @throws IOException
	 */
	public void sendvaluebyCssselector(String selector, String sendvalue) throws IOException {
		try {
			driver.findElement(By.cssSelector(selector)).clear();
			driver.findElement(By.cssSelector(selector)).sendKeys(sendvalue);
		} catch (NoSuchElementException expType) {

			expType.printStackTrace();

		} catch (NotFoundException expType) {

			expType.printStackTrace();
		} catch (WebDriverException expType) {

			expType.printStackTrace();
		} catch (Exception expType) {

			expType.printStackTrace();
		} finally {
			takesnapshot(selector);
		}
	}

	// To close the single opened browser which opened by Selenium
	public void closeBrowser() {
		driver.close();
	}

	// To close all the opened browser which opened by Selenium
	public void closeAllBrowsers() {
		driver.quit();
	}

	// Wait Until the Browser page loads
	public void waitTillBrowserLoads(int limit) {
		driver.manage().timeouts().implicitlyWait(limit, TimeUnit.SECONDS);
	}

	/**
	 * Click the Web Element by possible locator
	 */
	 public void iconClick(String xpath){
//		  try{
		   WebElement element = driver.findElement (By.xpath (xpath));
		   JavascriptExecutor executor = (JavascriptExecutor) driver;
		   executor.executeScript ("arguments[0].click();" , element);
//		   }
//		  catch (NoSuchElementException expType) {
//
//		   expType.printStackTrace();
//
//		  } catch (NotFoundException expType) {
//
//		   expType.printStackTrace();
//		  } catch (WebDriverException expType) {
//
//		   expType.printStackTrace();
//		  } catch (Exception expType) {
//
//		   expType.printStackTrace();
//		  }		  
		 }
	public void clickByXpath(String xpath) {
//		try {
			driver.findElement(By.xpath(xpath)).click();
//		 } catch (NoSuchElementException expType) {
//
//			expType.printStackTrace();
//
//		} catch (NotFoundException expType) {
//
//			expType.printStackTrace();
//		} catch (WebDriverException expType) {
//
//			expType.printStackTrace();
//		} catch (Exception expType) {
//
//			expType.printStackTrace();
//		}
	}
	public void clickwaitByXpath(String xpath) {
		try {
			WebElement w =driver.findElement(By.xpath(xpath));
			wait(3000);
			w.click();
		 } catch (NoSuchElementException expType) {

			expType.printStackTrace();

		} catch (NotFoundException expType) {

			expType.printStackTrace();
		} catch (WebDriverException expType) {

			expType.printStackTrace();
		} catch (Exception expType) {

			expType.printStackTrace();
		}
	}
	public void clickByCategoryXpath(String xpath,String Cate) {
		try {
			WebElement we = driver.findElement(By.xpath(xpath));
            Actions builder = new Actions(driver);
            @SuppressWarnings("deprecation")
			Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Cate).sendKeys(Keys.DOWN).sendKeys(Keys.ENTER).build();
			mouseOverHome.perform();
			
		} catch (Exception e) {
			System.out.println("Not able to recognize Webelement " + xpath + " here");
		}
	}

	public void clickByHDEmXpath(String xpath) {
//		try {
			WebElement we = driver.findElement(By.xpath(xpath));
            Actions builder = new Actions(driver);
            Action mouseOverHome = builder.click(we).sendKeys(Keys.ESCAPE).build();
			mouseOverHome.perform();
//			
//		} catch (Exception e) {
//			System.out.println("Not able to recognize Webelement " + xpath + " here");
//		}
	}
	public void clickByid(String id) {
		try {
			driver.findElement(By.id(id)).click();
		} catch (Exception e) {
			System.out.println("Not able to recognize Webelement " + id + " here");
		}
	}

	public void clickByname(String name) {
		try {
			driver.findElement(By.name(name)).click();
		} catch (Exception e) {
			System.out.println("Not able to recognize Webelement " + name + " here");
		}
	}

	public void clickBytagname(String tagname) {
		try {
			driver.findElement(By.tagName(tagname)).click();
		} catch (Exception e) {
			System.out.println("Not able to recognize Webelement " + tagname + " here");
		}
	}

	public void clickBycssSelector(String selector) {
		try {
			driver.findElement(By.cssSelector(selector)).click();
		} catch (Exception e) {
			System.out.println("Not able to recognize Webelement " + selector + " here");
		}
	}

	public void clickByclassname(String classname) {
		try {
			driver.findElement(By.className(classname)).click();
		} catch (Exception e) {
			System.out.println("Not able to recognize Webelement " + classname + " here");
		}
	}

	public void clickBylinktext(String text) {
		try {
			driver.findElement(By.linkText(text)).click();
		} catch (Exception e) {
			System.out.println("Not able to recognize Webelement " + text + " here");
		}
	}

	public void clickBypartiallinktext(String text) {
		try {
			driver.findElement(By.partialLinkText(text)).click();
		} catch (Exception e) {
			System.out.println("Not able to recognize Webelement " + text + " here");
		}
	}

	public void takesnapshot(String Snapshot) throws IOException {
		File snaps = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(snaps, new File("./Screenshots/" + Snapshot + ".png"), true);
	}

	public void selectByid_lastIndex(String element_id) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.id(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			int jobrolesize = jobrole_list.getOptions().size();
			jobrole_list.selectByIndex(jobrolesize - 1);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Cannot locate option with index");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectById_Index(String element_id, int i) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.id(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByIndex(i);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Cannot locate option with index " + i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByid_Value(String element_id, String Value) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.id(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByValue(Value);
		} catch (NoSuchElementException e) {
			System.out.println(" Cannot locate option with value: " + Value);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByid_Visibletext(String element_id, String text) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.id(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			System.out.println(" Cannot locate option with value: " + text);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByXpath_lastIndex(String element_id) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.xpath(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			int jobrolesize = jobrole_list.getOptions().size();
			jobrole_list.selectByIndex(jobrolesize - 1);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Cannot locate option with index");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByXpath_Index(String element_id, int i) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.xpath(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByIndex(i);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Cannot locate option with index " + i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByXpath_Value(String element_id, String Value) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.xpath(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByValue(Value);
		} catch (NoSuchElementException e) {
			System.out.println(" Cannot locate option with value: " + Value);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByXpath_Visibletext(String element_id, String text) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.xpath(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			System.out.println(" Cannot locate option with value: " + text);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByTag_lastIndex(String element_id) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.tagName(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			int jobrolesize = jobrole_list.getOptions().size();
			jobrole_list.selectByIndex(jobrolesize - 1);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Cannot locate option with index");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByTag_Index(String element_id, int i) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.tagName(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByIndex(i);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Cannot locate option with index " + i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByTag_Value(String element_id, String Value) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.tagName(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByValue(Value);
		} catch (NoSuchElementException e) {
			System.out.println(" Cannot locate option with value: " + Value);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByTag_Visibletext(String element_id, String text) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.tagName(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			System.out.println(" Cannot locate option with value: " + text);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByName_lastIndex(String element_id) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.name(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			int jobrolesize = jobrole_list.getOptions().size();
			jobrole_list.selectByIndex(jobrolesize - 1);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Cannot locate option with index");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByName_Index(String element_id, int i) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.name(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByIndex(i);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Cannot locate option with index " + i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByName_Value(String element_id, String Value) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.name(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByValue(Value);
		} catch (NoSuchElementException e) {
			System.out.println(" Cannot locate option with value: " + Value);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByName_Visibletext(String element_id, String text) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.name(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			System.out.println(" Cannot locate option with value: " + text);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByClass_lastIndex(String element_id) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.className(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			int jobrolesize = jobrole_list.getOptions().size();
			jobrole_list.selectByIndex(jobrolesize - 1);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Cannot locate option with index");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByClass_Index(String element_id, int i) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.className(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByIndex(i);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (IndexOutOfBoundsException e) {
			System.out.println(" Cannot locate option with index " + i);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}

	public void selectByClass_Value(String element_id, String Value) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.className(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByValue(Value);
		} catch (NoSuchElementException e) {
			System.out.println(" Cannot locate option with value: " + Value);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
		}
	}
	WebElement searchElement;
	public void Searchelement(String xpath) throws IOException {
		//try
		//  {
		   searchElement = driver.findElement(By.xpath(xpath));
		 // }
		 // catch(Exception e)
		 // {
			//  e.printStackTrace();
//		   searchElement = null;
//		   System.out.println("The Search element "+xpath+" is not found");
		  //}
		  }
	WebElement FilterElement;
	public void Filterelement(String xpath) throws IOException {
		try
		  {
			FilterElement = driver.findElement(By.xpath(xpath));
		  }
		  catch(Exception e)
		  {
			  FilterElement = null;
		  }
		  }
	public void selectByClass_Visibletext(String element_id, String text) throws IOException {
		try {
			WebElement dropdown_jobrole = driver.findElement(By.className(element_id));
			Select jobrole_list = new Select(dropdown_jobrole);
			jobrole_list.selectByVisibleText(text);
		} catch (NoSuchElementException e) {
			System.out.println(" Cannot locate option with value: " + text);
		} catch (NotFoundException e) {
			System.out.println("Not able to recognize Webelement " + element_id + " here");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			takesnapshot(element_id);
	}
	}
	
   public void mouseHoverByXpath(String xpath) {
	try {
		Actions mouseAction = new Actions(driver);
		WebElement we = driver.findElement(By.xpath(xpath));
		mouseAction.moveToElement(we).build().perform();
		System.out.println("The xpath:"+xpath+" is moused over successfully");

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
   public void mouseHoverdownByXpath(String xpath) {
	try {
		WebElement we = driver.findElement(By.xpath(xpath));
		we.sendKeys(Keys.ARROW_DOWN);
		System.out.println("The xpath:"+xpath+" is moused over successfully");

	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   }
	   public void mouseHoverlocXpath(String xpath) {
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions mouseAction = new Actions(driver);
				Actions seriesOfActions = mouseAction.click(we).pause(2000).moveByOffset(1272, 107).pause(2000).click();
				seriesOfActions.build().perform();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	public void doubleclickbyXpath(String xpath) {
					try {
						WebElement we = driver.findElement(By.xpath(xpath));
						Actions mouseAction = new Actions(driver);
						Actions seriesOfActions = mouseAction.doubleClick(we);
						seriesOfActions.build().perform();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}		
	
}
	   public void escape() {
			try {
				Actions mouseAction = new Actions(driver);
				Actions seriesOfActions = mouseAction.sendKeys(Keys.ESCAPE);
				seriesOfActions.build().perform();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
	
}   
	public void verifystatus(String xpath){
//    try {
    WebElement element = driver.findElement(By.xpath(xpath));
    strng= element.getText();
    System.out.println(strng);
//  } catch (NoSuchElementException e) {
//   System.out.println("Not able to recognize Webelement " + xpath + " here");
//  } catch (NotFoundException e) {
//   System.out.println("Not able to recognize Webelement " + xpath + " here");
//  } catch (Exception e) {
//   e.printStackTrace();
//  }
   }
	public void gettext(String xpath){
//	    try {
	    WebElement element = driver.findElement(By.xpath(xpath));
	    actvalue = element.getText();
//	    } catch (NoSuchElementException e) {
//	   System.out.println("Not able to recognize Webelement " + xpath + " here");
//	  } catch (NotFoundException e) {
//	   System.out.println("Not able to recognize Webelement " + xpath + " here");
//	  } catch (Exception e) {
//	   e.printStackTrace();
//	  }
	    }
	
	public void comparetask(String xpath){
	    try {
	    WebElement element = driver.findElement(By.xpath(xpath));
	    actvalue = element.getText();
	    } catch (NoSuchElementException e) {
	   System.out.println("Not able to recognize Webelement " + xpath + " here");
	  } catch (NotFoundException e) {
	   System.out.println("Not able to recognize Webelement " + xpath + " here");
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	    }
	
	public void gettexttrim(String xpath){
//	    try {
	    WebElement element = driver.findElement(By.xpath(xpath));
	    trimtext = element.getText();
	    int spos = trimtext.indexOf("(");
	    int epos = trimtext.lastIndexOf(")");
	    a = trimtext.substring(spos+1, epos);
	    System.out.println("This Part or Product is under "+a);
//	    } catch (NoSuchElementException e) {
//	   System.out.println("Not able to recognize Webelement " + xpath + " here");
//	  } catch (NotFoundException e) {
//	   System.out.println("Not able to recognize Webelement " + xpath + " here");
//	  } catch (Exception e) {
//	   e.printStackTrace();
//	  }
	    }
	public void gettitlenumtrim(String xpath){
	    try {
	    WebElement element = driver.findElement(By.xpath(xpath));
	    trimtext = element.getText();
	    p = trimtext.substring(0, 5);
	    System.out.println(p);
	    } catch (NoSuchElementException e) {
	   System.out.println("Not able to recognize Webelement " + xpath + " here");
	  } catch (NotFoundException e) {
	   System.out.println("Not able to recognize Webelement " + xpath + " here");
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	    }
	public void finddeletedBOM(String xpath){
		  WebElement we = driver.findElement(By.xpath(xpath));
		    ArrayList myArray = (ArrayList) we;// my array list
		    boolean isStringExists = myArray.contains(p);
		 }
 public void createdby(String xpath,String Xpath){
//    try {
    WebElement element = driver.findElement(By.xpath(xpath));
    WebElement element1 = driver.findElement(By.xpath(Xpath));
    text = element.getAttribute("innerHTML").trim();
    text1 = element1.getAttribute("innerHTML").trim();
    System.out.println("Part Created By  " + text);
    System.out.println("Part Created Date  " + text1);
//    } catch (NoSuchElementException e) {
//   System.out.println("Not able to recognize Webelement " + xpath + " here");
//  } catch (NotFoundException e) {
//   System.out.println("Not able to recognize Webelement " + xpath + " here");
//  } catch (Exception e) {
//   e.printStackTrace();
//  }
  }
 public void gettextprint(String xpath,String xpath1,String xpath2){
	    try {
	    WebElement element = driver.findElement(By.xpath(xpath));
	    WebElement element1 = driver.findElement(By.xpath(xpath1));
	    WebElement element2 = driver.findElement(By.xpath(xpath2));
	    name = element.getAttribute("innerHTML").trim();
	    title = element1.getAttribute("innerHTML").trim();
	    time = element2.getAttribute("innerHTML").trim();
	    System.out.println(name  +  title  +  time);
	    } catch (NoSuchElementException e) {
	   System.out.println("Not able to recognize Webelement " + xpath + " here");
	  } catch (NotFoundException e) {
	   System.out.println("Not able to recognize Webelement " + xpath + " here");
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	    }
	 
public void verifytext(String xpath){
//    try {
    WebElement element = driver.findElement(By.xpath(xpath));
    refvalue = element.getAttribute("innerHTML").trim();
   // Assert.assertEquals(text, refvalue);
    if ((actvalue.trim()).equalsIgnoreCase(refvalue))
    {
    	System.out.println("Created By : " + text + " Time : " + refvalue);
    	System.out.println("Basic info not updated");
    }
    else
    {
    	System.out.println("Updated By : " + text + " Time : " + refvalue);
    	System.out.println("Basic info updated successfully");
    }
    
//  } catch (NoSuchElementException e) {
//   System.out.println("Not able to recognize Webelement " + xpath + " here");
//  } catch (NotFoundException e) {
//   System.out.println("Not able to recognize Webelement " + xpath + " here");
//  } catch (Exception e) {
//   e.printStackTrace();
//  }
    }
	   public void partnumber(String xpath){
		   try {
		   WebElement element = driver.findElement(By.xpath(xpath));
		   part= element.getText();
		   System.out.println(part);
		   } catch(Exception e){
			   e.printStackTrace();
		   }
		   }
	   public void productnumber(String xpath){
		   try {
		   WebElement element = driver.findElement(By.xpath(xpath));
		   product= element.getText();
		   System.out.println(product);
//		   Assert.assertEquals("Google Search", strng);
		   } catch(Exception e){
			   e.printStackTrace();
		   }
		   }
	   public void scroll(String scele){
//		   try {
			 //scroll down
			   WebElement element = driver.findElement((By.xpath(scele)));
			   ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
//		   } catch(Exception e){
//			   e.printStackTrace();
//		   }
		   }
		 
	    public void enter() {
	    	   try {
	    	    Actions mouseAction = new Actions(driver);
	    	    Actions seriesOfActions = mouseAction.sendKeys(Keys.ENTER);
	    	    seriesOfActions.build().perform();
	    	   
	    	   } catch (Exception e) {
	    	    // TODO Auto-generated catch block
	    	    e.printStackTrace();
	    	   }
	    	    }
	    
	    public void getlastdiv(String id) throws IOException {
	    	
//	    	WebElement bodyElement = driver.findElement(By.id(id));   
//	    	List divElements1 = bodyElement.findElements(By.className("div"));
//	    	for(WebElement childDiv : divElements1)
//	    	{
//	    	 List fieldSetEle = childDiv.findElements(By.tagName("fieldset"));
//	    	 System.out.println(childDiv.getTagName()+":"+fieldSetEle.size());
//	    	   }  
//	    	
//	    	List<WebElement> allElement = driver.findElements(By.xpath(xpath));
//	         for (WebElement option : allElement)
//	         {
//	         System.out.println(option);
//	         String Str = "test" ;// based on string text match I want to select
//	         if("Str".equals(option.getText()))
//	         {
//	       option.click();    
//	      }}
	    	
	    	
	    	
//               List<WebElement> allElement = driver.findElements(By.xpath(xpath));
//                 int count = allElement.size();
//                 for(int i=0 ; i<=count;i++)
//                 {
//                 
//                 actvalue =allElement.get(i).getText();
//                 System.out.println(actvalue);
//                 }
//                 allElement.get(count).click();
//	    	try {
//	    	    WebElement element = driver.findElement(By.xpath(xpath));
//	    	    actvalue = element.getText();
//	    	    System.out.println(actvalue);
//	    	    } catch (NoSuchElementException e) {
//	    	   System.out.println("Not able to recognize Webelement " + xpath + " here");
//	    	  } catch (NotFoundException e) {
//	    	   System.out.println("Not able to recognize Webelement " + xpath + " here");
//	    	  } catch (Exception e) {
//	    	   e.printStackTrace();
//	    	  }

	    }
	    
	    
	    
	    private List<WebElement> FindElements(By xpath) {
			// TODO Auto-generated method stub
			return null;
		}

		public String[][] taskone() throws IOException {

	    	  // Create an input stream
	    	  FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    	  // Open the excel work sheet
	    	  XSSFWorkbook wb = new XSSFWorkbook(fis);

	    	  // Move control to the first sheet
	    	  XSSFSheet sheet = wb.getSheetAt(6);
	    	  int rc = sheet.getLastRowNum();
	    	  int cc = sheet.getRow(0).getLastCellNum();

	    	  String data[][] = new String[rc][3];

	    	  for (int i = 1; i <= rc; i++) {

	    	   // Move control to the specific row
	    	   XSSFRow firstRow = sheet.getRow(i);
	    	   int cellType;
	    	   String cellValue = null;
	    	   for(int k=0 ; k<1 ; k++){
	    	    cont:
	    	   for (int j = 0; j < 3; j++) {
	    	    cellType = firstRow.getCell(j).getCellType();
	    	    if (cellType == 0)
	    	    {
	    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
	    	        {
	    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
	    	        }
	    	       data[i - 1][k] = String.valueOf(cellValue);
	    	       k++;
	    	       continue cont;
	    	      }
	    	      else
	    	      {
	    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
	    	          System.out.println(data[i - 1][k]);
	    	          k++;
	    	          continue cont;
	    	      }
	    	      }
	    	    }
	    	    }
	    	  wb.close();
	    	  fis.close();

	    	  return data;
	    	  
	    	   
	    	 }
	    	 
	    	 public String[][] tasktwo() throws IOException {
	    	  // Create an input stream
	    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    	    // Open the excel work sheet
	    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    	    // Move control to the first sheet
	    	    XSSFSheet sheet = wb.getSheetAt(6);
	    	    int rc = sheet.getLastRowNum();
	    	    int cc = sheet.getRow(0).getLastCellNum();

	    	    String data[][] = new String[rc][4];

	    	    for (int i = 1; i <= rc; i++) {

	    	     // Move control to the specific row
	    	     XSSFRow firstRow = sheet.getRow(i);
	    	     int cellType;
	    	     String cellValue = null;
	    	     for(int k=0 ; k<4 ; k++){
	    	      cont:
	    	     for (int j = 3; j < 7; j++) {
	    	      cellType = firstRow.getCell(j).getCellType();
	    	      if (cellType == 0)
		    	    {
		    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
		    	        {
		    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
		    	        }
		    	       data[i - 1][k] = String.valueOf(cellValue);
		    	       k++;
		    	       continue cont;
		    	      }
		    	      else
		    	      {
		    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
		    	          System.out.println(data[i - 1][k]);
		    	          k++;
		    	          continue cont;
		    	      }
		    	      }
		    	    }
		    	    }
		    	  wb.close();
		    	  fis.close();
		    	  return data;  
		    	 }
	    	
	    	 public String[][] getrccarddata() throws IOException {
		    	  // Create an input stream
		    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		    	    // Open the excel work sheet
		    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

		    	    // Move control to the first sheet
		    	    XSSFSheet sheet = wb.getSheetAt(6);
		    	    int rc = sheet.getLastRowNum();
		    	    int cc = sheet.getRow(0).getLastCellNum();

		    	    String data[][] = new String[rc][4];

		    	    for (int i = 1; i <= rc; i++) {

		    	     // Move control to the specific row
		    	     XSSFRow firstRow = sheet.getRow(i);
		    	     int cellType;
		    	     String cellValue = null;
		    	     for(int k=0 ; k<1 ; k++){
		    	      cont:
		    	     for (int j = 24; j < 33; j++) {
		    	      cellType = firstRow.getCell(j).getCellType();
		    	      if (cellType == 0)
			    	    {
			    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
			    	        {
			    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
			    	        }
			    	       data[i - 1][k] = String.valueOf(cellValue);
			    	       k++;
			    	       continue cont;
			    	      }
			    	      else
			    	      {
			    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
			    	          System.out.println(data[i - 1][k]);
			    	          k++;
			    	          continue cont;
			    	      }
			    	      }
			    	    }
			    	    }
			    	  wb.close();
			    	  fis.close();
			    	  return data;  
			    	 }

	    	
	    	
	    	 public void xpathdownclick(String xpath) throws IOException{
	    		  try{
	    		   WebElement we = driver.findElement(By.xpath(xpath));
	    		   Actions builder = new Actions(driver);
	    		            Thread.sleep(2000);
	    		            Action mouseOverHome = builder.click(we).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
	    		   mouseOverHome.perform();
	    		  }catch (NoSuchElementException expType) {

	    		   expType.printStackTrace();

	    		  } catch (NotFoundException expType) {

	    		   expType.printStackTrace();
	    		  } catch (WebDriverException expType) {

	    		   expType.printStackTrace();
	    		  } catch (Exception expType) {

	    		   expType.printStackTrace();
	    		  } 
	    		 }
	    	 public String[][] taskthree() throws IOException {
	    	  // Create an input stream
	    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    	    // Open the excel work sheet
	    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    	    // Move control to the first sheet
	    	    XSSFSheet sheet = wb.getSheetAt(6);
	    	    int rc = sheet.getLastRowNum();
	    	    int cc = sheet.getRow(0).getLastCellNum();

	    	    String data[][] = new String[rc][4];

	    	    for (int i = 1; i <= rc; i++) {

	    	     // Move control to the specific row
	    	     XSSFRow firstRow = sheet.getRow(i);
	    	     int cellType;
	    	     String cellValue = null;
	    	     for(int k=0 ; k<4 ; k++){
	    	      cont:
	    	     for (int j = 7; j < 11; j++) {
	    	      cellType = firstRow.getCell(j).getCellType();
	    	      if (cellType == 0)
		    	    {
		    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
		    	        {
		    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
		    	        }
		    	       data[i - 1][k] = String.valueOf(cellValue);
		    	       k++;
		    	       continue cont;
		    	      }
		    	      else
		    	      {
		    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
		    	          System.out.println(data[i - 1][k]);
		    	          k++;
		    	          continue cont;
		    	      }
		    	      }
		    	    }
		    	    }
		    	  wb.close();
		    	  fis.close();

		    	  return data;
		    	  
		    	   
		    	 }
	    	 
	   public void gettitle(String xpath)
	   {
//	    try {
	        WebElement element = driver.findElement(By.xpath(xpath));
	        text = element.getAttribute("innerHTML").trim();
	        System.out.println("Board Name :  " + text);
//	        } catch (NoSuchElementException e) {
//	       System.out.println("Not able to recognize Webelement " + xpath + " here");
//	      } catch (NotFoundException e) {
//	       System.out.println("Not able to recognize Webelement " + xpath + " here");
//	      } catch (Exception e) {
//	       e.printStackTrace();
//	      }
	   }
	   public void getnumber(String xpath)
	   {
//	    try {
	        WebElement element = driver.findElement(By.xpath(xpath));
	        text = element.getAttribute("innerHTML").trim();
	        System.out.println("Board Number :  " + text);
//	        } catch (NoSuchElementException e) {
//	       System.out.println("Not able to recognize Webelement " + xpath + " here");
//	      } catch (NotFoundException e) {
//	       System.out.println("Not able to recognize Webelement " + xpath + " here");
//	      } catch (Exception e) {
//	       e.printStackTrace();
//	      }
	   }

	@SuppressWarnings("deprecation")
	public void dragAnddropByXpath(String abc,String def) {
//		     try {
				Actions act = new Actions(driver);
		      WebElement ele_drag = driver.findElement(By.xpath(abc));
		      WebElement ele_drop = driver.findElement(By.xpath(def));
		      act.clickAndHold(ele_drag).moveToElement(ele_drop).pause(3000).release(ele_drop).build().perform();
//		     } catch (Exception e) {
//		      // TODO Auto-generated catch block
//		      e.printStackTrace();
//		     }
	}
	public void currencysc(String xpath,String currency) {
	switch(currency) {
	   case "USD" :
//		   try {
	   {
		   WebElement we = driver.findElement(By.xpath(xpath));
	            Actions builder = new Actions(driver);
	            Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
//			} catch (NoSuchElementException expType) {
//
//				expType.printStackTrace();
//
//			} catch (NotFoundException expType) {
//
//				expType.printStackTrace();
//			} catch (WebDriverException expType) {
//
//				expType.printStackTrace();
//			} catch (Exception expType) {
//
//				expType.printStackTrace();
			} 
	      break; 
	   case "CAD" :
//		   try {
	   {		WebElement we = driver.findElement(By.xpath(xpath));
	            Actions builder = new Actions(driver);
	            Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
//			} catch (NoSuchElementException expType) {
//
//				expType.printStackTrace();
//
//			} catch (NotFoundException expType) {
//
//				expType.printStackTrace();
//			} catch (WebDriverException expType) {
//
//				expType.printStackTrace();
//			} catch (Exception expType) {
//
//				expType.printStackTrace();
			}
	      break;
	   case "EUR" :
//		   try {
	   {
		   		WebElement we = driver.findElement(By.xpath(xpath));
		        Actions builder = new Actions(driver);
	            Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
//			} catch (NoSuchElementException expType) {
//
//				expType.printStackTrace();
//
//			} catch (NotFoundException expType) {
//
//				expType.printStackTrace();
//			} catch (WebDriverException expType) {
//
//				expType.printStackTrace();
//			} catch (Exception expType) {
//
//				expType.printStackTrace();
			}
		  break;
	   case "GBP" :
//		   try {
	   {
		   		WebElement we = driver.findElement(By.xpath(xpath));
			    Actions builder = new Actions(driver);
	            Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
//			} catch (NoSuchElementException expType) {
//
//				expType.printStackTrace();
//
//			} catch (NotFoundException expType) {
//
//				expType.printStackTrace();
//			} catch (WebDriverException expType) {
//
//				expType.printStackTrace();
//			} catch (Exception expType) {
//
//				expType.printStackTrace();
			}
		  break;
	   case "INR" :
//		   try {
	   {
				WebElement we = driver.findElement(By.xpath(xpath));
	            Actions builder = new Actions(driver);
	            Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
//			} catch (NoSuchElementException expType) {
//
//				expType.printStackTrace();
//
//			} catch (NotFoundException expType) {
//
//				expType.printStackTrace();
//			} catch (WebDriverException expType) {
//
//				expType.printStackTrace();
//			} catch (Exception expType) {
//
//				expType.printStackTrace();
			}
		  break;
	   case "RMD" :
//		   try {
	   {
		   		WebElement we = driver.findElement(By.xpath(xpath));
	            Actions builder = new Actions(driver);
	            Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
//			} catch (NoSuchElementException expType) {
//
//				expType.printStackTrace();
//
//			} catch (NotFoundException expType) {
//
//				expType.printStackTrace();
//			} catch (WebDriverException expType) {
//
//				expType.printStackTrace();
//			} catch (Exception expType) {
//
//				expType.printStackTrace();
			}
		  break;	   
	     
	}
	}
	public void approvedsc(String xpath,String condition) {
		switch(condition) {
		   case "Yes" :
//			   try {
		   {
					WebElement we = driver.findElement(By.xpath(xpath));
		            Actions builder = new Actions(driver);
		            Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ENTER).build();
					mouseOverHome.perform();
//				} catch (NoSuchElementException expType) {
//
//					expType.printStackTrace();
//
//				} catch (NotFoundException expType) {
//
//					expType.printStackTrace();
//				} catch (WebDriverException expType) {
//
//					expType.printStackTrace();
//				} catch (Exception expType) {
//
//					expType.printStackTrace();
				} 
		      break; 
		   case "No" :
//			   try {
		   {
					WebElement we = driver.findElement(By.xpath(xpath));
		            Actions builder = new Actions(driver);
		            Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
					mouseOverHome.perform();
//				} catch (NoSuchElementException expType) {
//
//					expType.printStackTrace();
//
//				} catch (NotFoundException expType) {
//
//					expType.printStackTrace();
//				} catch (WebDriverException expType) {
//
//					expType.printStackTrace();
//				} catch (Exception expType) {
//
//					expType.printStackTrace();
				}
		      break;
		}
		}
	public void availablesc(String xpath,String condition) {
		switch(condition) {
		   case "Yes" :
//			   try {
		   {
			   		WebElement we = driver.findElement(By.xpath(xpath));
		            Actions builder = new Actions(driver);
		            Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ENTER).build();
					mouseOverHome.perform();
//				} catch (NoSuchElementException expType) {
//
//					expType.printStackTrace();
//
//				} catch (NotFoundException expType) {
//
//					expType.printStackTrace();
//				} catch (WebDriverException expType) {
//
//					expType.printStackTrace();
//				} catch (Exception expType) {
//
//					expType.printStackTrace();
				} 
		      break; 
		   case "No" :
//			   try {
		   {
					WebElement we = driver.findElement(By.xpath(xpath));
		            Actions builder = new Actions(driver);
		            Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
					mouseOverHome.perform();
//				} catch (NoSuchElementException expType) {
//
//					expType.printStackTrace();
//
//				} catch (NotFoundException expType) {
//
//					expType.printStackTrace();
//				} catch (WebDriverException expType) {
//
//					expType.printStackTrace();
//				} catch (Exception expType) {
//
//					expType.printStackTrace();
				}
		      break;
		}
		}
	@SuppressWarnings("deprecation")
	public void clickandholdByXpath(String a,String b) {
	try {
		WebElement src = driver.findElement(By.xpath(a));
		WebElement des = driver.findElement(By.xpath(b));
		Actions builder = new Actions(driver);
		Actions seriesOfActions = builder.clickAndHold(src).pause(2000).moveToElement(des).pause(5000).release(des).pause(2000);
		seriesOfActions.build().perform();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public String[][] getlogin() throws IOException {
		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(0);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][cc];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);

			for (int j = 0; j < cc; j++) {
				data[i - 1][j] = firstRow.getCell(j).getStringCellValue();
//				System.out.println(data[i - 1][j]);
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getcreatepartData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(1);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][3];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for (int j = 0; j < 3; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][j] = String.valueOf(cellValue);
				}
				else
					data[i - 1][j] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][j]);
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getIncrementalRevisionData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(1);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for (int j = 3; j < 4; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][j] = String.valueOf(cellValue);
				}
				else
					data[i - 1][0] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][0]);
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getbasicinfoData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(1);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][5];
		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<5 ; k++){

			cont:
			for (int j = 4; j < 9; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else{
					data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
			}
		}
	}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getsourcingData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(1);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][16];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<16 ; k++){
				cont:
			for (int j = 9; j < 25; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
			}
		}		
	}

		wb.close();
		fis.close();

		return data;
		
	}
	public String[][] getbillofmaterialData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(1);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][5];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<5 ; k++){
				cont:
			for (int j = 25; j < 30; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
				}
				else
				{
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] addmorebillofmaterial() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(1);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][5];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<5 ; k++){
				cont:
			for (int j = 30; j < 35; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
				}
				else
				{
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getaddmoreprobillofmaterial() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(3);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][5];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<5 ; k++){
				cont:
			for (int j = 30; j < 35; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
				}
				else
				{
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getcommentsData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(1);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<1 ; k++){
				cont:
			for (int j = 35; j < 36; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{	
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getsearchData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(1);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<1 ; k++){
				cont:
			for (int j = 36; j < 37; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{	
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getfilterData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(1);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<1 ; k++){
				cont:
			for (int j = 37; j < 38; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{	
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	
	public String[][] getCreateProduct() throws IOException {


		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(3);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][3];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for (int j = 0; j < 3; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][j] = String.valueOf(cellValue);
				}
				else
					data[i - 1][j] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][j]);
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getProIncrementalRevision() throws IOException {


		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(3);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<1 ; k++){
				cont:
			for (int j = 3; j < 4; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
						System.out.println(data[i - 1][k]);
						k++;
						continue cont;
						}
					}
				}
			}

				wb.close();
				fis.close();

				return data;
			}
		
	public String[][] getProBasicInfo() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(3);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][5];
		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<5 ; k++){

			cont:
			for (int j = 4; j < 9; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else{
					data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
			}
		}
	}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getProSourcing() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(3);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][16];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<16 ; k++){
				cont:
			for (int j = 9; j < 25; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
			}
		}		
	}

		wb.close();
		fis.close();

		return data;
		
	}
	public String[][] getProBillOfMaterial() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(3);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][5];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<5 ; k++){
				cont:
			for (int j = 25; j < 30; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getProComments() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(3);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<1 ; k++){
				cont:
			for (int j = 35; j < 36; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{	
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getprosearchData() throws IOException {
		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(3);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<1 ; k++){
				cont:
			for (int j = 36; j < 37; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{	
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getprofilterData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(3);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<1 ; k++){
				cont:
			for (int j = 37; j < 38; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{	
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getEditPartIncrementalRevision() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(2);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for (int j = 0; j < 1; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][j] = String.valueOf(cellValue);
				}
				else
					data[i - 1][0] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][0]);
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getEditPartbasicinfoData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(2);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][5];
		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<5 ; k++){

			cont:
			for (int j = 1; j < 6; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else{
					data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
			}
		}
	}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getEditPartsourcingData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(2);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][16];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<16 ; k++){
				cont:
			for (int j = 6; j < 22; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
			}
		}		
	}

		wb.close();
		fis.close();

		return data;
		
	}
	public String[][] getEditPartbillofmaterialData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(2);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][4];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<4 ; k++){
				cont:
			for (int j = 22; j < 26; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getEditPartcommentsData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(2);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<1 ; k++){
				cont:
			for (int j = 26; j < 27; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{	
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getEditProductIncrementalRevision() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(4);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for (int j = 0; j < 1; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][j] = String.valueOf(cellValue);
				}
				else
					data[i - 1][0] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][0]);
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getEditProductbasicinfoData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(4);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][5];
		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<5 ; k++){

			cont:
			for (int j = 1; j < 6; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else{
					data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
			}
		}
	}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getEditProductsourcingData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(4);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][16];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<16 ; k++){
				cont:
			for (int j = 6; j < 22; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
			}
		}		
	}

		wb.close();
		fis.close();

		return data;
		
	}
	public String[][] getEditProductbillofmaterialData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(4);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][4];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<4 ; k++){
				cont:
			for (int j = 22; j < 26; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getEditProductcommentsData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the first sheet
		XSSFSheet sheet = wb.getSheetAt(4);
		int rc = sheet.getLastRowNum();
		int cc = sheet.getRow(0).getLastCellNum();

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for(int k=0 ; k<1 ; k++){
				cont:
			for (int j = 26; j < 27; j++) {
				cellType = firstRow.getCell(j).getCellType();
				if (cellType == 0)
				{
					cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
					data[i - 1][k] = String.valueOf(cellValue);
					k++;
					continue cont;
				}
				else
				{	
				data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				System.out.println(data[i - 1][k]);
				k++;
				continue cont;
				}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}
	public String[][] getecrboardData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		 // Open the excel work sheet
  	  XSSFWorkbook wb = new XSSFWorkbook(fis);

  	  // Move control to the first sheet
  	  XSSFSheet sheet = wb.getSheetAt(5);
  	  int rc = sheet.getLastRowNum();
  	  int cc = sheet.getRow(0).getLastCellNum();

  	  String data[][] = new String[rc][7];

  	  for (int i = 1; i <= rc; i++) {

  	   // Move control to the specific row
  	   XSSFRow firstRow = sheet.getRow(i);
  	   int cellType;
  	   int cellValue;
  	   for(int k=0 ; k<7 ; k++){
  	    cont:
  	   for (int j = 0; j < 7; j++) {
  	    cellType = firstRow.getCell(j).getCellType();
  	    if (cellType == 0)
  	    {
  	     cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
  	     data[i - 1][k] = String.valueOf(cellValue);
  	     k++;
  	     continue cont;
  	    }
  	    else
  	    {
  	     data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
  	        System.out.println(data[i - 1][k]);
  	        k++;
  	        continue cont;
  	    }
  	    }
  	  }
  	  }
		wb.close();
		fis.close();

		return data;
	}
	public String[][] getsearchcommonData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		 // Open the excel work sheet
  	  XSSFWorkbook wb = new XSSFWorkbook(fis);

  	  // Move control to the first sheet
  	  XSSFSheet sheet = wb.getSheetAt(5);
  	  int rc = sheet.getLastRowNum();
  	  int cc = sheet.getRow(0).getLastCellNum();

  	  String data[][] = new String[rc][8];

  	  for (int i = 1; i <= rc; i++) {

  	   // Move control to the specific row
  	   XSSFRow firstRow = sheet.getRow(i);
  	   int cellType;
  	   int cellValue;
  	   for(int k=0 ; k<8 ; k++){
  	    cont:
  	   for (int j = 7; j <15 ; j++) {
  	    cellType = firstRow.getCell(j).getCellType();
  	    if (cellType == 0)
  	    {
  	     cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
  	     data[i - 1][k] = String.valueOf(cellValue);
  	     k++;
  	     continue cont;
  	    }
  	    else
  	    {
  	     data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
  	        System.out.println(data[i - 1][k]);
  	        k++;
  	        continue cont;
  	    }
  	    }
  	  }
  	  }
		wb.close();
		fis.close();

		return data;
	}
	public String[][] getsearchproductsData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		 // Open the excel work sheet
  	  XSSFWorkbook wb = new XSSFWorkbook(fis);

  	  // Move control to the first sheet
  	  XSSFSheet sheet = wb.getSheetAt(5);
  	  int rc = sheet.getLastRowNum();
  	  int cc = sheet.getRow(0).getLastCellNum();

  	  String data[][] = new String[rc][6];

  	  for (int i = 1; i <= rc; i++) {

  	   // Move control to the specific row
  	   XSSFRow firstRow = sheet.getRow(i);
  	   int cellType;
  	   int cellValue;
  	   for(int k=0 ; k<6 ; k++){
  	    cont:
  	   for (int j = 15; j <21 ; j++) {
  	    cellType = firstRow.getCell(j).getCellType();
  	    if (cellType == 0)
  	    {
  	     cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
  	     data[i - 1][k] = String.valueOf(cellValue);
  	     k++;
  	     continue cont;
  	    }
  	    else
  	    {
  	     data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
  	        System.out.println(data[i - 1][k]);
  	        k++;
  	        continue cont;
  	    }
  	    }
  	  }
  	  }
		wb.close();
		fis.close();

		return data;
	}
	public String[][] getecrboardcardsData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		 // Open the excel work sheet
  	  XSSFWorkbook wb = new XSSFWorkbook(fis);

  	  // Move control to the first sheet
  	  XSSFSheet sheet = wb.getSheetAt(5);
  	  int rc = sheet.getLastRowNum();
  	  int cc = sheet.getRow(0).getLastCellNum();

  	  String data[][] = new String[rc][7];

  	  for (int i = 1; i <= rc; i++) {

  	   // Move control to the specific row
  	   XSSFRow firstRow = sheet.getRow(i);
  	   int cellType;
  	   int cellValue;
  	   for(int k=0 ; k<7 ; k++){
  	    cont:
  	   for (int j = 21; j <28 ; j++) {
  	    cellType = firstRow.getCell(j).getCellType();
  	    if (cellType == 0)
  	    {
  	     cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
  	     data[i - 1][k] = String.valueOf(cellValue);
  	     k++;
  	     continue cont;
  	    }
  	    else
  	    {
  	     data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
  	        System.out.println(data[i - 1][k]);
  	        k++;
  	        continue cont;
  	    }
  	    }
  	  }
  	  }
		wb.close();
		fis.close();

		return data;
	}
	public String[][] getparteditData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		 // Open the excel work sheet
  	  XSSFWorkbook wb = new XSSFWorkbook(fis);

  	  // Move control to the first sheet
  	  XSSFSheet sheet = wb.getSheetAt(5);
  	  int rc = sheet.getLastRowNum();
  	  int cc = sheet.getRow(0).getLastCellNum();

  	  String data[][] = new String[rc][1];

  	  for (int i = 1; i <= rc; i++) {

  	   // Move control to the specific row
  	   XSSFRow firstRow = sheet.getRow(i);
  	   int cellType;
  	   int cellValue;
  	   for(int k=0 ; k<1 ; k++){
  	    cont:
  	   for (int j = 28; j <29 ; j++) {
  	    cellType = firstRow.getCell(j).getCellType();
  	    if (cellType == 0)
  	    {
  	     cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
  	     data[i - 1][k] = String.valueOf(cellValue);
  	     k++;
  	     continue cont;
  	    }
  	    else
  	    {
  	     data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
  	        System.out.println(data[i - 1][k]);
  	        k++;
  	        continue cont;
  	    }
  	    }
  	  }
  	  }
		wb.close();
		fis.close();

		return data;
	}
	public int rowCount;
	 public int columnCount;
	 public String[][] getplmbotsData() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	     // Open the excel work sheet
	       XSSFWorkbook wb = new XSSFWorkbook(fis);

	       // Move control to the first sheet
	       XSSFSheet sheet = wb.getSheetAt(9);
	       int rc = sheet.getLastRowNum();
	       int cc = sheet.getRow(0).getLastCellNum();

	       String data[][] = new String[rc][1];

	       for (int i = 1; i <= rc; i++) {

	        // Move control to the specific row
	        XSSFRow firstRow = sheet.getRow(i);
	        int cellType;
	        int cellValue;
	        for(int k=0 ; k<1 ; k++){
	         cont:
	        for (int j = 0; j <1 ; j++) {
	         cellType = firstRow.getCell(j).getCellType();
	         if (cellType == 0)
	         {
	          cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
	          data[i - 1][k] = String.valueOf(cellValue);
	          k++;
	          continue cont;
	         }
	         else
	         {
	          data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
	             System.out.println(data[i - 1][k]);
	             k++;
	             continue cont;
	         }
	         }
	       }
	       }
	    wb.close();
	    fis.close();

	    return data;
	 }
	 public String[][] getplmbotstwoData() throws IOException {
		  // Create an input stream
		    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		     // Open the excel work sheet
		       XSSFWorkbook wb = new XSSFWorkbook(fis);

		       // Move control to the first sheet
		       XSSFSheet sheet = wb.getSheetAt(9);
		       int rc = sheet.getLastRowNum();
		       int cc = sheet.getRow(0).getLastCellNum();

		       String data[][] = new String[rc][3];

		       for (int i = 1; i <= rc; i++) {


		        // Move control to the specific row
		        XSSFRow firstRow = sheet.getRow(i);
		        int cellType;
		        int cellValue;
		        for(int k=0 ; k<1 ; k++){
		         cont:
		        for (int j = 1; j <4 ; j++) {
		         cellType = firstRow.getCell(j).getCellType();
		         if (cellType == 0)
		         {
		          cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
		          data[i - 1][k] = String.valueOf(cellValue);
		          k++;
		          continue cont;
		         }
		         else
		         {
		          data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
		             System.out.println(data[i - 1][k]);
		             k++;
		             continue cont;
		         }
		         }
		       }
		       }
		    wb.close();
		    fis.close();

		    return data;
		 }

//		    	   // Move control to the specific row
//		    	     XSSFRow firstRow = sheet.getRow(i);
//		    	     int cellType;
//		    	     String cellValue = null;
//		    	     for(int k=0 ; k<3 ; k++){
//		    	      cont:
//		    	     for (int j = 1; j < 4; j++) {
//		    	      cellType = firstRow.getCell(j).getCellType();
//		    	      if (cellType == 0)
//			    	    {
//			    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
//			    	        {
//			    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
//			    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
//			    	        }
//			    	       data[i - 1][k] = String.valueOf(cellValue);
//			    	       k++;
//			    	       continue cont;
//			    	      }
//			    	      else
//			    	      {
//			    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
//			    	          System.out.println(data[i - 1][k]);
//			    	          k++;
//			    	          continue cont;
//			    	      }
//			    	      }
//			    	    }
//			    	    }
//			    	  wb.close();
//			    	  fis.close();
//			    	  return data;  
//			    	 }

	 
	 public String[][] getpetwocarddata() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(7);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][2];

			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<2 ; k++){
					cont:
				for (int j = 26; j < 28; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else
					{	
					data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
					}
				}
			}

			wb.close();
			fis.close();

			return data;
		}
		public String[][] getpeonecarddata() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(7);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][2];

			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<2 ; k++){
					cont:
				for (int j = 0; j < 2; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else
					{	
					data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
					}
				}
			}

			wb.close();
			fis.close();

			return data;
		}
	         public String[][] getpmcarddata() throws IOException {
			    	  // Create an input stream
			    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			    	    // Open the excel work sheet
			    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

			    	    // Move control to the first sheet
			    	    XSSFSheet sheet = wb.getSheetAt(7);
			    	    int rc = sheet.getLastRowNum();
			    	    int cc = sheet.getRow(0).getLastCellNum();

			    	    String data[][] = new String[rc][10];

			    	    for (int i = 1; i <= rc; i++) {

			    	     // Move control to the specific row
			    	     XSSFRow firstRow = sheet.getRow(i);
			    	     int cellType;
			    	     String cellValue = null;
			    	     for(int k=0 ; k<10 ; k++){
			    	      cont:
			    	     for (int j = 16; j < 26; j++) {
			    	      cellType = firstRow.getCell(j).getCellType();
			    	      if (cellType == 0)
				    	    {
				    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
				    	        {
				    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
				    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
				    	        }
				    	       data[i - 1][k] = String.valueOf(cellValue);
				    	       k++;
				    	       continue cont;
				    	      }
				    	      else
				    	      {
				    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				    	          System.out.println(data[i - 1][k]);
				    	          k++;
				    	          continue cont;
				    	      }
				    	      }
				    	    }
				    	    }
				    	  wb.close();
				    	  fis.close();
				    	  return data;  
				    	 }
	       public String[][] getrconecarddata() throws IOException {
			    	  // Create an input stream
			    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			    	    // Open the excel work sheet
			    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

			    	    // Move control to the first sheet
			    	    XSSFSheet sheet = wb.getSheetAt(7);
			    	    int rc = sheet.getLastRowNum();
			    	    int cc = sheet.getRow(0).getLastCellNum();

			    	    String data[][] = new String[rc][14];

			    	    for (int i = 1; i <= rc; i++) {

			    	    	// Move control to the specific row
			                XSSFRow firstRow = sheet.getRow(i);
			                int cellType;
			                String cellValue = null;
			                for(int k=0 ; k<14 ; k++){
			                 cont:
			                for (int j = 2; j < 16; j++) {
			                 cellType = firstRow.getCell(j).getCellType();
			                 if (cellType == 0)
			                {
			                 if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
			                    {
			                       SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
			                        cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
			                        System.out.println(cellValue);
			                        data[i - 1][k] = String.valueOf(cellValue);
			                     k++;
			                     continue cont;
			                    }
			                 else{
			                  int cellVal = (int)(long)firstRow.getCell(j).getNumericCellValue();
			                   data[i - 1][k] = String.valueOf(cellVal);
			                   System.out.println(cellVal);
			                     k++;
			                     continue cont;
			                     
			                 }
			                  
			                  }
			                  else
			                  {
			                   data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
			                      System.out.println(data[i - 1][k]);
			                      k++;
			                      continue cont;
			                  }
			                  }
			                }
			                }
			              wb.close();
			              fis.close();
			              
			              return data;  
			             }
	public String[][] getrctwocarddata() throws IOException {
			    	  // Create an input stream
			    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			    	    // Open the excel work sheet
			    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

			    	    // Move control to the first sheet
			    	    XSSFSheet sheet = wb.getSheetAt(7);
			    	    int rc = sheet.getLastRowNum();
			    	    int cc = sheet.getRow(0).getLastCellNum();

			    	    String data[][] = new String[rc][3];

			    	    for (int i = 1; i <= rc; i++) {

			    	     // Move control to the specific row
			    	     XSSFRow firstRow = sheet.getRow(i);
			    	     int cellType;
			    	     String cellValue = null;
			    	     for(int k=0 ; k<3 ; k++){
			    	      cont:
			    	     for (int j = 28; j < 31; j++) {
			    	      cellType = firstRow.getCell(j).getCellType();
			    	      if (cellType == 0)
				    	    {
				    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
				    	        {
				    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
				    	        }
				    	       data[i - 1][k] = String.valueOf(cellValue);
				    	       k++;
				    	       continue cont;
				    	      }
				    	      else
				    	      {
				    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				    	          System.out.println(data[i - 1][k]);
				    	          k++;
				    	          continue cont;
				    	      }
				    	      }
				    	    }
				    	    }
				    	  wb.close();
				    	  fis.close();
				    	  return data;  
				    	 }
	public String[][] getcacarddata() throws IOException {
			    	  // Create an input stream
			    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			    	    // Open the excel work sheet
			    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

			    	    // Move control to the first sheet
			    	    XSSFSheet sheet = wb.getSheetAt(7);
			    	    int rc = sheet.getLastRowNum();
			    	    int cc = sheet.getRow(0).getLastCellNum();

			    	    String data[][] = new String[rc][2];

			    	    for (int i = 1; i <= rc; i++) {

			    	     // Move control to the specific row
			    	     XSSFRow firstRow = sheet.getRow(i);
			    	     int cellType;
			    	     String cellValue = null;
			    	     for(int k=0 ; k<2 ; k++){
			    	      cont:
			    	     for (int j = 31; j < 33; j++) {
			    	      cellType = firstRow.getCell(j).getCellType();
			    	      if (cellType == 0)
				    	    {
				    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
				    	        {
				    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
				    	        }
				    	       data[i - 1][k] = String.valueOf(cellValue);
				    	       k++;
				    	       continue cont;
				    	      }
				    	      else
				    	      {
				    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				    	          System.out.println(data[i - 1][k]);
				    	          k++;
				    	          continue cont;
				    	      }
				    	      }
				    	    }
				    	    }
				    	  wb.close();
				    	  fis.close();
				    	  return data;  
				    	 }
	 public String[][] cardl() throws IOException {
			    	  // Create an input stream
			    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			    	    // Open the excel work sheet
			    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

			    	    // Move control to the first sheet
			    	    XSSFSheet sheet = wb.getSheetAt(7);
			    	    int rc = sheet.getLastRowNum();
			    	    int cc = sheet.getRow(0).getLastCellNum();

			    	    String data[][] = new String[rc][3];

			    	    for (int i = 1; i <= rc; i++) {

			    	     // Move control to the specific row
			    	     XSSFRow firstRow = sheet.getRow(i);
			    	     int cellType;
			    	     String cellValue = null;
			    	     for(int k=0 ; k<3 ; k++){
			    	      cont:
			    	     for (int j = 33; j < 36; j++) {
			    	      cellType = firstRow.getCell(j).getCellType();
			    	      if (cellType == 0)
				    	    {
				    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
				    	        {
				    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
				    	        }
				    	       data[i - 1][k] = String.valueOf(cellValue);
				    	       k++;
				    	       continue cont;
				    	      }
				    	      else
				    	      {
				    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
				    	          System.out.println(data[i - 1][k]);
				    	          k++;
				    	          continue cont;
				    	      }
				    	      }
				    	    }
				    	    }
				    	  wb.close();
				    	  fis.close();
				    	  return data;  
				    	 }

	 
	 // Changes
	 //For selecting document category
	 public void clickDocCategoryByXpath(String xpath, String Cate) {
			switch (Cate) {
			case "CAD Files":
				try {
					WebElement we = driver.findElement(By.xpath(xpath));
					Actions builder = new Actions(driver);
					Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ENTER).build();
					mouseOverHome.perform();

				} catch (Exception e) {
					System.out.println("Not able to recognize Webelement " + xpath + " here");
				}
				break;
			case "Electronics Design Files":
				try {
					WebElement we = driver.findElement(By.xpath(xpath));
					Actions builder = new Actions(driver);
					Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
					mouseOverHome.perform();

				} catch (Exception e) {
					System.out.println("Not able to recognize Webelement " + xpath + " here");
				}
				break;

			case "Engineering Drawings":
				try {
					WebElement we = driver.findElement(By.xpath(xpath));
					Actions builder = new Actions(driver);
					Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
							.build();
					mouseOverHome.perform();

				} catch (Exception e) {
					System.out.println("Not able to recognize Webelement " + xpath + " here");
				}
				break;
			case "General Documents":
				try {
					WebElement we = driver.findElement(By.xpath(xpath));
					Actions builder = new Actions(driver);
					Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
							.sendKeys(Keys.ENTER).build();
					mouseOverHome.perform();

				} catch (Exception e) {
					System.out.println("Not able to recognize Webelement " + xpath + " here");
				}
				break;
			case "Specifications":
				try {
					WebElement we = driver.findElement(By.xpath(xpath));
					Actions builder = new Actions(driver);
					Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
							.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
					mouseOverHome.perform();

				} catch (Exception e) {
					System.out.println("Not able to recognize Webelement " + xpath + " here");
				}
				break;
				}
		}
	 
	 public String[][] getdocumentsData() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(10);
			int rc = sheet.getLastRowNum();
			System.out.println(rc);
			int cc = sheet.getRow(0).getLastCellNum();
			System.out.println(cc);

			String data[][] = new String[rc][3];

			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for (int j = 0; j < 3; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0) {
						cellValue = (int) (long) firstRow.getCell(j).getNumericCellValue();
						data[i - 1][j] = String.valueOf(cellValue);
					} else
						data[i - 1][j] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][j]);
				}
			}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1 ; k++){

				cont:
				for (int j = 0; j < 1; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartCategoryName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 1; j < 2; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartRevisionNote() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 2; j < 3; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartIncrementalRevision() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 3; j < 4; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartDescriptioninBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 4; j < 5; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartUnitMeasureinBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 5; j < 6; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartProtypeinBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 6; j < 7; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartProjnameinBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 7; j < 8; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartTagsinBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 8; j < 9; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartInternalTrackingNumberinAttachments() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 9; j < 10; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsFirstComments() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 10; j < 11; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsSecondComments() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 11; j < 12; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] PartManufacturerNameInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 12; j < 13; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] PartManufacturerPartNumberInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 13; j < 14; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] PartManufacturerDescriptionInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 14; j < 15; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] PartManufacturerCostInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 15; j < 16; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] PartManufacturerCurrencyInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 16; j < 17; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartManufacturerApprovedInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 17; j < 18; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartManufacturerAvailableInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 18; j < 19; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] PartSupplierNameInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 19; j < 20; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] PartSupplierPartNumberInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 20; j < 21; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	
	 public String[][] PartManufacturerNameSuppInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 21; j < 22; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}		 
	 public String[][] PartManufacturerPartNumberSuppInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 22; j < 23; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	
	 public String[][] PartSupplierDescriptionInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 23; j < 24; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] PartSupplierCostInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 24; j < 25; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartSupplierCurrencyInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 25; j < 26; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartSupplierApprovedInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 26; j < 27; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartSupplierAvailableInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 27; j < 28; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EnterPart2Name() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 28; j < 29; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EnterPart2CategoryName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 29; j < 30; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EnterPart2RevisionNote() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 30; j < 31; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] Part2InternalTrackingNumber() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 31; j < 32; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EnterPart3Name() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 32; j < 33; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EnterPart3CategoryName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 33; j < 34; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EnterPart3RevisionNote() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 34; j < 35; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EnterPart4Name() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 35; j < 36; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EnterPart4CategoryName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 36; j < 37; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EnterPart4RevisionNote() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 37; j < 38; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 38; j < 39; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsLocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 39; j < 40; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsRefInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 40; j < 41; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 41; j < 42; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsChangeQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 42; j < 43; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 43; j < 44; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsAddExistingPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 44; j < 45; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsAnotherPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 45; j < 46; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsAnotherLocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 46; j < 47; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsAnotherQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 47; j < 48; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsAnotherBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 48; j < 49; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsDelPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 49; j < 50; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsDelLocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 50; j < 51; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsDelRefInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 51; j < 52; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsDelQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 52; j < 53; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsDelBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 53; j < 54; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsSearch() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 54; j < 55; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsFirstFilter() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 55; j < 56; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartsSecondFilter() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(1);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 56; j < 57; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartsIncrementalRevision() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1 ; k++){

				cont:
				for (int j = 0; j < 1; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartDescriptioninBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 1; j < 2; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartUnitMeasureinBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 2; j < 3; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartProtypeinBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 3; j < 4; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartProjnameinBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 4; j < 5; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartTagsinBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 5; j < 6; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartInternalTrackingNumberinAttachments() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 6; j < 7; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartManufacturerNameInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 7; j < 8; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartManufacturerPartNumberInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 8; j < 9; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartManufacturerDescriptionInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 9; j < 10; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartManufacturerCostInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 10; j < 11; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartManufacturerCurrencyInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 11; j < 12; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditPartManufacturerApprovedInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 12; j < 13; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditPartManufacturerAvailableInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 13; j < 14; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditPartSupplierNameInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 14; j < 15; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditPartSupplierPartNumberInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 15; j < 16; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditPartManufacturerNameSuppInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 16; j < 17; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartManufacturerPartNumberSuppInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 17; j < 18; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartSupplierDescriptionInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 18; j < 19; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditPartSupplierCostInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 19; j < 20; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditPartSupplierCurrencyInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 20; j < 21; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	
	 public String[][] EditPartSupplierApprovedInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 21; j < 22; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}		 
	 public String[][] EditPartSupplierAvailableInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 22; j < 23; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	
	 public String[][] EditPartsPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 23; j < 24; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditPartsLocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 24; j < 25; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartsRefInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 25; j < 26; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartsQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 26; j < 27; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartsBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 27; j < 28; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartsExistingPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 28; j < 29; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartsAnotherPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 29; j < 30; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartsAnotherLocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 30; j < 31; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartsAnotherRefInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 31; j < 32; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartsAnotherQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 32; j < 33; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartsAnotherBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 33; j < 34; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartsComments() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 34; j < 35; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
		 public String[][] ProductsSearch() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 38; j < 39; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsFilter() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 39; j < 40; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1 ; k++){

				cont:
				for (int j = 0; j < 1; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductCategoryName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 1; j < 2; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductRevisionNote() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 2; j < 3; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsDescriptionInBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 3; j < 4; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductUnitMeasureInBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 4; j < 5; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductProtypeInBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 5; j < 6; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductProjnameInBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 6; j < 7; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductTagsInBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 7; j < 8; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductInternalTrackingNumberinAttachments() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 8; j < 9; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductFirstComments() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 9; j < 10; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductSecondComments() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 10; j < 11; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EnterProduct2Name() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 11; j < 12; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EnterProduct2CategoryName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 12; j < 13; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EnterProduct2RevisionNote() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 13; j < 14; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] Product2InternalTrackingNumber() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 14; j < 15; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] ProductPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 15; j < 16; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] ProductLocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 16; j < 17; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductRefInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 17; j < 18; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 18; j < 19; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] ProductBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 19; j < 20; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] ProductAddExistingPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 20; j < 21; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	
	 public String[][] ProductAnotherPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 21; j < 22; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}		 
	 public String[][] ProductAnotherLocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 22; j < 23; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	
	 public String[][] ProductAnotherQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 23; j < 24; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] ProductAnotherBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 24; j < 25; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductAnother1PartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 25; j < 26; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductAnother1LocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 26; j < 27; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductAnother1QuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 27; j < 28; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductAnother1BOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 28; j < 29; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductIncrementalRevision() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 29; j < 30; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 30; j < 31; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsExistingPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 31; j < 32; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsAnotherPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 32; j < 33; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsAnotherLocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 33; j < 34; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsAnotherRefInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 34; j < 35; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsAnotherQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 35; j < 36; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsAnotherBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 36; j < 37; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsComments() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(2);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 37; j < 38; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductIncrementalRevision() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1 ; k++){

				cont:
				for (int j = 0; j < 1; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductDescriptioninBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 1; j < 2; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductUnitMeasureinBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 2; j < 3; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductProtypeinBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 3; j < 4; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductProjnameinBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 4; j < 5; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductTagsinBasicInfo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 5; j < 6; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductInternalTrackingNumberinAttachments() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 6; j < 7; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductManufacturerNameInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 7; j < 8; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductManufacturerPartNumberInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 8; j < 9; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProducftManufacturerDescriptionInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 9; j < 10; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductManufacturerCostInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 10; j < 11; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductManufacturerCurrencyInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 11; j < 12; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditProductManufacturerApprovedInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 12; j < 13; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditProductManufacturerAvailableInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 13; j < 14; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditProductSupplierNameInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 14; j < 15; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditProductSupplierPartNumberInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 15; j < 16; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditProductManufacturerNameSuppInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 16; j < 17; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductManufacturerPartNumberSuppInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 17; j < 18; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductSupplierDescriptionInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 18; j < 19; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditProductSupplierCostInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 19; j < 20; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditProductSupplierCurrencyInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 20; j < 21; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	
	 public String[][] EditProductSupplierApprovedInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 21; j < 22; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}		 
	 public String[][] EditProductSupplierAvailableInSourcing() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 22; j < 23; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	
	 public String[][] EditProductsPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 23; j < 24; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditProductsLocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 24; j < 25; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductsRefInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 25; j < 26; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductsQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 26; j < 27; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductsBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 27; j < 28; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductsExistingPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 28; j < 29; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductsAnotherPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 29; j < 30; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductsAnotherLocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 30; j < 31; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductsAnotherRefInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 31; j < 32; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductsAnotherQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 32; j < 33; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductsAnotherBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 33; j < 34; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditProductsComments() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(4);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 34; j < 35; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductSearch() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1 ; k++){

				cont:
				for (int j = 0; j < 1; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductBasicInfoProductName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 1; j < 2; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductBasicInfoProjectName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 2; j < 3; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductIncrementalRevisionNotes() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 3; j < 4; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartstoSearch() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 4; j < 5; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartBasicInfoPartName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 5; j < 6; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartBasicInfoProjectName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 6; j < 7; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] PartIncrementalRevisionNotes() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 7; j < 8; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ECRCardName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 8; j < 9; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ECRAddAffectedObjectsone() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 9; j < 10; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ECRAddAffectedObjectstwo() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 10; j < 11; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ECRAddAffectedObjectsThree() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 11; j < 12; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] SearchParts() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 12; j < 13; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] ECRAddPartAddAffectedObjects() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 13; j < 14; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] ECRTaskOneName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 14; j < 15; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] ECRTaskProjectManager() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 15; j < 16; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] ECRTaskTwoName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 16; j < 17; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ECRTaskReleaseCoordinator() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 17; j < 18; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] SearchKeywordFirst() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 18; j < 19; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] SearchPartsKeyword() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 19; j < 20; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] SearchUpdateRefinBOM() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 20; j < 21; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	
	 public String[][] SearchUpdateQuantityinBOM() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 21; j < 22; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}		 
	 public String[][] SRPartsAnotherPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 22; j < 23; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	
	 public String[][] SRPartsAnotherLocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 23; j < 24; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] SRPartsAnotherRefInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 24; j < 25; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] SRPartsAnotherQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 25; j < 26; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] SRPartsAnotherBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 26; j < 27; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] SearchProductKeyword() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 27; j < 28; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] SRProductsAnotherPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 28; j < 29; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] SRProductsAnotherLocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 29; j < 30; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] SRProductsAnotherRefInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 30; j < 31; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] SRProductsAnotherQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 31; j < 32; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] SRProductsAnotherBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 32; j < 33; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsAddAnotherPartNumberInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 33; j < 34; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsAddAnotherLocationInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 34; j < 35; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsAddAnotherRefInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1 ; k++){

				cont:
				for (int j = 35; j < 36; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsAddAnotherQuantityInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 36; j < 37; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ProductsAddAnotherBOMNotesInBillofMaterial() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 37; j < 38; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ECOCardName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 38; j < 39; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ECOBoardObjectOneAffectedObjects() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 39; j < 40; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ECOBoardObjectTwoAffectedObjects() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 40; j < 41; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ECOBoardObjectThreeAffectedObjects() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 41; j < 42; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ECOBoardProductAffectedObjects() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 42; j < 43; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] SRSearchParts() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 43; j < 44; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ECOObjectOneAddAffectedObjects() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 44; j < 45; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ECOTaskOneName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 45; j < 46; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] ECOAssignProjectManager() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 46; j < 47; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] ECOTaskTwoName() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 47; j < 48; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] ECOAssignReleaseCoordinator() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 48; j < 49; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] PartsEnterDescriptioninBasicInfofromECO() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(3);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 49; j < 50; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditPartsRefInBillofMaterialfromECO() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(5);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 50; j < 51; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}	 
	 public String[][] EditPartsQuantityInBillofMaterialfromECO() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(5);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 51; j < 52; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	 public String[][] EditPartsBOMNotesInBillofMaterialfromECO() throws IOException {

			// Create an input stream
			FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

			// Open the excel work sheet
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Move control to the first sheet
			XSSFSheet sheet = wb.getSheetAt(5);
			int rc = sheet.getLastRowNum();
			int cc = sheet.getRow(0).getLastCellNum();

			String data[][] = new String[rc][1];
			for (int i = 1; i <= rc; i++) {

				// Move control to the specific row
				XSSFRow firstRow = sheet.getRow(i);
				int cellType;
				int cellValue;
				for(int k=0 ; k<1; k++){

				cont:
				for (int j = 52; j < 53; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0)
					{
						cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					}
					else{
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
					System.out.println(data[i - 1][k]);
					k++;
					continue cont;
					}
				}
			}
		}

			wb.close();
			fis.close();

			return data;
		}
	///////////////////////Task//////////////////////////////
	  public String[][] enterPeTitle() throws IOException {

    	  // Create an input stream
    	  FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

    	  // Open the excel work sheet
    	  XSSFWorkbook wb = new XSSFWorkbook(fis);

    	  // Move control to the first sheet
    	  XSSFSheet sheet = wb.getSheetAt(4);
    	  int rc = sheet.getLastRowNum();
    	  int cc = sheet.getRow(0).getLastCellNum();

    	  String data[][] = new String[rc][1];

    	  for (int i = 1; i <= rc; i++) {

    	   // Move control to the specific row
    	   XSSFRow firstRow = sheet.getRow(i);
    	   int cellType;
    	   String cellValue = null;
    	   for(int k=0 ; k<1 ; k++){
    	    cont:
    	   for (int j = 0; j < 1; j++) {
    	    cellType = firstRow.getCell(j).getCellType();
    	    if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();

    	  return data;
    	  
    	   
    	 }

	 public String[][] enterPeStartDate() throws IOException {
    	  // Create an input stream
    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

    	    // Open the excel work sheet
    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

    	    // Move control to the first sheet
    	    XSSFSheet sheet = wb.getSheetAt(4);
    	    int rc = sheet.getLastRowNum();
    	    int cc = sheet.getRow(0).getLastCellNum();

    	    String data[][] = new String[rc][1];

    	    for (int i = 1; i <= rc; i++) {

    	     // Move control to the specific row
    	     XSSFRow firstRow = sheet.getRow(i);
    	     int cellType;
    	     String cellValue = null;
    	     for(int k=0 ; k<1 ; k++){
    	      cont:
    	     for (int j = 1; j < 2; j++) {
    	      cellType = firstRow.getCell(j).getCellType();
    	      if (cellType == 0)
	    	    {
	    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
	    	        {
	    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
	    	        }
	    	       data[i - 1][k] = String.valueOf(cellValue);
	    	       k++;
	    	       continue cont;
	    	      }
	    	      else
	    	      {
	    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
	    	          System.out.println(data[i - 1][k]);
	    	          k++;
	    	          continue cont;
	    	      }
	    	      }
	    	    }
	    	    }
	    	  wb.close();
	    	  fis.close();
	    	  return data;  
	    	 }
    public String[][] enterPeEndDate() throws IOException {
    	  // Create an input stream
    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

    	    // Open the excel work sheet
    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

    	    // Move control to the first sheet
    	    XSSFSheet sheet = wb.getSheetAt(4);
    	    int rc = sheet.getLastRowNum();
    	    int cc = sheet.getRow(0).getLastCellNum();

    	    String data[][] = new String[rc][1];

    	    for (int i = 1; i <= rc; i++) {

    	     // Move control to the specific row
    	     XSSFRow firstRow = sheet.getRow(i);
    	     int cellType;
    	     String cellValue = null;
    	     for(int k=0 ; k<1 ; k++){
    	      cont:
    	     for (int j = 2; j < 3; j++) {
    	      cellType = firstRow.getCell(j).getCellType();
    	      if (cellType == 0)
	    	    {
	    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
	    	        {
	    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
	    	        }
	    	       data[i - 1][k] = String.valueOf(cellValue);
	    	       k++;
	    	       continue cont;
	    	      }
	    	      else
	    	      {
	    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
	    	          System.out.println(data[i - 1][k]);
	    	          k++;
	    	          continue cont;
	    	      }
	    	      }
	    	    }
	    	    }
	    	  wb.close();
	    	  fis.close();

	    	  return data;  
	    	 }
	public String[][] enterPmTitle() throws IOException {

    	  // Create an input stream
    	  FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

    	  // Open the excel work sheet
    	  XSSFWorkbook wb = new XSSFWorkbook(fis);

    	  // Move control to the first sheet
    	  XSSFSheet sheet = wb.getSheetAt(4);
    	  int rc = sheet.getLastRowNum();
    	  int cc = sheet.getRow(0).getLastCellNum();

    	  String data[][] = new String[rc][1];

    	  for (int i = 1; i <= rc; i++) {

    	   // Move control to the specific row
    	   XSSFRow firstRow = sheet.getRow(i);
    	   int cellType;
    	   String cellValue = null;
    	   for(int k=0 ; k<1 ; k++){
    	    cont:
    	   for (int j = 3; j < 4; j++) {
    	    cellType = firstRow.getCell(j).getCellType();
    	    if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();

    	  return data;
    	  
    	   
    	 }

public String[][] enterPmStartDate() throws IOException {

    	  // Create an input stream
    	  FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

    	  // Open the excel work sheet
    	  XSSFWorkbook wb = new XSSFWorkbook(fis);

    	  // Move control to the first sheet
    	  XSSFSheet sheet = wb.getSheetAt(4);
    	  int rc = sheet.getLastRowNum();
    	  int cc = sheet.getRow(0).getLastCellNum();

    	  String data[][] = new String[rc][1];

    	  for (int i = 1; i <= rc; i++) {

    	   // Move control to the specific row
    	   XSSFRow firstRow = sheet.getRow(i);
    	   int cellType;
    	   String cellValue = null;
    	   for(int k=0 ; k<1 ; k++){
    	    cont:
    	   for (int j = 4; j < 5; j++) {
    	    cellType = firstRow.getCell(j).getCellType();
    	    if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();

    	  return data;
    	  
    	   
    	 }
	public String[][] enterPmEndDate() throws IOException {

    	  // Create an input stream
    	  FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

    	  // Open the excel work sheet
    	  XSSFWorkbook wb = new XSSFWorkbook(fis);

    	  // Move control to the first sheet
    	  XSSFSheet sheet = wb.getSheetAt(4);
    	  int rc = sheet.getLastRowNum();
    	  int cc = sheet.getRow(0).getLastCellNum();

    	  String data[][] = new String[rc][1];

    	  for (int i = 1; i <= rc; i++) {

    	   // Move control to the specific row
    	   XSSFRow firstRow = sheet.getRow(i);
    	   int cellType;
    	   String cellValue = null;
    	   for(int k=0 ; k<1 ; k++){
    	    cont:
    	   for (int j = 5; j < 6; j++) {
    	    cellType = firstRow.getCell(j).getCellType();
    	    if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();

    	  return data;
    	  
    	   
    	 }
public String[][] addReleaseCoordinator() throws IOException {

    	  // Create an input stream
    	  FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

    	  // Open the excel work sheet
    	  XSSFWorkbook wb = new XSSFWorkbook(fis);

    	  // Move control to the first sheet
    	  XSSFSheet sheet = wb.getSheetAt(4);
    	  int rc = sheet.getLastRowNum();
    	  int cc = sheet.getRow(0).getLastCellNum();

    	  String data[][] = new String[rc][1];

    	  for (int i = 1; i <= rc; i++) {

    	   // Move control to the specific row
    	   XSSFRow firstRow = sheet.getRow(i);
    	   int cellType;
    	   String cellValue = null;
    	   for(int k=0 ; k<1 ; k++){
    	    cont:
    	   for (int j = 6; j < 7; j++) {
    	    cellType = firstRow.getCell(j).getCellType();
    	    if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();

    	  return data;
    	  
    	   
    	 }
public String[][] enterReleaseCoordinatorTitle() throws IOException {

    	  // Create an input stream
    	  FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

    	  // Open the excel work sheet
    	  XSSFWorkbook wb = new XSSFWorkbook(fis);

    	  // Move control to the first sheet
    	  XSSFSheet sheet = wb.getSheetAt(4);
    	  int rc = sheet.getLastRowNum();
    	  int cc = sheet.getRow(0).getLastCellNum();

    	  String data[][] = new String[rc][1];

    	  for (int i = 1; i <= rc; i++) {

    	   // Move control to the specific row
    	   XSSFRow firstRow = sheet.getRow(i);
    	   int cellType;
    	   String cellValue = null;
    	   for(int k=0 ; k<1 ; k++){
    	    cont:
    	   for (int j = 7; j < 8; j++) {
    	    cellType = firstRow.getCell(j).getCellType();
    	    if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();

    	  return data;
    	  
    	   
    	 }
public String[][] enterRcStartDate() throws IOException {

    	  // Create an input stream
    	  FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

    	  // Open the excel work sheet
    	  XSSFWorkbook wb = new XSSFWorkbook(fis);

    	  // Move control to the first sheet
    	  XSSFSheet sheet = wb.getSheetAt(4);
    	  int rc = sheet.getLastRowNum();
    	  int cc = sheet.getRow(0).getLastCellNum();

    	  String data[][] = new String[rc][1];

    	  for (int i = 1; i <= rc; i++) {

    	   // Move control to the specific row
    	   XSSFRow firstRow = sheet.getRow(i);
    	   int cellType;
    	   String cellValue = null;
    	   for(int k=0 ; k<1 ; k++){
    	    cont:
    	   for (int j = 8; j < 9; j++) {
    	    cellType = firstRow.getCell(j).getCellType();
    	    if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();

    	  return data;
    	  
    	   
    	 }
public String[][] enterRcEndDate() throws IOException {

    	  // Create an input stream
    	  FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

    	  // Open the excel work sheet
    	  XSSFWorkbook wb = new XSSFWorkbook(fis);

    	  // Move control to the first sheet
    	  XSSFSheet sheet = wb.getSheetAt(4);
    	  int rc = sheet.getLastRowNum();
    	  int cc = sheet.getRow(0).getLastCellNum();

    	  String data[][] = new String[rc][1];

    	  for (int i = 1; i <= rc; i++) {

    	   // Move control to the specific row
    	   XSSFRow firstRow = sheet.getRow(i);
    	   int cellType;
    	   String cellValue = null;
    	   for(int k=0 ; k<1 ; k++){
    	    cont:
    	   for (int j = 9; j < 10; j++) {
    	    cellType = firstRow.getCell(j).getCellType();
    	    if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();

    	  return data;
    	  
    	   
    	 }
public String[][] addProjectManager() throws IOException {

    	  // Create an input stream
    	  FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

    	  // Open the excel work sheet
    	  XSSFWorkbook wb = new XSSFWorkbook(fis);

    	  // Move control to the first sheet
    	  XSSFSheet sheet = wb.getSheetAt(4);
    	  int rc = sheet.getLastRowNum();
    	  int cc = sheet.getRow(0).getLastCellNum();

    	  String data[][] = new String[rc][1];

    	  for (int i = 1; i <= rc; i++) {

    	   // Move control to the specific row
    	   XSSFRow firstRow = sheet.getRow(i);
    	   int cellType;
    	   String cellValue = null;
    	   for(int k=0 ; k<1 ; k++){
    	    cont:
    	   for (int j = 10; j < 11; j++) {
    	    cellType = firstRow.getCell(j).getCellType();
    	    if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();

    	  return data;
    	  
    	   
    	 }
////////////////////////////////////////////////////////////////////PLM BOTS//////////////////////////////////////////////
public String[][] showCard() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	     // Open the excel work sheet
	       XSSFWorkbook wb = new XSSFWorkbook(fis);

	       // Move control to the first sheet
	       XSSFSheet sheet = wb.getSheetAt(6);
	       int rc = sheet.getLastRowNum();
	       int cc = sheet.getRow(0).getLastCellNum();

	       String data[][] = new String[rc][1];

	       for (int i = 1; i <= rc; i++) {

	        // Move control to the specific row
	        XSSFRow firstRow = sheet.getRow(i);
	        int cellType;
	        int cellValue;
	        for(int k=0 ; k<1 ; k++){
	         cont:
	        for (int j = 0; j <1 ; j++) {
	         cellType = firstRow.getCell(j).getCellType();
	         if (cellType == 0)
	         {
	          cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
	          data[i - 1][k] = String.valueOf(cellValue);
	          k++;
	          continue cont;
	         }
	         else
	         {
	          data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
	             System.out.println(data[i - 1][k]);
	             k++;
	             continue cont;
	         }
	         }
	       }
	       }
	    wb.close();
	    fis.close();

	    return data;
	 }
public String[][] createCard() throws IOException {
		  // Create an input stream
		    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		     // Open the excel work sheet
		       XSSFWorkbook wb = new XSSFWorkbook(fis);

		       // Move control to the first sheet
		       XSSFSheet sheet = wb.getSheetAt(6);
		       int rc = sheet.getLastRowNum();
		       int cc = sheet.getRow(0).getLastCellNum();

		       String data[][] = new String[rc][1];

		       for (int i = 1; i <= rc; i++) {
		    	   
		    	// Move control to the specific row
		    	     XSSFRow firstRow = sheet.getRow(i);
		    	     int cellType;
		    	     String cellValue = null;
		    	     for(int k=0 ; k<1 ; k++){
		    	      cont:
		    	     for (int j = 1; j < 2; j++) {
		    	      cellType = firstRow.getCell(j).getCellType();
		    	      if (cellType == 0)
			    	    {
			    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
			    	        {
			    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
			    	        }
			    	       data[i - 1][k] = String.valueOf(cellValue);
			    	       k++;
			    	       continue cont;
			    	      }
			    	      else
			    	      {
			    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
			    	          System.out.println(data[i - 1][k]);
			    	          k++;
			    	          continue cont;
			    	      }
			    	      }
			    	    }
			    	    }
			    	  wb.close();
			    	  fis.close();
			    	  return data;	
	 }
public String[][] cardName() throws IOException {
		  // Create an input stream
		    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		     // Open the excel work sheet
		       XSSFWorkbook wb = new XSSFWorkbook(fis);

		       // Move control to the first sheet
		       XSSFSheet sheet = wb.getSheetAt(6);
		       int rc = sheet.getLastRowNum();
		       int cc = sheet.getRow(0).getLastCellNum();

		       String data[][] = new String[rc][1];

		       for (int i = 1; i <= rc; i++) {
		    	   
		    	// Move control to the specific row
		    	     XSSFRow firstRow = sheet.getRow(i);
		    	     int cellType;
		    	     String cellValue = null;
		    	     for(int k=0 ; k<1 ; k++){
		    	      cont:
		    	     for (int j = 2; j < 3; j++) {
		    	      cellType = firstRow.getCell(j).getCellType();
		    	      if (cellType == 0)
			    	    {
			    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
			    	        {
			    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
			    	        }
			    	       data[i - 1][k] = String.valueOf(cellValue);
			    	       k++;
			    	       continue cont;
			    	      }
			    	      else
			    	      {
			    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
			    	          System.out.println(data[i - 1][k]);
			    	          k++;
			    	          continue cont;
			    	      }
			    	      }
			    	    }
			    	    }
			    	  wb.close();
			    	  fis.close();
			    	  return data;	
	 }
public String[][] dueDate() throws IOException {
		  // Create an input stream
		    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		     // Open the excel work sheet
		       XSSFWorkbook wb = new XSSFWorkbook(fis);

		       // Move control to the first sheet
		       XSSFSheet sheet = wb.getSheetAt(6);
		       int rc = sheet.getLastRowNum();
		       int cc = sheet.getRow(0).getLastCellNum();

		       String data[][] = new String[rc][1];

		       for (int i = 1; i <= rc; i++) {
		    	   
		    	// Move control to the specific row
		    	     XSSFRow firstRow = sheet.getRow(i);
		    	     int cellType;
		    	     String cellValue = null;
		    	     for(int k=0 ; k<1 ; k++){
		    	      cont:
		    	     for (int j = 3; j < 4; j++) {
		    	      cellType = firstRow.getCell(j).getCellType();
		    	      if (cellType == 0)
			    	    {
			    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
			    	        {
			    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
			    	        }
			    	       data[i - 1][k] = String.valueOf(cellValue);
			    	       k++;
			    	       continue cont;
			    	      }
			    	      else
			    	      {
			    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
			    	          System.out.println(data[i - 1][k]);
			    	          k++;
			    	          continue cont;
			    	      }
			    	      }
			    	    }
			    	    }
			    	  wb.close();
			    	  fis.close();
			    	  return data;	
	 }
///////////////////////////////////////////Cards/////////////////////////////////////////////////
public String[][] enterPeCardTitle() throws IOException {

	// Create an input stream
	FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	// Open the excel work sheet
	XSSFWorkbook wb = new XSSFWorkbook(fis);

	// Move control to the first sheet
	XSSFSheet sheet = wb.getSheetAt(5);
	int rc = sheet.getLastRowNum();
	int cc = sheet.getRow(0).getLastCellNum();

	String data[][] = new String[rc][1];

	for (int i = 1; i <= rc; i++) {

		// Move control to the specific row
		XSSFRow firstRow = sheet.getRow(i);
		int cellType;
		int cellValue;
		for(int k=0 ; k<1 ; k++){
			cont:
		for (int j = 0; j < 1; j++) {
			cellType = firstRow.getCell(j).getCellType();
			if (cellType == 0)
			{
				cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
				data[i - 1][k] = String.valueOf(cellValue);
				k++;
				continue cont;
			}
			else
			{	
			data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
			System.out.println(data[i - 1][k]);
			k++;
			continue cont;
			}
			}
		}
	}

	wb.close();
	fis.close();

	return data;
}
public String[][] addCardOwner() throws IOException {

	// Create an input stream
	FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	// Open the excel work sheet
	XSSFWorkbook wb = new XSSFWorkbook(fis);

	// Move control to the first sheet
	XSSFSheet sheet = wb.getSheetAt(5);
	int rc = sheet.getLastRowNum();
	int cc = sheet.getRow(0).getLastCellNum();

	String data[][] = new String[rc][1];

	for (int i = 1; i <= rc; i++) {

		// Move control to the specific row
		XSSFRow firstRow = sheet.getRow(i);
		int cellType;
		int cellValue;
		for(int k=0 ; k<1 ; k++){
			cont:
		for (int j = 1; j < 2; j++) {
			cellType = firstRow.getCell(j).getCellType();
			if (cellType == 0)
			{
				cellValue = (int)(long)firstRow.getCell(j).getNumericCellValue();
				data[i - 1][k] = String.valueOf(cellValue);
				k++;
				continue cont;
			}
			else
			{	
			data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
			System.out.println(data[i - 1][k]);
			k++;
			continue cont;
			}
			}
		}
	}

	wb.close();
	fis.close();

	return data;
}
public String[][] enterRcDueDate() throws IOException {
	    	  // Create an input stream
	    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    	    // Open the excel work sheet
	    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    	 // Move control to the first sheet
	    	    XSSFSheet sheet = wb.getSheetAt(5);
	    	    int rc = sheet.getLastRowNum();
	    	    int cc = sheet.getRow(0).getLastCellNum();

	    	    String data[][] = new String[rc][1];

	    	    for (int i = 1; i <= rc; i++) {

	    	     // Move control to the specific row
	    	     XSSFRow firstRow = sheet.getRow(i);
	    	     int cellType;
	    	     String cellValue = null;
	    	     for(int k=0 ; k<1 ; k++){
	    	      cont:
	    	     for (int j = 2; j < 3; j++) {
	    	      cellType = firstRow.getCell(j).getCellType();
	    	      if (cellType == 0)
		    	    {
		    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
		    	        {
		    	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
		    	        }
		    	       data[i - 1][k] = String.valueOf(cellValue);
		    	       k++;
		    	       continue cont;
		    	      }
		    	      else
		    	      {
		    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
		    	          System.out.println(data[i - 1][k]);
		    	          k++;
		    	          continue cont;
		    	      }
		    	      }
		    	    }
		    	    }
		    	  wb.close();
		    	  fis.close();
		    	  return data;  
		    	 }
public String[][] enterReleaseCoordDesc() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	 // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 3; j < 4; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
  	    {
  	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
  	        {
  	           SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
  	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
  	        }
  	       data[i - 1][k] = String.valueOf(cellValue);
  	       k++;
  	       continue cont;
  	      }
  	      else
  	      {
  	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
  	          System.out.println(data[i - 1][k]);
  	          k++;
  	          continue cont;
  	      }
  	      }
  	    }
  	    }
  	  wb.close();
  	  fis.close();
  	  return data;  
  	 }
public String[][] enterRcAffObjNumber() throws IOException {
	    	  // Create an input stream
	    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    	    // Open the excel work sheet
	    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    	    // Move control to the first sheet
	    	    XSSFSheet sheet = wb.getSheetAt(5);
	    	    int rc = sheet.getLastRowNum();
	    	    int cc = sheet.getRow(0).getLastCellNum();

	    	    String data[][] = new String[rc][1];

	    	    for (int i = 1; i <= rc; i++) {

	    	    	// Move control to the specific row
	                XSSFRow firstRow = sheet.getRow(i);
	                int cellType;
	                String cellValue = null;
	                for(int k=0 ; k<1 ; k++){
	                 cont:
	                for (int j = 4; j < 5; j++) {
	                 cellType = firstRow.getCell(j).getCellType();
	                 if (cellType == 0)
	                {
	                 if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
	                    {
	                       SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	                        cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
	                        System.out.println(cellValue);
	                        data[i - 1][k] = String.valueOf(cellValue);
	                     k++;
	                     continue cont;
	                    }
	                 else{
	                  int cellVal = (int)(long)firstRow.getCell(j).getNumericCellValue();
	                   data[i - 1][k] = String.valueOf(cellVal);
	                   System.out.println(cellVal);
	                     k++;
	                     continue cont;
	                     
	                 }
	                  
	                  }
	                  else
	                  {
	                   data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
	                      System.out.println(data[i - 1][k]);
	                      k++;
	                      continue cont;
	                  }
	                  }
	                }
	                }
	              wb.close();
	              fis.close();
	              
	              return data;  
	             }
public String[][] Enterthepriority() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	    	// Move control to the specific row
          XSSFRow firstRow = sheet.getRow(i);
          int cellType;
          String cellValue = null;
          for(int k=0 ; k<1 ; k++){
           cont:
          for (int j = 5; j < 6; j++) {
           cellType = firstRow.getCell(j).getCellType();
           if (cellType == 0)
          {
           if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
              {
                 SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                  cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
                  System.out.println(cellValue);
                  data[i - 1][k] = String.valueOf(cellValue);
               k++;
               continue cont;
              }
           else{
            int cellVal = (int)(long)firstRow.getCell(j).getNumericCellValue();
             data[i - 1][k] = String.valueOf(cellVal);
             System.out.println(cellVal);
               k++;
               continue cont;
               
           }
            
            }
            else
            {
             data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
                System.out.println(data[i - 1][k]);
                k++;
                continue cont;
            }
            }
          }
          }
        wb.close();
        fis.close();
        
        return data;  
       }
public String[][] enterRcTaskTitle() throws IOException {
    	  // Create an input stream
    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

    	    // Open the excel work sheet
    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

    	    // Move control to the first sheet
    	    XSSFSheet sheet = wb.getSheetAt(5);
    	    int rc = sheet.getLastRowNum();
    	    int cc = sheet.getRow(0).getLastCellNum();

    	    String data[][] = new String[rc][1];

    	    for (int i = 1; i <= rc; i++) {

    	    	// Move control to the specific row
                XSSFRow firstRow = sheet.getRow(i);
                int cellType;
                String cellValue = null;
                for(int k=0 ; k<1 ; k++){
                 cont:
                for (int j = 6; j < 7; j++) {
                 cellType = firstRow.getCell(j).getCellType();
                 if (cellType == 0)
                {
                 if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
                    {
                       SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
                        cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
                        System.out.println(cellValue);
                        data[i - 1][k] = String.valueOf(cellValue);
                     k++;
                     continue cont;
                    }
                 else{
                  int cellVal = (int)(long)firstRow.getCell(j).getNumericCellValue();
                   data[i - 1][k] = String.valueOf(cellVal);
                   System.out.println(cellVal);
                     k++;
                     continue cont;
                     
                 }
                  
                  }
                  else
                  {
                   data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
                      System.out.println(data[i - 1][k]);
                      k++;
                      continue cont;
                  }
                  }
                }
                }
              wb.close();
              fis.close();
              
              return data;  
             }

public String[][] enterRcTaskOwner() throws IOException {
	    	  // Create an input stream
	    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    	    // Open the excel work sheet
	    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    	    // Move control to the first sheet
	    	    XSSFSheet sheet = wb.getSheetAt(5);
	    	    int rc = sheet.getLastRowNum();
	    	    int cc = sheet.getRow(0).getLastCellNum();

	    	    String data[][] = new String[rc][1];

	    	    for (int i = 1; i <= rc; i++) {

	    	     // Move control to the specific row
	    	     XSSFRow firstRow = sheet.getRow(i);
	    	     int cellType;
	    	     String cellValue = null;
	    	     for(int k=0 ; k<1 ; k++){
	    	      cont:
	    	     for (int j = 7; j <8; j++) {
	    	      cellType = firstRow.getCell(j).getCellType();
	    	      if (cellType == 0)
		    	    {
		    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
		    	        {
		    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
		    	        }
		    	       data[i - 1][k] = String.valueOf(cellValue);
		    	       k++;
		    	       continue cont;
		    	      }
		    	      else
		    	      {
		    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
		    	          System.out.println(data[i - 1][k]);
		    	          k++;
		    	          continue cont;
		    	      }
		    	      }
		    	    }
		    	    }
		    	  wb.close();
		    	  fis.close();
		    	  return data;  
		    	 }
public String[][] enterRcTaskOwnerTwo() throws IOException {
	    	  // Create an input stream
	    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    	    // Open the excel work sheet
	    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    	    // Move control to the first sheet
	    	    XSSFSheet sheet = wb.getSheetAt(5);
	    	    int rc = sheet.getLastRowNum();
	    	    int cc = sheet.getRow(0).getLastCellNum();

	    	    String data[][] = new String[rc][1];

	    	    for (int i = 1; i <= rc; i++) {

	    	     // Move control to the specific row
	    	     XSSFRow firstRow = sheet.getRow(i);
	    	     int cellType;
	    	     String cellValue = null;
	    	     for(int k=0 ; k<2 ; k++){
	    	      cont:
	    	     for (int j = 8; j < 9; j++) {
	    	      cellType = firstRow.getCell(j).getCellType();
	    	      if (cellType == 0)
		    	    {
		    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
		    	        {
		    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
		    	        }
		    	       data[i - 1][k] = String.valueOf(cellValue);
		    	       k++;
		    	       continue cont;
		    	      }
		    	      else
		    	      {
		    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
		    	          System.out.println(data[i - 1][k]);
		    	          k++;
		    	          continue cont;
		    	      }
		    	      }
		    	    }
		    	    }
		    	  wb.close();
		    	  fis.close();
		    	  return data;  
		    	 }
public String[][] enterRcTaskStartDate() throws IOException {
	    	  // Create an input stream
	    	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    	    // Open the excel work sheet
	    	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    	    // Move control to the first sheet
	    	    XSSFSheet sheet = wb.getSheetAt(5);
	    	    int rc = sheet.getLastRowNum();
	    	    int cc = sheet.getRow(0).getLastCellNum();

	    	    String data[][] = new String[rc][1];

	    	    for (int i = 1; i <= rc; i++) {

	    	     // Move control to the specific row
	    	     XSSFRow firstRow = sheet.getRow(i);
	    	     int cellType;
	    	     String cellValue = null;
	    	     for(int k=0 ; k<1 ; k++){
	    	      cont:
	    	     for (int j = 9; j < 10; j++) {
	    	      cellType = firstRow.getCell(j).getCellType();
	    	      if (cellType == 0)
		    	    {
		    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
		    	        {
		    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
		    	        }
		    	       data[i - 1][k] = String.valueOf(cellValue);
		    	       k++;
		    	       continue cont;
		    	      }
		    	      else
		    	      {
		    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
		    	          System.out.println(data[i - 1][k]);
		    	          k++;
		    	          continue cont;
		    	      }
		    	      }
		    	    }
		    	    }
		    	  wb.close();
		    	  fis.close();
		    	  return data;  
		    	 }
public String[][] enterRcTaskEndDate() throws IOException {
 // Create an input stream
   FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

   // Open the excel work sheet
   XSSFWorkbook wb = new XSSFWorkbook(fis);

   // Move control to the first sheet
   XSSFSheet sheet = wb.getSheetAt(5);
   int rc = sheet.getLastRowNum();
   int cc = sheet.getRow(0).getLastCellNum();

   String data[][] = new String[rc][1];

   for (int i = 1; i <= rc; i++) {

    // Move control to the specific row
    XSSFRow firstRow = sheet.getRow(i);
    int cellType;
    String cellValue = null;
    for(int k=0 ; k<1 ; k++){
     cont:
    for (int j = 10; j < 11; j++) {
     cellType = firstRow.getCell(j).getCellType();
     if (cellType == 0)
	    {
	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
	        {
	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
	        }
	       data[i - 1][k] = String.valueOf(cellValue);
	       k++;
	       continue cont;
	      }
	      else
	      {
	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
	          System.out.println(data[i - 1][k]);
	          k++;
	          continue cont;
	      }
	      }
	    }
	    }
	  wb.close();
	  fis.close();
	  return data;  
	 }

public String[][] enterRcTaskTwoTitle() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 11; j < 12; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterReleasecoordTaskOwnerTwo() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 12; j < 13; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterRcTaskStartDateTwo() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 13; j < 14; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterRcTaskEndDateTwo() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 14; j < 15; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterApproval1Desc() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 15; j < 16; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterApproval2Desc() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 16; j < 17; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterApproval2Duedate() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 17; j < 18; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterPriority() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 18; j < 19; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterThirdTitle() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 19; j < 20; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterThirdOwner() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 20; j < 21; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
  	    {
  	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
  	        {
  	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
  	        }
  	       data[i - 1][k] = String.valueOf(cellValue);
  	       k++;
  	       continue cont;
  	      }
  	      else
  	      {
  	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
  	          System.out.println(data[i - 1][k]);
  	          k++;
  	          continue cont;
  	      }
  	      }
  	    }
  	    }
  	  wb.close();
  	  fis.close();
  	  return data;  
  	 }
public String[][] enterThirdStartDate() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 21; j < 22; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterThirdEndDate() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 22; j < 23; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterThirdDesc() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 23; j < 24; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterComment() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 24; j < 25; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
  	    {
  	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
  	        {
  	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
  	        }
  	       data[i - 1][k] = String.valueOf(cellValue);
  	       k++;
  	       continue cont;
  	      }
  	      else
  	      {
  	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
  	          System.out.println(data[i - 1][k]);
  	          k++;
  	          continue cont;
  	      }
  	      }
  	    }
  	    }
  	  wb.close();
  	  fis.close();
  	  return data;  
  	 }
public String[][] enterApproval3Desc() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 25; j < 26; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterApproval3Owner() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 26; j < 27; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
  	    {
  	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
  	        {
  	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
  	        }
  	       data[i - 1][k] = String.valueOf(cellValue);
  	       k++;
  	       continue cont;
  	      }
  	      else
  	      {
  	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
  	          System.out.println(data[i - 1][k]);
  	          k++;
  	          continue cont;
  	      }
  	      }
  	    }
  	    }
  	  wb.close();
  	  fis.close();
  	  return data;  
  	 }
public String[][] enterRcDesc() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 27; j < 28; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] addComment() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 28; j < 29; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] enterdesc() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 29; j < 30; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
  	    {
  	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
  	        {
  	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
  	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
  	        }
  	       data[i - 1][k] = String.valueOf(cellValue);
  	       k++;
  	       continue cont;
  	      }
  	      else
  	      {
  	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
  	          System.out.println(data[i - 1][k]);
  	          k++;
  	          continue cont;
  	      }
  	      }
  	    }
  	    }
  	  wb.close();
  	  fis.close();
  	  return data;  
  	 }
public String[][] readOnlyCardTitle() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 30; j < 31; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] readOnlyCardName() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 31; j < 32; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }
public String[][] readonlyTaskTitle() throws IOException {
	  // Create an input stream
	    FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

	    // Open the excel work sheet
	    XSSFWorkbook wb = new XSSFWorkbook(fis);

	    // Move control to the first sheet
	    XSSFSheet sheet = wb.getSheetAt(5);
	    int rc = sheet.getLastRowNum();
	    int cc = sheet.getRow(0).getLastCellNum();

	    String data[][] = new String[rc][1];

	    for (int i = 1; i <= rc; i++) {

	     // Move control to the specific row
	     XSSFRow firstRow = sheet.getRow(i);
	     int cellType;
	     String cellValue = null;
	     for(int k=0 ; k<1 ; k++){
	      cont:
	     for (int j = 32; j < 33; j++) {
	      cellType = firstRow.getCell(j).getCellType();
	      if (cellType == 0)
    	    {
    	    	if (DateUtil.isCellDateFormatted(firstRow.getCell(j)))
    	        {
    	           SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    	            cellValue   = sdf.format(firstRow.getCell(j).getDateCellValue());
    	        }
    	       data[i - 1][k] = String.valueOf(cellValue);
    	       k++;
    	       continue cont;
    	      }
    	      else
    	      {
    	       data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
    	          System.out.println(data[i - 1][k]);
    	          k++;
    	          continue cont;
    	      }
    	      }
    	    }
    	    }
    	  wb.close();
    	  fis.close();
    	  return data;  
    	 }

}

