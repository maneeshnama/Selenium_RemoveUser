package BatchExecution;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.jboss.netty.util.Timeout;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import Browser_Setup.BrowserConfig;
import BusinessFunctions.Functional_Cases;
import DynamicTestCaseName.UseAsTestName;
import GenericFunctions.Functional_Libraries;
import Utilities.DataInputProvider;
import Utilities.ReadDataFromExcel;
import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;
import atu.testng.reports.utils.Utils;

@Listeners({ATUReportsListener.class, ConfigurationListener.class, MethodListener.class})
public class UpdateVMScenario extends BrowserConfig{
	
	Properties prop = new Properties();
	InputStream input = null;
	Functional_Cases fC = new Functional_Cases();
	Functional_Libraries fL = new Functional_Libraries();

		 //Set Property for ATU Reporter Configuration
	    {
	      System.setProperty("atu.reporter.config", "atu.properties");
	    }
	    
	    @Test
		 public void cNetLoginScenario() throws AWTException, InterruptedException, IOException{
			 setAuthorInfoReports();
				try{
				input = new FileInputStream("Configuration\\Object_Repository.properties");
				prop.load(input);
				fC.CNetLogin(driver);
				} catch (NoSuchElementException exc) {
					exc.printStackTrace();
				} catch (WebDriverException e) {
					e.printStackTrace();
				}
			}
	    
	    
	    @UseAsTestName(idx=1)
		@Test(dataProvider = "UpdateVM_Update", priority=1)
		public void UpdateVirtualMachine(String Control, String UpdateVM_Scenario, String ProjectInformation, String Project, String PrimaryDatacenter, String PrimaryCloudPlatform,  String VcenterHost, String ESXIHOST, String SelectCluster, String	SelectServer, String Serversize, String Storage, String StorageProvier, String StorageName, String AggregateName, String VServer,	String Size, String SizeUnits, String Protocol, String	OpenPort, String Port,  String FromPort, String ToPort, String AllowForm, String IP, String FromIP, String ToIP, String AddMonitering,	String InstallAgentMonitering,	String InstandEnablSNMP, String ChangeDefaultCommString, String	CommunityString) throws AWTException, InterruptedException, IOException
		{
			setAuthorInfoReports();
			try{
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
			
			if(Control.equalsIgnoreCase("Y")){
//				fC.AIMSLaunchApplication(driver);
//				fC.UpdateVirtualMachine_Update(driver, ProjectInformation, Project, PrimaryDatacenter, PrimaryCloudPlatform, VcenterHost, ESXIHOST, SelectCluster, SelectServer, Serversize, Storage, StorageProvier,	StorageName,	AggregateName,	VServer,	Size,	SizeUnits,	Protocol,	OpenPort,	Port,	FromPort, ToPort, AllowForm, IP, FromIP,  ToIP, AddMonitering,	InstallAgentMonitering,	InstandEnablSNMP,	ChangeDefaultCommString,	CommunityString );
//				fC.getRequestNumber(driver);	
//				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), "", "", "", "", "");
//				String RequestText = fC.getRequestID(driver, prop.getProperty("RequestLinkID"));
//				System.out.println(RequestText);
//				fC.ImpersonateUser(driver);
//				String replaceReqNum = fC.ReplaceRequestNumber(driver, RequestText);
//				System.out.println(replaceReqNum);
//				String finalreplaceReqNum = fC.getRITMNUMBEr(driver, replaceReqNum);
//				System.out.println(finalreplaceReqNum);
//				fC.RequestApproval(driver, RequestText, finalreplaceReqNum);
//				
//				fC.ShowWorkFlow(driver);
//				
//				fC.Search_cmdb_ci_server_list(driver);
				
			 getTestName().equals(UpdateVM_Scenario);
				
			}		
			} catch (NoSuchElementException exc) {
				exc.printStackTrace();
			} catch (WebDriverException e) {
				e.printStackTrace();
			}
		}
		
	    @UseAsTestName(idx=1)
		@Test(dataProvider = "UpdateVM_Delete", priority=2)
		public void UpdateVirtualMachine(String Control, String UpdateVM_Scenario, String ProjectInformation, String Project, String PrimaryDatacenter, String PrimaryCloudPlatform, String TypeofDecommission, String VcenterHost, String ESXIHOST, String SelectCluster, String	SelectServer) throws AWTException, InterruptedException, IOException
		{
			setAuthorInfoReports();
			try{
			input = new FileInputStream("Configuration\\Object_Repository.properties");
			prop.load(input);
			
			if(Control.equalsIgnoreCase("Y")){
				fC.AIMSLaunchApplication(driver);
				fC.UpdateVirtualMachine_Delete(driver, ProjectInformation, Project, PrimaryDatacenter, PrimaryCloudPlatform, TypeofDecommission, VcenterHost, ESXIHOST, SelectCluster, SelectServer);
				fC.getRequestNumber(driver);	
				fL.SwitchFrames(driver, prop.getProperty("MainframeID"), "", "", "", "", "");
				
				String RequestText = fC.getRequestID(driver, prop.getProperty("RequestLinkID"));
				System.out.println(RequestText);
				fC.ImpersonateUser(driver);
				
				String replaceReqNum = fC.ReplaceRequestNumber(driver, RequestText);
				System.out.println(replaceReqNum);
				String finalreplaceReqNum = fC.getRITMNUMBEr(driver, replaceReqNum);
				System.out.println(finalreplaceReqNum);
				fC.RequestApproval(driver, RequestText, finalreplaceReqNum);
				
				fC.ShowWorkFlow(driver);
				fC.Search_cmdb_ci_server_list(driver);
				
			 getTestName().equals(UpdateVM_Scenario);
				
			}		
			} catch (NoSuchElementException exc) {
				exc.printStackTrace();
			} catch (WebDriverException e) {
				e.printStackTrace();
			}
		}
	
		
		@Test(priority=3)
		 public void cNetLogoutScenario() throws AWTException, InterruptedException, IOException{
			 
			 setAuthorInfoReports();
				try{
				input = new FileInputStream("Configuration\\Object_Repository.properties");
				prop.load(input);
				
					fC.Logout(driver);
					
				} catch (NoSuchElementException exc) {
					exc.printStackTrace();
				} catch (WebDriverException e) {
					e.printStackTrace();
				}
			}
		
		@DataProvider(name ="UpdateVM_Update")
		  public Object[][]createData1() throws Exception{
			  Object[][] testObjArray = DataInputProvider.getDataArray("Testdata\\UpdateVirtualMachine.xlsx","Update");
		       return (testObjArray);
			}
	
		@DataProvider(name ="UpdateVM_Delete")
		  public Object[][]createData() throws Exception{
			  Object[][] testObjArray = DataInputProvider.getDataArray("Testdata\\UpdateVirtualMachine.xlsx","Delete");
		       return (testObjArray);
			}
	 
	
	
	private void setAuthorInfoReports(){
	 	   ATUReports.setAuthorInfo("Sample Application Automation", Utils.getCurrentTime(), "1.0");
	 }
	   
}
