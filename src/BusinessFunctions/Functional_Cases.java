package BusinessFunctions;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import GenericFunctions.Functional_Libraries;
import atu.testng.reports.ATUReports;
import atu.testng.reports.utils.Utils;

public class Functional_Cases {

	Functional_Libraries fL = new Functional_Libraries();
	WebDriver driver;
	Properties prop = new Properties();
	InputStream input = null;
	 
	 //Set Property for ATU Reporter Configuration
    {
      System.setProperty("atu.reporter.config", "atu.properties");
    }
	
    
	public void CNetLogin(WebDriver driver) throws AWTException, InterruptedException, IOException
	{
		try{
			
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
			
			////System.out.println(prop.getProperty("BaseUrl"));
			
			fL.Invokeapplication(driver, prop.getProperty("BaseUrl"), prop.getProperty("Browser"), prop.getProperty("BaseUrl"), "Passing URL in to browser", "URL Should be passed in to browser", "URL Launched successfully", "N");
			
			SwitchToMainFrame(driver, prop.getProperty("MainframeID"));
		
			fL.clickByID(driver, prop.getProperty("UserNameID"), prop.getProperty("UserNameID"),"Click on Username", "Username should be clicked", "UserName clicked successfully", "N");
			
			fL.enterValuebyID(driver, prop.getProperty("UserNameID"), "maneeshn", "maneeshn", "Passing value in to username", "Username should be entered", "Username should be passed successfully", "N");
			
			fL.clickByID(driver, prop.getProperty("PasswordID"), prop.getProperty("PasswordID"), "Click on Password", "Password should be clicked", "Password clicked successfully", "N");
			
			fL.enterValuebyID(driver, prop.getProperty("PasswordID"), "Maneeshnama@6468", "Maneeshnama@6468", "Passing value in to Password", "Password should be entered", "Password should be passed successfully", "N");
			
			fL.clickByID(driver, prop.getProperty("LoginButtonID"),prop.getProperty("LoginButtonID"), "Click on Login button", "Login button should be clicked", "Login button clicked succesfully", "N");
			
		 } catch (WebDriverException e) {
			////System.out.println(e.getMessage());
	 		}	
	}
	
	
	public void SwitchToMainFrame(WebDriver driver, String id) throws AWTException, InterruptedException, IOException
	{
		try{
						
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
		
			FluentWait<WebDriver> waitforelement  = new FluentWait<WebDriver>(driver)
				       .withTimeout(60, TimeUnit.SECONDS)
				       .pollingEvery(10, TimeUnit.SECONDS)
				       .ignoring(NoSuchElementException.class);
			waitforelement.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");

		 } catch (WebDriverException e) {
			////System.out.println(e.getMessage());
	 		}	
	}
	
	
	public void AIMSLaunchApplication(WebDriver driver) throws AWTException, InterruptedException, IOException
	{
		try{
			
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
			
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
			
			fL.SwitchtoWindows(driver, "", "", "", "");
			
			fL.enterValuebyID(driver, prop.getProperty("FilterID"), "AIMS",prop.getProperty("FilterID"), "Passed AIMS in FilterNavigator", "Find AIMS in search Navigator", "Search Successful", "N");
			
			fL.clickByID(driver, prop.getProperty("LaunchApplicationID"),prop.getProperty("LaunchApplicationID"),"clicked on launch Application", "Launch AIMS Application", "Clicked Successful", "N");
			
		 } catch (WebDriverException e) {
			////System.out.println(e.getMessage());
	 		}	
	}
	
	public void UpdateVirtualMachine_Update(WebDriver driver, String ProjectInformation, String Project, String PrimaryDatacenter, String PrimaryCloudPlatform,  String VcenterHost, String ESXIHOST, String SelectCluster, String	SelectServer, String Serversize, String Storage, String StorageProvier, String StorageName, String AggregateName, String VServer,	String Size, String SizeUnits, String Protocol, String	OpenPort, String Port,  String FromPort, String ToPort, String AllowForm, String IP, String FromIP, String ToIP, String AddMonitering,	String InstallAgentMonitering,	String InstandEnablSNMP, String ChangeDefaultCommString, String	CommunityString ) throws AWTException, InterruptedException, IOException
	{
		try{
			
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
			
			SwitchToMainFrame(driver, prop.getProperty("MainframeID"));
			
			fL.clickByxpath(driver, prop.getProperty("UpdateVM"),prop.getProperty("UpdateVM") ,"Clicked the UpdateVM", "Select UpdateVM from AIMS", "Successfully Selected", "N");

				
				fL.selectDropdownbyID(driver, prop.getProperty("ProjectInformationID"), ProjectInformation, prop.getProperty("ProjectInformationID"), "Type of ServerOperation Field Choosen", "Select Update Field", "ServerOperation field was successfully selected ", "N");
				
				fL.clickByxpath(driver, prop.getProperty("ProjectFiledXpath"),prop.getProperty("ProjectFiledXpath"), "Selected Project lookup field", "Hit the Project LookupField", "Successfully selected", "N");
				
				fL.HandleMultipleWindows(driver, Project, Project, "Choosen the Project", "Choose One Project", "PRJ0010232 Selected", "");
				
				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
				
				fL.clickByxpath(driver, prop.getProperty("PrimaryDataCenterXpath"),prop.getProperty("PrimaryDataCenterXpath"), "Selected PrimaryDataCenter lookup field", "Hit the PrimaryDataCenter LookupField", "PrimaryDataCenterServerOperation field was successfully selected", "N");
				
				fL.HandleMultipleWindows(driver, PrimaryDatacenter, PrimaryDatacenter, "Dallas Was Selected", "Choose one PrimarydataCenter", "Successfully Selected", "N");
				
				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
				
				fL.clickByxpath(driver, prop.getProperty("PrimaryCloudPlatformxpath"),prop.getProperty("PrimaryCloudPlatformxpath"), "Selected PrimaryCloudPlatform lookup field", "Hit the PrimaryCloudPlatform LookupField", "PrimaryCloudPlatform field was successfully selected ", "N");
				
				fL.HandleMultipleWindows(driver, PrimaryCloudPlatform, PrimaryCloudPlatform, "Choosen PrimaryCloud Field", "Choose PrimaryCloud Field", "Successfully Selected", "N");
				
				if(PrimaryCloudPlatform.equalsIgnoreCase("VMWare")){
					
					fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
					
					fL.selectDropdownbyID(driver, prop.getProperty("VcenterHost"), VcenterHost, VcenterHost, "Selected VcenterHost", "Select VcenterHost", "Select Successful", "N");
					
					fL.selectDropdownbyID(driver, prop.getProperty("ESXIHOST"), ESXIHOST, ESXIHOST, "Selected ESXIHOST", "Select ESXIHOST", "Select Successful", "N");
				}
				
				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
				
				fL.clickByxpath(driver, prop.getProperty("SelectCulsterxpath"),prop.getProperty("SelectCulsterxpath"), "Selected cluster field", "click on Cluster Lookup field", "Successfully hit the field", "N");
				
				fL.HandleMultipleWindows(driver, SelectCluster, SelectCluster, "Selected OpenStack-Aims", "Select one Cluster", "Cluster select Successful", "N");
				
				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
				
				fL.clickByxpath(driver, prop.getProperty("SelectServerXpath"),prop.getProperty("SelectServerXpath"), "Selected Server field ", "click on Server Lookup field", "Successfully hit the field", "N");
				
				fL.HandleMultipleWindows(driver, SelectServer, SelectServer, "Selected DEV-LNX-APACHE-63 ", "Select One Server", "Server Select Successful", "N");
				
				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
				
				fL.selectDropdownbyID(driver, prop.getProperty("ServerSize"), Serversize, Serversize, "Selected Service Size", "Select one Size", "Select Successful", "N");
				
				if(Storage.equalsIgnoreCase("Yes")){
				
				fL.selectDropdownbyID(driver, prop.getProperty("AdditionalStorage"), Storage, prop.getProperty("AdditionalStorage"), "Selected Additional Storage", "You need addition storage??", "Yes Selected", "N");
					
				fL.selectDropdownbyID(driver, prop.getProperty("StorageProviderID"), StorageProvier,prop.getProperty("StorageProviderID"), "Selected NetApp Storage provider", "Select Storage Provider", "Select Successfull", "N");
				
				fL.enterValuebyID(driver, prop.getProperty("StorageNameID"), StorageName, prop.getProperty("StorageNameID"), "Provided Storage Name", "Provide Storge name", "Successful", "N");
				
				fL.enterValuebyID(driver, prop.getProperty("AggregateNameID"), AggregateName, prop.getProperty("AggregateNameID"), "Provided AggregateName", "Provide Aggregate name", "Successful", "N");
				
				fL.enterValuebyID(driver, prop.getProperty("VserverID"), VServer, prop.getProperty("VserverID"), "Provided VServerId", "Provide VServerId", "Successful", "N");
				
				fL.enterValuebyID(driver, prop.getProperty("SizeID"), Size, prop.getProperty("SizeID"), "Entered 30" , "prvoide Size", "Successful", "N");
				
				fL.selectDropdownbyID(driver, prop.getProperty("SizeUnitID"), SizeUnits, prop.getProperty("SizeUnitID"), "Selected SizeUnit", "Select SizeUnit", "Successful", "N");
				
				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
				
				//fL.selectDropdownbyID(driver, prop.getProperty("ProtocolID"), "Custom",prop.getProperty("ProtocolID"), "Selected Additional Storage", "You need addition storage??", "Yes Selected", "N");

				FirewalPortRules(driver, Protocol, OpenPort, Port, AllowForm, IP, FromPort, ToPort, FromIP, ToIP);
				
				MonitoringInformation(driver, AddMonitering, InstallAgentMonitering,InstandEnablSNMP,ChangeDefaultCommString, CommunityString);
				
				//fL.clickByID(driver, prop.getProperty("OrderNow"),prop.getProperty("OrderNow") ,"Clicked OrderNow", "Place Your order", "Successful", "N");
					
				} else {
					
					fL.selectDropdownbyID(driver, prop.getProperty("AdditionalStorage"), "No", "No", "Value need to be Selected from the dropdown", "No value shouldbe selected", "No value isselected", "N");
					
					fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
					
					FirewalPortRules(driver, Protocol, OpenPort, Port, AllowForm, IP, FromPort, ToPort, FromIP, ToIP);
					
					MonitoringInformation(driver, AddMonitering, InstallAgentMonitering,InstandEnablSNMP,ChangeDefaultCommString, CommunityString);
					
				//	fL.clickByID(driver, prop.getProperty("OrderNow"),prop.getProperty("OrderNow") ,"Clicked OrderNow", "Place Your order", "Successful", "N");
				}
							
				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
				
				fL.clickByID(driver, prop.getProperty("OrderNow"),prop.getProperty("OrderNow") ,"Clicked OrderNow", "Place Your order", "Successful", "N");
	
								
		 } catch (WebDriverException e) {
			////System.out.println(e.getMessage());
	 	}	
	}
	
	public void UpdateVirtualMachine_Delete(WebDriver driver, String ProjectInformation, String Project,
			String PrimaryDatacenter, String PrimaryCloudPlatform, String TypeofDecommission, String VcenterHost,
			String ESXIHOST, String SelectCluster, String SelectServer)
			throws AWTException, InterruptedException, IOException {
		try {

			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);

			SwitchToMainFrame(driver, prop.getProperty("MainframeID"));

			fL.clickByxpath(driver, prop.getProperty("UpdateVM"), prop.getProperty("UpdateVM"), "Clicked the UpdateVM",
					"Select UpdateVM from AIMS", "Successfully Selected", "N");

			fL.selectDropdownbyID(driver, prop.getProperty("ProjectInformationID"), ProjectInformation,
					prop.getProperty("ProjectInformationID"), "Type of ServerOperation Field Choosen",
					"Select Update Field", "ServerOperation field was successfully selected ", "N");

			fL.clickByxpath(driver, prop.getProperty("ProjectFiledXpath"), prop.getProperty("ProjectFiledXpath"),
					"Selected Project lookup field", "Hit the Project LookupField", "Successfully selected", "N");

			fL.HandleMultipleWindows(driver, Project, Project, "Choosen the Project", "Choose One Project",
					"PRJ0010232 Selected", "");

			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"),
					"Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");

			fL.clickByxpath(driver, prop.getProperty("PrimaryDataCenterXpath"),
					prop.getProperty("PrimaryDataCenterXpath"), "Selected PrimaryDataCenter lookup field",
					"Hit the PrimaryDataCenter LookupField",
					"PrimaryDataCenterServerOperation field was successfully selected", "N");

			fL.HandleMultipleWindows(driver, PrimaryDatacenter, PrimaryDatacenter, "Dallas Was Selected",
					"Choose one PrimarydataCenter", "Successfully Selected", "N");

			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"),
					"Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");

			fL.clickByxpath(driver, prop.getProperty("PrimaryCloudPlatformxpath"),
					prop.getProperty("PrimaryCloudPlatformxpath"), "Selected PrimaryCloudPlatform lookup field",
					"Hit the PrimaryCloudPlatform LookupField", "PrimaryCloudPlatform field was successfully selected ",
					"N");

			fL.HandleMultipleWindows(driver, PrimaryCloudPlatform, PrimaryCloudPlatform, "Choosen PrimaryCloud Field",
					"Choose PrimaryCloud Field", "Successfully Selected", "N");

			if (PrimaryCloudPlatform.equalsIgnoreCase("VMWare")) {

				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"),
						"Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");

				fL.selectDropdownbyID(driver, prop.getProperty("VcenterHost"), VcenterHost, VcenterHost,
						"Selected VcenterHost", "Select VcenterHost", "Select Successful", "N");

				fL.selectDropdownbyID(driver, prop.getProperty("ESXIHOST"), ESXIHOST, ESXIHOST, "Selected ESXIHOST",
						"Select ESXIHOST", "Select Successful", "N");

			}

			if (TypeofDecommission.equalsIgnoreCase("Cluster")) {

				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"),
						"Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");

				fL.selectDropdownbyID(driver, prop.getProperty("TypeofDecommission"), TypeofDecommission,
						TypeofDecommission, "Selected VcenterHost", "Select VcenterHost", "Select Successful", "N");

				fL.clickByID(driver, prop.getProperty("SelectClusterid"), "", "", "", "", "");

				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"),
						"Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");

				fL.clickByxpath(driver, prop.getProperty("SelectCulsterxpath"), prop.getProperty("SelectCulsterxpath"),
						"Selected cluster field", "click on Cluster Lookup field", "Successfully hit the field", "N");

				fL.HandleMultipleWindows(driver, SelectCluster, SelectCluster, "Selected OpenStack-Aims",
						"Select one Cluster", "Cluster select Successful", "N");

			} else if (TypeofDecommission.equalsIgnoreCase("Server")) {

				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"),
						"Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");

				fL.selectDropdownbyID(driver, prop.getProperty("TypeofDecommission"), TypeofDecommission,
						TypeofDecommission, "Selected VcenterHost", "Select VcenterHost", "Select Successful", "N");

				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"),
						"Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");

				fL.clickByxpath(driver, prop.getProperty("SelectCulsterxpath"), prop.getProperty("SelectCulsterxpath"),
						"Selected cluster field", "click on Cluster Lookup field", "Successfully hit the field", "N");

				fL.HandleMultipleWindows(driver, SelectCluster, SelectCluster, "Selected OpenStack-Aims",
						"Select one Cluster", "Cluster select Successful", "N");

				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"),
						"Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");

				fL.clickByxpath(driver, prop.getProperty("SelectServerXpath"), prop.getProperty("SelectServerXpath"),
						"Selected Server field ", "click on Server Lookup field", "Successfully hit the field", "N");

				fL.HandleMultipleWindows(driver, SelectServer, SelectServer, "Selected DEV-LNX-APACHE-63 ",
						"Select One Server", "Server Select Successful", "N");

			}

			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"),
					"Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");

			fL.clickByID(driver, prop.getProperty("OrderNow"), prop.getProperty("OrderNow"), "Clicked OrderNow",
					"Place Your order", "Successful", "N");

		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}
	}

	public void ImpersonateUser(WebDriver driver) throws AWTException, InterruptedException, IOException
	{
		try{
			
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
	
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
			
			fL.SwitchtoWindows(driver, "", "", "", "");
			
			fL.clickByID(driver, prop.getProperty("infoDropdownid"),prop.getProperty("infoDropdownid"), "Clicked User Menu", "Select An User", "Select Successful", "N");
			
			fL.ClickByLinkText(driver, prop.getProperty("ImpersonateUserLink"),prop.getProperty("ImpersonateUserLink"), "Select ImpersonateUser", "Choose An User", "User Select Successful", "N");
			
			fL.clickByxpath(driver, prop.getProperty("SearchUserButtonXpath"),prop.getProperty("SearchUserButtonXpath"), "Clicked Search Bar", "Slect Search for User", "Successful", "N");
			
			fL.enterValuebyID(driver, prop.getProperty("SearchUserID"), "Maneesh Nama", "Maneesh Nama", "Passed UserName", "Provide UserName", "Successfully Provided", "N");
			
			fL.clickByClass(driver, prop.getProperty("SearchLabelUserClasss"),prop.getProperty("SearchLabelUserClasss"), "Clicked SearchLabel", "Click search for user", "Successful", "N");
		
			
		 } catch (WebDriverException e) {
			System.out.println(e.getMessage());
	 		}	
	}
	
	
	
	
	public void RequestApproval(WebDriver driver, String RequestNumber, String replaceReqNum) throws AWTException, InterruptedException, IOException
	{
		try{
			
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
			
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
			
			fL.enterValuebyID(driver, prop.getProperty("FilterID"), "Requests",prop.getProperty("FilterID"),  "passed the requests in FilterNavigator", "Search for requests", "Succesfully passed", "N");
			
			fL.clickByID(driver, prop.getProperty("SearchRequestID"),prop.getProperty("SearchRequestID"), "Clicked on Service catalog Requests", "Click on ServiceCatalog Requests", "Successful", "N");
			
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			fL.enterValuebyXpath(driver, prop.getProperty("RequestSearchxpath"), RequestNumber,prop.getProperty("RequestSearchxpath"), "Passed The RequestNumber", "Search for Requests", "Successful", "N");
			
			fL.PressEnterKeyUsingXpath(driver, prop.getProperty("RequestSearchxpath"));
			
			fL.ClickByLinkText(driver, RequestNumber, RequestNumber,"Clicked RequestNumber", "Click on request Number", "Successful", "N");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
		
			fL.ClickByLinkText(driver, replaceReqNum, replaceReqNum, "Clicking on Request Number Which contains RITM after replacing REQ to RITM", "Replace ReqNum", "Successful", "N");
			
			//RITMNumber(driver);
			
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
			
			fL.selectDropdownbyID(driver, prop.getProperty("ApprovedID"), "Approved", prop.getProperty("ApprovedID"),"Changed request to approve","aprrove status","aproved successfully","N");
			
			fL.clickByID(driver, prop.getProperty("UpdateButtonID"),prop.getProperty("UpdateButtonID"), "Updated form", "click update button", "Successfull", "N");
			
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
			
			//RITMNumber(driver);
			
			fL.ClickByLinkText(driver, replaceReqNum, replaceReqNum, "Replaced he request from REQ to RITM", "Replace RITM", "Successful", "N");
			
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
			
			fL.clickByxpath(driver, prop.getProperty("ApprovalTabxpath"),prop.getProperty("ApprovalTabxpath"), "Clicked on approval tab on RITM", "Manager Approval", "Successful", "N");
	
			ApprovalRequestTabLinkText(driver, prop.getProperty("ApprovalStatusLink"));
			
			fL.clickByxpath(driver, prop.getProperty("ApprovalTabxpath"),prop.getProperty("ApprovalTabxpath"), "Clicked on approval tab on RITM", "Manager Approval", "Successful", "N");
			
			ApprovalRequestNewTab(driver, prop.getProperty("ApprovalStatusLink"));
			
		 } catch (WebDriverException e) {
			////System.out.println(e.getMessage());
	 	}	
	}
	
	public void ApprovalRequestTabLinkText(WebDriver driver, String locator) throws IOException 
	{
		fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
		WebElement element=driver.findElement(By.linkText(locator));
		if(element.isDisplayed()){
			fL.rightClick(driver, element);
			WebElement elementEdit =driver.findElement(By.xpath(prop.getProperty("ApproveButtonXpath")));
			elementEdit.click();
			System.out.println("Success");
		}
	}
	
	public void ApprovalRequestNewTab(WebDriver driver, String locator) throws IOException, InterruptedException 
	{
		fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
		WebElement element=driver.findElement(By.linkText(locator));
		if(element.isDisplayed()){
			element.click();
			//fL.ClickByLinkText(driver, prop.getProperty("Approvallink"), prop.getProperty("Approvallink"), "Replaced he request from REQ to RITM", "Replace RITM", "Successful", "N");
			fL.selectDropdownbyID(driver, prop.getProperty("Approvaldropdown"), "Approved", prop.getProperty("Approvaldropdown"),"Changed request to approve","aprrove status","aproved successfully","N");
			fL.clickByxpath(driver, prop.getProperty("UpdateXpath"),prop.getProperty("UpdateXpath"), "Clicked on approval tab on RITM", "Manager Approval", "Successful", "N");
			System.out.println("Success1");
		}
	}


	public void ShowWorkFlow(WebDriver driver) throws AWTException, InterruptedException, IOException
	{
		try{
			
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
	
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
			
			fL.clickByID(driver, prop.getProperty("showworkflowID"),prop.getProperty("showworkflowID"), "Clicked on Workflow in RITM Form", "Show the workflow", "Workflow clicked Successful", "N");
			
			fL.SwitchtoAnotherWindows(driver, prop.getProperty("UpdateServerxpath"), "Selected updateserver tab on workflow", "click on updateserver tab", "successful", "N");
			
		 } catch (WebDriverException e) {
			////System.out.println(e.getMessage());
	 	}	
	}

	public String getRequestID(WebDriver driver, String locator)throws IOException
	{
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
			FluentWait<WebDriver> waitforelement  = new FluentWait<WebDriver>(driver)
				       .withTimeout(60, TimeUnit.SECONDS)
				       .pollingEvery(10, TimeUnit.SECONDS)
				       .ignoring(NoSuchElementException.class);
			waitforelement.until(ExpectedConditions.presenceOfElementLocated(By.id(locator)));
			String RequestID = fL.getTextByID(driver, locator);
			return RequestID;
			
	}
	
	public String ReplaceRequestNumber(WebDriver driver, String RequestNumber) throws IOException, InterruptedException{
		fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
		String RequestText = RequestNumber;
		String replaceReqNum  = RequestText.replace("REQ","RITM");  
		////System.out.println(replaceReqNum); 
		return replaceReqNum;
	}  
	
	public String getRequestNumber(WebDriver driver)throws IOException
	{
		fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
		String RequestText = getRequestID(driver, prop.getProperty("RequestLinkID"));
		////System.out.println(RequestText);
		return RequestText;
			
	}

	
	public void Search_cmdb_ci_server_list(WebDriver driver) throws IOException, InterruptedException {
		
		try {
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
	
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
			
			fL.SwitchtoWindows(driver, "", "", "", "");
			
			fL.enterValuebyXpath(driver, prop.getProperty("FilterXpath"), "cmdb_ci_server.list", "cmdb_ci_server.list", "passed cmdb server list in filternavigator", "pass cmdb server table in search navigator", "Successfully passed and entered", "N");
			
			fL.PressEnterKeyUsingXpath(driver, prop.getProperty("FilterXpath"));
		
						
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
			
	}
	
	public String getRITMNUMBEr (WebDriver driver, String replaceReqNum) throws IOException, InterruptedException {

			String str = replaceReqNum;
			
			int strLength = str.length();

			////System.out.println("strLength : " + strLength);

			String Laststr1 = str.substring(strLength - 5);

			////System.out.println("Last String : " + Laststr1);

			int i1 = Integer.parseInt(Laststr1);

			//System.out.println("Last String to int : " + i1);

			int add2AtLastString = i1 + 17;

			////System.out.println("Last int+2 : : " + add2AtLastString);

			String str3 = String.valueOf(add2AtLastString);

			String finalStr1 = str.substring(0, strLength - 5);

			////System.out.println("finalStr1 : " + finalStr1);

			String finalStr = finalStr1.concat(str3);

			////System.out.println("finalStr after adding 2 at last : " + finalStr);
	
			return finalStr;	
 }
	
	public void RITMNumber(WebDriver driver) throws IOException, InterruptedException {
		
		try {
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
	
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
			fL.SwitchFrames(driver, prop.getProperty("MainframeID"), prop.getProperty("MainframeID"), "Swicthing to Main Frame", "Main Frame should be activited", "Mainframe actitivited", "N");
			
			fL.SwitchtoWindows(driver, "", "", "", "");
			
			fL.clickByxpath(driver, prop.getProperty("RITMNumber"),prop.getProperty("RITMNumber"), "", "", "", "");
						
		} catch (WebDriverException e) {
			e.printStackTrace();
		}
			
	}

	public String getcurrentdate(String sTestCase){
		
		 Calendar cal = Calendar.getInstance();
		 SimpleDateFormat sdf = new SimpleDateFormat("HH-m-ss");
		 ////System.out.println(sdf.format(cal.getTime()));
		 String video = sTestCase;
		 String Value = video+"_"+sdf.format(cal.getTime());
		 return Value;
	}
	
	public void FirewalPortRules (WebDriver driver, String Protocol, String	OpenPort, String Port, String FromPort, String ToPort,	String AllowForm,	String IP, 	String FromIP,	String ToIP ) throws AWTException, InterruptedException, IOException
	{
		try{
			
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
			
			fL.selectDropdownbyID(driver, prop.getProperty("ProtocolID"), Protocol, "", "", "", "", "");
			
		
			if(OpenPort.equalsIgnoreCase("Port")){
				
				fL.clickByID(driver, prop.getProperty("OpenPortID"), "", "", "","", "");
				
				fL.selectDropdownbyID(driver, prop.getProperty("OpenPortID"), OpenPort, "", "", "", "", "");
				
				fL.clickByID(driver, prop.getProperty("PortID"), "", "", "","", "");
				
				fL.enterValuebyID(driver, prop.getProperty("PortID"), Port, "", "", "", "", "");
			}
			
			if(OpenPort.equalsIgnoreCase("Port Range")){
				
				fL.clickByID(driver, prop.getProperty("OpenPortID"), "", "", "","", "");
				
				fL.selectDropdownbyID(driver, prop.getProperty("OpenPortID"), OpenPort, "", "", "", "", "");
				
				fL.clickByID(driver, prop.getProperty("FromPort"), "", "", "","", "");
				
				fL.enterValuebyID(driver, prop.getProperty("FromPort"), FromPort, "", "", "", "", "");
				
				fL.clickByID(driver, prop.getProperty("ToPort"), "", "", "","", "");
				
				fL.enterValuebyID(driver, prop.getProperty("ToPort"), ToPort, "", "", "", "", "");
			}
			
			if(AllowForm.equalsIgnoreCase("IP")){
				
				fL.clickByID(driver, prop.getProperty("AllowFromID"), "", "","", "", "");
				
				fL.selectDropdownbyID(driver, prop.getProperty("AllowFromID"), AllowForm, "", "", "", "", "");
				
				fL.clickByID(driver, prop.getProperty("IPID"), "", "","", "", "");
				
				fL.enterValuebyID(driver, prop.getProperty("IPID"), IP, "", "", "", "", "");
				
			}

			if(AllowForm.equalsIgnoreCase("IP Range")){
				
				fL.clickByID(driver, prop.getProperty("AllowFromID"), "", "","", "", "");
				
				fL.selectDropdownbyID(driver, prop.getProperty("AllowFromID"), AllowForm, "", "", "", "", "");
				
				fL.clickByID(driver, prop.getProperty("FromIP"), "", "","", "", "");
				
				fL.enterValuebyID(driver, prop.getProperty("FromIP"), FromIP, "", "", "", "", "");
				
				fL.clickByID(driver, prop.getProperty("ToIP"), "", "","", "", "");
				
				fL.enterValuebyID(driver, prop.getProperty("ToIP"), ToIP, "", "", "", "", "");
				
				
			}

			if(AllowForm.equalsIgnoreCase("Any")){
				
				fL.clickByID(driver, prop.getProperty("AllowFromID"), "", "","", "", "");
				
				fL.selectDropdownbyID(driver, prop.getProperty("AllowFromID"), AllowForm, "", "", "", "", "");
				
			}

		 } catch (WebDriverException e) {
			////System.out.println(e.getMessage());
	 		}	
	}
	
	

	public void MonitoringInformation(WebDriver driver, String AddMonitering,	String InstallAgentMonitering,	String InstandEnablSNMP,	String ChangeDefaultCommString, String	CommunityString) throws AWTException, InterruptedException, IOException
	{
		try{
			
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
	
			if(AddMonitering.equalsIgnoreCase("No")){
				
				fL.clickByID(driver, prop.getProperty("MonitoringOptionID"),"", "", "", "", "");
				
				fL.selectDropdownbyID(driver, prop.getProperty("MonitoringOptionID"), AddMonitering, "", "", "", "", "");
				
			}
			
			if(AddMonitering.equalsIgnoreCase("Yes")){
				
				fL.clickByID(driver, prop.getProperty("MonitoringOptionID"),"", "", "", "", "");
				
				fL.selectDropdownbyID(driver, prop.getProperty("MonitoringOptionID"), AddMonitering, "", "", "", "", "");
				
				if(InstallAgentMonitering.equalsIgnoreCase("No")){
					
					fL.clickByID(driver, prop.getProperty("AgentMonitoringID"), "", "","", "", "");
					
					fL.selectDropdownbyID(driver, prop.getProperty("AgentMonitoringID"), InstallAgentMonitering, "", "", "", "", "");
					
					
				}
				
				if(InstandEnablSNMP.equalsIgnoreCase("No")){
					
					fL.clickByID(driver, prop.getProperty("SNMPAgentID"), "", "", "","", "");
					
					fL.selectDropdownbyID(driver, prop.getProperty("SNMPAgentID"), InstandEnablSNMP, "", "", "", "", "");
				}
				
			}
			
			
			if(AddMonitering.equalsIgnoreCase("Yes")){
				
				fL.clickByID(driver, prop.getProperty("MonitoringOptionID"),"", "", "", "", "");
				
				fL.selectDropdownbyID(driver, prop.getProperty("MonitoringOptionID"), AddMonitering, "", "", "", "", "");
				
				if(InstallAgentMonitering.equalsIgnoreCase("Yes")){
					
					fL.clickByID(driver, prop.getProperty("AgentMonitoringID"), "", "","", "", "");
					
					fL.selectDropdownbyID(driver, prop.getProperty("AgentMonitoringID"), InstallAgentMonitering, "", "", "", "", "");
					
					
				}
				
				if(InstandEnablSNMP.equalsIgnoreCase("Yes")){
					
					fL.clickByID(driver, prop.getProperty("SNMPAgentID"), "", "", "","", "");
					
					fL.selectDropdownbyID(driver, prop.getProperty("SNMPAgentID"), InstandEnablSNMP, "", "", "", "", "");
					
					if(ChangeDefaultCommString.equalsIgnoreCase("No")){
						
						fL.clickByID(driver, prop.getProperty("DefaultCommunitID"), "", "", "","", "");
						
						fL.selectDropdownbyID(driver, prop.getProperty("DefaultCommunitID"), ChangeDefaultCommString, "", "", "", "", "");
					}
				
				}
				
			}
			

			
			if(AddMonitering.equalsIgnoreCase("Yes")){
				
				fL.clickByID(driver, prop.getProperty("MonitoringOptionID"),"", "", "", "", "");
				
				fL.selectDropdownbyID(driver, prop.getProperty("MonitoringOptionID"), AddMonitering, "", "", "", "", "");
				
				if(InstallAgentMonitering.equalsIgnoreCase("Yes")){
					
					fL.clickByID(driver, prop.getProperty("AgentMonitoringID"), "", "","", "", "");
					
					fL.selectDropdownbyID(driver, prop.getProperty("AgentMonitoringID"), InstallAgentMonitering, "", "", "", "", "");
					
					
				}
				
				if(InstandEnablSNMP.equalsIgnoreCase("Yes")){
					
					fL.clickByID(driver, prop.getProperty("SNMPAgentID"), "", "", "","", "");
					
					fL.selectDropdownbyID(driver, prop.getProperty("SNMPAgentID"), InstandEnablSNMP, "", "", "", "", "");
					
					if(ChangeDefaultCommString.equalsIgnoreCase("Yes")){
						
						fL.clickByID(driver, prop.getProperty("DefaultCommunitID"), "", "", "","", "");
						
						fL.selectDropdownbyID(driver, prop.getProperty("DefaultCommunitID"), ChangeDefaultCommString, "", "", "", "", "");
						
						fL.clickByID(driver, prop.getProperty("CommunityStringID"), "", "", "","", "");
						
						fL.enterValuebyID(driver, prop.getProperty("CommunityStringID"), CommunityString, "", "", "", "", "");
					}
				
				}
				
			}
		
			
		 } catch (WebDriverException e) {
			//System.out.println(e.getMessage());
	 		}	
	}
	
	public void Logout(WebDriver driver) throws AWTException, InterruptedException, IOException
	{
		try{
			
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
	
			//SwitchToMainFrame(driver, prop.getProperty("MainframeID"));
			
			fL.SwitchtoWindows(driver, "", "", "", "");
			
			fL.clickByID(driver, prop.getProperty("LogoutDropdownID"),"", "", "", "", "");
			
			fL.ClickByLinkText(driver, prop.getProperty("LogoutLinkText"), "Logout", "", "", "", "");
			
		 } catch (WebDriverException e) {
			//System.out.println(e.getMessage());
	 		}	
	}
	
	
	 private void setAuthorInfoReports(){
		   ATUReports.setAuthorInfo("BCTab Application Automation", Utils.getCurrentTime(), "1.0");
	 }
	   
	   
			 

}
