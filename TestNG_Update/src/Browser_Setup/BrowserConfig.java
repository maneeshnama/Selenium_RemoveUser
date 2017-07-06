package Browser_Setup;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import BusinessFunctions.Functional_Cases;
import DynamicTestCaseName.UseAsTestName_TestBase;
import atu.testng.reports.ATUReports;
import atu.testrecorder.ATUTestRecorder;

public class BrowserConfig extends UseAsTestName_TestBase{

	public static WebDriver driver;
	public static ATUTestRecorder recorder;
	Functional_Cases fC = new Functional_Cases();
	
	Properties prop = new Properties();
	InputStream input = null;

	@BeforeTest
	public WebDriver setup()throws Exception{
		 input = new FileInputStream("Configuration\\Object_Repository.properties");
		 prop.load(input);
		 System.out.println(prop.getProperty("Browser"));
				 
		// #################################### Browser Configuration Setup #########################################
		 
		//========= FireFox Browser Setup ==============
		
		 if(prop.getProperty("Browser").equalsIgnoreCase("Firefox")){
			driver =  new FirefoxDriver();
			driver.manage().window().maximize();
			 String Value = fC.getcurrentdate("CNetLogin");
			 File file1 = new File("video");
			// recorder = new ATUTestRecorder(file1.getAbsolutePath(),Value,false);
			// recorder.start(); 
			ATUReports.setWebDriver(driver);
			ATUReports.indexPageDescription = "Sample Project";
		
		 } else if(prop.getProperty("Browser").equalsIgnoreCase("Chrome")){
			 
			//================Google Chrome Browser Setup====================== 
			 
			 	File file = new File("driver//chromedriver.exe");
		 		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
		 		ChromeOptions options = new ChromeOptions();
		 		options.addArguments("--start-maximized");
		 		options.addArguments("--disable-web-security");
		 		options.addArguments("--no-proxy-server");
		 		Map<String, Object> prefs = new HashMap<String, Object>();
		 		prefs.put("credentials_enable_service", false);
		 		prefs.put("profile.password_manager_enabled", false);
		 		options.setExperimentalOption("prefs", prefs);
		 		options.addArguments("disable-infobars"); 
		 		driver = new ChromeDriver(options);
		 		driver.manage().window().maximize();
		 		String Value = fC.getcurrentdate("CNetLogin");
				 File file1 = new File("video");
				// recorder = new ATUTestRecorder(file1.getAbsolutePath(),Value,false);
				 //recorder.start();
		 		ATUReports.setWebDriver(driver);
				ATUReports.indexPageDescription = "Sample Project"; 
				
		 } else if(prop.getProperty("Browser").equalsIgnoreCase("IE")){
			 
			//=================Internet Explorer Browser Setup======================				 
			 
			 File file = new File("drivers//IEDriverServer.exe");
			 System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
			 DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
			 capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			 capabilities.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
			 capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			 capabilities.setPlatform(Platform.WINDOWS);
			 File ie_temp = new File("E:\\WEBAUTOMATION_CODE\\SELENIUM_PERSONAL\\WORKSPACE_FRAMEWORK\\Selenium_Framework\\IEDrivertemp");
			 InternetExplorerDriverService.Builder ies= new InternetExplorerDriverService.Builder();
			 ies.withExtractPath(ie_temp);
			 InternetExplorerDriverService service=ies.build();
			 driver = new InternetExplorerDriver(service,capabilities);
			 driver.manage().window().maximize();
			 String Value = fC.getcurrentdate("CNetLogin");
			 File file1 = new File("video");
			// recorder = new ATUTestRecorder(file1.getAbsolutePath(),Value,false);
			// recorder.start();
			 ATUReports.setWebDriver(driver);
			 ATUReports.indexPageDescription = "Sample Project";

		 } else if(prop.getProperty("Browser").equalsIgnoreCase("Opera")){
			//=================Opera Browser Setup===================	
			 driver = new OperaDriver();
			 driver.manage().window().maximize();
			 String Value = fC.getcurrentdate("CNetLogin");
			 File file1 = new File("video");
			// recorder = new ATUTestRecorder(file1.getAbsolutePath(),Value,false);
			 //recorder.start();
			 ATUReports.setWebDriver(driver);
			 ATUReports.indexPageDescription = "Sample Project";
			 
		 } else if(prop.getProperty("Browser").equalsIgnoreCase("Safari")){
			//=====================Safari Browser Setup=================
			 driver =  new SafariDriver();
			 driver.manage().window().maximize();
			 String Value = fC.getcurrentdate("CNetLogin");
			 File file1 = new File("video");
			 //recorder = new ATUTestRecorder(file1.getAbsolutePath(),Value,false);
			//recorder.start();
			 ATUReports.setWebDriver(driver);
			 ATUReports.indexPageDescription = "Sample Project";
		 }
			 
			System.out.println(driver.manage().window().getSize());
			return driver;
			
	}
		
		@AfterTest
		public void tearDown() throws Exception {
		
//			driver.close();
			//recorder.stop();
			
		}
	
}
	
	
	

