package fusepackage;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.ThreadedRefreshHandler;

public class FuseCards extends WrapperClass{
	
	 @BeforeClass
	   public void beforeClass() {
	     // System.out.println("in beforeClass");
	   }
	
	@Test(priority = 1, enabled = true,groups = {"Project Engineer"})
	public void BCT0001projectEngineerLoginOne() throws IOException, InterruptedException {
		String[][] data = getlogin();
		String user = data[0][0];
		String pass = data[0][1];
		String browser = data [0][2];
		String role = data [0][3];
		String Url = data [0][4];
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
	@Test(priority = 2,enabled = true,groups = {"Project Engineer"})
	public void BCT0001clickBoardsTab()throws IOException, InterruptedException {
		//Go to boards
		 clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[2]/ul/li/ul/li/div/a");
		 Thread.sleep(3000);
	}
	@Test(priority = 3,enabled = true,groups = {"Project Engineer"})
	public void BCT0001clickPhase2ECO()throws IOException, InterruptedException {
		//Go to Phase -II ECO Board
		 clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[1]");
		 Thread.sleep(3000);
	}
	@Test(priority = 4,enabled = true,groups = {"Project Engineer"})
	public void BCT0001printSubmittedTitle()throws IOException, InterruptedException {
		//Submitted
		 gettitle("//div[@id='layout-vertical-navigation']/div/md-content/div[1]/md-content/div/div[1]/div/div[1]/div/span");
		 Thread.sleep(2000);
	}
	@Test(priority = 5,enabled = true,groups = {"Project Engineer"})
	public void BCT0001printReviewTitle()throws IOException, InterruptedException {
		//Review
		 gettitle("//div[@id='layout-vertical-navigation']/div/md-content/div[1]/md-content/div/div[2]/div/div[1]/div/span");
		 Thread.sleep(2000);
	}
	@Test(priority = 6,enabled = true,groups = {"Project Engineer"})
	public void BCT0001printApprovedTitle()throws IOException, InterruptedException {
		 //Approved
		  gettitle("//div[@id='layout-vertical-navigation']/div/md-content/div[1]/md-content/div/div[3]/div/div[1]/div/span");
		  Thread.sleep(2000);
	}
	@Test(priority = 7,enabled = true,groups = {"Project Engineer"})
	public void BCT0001printRejectedTitle()throws IOException, InterruptedException {
		//Rejected
		  gettitle("//div[@id='layout-vertical-navigation']/div/md-content/div[1]/md-content/div/div[4]/div/div[1]/div/span");
		  Thread.sleep(2000);
	}
	@Test(priority =8,enabled = true,groups = {"Project Engineer"})
	public void BCT0001printSubmittedNumber()throws IOException, InterruptedException {
		//No of Cards in Submitted List
		 getnumber("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[1]/div/div[1]/div/div/span[4]");
		 Thread.sleep(2000);
	}
	@Test(priority = 9,enabled = true,groups = {"Project Engineer"})
	public void BCT0001printReviewNumber()throws IOException, InterruptedException {
		//No of Cards in Review List
		 getnumber("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[2]/div/div[1]/div/div/span[4]");
		 Thread.sleep(2000);
	}
	@Test(priority = 10,enabled = true,groups = {"Project Engineer"})
	public void BCT0001printApprovedNumber()throws IOException, InterruptedException {
		 //No of Cards in Approved List
		  getnumber("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[1]/div/div/span[4]");
		  Thread.sleep(2000);
	}
	@Test(priority = 11,enabled = true,groups = {"Project Engineer"})
	public void BCT0001printRejectedNumber()throws IOException, InterruptedException {
		//No of Cards in Rejected List
		  getnumber("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[1]/div/div/span[4]");
		  Thread.sleep(2000);
	}
	@Test(priority = 12,enabled = true,groups = {"Project Engineer"})
	public void BCT0002clickAddCard()throws IOException, InterruptedException {
		//click add card
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[3]/ms-sb-add-card/div[@class='ms-sb-add-card-button layout-align-start-center layout-row']");
		Thread.sleep(2000);
	}
	@Test(priority = 13,enabled = true,dataProvider = "EnterPeCardTitle",groups = {"Project Engineer"})
	public void BCT0002enterCardTitle(String cardtitle)throws IOException, InterruptedException {
		//Enter card title
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[3]/ms-sb-add-card/div[2]/form/md-input-container/input", cardtitle);
		Thread.sleep(2000);
	}
	@Test(priority = 14,enabled = true,groups = {"Project Engineer"})
	public void BCT0002clickAdd()throws IOException, InterruptedException {
		//click add button to add card
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[3]/ms-sb-add-card/div[2]/form/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 15,enabled = true,groups = {"Project Engineer"})
	public void BCT0002clickClose()throws IOException, InterruptedException {
		//click close button
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[3]/ms-sb-add-card/div[2]/form/div/button[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 16,enabled = true,groups = {"Project Engineer"})
	public void BCT0003clickCreatedCard()throws IOException, InterruptedException {
		//open the created card
		 clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[2]/div");
		 Thread.sleep(3000);
	}
	@Test(priority = 17,enabled = true,groups = {"Project Engineer"})
	public void BCT0003verifyActivityStatus()throws IOException, InterruptedException {
		//Verify the Activity
		 gettextprint("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[3]/div/div[2]/div/div[1]","html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[3]/div/div[2]/div/div[2]","html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[3]/div/div[2]/div/div[3]");
		 Thread.sleep(5000);
	}
	@Test(priority = 18,enabled = true,groups = {"Project Engineer"})
	public void BCT0003closeCard()throws IOException, InterruptedException {
		//close the craeted card
		 clickByXpath("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/a/md-icon");
		 Thread.sleep(3000);
	}
	@Test(priority = 19,enabled = true,groups = {"Project Engineer"})
	public void BCT0004dragAndDragTheCard()throws IOException, InterruptedException {
		//Drag and Drop the card
		 dragAnddropByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[1]/div/div[2]/div/div[1]","html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[2]/div/div[2]/div");
		 Thread.sleep(5000);
	}
	@Test(priority = 20,enabled = true,groups = {"Project Engineer"})
	public void BCT0004verifyStatus()throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div/span");
		  Thread.sleep(5000);	
	}
	@Test(priority = 21, enabled = true,groups = {"Project Engineer"})
	public void BCT0004projectEngineerOneLogout() throws InterruptedException {
		//Logout
		Thread.sleep(3000);
		clickByXpath("/html/body/div/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");	
		Thread.sleep(3000);
		clickByXpath("/html/body/div[4]/md-menu-content/md-menu-item[4]/button");
		//*[@id="menu_container_354"]/md-menu-content/md-menu-item[4]/button
		Thread.sleep(3000);
		closeBrowser();
	}
	@Test(priority = 22, enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0005releaseCoordinatorOneLogin() throws IOException, InterruptedException {
		String[][] data = getlogin();
		String user = data[3][0];
		String pass = data[3][1];
		String browser = data [3][2];
		String role = data [3][3];
		String Url = data [3][4];
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
	@Test(priority = 23,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0005clickOnBoardsTab()throws IOException, InterruptedException {
		//Boards
		  clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[2]/ul/li/ul/li/div/a");
		  Thread.sleep(3000);
	}
	@Test(priority = 24,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0005clickPhase2Eco()throws IOException, InterruptedException {
		//Select phase2ECO
		  clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[1]");
		  Thread.sleep(3000);
	}
	@Test(priority = 25,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0005openCreatedCard()throws IOException, InterruptedException {
		//click the created card 
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[1]/div/div[2]/div/div[1]");
        Thread.sleep(3000);
	}
	@Test(priority = 26,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0006clickCoordinatorIcon()throws IOException, InterruptedException {
		//Click the assign coordinator button 
		  clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/md-menu[3]/button");
		  Thread.sleep(3000);
	}
	@Test(priority = 27,enabled = true,dataProvider = "AddReleaseCoordinator",groups = {"Release Co-Ordinator"})
	public void BCT0006addOwner(String coord)throws IOException, InterruptedException {
		//Add the owner(rc)
		  sendpartvaluebyxpathanddownclick("html/body/div[3]/md-menu-content/md-menu-item[1]/md-input-container/input", coord);
		  Thread.sleep(3000);
	}
	@Test(priority = 28,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0006clickoutside()throws IOException, InterruptedException {
		//click outside to close the coordinator dropdown
		clickByXpath("html/body/md-backdrop");
	}
	@Test(priority = 29,enabled = true,dataProvider = "EnterReleaseCoordinatorDueDate",groups = {"Release Co-Ordinator"})
	public void BCT0007enterReleaseCoordinatorDuedate(String duedate)throws IOException, InterruptedException {
		//enter due date
		  sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[1]/div/div[2]/div[2]/md-datepicker/div[1]/input", duedate);
		  Thread.sleep(3000);
	}
	@Test(priority = 30,enabled = true,dataProvider = "EnterReleaseCoordinatorDescription",groups = {"Release Co-Ordinator"})
	public void BCT0007enterReleaseCoordinatorDescription(String des)throws IOException, InterruptedException {
		//Enter the description
		 sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/md-input-container/div[1]/textarea", des);
		 Thread.sleep(3000);
	}
	@Test(priority = 31,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0007clickReleaseCoordinatorAffectedObjIcon()throws IOException, InterruptedException {
		//click the affected object button icon
		 clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/md-menu[1]/button");
		 Thread.sleep(3000);
	}
	@Test(priority = 32,enabled = true,dataProvider = "EnterReleaseCoordinatorAffobjNumber",groups = {"Release Co-Ordinator"})
	public void BCT0007enterReleaseCoordinatoraffectedObj(String affobj)throws IOException, InterruptedException {
		//Enter the affected obj number
		sendpartvaluebyxpathanddownclick("html/body/div[4]/md-menu-content/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-menu-item[1]/md-input-container/input", affobj);
		Thread.sleep(3000);
	}
	@Test(priority = 33,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0007clickOutside()throws IOException, InterruptedException {
		//click outside to close Affected obj dropdown
		clickByXpath("html/body/md-backdrop");
		Thread.sleep(3000);
	}
	@Test(priority = 34,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0007clickPriorityIcon()throws IOException, InterruptedException {
		//cick the priority icon
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/md-menu[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 35,enabled = true,dataProvider = "EnterPriority",groups = {"Release Co-Ordinator"})
	public void BCT0007enterpriority(String priority)throws IOException, InterruptedException {
		//enter the priority
		sendvaluebyxpath("html/body/div[7]/md-menu-content/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-menu-item/md-input-container/input", priority);
		Thread.sleep(3000);
	}
	@Test(priority = 36,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0007Clickout()throws IOException, InterruptedException {
		//click outside to close priority dropdown
		clickByXpath("html/body/md-backdrop");
		Thread.sleep(3000);
	}
	@Test(priority = 37,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0008clickSubscribeIcon()throws IOException, InterruptedException {
		//subscribe icon
		  clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/md-menu[4]/button");
		  Thread.sleep(3000);
	}
	@Test(priority = 38,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0008clickSubscribebutton()throws IOException, InterruptedException {
		//click subscribe button
		 clickByXpath("html/body/div[3]/md-menu-content/md-menu-item[1]/button");
		 Thread.sleep(3000);
	}
	@Test(priority = 39,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0009clickChecklistIcon()throws IOException, InterruptedException {
		//click checklist and name approval1 and click add
		 clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[2]");
		 Thread.sleep(4000);
	}
	@Test(priority = 40,enabled = true,dataProvider = "EnterRcTaskTitle",groups = {"Release Co-Ordinator"})
	public void BCT0010enterReleaseCoordinatorTaskTitle(String approval)throws IOException, InterruptedException {
		//Enter task title
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/md-input-container/input", approval);
		Thread.sleep(3000);
	}
	@Test(priority = 41,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0010clickReleaseCoordinatorAddButton()throws IOException, InterruptedException {
		//Add 
		 clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/button");
		 Thread.sleep(3000);
	}
	@Test(priority = 42,enabled = true,dataProvider = "EnterRcTaskOwner",groups = {"Release Co-Ordinator"})
	public void BCT0011enterReleaseCoordinatorTaskOwner(String rc)throws IOException, InterruptedException {
		//add owner to approval1
		  sendpartvaluebyxpathanddownclick("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", rc);
		  Thread.sleep(3000);
	}
	@Test(priority = 43,enabled = true,dataProvider = "EnterRcTaskOwnerTwo",groups = {"Release Co-Ordinator"})
	public void BCT0011enterReleaseCoordinatorTaskOwnertwo(String pm)throws IOException, InterruptedException {
		//add the next owner to approval1
		sendpartvaluebyxpathanddownclick("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", pm);
		Thread.sleep(3000);
	}
	@Test(priority = 44,enabled = true,dataProvider = "EnterRcTaskStartDate",groups = {"Release Co-Ordinator"})
	public void BCT0011enterReleaseCoordinatorTaskStartDate(String startdate)throws IOException, InterruptedException {
		//enter start date for approval1 task
		 sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[2]/div[1]/md-datepicker/div[1]/input", startdate);
		 Thread.sleep(3000);
	}
	@Test(priority = 45,enabled = true,dataProvider = "EnterRcTaskEndDate",groups = {"Release Co-Ordinator"})
	public void BCT0011enterReleaseCoordinatorTaskEndDate(String enddate)throws IOException, InterruptedException {
		//enter end date for approval1 task
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[2]/div[2]/md-datepicker/div[1]/input", enddate);
		 Thread.sleep(3000);
	}
	@Test(priority = 46,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0011closeTaskWindow()throws IOException, InterruptedException{
		//close task window
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 47,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0012scrollDown()throws IOException, InterruptedException{
		//scroll down
		scroll("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/md-input-container/input");
		Thread.sleep(5000);
	}
	@Test(priority = 48,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0012verifyTaskTitleOne()throws IOException, InterruptedException{
		//check whether the approval1 title is visible card window
		verifystatus("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div");
        Thread.sleep(3000);
	}
	@Test(priority = 49,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0012scrollUp()throws IOException, InterruptedException{
		//scroll to task textarea
		scroll("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/md-input-container/input");
		Thread.sleep(5000);
	}
	@Test(priority = 50,enabled = true,dataProvider = "EnterReleaseCoordinatorTaskTitle",groups = {"Release Co-Ordinator"})
	public void BCT0013enterReleaseCoordinatorTaskTilteTwo(String approval1)throws IOException, InterruptedException{
		//add approval 2 in the same card with pm alone as owner
		  sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/md-input-container/input", approval1);
		  Thread.sleep(3000);
	}
	@Test(priority = 51,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0013clickAddTaskButton()throws IOException, InterruptedException{
		//Add 
		  clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/button");
		  Thread.sleep(4000);
	}
	@Test(priority = 52,enabled = true,dataProvider = "EnterReleaseCoordinatorTaskOwnerTwo",groups = {"Release Co-Ordinator"})
	public void BCT0014enterReleaseCoordinatorTaskOwnerTwo(String pm2)throws IOException, InterruptedException{
		//Add pm as owner to approval2 task 
		sendpartvaluebyxpathanddownclick("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", pm2);
		Thread.sleep(3000);
	}
	@Test(priority = 53,enabled = true,dataProvider = "EnterReleaseCoordinatorTaskTwoStartDate",groups = {"Release Co-Ordinator"})
	public void BCT0014enterReleaseCoordinatorTaskTwoStartDate(String start)throws IOException, InterruptedException{
		//Enter task two start date
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[2]/div[1]/md-datepicker/div[1]/input", start);
		Thread.sleep(3000);
	}
	@Test(priority = 54,enabled = true,dataProvider = "EnterReleaseCoordinatorTaskTwoEndDate",groups = {"Release Co-Ordinator"})
	public void BCT0014enterReleaseCoordinatorTaskTwoEndDate(String end)throws IOException, InterruptedException{
		//Enter task two end date
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[2]/div[2]/md-datepicker/div[1]/input", end);
		Thread.sleep(3000);
	}
	@Test(priority = 55,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0014closeTaskTwo()throws IOException, InterruptedException{
		// close task two window 
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		  Thread.sleep(3000);
	}
	@Test(priority = 56,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0015verifyTaskTwoTitle()throws IOException, InterruptedException{
		//check whether the approval2 title is visible card window
		 verifystatus("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/div/div[1]/div/div");
		 Thread.sleep(4000);
	}
	@Test(priority = 57,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0016clickTasksTab()throws IOException, InterruptedException{
		//Go to task section 
        clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
        Thread.sleep(3000);
	}
	@Test(priority = 58,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0017clickBoards()throws IOException, InterruptedException{
		//go to boards
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[1]/div/a");
        Thread.sleep(3000);
	}
	@Test(priority = 59,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0017clickPhaseEco()throws IOException, InterruptedException{
		//click phase2 ECO
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[1]");
        Thread.sleep(3000);
	}
	@Test(priority = 60,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0018dragAndDropCard()throws IOException, InterruptedException{
		//search the created card and drag and drop it
        dragAnddropByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[1]/div/div[2]/div/div[1]", "html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[2]/div/div[2]/div");
        Thread.sleep(3000);
	}
	@Test(priority = 61,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0019openCard()throws IOException, InterruptedException{
		//open the created card
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[2]/div/div[2]/div/div[1]");
        Thread.sleep(4000);
	}
	@Test(priority = 62,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0019verifyTaskTitle()throws IOException, InterruptedException{
		//verify approval1 title
		gettitle("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]");
        Thread.sleep(3000);
	}
	@Test(priority = 63,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0019verifyTaskTitleTwo()throws IOException, InterruptedException{
		//verify approval2 title
		gettitle("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]");
        Thread.sleep(3000);
	}
	@Test(priority = 64,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0020clickTasksTab()throws IOException, InterruptedException{
		//Go to task section 
        clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
        Thread.sleep(3000);
	}
	@Test(priority = 65,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0020clickBoards()throws IOException, InterruptedException{
		//go to boards
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[1]/div/a");
        Thread.sleep(3000);
	}
	@Test(priority = 66,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0020clickPhaseEco()throws IOException, InterruptedException{
		//click phase2 ECO
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[1]");
        Thread.sleep(3000);
	}
	
	@Test(priority = 67,enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0020reviewCardsCount()throws IOException, InterruptedException{
		//No of cards in Review list
        getnumber("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[2]/div/div[1]/div/div/span[4]");
        Thread.sleep(3000);
	}
	@Test(priority = 68, enabled = true,groups = {"Release Co-Ordinator"})
	public void BCT0020releaseCoordinatorOneLogout() throws InterruptedException {
		//Logout
		Thread.sleep(3000);
		clickByXpath("/html/body/div/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");	
		Thread.sleep(3000);
		clickByXpath("/html/body/div[4]/md-menu-content/md-menu-item[4]/button");
		//*[@id="menu_container_354"]/md-menu-content/md-menu-item[4]/button
		Thread.sleep(3000);
		closeBrowser();
	
	}
	@Test(priority =69, enabled = true,groups = {"Project Manager"})
	public void BCT0021projectManagerOne() throws IOException, InterruptedException {
		String[][] data = getlogin();
		String user = data[1][0];
		String pass = data[1][1];
		String browser = data [1][2];
		String role = data [1][3];
		String Url = data [1][4];
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
		Thread.sleep(3000);
		
	}
	@Test(priority = 70,enabled = true,groups = {"Project Manager"})
	public void BCT0021clickTaskTab()throws IOException, InterruptedException{
		//Go to Tasks
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
	    Thread.sleep(3000);
	}
	@Test(priority = 71,enabled = true,groups = {"Project Manager"})
	public void BCT0022openTask()throws IOException, InterruptedException{
		//Open Approval 1 Task - check it has both RC and PM as a Owner and add some more description
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 72,enabled = true,groups = {"Project Manager"})
	public void BCT0022verifyOwner()throws IOException, InterruptedException{
		//check it has both RC and PM as a Owner
		verifystatus("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/md-chip[2]/div[1]/md-chip-template/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 73,enabled = true,groups = {"Project Manager"})
	public void BCT0022verifyNextOwner()throws IOException, InterruptedException{
		//check it has both RC and PM as a Owner
		verifystatus("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/md-chip[1]/div[1]/md-chip-template/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 74,enabled = true,dataProvider = "EnterApproval1Desc",groups = {"Project Manager"})
	public void BCT0022enterApproval1Description(String TaskDes)throws IOException, InterruptedException{
		//enter description
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[3]/text-angular/div[2]/div[3]", TaskDes);
		Thread.sleep(3000);
	}
	@Test(priority = 75,enabled = true,groups = {"Project Manager"})
	public void BCT0023close()throws IOException, InterruptedException{
		//Close the task
		clickByXpath("html/body/div[3]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 76,enabled = true,groups = {"Project Manager"})
	public void BCT0024clickApproval1Checkbox()throws IOException, InterruptedException{
		//Click on CheckBox for the Task
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div[1]/md-checkbox/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 77,enabled = true,groups = {"Project Manager"})
	public void BCT0025openApproval2Task()throws IOException, InterruptedException{
		//Open Approval 2 Task
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 78,enabled = true,groups = {"Project Manager"})
	public void BCT0025verifyApproval2Coord()throws IOException, InterruptedException{
		//Check the Co-Ordinators
		verifystatus("html/body/div[3]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/md-chip/div[1]/md-chip-template/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 79,enabled = true,dataProvider = "EnterApproval2Desc",groups = {"Project Manager"})
	public void BCT0025enterApproval2Desc(String TaskDes2)throws IOException, InterruptedException{
		//Add desc for Approval2 task
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[3]/text-angular/div[2]/div[3]/p", TaskDes2);
		Thread.sleep(3000);
	}
	@Test(priority = 80,enabled = true,dataProvider = "EnterApproval2DueDate",groups = {"Project Manager"})
	public void BCT0025enterApproval2DueDate(String DueDate)throws IOException, InterruptedException{
		//Change Due Date
		 sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[2]/div[2]/md-datepicker/div[1]/input", DueDate);
	}
	@Test(priority = 81,enabled = true,groups = {"Project Manager"})
	public void BCT0026closeTask()throws IOException, InterruptedException{
		//close task
		clickByXpath("html/body/div[3]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 82,enabled = true,groups = {"Project Manager"})
	public void BCT0027goToBoards()throws IOException, InterruptedException{
		//Boards
		 clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[2]/ul/li/ul/li/div/a");
		 Thread.sleep(3000);
	}
	@Test(priority = 83,enabled = true,groups = {"Project Manager"})
	public void BCT0027goToECOBoard()throws IOException, InterruptedException{
		//Go to ECO Board
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[4]");
	}
	@Test(priority = 84,enabled = true,groups = {"Project Manager"})
	public void BCT0028openTheCreatedCard()throws IOException, InterruptedException{
		//Enter into the Card
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[1]/div/div[2]/div/div[1]"); 
		Thread.sleep(3000);
	}
	@Test(priority = 85,enabled = true,groups = {"Project Manager"})
	public void BCT0029clickThePriorityIcon()throws IOException, InterruptedException{
		//click the priority icon
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/md-menu[3]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 86,enabled = true,dataProvider = "EnterThePrior",groups = {"Project Manager"})
	public void BCT0029changePriority(String high)throws IOException, InterruptedException{
		//Modify priority from 'M' to 'H'
		sendvaluebyxpath("html/body/div[3]/md-menu-content/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-menu-item[1]/md-input-container/input", high);
		Thread.sleep(3000);
	}
	@Test(priority = 87,enabled = true,groups = {"Project Manager"})
	public void BCT0030clickCheckListIcon()throws IOException, InterruptedException{
		//click the checklist icon 
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 88,enabled = true,dataProvider = "EnterThirdTaskTitle",groups = {"Project Manager"})
	public void BCT0030enterThirdTaskTitle(String approval3)throws IOException, InterruptedException{
		//Add task3
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/md-input-container/input", approval3);
	    Thread.sleep(3000);
	}
	@Test(priority = 89,enabled = true,groups = {"Project Manager"})
	public void BCT0030addThirdTask()throws IOException, InterruptedException{
		//Click add task button
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/button");
	    Thread.sleep(3000);
	}
	@Test(priority = 90,enabled = true,dataProvider = "EnterThirdOwner",groups = {"Project Manager"})
	public void BCT0031enterThirdOwner(String pe)throws IOException, InterruptedException{
		//enter the owner for third task
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", pe);
	    Thread.sleep(3000);
	}
	@Test(priority = 91,enabled = true,dataProvider = "EnterThirdStartDate",groups = {"Project Manager"})
	public void BCT0031enterThirdStart(String start)throws IOException, InterruptedException{
		//enter the start date for third task
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[2]/div[1]/md-datepicker/div[1]/input", start);
	    Thread.sleep(3000);
	}
	@Test(priority = 92,enabled = true,dataProvider = "EnterThirdEndDate",groups = {"Project Manager"})
	public void BCT0031enterThirdEnd(String end)throws IOException, InterruptedException{
		//enter the end date for third task
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[2]/div[2]/md-datepicker/div[1]/input", end);
	    Thread.sleep(3000);
	}
	@Test(priority = 93,enabled = true,dataProvider = "EnterThirdDesc",groups = {"Project Manager"})
	public void BCT0031enterThirdDesc(String des)throws IOException, InterruptedException{
		//enter description
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[3]/text-angular/div[2]/div[3]", des);
	    Thread.sleep(3000);
	}
	@Test(priority = 94,enabled = true,groups = {"Project Manager"})
	public void BCT0031closeTheTask()throws IOException, InterruptedException{
		//close window
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 95,enabled = true,groups = {"Project Manager"})
	public void BCT0032verifyTaskThreeTitle()throws IOException, InterruptedException{
		//check whether approval3 task appears,title
	    verifystatus("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/div[3]/div[1]/div/div");
	    Thread.sleep(3000);
	}
	@Test(priority = 96,enabled = true,groups = {"Project Manager"})
	public void BCT0032verifyTaskThreeOwner()throws IOException, InterruptedException{
		//check whether approval3 task appears,title
	    verifystatus("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[4]/div[1]/div[2]/div[2]/div/div[2]/div/md-chip-template/div");
	    Thread.sleep(3000);
	}
	@Test(priority = 97,enabled = true,groups = {"Project Manager"})
	public void BCT0032verifyTaskThreeDuedate()throws IOException, InterruptedException{
		//check whether approval3 task appears,title
	    verifystatus("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[4]/div[1]/div[2]/div[2]/div/div[2]/div/div");
	    Thread.sleep(3000);
	}
	@Test(priority = 98,enabled = true,groups = {"Project Manager"})
	public void BCT0033openTaskTab()throws IOException, InterruptedException{
		//go to task section
	    clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
	    Thread.sleep(3000);
	}
	@Test(priority = 99,enabled = true,groups = {"Project Manager"})
	public void BCT0034openBoardTab()throws IOException, InterruptedException{
		//go back to boards and move the cards from list2 to list3
	    clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[1]/div/a");
	    Thread.sleep(3000);
	}
	@Test(priority = 100,enabled = true,groups = {"Project Manager"})
	public void BCT0034openPhase2Eco()throws IOException, InterruptedException{
		//go back to boards and move the cards from list2 to list3
	    clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[1]");
	    Thread.sleep(3000);
	}
	@Test(priority = 101,enabled = true,groups = {"Project Manager"})
	public void BCT0034dragDrop()throws IOException, InterruptedException{
		//Drag and drop the card
		dragAnddropByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[2]/div/div[2]/div/div[1]", "html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div");
    	Thread.sleep(3000);
	}
	@Test(priority = 102,enabled = true,groups = {"Project Manager"})
	public void BCT0034verifyThirdTaskTitle()throws IOException, InterruptedException{
		//Verify the title
		gettitle("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[1]/div/span");
    	Thread.sleep(3000);
	}
	@Test(priority = 103,enabled = true,groups = {"Project Manager"})
	public void BCT0034verifyThirdTaskCount()throws IOException, InterruptedException{
		getnumber("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[1]/div/div/span[4]");
    	Thread.sleep(3000);
	}
	@Test(priority = 104,enabled = true,groups = {"Project Manager"})
	public void BCT0035openCardFrom()throws IOException, InterruptedException{
		//open the card from list 3 and add comment
	    clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div/div[1]");
	    Thread.sleep(3000);
	}
	@Test(priority = 105,enabled = true,dataProvider = "Entercomment",groups = {"Project Manager"})
	public void BCT0035enterComment(String comment1)throws IOException, InterruptedException{
		//Enter comment 
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[2]/div/div[2]/form/div[1]/md-input-container/div[1]/textarea", comment1);
	    Thread.sleep(3000);
	}
	@Test(priority = 106,enabled = true,groups = {"Project Manager"})
	public void BCT0036ClickuploadButton()throws IOException, InterruptedException{
		//upload an image and add cover
	    clickByXpath("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[2]/div/div[2]/div/div/div[2]/button");
	    Thread.sleep(3000);
	}
	@Test(priority = 107,enabled = true,groups = {"Project Manager"})
	public void BCT0036uploadImage()throws IOException, InterruptedException{
		Runtime.getRuntime().exec("C:\\Users\\Lakshmanan.S\\workspace\\Fuseplm\\sel-auto-testing\\AutoIT\\AutoIt\\FileUpload.exe");  //Uploading .jpg file using AutoIT
	    Thread.sleep(4000);
	}
	@Test(priority = 108,enabled = true,groups = {"Project Manager"})
	public void BCT0036clickCoverbutton()throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/md-menu/button");
	    Thread.sleep(3000);
	}
	@Test(priority = 109,enabled = true,groups = {"Project Manager"})
	public void BCT0036clickCoverItem()throws IOException, InterruptedException{
		clickByXpath("html/body/div[3]/md-menu-content/md-menu-item[1]/button");
	}
	@Test(priority = 110,enabled = true,groups = {"Project Manager"})
	public void BCT0036closeImage()throws IOException, InterruptedException{
		 clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/a/md-icon");
	}
	@Test(priority = 111,enabled = true,groups = {"Project Manager"})
	public void BCT0037verifyTaskTitleOne()throws IOException, InterruptedException{
		//check whether approval1 task appears,title
	    verifystatus("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[4]/div[1]/div[2]/div[2]/div[1]/div[1]/div/div");
	    Thread.sleep(3000);
	}
	@Test(priority = 112,enabled = true,groups = {"Project Manager"})
	public void BCT0037verifyTaskTitleTwo()throws IOException, InterruptedException{
		//check whether approval2 task appears,title
	    verifystatus("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[4]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div");
	    Thread.sleep(3000);
	}
	@Test(priority = 113,enabled = true,groups = {"Project Manager"})
	public void BCT0037verifyTaskTitleThree()throws IOException, InterruptedException{
		//check whether approval3 task appears,title
	    verifystatus("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[4]/div[1]/div[2]/div[2]/div[2]/div[1]/div/div");
	    Thread.sleep(3000);
	}
	@Test(priority = 114,enabled = true,groups = {"Project Manager"})
	public void BCT0038goTask()throws IOException, InterruptedException{
		//go to task section and come back to boards
	    clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
	    Thread.sleep(3000);
	}
	@Test(priority = 115,enabled = true,groups = {"Project Manager"})
	public void BCT0038goToBoardsTab()throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[1]/div/a");
	    Thread.sleep(3000);
	}
	@Test(priority = 116,enabled = true,groups = {"Project Manager"})
	public void BCT0038clickPhase2ECO()throws IOException, InterruptedException {
		//Go to Phase -II ECO Board
		 clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[1]");
		 Thread.sleep(3000);
	}
	@Test(priority = 117,enabled = true,groups = {"Project Manager"})
	public void BCT0039openCardAgain()throws IOException, InterruptedException{
		//click the card created and remove cover of the image
	    clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div/div[1]");
	    Thread.sleep(3000);
	}
	@Test(priority = 118,enabled = true,groups = {"Project Manager"})
	public void BCT0039clickUpload()throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[2]/div/div[2]/div[1]/div/div[2]/md-menu/button");
	    Thread.sleep(3000);
	}
	@Test(priority = 119,enabled = true,groups = {"Project Manager"})
	public void BCT0039clickUncoverButton()throws IOException, InterruptedException{
		clickByXpath("html/body/div[3]/md-menu-content/md-menu-item[1]/button");
	    Thread.sleep(3000);
	}
	@Test(priority = 120,enabled = true,groups = {"Project Manager"})
	public void BCT0039clickCloseButton()throws IOException, InterruptedException{
		 clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/a/md-icon");
	}
	@Test(priority = 121, enabled = true,groups = {"Project Manager"})
	public void BCT0039projectManagerLogoutOne() throws InterruptedException {
		//Logout
		Thread.sleep(3000);
		clickByXpath("/html/body/div/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");	
		Thread.sleep(3000);
		clickByXpath("/html/body/div[4]/md-menu-content/md-menu-item[4]/button");
		Thread.sleep(3000);
		closeBrowser();
	}
	@Test(priority = 122, enabled = true,groups = {"Project Engineer2"})
	public void BCT0040projectEngineerTwoLogin() throws IOException, InterruptedException {
		String[][] data = getlogin();
		String user = data[0][0];
		String pass = data[0][1];
		String browser = data [0][2];
		String role = data [0][3];
		String Url = data [0][4];
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
	@Test(priority = 123,enabled = true,groups = {"Project Engineer2"})
	public void BCT0040clickTaskTabForPe2()throws IOException, InterruptedException{
		//Go to task section
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 124,enabled = true,groups = {"Project Engineer2"})
	public void BCT0041clickMenuButton()throws IOException, InterruptedException{
		//click on menu icon of approval 3 task 
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div/div[2]/div[2]/md-menu/button");
		Thread.sleep(3000);
	}
	@Test(priority = 125,enabled = true,groups = {"Project Engineer2"})
	public void BCT0041clickPriority()throws IOException, InterruptedException{
		//click priority
		clickByXpath("//*[@id='menu_container_223']/md-menu-content/md-menu-item[2]/button");
		Thread.sleep(3000);	
	}
	@Test(priority = 126,enabled = true,groups = {"Project Engineer2"})
	public void BCT0041clickStarredButton()throws IOException, InterruptedException{
		//click starred button
		clickByXpath("//*[@id='menu_container_223']/md-menu-content/md-menu-item[3]/button");
		Thread.sleep(3000);	
	}
	@Test(priority = 127,enabled = true,groups = {"Project Engineer2"})
	public void BCT0042checkForDeleteButton()throws IOException, InterruptedException{
		//click menu
		clickByXpath("//*[@id='menu_container_223']/md-menu-content/md-menu-item[3]/button");
		Thread.sleep(3000);	
	}
	@Test(priority = 128,enabled = true,groups = {"Project Engineer2"})
	public void BCT0042clickOutside()throws IOException, InterruptedException{
		//click menu
		clickByXpath("html/body/md-backdrop");
		Thread.sleep(3000);	
	}
	@Test(priority = 129,enabled = true,groups = {"Project Engineer"})
	public void BCT0043goToScrumBoard()throws IOException, InterruptedException {
		//Go to boards
		 clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[2]/ul/li/ul/li/div/a");
		 Thread.sleep(3000);
	}
	@Test(priority = 130,enabled = true,groups = {"Project Engineer"})
	public void BCT0043clickIssueBoard()throws IOException, InterruptedException {
		//Go to Phase -II ECO Board
		 clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[1]");
		 Thread.sleep(3000);
	}
	@Test(priority = 131,enabled = true,groups = {"Project Engineer2"})
	public void BCT0044openTaskSection()throws IOException, InterruptedException{
		// go to task section and click approval 3 and some description
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 132,enabled = true,groups = {"Project Engineer2"})
	public void BCT0045openApproval3()throws IOException, InterruptedException{
		//click approval 3 task
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div/div[2]/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 133,enabled = true,groups = {"Project Engineer2"})
	public void BCT0045verify()throws IOException, InterruptedException{
		verifystatus("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/md-chip/div[1]/md-chip-template/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 134,enabled = true, dataProvider = "EnterApproval3Desc",groups = {"Project Engineer2"})
	public void BCT0045verify(String desc)throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[3]/text-angular/div[2]/div[3]", desc);
		Thread.sleep(3000);
	}
	@Test(priority = 135,enabled = true, dataProvider = "EnterApproval3Owner",groups = {"Project Engineer2"})
	public void BCT0046enterApproval3Owner(String rc)throws IOException, InterruptedException{
		//try to add rc as owner and verify the toast content
		sendpartvaluebyxpathanddownclick("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", rc);
	}
	@Test(priority = 136,enabled = true,groups = {"Project Engineer2"})
	public void BCT0046verifyWarningMessage()throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
	}
	@Test(priority = 137,enabled = true,groups = {"Project Engineer2"})
	public void BCT0046closeWarningMessage()throws IOException, InterruptedException{
		clickByXpath("html/body/md-toast/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 138,enabled = true,groups = {"Project Engineer2"})
	public void BCT0047closetask()throws IOException, InterruptedException{
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 139,enabled = true,groups = {"Project Engineer2"})
	public void BCT0048clickapproval3checkbox()throws IOException, InterruptedException{
		//select the checkbox of approval3 task
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div[1]/md-checkbox/div[1]");
	}
	@Test(priority = 140, enabled = true,groups = {"Project Engineer2"})
	public void BCT0048projectEngineerLogout() throws InterruptedException {
		//Logout
		Thread.sleep(3000);
		clickByXpath("/html/body/div/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");	
		Thread.sleep(3000);
		clickByXpath("/html/body/div[4]/md-menu-content/md-menu-item[4]/button");
		//*[@id="menu_container_354"]/md-menu-content/md-menu-item[4]/button
		Thread.sleep(3000);
		closeBrowser();
	}
	@Test(priority = 141, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0049releaseCoordinatorTwoLogin() throws IOException, InterruptedException {
		String[][] data = getlogin();
		String user = data[3][0];
		String pass = data[3][1];
		String browser = data [3][2];
		String role = data [3][3];
		String Url = data [3][4];
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
	@Test(priority = 142, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0049BoardsTab() throws IOException, InterruptedException {
		//Go to boards and select the card
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[1]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 143,enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0049clickPhase2ECO()throws IOException, InterruptedException {
		//Go to Phase -II ECO Board
		 clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[1]");
		 Thread.sleep(3000);
	}
	@Test(priority = 144, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0049clickCard() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 145, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0050checkSubscribe() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[1]/div/div[1]/div[4]/md-icon");
		Thread.sleep(3000);
	}
	@Test(priority = 146, enabled = true,dataProvider = "EnterRcDescription",groups = {"Release Co-Ordinator2"})
	public void BCT0051addDesc(String desc) throws IOException, InterruptedException {
		//add description
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/md-input-container/div[1]/textarea", desc);
		Thread.sleep(3000);
	}
	@Test(priority = 147, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0052upload() throws IOException, InterruptedException {
		//upload a image,add comment,description and close
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[2]/div/div[2]/div[2]/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 148, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0052uploadTheImage() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("C:\\Users\\Lakshmanan.S\\workspace\\Fuseplm\\sel-auto-testing\\AutoIT\\AutoIt\\FileUpload.exe");  //Uploading .jpg file using AutoIT
	    Thread.sleep(4000);
	}
	@Test(priority = 149,enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0053scrollDown()throws IOException, InterruptedException{
		//scroll down
		scroll("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[4]/div[1]/div[2]/div[2]/div[1]/div[1]");
		Thread.sleep(5000);
	}
	@Test(priority = 150, enabled = true,dataProvider = "AddComment",groups = {"Release Co-Ordinator2"})
	public void BCT0054addComment(String comment) throws IOException, InterruptedException {
		//add  comment and close
	    sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[2]/div/div[2]/form/div[1]/md-input-container/div[1]/textarea", comment);
		Thread.sleep(3000);
	}
	@Test(priority = 151, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0055closeWindow() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/a/md-icon");
		Thread.sleep(3000);
	}
	@Test(priority = 152, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0056dragdropCard() throws IOException, InterruptedException {
		//drag the card from list3 to list 4 ,error throws to complete all the task
		dragAnddropByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div/div[1]", "html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[2]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 153, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0056verifydraganddropStatus() throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 154, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0057clickCardList3() throws IOException, InterruptedException {
		//click the card in list 3 and check the approva1
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 155, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0057scrolToTaskSection() throws IOException, InterruptedException {
		scroll("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/md-checkbox/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 156, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0058clickCheckbox() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[4]/div[1]/div[2]/div[2]/div[1]/div[1]/md-checkbox/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 157, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0059closecard() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/a/md-icon");
		Thread.sleep(3000);
	}
	@Test(priority = 158, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0059verifyTaskStatus() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div/div[1]/div[1]/div[6]/span[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 159, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0060dragandDropToList4() throws IOException, InterruptedException {
		//now move the task from list3 to list4
		dragAnddropByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div/div[1]", "html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[2]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 160, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0061dragandDropToList3() throws IOException, InterruptedException {
		//now move the task from list4 to list3
		dragAnddropByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[2]/div/div[1]", "html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 161, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0062clickcard() throws IOException, InterruptedException {
		//click the task from list4 and try to edit the des
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[2]/div/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 162, enabled = true,dataProvider = "EnterDes",groups = {"Release Co-Ordinator2"})
	public void BCT0062enterDes(String des) throws IOException, InterruptedException {
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/md-input-container/div[1]/textarea", des);
		Thread.sleep(3000);
	}
	@Test(priority = 163, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0062clickclose() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/a/md-icon");
		Thread.sleep(3000);
	}
	@Test(priority = 164, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0062verifyAfterClose() throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 165, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0063opentask() throws IOException, InterruptedException {
		//go to task section
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 166, enabled = true,groups = {"Release Co-Ordinator2"})
	public void BCT0063releaseCoordinatorTwoLogout() throws InterruptedException {
		//Logout
		Thread.sleep(3000);
		clickByXpath("/html/body/div/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");	
		Thread.sleep(3000);
		clickByXpath("/html/body/div[4]/md-menu-content/md-menu-item[4]/button");
		Thread.sleep(3000);
		closeBrowser();
	}
	@Test(priority = 167, enabled = true,groups = {"Customer Admin"})
	public void BCT0064customerAdminLogin() throws IOException, InterruptedException {
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
	@Test(priority = 168, enabled = true,groups = {"Customer Admin"})
	public void BCT0064goBoards() throws IOException, InterruptedException {
		//Go to boards
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[1]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 169, enabled = true,groups = {"Customer Admin"})
	public void BCT0064phase2eco() throws IOException, InterruptedException {
		//Go to phase2eco
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[1]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 170, enabled = true,groups = {"Customer Admin"})
	public void BCT0064clickSettings() throws IOException, InterruptedException {
		//click the settings in list4  
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[1]/md-menu/button");
		Thread.sleep(3000);
	}
	@Test(priority = 171, enabled = true,groups = {"Customer Admin"})
	public void BCT0064unselectLock() throws IOException, InterruptedException {
		//unselect the lock
		clickByXpath("html/body/div[5]/md-menu-content/md-menu-item[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 172, enabled = true,groups = {"Customer Admin"})
	public void BCT0065verifyCardInList4() throws IOException, InterruptedException {
		//verify card
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[2]/div/div[1]/div[1]/div[3]");
		Thread.sleep(3000);
	}
	
	@Test(priority = 173, enabled = true,groups = {"Customer Admin"})
	public void BCT0066openCardInList4() throws IOException, InterruptedException {
		//verify card
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[2]/div/div[1]");
		Thread.sleep(3000);
	}		
	@Test(priority = 174, enabled = true,groups = {"Customer Admin"})
	public void BCT0066addCommentInCard() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[2]/div/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 175, enabled = true,groups = {"Customer Admin"})
	public void BCT0067dragAndDropToList3() throws IOException, InterruptedException {
		//drag from list 4 to list 3
		dragAnddropByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[2]/div/div[1]", "html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 176, enabled = true,groups = {"Customer Admin"})
	public void BCT0068goToTask() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 177, enabled = true,groups = {"Customer Admin"})
	public void BCT0068customerAdminLogout() throws InterruptedException {
		//Logout
		Thread.sleep(3000);
		clickByXpath("/html/body/div/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");	
		Thread.sleep(3000);
		clickByXpath("/html/body/div[4]/md-menu-content/md-menu-item[4]/button");
		Thread.sleep(3000);
		closeBrowser();
	
	}
	@Test(priority = 178, enabled = true,groups = {"Read Only"})
	public void BCT0069readonlyLogin() throws IOException, InterruptedException {
		String[][] data = getlogin();
		String user = data[4][0];
		String pass = data[4][1];
		String browser = data [4][2];
		String role = data [4][3];
		String Url = data [4][4];
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
	@Test(priority = 179, enabled = true,groups = {"Read Only"})
	public void BCT0069boards() throws IOException, InterruptedException {
		//go to boards and try to add card
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[1]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 180, enabled = true,groups = {"Read Only"})
	public void BCT0069phaseeco2() throws IOException, InterruptedException {
		//go to phase eco 2
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 181, enabled = true,groups = {"Read Only"})
	public void BCT0070clickTheAddCardButton() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[1]/div/div[3]/ms-sb-add-card/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 182, enabled = true,dataProvider = "EnterReadOnlyCard",groups = {"Read Only"})
	public void BCT0070enterReadOnlyCardTitle(String cardtitle) throws IOException, InterruptedException {
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[1]/div/div[3]/ms-sb-add-card/div[2]/form/md-input-container/input", cardtitle);
		Thread.sleep(3000);
	}
	@Test(priority = 183, enabled = true,groups = {"Read Only"})
	public void BCT0070clickAddButton() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[1]/div/div[3]/ms-sb-add-card/div[2]/form/div/button[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 184, enabled = true,groups = {"Read Only"})
	public void BCT0070verifystatus() throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 185, enabled = true,groups = {"Read Only"})
	public void BCT0071openReadOnllyCard() throws IOException, InterruptedException {
		//try to edit card 
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[1]/div/div[2]/div/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 186, enabled = true,dataProvider = "EnterCardName",groups = {"Read Only"})
	public void BCT0071CardName(String cardname) throws IOException, InterruptedException {
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[1]/div/div[1]/div[2]/div/form/span/input",cardname);
		Thread.sleep(3000);
	}
	@Test(priority = 187, enabled = true,groups = {"Read Only"})
	public void BCT0071clickAddCardButton() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[1]/div/div[1]/div[2]/div/form/span/span/button[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 188, enabled = true,groups = {"Read Only"})
	public void BCT0071VERIFY() throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 189, enabled = true,groups = {"Read Only"})
	public void BCT0072Clickontasktab() throws IOException, InterruptedException {
		//Go to tasks and try to add a task
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 190, enabled = true,groups = {"Read Only"})
	public void BCT0073ClickAddbutton() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-sidenav/md-content/div[1]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 191, enabled = true,dataProvider = "EnterreadOnlyTaskTitle",groups = {"Read Only"})
	public void BCT0073ClickAddbutton(String title) throws IOException, InterruptedException {
		sendvaluebyxpath("html/body/div[3]/md-dialog/md-dialog-content/md-input-container/input", title);
		Thread.sleep(4000);
	}
	@Test(priority = 192, enabled = true,groups = {"Read Only"})
	public void BCT0073verifymessage() throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div/span");
	}
	@Test(priority = 193,  enabled = true,groups = {"Read Only"})
	public void BCT0073readOnlyLogout() throws InterruptedException {
		//Logout
		Thread.sleep(3000);
		clickByXpath("/html/body/div/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");	
		Thread.sleep(3000);
		clickByXpath("/html/body/div[4]/md-menu-content/md-menu-item[4]/button");
		//*[@id="menu_container_354"]/md-menu-content/md-menu-item[4]/button
		Thread.sleep(3000);
		closeBrowser();
	}
	
	
 @AfterClass
	   public void afterClass() {
	   //   System.out.println("in afterClass");
	   }

 @DataProvider(name = "EnterPeCardTitle")
 public Object[][] cardCredentials0() throws IOException {

	    Object[][] data = enterPeCardTitle();

	    return data;
 }
 @DataProvider(name = "AddReleaseCoordinator")
 public Object[][] cardCredentials1() throws IOException {

	    Object[][] data = addCardOwner();

	    return data;
 }
@DataProvider(name = "EnterReleaseCoordinatorDueDate")
 public Object[][] cardCredentials2() throws IOException {

 	    Object[][] data = enterRcDueDate();

   	    return data;
 }
@DataProvider(name = "EnterReleaseCoordinatorDescription")
public Object[][] cardCredentials3() throws IOException {

	    Object[][] data = enterReleaseCoordDesc();

  	    return data;
}

@DataProvider(name = "EnterReleaseCoordinatorAffobjNumber")
public Object[][] cardCredentials4() throws IOException {

	    Object[][] data = enterRcAffObjNumber();

  	    return data;
}
@DataProvider(name = "EnterPriority")
public Object[][] cardCredentials5() throws IOException {

	    Object[][] data = Enterthepriority();

  	    return data;
}
@DataProvider(name = "EnterRcTaskTitle")
public Object[][] cardCredentials6() throws IOException {

	    Object[][] data = enterRcTaskTitle();

  	    return data;
}

@DataProvider(name = "EnterRcTaskOwner")
public Object[][] cardCredentials7() throws IOException {

	    Object[][] data = enterRcTaskOwner();

  	    return data;
}

@DataProvider(name = "EnterRcTaskOwnerTwo")
public Object[][] cardCredentials8() throws IOException {

	    Object[][] data = enterRcTaskOwnerTwo();

  	    return data;
}
	 @DataProvider(name = "EnterRcTaskStartDate")
	 public Object[][] cardCredentials9() throws IOException {
	
	 Object[][] data = enterRcTaskStartDate();
	
	 return data;
	 }
	 @DataProvider(name = "EnterRcTaskEndDate")
	 public Object[][] cardCredentials10() throws IOException {
	
	 Object[][] data = enterRcTaskEndDate();
	
	 return data;
	 }
	 @DataProvider(name = "EnterReleaseCoordinatorTaskTitle")
	 public Object[][] cardCredentials11() throws IOException {
	
	 Object[][] data = enterRcTaskTwoTitle();
	
	 return data;
	 }
	 @DataProvider(name = "EnterReleaseCoordinatorTaskOwnerTwo")
	 public Object[][] cardCredentials12() throws IOException {
	
	 Object[][] data = enterReleasecoordTaskOwnerTwo();
	
	 return data;
	 }
	 @DataProvider(name = "EnterReleaseCoordinatorTaskTwoStartDate")
	 public Object[][] cardCredentials13() throws IOException {
	
	 Object[][] data = enterRcTaskStartDateTwo();
	
	 return data;
	 }
	 @DataProvider(name = "EnterReleaseCoordinatorTaskTwoEndDate")
	 public Object[][] cardCredentials14() throws IOException {
	
	 Object[][] data = enterRcTaskEndDateTwo();
	
	 return data;
	 }
	 @DataProvider(name = "EnterApproval1Desc")
	 public Object[][] cardCredentials15() throws IOException {
	
	 Object[][] data = enterApproval1Desc();
	
	 return data;
	 }
	 @DataProvider(name = "EnterApproval2Desc")
	 public Object[][] cardCredentials16() throws IOException {
	
	 Object[][] data = enterApproval2Desc();
	
	 return data;
	 }
	 @DataProvider(name = "EnterApproval2DueDate")
	 public Object[][] cardCredentials17() throws IOException {
	
	 Object[][] data = enterApproval2Duedate();
	
	 return data;
	 }
	 @DataProvider(name = "EnterThePrior")
	 public Object[][] cardCredentials18() throws IOException {
	
	 Object[][] data = enterPriority();
	
	 return data;
	 }
	 @DataProvider(name = "EnterThirdTaskTitle")
	 public Object[][] cardCredentials19() throws IOException {
	
	 Object[][] data = enterThirdTitle();
	
	 return data;
	 }
	 @DataProvider(name = "EnterThirdOwner")
	 public Object[][] cardCredentials20() throws IOException {
			
		 Object[][] data = enterThirdOwner();
		
		 return data;
		 }
	 @DataProvider(name = "EnterThirdStartDate")
	 public Object[][] cardCredentials21() throws IOException {
	
	 Object[][] data = enterThirdStartDate();
	
	 return data;
	 }
	 @DataProvider(name = "EnterThirdEndDate")
	 public Object[][] cardCredentials22() throws IOException {
	
	 Object[][] data = enterThirdEndDate();
	
	 return data;
	 }
	 @DataProvider(name = "EnterThirdDesc")
	 public Object[][] cardCredentials23() throws IOException {
	
	 Object[][] data = enterThirdDesc();
	
	 return data;
	 }
	 @DataProvider(name = "Entercomment")
	 public Object[][] cardCredentials24() throws IOException {
	
	 Object[][] data = enterComment();
	
	 return data;
	 }
	 @DataProvider(name = "EnterApproval3Desc")
	 public Object[][] cardCredentials25() throws IOException {
	
	 Object[][] data = enterApproval3Desc();
	
	 return data;
	 }
	 @DataProvider(name = "EnterApproval3Owner")
	 public Object[][] cardCredentials26() throws IOException {
	
	 Object[][] data = enterApproval3Owner();
	
	 return data;
	 }
	 @DataProvider(name = "EnterRcDescription")
	 public Object[][] cardCredentials27() throws IOException {
	
	 Object[][] data = enterRcDesc();
	
	 return data;
	 }
	 @DataProvider(name = "AddComment")
	 public Object[][] cardCredentials28() throws IOException {
	
	 Object[][] data = addComment();
	
	 return data;
	 }
	 @DataProvider(name = "EnterDes")
	 public Object[][] cardCredentials29() throws IOException {
	
	 Object[][] data = enterdesc();
	
	 return data;
	 }
	 @DataProvider(name = "EnterReadOnlyCard")
	 public Object[][] cardCredentials30() throws IOException {
	
	 Object[][] data = readOnlyCardTitle();
	
	 return data;
	 }
	 @DataProvider(name = "EnterCardName")
	 public Object[][] cardCredentials31() throws IOException {
	
	 Object[][] data = readOnlyCardName();
	
	 return data;
	 }
	 @DataProvider(name = "EnterreadOnlyTaskTitle")
	 public Object[][] cardCredentials32() throws IOException {
	
	 Object[][] data = readonlyTaskTitle();
	
	 return data;
	 }
}
