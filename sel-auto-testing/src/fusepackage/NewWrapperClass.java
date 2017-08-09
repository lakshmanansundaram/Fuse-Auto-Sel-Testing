package fusepackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
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
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.internal.Locatable;
import org.openqa.selenium.remote.RemoteWebDriver;

public class NewWrapperClass {
	RemoteWebDriver driver;

	/**
	 * Launch the desired browser and click the URL
	 * 
	 * @param Browser
	 * @param URL
	 * @throws InterruptedException
	 */
	public void launchBroswer(String Browser, String URL) {
		if (Browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", ".\\drivers\\geckodriver.exe");
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
		try {
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(sendvalue);
		} catch (NoSuchElementException expType) {

			expType.printStackTrace();

		} catch (NotFoundException expType) {

			expType.printStackTrace();
		} catch (WebDriverException expType) {

			expType.printStackTrace();
		} catch (Exception expType) {

			expType.printStackTrace();
		} finally {
			takesnapshot(sendvalue);
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
		try {
			driver.findElement(By.name(name)).clear();
			driver.findElement(By.name(name)).sendKeys(sendvalue);
		} catch (NoSuchElementException expType) {

			expType.printStackTrace();

		} catch (NotFoundException expType) {

			expType.printStackTrace();
		} catch (WebDriverException expType) {

			expType.printStackTrace();
		} catch (Exception expType) {

			expType.printStackTrace();
		} finally {
			takesnapshot(name);
		}
	}

	/**
	 * Click the Web Element by possible locator
	 */

	public void clickByXpath(String xpath) {
		try {
			driver.findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			System.out.println("Not able to recognize Webelement " + xpath + " here");
		}
	}

	public void clickByHDEmXpath(String xpath) {
		try {
			WebElement we = driver.findElement(By.xpath(xpath));
			Actions builder = new Actions(driver);
			Action mouseOverHome = builder.click(we).sendKeys(Keys.ESCAPE).build();
			mouseOverHome.perform();

		} catch (Exception e) {
			System.out.println("Not able to recognize Webelement " + xpath + " here");
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

	public void iconClick(String xpath) {
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
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

	public void takesnapshot(String Snapshot) throws IOException {
		File snaps = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(snaps, new File("./Screenshots/" + Snapshot + ".png"), true);
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

	public void scrolltoelement(String xpath) {
		try {
			WebElement element = driver.findElement(By.xpath(xpath));
			Coordinates coordinate = ((Locatable) element).getCoordinates();
			coordinate.inViewPort();

		} catch (Exception e) {
			e.printStackTrace();
		}

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

	// To close the single opened browser which opened by Selenium
	public void closeBrowser() {
		driver.close();
	}

	public void selectByXpath(String xpath) {
		try {
			WebElement we = driver.findElement(By.xpath(xpath));
			Actions builder = new Actions(driver);
			Action mouseOverHome = builder.click(we).sendKeys(Keys.ENTER).build();
			mouseOverHome.perform();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void senddocvaluebyxpathanddownclick(String xpath, String sendvalue) throws IOException {
		try {
			WebElement we = driver.findElement(By.xpath(xpath));
			we.clear();
			we.sendKeys(sendvalue);
			Actions builder = new Actions(driver);
			Thread.sleep(2000);
			Action mouseOverHome = builder.click(we).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
			mouseOverHome.perform();
		} catch (NoSuchElementException expType) {

			expType.printStackTrace();

		} catch (NotFoundException expType) {

			expType.printStackTrace();
		} catch (WebDriverException expType) {

			expType.printStackTrace();
		} catch (Exception expType) {

			expType.printStackTrace();
		} finally {
			takesnapshot(sendvalue);
		}
	}

	public void clickPartCategoryByXpath(String xpath, String Cate) {
		switch (Cate) {
		case "Assembly":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();

			} catch (Exception e) {
				System.out.println("Not able to recognize Webelement " + xpath + " here");
			}
			break;
		case "Electronics":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();

			} catch (Exception e) {
				System.out.println("Not able to recognize Webelement " + xpath + " here");
			}
			break;
		case "Mechanical":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();

			} catch (Exception e) {
				System.out.println("Not able to recognize Webelement " + xpath + " here");
			}
			break;
		case "Other":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();

			} catch (Exception e) {
				System.out.println("Not able to recognize Webelement " + xpath + " here");
			}
			break;
		case "Packaging":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();

			} catch (Exception e) {
				System.out.println("Not able to recognize Webelement " + xpath + " here");
			}
			break;

		}
	}

	// For selecting document category
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
				Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();

			} catch (Exception e) {
				System.out.println("Not able to recognize Webelement " + xpath + " here");
			}
			break;

		case "Engineering Drawings":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();

			} catch (Exception e) {
				System.out.println("Not able to recognize Webelement " + xpath + " here");
			}
			break;
		case "General Documents":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();

			} catch (Exception e) {
				System.out.println("Not able to recognize Webelement " + xpath + " here");
			}
			break;
		case "Specifications":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();

			} catch (Exception e) {
				System.out.println("Not able to recognize Webelement " + xpath + " here");
			}
			break;
		}
	}

	public void clickDocCategoryByXpath1(String xpath, String Cate) {
		switch (Cate) {
		case "Electronics Design Files":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();

			} catch (Exception e) {
				System.out.println("Not able to recognize Webelement " + xpath + " here");
			}
			break;
		case "Engineering Drawings":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
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
				Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
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
				Action mouseOverHome = builder.click(we).pause(2000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();

			} catch (Exception e) {
				System.out.println("Not able to recognize Webelement " + xpath + " here");
			}
			break;
		}
	}

	public void selectnotes(String xpath, String notes) {
		switch (notes) {
		case "#Column Name Error:Manufacturer 2":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "#Column Name Error:Manufacturer Part Number 2":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "ASSY_OPT":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Designator":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Footprint":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Manufacturer 1":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Manufacturer Part Number 1":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		}

	}

	public void selectpartname(String xpath, String partname) {
		switch (partname) {
		case "#Column Name Error:Manufacturer 2":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "#Column Name Error:Manufacturer Part Number 2":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "ASSY_OPT":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Designator":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Footprint":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Manufacturer 1":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		}

	}

	public void selectattribute1(String xpath, String attribute1) {
		switch (attribute1) {
		case "Category Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Cost":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Currency":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Display Part":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "External Part Number":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Footprint":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Approved":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Available":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Manufacturer Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		}
	}

	public void selectexcelcol1(String xpath, String excelcolumn1) {
		switch (excelcolumn1) {
		case "#Column Name Error:Manufacturer 2":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "#Column Name Error:Manufacturer Part Number 2":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "ASSY_OPT":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Designator":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Footprint":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Manufacturer 1":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		}
	}

	public void selectoperator(String xpath, String operator) {
		switch (operator) {
		case "AND":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "OR":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		}
	}

	public void selectattribute2(String xpath, String attribute2) {
		switch (attribute2) {
		case "Category Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Cost":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Currency":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Display Part":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "External Part Number":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Footprint":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Approved":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Available":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Manufacturer Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Manafacturer Part Number":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Part Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		}

	}

	public void selectexcelcol2(String xpath, String excelcolumn2) {
		switch (excelcolumn2) {
		case "#Column Name Error:Manufacturer 2":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "#Column Name Error:Manufacturer Part Number 2":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "ASSY_OPT":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Designator":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Footprint":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Manufacturer 1":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Manufacturer Part Number 1":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		}

	}

	void selectconfigfileByXpath(String xpath) {
		try {
			WebElement we = driver.findElement(By.xpath(xpath));
			Actions builder = new Actions(driver);
			Action mouseOverHome = builder.click(we).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
			mouseOverHome.perform();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void partselectattribute1(String xpath, String attribute1) {
		switch (attribute1) {
		case "Category Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Cost":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Currency":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Display Part":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "External Part Number":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Footprint":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Approved":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Available":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Manufacturer Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		}
	}

	public void partselectexcelcol1(String xpath, String excelcolumn1) {
		switch (excelcolumn1) {
		case "Category":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Creation Date":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Manufacturer Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Manufacturer Part Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Manufacturer Part Number":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Part Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Part Number":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		}
	}

	public void partselectattribute2(String xpath, String attribute2) {
		switch (attribute2) {
		case "Category Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Cost":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Currency":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Display Part":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "External Part Number":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Footprint":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Approved":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Available":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Manufacturer Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Manafacturer Part Number":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Part Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		}

	}

	public void partselectexcelcol2(String xpath, String excelcolumn2) {
		switch (excelcolumn2) {
		case "Category":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Creation Date":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Manufacturer Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Manufacturer Part Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Manufacturer Part Number":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		case "Part Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Part Number":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;

		}

	}

	public void selectexternalnumber(String xpath, String externalno) {
		switch (externalno) {
		case "Category":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER)
						.build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Creation Date":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Manufacturer Name":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Manufacturer Part Description":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Manufacturer Part Number":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Part Number":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Part Owner":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		case "Phase":
			try {
				WebElement we = driver.findElement(By.xpath(xpath));
				Actions builder = new Actions(driver);
				Action mouseOverHome = builder.click(we).pause(3000).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN)
						.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build();
				mouseOverHome.perform();
			} catch (NoSuchElementException expType) {

				expType.printStackTrace();

			} catch (NotFoundException expType) {

				expType.printStackTrace();
			} catch (WebDriverException expType) {

				expType.printStackTrace();
			} catch (Exception expType) {

				expType.printStackTrace();
			}
			break;
		}

	}

	public String[][] getcreatedocumentsData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the corresponding sheet
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

	public String[][] getdocbasicinfoData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the corresponding sheet
		XSSFSheet sheet = wb.getSheetAt(10);
		int rc = sheet.getLastRowNum();
		System.out.println(rc);
		int cc = sheet.getRow(0).getLastCellNum();
		System.out.println(cc);

		String data[][] = new String[rc][5];
		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for (int k = 0; k < 5; k++) {

				cont: for (int j = 3; j < 8; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0) {
						cellValue = (int) (long) firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					} else {
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
						System.out.println(data[i - 1][k]);
						k++;
						continue cont;
					}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}

	public String[][] getdocattachmentData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the corresponding sheet
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
			for (int k = 0; k < 3; k++) {

				cont: for (int j = 8; j < 11; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0) {
						cellValue = (int) (long) firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					} else {
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
						System.out.println(data[i - 1][k]);
						k++;
						continue cont;
					}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}

	public String[][] getdoccommentsData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the corresponding sheet
		XSSFSheet sheet = wb.getSheetAt(10);
		int rc = sheet.getLastRowNum();
		System.out.println(rc);
		int cc = sheet.getRow(0).getLastCellNum();
		System.out.println(cc);

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for (int k = 0; k < 1; k++) {

				cont: for (int j = 11; j < 12; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0) {
						cellValue = (int) (long) firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					} else {
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
						System.out.println(data[i - 1][k]);
						k++;
						continue cont;
					}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}

	public String[][] getdocumentvalue() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the corresponding sheet
		XSSFSheet sheet = wb.getSheetAt(10);
		int rc = sheet.getLastRowNum();
		System.out.println(rc);
		int cc = sheet.getRow(0).getLastCellNum();
		System.out.println(cc);

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for (int k = 0; k < 1; k++) {

				cont: for (int j = 12; j < 13; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0) {
						cellValue = (int) (long) firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					} else {
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
						System.out.println(data[i - 1][k]);
						k++;
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
		XSSFSheet sheet = wb.getSheetAt(11);
		int rc = sheet.getLastRowNum();
		System.out.println(rc);
		int cc = sheet.getRow(0).getLastCellNum();
		System.out.println(cc);

		String data[][] = new String[rc][10];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for (int j = 0; j < 10; j++) {
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

	public String[][] getpartsData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the corresponding sheet
		XSSFSheet sheet = wb.getSheetAt(11);
		int rc = sheet.getLastRowNum();
		System.out.println(rc);
		int cc = sheet.getRow(0).getLastCellNum();
		System.out.println(cc);

		String data[][] = new String[rc][5];
		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for (int k = 0; k < 5; k++) {

				cont: for (int j = 10; j < 15; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0) {
						cellValue = (int) (long) firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					} else {
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
						System.out.println(data[i - 1][k]);
						k++;
						continue cont;
					}
				}
			}
		}

		wb.close();
		fis.close();

		return data;
	}

	public String[][] getproductsData() throws IOException {

		// Create an input stream
		FileInputStream fis = new FileInputStream(new File(".\\Data\\Chrome\\Fuseplm.xlsx"));

		// Open the excel work sheet
		XSSFWorkbook wb = new XSSFWorkbook(fis);

		// Move control to the corresponding sheet
		XSSFSheet sheet = wb.getSheetAt(11);
		int rc = sheet.getLastRowNum();
		System.out.println(rc);
		int cc = sheet.getRow(0).getLastCellNum();
		System.out.println(cc);

		String data[][] = new String[rc][1];

		for (int i = 1; i <= rc; i++) {

			// Move control to the specific row
			XSSFRow firstRow = sheet.getRow(i);
			int cellType;
			int cellValue;
			for (int k = 0; k < 1; k++) {
				cont: for (int j = 15; j < 16; j++) {
					cellType = firstRow.getCell(j).getCellType();
					if (cellType == 0) {
						cellValue = (int) (long) firstRow.getCell(j).getNumericCellValue();
						data[i - 1][k] = String.valueOf(cellValue);
						k++;
						continue cont;
					} else {
						data[i - 1][k] = firstRow.getCell(j).getStringCellValue();
						System.out.println(data[i - 1][k]);
						k++;
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