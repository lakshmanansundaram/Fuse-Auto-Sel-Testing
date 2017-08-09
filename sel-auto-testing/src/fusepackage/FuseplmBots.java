package fusepackage;

import java.io.IOException;

import org.apache.tools.ant.types.Commandline.Argument;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.Window;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FuseplmBots extends WrapperClass {
	@BeforeClass
	public void login() throws IOException, InterruptedException {
		String[][] data = getlogin();
		String user = data[2][0];
		String pass = data[2][1];
		String browser = data [2][2];
		String role = data [2][3];
		String Url = data [2][4];
		//Launch Browsers
		launchBroswer( browser , Url);
		//Login
		sendvaluebyname("userEmail", user);
		sendvaluebyname("userPassword", pass);
		clickByXpath("//*[@id='login-form']/form/button");
		System.out.println("The " + role + "Login Successfully");
		Thread.sleep(3000);
		//Escape from the Guide menu
		clickByHDEmXpath("/html/body/div[6]/div/div[5]/a[2]");
		Thread.sleep(5000);
		iconClick("html/body/div[1]/div[1]/md-sidenav[1]/md-toolbar/md-icon");
		}
	
	@Test(priority = 1,enabled = true,groups = {"PLM Bots"})
	public void clickOnPlmBotIcon()throws IOException, InterruptedException {
		//Go to PlmBots
		clickByXpath("html/body/div[2]/ms-plm-chat-bot/div/div[1]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 2,enabled = true,groups = {"PLM Bots"})
	public void printPlmBotText()throws IOException, InterruptedException {
		//print the status
		verifystatus("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/md-content/div[1]/div[1]/div[1]/div/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 3,enabled = true,dataProvider = "EnterShowCard",groups = {"PLM Bots"})
	public void enterShowCard(String ShowCard)throws IOException, InterruptedException {
		//Enter show card
		sendvalueenterbyxpath("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/div/form/md-input-container/div[1]/textarea", ShowCard );
		Thread.sleep(3000);
	}
	@Test(priority = 4,enabled = true,groups = {"PLM Bots"})
	public void scrolldown()throws IOException, InterruptedException {
		//scroll down    
		scroll("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/md-content/div[1]/div[3]/div[2]/div[1]/div[1]");
		Thread.sleep(5000);
	}
	@Test(priority = 5,enabled = true,groups = {"PLM Bots"})
	public void clickChangeStateButtonfirst()throws IOException, InterruptedException {
		//Click the change state button from first card  
		clickByXpath("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/md-content/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[2]/div[2]/md-menu/button");
		Thread.sleep(5000);
	}
	@Test(priority = 6,enabled = true,groups = {"PLM Bots"})
	public void clickReleasedButton()throws IOException, InterruptedException {
		//Click released 
		clickByXpath("html/body/div[8]/md-menu-content/md-menu-item[4]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 7,enabled = true,groups = {"PLM Bots"})
	public void verifyStaus()throws IOException, InterruptedException {
		//verify the status
		verifystatus("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/md-content/div[1]/div[4]/div[1]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 8,enabled = true,groups = {"PLM Bots"})
	public void scrollUp()throws IOException, InterruptedException {
		//scroll up to second card
		scroll("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/md-content/div[1]/div[3]/div[2]/div[1]/div[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 9,enabled = true,groups = {"PLM Bots"})
	public void clickVisualizeButton()throws IOException, InterruptedException {
		//click visualize button from second card
		clickByXpath("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/md-content/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[2]/div[1]/button");
		Thread.sleep(4000);
	}
	@Test(priority = 10,enabled = true,groups = {"PLM Bots"})
	public void clickAffectedObject()throws IOException, InterruptedException {
		//click the affected obj
		clickByXpath("html/body/div[6]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/div[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 11,enabled = true,groups = {"PLM Bots"})
	public void clickModificationECO()throws IOException, InterruptedException {
		//click modification eco and close
		clickByXpath("html/body/div[7]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 12,enabled = true,groups = {"PLM Bots"})
	public void closeWindow()throws IOException, InterruptedException {
		//click close icon
		clickByXpath("html/body/div[7]/md-dialog/md-toolbar/div/div[2]/a/md-icon");
		Thread.sleep(3000);	
	}
	@Test(priority = 13,enabled = true,groups = {"PLM Bots"})
	public void clickChangeStateButton()throws IOException, InterruptedException {
		//click the change state button from second card
		clickByXpath("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/md-content/div[1]/div[3]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/md-menu/button");
		Thread.sleep(5000);
	}
	@Test(priority = 14,enabled = true,groups = {"PLM Bots"})
	public void clickReleaseButton()throws IOException, InterruptedException {
		//click released
		clickByXpath("html/body/div[7]/md-menu-content/md-menu-item[4]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 15,enabled = true,groups = {"PLM Bots"})
	public void verifyStatus()throws IOException, InterruptedException {
		//verify the status after clicking released
		verifystatus("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/md-content/div[1]/div[4]/div[1]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 16,enabled = true,dataProvider = "CreateCard",groups = {"PLM Bots"})
	public void createCard(String CreateCard)throws IOException, InterruptedException {
		//Sent a Message to create a card
		sendvalueenterbyxpath("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/div/form/md-input-container/div[1]/textarea", CreateCard );
		Thread.sleep(5000);
	}
	@Test(priority = 17,enabled = true,dataProvider = "CardName",groups = {"PLM Bots"})
	public void enterCardName(String CardName)throws IOException, InterruptedException {
		//Enter the Name of the Card
		sendvalueenterbyxpath("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/div/form/md-input-container/div[1]/textarea", CardName );
		Thread.sleep(5000);
	}
	@Test(priority = 18,enabled = true,groups = {"PLM Bots"})
	public void selectBoard()throws IOException, InterruptedException {
		//Click on the Board to Create a card
		clickByXpath("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/md-content/div[1]/div[5]/div[3]/div[1]");
		Thread.sleep(5000);
	}
	@Test(priority = 19,enabled = true,groups = {"PLM Bots"})
	public void scrollDown()throws IOException, InterruptedException {
		//scrolldown
		scroll("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/md-content/div[1]/div[6]/div[1]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 20,enabled = true,groups = {"PLM Bots"})
	public void clickClickHereLink()throws IOException, InterruptedException {
		//Click on Click Here Link to open the Card
		clickByXpath("html/body/div[2]/ms-plm-chat-bot/div/div[3]/div/div[2]/div/div/md-content/div[1]/div[6]/div[1]/div/div[1]/a/span");
		Thread.sleep(8000);
	}
	@Test(priority = 21,enabled = true,dataProvider = "EnterDueDate",groups = {"PLM Bots"})
	public void enterDueDate(String DueDate)throws IOException, InterruptedException {
		//Enter the due date
		sendvaluebyxpath("html/body/div[7]/md-dialog/md-dialog-content/div[1]/div[1]/div/div[2]/div[2]/md-datepicker/div[1]/input", DueDate);
		Thread.sleep(5000);
	}
	@Test(priority = 22,enabled = true,groups = {"PLM Bots"})
	public void clickCoordinatorButton()throws IOException, InterruptedException {
		//Add the Co-ordinators 
		clickByXpath("html/body/div[7]/md-dialog/md-toolbar/div/div[2]/md-menu[3]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 23,enabled = true,groups = {"PLM Bots"})
	public void selectCoordinators()throws IOException, InterruptedException {
		//select the first coordinator
		clickByXpath("html/body/div[8]/md-menu-content/md-menu-item[3]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 24,enabled = true,groups = {"PLM Bots"})
	public void selectNextCoordinators()throws IOException, InterruptedException {
		//select the next coordinator
		clickByXpath("html/body/div[8]/md-menu-content/md-menu-item[4]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 25,enabled = true,groups = {"PLM Bots"})
	public void closeCard()throws IOException, InterruptedException {
		//Close the Card
		clickByHDEmXpath("html/body/md-backdrop[1]");
		clickByXpath("html/body/div[7]/md-dialog/md-toolbar/div/div[2]/a/md-icon");
		Thread.sleep(3000);
	}
	@Test(priority = 26,enabled = true,groups = {"PLM Bots"})
	public void closePlmBot()throws IOException, InterruptedException {
		//Close the Plm-Bots
		iconClick("html/body/div[2]/ms-plm-chat-bot/div/div[2]/md-icon");
	}
	
	@AfterClass
	public void logout() throws InterruptedException {
		//Logout
		Thread.sleep(3000);
		clickByXpath("/html/body/div/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");	
		Thread.sleep(3000);
		clickByXpath("/html/body/div[4]/md-menu-content/md-menu-item[4]/button");
		Thread.sleep(3000);
		closeBrowser();
	}
	
	@DataProvider(name = "EnterShowCard")
	   public Object[][] plmbotscredential1() throws IOException {

		    Object[][] data = showCard();

		    return data;
	}
	@DataProvider(name = "CreateCard")
	   public Object[][] plmbotcredentials2() throws IOException {

		    Object[][] data = createCard();

		    return data;
	}
	@DataProvider(name = "CardName")
	   public Object[][] plmbotcredentials3() throws IOException {

		    Object[][] data = cardName();

		    return data;
	}
	@DataProvider(name = "EnterDueDate")
	   public Object[][] plmbotcredentials4() throws IOException {

		    Object[][] data = dueDate();

		    return data;
	}
	
	
	
}
