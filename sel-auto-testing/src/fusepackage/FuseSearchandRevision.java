package fusepackage;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FuseSearchandRevision extends WrapperClass{
	String ProductName = null;
	String PartName = null;
	@BeforeClass
	public void login() throws IOException, InterruptedException {
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
	@Test(priority = 1,enabled = true,groups = {"Search and Revision"})
	public void RAR001ClickonProductsFromLeftTree()throws IOException, InterruptedException {
		//Products
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[1]/div/a/span");
		Thread.sleep(3000);
	}
	@Test(priority = 2,dataProvider = "Product Search", enabled = true,groups = {"Search and Revision"})
	public void RAR002EntertheProductDetailstoSearch(String Search)throws IOException, InterruptedException{
	  //Enter value to search
	  sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div[2]/div[1]/input", Search);
	  Thread.sleep(3000);
	}
	@Test(priority = 3, enabled = true,groups = {"Search and Revision"})
	public void RAR002TapOnEntertoSearchProducts()throws IOException, InterruptedException{
	  enter();
	  Thread.sleep(2000);
	}
	@Test(priority = 4, enabled = true,groups = {"Search and Revision"})
	public void RAR002FindtheProductfromtheSearch()throws IOException, InterruptedException{
	  Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/a");
	}
	@Test(priority = 5, enabled = true,dependsOnMethods={"RAR002FindtheProductfromtheSearch"},groups = {"Search and Revision"})
	public void RAR002ClickonProductfromtheSearch()throws IOException, InterruptedException{
	  clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/a");
	}
	@Test(priority = 6,enabled = true,groups = {"Search and Revision"})
	public void RAR003SearchChangeStatusinProduct() throws IOException,InterruptedException{
		//Click on Change Status
		Searchelement("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/md-menu/button[@class='white-fg md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 7,enabled = true,groups = {"Search and Revision"})
	public void RAR004ClickonChangeStatusinProduct() throws IOException,InterruptedException{
		//Click on Change Status
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/md-menu/button[@class='white-fg md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 8,enabled = true,groups = {"Search and Revision"})
	public void RAR004ClickOnReleaseButtoninChangeStatusofProduct() throws IOException,InterruptedException{
		//Click on released button
		clickByXpath("//div[@class='_md md-open-menu-container md-whiteframe-z2 md-default-theme md-active md-clickable']/md-menu-content/md-menu-item/button");
		Thread.sleep(3000);
	}
	@Test(priority = 9,enabled = true,groups = {"Search and Revision"})
	public void RAR005ClickYESonConfirmationMessageinChangeStatusofProduct() throws IOException,InterruptedException{
		//Click Yes on Confirmation Message
		clickByXpath("html/body/div[5]/md-dialog/md-dialog-actions/button[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 10,enabled = true,groups = {"Search and Revision"})
	public void RAR006CheckforSaveButton()throws IOException, InterruptedException{
		Searchelement("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/button[@class='md-raised md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 11,enabled = true,groups = {"Search and Revision"})
	public void RAR006CheckforDeleteButton()throws IOException, InterruptedException{
		Searchelement("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[3]/button[@class='md-raised md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 12,enabled = true,groups = {"Search and Revision"})
	public void RAR007ClickOnTimelineTabfromProductView() throws InterruptedException,IOException{
		//Click on Time-Line
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[7]");
		Thread.sleep(3000);
	}
	@Test(priority = 13,enabled = true,groups = {"Search and Revision"})
	public void RAR008ClickOnBasicInfoTabfromProductView() throws InterruptedException,IOException{
		//Click on Basic Info
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]/span");
		Thread.sleep(3000);
	}
	@Test(priority = 14,enabled = true,dataProvider = "Product BasicInfo ProductName",groups = {"Search and Revision"})
	public void RAR008EnterthePartNameinBasicInfofromofProduct(String ProductName) throws InterruptedException,IOException{
		//Click on Basic Info
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/md-input-container/input", ProductName);
		Thread.sleep(3000);
	}
	@Test(priority = 15,enabled = true,dataProvider = "Product BasicInfo ProjectName",groups = {"Search and Revision"})
	public void RAR008EntertheProjectNameinBasicInfofromofProduct(String ProjectName) throws InterruptedException,IOException{
		//Click on Basic Info
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[3]/md-chips[1]/md-chips-wrap/div/div/input", ProjectName);
		Thread.sleep(3000);
	}
	@Test(priority = 16,enabled = true,groups = {"Search and Revision"})
	public void RAR009CheckheaderbuttonsforIncrementRevisionbuttoninProduct() throws InterruptedException, IOException{
		//Get Part Identity after that the Part Incremental Revision 
		gettexttrim("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div[2]/div[1]/div[1]/span[3]/strong");
		Thread.sleep(3000);
	}
	@Test(priority = 17,enabled = true,groups = {"Search and Revision"})
	public void RAR010ClickonIncrementalRevisionButtoninProduct() throws InterruptedException, IOException{
		//Click on Incremental Revision Button
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/button[@class='white-fg md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 18,enabled = true,groups = {"Search and Revision"})
	public void RAR011ClickYesonConfirmationMessageinIncrementalRevisionofProduct() throws InterruptedException, IOException{
		//Click YES on Confirmation Message
		clickByXpath("html/body/div[5]/md-dialog/md-dialog-actions/button[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 19,dataProvider = "Product Incremental Revision Notes",enabled = true,groups = {"Search and Revision"})
	public void RAR011EntertheRevisionNotesinIncrementalRevisionofProduct(String Notes) throws InterruptedException, IOException{
		//Enter the Revision Notes in Incremental revision
		sendvaluebyxpath("//div[@id='content-container']/div[2]/md-dialog/form/md-dialog-content/md-input-container/input", Notes);
		Thread.sleep(3000);
	}
	@Test(priority = 20,enabled = true,groups = {"Search and Revision"})
	public void RAR011ClickonCreateButtoninIncrementalRevisionofProduct() throws InterruptedException, IOException{
		//Click Create Button on Incremental Revision  
		clickByXpath("//div[@id='content-container']/div[2]/md-dialog/form/md-dialog-actions/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 21,enabled = true,groups = {"Search and Revision"})
	public void RAR011GetStatusofProductIncrementalRevision() throws InterruptedException, IOException{
		//Get Status of the Part Incremental Revision
		verifystatus("/html/body/md-toast/div[@class='md-toast-content']");
		Thread.sleep(3000);
	}
	@Test(priority = 22,enabled = true,groups = {"Search and Revision"})
	public void RAR011GetProductIdentityafterIncrementalRevision() throws InterruptedException, IOException{
		//Get Part Identity after that the Part Incremental Revision 
		gettexttrim("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div/div[1]/div[1]/div[1]/span[3]/strong");
		Thread.sleep(3000);
	}
	@Test(priority = 23,enabled = true,groups = {"Search and Revision"})
	public void RAR012DataintheNewRevisionischeckintheBasicInfo() throws InterruptedException, IOException{
		//Get Status of the Part Incremental Revision
		gettext("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/md-input-container/input");
		Thread.sleep(3000);
	}
	@Test(priority = 24,enabled = true,groups = {"Search and Revision"},dependsOnMethods = {"RAR012DataintheNewRevisionischeckintheBasicInfo"})
	public void RAR012VerifyDataintheNewRevisionischeckintheBasicInfo() throws InterruptedException, IOException{
		//Get Status of the Part Incremental Revision
		a.equalsIgnoreCase(ProductName);
		Thread.sleep(3000);
	}
	@Test(priority = 25,enabled = true,groups = {"Search and Revision"})
	public void RAR013SearchBillofmaterialtapinProduct() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 26,enabled = true,dependsOnMethods={"RAR013SearchBillofmaterialtapinProduct"},groups = {"Search and Revision"})
	public void RAR013ClickonBillofmaterialtapinProduct() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 27,enabled = true,groups = {"Search and Revision"})
	public void RAR014ClickonAttachmentsTabinProduct() throws InterruptedException, IOException{
		//Click on Attachments
		clickByXpath("//div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[3]");
	    Thread.sleep(5000);
	}
	@Test(priority = 28,enabled = true,groups = {"Search and Revision"})
	public void RAR015ClickonAdditionalInfoTabinProduct() throws IOException,InterruptedException{
		//Go to Additional Info
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 29,enabled = true,groups = {"Search and Revision"})
	public void RAR015ClickonSourcingTapinProducts() throws IOException, InterruptedException {	
		//Go to Souring
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[4]");
		Thread.sleep(5000);
	}
	@Test(priority = 30,enabled = true,groups = {"Search and Revision"})
	public void RAR016ClickonProductsFromLeftTree()throws IOException, InterruptedException {
		//Products
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[1]/div/a/span");
		Thread.sleep(3000);
	}
	@Test(priority = 31,enabled = true,groups = {"Search and Revision"})
	public void RAR017ClickonPartsfromLeftTree()throws IOException, InterruptedException {
		//Parts
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 32,dataProvider = "Parts to Search", enabled = true,groups = {"Search and Revision"})
	public void RAR018EnterthePartDetailstoSearch(String Search)throws IOException, InterruptedException{
	  //Enter value to search
	  sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div[2]/div[1]/input", Search);
	  Thread.sleep(3000);
	}
	@Test(priority = 33, enabled = true,groups = {"Search and Revision"})
	public void RAR018TapOnEntertoSearchParts()throws IOException, InterruptedException{
	  enter();
	  Thread.sleep(2000);
	}
	@Test(priority = 34, enabled = true,groups = {"Search and Revision"})
	public void RAR018FindthePartfromtheSearch()throws IOException, InterruptedException{
	  Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/a");
	  Thread.sleep(2000);
	}
	@Test(priority = 35, enabled = true,dependsOnMethods={"RAR018FindthePartfromtheSearch"},groups = {"Search and Revision"})
	public void RAR018ClickonPartfromtheSearch()throws IOException, InterruptedException{
	  clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/a");
	  Thread.sleep(2000);
	}
	@Test(priority = 36,enabled = true,groups = {"Search and Revision"})
	public void RAR019SearchChangeStatusinPart() throws IOException,InterruptedException{
		//Click on Change Status
		Searchelement("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/md-menu/button[@class='white-fg md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 37,enabled = true,groups = {"Search and Revision"})
	public void RAR019ClickonChangeStatusinPart() throws IOException,InterruptedException{
		//Click on Change Status
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/md-menu/button[@class='white-fg md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 38,enabled = true,groups = {"Search and Revision"})
	public void RAR019ClickOnReleaseButtoninChangeStatusofPart() throws IOException,InterruptedException{
		//Click on released button
		clickByXpath("//div[@class='_md md-open-menu-container md-whiteframe-z2 md-default-theme md-active md-clickable']/md-menu-content/md-menu-item/button");
		Thread.sleep(3000);
	}
	@Test(priority = 39,enabled = true,groups = {"Search and Revision"})
	public void RAR020ClickYESonConfirmationMessageinChangeStatusofPart() throws IOException,InterruptedException{
		//Click Yes on Confirmation Message
		clickByXpath("html/body/div[5]/md-dialog/md-dialog-actions/button[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 40,enabled = true,groups = {"Search and Revision"})
	public void RAR021CheckforSaveButton()throws IOException, InterruptedException{
		Searchelement("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/button[@class='md-raised md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 41,enabled = true,groups = {"Search and Revision"})
	public void RAR021CheckforDeleteButton()throws IOException, InterruptedException{
		Searchelement("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[3]/button[@class='md-raised md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 42,enabled = true,groups = {"Search and Revision"})
	public void RAR022ClickOnTimelineTabfromProductView() throws InterruptedException,IOException{
		//Click on Time-Line
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[7]");
		Thread.sleep(3000);
	}
	@Test(priority = 43,enabled = true,groups = {"Search and Revision"})
	public void RAR023ClickOnBasicInfoTabfromPartView() throws InterruptedException,IOException{
		//Click on Basic Info
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]/span");
		Thread.sleep(3000);
	}
	@Test(priority = 44,enabled = true,dataProvider = "Part BasicInfo PartName",groups = {"Search and Revision"})
	public void RAR023EnterthePartNameinBasicInfofromofPart(String PartName) throws InterruptedException,IOException{
		//Click on Basic Info
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/md-input-container/input", PartName);
		Thread.sleep(3000);
	}
	@Test(priority = 45,enabled = true,dataProvider = "Part BasicInfo ProjectName",groups = {"Search and Revision"})
	public void RAR023EntertheProjectNameinBasicInfofromofPart(String ProjectName) throws InterruptedException,IOException{
		//Click on Basic Info
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[3]/md-chips[1]/md-chips-wrap/div/div/input", ProjectName);
		Thread.sleep(3000);
	}
	@Test(priority = 46,enabled = true,groups = {"Search and Revision"})
	public void RAR024CheckheaderbuttonsforIncrementRevisionbuttoninPart() throws InterruptedException, IOException{
		//Get Part Identity after that the Part Incremental Revision 
		gettexttrim("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div[2]/div[1]/div[1]/span[3]/strong");
		Thread.sleep(3000);
	}
	@Test(priority = 47,enabled = true,groups = {"Search and Revision"})
	public void RAR025ClickonIncrementalRevisionButtoninPart() throws InterruptedException, IOException{
		//Click on Incremental Revision Button
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/button[@class='white-fg md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 48,enabled = true,groups = {"Search and Revision"})
	public void RAR026ClickYesonConfirmationMessageinIncrementalRevisionofPart() throws InterruptedException, IOException{
		//Click YES on Confirmation Message
		clickByXpath("html/body/div[5]/md-dialog/md-dialog-actions/button[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 49,dataProvider = "Part Incremental Revision Notes",enabled = true,groups = {"Search and Revision"})
	public void RAR026EntertheRevisionNotesinIncrementalRevisionofPart(String Notes) throws InterruptedException, IOException{
		//Enter the Revision Notes in Incremental revision
		sendvaluebyxpath("//div[@id='content-container']/div[2]/md-dialog/form/md-dialog-content/md-input-container/input", Notes);
		Thread.sleep(3000);
	}
	@Test(priority = 50,enabled = true,groups = {"Search and Revision"})
	public void RAR026ClickonCreateButtoninIncrementalRevisionofPart() throws InterruptedException, IOException{
		//Click Create Button on Incremental Revision  
		clickByXpath("//div[@id='content-container']/div[2]/md-dialog/form/md-dialog-actions/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 51,enabled = true,groups = {"Search and Revision"})
	public void RAR026GetStatusofPartIncrementalRevision() throws InterruptedException, IOException{
		//Get Status of the Part Incremental Revision
		verifystatus("/html/body/md-toast/div[@class='md-toast-content']");
		Thread.sleep(3000);
	}
	@Test(priority = 52,enabled = true,groups = {"Search and Revision"})
	public void RAR026GetProductIdentityafterIncrementalRevision() throws InterruptedException, IOException{
		//Get Part Identity after that the Part Incremental Revision 
		gettexttrim("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div/div[1]/div[1]/div[1]/span[3]/strong");
		Thread.sleep(3000);
	}
	@Test(priority = 53,enabled = true,groups = {"Search and Revision"})
	public void RAR027DataintheNewRevisionischeckintheBasicInfo() throws InterruptedException, IOException{
		//Get Status of the Part Incremental Revision
		gettext("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/md-input-container/input");
		Thread.sleep(3000);
	}
	@Test(priority = 54,enabled = true,groups = {"Search and Revision"},dependsOnMethods = {"RAR027DataintheNewRevisionischeckintheBasicInfo"})
	public void RAR027VerifyDataintheNewRevisionischeckintheBasicInfo() throws InterruptedException, IOException{
		//Get Status of the Part Incremental Revision
		a.equalsIgnoreCase(PartName);
		Thread.sleep(3000);
	}
	@Test(priority = 55,enabled = true,groups = {"Search and Revision"})
	public void RAR028ClickonAttachmentsTabinProduct() throws InterruptedException, IOException{
		//Click on Attachments
		clickByXpath("//div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[3]");
	    Thread.sleep(5000);
	}
	@Test(priority = 56,enabled = true,groups = {"Search and Revision"})
	public void RAR029SearchBillofmaterialtapinPart() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 57,enabled = true,dependsOnMethods={"RAR029SearchBillofmaterialtapinPart"},groups = {"Search and Revision"})
	public void RAR029ClickonBillofmaterialtapinPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 58,enabled = true,groups = {"Search and Revision"})
	public void RAR030ClickonAdditionalInfoTabinPart() throws IOException,InterruptedException{
		//Go to Additional Info
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 59,enabled = true,groups = {"Search and Revision"})
	public void RAR030ClickonSourcingTapinPart() throws IOException, InterruptedException {	
		//Go to Souring
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[4]");
		Thread.sleep(5000);
	}
	@Test(priority = 60,enabled = true,groups = {"Search and Revision"})
	public void logoutfromProjectManager() throws InterruptedException {
		//Logout
		Thread.sleep(3000);
		clickByXpath("html/body/div[1]/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");
		Thread.sleep(3000);
		clickByXpath("html/body/div[3]/md-menu-content/md-menu-item[4]/button");
		Thread.sleep(3000);
		closeBrowser();
	}
	@Test(priority = 61,enabled = true,groups = {"Search and Revision"})
	public void loginasReleaseCoordinator() throws IOException, InterruptedException {
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
	@Test(priority = 62,enabled = true,groups = "Search and Revision")
	public void RAR031ClickOnBoardsFromLeftTree() throws IOException, InterruptedException {
		//Go to Boards 
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[2]/ul/li/ul/li/div/a");
		Thread.sleep(3000);	
	}
	@Test(priority = 63,enabled = true,groups = "Search and Revision")
	public void RAR032ClickOnECRBoards() throws IOException, InterruptedException {
		//Go to ECR Board
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 64,enabled = true,groups = "Search and Revision")
	public void RAR033ClickOnCreateCardButtoninECRBoard() throws IOException, InterruptedException {
		//Create Card
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[3]/ms-sb-add-card/div[@class='ms-sb-add-card-button layout-align-start-center layout-row']");
		Thread.sleep(3000);
	}
	@Test(priority = 65,dataProvider = "ECR CardName",enabled = true,groups = "Search and Revision")
	public void RAR033EntertheCardNameinECRBoard(String Cardname) throws IOException, InterruptedException {
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[3]/ms-sb-add-card/div[2]/form/md-input-container/input", Cardname);
		Thread.sleep(3000);
	}
	@Test(priority = 66,enabled = true,groups = "Search and Revision")
	public void RAR033ClickDoneButtonToCreateCardinECRBoard() throws IOException, InterruptedException {
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[3]/ms-sb-add-card/div[2]/form/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 67,enabled = true,groups = "Search and Revision")
	public void RAR033GetStatusofCardCreationinECRBoard() throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div/span");
	}
	@Test(priority = 68,enabled = true,groups = "Search and Revision")
	public void RAR033ClickonCloseButtontoCreateCardinECRBoard() throws IOException, InterruptedException {
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[3]/ms-sb-add-card/div[2]/form/div/button[2]");
	}	
	@Test(priority = 69,enabled = true,groups = "Search and Revision")
	public void RAR034ClickonCardinECRBoard() throws IOException, InterruptedException {	
		//Enter into the Card
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[2]/div"); 
		Thread.sleep(20000);
	}
	@Test(priority = 70,dataProvider = "ECR AddAffectedObjects one",enabled = true,groups = "Search and Revision")
	public void RAR034AddAffectedObjectsoneonCardInECRBoard(String ObjectOne) throws IOException, InterruptedException {		
		//Add Affected Objects-Part
		Thread.sleep(15000);
		sendpartvaluebyxpathanddownclick("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", ObjectOne);
	}
	@Test(priority = 71,enabled = true,groups = "Search and Revision")
	public void RAR034GetStatusofPartAddAffectedObjectsOneInECRBoard() throws IOException, InterruptedException {	
		//GetStatusofAddAffectedObjectsInECRBoard
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 72,dataProvider = "ECR AddAffectedObjects two",enabled = true,groups = "Search and Revision")
	public void RAR035AddAffectedObjectsTwoonCardInECRBoard(String ObjectTwo) throws IOException, InterruptedException {		
		//Add Affected Objects-Part
		Thread.sleep(15000);
		sendpartvaluebyxpathanddownclick("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", ObjectTwo);
	}
	@Test(priority = 73,enabled = true,groups = "Search and Revision")
	public void RAR035GetStatusofPartAddAffectedObjectsTwoInECRBoard() throws IOException, InterruptedException {	
		//GetStatusofAddAffectedObjectsInECRBoard
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 74,enabled = true,groups = "Search and Revision")
	public void RAR036ClickonImpactVisualizerinECRBoard() throws IOException, InterruptedException {	
		//Click on Impact Visualizer
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
		Thread.sleep(15000);
	}
	@Test(priority = 75,enabled = true,groups = "Search and Revision")
	public void RAR037ClickonObjectoneLinkinECRBoard() throws IOException, InterruptedException {	
		//Click on the Part Link
		Thread.sleep(15000);
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/div[2]/div[1]/div[1]/a/div");
		Thread.sleep(5000);
	}
	@Test(priority = 76,enabled = true,groups = "Search and Revision")
	public void RAR037GoToPartViewandScrolldowntoAssociatedCards() throws IOException, InterruptedException {	
		scroll("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[4]/md-input-container/div/a");
	}
	@Test(priority = 77,enabled = true,groups = "Search and Revision")
	public void RAR038SearchAssociatedCardsonthePartView() throws IOException, InterruptedException {	
		//Search Associated Cards
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[4]/md-input-container/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 78,enabled = true,groups = "Search and Revision",dependsOnMethods = {"RAR038SearchAssociatedCardsonthePartView"})
	public void RAR039ClickOnAssociatedCardsinthePartView() throws IOException, InterruptedException {	
		//Click on the Card from Associated Cards
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[4]/md-input-container/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 79,dataProvider = "ECR AddAffectedObjectsThree",enabled = true,groups = "Search and Revision")
	public void RAR040GoToCardViewandAddProductinAffectedObjects(String ObjectThree) throws IOException, InterruptedException {	
		//Add Affected Objects-Product
		sendproductvaluebyxpathanddownclick("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", ObjectThree);	
	}
	@Test(priority = 80,enabled = true,groups = "Search and Revision")
	public void RAR040GetStatusofProductAddAffectedObjectsInECRBoard() throws IOException, InterruptedException {	
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 81,enabled = true,groups = "Search and Revision")
	public void RAR041ClickonImpactVisualizerProductinECRBoard() throws IOException, InterruptedException {	
		//Click on Impact Visualizer
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
	}
	@Test(priority = 82,enabled = true,groups = "Search and Revision")
	public void RAR042ClickonObjectThreeLinkinECRBoard() throws IOException, InterruptedException {	
		//Click on that Product Link
		clickByXpath("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/div[4]/div[1]/div[1]/a/div");
		Thread.sleep(5000);
	}
	@Test(priority = 83,enabled = true,groups = "Search and Revision")
	public void RAR043GoToProductViewandScrolldowntoAssociatedCards() throws IOException, InterruptedException {	
		scroll("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[4]/md-input-container/div/a");
	}
	@Test(priority = 84,enabled = true,groups = "Search and Revision")
	public void RAR043SearchAssociatedCardsintheProductView() throws IOException, InterruptedException {	
		//Go to the Product View and Click on the Card from Associated Cards
		Searchelement("//*[@id='layout-vertical-navigation']/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div/div/div/form/div[4]/md-input-container/div/a");
	}
	@Test(priority = 85,enabled = true,groups = "Search and Revision",dependsOnMethods = {"RAR043SearchAssociatedCardsintheProductView"})
	public void RAR044ClickOnAssociatedCardsintheProductView() throws IOException, InterruptedException {	
		//Go to the Product View and Click on the Card from Associated Cards
		clickByXpath("//*[@id='layout-vertical-navigation']/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div/div/div/form/div[4]/md-input-container/div/a");
	}
	@Test(priority = 86,enabled = true,groups = "Search and Revision")
	public void RAR045GoToCardViewandClickOnImpactVisualizerButton() throws IOException, InterruptedException {	
		//Click on the Impact Visualizer
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
	}
	@Test(priority = 87,enabled = true,groups = "Search and Revision")
	public void RAR046ClickonObjectOnetoCheckwhereUsed() throws IOException, InterruptedException {
		//Check for corresponding right side where used updated automatically
		clickByXpath("html/body/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/div[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 88,enabled = true,groups = "Search and Revision")
	public void RAR046ClickonObjectOnetoNormalView() throws IOException, InterruptedException {
		clickByXpath("html/body/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/div[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 89,enabled = true,groups = "Search and Revision")
	public void RAR046ClickonObjectTwotoCheckwhereUsed() throws IOException, InterruptedException {
		clickByXpath("html/body/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/div[3]");
		Thread.sleep(5000);
	}
	@Test(priority = 90,enabled = true,groups = "Search and Revision")
	public void RAR046ClickonObjectTwotoNormalView() throws IOException, InterruptedException {	
		clickByXpath("html/body/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/div[3]");
		Thread.sleep(5000);	
	}
	@Test(priority = 91,enabled = true,groups = "Search and Revision")
	public void RAR046ClickonObjectThreetoCheckwhereUsed() throws IOException, InterruptedException {
		clickByXpath("html/body/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/div[4]");
		Thread.sleep(5000);
	}
	@Test(priority = 92,enabled = true,groups = "Search and Revision")
	public void RAR046ClickonObjectThreetoNormalView() throws IOException, InterruptedException {
		clickByXpath("html/body/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/div[4]");
		Thread.sleep(3000);	
	}
	@Test(priority = 93,enabled = true,groups = "Search and Revision")
	public void RAR047ClickonImpactVisualizerButtontforBacktoCardView() throws IOException, InterruptedException {
		//Click on the Impact Visualizer-Back to card View
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
	}
	@Test(priority = 94,enabled = true,groups = "Search and Revision")
	public void RAR048SearchObjectOneintheAffectedObjectstoRemove() throws IOException, InterruptedException {	
		//Search Object One
		Searchelement("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/md-chip[1]/div[1]/md-chip-template/span");
		Thread.sleep(5000);
	}
	@Test(priority = 95,enabled = true,groups = "Search and Revision",dependsOnMethods = {"RAR048SearchObjectOneintheAffectedObjectstoRemove"})
	public void RAR048ClickonRemoveButtontoRemovetheObjectOne() throws IOException, InterruptedException {	
		//Delete the Object One
		clickByXpath("html/body/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/md-chip[1]/div[2]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 96,enabled = true,groups = "Search and Revision")
	public void RAR049ClickOnImpactVisualizerButton() throws IOException, InterruptedException {	
		//Click on the Impact Visualizer
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
	}
	@Test(priority = 97,enabled = true,groups = "Search and Revision")
	public void RAR050ClickOnPartsFromLeftTree() throws IOException, InterruptedException {		
		//Go to Parts
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 98,dataProvider = "Search Parts",enabled = true,groups = "Search and Revision") //Assembly
	public void RAR050EnterPartDetailstoSearch(String PartDetail) throws IOException, InterruptedException {
		//Enter the Part to search
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div[2]/div[1]/input", PartDetail);
		Thread.sleep(3000);        
	}
	@Test(priority = 99,enabled = true,groups = "Search and Revision")
	public void RAR050EntertoSearchPartDetails() throws IOException, InterruptedException {	
		enter();
		Thread.sleep(2000);
	}
	@Test(priority = 100,enabled = true,groups = "Search and Revision")
	public void RAR050FindthePartsfromtheSearchList() throws IOException, InterruptedException {	
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/a");
		Thread.sleep(3000);
	}
	@Test(priority = 101,enabled = true,groups = "Search and Revision")
	public void RAR051ClickonPartfromthePartList() throws IOException, InterruptedException {	
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/a");
		Thread.sleep(3000);
	}
	@Test(priority = 102,enabled = true,groups = "Search and Revision")
	public void RAR051SearchtheAssociatedCardsinthePart() throws IOException, InterruptedException {	
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[4]/md-input-container/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 103,enabled = true,groups = "Search and Revision")
	public void RAR052ClickOnBoardsFromtheLeftTree() throws IOException, InterruptedException {	
		//Go to Boards 
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[2]/ul/li/ul/li/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 104,enabled = true,groups = "Search and Revision")
	public void RAR052ClickonECRBoardsfromtheBoards() throws IOException, InterruptedException {	
		//Go to ECR Board
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 105,enabled = true,groups = "Search and Revision")
	public void RAR052ClickontheCardfromECRBoards() throws IOException, InterruptedException {	
		//Enter into the Card
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[2]/div"); 
		Thread.sleep(5000);
	}
	@Test(priority = 106,dataProvider = "ECR Add Part Add Affected Objects",enabled = true,groups = "Search and Revision")
	public void RAR053AddObjectOneAffectedObjectsontheCard(String Objectone) throws IOException, InterruptedException { //Assembly		
		//Add Affected Objects-Part
		sendpartvaluebyxpathanddownclick("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", Objectone);
		Thread.sleep(5000);
	}
	@Test(priority = 107,enabled = true,groups = "Search and Revision")
	public void RAR054GetStatusonAddObjectOneinAffectedObjectsintheCard() throws IOException, InterruptedException {		
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 108,enabled = true,groups = "Search and Revision")
	public void RAR055ClickOnImpactVisualizerButton() throws IOException, InterruptedException {	
		//Click on the Impact Visualizer
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
	}
	@Test(priority = 109,enabled = true,groups = "Search and Revision")
	public void RAR061ClickOnImpactVisualizerButtonBacktoCardView() throws IOException, InterruptedException {	
		//Click on the Impact Visualizer
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
	}
		///////////////
		//**SKIPPED**//Resolution
		///////////////
	@Test(priority = 110,enabled = true,groups = "Search and Revision")
	public void RAR062ClickonAddApprovalTaskButtonToAddTaskOneintheCard() throws IOException, InterruptedException {		
		//Click on Add Approval Task
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[2]");
		Thread.sleep(2000);
	}
	@Test(priority = 111,dataProvider = "ECR TaskOneName",enabled = true,groups = "Search and Revision")
	public void RAR062EntertheTaskOneNameintheCard(String TaskOneName) throws IOException, InterruptedException {		
		//Create a Task
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/md-input-container/input", TaskOneName);
		Thread.sleep(5000);
	}
	@Test(priority = 112,enabled = true,groups = "Search and Revision")
	public void RAR062ClickonAddTaskButtontoAddTaskOneintheCard() throws IOException, InterruptedException {	
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/button");
		Thread.sleep(3000);
	}
	@Test(priority = 113,dataProvider = "ECR Task ProjectManager",enabled = true,groups = "Search and Revision")
	public void RAR062AssignthisTaskintoProjectManager(String ProjectManager) throws IOException, InterruptedException {	
		//Assign the Task to Project manager
		sendpartvaluebyxpathanddownclick("html/body/div[3]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", ProjectManager);
	}	
	@Test(priority = 114,enabled = true,groups = "Search and Revision")
	public void RAR062GetStatusonTaskAssignedtoProjectManager() throws IOException, InterruptedException {	
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 115,enabled = true,groups = "Search and Revision")
	public void RAR062ClickonTaskOneCloseButtonintheCard() throws IOException, InterruptedException {	
		//Close the Task
		clickByXpath("html/body/div[3]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 116,enabled = true,groups = "Search and Revision")
	public void RAR062ClickonAddApprovalTaskButtonToAddTaskTwointheCard() throws IOException, InterruptedException {		
		//Click on Add Approval Task
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[2]");
		Thread.sleep(2000);
	}
	@Test(priority = 117,dataProvider = "ECR TaskTwoName",enabled = true,groups = "Search and Revision")
	public void RAR062EntertheTaskTwoNameintheCard(String TaskTwoName) throws IOException, InterruptedException {		
		//Create a Second Task
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/md-input-container/input", TaskTwoName);
	}
	@Test(priority = 118,enabled = true,groups = "Search and Revision")
	public void RAR062ClickonAddTaskButtontoAddTaskTwointheCard() throws IOException, InterruptedException {		
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/button");
		Thread.sleep(3000);
	}
	@Test(priority = 119,dataProvider = "ECR Task ReleaseCo-ordinator",enabled = true,groups = "Search and Revision")
	public void RAR062AssignthisTaskintoReleaseCoordinator(String ReleaseCoordinator) throws IOException, InterruptedException {		
		//Assign the Task to Release Co-Ordinator
		sendpartvaluebyxpathanddownclick("html/body/div[3]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", ReleaseCoordinator);
	}
	@Test(priority = 120,enabled = true,groups = "Search and Revision")
	public void RAR062GetStatusonTaskAssignedtoReleaseCoordinator() throws IOException, InterruptedException {		
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 121,enabled = true,groups = "Search and Revision")
	public void RAR062ClickonTaskTwoCloseButtonintheCard() throws IOException, InterruptedException {		
		//Close the Task
		clickByXpath("html/body/div[3]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 122,enabled = true,groups = "Search and Revision")
	public void RAR063ClickonCloseButtonintheCardFromECRBoard() throws IOException, InterruptedException {		
		//Close the Card
		iconClick("html/body/div[1]/div[1]/div/md-content/div[1]/div[3]/md-dialog/md-toolbar/div/div[2]/a/md-icon");
	}
	@Test(priority = 123,enabled = true,groups = "Search and Revision")
	public void RAR064ClickOnBoardfromtheLeftTree() throws IOException, InterruptedException {
		//Go to Boards 
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[2]/ul/li/ul/li/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 124,enabled = true,groups = "Search and Revision")
	public void RAR064ClickOnECRBoardfromtheBoards() throws IOException, InterruptedException {	
		//Go to ECR Board
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[2]");
	}
	@Test(priority = 125,enabled = true,groups = "Search and Revision")
	public void RAR065MovetheCardfromInitiatedtoApproved() throws IOException, InterruptedException {	
		//Select the Card and Move to Approved
		dragAnddropByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[2]/div","html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div");
		Thread.sleep(5000);
	}
	@Test(priority = 126,enabled = true,groups = "Search and Revision")
	public void RAR065ClickonMessagetoConfirmation() throws IOException, InterruptedException {	
		clickByXpath("//*[@id='layout-vertical-navigation']/div/md-content/div/div[4]/md-dialog/md-dialog-actions/button[2]");
	}
	@Test(priority = 127,enabled = true,groups = "Search and Revision")
	public void RAR065GetApprovalMandatoryErrorMessage() throws IOException, InterruptedException {	
		verifystatus("html/body/md-toast/div/span");
	}
	@Test(priority = 128,enabled = true,groups = "Search and Revision")
	public void RAR065CloseApprovalMandatoryErrorMessage() throws IOException, InterruptedException {	
		clickByXpath("//*[@id='layout-vertical-navigation']/div/md-content/div/div[4]/md-dialog/md-dialog-actions/button[2]");
	}
	@Test(priority = 129,enabled = true,groups = "Search and Revision")
	public void RAR065ClickontheCardfromECRBoards() throws IOException, InterruptedException {	
		//Enter into the Card
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[2]/div"); 
		Thread.sleep(5000);
	}
	@Test(priority = 130,enabled = true,groups = "Search and Revision")
	public void RAR066ClickonApprovalButtontotheTaskOne() throws IOException, InterruptedException {	
		//Approval to the TaskOne
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[3]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/div/div[1]/md-checkbox/div[1]");
	}	
	@Test(priority = 131,enabled = true,groups = "Search and Revision")
	public void RAR066ClickonApprovalButtontotheTaskTwo() throws IOException, InterruptedException {	
		//Approval to the TaskTwo
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[3]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/md-checkbox/div[1]");
	}
	@Test(priority = 132,enabled = true,groups = "Search and Revision")
	public void RAR067MovetheCardfromInitiatedtoApproved() throws IOException, InterruptedException {	
		//Select the Card and Move to Approved
		dragAnddropByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[2]/div","html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div");
		Thread.sleep(5000);
	}
	@Test(priority = 133,enabled = true,groups = "Search and Revision")
	public void RAR067ClickonMessagetoConfirmation() throws IOException, InterruptedException {	
		clickByXpath("//*[@id='layout-vertical-navigation']/div/md-content/div/div[4]/md-dialog/md-dialog-actions/button[2]");
	}
	@Test(priority = 134,enabled = true,groups = "Search and Revision")
	public void RAR067GetStatusonMovetheCardfromInitiatedtoApproved() throws IOException, InterruptedException {	
		verifystatus("/html/body/md-toast/div/span");
	}
	@Test(priority = 135,enabled = true,groups = "Search and Revision")
	public void RAR068MovetheCardfromApprovedtoCancelled() throws IOException, InterruptedException {	
		//Select the Card and Move to Approved
		dragAnddropByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div/div[1]","html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[2]/div");
		Thread.sleep(5000);
	}
	@Test(priority = 136,enabled = true,groups = "Search and Revision")
	public void RAR068GetStatusonMovetheCardfromInitiatedtoApproved() throws IOException, InterruptedException {	
		verifystatus("/html/body/md-toast/div/span");
	}
	@Test(priority = 137,enabled = true,groups = "Search and Revision")
	public void RAR069ClickOnSearchfromLeftTree() throws IOException, InterruptedException{
		//Go to Search
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[1]/ul/li/ul/li[1]/div/a");
	}
	@Test(priority = 138,dataProvider = "Search Keyword First",enabled = true,groups = "Search and Revision")
	public void RAR070EntertheKeywordtoSearch(String Keyword) throws IOException, InterruptedException {	
		sendvalueenterbyxpath("html/body/div[1]/div/div/md-content/div[1]/div[1]/div[1]/input", Keyword);
		Thread.sleep(3000);	
	}
	@Test(priority = 139,enabled = true,groups = "Search and Revision")
	public void RAR071ClickonPartsfromtheSearchList()throws IOException, InterruptedException {
		//Go to Parts
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 140,enabled = true,groups = "Search and Revision")
	public void RAR071ClickonTasksfromtheSearchList()throws IOException, InterruptedException {
		//Go to Tasks
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[3]");
		Thread.sleep(3000);
	}	
	@Test(priority = 141,enabled = true,groups = "Search and Revision")
	public void RAR071ClickonCardsfromtheSearchList()throws IOException, InterruptedException {	
		//Go to Cards
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[4]");
		Thread.sleep(3000);	
	}
	@Test(priority = 142,enabled = true,groups = "Search and Revision")
	public void RAR071ClickonProductsfromtheSearchList()throws IOException, InterruptedException {	
		//Go to Products
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 143,enabled = true,groups = "Search and Revision")
	public void RAR072ClickonTasksagain()throws IOException, InterruptedException {	
		//Go to Tasks--->Open the Task and Close
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[3]");
		Thread.sleep(3000);
	}
	@Test(priority = 144,enabled = true,groups = "Search and Revision")
	public void RAR072SearchonTasksListfromtheSearch()throws IOException, InterruptedException {	
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[3]/div/md-content/div[3]/div[1]/div[1]");
		Thread.sleep(50000);
	}
	@Test(priority = 145,enabled = true,dependsOnMethods = {"RAR072SearchonTasksListfromtheSearch"},groups = "Search and Revision")
	public void RAR072ClickonTaskformtheSeachList()throws IOException, InterruptedException {	
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[3]/div/md-content/div[3]/div[1]/div[1]");
		Thread.sleep(3000);
	}		
	@Test(priority = 146,enabled = true,dependsOnMethods = {"RAR072SearchonTasksListfromtheSearch"},groups = "Search and Revision")
	public void RAR073ClickonCloseButtonofTaskformtheSeachList()throws IOException, InterruptedException {	
		clickByXpath("html/body/div[3]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 147,enabled = true,groups = "Search and Revision")
	public void RAR073ClickonCardsagain()throws IOException, InterruptedException {	
		//Go to Cards--->Open the Card and Close
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[4]");
		Thread.sleep(3000);
	}
	@Test(priority = 148,enabled = true,groups = "Search and Revision")
	public void RAR074SearchonCardsListfromtheSearch()throws IOException, InterruptedException {		
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[4]/div/md-content/div[3]/div/a/div");
		Thread.sleep(5000);
	}
	@Test(priority = 149,enabled = true,dependsOnMethods = {"RAR074SearchonCardsListfromtheSearch"},groups = "Search and Revision")
	public void RAR074ClickonCardfromtheSearchList()throws IOException, InterruptedException {		
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[4]/div/md-content/div[3]/div/a/div");
		Thread.sleep(5000);
	}
	@Test(priority = 150,enabled = true,dependsOnMethods = {"RAR074SearchonCardsListfromtheSearch"},groups = "Search and Revision")
	public void RAR075ClickonCloseButtonofCardformtheSeachList()throws IOException, InterruptedException {	
		iconClick("html/body/div[3]/md-dialog/md-toolbar/div/div[2]/a/md-icon");
		Thread.sleep(3000);
	}
	@Test(priority = 151,enabled = true,groups = "Search and Revision")
	public void RAR075ClickonProductsagain()throws IOException, InterruptedException {	
		//Go to Products--->Open the Products and Close
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 152,enabled = true,groups = "Search and Revision")
	public void RAR075SearchonProductsfromtheSearchList()throws IOException, InterruptedException {		
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/a");
		Thread.sleep(5000);
	}
	@Test(priority = 153,enabled = true,dependsOnMethods = {"RAR075SearchonProductsfromtheSearchList"},groups = "Search and Revision")
	public void RAR075ClickonProductfromtheSearchList()throws IOException, InterruptedException {		
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/a");
		Thread.sleep(5000);
	}
	@Test(priority = 154,enabled = true,dependsOnMethods = {"RAR075SearchonProductsfromtheSearchList"},groups = "Search and Revision")
	public void RAR075ClickonBackButtonofProductformtheSeachList()throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 155,enabled = true,groups = "Search and Revision")
	public void RAR076ClickonSearchfromLeftTree()throws IOException, InterruptedException {	
		//Go to Search Again
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[1]/ul/li/ul/li[1]/div/a");
	}
	@Test(priority = 156,dataProvider = "Search Parts Keyword",enabled = true,groups = "Search and Revision") //Assembly
	public void RAR076EntertheKeywordtoSearchAgain(String Keyword)throws IOException, InterruptedException {
		sendvalueenterbyxpath("html/body/div[1]/div/div/md-content/div[1]/div[1]/div[1]/input", Keyword);
		Thread.sleep(3000);
	}
	@Test(priority = 157,enabled = true,groups = "Search and Revision")
	public void RAR076ClickonPartsAgainfromtheSearchList()throws IOException, InterruptedException {
		//Go to Parts
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 158,enabled = true,groups = "Search and Revision")
	public void RAR076SearchonPartsListfromSearch()throws IOException, InterruptedException {	
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/md-content/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/a");
		Thread.sleep(5000);
	}
	@Test(priority = 159,enabled = true,groups = "Search and Revision")
	public void RAR077ClickonPartfromSearchList()throws IOException, InterruptedException {	
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/md-content/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/a");
		Thread.sleep(3000);
	}
	@Test(priority = 160,enabled = true,groups = "Search and Revision")
	public void RAR078SearchBOMinPartsfromSearchList()throws IOException, InterruptedException {		
		//Go to Bill of Materials
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 161,enabled = true,groups = "Search and Revision",dependsOnMethods = {"RAR078SearchBOMinPartsfromSearchList"})
	public void RAR078ClickonBOMinPartsfromSearchList()throws IOException, InterruptedException {		
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(3000);
	}
	@Test(priority = 162,enabled = true,groups = "Search and Revision",dependsOnMethods = {"RAR078ClickonBOMinPartsfromSearchList"})
	public void RAR079ClickonEditButtoninBOMfromSearchList()throws IOException, InterruptedException {		
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[2]/div/md-table-container/table/tbody/tr/td[1]/div/button");
		Thread.sleep(5000);
	}
	@Test(priority = 163,dataProvider = "Search Update Ref in BOM",enabled = true,groups = "Search and Revision",dependsOnMethods = {"RAR078ClickonBOMinPartsfromSearchList"})
	public void RAR079UpdatetheRefValueinBOMfromSearch(String RefBOM)throws IOException, InterruptedException {
	//Update the Ref Value
		sendvaluebyxpath("html/body/div[3]/md-dialog/form/md-dialog-content/md-input-container[3]/md-chips/md-chips-wrap/div/div/input", RefBOM);
		Thread.sleep(3000);
	}
	@Test(priority = 164,dataProvider = "Search Update Quantity in BOM",enabled = true,groups = "Search and Revision",dependsOnMethods = {"RAR078ClickonBOMinPartsfromSearchList"})
	public void RAR079UpdatetheQunatityinBOMfromSearch(String QuantityBOM)throws IOException, InterruptedException {	
		sendvaluebyxpath("html/body/div[3]/md-dialog/form/md-dialog-content/md-input-container[4]/input", QuantityBOM);
		Thread.sleep(3000);
	}
	@Test(priority = 165,enabled = true,groups = "Search and Revision",dependsOnMethods = {"RAR078ClickonBOMinPartsfromSearchList"})
	public void RAR079SavetheDetailsinBOMfromSearchList()throws IOException, InterruptedException {		
		//Save the Details
		clickByXpath("html/body/div[3]/md-dialog/form/md-dialog-actions/div[1]/button");	
	}
	@Test(priority = 166,enabled = true,groups = "Search and Revision",dependsOnMethods = {"RAR078ClickonBOMinPartsfromSearchList"})
	public void RAR079GetStatusofBOMfromSearchList()throws IOException, InterruptedException {		
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 167,enabled = true,dependsOnMethods = {"RAR078ClickonBOMinPartsfromSearchList"},groups = "Search and Revision")
	public void RAR080ClickonAddParttoBOMIfPartisInDevelopment() throws IOException, InterruptedException {
		a.equals("InDevelopment");
	}
	@Test(priority = 168,enabled = true,dataProvider = "Parts Another PartNumber In BillofMaterial",dependsOnMethods={"RAR080ClickonAddParttoBOMIfPartisInDevelopment"},groups = "Search and Revision")
	public void RAR080InPartsEnterAnotherPartNumberinAddBOM(String PartNumber) throws IOException, InterruptedException{
		sendpartvaluebyxpathanddownclick("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[1]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartNumber);
		Thread.sleep(3000);
	}
	@Test(priority = 169,enabled = true,dataProvider = "Parts Another Location In BillofMaterial",dependsOnMethods={"RAR080ClickonAddParttoBOMIfPartisInDevelopment"},groups = "Search and Revision")
	public void RAR080InPartsEnterAnotherLocationinAddBOM(String Location) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[2]/input", Location);
		Thread.sleep(3000);
	}
	@Test(priority = 170,enabled = true,dataProvider = "Parts Another Ref In BillofMaterial",dependsOnMethods={"RAR080ClickonAddParttoBOMIfPartisInDevelopment"},groups = "Search and Revision")
	public void RAR080InPartsEnterAnotherRefinAddBOM(String Ref) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[3]/md-chips/md-chips-wrap/div/div/input", Ref);
		Thread.sleep(3000);
	}
	@Test(priority = 171,enabled = true,dependsOnMethods={"RAR080ClickonAddParttoBOMIfPartisInDevelopment"},groups = "Search and Revision")
	public void RAR080InPartsScrolldowninAddBOMforaddAnotherBOM() throws IOException, InterruptedException{
		scroll("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input");
	}
	@Test(priority = 172,enabled = true,dataProvider = "Parts Another Quantity In BillofMaterial",dependsOnMethods={"RAR080ClickonAddParttoBOMIfPartisInDevelopment"},groups = "Search and Revision")
	public void RAR080InPartsEnterAnotherQuantityinAddBOM(String Quantity) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[4]/input", Quantity);
		Thread.sleep(3000);
	}
	@Test(priority = 173,enabled = true,dataProvider = "Parts Another BOMNotes In BillofMaterial",dependsOnMethods={"RAR080ClickonAddParttoBOMIfPartisInDevelopment"},groups = "Search and Revision")
	public void RAR080InPartsEnterAnotherBOMNotesinAddBOM(String BOMNotes) throws IOException, InterruptedException{
		sendwoutclvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input", BOMNotes);
		Thread.sleep(3000);
	}
	@Test(priority = 174,enabled = true,dependsOnMethods={"RAR080ClickonAddParttoBOMIfPartisInDevelopment"},groups = "Search and Revision")
	public void RAR080InPartsClickAddParttoBOMButtoninAddBOMforAddAnotherPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[5]/md-dialog/form/md-dialog-actions/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 175,enabled = true,dependsOnMethods={"RAR080ClickonAddParttoBOMIfPartisInDevelopment"},groups = "Search and Revision")
	public void RAR080PartStatusofAddAnotherParttoBOM() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(10000);
	}
	@Test(priority = 176,enabled = true,dependsOnMethods={"RAR080ClickonAddParttoBOMIfPartisInDevelopment"},groups = "Search and Revision")
	public void RAR081InPartsClickonEditButtontoDeleteanyoneOfthePartfromBOM() throws IOException, InterruptedException{
		//Delete any one of the Part from BOM
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[2]/div/md-table-container/table/tbody/tr/td[1]/div/button");
	}
	@Test(priority = 177,enabled = true,dependsOnMethods={"RAR080ClickonAddParttoBOMIfPartisInDevelopment"},groups = "Search and Revision")
	public void RAR081InPartsClickonDeleteButtontoDeleteanyoneOfthePartfromBOM() throws IOException, InterruptedException{	
		clickByXpath("html/body/div[3]/md-dialog/form/md-dialog-actions/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 178,enabled = true,dependsOnMethods={"RAR080ClickonAddParttoBOMIfPartisInDevelopment"},groups = "Search and Revision")
	public void RAR081InPartsClickonOKButtonInConfirmationMessagetoDeleteanyoneOfthePartfromBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[3]/md-dialog/md-dialog-actions/button[2]");
	}
	@Test(priority = 179,enabled = true,dependsOnMethods={"RAR080ClickonAddParttoBOMIfPartisInDevelopment"},groups = "Search and Revision")
	public void RAR081InPartsGetStatusOnDeleteanyoneOfthePartfromBOM() throws IOException, InterruptedException{	
		verifystatus("/html/body/md-toast/div/span");
	}
	@Test(priority = 180,enabled = true,groups = "Search and Revision")
	public void RAR082ClickOnSearchFromLeftTree() throws IOException, InterruptedException{
		//Go to Search
		clickByXpath("html/body/div[1]/div/md-sidenav[1]/ms-navigation[1]/ul/li/ul/li[1]/div/a");
		Thread.sleep(2000);
	}
	@Test(priority = 181,enabled = true,groups = "Search and Revision")
	public void RAR083ClickOnSettingsButtonfromSearch() throws IOException, InterruptedException{	
		//Click on Settings Button from Search
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[1]/md-menu/button");
		Thread.sleep(2000);
	}
	@Test(priority = 182,enabled = true,groups = "Search and Revision")
	public void RAR083ClickOnProductsButtonfromSettingsMenuInSearch() throws IOException, InterruptedException{	
		clickByXpath("html/body/div[3]/md-menu-content/md-menu-item[2]/button");
		Thread.sleep(2000);
	}	
	@Test(priority = 183,dataProvider = "Search Product Keyword",enabled = true,groups = "Search and Revision")
	public void RAR084EnterProductsKewywordstoSearch(String ProductSearchKeyword) throws IOException, InterruptedException{	
		sendvalueenterbyxpath("html/body/div[1]/div/div/md-content/div[1]/div[1]/div[1]/input", ProductSearchKeyword);
		Thread.sleep(3000);
	}
	@Test(priority = 184,enabled = true,groups = "Search and Revision")
	public void RAR084EntertoSearchPartDetails() throws IOException, InterruptedException {	
		enter();
		Thread.sleep(2000);
	}
	@Test(priority = 185,enabled = true,groups = "Search and Revision")
	public void RAR084SearchOnProductFromtheSearchList() throws IOException, InterruptedException{		
	//Go to Products--->Open the Products and Close
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/a");
		Thread.sleep(3000);
	}
	@Test(priority = 186,enabled = true,groups = "Search and Revision")
	public void RAR085ClickOnProductFromtheSearchList() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div/div[2]/div[2]/div[2]/table/tbody/tr/td[1]/a");
		Thread.sleep(3000);
	}
	@Test(priority = 187,enabled = true,groups = "Search and Revision")
	public void RAR086SearchBOMinProductsfromSearchList()throws IOException, InterruptedException {		
		//Go to Bill of Materials
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 188,enabled = true,dependsOnMethods={"RAR086SearchBOMinProductsfromSearchList"},groups = "Search and Revision")
	public void RAR086ClickonBOMinProductsfromSearchList()throws IOException, InterruptedException {		
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(3000);
	}
	@Test(priority = 189,enabled = true,dependsOnMethods={"RAR086ClickonBOMinProductsfromSearchList"},groups = "Search and Revision")
	public void RAR087ClickonAddParttoBOMIfProductisInDevelopment() throws IOException, InterruptedException {
		a.equals("InDevelopment");
	}
	@Test(priority = 190,enabled = true,dataProvider = "Products Another PartNumber In BillofMaterial",dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR087InProductsEnterAnotherPartNumberinAddBOM(String PartNumber) throws IOException, InterruptedException{
		sendpartvaluebyxpathanddownclick("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[1]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartNumber);
		Thread.sleep(3000);
	}
	@Test(priority = 191,enabled = true,dataProvider = "Products Another Location In BillofMaterial",dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR087InProductsEnterAnotherLocationinAddBOM(String Location) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[2]/input", Location);
		Thread.sleep(3000);
	}
	@Test(priority = 192,enabled = true,dataProvider = "Products Another Ref In BillofMaterial",dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR087InProductsEnterAnotherRefinAddBOM(String Ref) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[3]/md-chips/md-chips-wrap/div/div/input", Ref);
		Thread.sleep(3000);
	}
	@Test(priority = 193,enabled = true,dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR087InProductsScrolldowninAddBOMforaddAnotherBOM() throws IOException, InterruptedException{
		scroll("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input");
	}
	@Test(priority = 194,enabled = true,dataProvider = "Products Another Quantity In BillofMaterial",dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR087InProductsEnterAnotherQuantityinAddBOM(String Quantity) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[4]/input", Quantity);
		Thread.sleep(3000);
	}
	@Test(priority = 195,enabled = true,dataProvider = "Products Another BOMNotes In BillofMaterial",dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR087InProductsEnterAnotherBOMNotesinAddBOM(String BOMNotes) throws IOException, InterruptedException{
		sendwoutclvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input", BOMNotes);
		Thread.sleep(3000);
	}
	@Test(priority = 196,enabled = true,dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR087InProductsClickAddParttoBOMButtoninAddBOMforAddAnotherPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[5]/md-dialog/form/md-dialog-actions/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 197,enabled = true,dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR087ProductsStatusofAddAnotherParttoBOM() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(10000);
	}
	@Test(priority = 198,enabled = true,dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")//Delete PCB Assembly Rev1
	public void RAR088InProductsClickonEditButtontoDeleteanyoneOfthePartfromBOM() throws IOException, InterruptedException{
		//Delete any one of the Part from BOM
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[2]/div/md-table-container/table/tbody/tr/td[1]/div/button");
	}
	@Test(priority = 199,enabled = true,dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR088InProductsClickonDeleteButtontoDeleteanyoneOfthePartfromBOM() throws IOException, InterruptedException{	
		clickByXpath("html/body/div[3]/md-dialog/form/md-dialog-actions/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 200,enabled = true,dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR088InProductsClickonOKButtonInConfirmationMessagetoDeleteanyoneOfthePartfromBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[3]/md-dialog/md-dialog-actions/button[2]");
	}
	@Test(priority = 201,enabled = true,dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR088InProductsGetStatusOnDeleteanyoneOfthePartfromBOM() throws IOException, InterruptedException{	
		verifystatus("/html/body/md-toast/div/span");
	}
	@Test(priority = 202,enabled = true,dataProvider = "Products Add Another PartNumber In BillofMaterial",dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR088InProductsEnterAnotherPartNumberinAddBOM(String PartNumber) throws IOException, InterruptedException{ ///// Add Assembly Rev 2
		sendpartvaluebyxpathanddownclick("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[1]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartNumber);
		Thread.sleep(3000);
	}
	@Test(priority = 203,enabled = true,dataProvider = "Products Add Another Location In BillofMaterial",dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR088InProductsEnterAnotherLocationinAddBOM(String Location) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[2]/input", Location);
		Thread.sleep(3000);
	}
	@Test(priority = 204,enabled = true,dataProvider = "Products Add Another Ref In BillofMaterial",dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR088InProductsEnterAnotherRefinAddBOM(String Ref) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[3]/md-chips/md-chips-wrap/div/div/input", Ref);
		Thread.sleep(3000);
	}
	@Test(priority = 205,enabled = true,dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR088InProductsScrolldowninAddBOMforaddAnotherBOM() throws IOException, InterruptedException{
		scroll("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input");
	}
	@Test(priority = 206,enabled = true,dataProvider = "Products Add Another Quantity In BillofMaterial",dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR088InProductsEnterAnotherQuantityinAddBOM(String Quantity) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[4]/input", Quantity);
		Thread.sleep(3000);
	}
	@Test(priority = 207,enabled = true,dataProvider = "Products Add Another BOMNotes In BillofMaterial",dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR088InProductsEnterAnotherBOMNotesinAddBOM(String BOMNotes) throws IOException, InterruptedException{
		sendwoutclvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input", BOMNotes);
		Thread.sleep(3000);
	}
	@Test(priority = 208,enabled = true,dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR088InProductsClickAddParttoBOMButtoninAddBOMforAddAnotherPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[5]/md-dialog/form/md-dialog-actions/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 209,enabled = true,dependsOnMethods={"RAR087ClickonAddParttoBOMIfProductisInDevelopment"},groups = "Search and Revision")
	public void RAR088ProductsStatusofAddAnotherParttoBOM() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(10000);
	}
	@Test(priority = 210,enabled = true,groups = "Search and Revision")
	public void RAR089ClickOnBoardsAgainFromLeftTree() throws IOException, InterruptedException{
		//Boards
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[2]/ul/li/ul/li/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 211,enabled = true,groups = "Search and Revision")
	public void RAR090ClickOnECOBoard() throws IOException, InterruptedException{	
		//Go to ECO Board
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[4]");
		Thread.sleep(5000);
	}
	@Test(priority = 212,enabled = true,groups = "Search and Revision")
	public void RAR091ClickOnCreateCardButtoninECOBoard() throws IOException, InterruptedException{
		//Create Card
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[3]/ms-sb-add-card/div[@class='ms-sb-add-card-button layout-align-start-center layout-row']");
		Thread.sleep(3000);
	}
	@Test(priority = 213,dataProvider = "ECO Card Name",enabled = true,groups = "Search and Revision")
	public void RAR091EntertheCardName(String Cardname) throws IOException, InterruptedException{
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[3]/ms-sb-add-card/div[2]/form/md-input-container/input", Cardname);
		Thread.sleep(5000);
	}
	@Test(priority = 214,enabled = true,groups = "Search and Revision")
	public void RAR091ClickOnCreateButtontoCreateaCard() throws IOException, InterruptedException{
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[3]/ms-sb-add-card/div[2]/form/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 215,enabled = true,groups = "Search and Revision")
	public void RAR091GetStatusOnCreateCard() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(5000);
	}
	@Test(priority = 216,enabled = true,groups = "Search and Revision")
	public void RAR091ClickOnCloseButtontoCreateCard() throws IOException, InterruptedException{
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[3]/ms-sb-add-card/div[2]/form/div/button[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 217,enabled = true,groups = "Search and Revision")
	public void RAR092ClickOnCardandEnterintotheCardView() throws IOException, InterruptedException{
		//Enter into the Card
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/md-content/div/div/div/div[2]/div"); 
		Thread.sleep(5000);
	}	
	@Test(priority = 218,dataProvider = "ECO Board Object One Affected Objects",enabled = true,groups = "Search and Revision")
	public void RAR092EnterObjectonetoAddAffectedObjectsontheCard(String ObjectOne) throws IOException, InterruptedException{ ////Electronics
		//Add Affected Objects-Part
		sendpartvaluebyxpathanddownclick("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", ObjectOne);
		Thread.sleep(3000);
	}
	@Test(priority = 219,enabled = true,groups = "Search and Revision")
	public void RAR092GetStatusonAddObjectOnetoAffectedObjectsintheCardFromECOBoard() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 220,dataProvider = "ECO Board Object Two Affected Objects",enabled = true,groups = "Search and Revision")
	public void RAR092EnterObjectTwotoAddAffectedObjectsontheCard(String ObjectTwo) throws IOException, InterruptedException{ //// Ceramic Capacitor
		//Add Affected Objects-Part
		sendpartvaluebyxpathanddownclick("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", ObjectTwo);
		Thread.sleep(3000);
	}
	@Test(priority = 221,enabled = true,groups = "Search and Revision")
	public void RAR092GetStatusonAddObjectTwotoAffectedObjectsintheCardFromECOBoard() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 222,dataProvider = "ECO Board Object Three Affected Objects",enabled = true,groups = "Search and Revision")
	public void RAR093EnterObjectThreetoAddAffectedObjectsontheCard(String ObjectThree) throws IOException, InterruptedException{ //// Assembly Rev 2
		//Add Affected Objects-Part
		sendpartvaluebyxpathanddownclick("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", ObjectThree);
		Thread.sleep(3000);
	}
	@Test(priority = 223,enabled = true,groups = "Search and Revision")
	public void RAR094GetStatusonAddObjectThreetoAffectedObjectsintheCardFromECOBoard() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 224,enabled = true,groups = "Search and Revision")
	public void RAR095ClickOnImpactVisualizerButtonintheCardfromECOBoard() throws IOException, InterruptedException{
		//Click on Impact Visualizer
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
		Thread.sleep(3000);
	}
	@Test(priority = 225,enabled = true,groups = "Search and Revision")
	public void RAR096ClickOnObjectThrreLinkfromtheCard() throws IOException, InterruptedException{   ///Assembly Rev 2
		//Click on the Part Link
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/div[4]/div[1]/div[1]/a/div");
		Thread.sleep(5000);
	}	
	@Test(priority = 226,enabled = true,groups = "Search and Revision")
	public void RAR096ScrollToAssociatedCardfromthePartView() throws IOException, InterruptedException{
		//Go to the Part View and Click on the Card from Associated Cards
		scroll("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[4]/md-input-container/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 227,enabled = true,groups = "Search and Revision")
	public void RAR096SearchAssociatedCardfromthePartView() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[4]/md-input-container/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 228,enabled = true,groups = "Search and Revision",dependsOnMethods = {"RAR096SearchAssociatedCardfromthePartView"})
	public void RAR097ClickOnAssociatedCardfromthePartView() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[4]/md-input-container/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 229,dataProvider = "ECO Board Product Affected Objects",enabled = true,groups = "Search and Revision")
	public void RAR098EnterProducttoAddAffectedObjectsontheCardInECOBoard(String Product) throws IOException, InterruptedException{///iphone
		//Add Affected Objects-Product
		sendproductvaluebyxpathanddownclick("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", Product);//10248
		Thread.sleep(3000);
	}
	@Test(priority = 230,enabled = true,groups = "Search and Revision")
	public void RAR099GetStatusonAddProducttoAffectedObjectsintheCard() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 231,enabled = true,groups = "Search and Revision")
	public void RAR100ClickOnImpactVisualizerButtonintheCard() throws IOException, InterruptedException{	
		//Click on Impact Visualizer
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
		Thread.sleep(5000);
	}
	@Test(priority = 232,enabled = true,groups = "Search and Revision")
	public void RAR100ClickOnProductLinktoViewtheProductinWhereUsed() throws IOException, InterruptedException{	
		//Click on Product Link
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/div[2]/div[1]/div[1]/a/div");
		Thread.sleep(5000);
	}
	@Test(priority = 233,enabled = true,groups = "Search and Revision")
	public void RAR101ScrollToAssociatedCardfromtheProductView() throws IOException, InterruptedException{
		//Go to the Part View and Click on the Card from Associated Cards
		scroll("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[4]/md-input-container/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 234,enabled = true,groups = "Search and Revision")
	public void RAR101SearchAssociatedCardfromtheProductView() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[4]/md-input-container/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 235,enabled = true,groups = "Search and Revision",dependsOnMethods = {"RAR096SearchAssociatedCardfromthePartView"})
	public void RAR102ClickOnAssociatedCardfromtheProductView() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[4]/md-input-container/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 236,enabled = true,groups = "Search and Revision")
	public void RAR103ClickOnImpactVisualizerButtonintheCard() throws IOException, InterruptedException{	
		//Click on Impact Visualizer
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
		Thread.sleep(5000);
	}
	@Test(priority = 237,enabled = true,groups = "Search and Revision")
	public void RAR104ClickOnObjectOnetoCheckCorrespondingWhereUsedUpdatedAutomatically() throws IOException, InterruptedException{				
		//Check for corresponding right side where used updated automatically
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/button[1]");
		Thread.sleep(5000);
	}
	@Test(priority = 238,enabled = true,groups = "Search and Revision")
	public void RAR104ClickOnObjectOnetoBackViewWhereUsed() throws IOException, InterruptedException{				
		//Check for corresponding right side where used updated automatically
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/button[1]");
		Thread.sleep(5000);
	}
	@Test(priority = 239,enabled = true,groups = "Search and Revision")
	public void RAR104ClickOnObjectTwotoCheckCorrespondingWhereUsedUpdatedAutomatically() throws IOException, InterruptedException{				
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/button[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 240,enabled = true,groups = "Search and Revision")
	public void RAR104ClickOnObjectTwotoCheckBackViewWhereUsed() throws IOException, InterruptedException{				
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/button[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 241,enabled = true,groups = "Search and Revision")
	public void RAR105ClickOnModificationECOintheCardfromECOBoard() throws IOException, InterruptedException{		
		//Click on Modification ECO
		clickByXpath("html/body/div/div/div/md-content/div/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 242,enabled = true,groups = "Search and Revision")
	public void RAR106VerifytheInitialReleasefromModificationECO() throws IOException, InterruptedException{		
		//Verify the Blue colour  Initial Release Button
		verifystatus("html/body/div/div/div/md-content/div/div[4]/md-dialog/md-dialog-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/div/div/md-content/div/md-list/md-list-item/div/div/button");
		Thread.sleep(5000);
	}
	@Test(priority = 243,enabled = true,groups = "Search and Revision")
	public void RAR107ClickOnProductRev2fromLeft() throws IOException, InterruptedException{		
		//Click on Product Rev2
		clickByXpath("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/div/div[1]/md-content/div/md-list/md-list-item[1]/div[1]/div[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 244,enabled = true,groups = "Search and Revision")
	public void RAR108UnSelecttheProductRev2fromLeft() throws IOException, InterruptedException{		
		//Unselect on Product Rev2
		clickByXpath("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/div/div[1]/md-content/div/md-list/md-list-item[1]/div[1]/div[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 245,enabled = true,groups = "Search and Revision")
	public void RAR108ClickonPartfromLeftinModificationECO() throws IOException, InterruptedException{		
		//Click on Parts
		clickByXpath("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/div/div[1]/md-content/div/md-list/md-list-item[2]/div[1]/div[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 246,enabled = true,groups = "Search and Revision")
	public void RAR109ClickOnImpactVisualizerButtonBacktoCardViewfromECOBoard() throws IOException, InterruptedException{		
		//Click on the Impact Visualizer-Back to card View
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
		Thread.sleep(5000);
	}
	@Test(priority = 247,enabled = true,groups = "Search and Revision")
	public void RAR110SearchthePartinAffectedObjectsuintheCardfromECOBoard() throws IOException, InterruptedException{		
		//Remove the Part from Affected Objects
		Searchelement("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/md-chip[1]/div[1]/md-chip-template/span");
		Thread.sleep(5000);
	}
	@Test(priority = 248,enabled = true,groups = "Search and Revision")
	public void RAR110RemovethePartinAffectedObjectsuintheCardfromECOBoard() throws IOException, InterruptedException{		
		//Remove the Part from Affected Objects
		clickByXpath("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/md-chip[1]/div[2]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 249,enabled = true,groups = "Search and Revision")
	public void RAR111ClickOnImpactVisualizerButtonintheCard() throws IOException, InterruptedException{	
		//Click on Impact Visualizer
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
		Thread.sleep(5000);
	}
	@Test(priority = 250,enabled = true,groups = "Search and Revision")
	public void RAR112ClickOnObjectOnetoCheckCorrespondingWhereUsedUpdatedAutomatically() throws IOException, InterruptedException{				
		//Check for corresponding right side where used updated automatically
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/button[1]");
		Thread.sleep(5000);
	}
	@Test(priority = 251,enabled = true,groups = "Search and Revision")
	public void RAR112ClickOnObjectOnetoBackViewWhereUsed() throws IOException, InterruptedException{				
		//Check for corresponding right side where used updated automatically
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/button[1]");
		Thread.sleep(5000);
	}
	@Test(priority = 252,enabled = true,groups = "Search and Revision")
	public void RAR112ClickOnObjectTwotoCheckCorrespondingWhereUsedUpdatedAutomatically() throws IOException, InterruptedException{				
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/button[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 253,enabled = true,groups = "Search and Revision")
	public void RAR112ClickOnObjectTwotoCheckBackViewWhereUsed() throws IOException, InterruptedException{				
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/div/md-sidenav/md-content/div[1]/button[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 254,enabled = true,groups = "Search and Revision")
	public void RAR113ClickOnModificationECOintheCardfromECOBoard() throws IOException, InterruptedException{		
		//Click on Modification ECO
		clickByXpath("html/body/div/div/div/md-content/div/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 255,enabled = true,groups = "Search and Revision")
	public void RAR114ClickOnPartsFromLeftTree() throws IOException, InterruptedException {		
		//Go to Parts
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 256,dataProvider = "Search Parts ECO",enabled = true,groups = "Search and Revision") //Assembly rev 2
	public void RAR115EnterPartDetailstoSearch(String PartDetail) throws IOException, InterruptedException {
		//Enter the Part to search
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div[2]/div[1]/input", PartDetail);
		Thread.sleep(3000);        
	}
	@Test(priority = 257,enabled = true,groups = "Search and Revision")
	public void RAR115EntertoSearchPartDetails() throws IOException, InterruptedException {	
		enter();
		Thread.sleep(2000);
	}
	@Test(priority = 258,enabled = true,groups = "Search and Revision")
	public void RAR115FindthePartsfromtheSearchList() throws IOException, InterruptedException {	
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/a");
		Thread.sleep(3000);
	}
	@Test(priority = 259,enabled = true,groups = "Search and Revision")
	public void RAR115ClickonPartfromthePartList() throws IOException, InterruptedException {	
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/a");
		Thread.sleep(3000);
	}
	@Test(priority = 260,enabled = true,groups = "Search and Revision")
	public void RAR115SearchtheAssociatedCardsinthePart() throws IOException, InterruptedException {	
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[4]/md-input-container/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 261,enabled = true,groups = "Search and Revision")
	public void RAR116ClickOnBoardsFromtheLeftTree() throws IOException, InterruptedException {	
		//Go to Boards 
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[2]/ul/li/ul/li/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 262,enabled = true,groups = "Search and Revision")
	public void RAR116ClickonECOBoardsfromtheBoards() throws IOException, InterruptedException {	
		//Go to ECR Board
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[4]");
		Thread.sleep(3000);
	}
	@Test(priority = 263,enabled = true,groups = "Search and Revision")
	public void RAR116ClickontheCardfromECOBoards() throws IOException, InterruptedException {	
		//Enter into the Card
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[1]/div/div[2]/div/div[1]"); 
		Thread.sleep(5000);
	}
	@Test(priority = 264,dataProvider = "ECO Object One Add Affected Objects",enabled = true,groups = "Search and Revision")
	public void RAR117AddObjectOneAffectedObjectsontheCard(String Objectone) throws IOException, InterruptedException { //Assembly Rev 2		
		//Add Affected Objects-Part
		sendpartvaluebyxpathanddownclick("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", Objectone);
		Thread.sleep(5000);
	}
	@Test(priority = 265,enabled = true,groups = "Search and Revision")
	public void RAR118GetStatusonAddObjectOneinAffectedObjectsintheCard() throws IOException, InterruptedException {		
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 266,enabled = true,groups = "Search and Revision")
	public void RAR119ClickOnImpactVisualizerButton() throws IOException, InterruptedException {	
		//Click on the Impact Visualizer
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
	}
	@Test(priority = 267,enabled = true,groups = "Search and Revision")
	public void RAR120ClickModificationTabintheCard() throws IOException, InterruptedException {	
		//Click on the Modification Eco
		clickByXpath("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]/span");
	}
		///////////////
		//**SKIPPED**//Resolution
		///////////////
	@Test(priority = 268,enabled = true,groups = "Search and Revision")
	public void RAR126ClickOnImpactVisualizerButton() throws IOException, InterruptedException {	
		//Click on the Impact Visualizer
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
	}
	@Test(priority = 269,enabled = true,groups = "Search and Revision")
	public void RAR127SearchthePartinAffectedObjectsuintheCardfrom() throws IOException, InterruptedException{		
		//Remove the Part from Affected Objects
		Searchelement("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/md-chip[2]/div[1]/md-chip-template/span");
		Thread.sleep(5000);
	}
	@Test(priority = 270,enabled = true,groups = "Search and Revision")
	public void RAR127RemovethePartinAffectedObjectsuintheCard() throws IOException, InterruptedException{		
		//Remove the Part from Affected Objects
		clickByXpath("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[1]/div/div[2]/md-chips/md-chips-wrap/md-chip[2]/div[2]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 271,dataProvider = "ECO TaskOneName",enabled = true,groups = "Search and Revision")
	public void RAR128CreateTaskOneintheCardfromECOBoard(String TaskOneName) throws IOException, InterruptedException{		
		//Create a Task
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/md-input-container/input", TaskOneName);
		Thread.sleep(5000);
	}
	@Test(priority = 272,enabled = true,groups = "Search and Revision")
	public void RAR128ClickOnAddTaskButtontoAddTaskOneintheCardfromECOBoard() throws IOException, InterruptedException{		
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/button");
		Thread.sleep(3000);
	}
	@Test(priority = 273,dataProvider = "ECO Assign ProjectManager",enabled = true,groups = "Search and Revision")
	public void RAR128AssignthisTaskOneintoProjectManager(String ProjectManager) throws IOException, InterruptedException{		
		//Assign the Task to Project manager
		sendpartvaluebyxpathanddownclick("html/body/div[3]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", ProjectManager);
		Thread.sleep(5000);
	}
	@Test(priority = 274,enabled = true,groups = "Search and Revision")
	public void RAR128GetStatusonTaskOneAssigntoProjectManagerintheCardfromECOBoard() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 275,enabled = true,groups = "Search and Revision")
	public void RAR128ClosetheTaskOneintheCardfromECOBoard() throws IOException, InterruptedException{
		//Close the Task
		clickByXpath("html/body/div[3]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}	
	@Test(priority = 276,dataProvider = "ECO TaskTwoName",enabled = true,groups = "Search and Revision")
	public void RAR128CreateTaskTwointheCardfromECOBoard(String TaskTwoName) throws IOException, InterruptedException{	
		//Create a Second Task
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/md-input-container/input", TaskTwoName);
		Thread.sleep(5000);
	}
	@Test(priority = 277,enabled = true,groups = "Search and Revision")
	public void RAR128ClickOnAddTaskButtontoAddTaskTwointheCardfromECOBoard() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/form/button");
		Thread.sleep(3000);
	}
	@Test(priority = 278,dataProvider = "ECO Assign ReleaseCoordinator",enabled = true,groups = "Search and Revision")
	public void RAR128AssignthisTaskTwointoProjectManager(String ReleaseCoordinator) throws IOException, InterruptedException{	
		//Assign the Task to Project manager
		sendpartvaluebyxpathanddownclick("html/body/div[3]/md-dialog/md-dialog-content/div[1]/div[2]/div[2]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", ReleaseCoordinator);
		Thread.sleep(5000);
	}
	@Test(priority = 279,enabled = true,groups = "Search and Revision")
	public void RAR128GetStatusonTaskTwoAssigntoReleaseCoordinatorintheCardfromECOBoard() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 280,enabled = true,groups = "Search and Revision")
	public void RAR128ClosetheTaskTwointheCardfromECOBoard() throws IOException, InterruptedException{	
		//Close the Task
		clickByXpath("html/body/div[3]/md-dialog/md-toolbar/div/div[2]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 281,enabled = true,groups = "Search and Revision")
	public void RAR129ClosetheCardfromECOBoard() throws IOException, InterruptedException{		
		//Close the Card
		iconClick("html/body/div[1]/div[1]/div/md-content/div[1]/div[3]/md-dialog/md-toolbar/div/div[2]/a/md-icon");
	}
	@Test(priority = 282,enabled = true,groups = "Search and Revision")
	public void RAR130ClickonBoardsAgainFromLeftTree() throws IOException, InterruptedException{
		//Boards
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[2]/ul/li/ul/li/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 283,enabled = true,groups = "Search and Revision")
	public void RAR130ClickonECOBoardinBoards() throws IOException, InterruptedException{	
		//Go to ECO Board
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div/div[4]");
		Thread.sleep(3000);
	}
	@Test(priority = 284,enabled = true,groups = "Search and Revision")
	public void RAR131MovetheCardfromInitialToCancel() throws IOException, InterruptedException{	
		//Drag and Drop the Card from Initial to Cancel
		dragAnddropByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[1]/div/div[2]/div","html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 285,enabled = true,groups = "Search and Revision")
	public void RAR131ClickonMessagetoConfirmation() throws IOException, InterruptedException {	
		clickByXpath("//*[@id='layout-vertical-navigation']/div/md-content/div/div[4]/md-dialog/md-dialog-actions/button[2]");
	}
	@Test(priority = 286,enabled = true,groups = "Search and Revision")
	public void RAR131GetApprovalMandatoryErrorMessage() throws IOException, InterruptedException {	
		verifystatus("html/body/md-toast/div/span");
	}
	@Test(priority = 287,enabled = true,groups = "Search and Revision")
	public void RAR131CloseApprovalMandatoryErrorMessage() throws IOException, InterruptedException {	
		clickByXpath("//*[@id='layout-vertical-navigation']/div/md-content/div/div[4]/md-dialog/md-dialog-actions/button[2]");
	}
	@Test(priority = 288,enabled = true,groups = "Search and Revision")
	public void RAR132ClickontheCardinInitialListfromECOBoard() throws IOException, InterruptedException{
		//Open the Card
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[1]/div/div[2]/div/div[2]/div[1]");
		Thread.sleep(5000);
	}
	@Test(priority = 289,enabled = true,groups = "Search and Revision")
	public void RAR132ClickontheApprovaltoTaskOnefromECOBoard() throws IOException, InterruptedException{
		//Approval to the Task
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/div[1]/div[1]/md-checkbox/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 290,enabled = true,groups = "Search and Revision")
	public void RAR132ClickontheApprovaltoTaskTwofromECOBoard() throws IOException, InterruptedException{
		//Approval to the Task	
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div[4]/md-dialog/md-dialog-content/div[1]/div[3]/div[3]/div[1]/div[2]/div[2]/div[2]/div[1]/md-checkbox/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 291,enabled = true,groups = "Search and Revision")
	public void RAR132ClosetheCardfromECOBoard() throws IOException, InterruptedException{		
		//Close the Card
		iconClick("html/body/div[1]/div[1]/div/md-content/div[1]/div[3]/md-dialog/md-toolbar/div/div[2]/a/md-icon");
	}
	@Test(priority = 292,enabled = true,groups = "Search and Revision")
	public void RAR133MovetheCardfromInitialToCancelinECOBoard() throws IOException, InterruptedException{
		//Drag and Drop the Approved task Card from Initial to Cancel
		dragAnddropByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[1]/div/div[2]/div/div[2]/div[1]","html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 293,enabled = true,groups = "Search and Revision")
	public void RAR133ClickonMessagetoConfirmation() throws IOException, InterruptedException {	
		clickByXpath("//*[@id='layout-vertical-navigation']/div/md-content/div/div[4]/md-dialog/md-dialog-actions/button[2]");
	}
	@Test(priority = 294,enabled = true,groups = "Search and Revision")
	public void RAR133GetStatusOnCardMoveFromInitialToCancelinECOBoard() throws IOException, InterruptedException{	
		//Get the Status
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 295,enabled = true,groups = "Search and Revision")
	public void RAR134MovetheCardfromCancelToCompleteinECOBoard() throws IOException, InterruptedException{
		//Drag and Drop the Card from Cancel to Complete
		dragAnddropByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div/div[1]","html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[2]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 296,enabled = true,groups = "Search and Revision")
	public void RAR135MovetheCardfromCancelToCompleteinECOBoard() throws IOException, InterruptedException{
		//Drag and Drop the Card from complete to Cancel
		dragAnddropByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[2]/div","html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[3]/div/div[2]/div/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 297,enabled = true,groups = "Search and Revision")
	public void RAR136ClickontheCardinCancelListinECOBoard() throws IOException, InterruptedException{	
		//Click on the Card in Complete List
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/md-content/div/div[4]/div/div[2]/div/div[1]");
		Thread.sleep(3000);
	}
	@Test(priority = 298,enabled = true,groups = "Search and Revision")
	public void RAR136ClickonImpactVisualizerButtonintheCardfromECOBoard() throws IOException, InterruptedException{
		//Click on Impact Visualizer
		clickByXpath("html/body/div[1]/div[1]/div/md-content/div[1]/div[4]/md-dialog/md-toolbar/div/div[2]/button[3]");
		Thread.sleep(3000);
	}
	@Test(priority = 299,enabled = true,groups = "Search and Revision")
	public void RAR136GetStatusonFirstAffetectdObjectsintheCardECOBoard() throws IOException, InterruptedException{
		//Get the Status of the Affected Objects
		verifystatus("//*[@id='layout-vertical-navigation']/div/md-content/div/div[4]/md-dialog/md-dialog-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content/div/div/md-sidenav/md-content/div/button[1]/div[1]/div[2]/div[2]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 300,enabled = true,groups = "Search and Revision")
	public void RAR136GetStatusonSecondAffetectdObjectsintheCardECOBoard() throws IOException, InterruptedException{
		//Get the Status of the Affected Objects
		verifystatus("//*[@id='layout-vertical-navigation']/div/md-content/div/div[4]/md-dialog/md-dialog-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content/div/div/md-sidenav/md-content/div/button[2]/div[1]/div[2]/div[2]/div");
		Thread.sleep(3000);
	}
	@Test(priority = 301,enabled = true,groups = "Search and Revision")
	public void RAR137ClickonPartLinkintheCardfromECOBoard() throws IOException, InterruptedException{
		//Click on the Part Link
		clickByXpath("//*[@id='layout-vertical-navigation']/div/md-content/div/div[4]/md-dialog/md-dialog-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content/div/div/md-sidenav/md-content/div/button[1]/div[1]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 302,enabled = true,groups = "Search and Revision")
	public void RAR138SearchSaveButtonisDisableorNotinthePartView() throws IOException, InterruptedException{
		//Check the Save Button is Disable
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div/div[2]/button[3]");
		Thread.sleep(5000);
	}
	@Test(priority = 303,dataProvider = "Parts Enter Description in Basic-Info from ECO",enabled = true,groups = "Search and Revision")
	public void RAR139EditPartsandEnterDescriptioninBasicInfoofPart(String Des)throws IOException, InterruptedException{
		//Go to Basic Info and Enter Description and Save the Part Details
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div/div/div/form/div/md-input-container/input", Des);
		Thread.sleep(5000);
	}
	@Test(priority = 304,enabled = true,groups = "Search and Revision")
	public void RAR139EditPartsandClickonAdditionalInfoTabinPart() throws IOException,InterruptedException{
		//Go to Additional Info
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 305,enabled = true,groups = "Search and Revision")
	public void RAR139EditPartsandClickonAttachmentsTabinPart() throws InterruptedException, IOException{
		//Click on Attachments
		clickByXpath("//div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[3]");
	    Thread.sleep(5000);
	}
	@Test(priority = 306,enabled = true,groups = "Search and Revision")
	public void RAR139EditPartsandClickonSourcingTapinPart() throws IOException, InterruptedException {	
		//Go to Souring
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[4]");
		Thread.sleep(5000);
	}
	@Test(priority = 307,enabled = true,groups = "Search and Revision")
	public void RAR139EditPartsandSearchBillofmaterialtapinPart() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 308,enabled = true,dependsOnMethods={"RAR139EditPartsandSearchBillofmaterialtapinPart"},groups = "Search and Revision")
	public void RAR139EditPartsandClickonBillofmaterialtapinPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 309,enabled = true,groups = "Search and Revision")
	public void RAR139EditPartsandClickOnWhereusedTapinPart() throws InterruptedException,IOException{
		//Where-Used
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(15000);
	}
	@Test(priority = 310,enabled = true,groups = "Search and Revision")
	public void RAR140EditPartsClickOnTimelineTab() throws InterruptedException,IOException{
		//Click on Time-Line
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[6]/span");
		Thread.sleep(3000);
	}
	@AfterClass
	public void logout() throws InterruptedException {
		//Logout
		Thread.sleep(3000);
		clickByXpath("html/body/div[1]/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");
		Thread.sleep(3000);
		clickByXpath("html/body/div[3]/md-menu-content/md-menu-item[4]/button");
		Thread.sleep(3000);
		closeBrowser();
	}
	//////////////////////////////Data Provider////////////////////////////////////
	
	@DataProvider(name = "Product Search")
	public Object[][] parameterCredentials() throws IOException {

	 Object[][] data = ProductSearch();

	 return data;
	}
	@DataProvider(name = "Product BasicInfo ProductName")
	public Object[][] parameterCredentials1() throws IOException {

	 Object[][] data = ProductBasicInfoProductName();

	 return data;
	}
	@DataProvider(name = "Product BasicInfo ProjectName")
	public Object[][] parameterCredentials2() throws IOException {

	 Object[][] data = ProductBasicInfoProjectName();

	 return data;
	}
	@DataProvider(name = "Product Incremental Revision Notes")
	public Object[][] parameterCredentials3() throws IOException {

	 Object[][] data = ProductIncrementalRevisionNotes();

	 return data;
	}
	@DataProvider(name = "Parts to Search")
	public Object[][] parameterCredentials4() throws IOException {

	 Object[][] data = PartstoSearch();

	 return data;
	}
	@DataProvider(name = "Part BasicInfo PartName")
	public Object[][] parameterCredentials5() throws IOException {

	 Object[][] data = PartBasicInfoPartName();

	 return data;
	}
	@DataProvider(name = "Part BasicInfo ProjectName")
	public Object[][] parameterCredentials6() throws IOException {

	 Object[][] data = PartBasicInfoProjectName();

	 return data;
	}
	@DataProvider(name = "Part Incremental Revision Notes")
	public Object[][] parameterCredentials7() throws IOException {

	 Object[][] data = PartIncrementalRevisionNotes();

	 return data;
	}
	@DataProvider(name = "ECR CardName")
	public Object[][] parameterCredentials8() throws IOException {

	 Object[][] data = ECRCardName();

	 return data;
	}
	@DataProvider(name = "ECR AddAffectedObjects one")
	public Object[][] parameterCredentials9() throws IOException {

	 Object[][] data = ECRAddAffectedObjectsone();

	 return data;
	}
	@DataProvider(name = "ECR AddAffectedObjects two")
	public Object[][] parameterCredentials10() throws IOException {

	 Object[][] data = ECRAddAffectedObjectstwo();

	 return data;
	}
	@DataProvider(name = "ECR AddAffectedObjectsThree")
	public Object[][] parameterCredentials11() throws IOException {

	 Object[][] data = ECRAddAffectedObjectsThree();

	 return data;
	}
	@DataProvider(name = "Search Parts")
	public Object[][] parameterCredentials12() throws IOException {

	 Object[][] data = SearchParts();

	 return data;
	}
	@DataProvider(name = "ECR Add Part Add Affected Objects")
	public Object[][] parameterCredentials13() throws IOException {

	 Object[][] data = ECRAddPartAddAffectedObjects();
	 
	 return data;
	}
	@DataProvider(name = "ECR TaskOneName")
	public Object[][] parameterCredentials14() throws IOException {

	 Object[][] data = ECRTaskOneName();

	 return data;
	}
	@DataProvider(name = "ECR Task ProjectManager")
	public Object[][] parameterCredentials15() throws IOException {

	 Object[][] data = ECRTaskProjectManager();

	 return data;
	}
	@DataProvider(name = "ECR TaskTwoName")
	public Object[][] parameterCredentials16() throws IOException {

	 Object[][] data = ECRTaskTwoName();

	 return data;
	}
	@DataProvider(name = "ECR Task ReleaseCo-ordinator")
	public Object[][] parameterCredentials17() throws IOException {

	 Object[][] data = ECRTaskReleaseCoordinator();

	 return data;
	}
	@DataProvider(name = "Search Keyword First")
	public Object[][] parameterCredentials18() throws IOException {

	 Object[][] data = SearchKeywordFirst();

	 return data;
	}
	@DataProvider(name = "Search Parts Keyword")
	public Object[][] parameterCredentials19() throws IOException {

	 Object[][] data = SearchPartsKeyword();

	 return data;
	}
	@DataProvider(name = "Search Update Ref in BOM")
	public Object[][] parameterCredentials20() throws IOException {

	 Object[][] data = SearchUpdateRefinBOM();

	 return data;
	}
	@DataProvider(name = "Search Update Quantity in BOM")
	public Object[][] parameterCredentials21() throws IOException {

	 Object[][] data = SearchUpdateQuantityinBOM();

	 return data;
	}
	@DataProvider(name = "Parts Another PartNumber In BillofMaterial")
	public Object[][] parameterCredentials22() throws IOException {

	 Object[][] data = SRPartsAnotherPartNumberInBillofMaterial();

	 return data;
	}
	@DataProvider(name = "Parts Another Location In BillofMaterial")
	public Object[][] parameterCredentials23() throws IOException {

	 Object[][] data = SRPartsAnotherLocationInBillofMaterial();

	 return data;
	}
	@DataProvider(name = "Parts Another Ref In BillofMaterial")
	public Object[][] parameterCredentials24() throws IOException {

	 Object[][] data = SRPartsAnotherRefInBillofMaterial();

	 return data;
	}
	@DataProvider(name = "Parts Another Quantity In BillofMaterial")
	public Object[][] parameterCredentials25() throws IOException {

	 Object[][] data = SRPartsAnotherQuantityInBillofMaterial();

	 return data;
	}
	@DataProvider(name = "Parts Another BOMNotes In BillofMaterial")
	public Object[][] parameterCredentials26() throws IOException {

	 Object[][] data = SRPartsAnotherBOMNotesInBillofMaterial();

	 return data;
	}
	@DataProvider(name = "Search Product Keyword")
	public Object[][] parameterCredentials27() throws IOException {

	 Object[][] data = SearchProductKeyword();

	 return data;
	}
	@DataProvider(name = "Products Another PartNumber In BillofMaterial")
	public Object[][] parameterCredentials28() throws IOException {

	 Object[][] data = SRProductsAnotherPartNumberInBillofMaterial();

	 return data;
	}
	@DataProvider(name = "Products Another Location In BillofMaterial")
	public Object[][] parameterCredentials29() throws IOException {

	 Object[][] data = SRProductsAnotherLocationInBillofMaterial();

	 return data;
	}
	@DataProvider(name = "Products Another Ref In BillofMaterial")
	public Object[][] parameterCredentials30() throws IOException {

	 Object[][] data = SRProductsAnotherRefInBillofMaterial();

	 return data;
	}
	@DataProvider(name = "Products Another Quantity In BillofMaterial")
	public Object[][] parameterCredentials31() throws IOException {

	 Object[][] data = SRProductsAnotherQuantityInBillofMaterial();

	 return data;
	}
	@DataProvider(name = "Products Another BOMNotes In BillofMaterial")
	public Object[][] parameterCredentials32() throws IOException {

		Object[][] data = SRProductsAnotherBOMNotesInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Products Add Another PartNumber In BillofMaterial")
	public Object[][] parameterCredentials33() throws IOException {

		Object[][] data = ProductsAddAnotherPartNumberInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Products Add Another Location In BillofMaterial")
	public Object[][] parameterCredentials34() throws IOException {

		Object[][] data = ProductsAddAnotherLocationInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Products Add Another Ref In BillofMaterial")
	public Object[][] parameterCredentials35() throws IOException {

		Object[][] data = ProductsAddAnotherRefInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Products Add Another Quantity In BillofMaterial")
	public Object[][] parameterCredentials36() throws IOException {

		Object[][] data = ProductsAddAnotherQuantityInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Products Add Another BOMNotes In BillofMaterial")
	public Object[][] parameterCredentials37() throws IOException {

		Object[][] data = ProductsAddAnotherBOMNotesInBillofMaterial();

		return data;
	}
	@DataProvider(name = "ECO Card Name")
	public Object[][] parameterCredentials38() throws IOException {

		Object[][] data = ECOCardName();

		return data;
	}
	@DataProvider(name = "ECO Board Object One Affected Objects")
	public Object[][] parameterCredentials39() throws IOException {

		Object[][] data = ECOBoardObjectOneAffectedObjects();

		return data;
	}
	@DataProvider(name = "ECO Board Object Two Affected Objects")
	public Object[][] parameterCredentials40() throws IOException {

		Object[][] data = ECOBoardObjectTwoAffectedObjects();

		return data;
	}	
	@DataProvider(name = "ECO Board Object Three Affected Objects")
	public Object[][] parameterCredentials41() throws IOException {

		Object[][] data = ECOBoardObjectThreeAffectedObjects();

		return data;
	}	
	@DataProvider(name = "ECO Board Product Affected Objects")
	public Object[][] parameterCredentials42() throws IOException {

		Object[][] data = ECOBoardProductAffectedObjects();

		return data;
	}		
	@DataProvider(name = "Search Parts ECO")
	public Object[][] parameterCredentials43() throws IOException {

		Object[][] data = SRSearchParts();

		return data;
	}	
	@DataProvider(name = "ECO Object One Add Affected Objects")
	public Object[][] parameterCredentials44() throws IOException {

		Object[][] data = ECOObjectOneAddAffectedObjects();

		return data;
	}
	@DataProvider(name = "ECO TaskOneName")
	public Object[][] parameterCredentials45() throws IOException {

		Object[][] data = ECOTaskOneName();

		return data;
	}
	@DataProvider(name = "ECO Assign ProjectManager")
	public Object[][] parameterCredentials46() throws IOException {

		Object[][] data = ECOAssignProjectManager();

		return data;
	}	
	@DataProvider(name = "ECO TaskTwoName")
	public Object[][] parameterCredentials47() throws IOException {

		Object[][] data = ECOTaskTwoName();

		return data;
	}
	@DataProvider(name = "ECO Assign ReleaseCoordinator")
	public Object[][] parameterCredentials48() throws IOException {

		Object[][] data = ECOAssignReleaseCoordinator();

		return data;
	}
	@DataProvider(name = "Parts Enter Description in Basic-Info from ECO")
	public Object[][] parameterCredentials49() throws IOException {

		Object[][] data = PartsEnterDescriptioninBasicInfofromECO();

		return data;
	}	
}
