package fusepackage;

import java.io.IOException;

import javax.print.DocFlavor.STRING;

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

import net.sourceforge.htmlunit.corejs.javascript.ast.ThrowStatement;

public class FuseTask extends WrapperClass{
	
	
	@BeforeClass
	   public void beforeMethod() {
	      //Do Nothing
	   }
	
	@Test(priority = 1, enabled = true,groups = {"Project Engineer"})
	public void projectEngineerLogin() throws IOException, InterruptedException {
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
		Thread.sleep(3000);
		System.out.println("The " + role + "Login Successfully");
		//Escape from the Guide menu
		clickByHDEmXpath("/html/body/div[6]/div/div[5]/a[2]");
		Thread.sleep(5000);
		iconClick("html/body/div[1]/div[1]/md-sidenav[1]/md-toolbar/md-icon");
	}
	
	@Test(priority = 2,enabled = true,groups = {"Project Engineer"})
	public void clickOnTasks()throws IOException, InterruptedException {
		//click on task tab
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 3,enabled = true,groups = {"Project Engineer"})
	public void clickAddTask()throws IOException, InterruptedException {
		//click add task to create task
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-sidenav/md-content/div[1]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 4,enabled = true, dataProvider = "EnterProjectEngineerTaskTitle",groups = {"Project Engineer"})
	public void enterTaskTitle(String title)throws IOException, InterruptedException {
		//Enter Project Engineer task title
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/md-input-container/input", title);
		Thread.sleep(5000);
	}
	@Test(priority = 5,enabled = true,groups = {"Project Engineer"})
	public void clickCloseButton()throws IOException, InterruptedException {
		//close the task
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(4000);
	}
	@Test(priority = 6,enabled = true,groups = {"Project Engineer"})
	public void selectCreatedTask()throws IOException, InterruptedException {
		//select the created task
	    clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 7,enabled = true,dataProvider = "EnterStartDate",groups = {"Project Engineer"})
	public void enterStartDate(String start)throws IOException, InterruptedException {
		//Enter the start date
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[2]/div[1]/md-datepicker/div[1]/input", start);
		Thread.sleep(3000);
	}
	@Test(priority = 8,enabled = true,dataProvider = "EnterEndDate",groups = {"Project Engineer"})
	public void enterEndDate(String end)throws IOException, InterruptedException {
		//Enter the end date
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[2]/div[2]/md-datepicker/div[1]/input", end);
		Thread.sleep(3000);
	}
	@Test(priority = 9,enabled = true,groups = {"Project Engineer"})
	public void clickTagButton()throws IOException, InterruptedException {
		//click and add two tags
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/md-menu[1]/button");
		Thread.sleep(3000);	
	}
	@Test(priority = 10,enabled = true,groups = {"Project Engineer"})
	public void clickAffectedObject()throws IOException, InterruptedException {
		//click one affected object
		clickByXpath("html/body/div[5]/md-menu-content/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-menu-item[1]/button");
		Thread.sleep(4000);
	}
	@Test(priority = 11,enabled = true,groups = {"Project Engineer"})
	public void clickAnotherAffectedObject()throws IOException, InterruptedException {
		//click another affected object
		clickByXpath("html/body/div[5]/md-menu-content/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-menu-item[2]/button");
		Thread.sleep(4000);
	}
	@Test(priority = 12,enabled = true,groups = {"Project Engineer"})
	public void clickBackDrop()throws IOException, InterruptedException {
		//click outside to close the affected object dropdown
		clickByXpath("html/body/md-backdrop[1]");
		Thread.sleep(4000);
	}
	@Test(priority = 13,enabled = true,groups = {"Project Engineer"})
	public void clickCloseIcon()throws IOException, InterruptedException {
		//click the close button
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(4000);
	}
	@Test(priority = 14,enabled = true,groups = {"Project Engineer"})
	public void clickCreatedTask()throws IOException, InterruptedException {
		//select the created project engineer task 
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 15,enabled = true,groups = {"Project Engineer"})
	public void removeDefaultOwner()throws IOException, InterruptedException {
		//Remove the default owner
		clickByXpath("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/md-chip/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 16,enabled = true,groups = {"Project Engineer"})
	public void verifyStatus()throws IOException, InterruptedException {
		//Verify warning status after removing default owner
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 17,enabled = true,groups = {"Project Engineer"})
	public void closeTaskWindow()throws IOException, InterruptedException {
		//Close the window
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 18,enabled = true,groups = {"Project Engineer"})
	public void openCreatedTask()throws IOException, InterruptedException {
		//again select the created task and verify the default owner exist
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 19,enabled = true,groups = {"Project Engineer"})
	public void verifyDefaultOwner()throws IOException, InterruptedException {
		//verify the owner
		verifystatus("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/md-chip/div[1]/md-chip-template/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 20,enabled = true,groups = {"Project Engineer"})
	public void closeWindow()throws IOException, InterruptedException {
		//close the window
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 20,enabled = true,groups = {"Project Engineer"})
	public void clickBoardsTab()throws IOException, InterruptedException {
		//click on boards 
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[1]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 21,enabled = true,groups = {"Project Engineer"})
	public void clicktaskTab()throws IOException, InterruptedException {
		//click on task tab
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 22,enabled = true,groups = {"Project Engineer"})
	public void clicktask()throws IOException, InterruptedException {
		//click on created task
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 23,enabled = true,groups = {"Project Engineer"})
	public void CloseWindow()throws IOException, InterruptedException {
		//close the window
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 24, enabled = true,groups = {"Project Engineer"})
	public void logout() throws InterruptedException {
		//Logout
		Thread.sleep(3000);
		clickByXpath("/html/body/div/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");	
		Thread.sleep(3000);
		clickByXpath("/html/body/div[4]/md-menu-content/md-menu-item[4]/button");
		//*[@id="menu_container_354"]/md-menu-content/md-menu-item[4]/button
		Thread.sleep(3000);
		closeBrowser();
	}
	@Test(priority = 25,  enabled = true,groups = {"Project Manager"})
	public void projectManagerlogin() throws IOException, InterruptedException {
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
	}
	@Test(priority = 26,enabled = true,groups = {"Project Manager"})
	public void clickTaskTab()throws IOException, InterruptedException {
		//click task tab
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 27,enabled = true,groups = {"Project Manager"})
	public void clickAddTaskButton()throws IOException, InterruptedException {
		//click add button
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-sidenav/md-content/div[1]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 28,enabled = true,dataProvider = "EnterProjectManagerTaskTitle",groups = {"Project Manager"})
	public void enterTitle(String pmtitle)throws IOException, InterruptedException {
		//Enter title
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/md-input-container/input", pmtitle);
		Thread.sleep(5000);
	}
	@Test(priority = 29,enabled = true,groups = {"Project Manager"})
	public void clickCloseTaskButton()throws IOException, InterruptedException {
		//close task window
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 30,enabled = true,groups = {"Project Manager"})
	public void clickCreatedProjectManagerTask()throws IOException, InterruptedException {
		//select the created task
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 31,enabled = true, dataProvider = "EnterProjectManagerTaskStartDate",groups = {"Project Manager"})
	public void enterProjectManagerTaskStartDate(String pstart)throws IOException, InterruptedException {
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[2]/div[1]/md-datepicker/div[1]/input", pstart);
		Thread.sleep(3000);
	}
	@Test(priority = 32,enabled = true, dataProvider = "EnterProjectManagerTaskEndDate",groups = {"Project Manager"})
	public void enterProjectManagerTaskEndDate(String pend)throws IOException, InterruptedException {
		sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[2]/div[2]/md-datepicker/div[1]/input", pend);
		Thread.sleep(3000);
	}
	@Test(priority = 33,enabled = true,groups = {"Project Manager"})
	public void clickTaskCloseButton()throws IOException, InterruptedException {
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 34,enabled = true,groups = {"Project Manager"})
	public void clickProjectManagerTask()throws IOException, InterruptedException {
		//select the created task 
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 35,enabled = true,groups = {"Project Manager"})
	public void clickOwnerCloseButton()throws IOException, InterruptedException {
        //remove default owner
		clickByXpath("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/md-chip/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 36,enabled = true,groups = {"Project Manager"})
	public void verifyWarningStatus()throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 37,enabled = true,groups = {"Project Manager"})
	public void closeTask()throws IOException, InterruptedException {
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);	
	}
	@Test(priority = 38,enabled = true,groups = {"Project Manager"})
	public void selectCreatedProjectManagerTask()throws IOException, InterruptedException {
		//select the created task and add Release Co-ordinator
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 39,enabled = true,dataProvider = "AddReleaseCoordinator",groups = {"Project Manager"})
	public void addCoordinator(String rc)throws IOException, InterruptedException {
		sendvaluebyxpathand2downclick("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", rc);
		Thread.sleep(4000);
	}
	@Test(priority = 40,enabled = true,groups = {"Project Manager"})
	public void verifyCoordinator()throws IOException, InterruptedException {
		verifystatus("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/md-chip[2]/div[1]/md-chip-template/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 41,enabled = true,groups = {"Project Manager"})
	public void verifyAnotherCoordinator()throws IOException, InterruptedException {
		verifystatus("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/md-chip[1]/div[1]/md-chip-template/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 42,enabled = true,groups = {"Project Manager"})
	public void closeProjectManagerTaskWindow()throws IOException, InterruptedException {
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 43,enabled = true,groups = {"Project Manager"})
	public void clickBoards()throws IOException, InterruptedException {
		//click on boards and then task and created task
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[1]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 44,enabled = true,groups = {"Project Manager"})
	public void clickTasksTab()throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 45,enabled = true,groups = {"Project Manager"})
	public void selectProjectManagerTask()throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 46,enabled = true,groups = {"Project Manager"})
	public void closeTheTaskWindow()throws IOException, InterruptedException {
		clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
    @Test(priority = 47,enabled = true,groups = {"Project Manager"})
    public void logout2() throws InterruptedException {
		//Logout
		Thread.sleep(3000);
		clickByXpath("/html/body/div/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");	
		Thread.sleep(3000);
		clickByXpath("/html/body/div[4]/md-menu-content/md-menu-item[4]/button");
		//*[@id="menu_container_354"]/md-menu-content/md-menu-item[4]/button
		Thread.sleep(3000);
		closeBrowser();
	}
    
    @Test(priority = 48,enabled = true,groups = {"Release Co-Ordinator"})
	public void releaseCoordinatorLogin() throws IOException, InterruptedException {
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
    @Test(priority = 49,enabled = true,groups = {"Release Co-Ordinator"})
	public void selectTasksTab()throws IOException, InterruptedException {
    	clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
    }
    @Test(priority = 50,enabled = true,groups = {"Release Co-Ordinator"})
	public void selectProjManagerTask()throws IOException, InterruptedException {
    	//click the pmtask and check by removing the owner
    	clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div[1]");
    	Thread.sleep(3000);
    }
    @Test(priority = 51,enabled = true,groups = {"Release Co-Ordinator"})
	public void removeOwner()throws IOException, InterruptedException {
    	clickByXpath("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/md-chip[1]/div[2]/button");
		Thread.sleep(3000);
    }
    @Test(priority = 52,enabled = true,groups = {"Release Co-Ordinator"})
	public void verifywarningStatus()throws IOException, InterruptedException {
    	verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
    }
    @Test(priority = 53,enabled = true,groups = {"Release Co-Ordinator"})
	public void close()throws IOException, InterruptedException {
    	clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
    }
    @Test(priority = 54,enabled = true,groups = {"Release Co-Ordinator"})
   	public void clickAddNewTask()throws IOException, InterruptedException {
    	//Add Release Coordinator task
    	clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-sidenav/md-content/div[1]/button");
		Thread.sleep(3000);
    }
    @Test(priority = 54,enabled = true,dataProvider = "EnterReleaseCoordinatorTitle",groups = {"Release Co-Ordinator"})
   	public void enterReleaseCoordinatorTaskTitle(String rctitle)throws IOException, InterruptedException {
    	sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/md-input-container/input", rctitle);
		Thread.sleep(5000);
    }
    @Test(priority = 55,enabled = true,groups = {"Release Co-Ordinator"})
	public void closeRCTaskWindow()throws IOException, InterruptedException {
    	clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
    }
    @Test(priority = 56,enabled = true,groups = {"Release Co-Ordinator"})
	public void OpenReleaseCoordinatorTask()throws IOException, InterruptedException {
    	//select the created RC task and add start and end date and add tags
    	clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div[2]");
    	Thread.sleep(3000);
    }
    @Test(priority = 57,enabled = true,dataProvider = "EnterRCStartDate",groups = {"Release Co-Ordinator"})
	public void enterStartdate(String rcstart)throws IOException, InterruptedException {
    	//enter the start date
    	sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[2]/div[1]/md-datepicker/div[1]/input", rcstart);
		Thread.sleep(3000);
    }
    @Test(priority = 58,enabled = true,dataProvider = "EnterRCEndDate",groups = {"Release Co-Ordinator"})
	public void enterEnddate(String rcend)throws IOException, InterruptedException {
    	//enter the end date
    	sendvaluebyxpath("html/body/div[4]/md-dialog/md-dialog-content/div[2]/div[2]/md-datepicker/div[1]/input", rcend);
		Thread.sleep(3000);
    }
    @Test(priority = 59,enabled = true,groups = {"Release Co-Ordinator"})
	public void clickAffectedObjectIcon()throws IOException, InterruptedException {
    	//click affetcted object icon
    	clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/md-menu[1]/button");
		Thread.sleep(3000);
    }
    @Test(priority = 60,enabled = true,groups = {"Release Co-Ordinator"})
	public void clickAffectedObj()throws IOException, InterruptedException {
    	//click one affected object
    	clickByXpath("html/body/div[5]/md-menu-content/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-menu-item[1]/button");
		Thread.sleep(4000);
    }
    @Test(priority = 61,enabled = true,groups = {"Release Co-Ordinator"})
	public void clickAnotherAffectedObj()throws IOException, InterruptedException {
    	//click next affected object
    	clickByXpath("html/body/div[5]/md-menu-content/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-menu-item[2]/button");
		Thread.sleep(4000);
    }
    @Test(priority = 62,enabled = true,groups = {"Release Co-Ordinator"})
   	public void clickOutside()throws IOException, InterruptedException {
    	//click outside the affctedobj dropdown
    	clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div");
		Thread.sleep(4000);
    }
    @Test(priority = 63,enabled = true,groups = {"Release Co-Ordinator"})
   	public void closetask()throws IOException, InterruptedException {
    	//close the task window
    	clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
    }
    @Test(priority = 64,enabled = true,groups = {"Release Co-Ordinator"})
   	public void clickRcTask()throws IOException, InterruptedException {
    	//select the created task 
    	clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div[2]");
    	Thread.sleep(3000);
    }
    @Test(priority = 65,enabled = true,groups = {"Release Co-Ordinator"})
   	public void deleteOwner()throws IOException, InterruptedException {
    	//click to remove the default owner
    	clickByXpath("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/md-chip/div[2]/button");
		Thread.sleep(3000);
    }
    @Test(priority = 66,enabled = true,groups = {"Release Co-Ordinator"})
   	public void verifyWarning()throws IOException, InterruptedException {
    	verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
    }
    @Test(priority = 67,enabled = true,groups = {"Release Co-Ordinator"})
   	public void closeTaskwindow()throws IOException, InterruptedException {
    	//close the window
    	clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
    }
    @Test(priority = 68,enabled = true,groups = {"Release Co-Ordinator"})
   	public void selectCreatedtask()throws IOException, InterruptedException {
    	//select the created task and add Release Co-ordinator
    	clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div[2]");
    	Thread.sleep(3000);
    }
    @Test(priority = 69,enabled = true,dataProvider = "AddProjectManager",groups = {"Release Co-Ordinator"})
   	public void addProjectManagerAsOwner(String pm)throws IOException, InterruptedException {
    	//add Project manner as owner
    	sendvaluebyxpathand2downclick("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", pm);
		Thread.sleep(4000);
    }
    @Test(priority = 70,enabled = true,groups = {"Release Co-Ordinator"})
	public void verifyOwner()throws IOException, InterruptedException {
    	//verify the owner
    	verifystatus("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/md-chip[2]/div[1]/md-chip-template/div/span");
		Thread.sleep(3000);
    }
    @Test(priority = 71,enabled = true,groups = {"Release Co-Ordinator"})
   	public void verifyNextOwner()throws IOException, InterruptedException {
    	//verify the next owner
    	verifystatus("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/md-chip[1]/div[1]/md-chip-template/div/span");
		Thread.sleep(3000);
       }
    @Test(priority = 72,enabled = true,groups = {"Release Co-Ordinator"})
   	public void clickClose()throws IOException, InterruptedException {
    	//close the task window
    	clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);	
    }
    @Test(priority = 73,enabled = true,groups = {"Release Co-Ordinator"})
   	public void clickBoardstab()throws IOException, InterruptedException {
    	//click on boards
    	clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[1]/div/a");
    	Thread.sleep(3000);
    }
    @Test(priority = 74,enabled = true,groups = {"Release Co-Ordinator"})
   	public void clickTaskstab()throws IOException, InterruptedException {
    	//click on tasks tab
    	clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[2]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
    }
    @Test(priority = 75,enabled = true,groups = {"Release Co-Ordinator"})
   	public void clickCreatedtask()throws IOException, InterruptedException {
    	//click the created task
    	clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/div[2]/div[2]/md-content/div[1]/div");
		Thread.sleep(3000);
    }
    @Test(priority = 76,enabled = true,groups = {"Release Co-Ordinator"})
   	public void clickCloseTask()throws IOException, InterruptedException {
    	//close the task window
    	clickByXpath("html/body/div[4]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
    } 
    @Test(priority = 77,enabled = true,groups = {"Release Co-Ordinator"})
    public void logout3() throws InterruptedException {
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
	   public void afterMethod() {
	      System.out.println("in afterMethod");
	   }
    

  
   @DataProvider(name = "EnterProjectEngineerTaskTitle")
   public Object[][] taskCredentials1() throws IOException {

	    Object[][] data = enterPeTitle();

	    return data;
}
   @DataProvider(name = "EnterStartDate")
   public Object[][] taskCredentials2() throws IOException {

	    Object[][] data = enterPeStartDate();

	    return data;
}
   @DataProvider(name = "EnterEndDate")
   public Object[][] taskCredentials3() throws IOException {

	    Object[][] data = enterPeEndDate();

	    return data;
}
   @DataProvider(name = "EnterProjectManagerTaskTitle")
   public Object[][] taskCredentials4() throws IOException {

	    Object[][] data = enterPmTitle();

	    return data;
   }
   @DataProvider(name = "EnterProjectManagerTaskStartDate")
   public Object[][] taskCredentials5() throws IOException {

	    Object[][] data = enterPmStartDate();

	    return data;
   }
   @DataProvider(name = "EnterProjectManagerTaskEndDate")
   public Object[][] taskCredentials6() throws IOException {

	    Object[][] data = enterPmEndDate();

	    return data;
   }
   @DataProvider(name = "AddReleaseCoordinator")
   public Object[][] taskCredentials7() throws IOException {

	    Object[][] data = addReleaseCoordinator();

	    return data;
   }
   @DataProvider(name = "EnterReleaseCoordinatorTitle")
   public Object[][] taskCredentials8() throws IOException {

	    Object[][] data = enterReleaseCoordinatorTitle();

	    return data;
   }
   @DataProvider(name = "EnterRCStartDate")
   public Object[][] taskCredentials9() throws IOException {

	    Object[][] data = enterRcStartDate();

	    return data;
   }
   @DataProvider(name = "EnterRCEndDate")
   public Object[][] taskCredentials10() throws IOException {

	    Object[][] data = enterRcEndDate();

	    return data;
   }
   @DataProvider(name = "AddProjectManager")
   public Object[][] taskCredentials11() throws IOException {

	    Object[][] data = addProjectManager();

	    return data;
   }
}