package fusepackage;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import fusepackage.WrapperClass;
public class FusePartsandProducts extends WrapperClass{
	String browser;
	@BeforeClass
	public void Login() throws IOException, InterruptedException {
		String[][] data = getlogin();
		String user = data[0][0];
		String pass = data[0][1];
		browser = data [0][2];
		String role = data [0][3];
		String Url = data [0][4];
		//Launch Browsers
		launchBroswer( browser , Url);
		//Login
		sendvaluebyname("userEmail", user);
		sendvaluebyname("userPassword", pass);
		clickByXpath("//*[@id='login-form']/form/button");
		System.out.println("The " + role + " Login Successfully");
		Thread.sleep(3000);
		//Escape from the Guide menu
		clickByHDEmXpath("/html/body/div[6]/div/div[5]/a[2]");
		Thread.sleep(5000);
		iconClick("html/body/div[1]/div[1]/md-sidenav[1]/md-toolbar/md-icon");
	}
	@Test(priority = 1,enabled = true,groups = {"Parts"})
	public void PTPDT0001ClickonPartsfromLeftTree()throws IOException, InterruptedException {
		//Parts
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 2,enabled = true,groups = {"Parts"})
	public void PTPDT0002ClickonCreateNewButtoninParts()throws IOException, InterruptedException {
		//Create Part 
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div[2]/div[2]/button/a");
		Thread.sleep(3000);
	}
	@Test(priority = 3,dataProvider = "Enter Part Name",enabled = true,groups = {"Parts"})
	public void PTPDT0003EnterPartName(String PartName)throws IOException, InterruptedException {
		//Enter the Part Name
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[1]/input", PartName);
		Thread.sleep(3000);
	}
	@Test(priority = 4,dataProvider = "Enter Part Category Name",enabled = true,groups = {"Parts"})
	public void PTPDT0003EnterPartCategoryName(String PartCategory)throws IOException, InterruptedException {
		//Select the category
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[2]/md-input-container/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartCategory);
		Thread.sleep(3000);
	}
	@Test(priority = 5,dataProvider = "Enter Part Revision Note",enabled = true,groups = {"Parts"})
	public void PTPDT0003EnterPartRevisionNote(String RevisionNote)throws IOException, InterruptedException {
		//Enter the Revision Notes
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[3]/input",RevisionNote);
		Thread.sleep(3000);
	}
	@Test(priority = 6,enabled = true,groups = {"Parts"})
	public void PTPDT0003ClickonCreateButtoninParts()throws IOException, InterruptedException {
		//Click on create Button
		clickByXpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-actions/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 7,enabled = true,groups = {"Parts"})
	public void PTPDT0003StatusOfPartCreation()throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div[@class='md-toast-content']");
		Thread.sleep(3000);
	}
	@Test(priority = 8,enabled = true,groups = {"Parts"})
	public void PTPDT0004PartIncrementalRevisionCheck() throws IOException, InterruptedException{
		//Click on Incremental Revision Button
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/button[@class='white-fg md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 9,enabled = true,groups = {"Parts"})
	public void PTPDT0004ClickYESonConfirmationMessageinPartIncrementalRevisionCheck() throws IOException, InterruptedException{
		//Click Yes on the Confirmation message
		clickByXpath("html/body/div[4]/md-dialog/md-dialog-actions/button[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 10,dataProvider = "Part Incremental Revision",enabled = true,groups = {"Parts"})
	public void PTPDT0004EntertheRevisionNotesinPartIncrementalRevisionCheck(String Note) throws IOException, InterruptedException{
		//Enter the Revision Notes
		sendvaluebyxpath("//div[@id='content-container']/div[2]/md-dialog/form/md-dialog-content/md-input-container/input", Note);
	}
	@Test(priority = 11,enabled = true,groups = {"Parts"})
	public void PTPDT0004ClickonCreateButtonforPartIncrementalRevisionCheck() throws IOException, InterruptedException{
		//Click on Create Button
		clickByXpath("//div[@id='content-container']/div[2]/md-dialog/form/md-dialog-actions/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 12,enabled = true,groups = {"Parts"})
	public void PTPDT0004StatusofPartIncrementalRevisionCheck()throws IOException, InterruptedException {
		//Verify the status
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 13,enabled = true,groups = {"Parts"})
	public void PTPDT0004ClosethePartInrementalRevisionPopup()throws IOException, InterruptedException {
		//Close the Incremental Revision Popup
		clickByXpath("/html/body/div[1]/div/div/div[2]/md-dialog/form/md-toolbar/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 14,enabled = true,groups = {"Parts"})
	public void PTPDT0004ClosetheStatusofPartIncrementalRevisionCheck()throws IOException, InterruptedException {
		//Close the Text Box
		clickByXpath("html/body/md-toast/div/button");
		Thread.sleep(5000);
	}
	@Test(priority = 15,enabled = true,groups = {"Parts"})
	public void PTPDT0005CheckChangeStatusinPart() throws IOException,InterruptedException{
		//Click on Change Status
		Searchelement("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/md-menu/button[@class='white-fg md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 16,enabled = true,groups = {"Parts"})
	public void PTPDT0006CheckHistoryinBasicInfoofPart()throws IOException, InterruptedException{
		//Check History section in Basic Info
		createdby("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div[2]/div/div[2]/table/tbody/tr/td/p", "//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div[2]/div/div[2]/table/tbody/tr/td[2]/p");
		Thread.sleep(5000);
	}
	@Test(priority = 17,dataProvider = "Part-Enter Description in Basic-Info",enabled = true,groups = {"Parts"})
	public void PTPDT0007EnterDescriptioninBasicInfoofPart(String Des)throws IOException, InterruptedException{
		//Go to Basic Info and Enter Description and Save the Part Details
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div/div/div/form/div/md-input-container/input", Des);
		Thread.sleep(5000);
	}
	@Test(priority = 18,enabled = true,groups = {"Parts"})
	public void PTPDT0007SavetheBasicInfoofPart()throws IOException, InterruptedException{
		//Click on save Button
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/button[@class='md-raised md-button md-default-theme md-ink-ripple']");
		Thread.sleep(5000);
	}
	@Test(priority = 19,enabled = true,groups = {"Parts"})
	public void PTPDT0007GetBasicInfoHistoryBeforeUpdationofPart()throws IOException, InterruptedException{
		//Get the Basic Info History Before the Updation
		gettext("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div[2]/div/div[2]/table/tbody/tr/td[4]/p");
		Thread.sleep(5000);
	}
	@Test(priority = 20,dataProvider = "Part-Enter UnitMeasure in Basic-Info",enabled = true,groups = {"Parts"})
	public void PTPDT0007EnterUnitMeasureinBasicInfoofPart(String Unitmeasure)throws IOException, InterruptedException{
		//Enter the Unit Measure in the Basic-Info 
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div/div/div/form/div[2]/md-input-container/input", Unitmeasure);
		Thread.sleep(5000);
	}
	@Test(priority = 21,dataProvider = "Part-Enter Protype in Basic-Info",enabled = true,groups = {"Parts"})
	public void PTPDT0007EnterProtypeinBasicInfoofPart(String Protype)throws IOException, InterruptedException{
		//Enter the Protype in the Basic-Info
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div/div/div/form/div[2]/md-input-container[2]/input", Protype);
		Thread.sleep(5000);
	}
	@Test(priority = 22,dataProvider = "Part-Enter Projname in Basic-Info",enabled = true,groups = {"Parts"})
	public void PTPDT0007EnterProjnameinBasicInfoofPart(String Projname)throws IOException, InterruptedException{
		//Enter the ProjName in Basic-Info
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[3]/md-chips[1]/md-chips-wrap/div/div/input", Projname);
		Thread.sleep(5000);
	}
	@Test(priority = 23,dataProvider = "Part-Enter Tags in Basic-Info",enabled = true,groups = {"Parts"})
	public void PTPDT0008EnterTagsinBasicInfoofPart(String Tags)throws IOException, InterruptedException{
		//Enter the Tags Name in the Basic-Info
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[3]/md-chips[2]/md-chips-wrap/div/div/input", Tags);
		Thread.sleep(3000);
	}
	@Test(priority = 24,enabled = true,groups = {"Parts"})
	public void PTPDT0008SavetheBasicInfofinalyofPart()throws IOException, InterruptedException{
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/button[@class='md-raised md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 25,enabled = true,groups = {"Parts"})
	public void PTPDT0008GetStatusoftheBasicInfoUpdationofPart()throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 26,enabled = true,groups = {"Parts"})
	public void PTPDT0009GetBasicInfoHistoryAfterUpdationofPart()throws IOException, InterruptedException{
		verifytext("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div[2]/div/div[2]/table/tbody/tr/td[4]/p");
		Thread.sleep(5000);
	}
	@Test(priority = 27,enabled = true,groups = {"Parts"})
	public void PTPDT0010ClickonAdditionalInfoTabinPart() throws IOException,InterruptedException{
		//Go to Additional Info
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 28,enabled = true,groups = {"Parts"})
	public void PTPDT0010GetPartIdentitytoEnterAdditionalInfo() throws IOException, InterruptedException {			
		gettexttrim("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div/div[1]/div[1]/div[1]/span[3]/strong");
		Thread.sleep(5000);
	}
	@Test(priority = 29,enabled = true,groups = {"Parts"},dependsOnMethods = {"PTPDT0010GetPartIdentitytoEnterAdditionalInfo"})
	public void PTPDT0010DoAdditioanlInfoIfPartisInDevelopment() throws IOException, InterruptedException {	
		//Enter Additional Info
		a.equals("InDevelopment");
		Thread.sleep(5000);
	}
	@Test(priority = 30,dataProvider = "Part InternalTrackingNumber",enabled = true,dependsOnMethods={"PTPDT0010DoAdditioanlInfoIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0010EnterInternalTrackingNumberinAdditionalInfoofPart(String InternalTrackingNumber) throws IOException,InterruptedException{
		//Enter Internal Tracking Number in Additional Info
		sendvaluebyxpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/md-content/div/div/form/div/md-input-container[3]/input", InternalTrackingNumber);
		Thread.sleep(5000);
	}
	@Test(priority = 31,enabled = true,groups = {"Parts"})
	public void PTPDT0011SearchBillofmaterialtapinPart() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 32,enabled = true,groups = {"Parts"})
	public void PTPDT0012ClickonAttachmentsTabinPart() throws InterruptedException, IOException{
		//Click on Attachments
		clickByXpath("//div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[3]");
	    Thread.sleep(5000);
	}
	@Test(priority = 33,enabled = true,groups = {"Parts"})
	public void PTPDT0012GetPartIdentitytoDoAttachments() throws InterruptedException, IOException{
	    gettexttrim("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div/div[1]/div[1]/div[1]/span[3]/strong");
	}
	@Test(priority = 34,enabled = true,groups = {"Parts"},dependsOnMethods = {"PTPDT0012GetPartIdentitytoDoAttachments"})
	public void PTPDT0012DoAttachmentsIfPartisInDevelopment() throws InterruptedException, IOException{
		a.equalsIgnoreCase("InDevelopment");
	}
	@Test(priority = 35,enabled = true,dependsOnMethods={"PTPDT0012DoAttachmentsIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0012ClickonUploadButtoninAttachementsofParts() throws InterruptedException, IOException{
	    clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[3]/div/md-content/div/div/div/div/div/div/div/div[2]/div/md-menu[2]/button");
	    Thread.sleep(3000);
	}
	@Test(priority = 36,enabled = true,dependsOnMethods={"PTPDT0012DoAttachmentsIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0012DoAutoITtoUploadJPGfileinAttachementsofParts() throws InterruptedException, IOException{
	    Runtime.getRuntime().exec("C:\\Users\\Lakshmanan.S\\workspace\\Fuseplm\\sel-auto-testing\\AutoIT\\AutoIt\\FileUpload.exe");  //Uploading .jpg file using AutoIT
	    Thread.sleep(5000);
	}
	@Test(priority = 37,enabled = true,dependsOnMethods={"PTPDT0012DoAttachmentsIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0012DoAutoITtoUploadPDFfileinAttachementsofParts() throws InterruptedException, IOException{
	    Runtime.getRuntime().exec("C:\\Users\\Lakshmanan.S\\workspace\\Fuseplm\\sel-auto-testing\\AutoIT\\AutoIt\\FileUpload2.exe"); //Uploading pdf file using AutoIT
	    Thread.sleep(5000);
	}
	@Test(priority = 38,enabled = true,dependsOnMethods={"PTPDT0012DoAttachmentsIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0012ClickSaveButtoninAttachementsofParts() throws InterruptedException, IOException{
	    //save
	    clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/button[@class='md-raised md-button md-default-theme md-ink-ripple']");
	    Thread.sleep(2000);
	} 
	@Test(priority = 39,enabled = true,groups = {"Parts"})
	public void PTPDT0013ClickOnWhereusedTapinPart() throws InterruptedException,IOException{
		//Where-Used
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(15000);
	}
	@Test(priority = 40,enabled = true,groups = {"Parts"})
	public void PTPDT0014ClickOnCommentsTabfromthePartView() throws IOException, InterruptedException{
		//Click on Comments
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[8]");
		Thread.sleep(3000);
	}
	@Test(priority = 41,dataProvider = "Parts First Comments",enabled = true,groups = {"Parts"})
	public void PTPDT0014EntertheCommentsinthePart(String Comments) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[8]/div/md-content/div/div/div/div/div[2]/form/div[1]/md-input-container/div[1]/textarea", Comments);	
	}
	@Test(priority = 42,enabled = true,groups = {"Parts"})
	public void PTPDT0014ClickonAddButtontoAddtheCommentsinthePart() throws IOException, InterruptedException{
	clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[8]/div/md-content/div/div/div/div/div[2]/form/div[2]/button");
	}
	@Test(priority = 43,enabled = true,groups = {"Parts"})
	public void PTPDT0014StatusoftheCommentsAddedinthePart() throws IOException, InterruptedException{
	verifystatus("/html/body/md-toast/div[@class='md-toast-content']");
	}
	@Test(priority = 44,dataProvider = "Parts Second Comments",enabled = true,groups = {"Parts"})
	public void PTPDT0015AddOnemoreCommentsinthePart(String Comments) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[8]/div/md-content/div/div/div/div/div[2]/form/div[1]/md-input-container/div[1]/textarea", Comments);	
	}
	@Test(priority = 45,enabled = true,groups = {"Parts"})
	public void PTPDT0015ClickonAddButtontoAddtheCommentsinthePart() throws IOException, InterruptedException{
	clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[8]/div/md-content/div/div/div/div/div[2]/form/div[2]/button");
	}
	@Test(priority = 46,enabled = true,groups = {"Parts"})
	public void PTPDT0015StatusoftheCommentsAddedinthePart() throws IOException, InterruptedException{
	verifystatus("/html/body/md-toast/div[@class='md-toast-content']");
	}
	@Test(priority = 47,enabled = true,groups = {"Parts"})
	public void PTPDT0016ClickonSourcingTapinPart() throws IOException, InterruptedException {	
		//Go to Souring
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[4]");
		Thread.sleep(5000);
	}
	@Test(priority = 48,enabled = true,groups = {"Parts"})
	public void PTPDT0017GetPartIdentitytoClickonManufacturerinSourcing() throws IOException, InterruptedException {			
		gettexttrim("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div/div[1]/div[1]/div[1]/span[3]/strong");
		Thread.sleep(5000);
	}
	@Test(priority = 49,enabled = true,groups = {"Parts"},dependsOnMethods = {"PTPDT0017GetPartIdentitytoClickonManufacturerinSourcing"})
	public void PTPDT0017ClickonManufacturerIfPartisInDevelopment() throws IOException, InterruptedException {	
		//Click on Manufacturer
		a.equals("InDevelopment");
		Thread.sleep(5000);
	}
	@Test(priority = 50,enabled = true,dependsOnMethods={"PTPDT0017ClickonManufacturerIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0017ClickonAddNewManufacturerinSourcingofPart() throws IOException, InterruptedException {
		//Add new manufacturer
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[4]/div/md-content/div[1]/div/div/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 51,enabled = true,dataProvider = "Part ManufacturerName In Sourcing",dependsOnMethods={"PTPDT0017ClickonManufacturerIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0018EnterManufacturerNameinSourcingofPart(String ManufacturerName) throws IOException, InterruptedException {
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[1]/input", ManufacturerName);
	}
	@Test(priority = 52,enabled = true,dataProvider = "Part ManufacturerPartNumber In Sourcing",dependsOnMethods={"PTPDT0017ClickonManufacturerIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0018EnterManufacturerPartNameinSourcingofPart(String ManufacturerPartNumber) throws IOException, InterruptedException {
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[2]/input", ManufacturerPartNumber);
	}
	@Test(priority = 53,enabled = true,dataProvider = "Part ManufacturerDescription In Sourcing",dependsOnMethods={"PTPDT0017ClickonManufacturerIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0018EnterManufacturerDescriptioninSourcingofPart(String ManufacturerDescription) throws IOException, InterruptedException {
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[3]/input", ManufacturerDescription);
	}
	@Test(priority = 54,enabled = true,dataProvider = "Part ManufacturerCost In Sourcing",dependsOnMethods={"PTPDT0017ClickonManufacturerIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0018EnterManufacturerCostinSourcingofPart(String ManufacturerCost) throws IOException, InterruptedException {
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[4]/input", ManufacturerCost);
	}
	@Test(priority = 55,enabled = true,dataProvider = "Part ManufacturerCurrency In Sourcing",dependsOnMethods={"PTPDT0017ClickonManufacturerIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0018EnterManufacturerCurrencyinSourcingofPart(String ManufacturerCurrency) throws IOException, InterruptedException {
		currencysc("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[5]/md-select/md-select-value", ManufacturerCurrency);
		Thread.sleep(3000);
	}
	@Test(priority = 56,enabled = true,dataProvider = "Part ManufacturerApproved In Sourcing",dependsOnMethods={"PTPDT0017ClickonManufacturerIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0018EnterManufacturerApprovedinSourcingofPart(String ManufacturerApproved) throws IOException, InterruptedException {
		approvedsc("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[6]/md-select", ManufacturerApproved);
		Thread.sleep(3000);
	}
	@Test(priority = 57,enabled = true,dataProvider = "Part ManufacturerAvailable In Sourcing",dependsOnMethods={"PTPDT0017ClickonManufacturerIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0018EnterManufacturerAvailableinSourcingofPart(String ManufacturerAvailable) throws IOException, InterruptedException {
		availablesc("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[7]/md-select", ManufacturerAvailable);
		Thread.sleep(3000);
	}
	@Test(priority = 58,enabled = true,dependsOnMethods={"PTPDT0017ClickonManufacturerIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0018ClickOnAddManufacturerButtoninSourcingofPart() throws IOException, InterruptedException {
		clickByXpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-actions/div[1]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 59,enabled = true,dependsOnMethods={"PTPDT0017ClickonManufacturerIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0019ClickOnAttachmentButtoninManufacturerofPart() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[4]/div/md-content/div[1]/div/div/div[2]/table/tbody/tr[1]/td[9]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 60,enabled = true,dependsOnMethods={"PTPDT0017ClickonManufacturerIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0019ClickOnUploadButtontoAttachinManufacturerofPart() throws IOException, InterruptedException {
		clickByXpath("//div/div/div/div[2]/md-dialog/md-dialog-content/div[1]/div/div[2]/div[2]/div/div[2]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 61,enabled = true,dependsOnMethods={"PTPDT0017ClickonManufacturerIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0020DoAutoITtouploadJPGfileinManufacturerofPart() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("C:\\Users\\Lakshmanan.S\\workspace\\Fuseplm\\sel-auto-testing\\AutoIT\\AutoIt\\FileUpload3.exe");   //upload .jpg file using AutoIt
		Thread.sleep(5000);
	}
	@Test(priority = 62,enabled = true,dependsOnMethods={"PTPDT0017ClickonManufacturerIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0020ClosetheUploadPopupinManufacturerofPart() throws IOException, InterruptedException {
		clickByXpath("//div/div/div/div[2]/md-dialog/md-toolbar/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 63,enabled = true,groups = {"Parts"},dependsOnMethods = {"PTPDT0017GetPartIdentitytoClickonManufacturerinSourcing"})
	public void PTPDT0021ClickonSupplierIfPartisInDevelopment() throws IOException, InterruptedException {
		a.equals("InDevelopment");
	}
	@Test(priority = 64,enabled = true,dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0021ClickonAddNewSupplierinSourcingofPart() throws IOException, InterruptedException {
		//Click on Add New Supplier
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[4]/div/md-content/div[2]/div/div/div[1]/button");
		Thread.sleep(2000);
	}
	@Test(priority = 65,enabled = true,dataProvider = "Part SupplierName In Sourcing",dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0022EnterSupplierNameinSourcingofPart(String SupplierName) throws IOException, InterruptedException {	
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[1]/input", SupplierName);
	}
	@Test(priority = 66,enabled = true,dataProvider = "Part SupplierPartNumber In Sourcing",dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0022EnterSupplierPartNumberinSourcingofPart(String SupplierPartNumber) throws IOException, InterruptedException {	
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[2]/input", SupplierPartNumber);
	}
	@Test(priority = 67,enabled = true,dataProvider = "Part ManufacturerNameSupp In Sourcing",dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0022EnterManufacturerNameSuppinSourcingofPart(String ManufacturerNameSupp) throws IOException, InterruptedException {	
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[3]/input", ManufacturerNameSupp);
	}
	@Test(priority = 68,enabled = true,dataProvider = "Part ManufacturerPartNumberSupp In Sourcing",dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0022EnterManufacturerPartNumberSuppinSourcingofPart(String ManufacturerPartNumberSupp) throws IOException, InterruptedException {	
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[4]/input", ManufacturerPartNumberSupp);
	}
	@Test(priority = 69,enabled = true,dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0022ScrolldownonSupplierinSourcingofPart() throws IOException, InterruptedException {	
		scroll("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[5]/input");
	}
	@Test(priority = 70,enabled = true,dataProvider = "Part SupplierDescription In Sourcing",dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0022EnterSupplierDescriptioninSourcingofPart(String SupplierDescription) throws IOException, InterruptedException {	
		sendwoutclvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[5]/input", SupplierDescription);
	}
	@Test(priority = 71,enabled = true,dataProvider = "Part SupplierCost In Sourcing",dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0022EnterSupplierCostinSourcingofPart(String SupplierCost) throws IOException, InterruptedException {	
		sendwoutclvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[6]/input", SupplierCost);
	}
	@Test(priority = 72,enabled = true,dataProvider = "Part SupplierCurrency In Sourcing",dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0022EnterSupplierCurrencyinSourcingofPart(String SupplierCurrency) throws IOException, InterruptedException {	
		currencysc("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[7]/md-select/md-select-value", SupplierCurrency);
		Thread.sleep(3000);
	}
	@Test(priority = 73,enabled = true,dataProvider = "Part SupplierApproved In Sourcing",dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0022EnterSupplierApprovedinSourcingofPart(String SupplierApproved) throws IOException, InterruptedException {	
		approvedsc("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[8]/md-select", SupplierApproved);
		Thread.sleep(3000);
	}
	@Test(priority = 74,enabled = true,dataProvider = "Part SupplierAvailable In Sourcing",dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0022EnterSupplierAvailableinSourcingofPart(String SupplierAvailable) throws IOException, InterruptedException {	
		availablesc("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[9]/md-select", SupplierAvailable);
		Thread.sleep(3000);
	}
	@Test(priority = 75,enabled = true,dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0022ClickonAddsupplierButtoninSourcingofPart() throws IOException, InterruptedException {	
		clickByXpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-actions/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 76,enabled = true,dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT00123ClickOnAttachmentButtoninSourcingofPart() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[4]/div/md-content/div[2]/div/div/div[2]/table/tbody/tr[1]/td[11]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 77,enabled = true,dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0023ClickOnUploadButtontoAttachinSourcingofPart() throws IOException, InterruptedException {
		clickByXpath("html/body/div[1]/div[1]/div/div[2]/md-dialog/md-dialog-content/div[1]/div/div[2]/div[2]/div/div[2]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 78,enabled = true,dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0024DoAutoITtouploadJPGfileinSourcingofPart() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("C:\\Users\\Lakshmanan.S\\workspace\\Fuseplm\\sel-auto-testing\\AutoIT\\AutoIt\\FileUpload3.exe");   //upload .jpg file using AutoIt
		Thread.sleep(5000);
	}
	@Test(priority = 79,enabled = true,dependsOnMethods={"PTPDT0021ClickonSupplierIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0024ClosetheUploadPopupinSourcingofPart() throws IOException, InterruptedException {
		clickByXpath("//div/div/div/div[2]/md-dialog/md-toolbar/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 80,enabled = true,groups = {"Parts"})
	public void PTPDT0025ClickOnTimelineTabfromPartView() throws InterruptedException,IOException{
		//Click on Time-Line
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[7]");
		Thread.sleep(3000);
	}
	@Test(priority = 81,enabled = true,groups = {"Parts"})
	public void PTPDT0026ClickonPartsfromLeftTree()throws IOException, InterruptedException {
		//Parts
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 82,enabled = true,groups = {"Parts"})
	public void PTPDT0027ClickonCreateNewButtoninParts()throws IOException, InterruptedException {
		//Create Part 
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div[2]/div[2]/button/a");
		Thread.sleep(3000);
	}
	@Test(priority = 83,dataProvider = "Enter Part2 Name",enabled = true,groups = {"Parts"})//My Capcitor
	public void PTPDT0028EnterPartName(String PartName)throws IOException, InterruptedException {
		//Enter the Part Name
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[1]/input", PartName);
		Thread.sleep(3000);
	}
	@Test(priority = 84,dataProvider = "Enter Part2 Category Name",enabled = true,groups = {"Parts"})
	public void PTPDT0028EnterPartCategoryName(String PartCategory)throws IOException, InterruptedException {
		//Select the category
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[2]/md-input-container/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartCategory);
		Thread.sleep(3000);
	}
	@Test(priority = 85,dataProvider = "Enter Part2 Revision Note",enabled = true,groups = {"Parts"})
	public void PTPDT0028EnterPartRevisionNote(String RevisionNote)throws IOException, InterruptedException {
		//Enter the Revision Notes
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[3]/input",RevisionNote);
		Thread.sleep(3000);
	}
	@Test(priority = 86,enabled = true,groups = {"Parts"})
	public void PTPDT0028ClickonCreateButtoninParts()throws IOException, InterruptedException {
		//Click on create Button
		clickByXpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-actions/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 87,enabled = true,groups = {"Parts"})
	public void PTPDT0028StatusOfPartCreation()throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div[@class='md-toast-content']");
		Thread.sleep(3000);
	}
	@Test(priority = 88,enabled = true,groups = {"Parts"})
	public void PTPDT0029ClickonAdditionalInfoTabinPart() throws IOException,InterruptedException{
		//Go to Additional Info
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 89,enabled = true,groups = {"Parts"})
	public void PTPDT0029GetPartIdentitytoEnterAdditionalInfo() throws IOException, InterruptedException {			
		gettexttrim("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div/div[1]/div[1]/div[1]/span[3]/strong");
		Thread.sleep(5000);
	}
	@Test(priority = 90,enabled = true,groups = {"Parts"},dependsOnMethods = {"PTPDT0029GetPartIdentitytoEnterAdditionalInfo"})
	public void PTPDT0029DoAdditioanlInfoIfPartisInDevelopment() throws IOException, InterruptedException {	
		//Enter Additional Info
		a.equals("InDevelopment");
		Thread.sleep(5000);
	}
	@Test(priority = 91,dataProvider = "Part2 InternalTrackingNumber",enabled = true,dependsOnMethods={"PTPDT0029DoAdditioanlInfoIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0030EnterInternalTrackingNumberinAdditionalInfoofPart(String InternalTrackingNumber) throws IOException,InterruptedException{
		//Enter Internal Tracking Number in Additional Info
		sendvaluebyxpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/md-content/div/div/form/div/md-input-container[3]/input", InternalTrackingNumber);
		Thread.sleep(5000);
	}
	@Test(priority = 92,enabled = true,groups = {"Parts"})
	public void PTPDT0031SearchBillofmaterialtapinPart() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 93,enabled = true,groups = {"Parts"})
	public void PTPDT0032ClickonPartsfromLeftTree()throws IOException, InterruptedException {
		//Parts
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 94,enabled = true,groups = {"Parts"})
	public void PTPDT0032ClickonCreateNewButtoninParts()throws IOException, InterruptedException {
		//Create Part 
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div[2]/div[2]/button/a");
		Thread.sleep(3000);
	}
	@Test(priority = 95,dataProvider = "Enter Part3 Name",enabled = true,groups = {"Parts"})
	public void PTPDT0032EnterPartName(String PartName)throws IOException, InterruptedException {
		//Enter the Part Name
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[1]/input", PartName);
		Thread.sleep(3000);
	}
	@Test(priority = 96,dataProvider = "Enter Part3 Category Name",enabled = true,groups = {"Parts"})
	public void PTPDT0032EnterPartCategoryName(String PartCategory)throws IOException, InterruptedException {
		//Select the category
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[2]/md-input-container/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartCategory);
		Thread.sleep(3000);
	}
	@Test(priority = 97,dataProvider = "Enter Part3 Revision Note",enabled = true,groups = {"Parts"})
	public void PTPDT0032EnterPartRevisionNote(String RevisionNote)throws IOException, InterruptedException {
		//Enter the Revision Notes
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[3]/input",RevisionNote);
		Thread.sleep(3000);
	}
	@Test(priority = 98,enabled = true,groups = {"Parts"})
	public void PTPDT0032ClickonCreateButtoninParts()throws IOException, InterruptedException {
		//Click on create Button
		clickByXpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-actions/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 99,enabled = true,groups = {"Parts"})
	public void PTPDT0032StatusOfPartCreation()throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div[@class='md-toast-content']");
		Thread.sleep(3000);
	}
	@Test(priority = 100,enabled = true,groups = {"Parts"})
	public void PTPDT0033ClickonPartsfromLeftTree()throws IOException, InterruptedException {
		//Parts
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 101,enabled = true,groups = {"Parts"})
	public void PTPDT0034ClickonCreateNewButtoninParts()throws IOException, InterruptedException {
		//Create Part 
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div[2]/div[2]/button/a");
		Thread.sleep(3000);
	}
	@Test(priority = 102,dataProvider = "Enter Part4 Name",enabled = true,groups = {"Parts"})
	public void PTPDT0035EnterPartName(String PartName)throws IOException, InterruptedException {
		//Enter the Part Name
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[1]/input", PartName);
		Thread.sleep(3000);
	}
	@Test(priority = 103,dataProvider = "Enter Part4 Category Name",enabled = true,groups = {"Parts"})
	public void PTPDT0035EnterPartCategoryName(String PartCategory)throws IOException, InterruptedException {
		//Select the category
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[2]/md-input-container/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartCategory);
		Thread.sleep(3000);
	}
	@Test(priority = 104,dataProvider = "Enter Part4 Revision Note",enabled = true,groups = {"Parts"})
	public void PTPDT0035EnterPartRevisionNote(String RevisionNote)throws IOException, InterruptedException {
		//Enter the Revision Notes
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[3]/input",RevisionNote);
		Thread.sleep(3000);
	}
	@Test(priority = 105,enabled = true,groups = {"Parts"})
	public void PTPDT0035ClickonCreateButtoninParts()throws IOException, InterruptedException {
		//Click on create Button
		clickByXpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-actions/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 106,enabled = true,groups = {"Parts"})
	public void PTPDT0035StatusOfPartCreation()throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div[@class='md-toast-content']");
		Thread.sleep(3000);
	}
	@Test(priority = 107,enabled = true,groups = {"Parts"})
	public void PTPDT0036SearchBillofmaterialtapinPart() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 108,enabled = true,dependsOnMethods={"PTPDT0036SearchBillofmaterialtapinPart"},groups = {"Parts"})
	public void PTPDT0036ClickonBillofmaterialtapinPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 109,enabled = true,dependsOnMethods={"PTPDT0036ClickonBillofmaterialtapinPart"},groups = {"Parts"})
	public void PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment() throws IOException, InterruptedException {
		a.equals("InDevelopment");
	}
	@Test(priority = 110,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0037InPartsClickonAddBillofmaterialButtoninBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[1]/div/button[2]");
		Thread.sleep(15000);
	}
	@Test(priority = 111,enabled = true,dataProvider = "Parts PartNumber In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0038InPartsEnterPartNumberinAddBOM(String PartNumber) throws IOException, InterruptedException{
		sendpartvaluebyxpathanddownclick("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[1]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartNumber);
		Thread.sleep(3000);
	}
	@Test(priority = 112,enabled = true,dataProvider = "Parts Location In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0038InPartsEnterLocationinAddBOM(String Location) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[2]/input", Location);
		Thread.sleep(3000);
	}
	@Test(priority = 113,enabled = true,dataProvider = "Parts Ref In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0038InPartsEnterRefinAddBOM(String Ref) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[3]/md-chips/md-chips-wrap/div/div/input", Ref);
		Thread.sleep(3000);
	}
	@Test(priority = 114,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0038InPartsScrolldowninAddBOM() throws IOException, InterruptedException{
		scroll("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input");
	}
	@Test(priority = 115,enabled = true,dataProvider = "Parts Quantity In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0039InPartsEnterQuantityinAddBOM(String Quantity) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[4]/input", Quantity);
		Thread.sleep(3000);
	}
	@Test(priority = 116,enabled = true,dataProvider = "Parts Change Quantity In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0040InPartsChangeQuantityinAddBOM(String Quantity) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[4]/input", Quantity);
		Thread.sleep(3000);
	}
	@Test(priority = 117,enabled = true,dataProvider = "Parts BOMNotes In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0040InPartsEnterBOMNotesinAddBOM(String BOMNotes) throws IOException, InterruptedException{
		sendwoutclvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input", BOMNotes);
		Thread.sleep(3000);
	}
	@Test(priority = 118,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0040InPartsClickAddParttoBOMButtoninAddBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[5]/md-dialog/form/md-dialog-actions/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 119,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0040InPartsStatusofAddParttoBOM() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(10000);
	}
	//Add Existing Part into the BOM
	@Test(priority = 120,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0041InPartsClickonAddBillofmaterialButtoninBOMforAddExistingPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[1]/div/button[2]");
		Thread.sleep(15000);
	}
	@Test(priority = 121,enabled = true,dataProvider = "Parts Add Existing PartNumber In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0041InPartsEnterexistingPartNumberinAddBOM(String PartNumber) throws IOException, InterruptedException{
		sendpartvaluebyxpathanddownclick("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[1]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartNumber);
		Thread.sleep(3000);
	}	
	@Test(priority = 122,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0041InPartsClickAddParttoBOMButtoninAddBOMforAddExistingPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[5]/md-dialog/form/md-dialog-actions/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 123,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0041InPartsClickonCloseButtoninAddBillofmaterialPopupMenu() throws IOException, InterruptedException{
		clickByXpath("html/body/div[5]/md-dialog/form/md-toolbar/div[1]/button");
	}
	@Test(priority = 124,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0041InPartsClickonCloseButtoninAddBillofmaterialStatus() throws IOException, InterruptedException{
		clickByXpath("html/body/md-toast/div/button");
		Thread.sleep(10000);
	}
	@Test(priority = 125,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0042InPartsClickonAddBillofmaterialButtontoAddanotherPartinBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[1]/div/button[2]");
		Thread.sleep(15000);
	}
	@Test(priority = 126,enabled = true,dataProvider = "Parts Another PartNumber In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0042InPartsEnterAnotherPartNumberinAddBOM(String PartNumber) throws IOException, InterruptedException{
		sendpartvaluebyxpathanddownclick("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[1]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartNumber);
		Thread.sleep(3000);
	}
	@Test(priority = 127,enabled = true,dataProvider = "Parts Another Location In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0042InPartsEnterAnotherLocationinAddBOM(String Location) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[2]/input", Location);
		Thread.sleep(3000);
	}
	@Test(priority = 128,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0042InPartsScrolldowninAddBOMforaddAnotherBOM() throws IOException, InterruptedException{
		scroll("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input");
	}
	@Test(priority = 129,enabled = true,dataProvider = "Parts Another Quantity In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0042InPartsEnterAnotherQuantityinAddBOM(String Quantity) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[4]/input", Quantity);
		Thread.sleep(3000);
	}
	@Test(priority = 130,enabled = true,dataProvider = "Parts Another BOMNotes In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0042InPartsEnterAnotherBOMNotesinAddBOM(String BOMNotes) throws IOException, InterruptedException{
		sendwoutclvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input", BOMNotes);
		Thread.sleep(3000);
	}
	@Test(priority = 131,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0042InPartsClickAddParttoBOMButtoninAddBOMforAddAnotherPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[5]/md-dialog/form/md-dialog-actions/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 132,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0042PartStatusofAddAnotherParttoBOM() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(10000);
	}
	@Test(priority = 133,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0043ClickonPartfromPartAddedintheBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[2]/div/table/tbody/tr/td[3]/a");
		Thread.sleep(5000);
	}
	@Test(priority = 134,enabled = true,groups = {"Parts"})
	public void PTPDT0044ClickOnWhereusedTapinPartView() throws InterruptedException,IOException{
		//Where-Used
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[6]/span");
		Thread.sleep(15000);
	}
	@Test(priority = 135,enabled = true,groups = {"Parts"})
	public void PTPDT0045ClickOnPartinWhereused() throws InterruptedException,IOException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[6]/div/md-content/div/div/div[2]/div/table/tbody/tr/td[2]/a");
		Thread.sleep(10000);
	}
	@Test(priority = 136,enabled = true,groups = {"Parts"})
	public void PTPDT0045SearchBillofmaterialtapinPartfromWherUsed() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 137,enabled = true,dependsOnMethods={"PTPDT0045SearchBillofmaterialtapinPartfromWherUsed"},groups = {"Parts"})
	public void PTPDT0045ClickonBillofmaterialtapinPartfromWhereUsed() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 138,enabled = true,dependsOnMethods={"PTPDT0045ClickonBillofmaterialtapinPartfromWhereUsed"},groups = {"Parts"})
	public void PTPDT0045ClickonAddParttoBOMIfPartisInDevelopmentfromWhereUsed() throws IOException, InterruptedException {
		a.equals("InDevelopment");
	}
	@Test(priority = 139,enabled = true,dependsOnMethods={"PTPDT0045ClickonAddParttoBOMIfPartisInDevelopmentfromWhereUsed"},groups = {"Parts"})
	public void PTPDT0046InPartsClickonEditIconintheAddedPartofBOM() throws InterruptedException, IOException{
	//Edit BOM
	clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[2]/div/md-table-container/table/tbody/tr/td[1]/div/button");
	Thread.sleep(3000);
	}
	@Test(priority = 140,enabled = true,dependsOnMethods={"PTPDT0045ClickonAddParttoBOMIfPartisInDevelopmentfromWhereUsed"},groups = {"Parts"})
	public void PTPDT0047InPartsClickonDeleteIconintheAddedPartofBOM() throws InterruptedException, IOException{
	//Delete BOM
	clickByXpath("html/body/div[3]/md-dialog/form/md-dialog-actions/div[2]/button");
	Thread.sleep(3000);
	}
	@Test(priority = 141,enabled = true,dependsOnMethods={"PTPDT0045ClickonAddParttoBOMIfPartisInDevelopmentfromWhereUsed"},groups = {"Parts"})
	public void PTPDT0047InPartsClickonYESButtonfromtheConfirmationMessageintheAddedPartofBOM() throws InterruptedException, IOException{
	//Confirmation
	clickByXpath("html/body/div[3]/md-dialog/md-dialog-actions/button[2]");
	Thread.sleep(3000);
	}
	@Test(priority = 142,enabled = true,dependsOnMethods={"PTPDT0045ClickonAddParttoBOMIfPartisInDevelopmentfromWhereUsed"},groups = {"Parts"})
	public void PTPDT0047InPartsVerifytheStatusforDeletethePartfromfBOM() throws InterruptedException, IOException{
	verifystatus("/html/body/md-toast/div[@class='md-toast-content']");
	}
	//Add the Deleted part in BOM
	@Test(priority = 143,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0048InPartsClickonAddBillofmaterialButtoninBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[1]/div/button[2]");
		Thread.sleep(15000);
	}
	@Test(priority = 144,enabled = true,dataProvider = "Parts Del PartNumber In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0048InPartsEnterPartNumberinAddBOM(String PartNumber) throws IOException, InterruptedException{
		sendpartvaluebyxpathanddownclick("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[1]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartNumber);
		Thread.sleep(3000);
	}
	@Test(priority = 145,enabled = true,dataProvider = "Parts Del Location In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0048InPartsEnterLocationinAddBOM(String Location) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[2]/input", Location);
		Thread.sleep(3000);
	}
	@Test(priority = 146,enabled = true,dataProvider = "Parts Del Ref In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0048InPartsEnterRefinAddBOM(String Ref) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[3]/md-chips/md-chips-wrap/div/div/input", Ref);
		Thread.sleep(3000);
	}
	@Test(priority = 147,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0048InPartsScrolldowninAddBOM() throws IOException, InterruptedException{
		scroll("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input");
	}
	@Test(priority = 148,enabled = true,dataProvider = "Parts Del Quantity In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0048InPartsEnterQuantityinAddBOM(String Quantity) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[4]/input", Quantity);
		Thread.sleep(3000);
	}
	@Test(priority = 149,enabled = true,dataProvider = "Parts Del BOMNotes In BillofMaterial",dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0048InPartsEnterBOMNotesinAddBOM(String BOMNotes) throws IOException, InterruptedException{
		sendwoutclvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input", BOMNotes);
		Thread.sleep(3000);
	}
	@Test(priority = 150,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0048InPartsClickAddParttoBOMButtoninAddBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[5]/md-dialog/form/md-dialog-actions/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 151,enabled = true,dependsOnMethods={"PTPDT0037ClickonAddParttoBOMIfPartisInDevelopment"},groups = {"Parts"})
	public void PTPDT0048InPartsStatusofAddParttoBOM() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(10000);
	}
	@Test(priority = 152, enabled = true,groups = {"Parts"})
	public void PTPDT0049ClickonPartsfromLeftTreetoSearch()throws IOException, InterruptedException{
	  //Click on Parts from the Left tree
	  clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[2]/div/a");
	  Thread.sleep(3000);
	}
	@Test(priority = 153,dataProvider = "Parts Search", enabled = true,groups = {"Parts"})
	public void PTPDT0050EntertheDeletedPartDetailstoSearch(String Search)throws IOException, InterruptedException{
	  //Enter value to search
	  sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div[2]/div[1]/input", Search);
	  Thread.sleep(3000);
	}
	@Test(priority = 154, enabled = true,groups = {"Parts"})
	public void PTPDT0050TapOnEntertoSearchParts()throws IOException, InterruptedException{
	  enter();
	  Thread.sleep(2000);
	}
	@Test(priority = 155, enabled = true,groups = {"Parts"})
	public void PTPDT0050FindtheDeletedPartfromtheSearch()throws IOException, InterruptedException{
	  Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/a");
	}
	@Test(priority = 156, enabled = true,dependsOnMethods={"PTPDT0050FindtheDeletedPartfromtheSearch"},groups = {"Parts"})
	public void PTPDT0050ClickonPartfromtheSearch()throws IOException, InterruptedException{
	  clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/a");
	}
	@Test(priority = 157,enabled = true,groups = {"Parts"})
	public void PTPDT0050SearchBillofmaterialtapinPart() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 158,enabled = true,dependsOnMethods={"PTPDT0050SearchBillofmaterialtapinPart"},groups = {"Parts"})
	public void PTPDT0050ClickonBillofmaterialtapinPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 159,enabled = true,dependsOnMethods={"PTPDT0050SearchBillofmaterialtapinPart"},groups = {"Parts"})
	public void PTPDT0050ClickonPartintheBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[2]/div/table/tbody/tr/td[3]/a");
		Thread.sleep(5000);
	}
	@Test(priority = 160,enabled = true,dependsOnMethods={"PTPDT0050SearchBillofmaterialtapinPart"},groups = {"Parts"})
	public void PTPDT0051ClickonWhereUsedTapinthePartView() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[6]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 161,enabled = true,groups = {"Parts"})
	public void PTPDT0052ClickonPartsfromLeftTree()throws IOException, InterruptedException {
		//Parts
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[2]/div/a");
		Thread.sleep(3000);
	}
	@Test(priority = 162,dataProvider = "Parts First Filter", enabled = true,groups = {"Parts"})//Ceramic
	public void PTPDT0053EnterthePartDetailstoFilter(String Filter)throws IOException, InterruptedException{
	  //Enter value to Filter
	  sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[1]/div/label/input", Filter);
	  Thread.sleep(3000);
	}
	@Test(priority = 163, enabled = true,groups = {"Parts"})
	public void PTPDT0053TapOnEntertoFilter()throws IOException, InterruptedException{
	  enter();
	  Thread.sleep(2000);
	}
	@Test(priority = 164, enabled = true,groups = {"Parts"})
	public void PTPDT0053FindonPartfromtheFilter()throws IOException, InterruptedException{
	  Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/a");
	}
	@Test(priority = 165,dataProvider = "Parts Second Filter", enabled = true,groups = {"Parts"})//Assembly
	public void PTPDT0054EnterthePartDetailstoFilter(String Filter)throws IOException, InterruptedException{
	  //Enter value to Filter
	  sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[1]/div/label/input", Filter);
	  Thread.sleep(3000);
	}
	@Test(priority = 166, enabled = true,groups = {"Parts"})
	public void PTPDT0054TapOnEntertoFilter()throws IOException, InterruptedException{
	  enter();
	  Thread.sleep(2000);
	}
	@Test(priority = 167, enabled = true,groups = {"Parts"})
	public void PTPDT0054FindonPartfromtheFilter()throws IOException, InterruptedException{
	  Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[2]/div[2]/div[2]/table/tbody/tr/td[2]/a");
	}
	@Test(priority = 168,enabled = true,groups = {"Parts"})
	public void PTPDT0055ClickonDownloadButtontoDownloadthePartListFile()throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/div/div[1]/md-menu/button");
		Thread.sleep(3000);
	}
	@Test(priority = 169,enabled = true,groups = {"Parts"})
	public void PTPDT0055ClickonExcelButtontoDownloadthePartListExcelFile()throws IOException, InterruptedException{
		clickByXpath("html/body/div[4]/md-menu-content/md-menu-item[1]/button");
		Thread.sleep(3000);
	}
	@Test(priority = 170,enabled = true,groups = {"Parts"})
	public void PTPDT0055LogoutfromParts()throws IOException, InterruptedException{
	//Logout
			Thread.sleep(3000);
			clickByXpath("html/body/div[1]/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");	
			Thread.sleep(3000);
			clickByXpath("html/body/div[3]/md-menu-content/md-menu-item[4]/button");
			Thread.sleep(3000);
			closeBrowser();
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////Products///////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////////////
	@Test(priority = 171,enabled = true,groups = {"Products"})
	public void PTPDT0056LoginforProducts()throws IOException, InterruptedException{
		String[][] data = getlogin();
		String user = data[0][0];
		String pass = data[0][1];
		browser = data [0][2];
		String role = data [0][3];
		String Url = data [0][4];
		//Launch Browsers
		launchBroswer( browser , Url);
		//Login
		sendvaluebyname("userEmail", user);
		sendvaluebyname("userPassword", pass);
		clickByXpath("//*[@id='login-form']/form/button");
		System.out.println("The " + role + " Login Successfully");
		Thread.sleep(3000);
		//Escape from the Guide menu
		clickByHDEmXpath("/html/body/div[6]/div/div[5]/a[2]");
		Thread.sleep(5000);
		iconClick("html/body/div[1]/div[1]/md-sidenav[1]/md-toolbar/md-icon");
	}
	
	@Test(priority = 172,enabled = true,groups = {"Products"})
	public void PTPDT0056ClickonProductsFromLeftTree()throws IOException, InterruptedException {
		//Products
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[1]/div/a/span");
		Thread.sleep(3000);
	}
	@Test(priority = 173,enabled = true,groups = {"Products"})
	public void PTPDT0057ClickonCreateNewButtoninProducts()throws IOException, InterruptedException {
		//Create Products 
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div[2]/div[2]/button/a");
		Thread.sleep(3000);
	}
	@Test(priority = 174,dataProvider = "Enter Product Name",enabled = true,groups = {"Products"})
	public void PTPDT0058EnterProductName(String ProductName)throws IOException, InterruptedException {
		//Enter the Product Name
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[1]/input", ProductName);
		Thread.sleep(3000);
	}
	@Test(priority = 175,dataProvider = "Enter Product Category Name",enabled = true,groups = {"Products"})
	public void PTPDT0058EnterProductCategoryName(String ProductCategory)throws IOException, InterruptedException {
		//Select the category
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[2]/md-input-container/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input",ProductCategory);
		Thread.sleep(3000);
	}
	@Test(priority = 176,dataProvider = "Enter Product Revision Note",enabled = true,groups = {"Products"})
	public void PTPDT0058EnterProductRevisionNote(String RevisionNote)throws IOException, InterruptedException {
		//Enter the Revision Notes
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[3]/input",RevisionNote);
		Thread.sleep(3000);
	}
	@Test(priority = 177,enabled = true,groups = {"Products"})
	public void PTPDT0058ClickonCreateButtoninProducts()throws IOException, InterruptedException {
		//Click on create Button
		clickByXpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-actions/div/button");
		Thread.sleep(3000);
	}
	@Test(priority =178,enabled = true,groups = {"Products"})
	public void PTPDT0058StatusOfProductCreation()throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div[@class='md-toast-content']");
		Thread.sleep(3000);
	}
	@Test(priority = 179,enabled = true,groups = {"Products"})
	public void PTPDT0059CheckHistoryinBasicInfoofProduct()throws IOException, InterruptedException{
		//Check History section in Basic Info
		createdby("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div[2]/div/div[2]/table/tbody/tr/td/p", "//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div[2]/div/div[2]/table/tbody/tr/td[2]/p");
		Thread.sleep(5000);
	}
	@Test(priority = 180,dataProvider = "Products Enter Description in Basic-Info",enabled = true,groups = {"Products"})
	public void PTPDT0059EnterDescriptioninBasicInfoofProduct(String Des)throws IOException, InterruptedException{
		//Go to Basic Info and Enter Description and Save the Part Details
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div/div/div/form/div/md-input-container/input", Des);
		Thread.sleep(5000);
	}
	@Test(priority = 181,enabled = true,groups = {"Products"})
	public void PTPDT0059SavetheBasicInfoofProduct()throws IOException, InterruptedException{
		//Click on save Button
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/button[@class='md-raised md-button md-default-theme md-ink-ripple']");
		Thread.sleep(5000);
	}
	@Test(priority = 182,enabled = true,groups = {"Products"})
	public void PTPDT0059GetBasicInfoHistoryBeforeUpdationOfProduct()throws IOException, InterruptedException{
		//Get the Basic Info History Before the Updation
		gettext("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div[2]/div/div[2]/table/tbody/tr/td[4]/p");
		Thread.sleep(5000);
	}
	@Test(priority = 183,dataProvider = "Product Enter UnitMeasure in Basic-Info",enabled = true,groups = {"Products"})
	public void PTPDT0059EnterUnitMeasureinBasicInfoofProduct(String Unitmeasure)throws IOException, InterruptedException{
		//Enter the Unit Measure in the Basic-Info 
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div/div/div/form/div[2]/md-input-container/input", Unitmeasure);
		Thread.sleep(5000);
	}
	@Test(priority = 184,dataProvider = "Product Enter Protype in Basic-Info",enabled = true,groups = {"Products"})
	public void PTPDT0059EnterProtypeinBasicInfoofProduct(String Protype)throws IOException, InterruptedException{
		//Enter the Protype in the Basic-Info
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div/div/div/form/div[2]/md-input-container[2]/input", Protype);
		Thread.sleep(5000);
	}
	@Test(priority = 185,dataProvider = "Product Enter Projname in Basic-Info",enabled = true,groups = {"Products"})
	public void PTPDT0060EnterProjnameinBasicInfoofProduct(String Projname)throws IOException, InterruptedException{
		//Enter the ProjName in Basic-Info
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[3]/md-chips[1]/md-chips-wrap/div/div/input", Projname);
		Thread.sleep(5000);
	}
	@Test(priority = 186,dataProvider = "Product Enter Tags in Basic-Info",enabled = true,groups = {"Products"})
	public void PTPDT0061EnterTagsinBasicInfoofProduct(String Tags)throws IOException, InterruptedException{
		//Enter the Tags Name in the Basic-Info
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div[1]/div/div/form/div[3]/md-chips[2]/md-chips-wrap/div/div/input", Tags);
		Thread.sleep(3000);
	}
	@Test(priority = 187,enabled = true,groups = {"Products"})
	public void PTPDT0061SavetheBasicInfofinalyofProduct()throws IOException, InterruptedException{
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/button[@class='md-raised md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 188,enabled = true,groups = {"Products"})
	public void PTPDT0062GetStatusoftheBasicInfoUpdationofProduct()throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 189,enabled = true,groups = {"Products"})
	public void PTPDT0062GetBasicInfoHistoryAfterUpdationofProduct()throws IOException, InterruptedException{
		verifytext("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content/div/md-content/div[2]/div/div[2]/table/tbody/tr/td[4]/p");
		Thread.sleep(5000);
	}
	@Test(priority = 190,enabled = true,groups = {"Products"})
	public void PTPDT0063ClickonAdditionalInfoTabinProduct() throws IOException,InterruptedException{
		//Go to Additional Info
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 191,enabled = true,groups = {"Products"})
	public void PTPDT0063GetProductIdentitytoEnterAdditionalInfo() throws IOException, InterruptedException {			
		gettexttrim("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div/div[1]/div[1]/div[1]/span[3]/strong");
		Thread.sleep(5000);
	}
	@Test(priority = 192,enabled = true,groups = {"Products"},dependsOnMethods = {"PTPDT0063GetProductIdentitytoEnterAdditionalInfo"})
	public void PTPDT0063DoAdditionalInfoIfProductisInDevelopment() throws IOException, InterruptedException {	
		//Enter Additional Info
		a.equals("InDevelopment");
		Thread.sleep(5000);
	}
	@Test(priority = 193,dataProvider = "Product InternalTrackingNumber",enabled = true,dependsOnMethods={"PTPDT0063DoAdditionalInfoIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0063EnterInternalTrackingNumberinAdditionalInfoofProduct(String InternalTrackingNumber) throws IOException,InterruptedException{
		//Enter Internal Tracking Number in Additional Info
		sendvaluebyxpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/md-content/div/div/form/div/md-input-container[3]/input", InternalTrackingNumber);
		Thread.sleep(5000);
	}
	@Test(priority = 194,enabled = true,groups = {"Products"})
	public void PTPDT0064SearchBillofmaterialtapinProduct() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 195,enabled = true,groups = {"Products"})
	public void PTPDT0065ClickonAttachmentsTabinProduct() throws InterruptedException, IOException{
		//Click on Attachments
		clickByXpath("//div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[3]");
	    Thread.sleep(5000);
	}
	@Test(priority = 196,enabled = true,groups = {"Products"})
	public void PTPDT0065GetProductIdentitytoDoAttachments() throws InterruptedException, IOException{
	    gettexttrim("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div/div[1]/div[1]/div[1]/span[3]/strong");
	}
	@Test(priority = 197,enabled = true,groups = {"Products"},dependsOnMethods = {"PTPDT0065GetProductIdentitytoDoAttachments"})
	public void PTPDT0065DoAttachmentsIfProductisInDevelopment() throws InterruptedException, IOException{
		a.equalsIgnoreCase("InDevelopment");
	}
	@Test(priority = 198,enabled = true,dependsOnMethods={"PTPDT0065DoAttachmentsIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0065ClickonUploadButtoninAttachementsofProducts() throws InterruptedException, IOException{
	    clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[3]/div/md-content/div/div/div/div/div/div/div/div[2]/div/md-menu[2]/button");
	    Thread.sleep(3000);
	}
	@Test(priority = 199,enabled = true,dependsOnMethods={"PTPDT0065DoAttachmentsIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0065DoAutoITtoUploadJPGfileinAttachementsofProducts() throws InterruptedException, IOException{
	    Runtime.getRuntime().exec("C:\\Users\\Lakshmanan.S\\workspace\\Fuseplm\\sel-auto-testing\\AutoIT\\AutoIt\\FileUpload.exe");  //Uploading .jpg file using AutoIT
	    Thread.sleep(5000);
	}
	@Test(priority = 200,enabled = true,dependsOnMethods={"PTPDT0065DoAttachmentsIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0065DoAutoITtoUploadPDFfileinAttachementsofProducts() throws InterruptedException, IOException{
	    Runtime.getRuntime().exec("C:\\Users\\Lakshmanan.S\\workspace\\Fuseplm\\sel-auto-testing\\AutoIT\\AutoIt\\FileUpload2.exe"); //Uploading pdf file using AutoIT
	    Thread.sleep(5000);
	}
	@Test(priority = 201,enabled = true,dependsOnMethods={"PTPDT0065DoAttachmentsIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0065ClickSaveButtoninAttachementsofProducts() throws InterruptedException, IOException{
	    //save
	    clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/button[@class='md-raised md-button md-default-theme md-ink-ripple']");
	    Thread.sleep(2000);
	}
	@Test(priority = 202,enabled = true,groups = {"Products"})
	public void PTPDT0066SearchWhereUsedtapinProduct() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[6]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 203,enabled = true,groups = {"Products"})
	public void PTPDT0067ClickOnCommentsTabfromtheProductView() throws IOException, InterruptedException{
		//Click on Comments
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[8]");
		Thread.sleep(3000);
	}
	@Test(priority = 204,dataProvider = "Product First Comments",enabled = true,groups = {"Products"})
	public void PTPDT0067EntertheCommentsintheProduct(String Comments) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[8]/div/md-content/div/div/div/div/div[2]/form/div[1]/md-input-container/div[1]/textarea", Comments);	
	}
	@Test(priority = 205,enabled = true,groups = {"Products"})
	public void PTPDT0067ClickonAddButtontoAddtheCommentsintheProduct() throws IOException, InterruptedException{
	clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[8]/div/md-content/div/div/div/div/div[2]/form/div[2]/button");
	}
	@Test(priority = 206,enabled = true,groups = {"Products"})
	public void PTPDT0067StatusoftheCommentsAddedintheProduct() throws IOException, InterruptedException{
	verifystatus("/html/body/md-toast/div[@class='md-toast-content']");
	}
	@Test(priority = 207,dataProvider = "Product Second Comments",enabled = true,groups = {"Products"})
	public void PTPDT0068AddOneMoreCommentsintheProduct(String Comments) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[8]/div/md-content/div/div/div/div/div[2]/form/div[1]/md-input-container/div[1]/textarea", Comments);	
	}
	@Test(priority = 208,enabled = true,groups = {"Products"})
	public void PTPDT0068ClickonAddButtontoAddtheCommentsintheProduct() throws IOException, InterruptedException{
	clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[8]/div/md-content/div/div/div/div/div[2]/form/div[2]/button");
	}
	@Test(priority = 209,enabled = true,groups = {"Products"})
	public void PTPDT0068StatusoftheCommentsAddedintheProduct() throws IOException, InterruptedException{
	verifystatus("/html/body/md-toast/div[@class='md-toast-content']");
	}
	@Test(priority = 210,enabled = true,groups = {"Products"})
	public void PTPDT0069ClickOnTimelineTabfromProductView() throws InterruptedException,IOException{
		//Click on Time-Line
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[7]");
		Thread.sleep(3000);
	}
	@Test(priority = 211,enabled = true,groups = {"Products"})
	public void PTPDT0070ClickonProductsFromLeftTree()throws IOException, InterruptedException {
		//Products
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[1]/div/a/span");
		Thread.sleep(3000);
	}
	@Test(priority = 212,enabled = true,groups = {"Products"})
	public void PTPDT0071ClickonCreateNewButtoninProducts()throws IOException, InterruptedException {
		//Create Products 
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div[2]/div[2]/button/a");
		Thread.sleep(3000);
	}
	@Test(priority = 213,dataProvider = "Enter Product2 Name",enabled = true,groups = {"Products"})
	public void PTPDT0072EnterProductName(String ProductName)throws IOException, InterruptedException {
		//Enter the Product Name
		sendvaluebyxpath("/html/body/div/div/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[1]/input", ProductName);
		Thread.sleep(3000);
	}
	@Test(priority = 214,dataProvider = "Enter Product2 Category Name",enabled = true,groups = {"Products"})
	public void PTPDT0072EnterProductCategoryName(String ProductCategory)throws IOException, InterruptedException {
		//Select the category
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[2]/md-input-container/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input",ProductCategory);
		Thread.sleep(3000);
	}
	@Test(priority = 215,dataProvider = "Enter Product2 Revision Note",enabled = true,groups = {"Products"})
	public void PTPDT0072EnterProductRevisionNote(String RevisionNote)throws IOException, InterruptedException {
		//Enter the Revision Notes
		sendvaluebyxpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-content/md-input-container[3]/input",RevisionNote);
		Thread.sleep(3000);
	}
	@Test(priority = 216,enabled = true,groups = {"Products"})
	public void PTPDT0072ClickonCreateButtoninProducts()throws IOException, InterruptedException {
		//Click on create Button
		clickByXpath("//div[@id='layout-vertical-navigation']/div/div[2]/md-dialog/form/md-dialog-actions/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 217,enabled = true,groups = {"Products"})
	public void PTPDT0072StatusOfProductCreation()throws IOException, InterruptedException {
		verifystatus("/html/body/md-toast/div[@class='md-toast-content']");
		Thread.sleep(3000);
	}
	@Test(priority = 218,enabled = true,groups = {"Products"})
	public void PTPDT0073ClickonAdditionalInfoTabinProduct() throws IOException,InterruptedException{
		//Go to Additional Info
		clickByXpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[2]");
		Thread.sleep(5000);
	}
	@Test(priority = 219,enabled = true,groups = {"Products"})
	public void PTPDT0073GetProductIdentitytoEnterAdditionalInfo() throws IOException, InterruptedException {			
		gettexttrim("html/body/div[1]/div/div/md-content/div[1]/div/div[1]/div/div[1]/div[1]/div[1]/span[3]/strong");
		Thread.sleep(5000);
	}
	@Test(priority = 220,enabled = true,groups = {"Products"},dependsOnMethods = {"PTPDT0073GetProductIdentitytoEnterAdditionalInfo"})
	public void PTPDT0073DoAdditionalInfoIfProductisInDevelopment() throws IOException, InterruptedException {	
		//Enter Additional Info
		a.equals("InDevelopment");
		Thread.sleep(5000);
	}
	@Test(priority = 221,dataProvider = "Product2 InternalTrackingNumber",enabled = true,dependsOnMethods={"PTPDT0073DoAdditionalInfoIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0074EnterInternalTrackingNumberinAdditionalInfoofProduct(String InternalTrackingNumber) throws IOException,InterruptedException{
		//Enter Internal Tracking Number in Additional Info
		sendvaluebyxpath("/html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[2]/div/md-content/div/div/form/div/md-input-container[3]/input", InternalTrackingNumber);
		Thread.sleep(5000);
	}
	@Test(priority = 222,enabled = true,groups = {"Products"})
	public void PTPDT0075SearchBillofmaterialtapinProduct() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 223,enabled = true,dependsOnMethods={"PTPDT0075SearchBillofmaterialtapinProduct"},groups = {"Products"})
	public void PTPDT0075ClickonBillofmaterialtapinProduct() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 224,enabled = true,dependsOnMethods={"PTPDT0075ClickonBillofmaterialtapinProduct"},groups = {"Products"})
	public void PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment() throws IOException, InterruptedException {
		a.equals("InDevelopment");
	}
	@Test(priority = 225,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0076InProductsClickonAddBillofmaterialButtoninBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[1]/div/button[2]");
		Thread.sleep(15000);
	}
	@Test(priority = 226,enabled = true,dataProvider = "Product PartNumber In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0077InProductsEnterPartNumberinAddBOM(String PartNumber) throws IOException, InterruptedException{ //Add PCB 
		sendpartvaluebyxpathanddownclick("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[1]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartNumber);
		Thread.sleep(3000);
	}
	@Test(priority = 227,enabled = true,dataProvider = "Product Location In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0077InProductsEnterLocationinAddBOM(String Location) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[2]/input", Location);
		Thread.sleep(3000);
	}
	@Test(priority = 228,enabled = true,dataProvider = "Product Ref In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0077InProductsEnterRefinAddBOM(String Ref) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[3]/md-chips/md-chips-wrap/div/div/input", Ref);
		Thread.sleep(3000);
	}
	@Test(priority = 229,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0077InProductsScrolldowninAddBOM() throws IOException, InterruptedException{
		scroll("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input");
	}
	@Test(priority = 230,enabled = true,dataProvider = "Product Quantity In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0077InProductsEnterQuantityinAddBOM(String Quantity) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[4]/input", Quantity);
		Thread.sleep(3000);
	}
	@Test(priority = 231,enabled = true,dataProvider = "Product BOMNotes In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0077InProductsEnterBOMNotesinAddBOM(String BOMNotes) throws IOException, InterruptedException{
		sendwoutclvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input", BOMNotes);
		Thread.sleep(3000);
	}
	@Test(priority = 232,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0077InProductsClickAddParttoBOMButtoninAddBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[5]/md-dialog/form/md-dialog-actions/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 233,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0077InProductsStatusofAddParttoBOM() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(10000);
	}
	//Add Existing Part into the BOM
	@Test(priority = 234,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0078InProductsClickonAddBillofmaterialButtoninBOMforAddExistingPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[1]/div/button[2]");
		Thread.sleep(15000);
	}
	@Test(priority = 235,enabled = true,dataProvider = "Product Add Existing PartNumber In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0078InProductsEnterexistingPartNumberinAddBOM(String PartNumber) throws IOException, InterruptedException{
		sendpartvaluebyxpathanddownclick("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[1]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartNumber);			
		Thread.sleep(3000);
	}	
	@Test(priority = 236,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0078InProductsClickAddParttoBOMButtoninAddBOMforAddExistingPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[5]/md-dialog/form/md-dialog-actions/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 237,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0078InProductsClickonCloseButtoninAddBillofmaterialPopupMenu() throws IOException, InterruptedException{
		clickByXpath("html/body/div[5]/md-dialog/form/md-toolbar/div[1]/button");
	}
	@Test(priority = 238,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0078InProductsClickonCloseButtoninAddBillofmaterialStatus() throws IOException, InterruptedException{
		clickByXpath("html/body/md-toast/div/button");
		Thread.sleep(10000);
	}
	@Test(priority = 239,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0079InProductsClickonAddBillofmaterialButtontoAddanotherPartinBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[1]/div/button[2]");
		Thread.sleep(15000);
	}
	@Test(priority = 240,enabled = true,dataProvider = "Product Another PartNumber In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0079InProductsEnterAnotherPartNumberinAddBOM(String PartNumber) throws IOException, InterruptedException{
		sendpartvaluebyxpathanddownclick("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[1]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartNumber);
		Thread.sleep(3000);
	}
	@Test(priority = 241,enabled = true,dataProvider = "Product Another Location In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0079InProductsEnterAnotherLocationinAddBOM(String Location) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[2]/input", Location);
		Thread.sleep(3000);
	}
	@Test(priority = 242,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0079InProductsScrolldowninAddBOMforaddAnotherBOM() throws IOException, InterruptedException{
		scroll("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input");
	}
	@Test(priority = 243,enabled = true,dataProvider = "Product Another Quantity In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0079InProductsEnterAnotherQuantityinAddBOM(String Quantity) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[4]/input", Quantity);
		Thread.sleep(3000);
	}
	@Test(priority = 244,enabled = true,dataProvider = "Product Another BOMNotes In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0079InProductsEnterAnotherBOMNotesinAddBOM(String BOMNotes) throws IOException, InterruptedException{
		sendwoutclvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input", BOMNotes);
		Thread.sleep(3000);
	}
	@Test(priority = 245,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0079InProductsClickAddParttoBOMButtoninAddBOMforAddAnotherPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[5]/md-dialog/form/md-dialog-actions/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 246,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0079ProductStatusofAddAnotherParttoBOM() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(10000);
	}
	@Test(priority = 247,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0080SearchtheIntentedViewforPartinBOM() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[2]/div/table/tbody/tr/td[3]/a");
		Thread.sleep(5000);
	}
	@Test(priority = 248,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0081ClickonAddedPartintheBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[2]/div/table/tbody/tr/td[3]/a");
		Thread.sleep(5000);
	}
	@Test(priority = 249,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0082ClickonWhereUsedTapfromtheBOMPartView() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[6]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 250,enabled = true,groups = {"Products"})
	public void PTPDT0083ClickOnProductinWhereused() throws InterruptedException,IOException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[6]/div/md-content/div/div/div[2]/div/table/tbody/tr/td[2]/a");
		Thread.sleep(10000);
	}
	@Test(priority = 251,enabled = true,groups = {"Products"})
	public void PTPDT0083SearchBillofmaterialtapinProductfromWherUsed() throws IOException, InterruptedException{
		Searchelement("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 252,enabled = true,dependsOnMethods={"PTPDT0083SearchBillofmaterialtapinProductfromWherUsed"},groups = {"Products"})
	public void PTPDT0083ClickonBillofmaterialtapinProductfromWhereUsed() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[5]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 253,enabled = true,dependsOnMethods={"PTPDT0083ClickonBillofmaterialtapinProductfromWhereUsed"},groups = {"Products"})
	public void PTPDT0084ClickonWhereUsedTapoftheProduct() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-wrapper/md-tabs-canvas/md-pagination-wrapper/md-tab-item[6]/span");
		Thread.sleep(5000);
	}
	@Test(priority = 254,enabled = true,groups = {"Products"})
	public void PTPDT0085ClickOnProductinWhereused() throws InterruptedException,IOException{//iphone Product
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[6]/div/md-content/div/div/div[2]/div/table/tbody/tr/td[2]/a");
		Thread.sleep(10000);
	}
	@Test(priority = 255,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0086InProductsClickonAddBillofmaterialButtontoAddanotherPartinBOM() throws IOException, InterruptedException{
		clickByXpath("html/body/div[1]/div/div/md-content/div[1]/div/div[2]/md-tabs/md-tabs-content-wrapper/md-tab-content[5]/div/md-content/div/md-tabs/md-tabs-content-wrapper/md-tab-content[1]/div/md-content/div/div/div/div[1]/div/button[2]");
		Thread.sleep(15000);
	}
	@Test(priority = 256,enabled = true,dataProvider = "Product Another1 PartNumber In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0086InProductsEnterAnotherPartNumberinAddBOM(String PartNumber) throws IOException, InterruptedException{
		sendpartvaluebyxpathanddownclick("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[1]/md-chips/md-chips-wrap/div/div/md-autocomplete/md-autocomplete-wrap/input", PartNumber);
		Thread.sleep(3000);
	}
	@Test(priority = 257,enabled = true,dataProvider = "Product Another1 Location In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0086InProductsEnterAnotherLocationinAddBOM(String Location) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[2]/input", Location);
		Thread.sleep(3000);
	}
	@Test(priority = 258,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0086InProductsScrolldowninAddBOMforaddAnotherBOM() throws IOException, InterruptedException{
		scroll("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input");
	}
	@Test(priority = 259,enabled = true,dataProvider = "Product Another1 Quantity In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0086InProductsEnterAnotherQuantityinAddBOM(String Quantity) throws IOException, InterruptedException{
		sendvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[4]/input", Quantity);
		Thread.sleep(3000);
	}
	@Test(priority = 260,enabled = true,dataProvider = "Product Another1 BOMNotes In BillofMaterial",dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0086InProductsEnterAnotherBOMNotesinAddBOM(String BOMNotes) throws IOException, InterruptedException{
		sendwoutclvaluebyxpath("html/body/div[5]/md-dialog/form/md-dialog-content/md-input-container[5]/input", BOMNotes);
		Thread.sleep(3000);
	}
	@Test(priority = 261,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0086InProductsClickAddParttoBOMButtoninAddBOMforAddAnotherPart() throws IOException, InterruptedException{
		clickByXpath("html/body/div[5]/md-dialog/form/md-dialog-actions/div[1]/button");
		Thread.sleep(5000);
	}
	@Test(priority = 262,enabled = true,dependsOnMethods={"PTPDT0076ClickonAddParttoBOMIfProductisInDevelopment"},groups = {"Products"})
	public void PTPDT0086ProductStatusofAddAnotherParttoBOM() throws IOException, InterruptedException{
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(10000);
	}
	@Test(priority = 263,enabled = true,groups = {"Products"})
	public void PTPDT0087ProductIncrementalRevisionCheck() throws IOException, InterruptedException{
		//Click on Incremental Revision Button
		clickByXpath("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/button[@class='white-fg md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 264,enabled = true,groups = {"Products"})
	public void PTPDT0087ClickYESonConfirmationMessageinProductIncrementalRevisionCheck() throws IOException, InterruptedException{
		//Click Yes on the Confirmation message
		clickByXpath("html/body/div[4]/md-dialog/md-dialog-actions/button[2]");
		Thread.sleep(3000);
	}
	@Test(priority = 265,dataProvider = "Product Incremental Revision",enabled = true,groups = {"Products"})
	public void PTPDT0087EntertheRevisionNotesinProductIncrementalRevisionCheck(String ProductNote) throws IOException, InterruptedException{
		//Enter the Revision Notes
		sendvaluebyxpath("//div[@id='content-container']/div[2]/md-dialog/form/md-dialog-content/md-input-container/input", ProductNote);
	}
	@Test(priority = 266,enabled = true,groups = {"Products"})
	public void PTPDT0087ClickonCreateButtonforProductIncrementalRevisionCheck() throws IOException, InterruptedException{
		//Click on Create Button
		clickByXpath("//div[@id='content-container']/div[2]/md-dialog/form/md-dialog-actions/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 267,enabled = true,groups = {"Products"})
	public void PTPDT0087StatusofProductIncrementalRevisionCheck()throws IOException, InterruptedException {
		//Verify the status
		verifystatus("/html/body/md-toast/div/span");
		Thread.sleep(3000);
	}
	@Test(priority = 268,enabled = true,groups = {"Products"})
	public void PTPDT0087ClosetheProductInrementalRevisionPopup()throws IOException, InterruptedException {
		//Close the Incremental Revision Popup
		clickByXpath("/html/body/div[1]/div/div/div[2]/md-dialog/form/md-toolbar/div/button");
		Thread.sleep(3000);
	}
	@Test(priority = 269,enabled = true,groups = {"Products"})
	public void PTPDT0087ClosetheStatusofProductIncrementalRevisionCheck()throws IOException, InterruptedException {
		//Close the Text Box
		clickByXpath("html/body/md-toast/div/button");
		Thread.sleep(5000);
	}
	@Test(priority = 270,enabled = true,groups = {"Products"})
	public void PTPDT0088SearchChangeStatusinProduct() throws IOException,InterruptedException{
		//Click on Change Status
		Searchelement("//div[@id='layout-vertical-navigation']/div/md-content/div/div/div/div/div[2]/md-menu/button[@class='white-fg md-button md-default-theme md-ink-ripple']");
		Thread.sleep(3000);
	}
	@Test(priority = 271,enabled = true,groups = {"Products"})
	public void PTPDT0089ClickonProductsFromLeftTree()throws IOException, InterruptedException {
		//Products
		clickByXpath("//div[@id='layout-vertical-navigation']/md-sidenav/ms-navigation[3]/ul/li/ul/li[1]/div/a/span");
		Thread.sleep(3000);
	}
	///////////////Data Provider/////////////////////////////////////////
	@DataProvider(name = "Enter Part Name")
	public Object[][] parameterCredentials() throws IOException {

		Object[][] data = PartName();

		return data;
	}
	@DataProvider(name = "Enter Part Category Name")
	public Object[][] parameterCredentials1() throws IOException {

		Object[][] data = PartCategoryName();

		return data;
	}
	@DataProvider(name = "Enter Part Revision Note")
	public Object[][] parameterCredentials2() throws IOException {

		Object[][] data = PartRevisionNote();

		return data;
	}
	@DataProvider(name = "Part Incremental Revision")
	public Object[][] parameterCredentials3() throws IOException {

		Object[][] data = PartIncrementalRevision();

		return data;
	}
	@DataProvider(name = "Part-Enter Description in Basic-Info")
	public Object[][] parameterCredentials4() throws IOException {

		Object[][] data = PartDescriptioninBasicInfo();

		return data;
	}	
	@DataProvider(name = "Part-Enter UnitMeasure in Basic-Info")
	public Object[][] parameterCredentials5() throws IOException {

		Object[][] data = PartUnitMeasureinBasicInfo();

		return data;
	}
	@DataProvider(name = "Part-Enter Protype in Basic-Info")
	public Object[][] parameterCredentials6() throws IOException {

		Object[][] data = PartProtypeinBasicInfo();

		return data;
	}
	@DataProvider(name = "Part-Enter Projname in Basic-Info")
	public Object[][] parameterCredentials7() throws IOException {

		Object[][] data = PartProjnameinBasicInfo();

		return data;
	}
	@DataProvider(name = "Part-Enter Tags in Basic-Info")
	public Object[][] parameterCredentials8() throws IOException {

		Object[][] data = PartTagsinBasicInfo();

		return data;
	}
	@DataProvider(name = "Part InternalTrackingNumber")
	public Object[][] parameterCredentials9() throws IOException {

		Object[][] data = PartInternalTrackingNumberinAttachments();

		return data;
	}	
	@DataProvider(name = "Parts First Comments")
	public Object[][] parameterCredentials10() throws IOException {

		Object[][] data = PartsFirstComments();

		return data;
	}
	@DataProvider(name = "Parts Second Comments")
	public Object[][] parameterCredentials11() throws IOException {

		Object[][] data = PartsSecondComments();

		return data;
	}
	@DataProvider(name = "Part ManufacturerName In Sourcing")
	public Object[][] parameterCredentials12() throws IOException {

		Object[][] data = PartManufacturerNameInSourcing();

		return data;
	}
	@DataProvider(name = "Part ManufacturerPartNumber In Sourcing")
	public Object[][] parameterCredentials13() throws IOException {

		Object[][] data = PartManufacturerPartNumberInSourcing();

		return data;
	}
	@DataProvider(name = "Part ManufacturerDescription In Sourcing")
	public Object[][] parameterCredentials14() throws IOException {

		Object[][] data = PartManufacturerDescriptionInSourcing();

		return data;
	}
	@DataProvider(name = "Part ManufacturerCost In Sourcing")
	public Object[][] parameterCredentials15() throws IOException {

		Object[][] data = PartManufacturerCostInSourcing();

		return data;
	}
	@DataProvider(name = "Part ManufacturerCurrency In Sourcing")
	public Object[][] parameterCredentials16() throws IOException {

		Object[][] data = PartManufacturerCurrencyInSourcing();

		return data;
	}
	@DataProvider(name = "Part ManufacturerApproved In Sourcing")
	public Object[][] parameterCredentials17() throws IOException {

		Object[][] data = PartManufacturerApprovedInSourcing();

		return data;
	}
	@DataProvider(name = "Part ManufacturerAvailable In Sourcing")
	public Object[][] parameterCredentials18() throws IOException {

		Object[][] data = PartManufacturerAvailableInSourcing();

		return data;
	}	
	@DataProvider(name = "Part SupplierName In Sourcing")
	public Object[][] parameterCredentials19() throws IOException {

		Object[][] data = PartSupplierNameInSourcing();

		return data;
	}	
	@DataProvider(name = "Part SupplierPartNumber In Sourcing")
	public Object[][] parameterCredentials20() throws IOException {

		Object[][] data = PartSupplierPartNumberInSourcing();

		return data;
	}		
	@DataProvider(name = "Part ManufacturerNameSupp In Sourcing")
	public Object[][] parameterCredentials21() throws IOException {

		Object[][] data = PartManufacturerNameSuppInSourcing();

		return data;
	}	
	@DataProvider(name = "Part ManufacturerPartNumberSupp In Sourcing")
	public Object[][] parameterCredentials22() throws IOException {

		Object[][] data = PartManufacturerPartNumberSuppInSourcing();

		return data;
	}
	@DataProvider(name = "Part SupplierDescription In Sourcing")
	public Object[][] parameterCredentials23() throws IOException {

		Object[][] data = PartSupplierDescriptionInSourcing();

		return data;
	}
	@DataProvider(name = "Part SupplierCost In Sourcing")
	public Object[][] parameterCredentials24() throws IOException {

		Object[][] data = PartSupplierCostInSourcing();

		return data;
	}	
	@DataProvider(name = "Part SupplierCurrency In Sourcing")
	public Object[][] parameterCredentials25() throws IOException {

		Object[][] data = PartSupplierCurrencyInSourcing();

		return data;
	}
	@DataProvider(name = "Part SupplierApproved In Sourcing")
	public Object[][] parameterCredentials26() throws IOException {

		Object[][] data = PartSupplierApprovedInSourcing();

		return data;
	}
	@DataProvider(name = "Part SupplierAvailable In Sourcing")
	public Object[][] parameterCredentials27() throws IOException {

		Object[][] data = PartSupplierAvailableInSourcing();

		return data;
	}	
	@DataProvider(name = "Enter Part2 Name")
	public Object[][] parameterCredentials28() throws IOException {

		Object[][] data = EnterPart2Name();

		return data;
	}	
	@DataProvider(name = "Enter Part2 Category Name")
	public Object[][] parameterCredentials29() throws IOException {

		Object[][] data = EnterPart2CategoryName();

		return data;
	}
	@DataProvider(name = "Enter Part2 Revision Note")
	public Object[][] parameterCredentials30() throws IOException {

		Object[][] data = EnterPart2RevisionNote();

		return data;
	} 	
	@DataProvider(name = "Part2 InternalTrackingNumber")
	public Object[][] parameterCredentials31() throws IOException {

		Object[][] data = Part2InternalTrackingNumber();

		return data;
	}
	@DataProvider(name = "Enter Part3 Name")
	public Object[][] parameterCredentials32() throws IOException {

		Object[][] data = EnterPart3Name();

		return data;
	}
	@DataProvider(name = "Enter Part3 Category Name")
	public Object[][] parameterCredentials33() throws IOException {

		Object[][] data = EnterPart3CategoryName();

		return data;
	}	
	@DataProvider(name = "Enter Part3 Revision Note")
	public Object[][] parameterCredentials34() throws IOException {

		Object[][] data = EnterPart3RevisionNote();

		return data;
	}	
	@DataProvider(name = "Enter Part4 Name")
	public Object[][] parameterCredentials35() throws IOException {

		Object[][] data = EnterPart4Name();

		return data;
	}
	@DataProvider(name = "Enter Part4 Category Name")
	public Object[][] parameterCredentials36() throws IOException {

		Object[][] data = EnterPart4CategoryName();

		return data;
	}
	@DataProvider(name = "Enter Part4 Revision Note")
	public Object[][] parameterCredentials37() throws IOException {

		Object[][] data = EnterPart4RevisionNote();

		return data;
	}
	@DataProvider(name = "Parts PartNumber In BillofMaterial")
	public Object[][] parameterCredentials38() throws IOException {

		Object[][] data = PartsPartNumberInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Location In BillofMaterial")
	public Object[][] parameterCredentials39() throws IOException {

		Object[][] data = PartsLocationInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Ref In BillofMaterial")
	public Object[][] parameterCredentials40() throws IOException {

		Object[][] data = PartsRefInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Quantity In BillofMaterial")
	public Object[][] parameterCredentials41() throws IOException {

		Object[][] data = PartsQuantityInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Change Quantity In BillofMaterial")
	public Object[][] parameterCredentials42() throws IOException {

		Object[][] data = PartsChangeQuantityInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts BOMNotes In BillofMaterial")
	public Object[][] parameterCredentials43() throws IOException {

		Object[][] data = PartsBOMNotesInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Add Existing PartNumber In BillofMaterial")
	public Object[][] parameterCredentials44() throws IOException {

		Object[][] data = PartsAddExistingPartNumberInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Another PartNumber In BillofMaterial")
	public Object[][] parameterCredentials45() throws IOException {

		Object[][] data = PartsAnotherPartNumberInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Another Location In BillofMaterial")
	public Object[][] parameterCredentials46() throws IOException {

		Object[][] data = PartsAnotherLocationInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Another Quantity In BillofMaterial")
	public Object[][] parameterCredentials47() throws IOException {

		Object[][] data = PartsAnotherQuantityInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Another BOMNotes In BillofMaterial")
	public Object[][] parameterCredentials48() throws IOException {

		Object[][] data = PartsAnotherBOMNotesInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Del PartNumber In BillofMaterial")
	public Object[][] parameterCredentials49() throws IOException {

		Object[][] data = PartsDelPartNumberInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Del Location In BillofMaterial")
	public Object[][] parameterCredentials50() throws IOException {

		Object[][] data = PartsDelLocationInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Del Ref In BillofMaterial")
	public Object[][] parameterCredentials51() throws IOException {

		Object[][] data = PartsDelRefInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Del Quantity In BillofMaterial")
	public Object[][] parameterCredentials52() throws IOException {

		Object[][] data = PartsDelQuantityInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Del BOMNotes In BillofMaterial")
	public Object[][] parameterCredentials53() throws IOException {

		Object[][] data = PartsDelBOMNotesInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Parts Search")
	public Object[][] parameterCredentials54() throws IOException {

		Object[][] data = PartsSearch();

		return data;
	}
	@DataProvider(name = "Parts First Filter")
	public Object[][] parameterCredentials55() throws IOException {

		Object[][] data = PartsFirstFilter();

		return data;
	}
	@DataProvider(name = "Parts Second Filter")
	public Object[][] parameterCredentials56() throws IOException {

		Object[][] data = PartsSecondFilter();

		return data;
	}
	
	
	///////////////////////////////////////////////////
	//////////////Products/////////////////////////////
	///////////////////////////////////////////////////
	
	@DataProvider(name = "Enter Product Name")
	public Object[][] productCredentials() throws IOException {

		Object[][] data = ProductName();

		return data;
	}
	@DataProvider(name = "Enter Product Category Name")
	public Object[][] productCredentials1() throws IOException {

		Object[][] data = ProductCategoryName();

		return data;
	}
	@DataProvider(name = "Enter Product Revision Note")
	public Object[][] productCredentials2() throws IOException {

		Object[][] data = ProductRevisionNote();

		return data;
	}
	@DataProvider(name = "Products Enter Description in Basic-Info")
	public Object[][] productCredentials3() throws IOException {

		Object[][] data = ProductsDescriptionInBasicInfo();

		return data;
	}
	@DataProvider(name = "Product Enter UnitMeasure in Basic-Info")
	public Object[][] productCredentials4() throws IOException {

		Object[][] data = ProductUnitMeasureInBasicInfo();

		return data;
	}	
	@DataProvider(name = "Product Enter Protype in Basic-Info")
	public Object[][] productCredentials5() throws IOException {

		Object[][] data = ProductProtypeInBasicInfo();

		return data;
	}
	@DataProvider(name = "Product Enter Projname in Basic-Info")
	public Object[][] productCredentials6() throws IOException {

		Object[][] data = ProductProjnameInBasicInfo();

		return data;
	}
	@DataProvider(name = "Product Enter Tags in Basic-Info")
	public Object[][] productCredentials7() throws IOException {

		Object[][] data = ProductTagsInBasicInfo();

		return data;
	}
	@DataProvider(name = "Product InternalTrackingNumber")
	public Object[][] productCredentials8() throws IOException {

		Object[][] data = ProductInternalTrackingNumberinAttachments();

		return data;
	}
	@DataProvider(name = "Product First Comments")
	public Object[][] productCredentials9() throws IOException {

		Object[][] data = ProductFirstComments();

		return data;
	}	
	@DataProvider(name = "Product Second Comments")
	public Object[][] productCredentials10() throws IOException {

		Object[][] data = ProductSecondComments();

		return data;
	}
	@DataProvider(name = "Enter Product2 Name")
	public Object[][] productCredentials11() throws IOException {

		Object[][] data = EnterProduct2Name();

		return data;
	}
	@DataProvider(name = "Enter Product2 Category Name")
	public Object[][] productCredentials12() throws IOException {

		Object[][] data = EnterProduct2CategoryName();

		return data;
	}
	@DataProvider(name = "Enter Product2 Revision Note")
	public Object[][] productCredentials13() throws IOException {

		Object[][] data = EnterProduct2RevisionNote();

		return data;
	}
	@DataProvider(name = "Product2 InternalTrackingNumber")
	public Object[][] productCredentials14() throws IOException {

		Object[][] data = Product2InternalTrackingNumber();

		return data;
	}
	@DataProvider(name = "Product PartNumber In BillofMaterial")
	public Object[][] productCredentials15() throws IOException {

		Object[][] data = ProductPartNumberInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Product Location In BillofMaterial")
	public Object[][] productCredentials16() throws IOException {

		Object[][] data = ProductLocationInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Product Ref In BillofMaterial")
	public Object[][] productCredentials17() throws IOException {

		Object[][] data = ProductRefInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Product Quantity In BillofMaterial")
	public Object[][] productCredentials18() throws IOException {

		Object[][] data = ProductQuantityInBillofMaterial();

		return data;
	}	
	@DataProvider(name = "Product BOMNotes In BillofMaterial")
	public Object[][] productCredentials19() throws IOException {

		Object[][] data = ProductBOMNotesInBillofMaterial();

		return data;
	}	
	@DataProvider(name = "Product Add Existing PartNumber In BillofMaterial")
	public Object[][] productCredentials20() throws IOException {

		Object[][] data = ProductAddExistingPartNumberInBillofMaterial();

		return data;
	}		
	@DataProvider(name = "Product Another PartNumber In BillofMaterial")
	public Object[][] productCredentials21() throws IOException {

		Object[][] data = ProductAnotherPartNumberInBillofMaterial();

		return data;
	}	
	@DataProvider(name = "Product Another Location In BillofMaterial")
	public Object[][] productCredentials22() throws IOException {

		Object[][] data = ProductAnotherLocationInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Product Another Quantity In BillofMaterial")
	public Object[][] productCredentials23() throws IOException {

		Object[][] data = ProductAnotherQuantityInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Product Another BOMNotes In BillofMaterial")
	public Object[][] productCredentials24() throws IOException {

		Object[][] data = ProductAnotherBOMNotesInBillofMaterial();

		return data;
	}	
	@DataProvider(name = "Product Another1 PartNumber In BillofMaterial")
	public Object[][] productCredentials25() throws IOException {

		Object[][] data = ProductAnother1PartNumberInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Product Another1 Location In BillofMaterial")
	public Object[][] productCredentials26() throws IOException {

		Object[][] data = ProductAnother1LocationInBillofMaterial();

		return data;
	}
	@DataProvider(name = "Product Another1 Quantity In BillofMaterial")
	public Object[][] productCredentials27() throws IOException {

		Object[][] data = ProductAnother1QuantityInBillofMaterial();

		return data;
	}	
	@DataProvider(name = "Product Another1 BOMNotes In BillofMaterial")
	public Object[][] productCredentials28() throws IOException {

		Object[][] data = ProductAnother1BOMNotesInBillofMaterial();

		return data;
	}	
	@DataProvider(name = "Product Incremental Revision")
	public Object[][] productCredentials29() throws IOException {

		Object[][] data = ProductIncrementalRevision();

		return data;
	}
		
	@AfterClass()
	public void Logout() throws InterruptedException {
		//Logout
		Thread.sleep(3000);
		clickByXpath("html/body/div[1]/div/div/md-toolbar/div/div[2]/md-menu-bar/md-menu/button");	
		Thread.sleep(3000);
		clickByXpath("html/body/div[3]/md-menu-content/md-menu-item[4]/button");
		Thread.sleep(3000);
		closeBrowser();
	}
}
