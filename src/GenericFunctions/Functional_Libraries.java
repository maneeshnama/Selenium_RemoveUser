package GenericFunctions;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import atu.testng.reports.ATUReports;
import atu.testng.reports.logging.LogAs;
import atu.testng.reports.utils.Utils;
import atu.testng.selenium.reports.CaptureScreen;
import atu.testng.selenium.reports.CaptureScreen.ScreenshotOf;

public class Functional_Libraries {
	
	Properties prop = new Properties();
	InputStream input1 = null;
	
	 //Set Property for ATU Reporter Configuration
    {
      System.setProperty("atu.reporter.config", "atu.properties");
    }
    
		//Pass the url into the browser
		public void Invokeapplication(WebDriver driver, String URL, String browser, String input, String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws AWTException, InterruptedException, IOException
		{
			try {
			driver.get(URL);
			reportStep(input, Description, "SUCCESS", ExpectedResult, ActualResults, Screenshot);
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			} catch (WebDriverException e) {
				e.printStackTrace();
				reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				//System.out.println(e.getMessage());
			}
		}
	
		
		public void NavigateURL(WebDriver driver, String navURL, String browser, String input, String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws AWTException, InterruptedException, IOException
		{
			try {
				driver.navigate().to(navURL);
				reportStep(input, Description, "SUCCESS", ExpectedResult, ActualResults, Screenshot);		       
			    } catch (NoSuchElementException exc) {
					exc.printStackTrace();
					reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				} catch (WebDriverException e) {
					e.printStackTrace();
					reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
					//System.out.println(e.getMessage());
				}
			}
		
		
		public void clickByID(WebDriver driver, String id, String input, String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws IOException, InterruptedException
		{
			try {
				FluentWait<WebDriver> waitforelement  = new FluentWait<WebDriver>(driver)
					       .withTimeout(60, TimeUnit.SECONDS)
					       .pollingEvery(10, TimeUnit.SECONDS)
					       .ignoring(NoSuchElementException.class);
				waitforelement.until(ExpectedConditions.elementToBeClickable(By.id(id)));
				driver.findElement(By.id(id)).click();
				reportStep(input, Description, "SUCCESS", ExpectedResult, ActualResults, Screenshot);
				} catch (NoSuchElementException exc) {
					exc.printStackTrace();
					reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				} catch (WebDriverException e) {
					e.printStackTrace();
					reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				} 
			}
		
		public void clickByClass(WebDriver driver, String classname,String input ,String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws IOException, InterruptedException
		{
			try {
				FluentWait<WebDriver> waitforelement  = new FluentWait<WebDriver>(driver)
					       .withTimeout(60, TimeUnit.SECONDS)
					       .pollingEvery(10, TimeUnit.SECONDS)
					       .ignoring(NoSuchElementException.class);
				waitforelement.until(ExpectedConditions.elementToBeClickable(By.className(classname)));
				driver.findElement(By.className(classname)).click();
				reportStep(input, Description, "SUCCESS", ExpectedResult, ActualResults, Screenshot);
				} catch (NoSuchElementException exc) {
					exc.printStackTrace();
					reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				} catch (WebDriverException e) {
					e.printStackTrace();
					reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				} 
			}
		
		public void clickByxpath(WebDriver driver, String xpath,String input,  String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws IOException, InterruptedException
		{
			try {
				FluentWait<WebDriver> waitforelement  = new FluentWait<WebDriver>(driver)
					       .withTimeout(60, TimeUnit.SECONDS)
					       .pollingEvery(10, TimeUnit.SECONDS)
					       .ignoring(NoSuchElementException.class);
				waitforelement.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
				driver.findElement(By.xpath(xpath)).click();
				reportStep(input, Description, "SUCCESS", ExpectedResult, ActualResults, Screenshot);
				} catch (NoSuchElementException exc) {
					exc.printStackTrace();
					reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				} catch (WebDriverException e) {
					e.printStackTrace();
					reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				} 
			}
	
		
		public void ClickByLinkText(WebDriver driver, String text,String input,  String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws IOException, InterruptedException
		{
			try {
				FluentWait<WebDriver> waitforelement  = new FluentWait<WebDriver>(driver)
					       .withTimeout(60, TimeUnit.SECONDS)
					       .pollingEvery(10, TimeUnit.SECONDS)
					       .ignoring(NoSuchElementException.class);
				waitforelement.until(ExpectedConditions.elementToBeClickable(By.linkText(text)));
				driver.findElement(By.linkText(text)).click();
				reportStep(input, Description, "SUCCESS", ExpectedResult, ActualResults, Screenshot);
				} catch (NoSuchElementException exc) {
					exc.printStackTrace();
					reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				} catch (WebDriverException e) {
					e.printStackTrace();
					reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				} 
			}
		
		
		
		public void SwitchFrames(WebDriver driver, String frame, String input, String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws IOException
		{
			try {
			driver.switchTo().defaultContent();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.switchTo().frame(frame);
			input=frame;
			reportStep(input, Description, "SUCCESS", ExpectedResult, ActualResults, Screenshot);
			} catch (NoSuchElementException e) {
				e.printStackTrace();
				reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				//System.out.println(e.getMessage());
			}
		}
		
		public void enterValuebyID(WebDriver driver, String id, String Value, String input, String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws IOException
		{
			try {
				FluentWait<WebDriver> waitforelement  = new FluentWait<WebDriver>(driver)
					       .withTimeout(10, TimeUnit.SECONDS)
					       .pollingEvery(2, TimeUnit.MILLISECONDS)
					       .ignoring(NoSuchElementException.class);
				waitforelement.until(ExpectedConditions.elementToBeClickable(By.id(id)));
			driver.findElement(By.id(id)).clear();
			driver.findElement(By.id(id)).sendKeys(Value);
			reportStep(input, Description, "SUCCESS", ExpectedResult, ActualResults, Screenshot);
			} catch (NoSuchElementException exc) {
				exc.printStackTrace();
				reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
			} catch (Exception e) {
				e.printStackTrace();
				reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				//System.out.println(e.getMessage());
			}
		}
		
		public void enterValuebyXpath(WebDriver driver, String xpath, String Value, String input, String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws IOException
		{
			try {
				FluentWait<WebDriver> waitforelement  = new FluentWait<WebDriver>(driver)
					       .withTimeout(60, TimeUnit.SECONDS)
					       .pollingEvery(10, TimeUnit.SECONDS)
					       .ignoring(NoSuchElementException.class);
				waitforelement.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			driver.findElement(By.xpath(xpath)).clear();
			driver.findElement(By.xpath(xpath)).sendKeys(Value);
			reportStep(input, Description, "SUCCESS", ExpectedResult, ActualResults, Screenshot);
			} catch (NoSuchElementException exc) {
				exc.printStackTrace();
				reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
			} catch (Exception e) {
				e.printStackTrace();
				reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				//System.out.println(e.getMessage());
			}
		}
		public void selectDropdownbyID(WebDriver driver, String id, String text, String input, String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws IOException
		{
			try {
				FluentWait<WebDriver> waitforelement  = new FluentWait<WebDriver>(driver)
					       .withTimeout(60, TimeUnit.SECONDS)
					       .pollingEvery(10, TimeUnit.SECONDS)
					       .ignoring(NoSuchElementException.class);
				waitforelement.until(ExpectedConditions.elementToBeClickable(By.id(id)));
				WebElement element = driver.findElement(By.id(id));
				Select dropDownElement = new Select(element);
				dropDownElement.selectByVisibleText(text);
				
				
				
				
				reportStep(input, Description, "SUCCESS", ExpectedResult, ActualResults, Screenshot);
				} catch (NoSuchElementException exc) {
					exc.printStackTrace();
					reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				} 
			}
		
		
		public void HandleMultipleWindows(WebDriver driver, String text,String input, String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws IOException, InterruptedException
		{
			try {
				
				// To get the main window handle
				String mainWindow= driver.getWindowHandle();
				
				//System.out.println("Current Window Page Window Handler ="+ mainWindow );
						
				String windowTitle  = driver.getTitle();
				
				//System.out.println("Current Page Tile ="+ windowTitle );
				
				// To get all windows handles 
				Set<String> allWindowHandles = driver.getWindowHandles();
				
				//System.out.println("ALL Window Page Window Handler ="+ allWindowHandles );
				
				for (String currentWindowHandle : allWindowHandles) {
					
					if (!currentWindowHandle.equals(mainWindow)) {
						
						driver.switchTo().window(currentWindowHandle);
						
						//driver.manage().window().maximize();
							
						try {
							FluentWait<WebDriver> waitforelement  = new FluentWait<WebDriver>(driver)
								       .withTimeout(60, TimeUnit.SECONDS)
								       .pollingEvery(10, TimeUnit.SECONDS)
								       .ignoring(NoSuchElementException.class);
							waitforelement.until(ExpectedConditions.elementToBeClickable(By.linkText(text)));
							driver.findElement(By.linkText(text)).click();
							reportStep(input, Description, "SUCCESS", ExpectedResult, ActualResults, Screenshot);
							} catch (NoSuchElementException exc) {
								exc.printStackTrace();
								reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
							} catch (WebDriverException e) {
								e.printStackTrace();
								reportStep(input, Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
							}
					
						}
				}
				
				driver.switchTo().window(mainWindow);
			
			} catch (NoSuchElementException exc) {
				exc.printStackTrace();
				reportStep("", Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
			} catch (WebDriverException e) {
				e.printStackTrace();
				reportStep("", Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
			} 
		}
	
			
		public void SwitchtoWindows(WebDriver driver,  String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws IOException, InterruptedException
		{
			try {
				
				// To get the main window handle
				String mainWindow= driver.getWindowHandle();
				
				//System.out.println("Current Window Page Window Handler ="+ mainWindow );
						
				String windowTitle  = driver.getTitle();
				
				//System.out.println("Current Page Tile ="+ windowTitle );
				
				// To get all windows handles 
				Set<String> allWindowHandles = driver.getWindowHandles();
				
				//System.out.println("ALL Window Page Window Handler ="+ allWindowHandles );
				
				for (String currentWindowHandle : allWindowHandles) {
					
					if (!currentWindowHandle.equals(mainWindow)) {
						
						driver.switchTo().window(currentWindowHandle);
						
						driver.manage().window().maximize();
					
					}
				}
				
				driver.switchTo().window(mainWindow);
			
			} catch (NoSuchElementException exc) {
				exc.printStackTrace();
				reportStep("", Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
			} catch (WebDriverException e) {
				e.printStackTrace();
				reportStep("", Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
			} 
		}
	
		public void SwitchtoAnotherWindows(WebDriver driver,  String locator, String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws IOException, InterruptedException
		{
			try {
				input1 = new FileInputStream("Configuration\\Object_Repository.properties");
				prop.load(input1);
				
				// To get the main window handle
				String mainWindow= driver.getWindowHandle();
				
				//System.out.println("Current Window Page Window Handler ="+ mainWindow );
						
				String windowTitle  = driver.getTitle();
				
				//System.out.println("Current Page Tile ="+ windowTitle );
				
				// To get all windows handles 
				Set<String> allWindowHandles = driver.getWindowHandles();
				
				//System.out.println("ALL Window Page Window Handler ="+ allWindowHandles );
				
				for (String currentWindowHandle : allWindowHandles) {
					
					if (!currentWindowHandle.equals(mainWindow)) {
						
						driver.switchTo().window(currentWindowHandle);
						
						//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
						
						//System.out.println(currentWindowHandle);
						
						try {
							//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							
						    clickByxpath(driver, prop.getProperty("UpdateServerxpath"),prop.getProperty("UpdateServerxpath") ,"", "", "", "");
							
							//WaitForSpinner(driver, prop.getProperty("Spinner"));
							
							//WaitForLoader(driver, prop.getProperty("Loader"));
													
							RefreshButton(driver, prop.getProperty("RefreshButtonXpath"), "", "", "", "", "");
							//RefreshButtonuntilEndButtonEnable(driver);
													
							Scroll_PageTo_BottomofAPage(driver, "", "", "", "");
							
							driver.switchTo().window(currentWindowHandle).close();
							
						} catch (NoSuchElementException exc) {
								exc.printStackTrace();
								reportStep("", Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
							} catch (WebDriverException e) {
								e.printStackTrace();
								reportStep("", Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
							}
					}
		
				}
			
				driver.switchTo().window(mainWindow);
			
			} catch (NoSuchElementException exc) {
				exc.printStackTrace();
				reportStep("", Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
			} catch (WebDriverException e) {
				e.printStackTrace();
				reportStep("", Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
			} 
		}
		
		
		public void Scroll_PageTo_BottomofAPage(WebDriver driver, String Description, String ExpectedResult, String ActualResults,String Screenshot ) throws IOException, InterruptedException {
			
			try {
				input1 = new FileInputStream("Configuration\\Object_Repository.properties");
				prop.load(input1);
		
				// Create instance of Javascript executor
				JavascriptExecutor je = (JavascriptExecutor) driver;
				 
				//Identify the WebElement which will appear after scrolling down
				WebElement element = driver.findElement(By.xpath(prop.getProperty("EndButtonXpath")));
				 
				// now execute query which actually will scroll until that element is not appeared on pa
				je.executeScript("arguments[0].scrollIntoView(true);",element);
				
				//Thread.sleep(10000);
							
			} catch (WebDriverException e) {
				e.printStackTrace();
				reportStep("", Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
			}
				
		}

		
		public void RefreshButton(WebDriver driver, String locator, String input, String Description, String ExpectedResult, String ActualResults,String Screenshot )throws IOException{
				try {
						FluentWait<WebDriver> waitforelement  = new FluentWait<WebDriver>(driver)
							       .withTimeout(60, TimeUnit.SECONDS)
							       .pollingEvery(10, TimeUnit.SECONDS)
							       .ignoring(NoSuchElementException.class);
						waitforelement.until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));
						driver.findElement(By.xpath(locator)).click();
						reportStep("", Description, "SUCCESS", ExpectedResult, ActualResults, Screenshot);
					} catch (NoSuchElementException exc) {
						exc.printStackTrace();
						reportStep("", Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
					} catch (WebDriverException e) {
						e.printStackTrace();
						reportStep("", Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
					}
			}
		
			public void RefreshButtonuntilEndButtonEnable(WebDriver driver) throws IOException{
				try {
				input1 = new FileInputStream("Configuration\\Object_Repository.properties");
				prop.load(input1);
				
				String EndButton = driver.findElement(By.className(prop.getProperty("EndButtonClass"))).getAttribute("background-color");
				do {
					RefreshButton(driver, prop.getProperty("RefreshButtonXpath"), "", "", "", "", "");
			      }while(!EndButton.equalsIgnoreCase(null));
				} catch (NoSuchElementException exc) {
					exc.printStackTrace();
					//reportStep("", Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				} catch (WebDriverException e) {
					e.printStackTrace();
					//reportStep("", Description, "FAILED", ExpectedResult, ActualResults, Screenshot);
				}
			}
			
		public String getTextByID(WebDriver driver, String id)throws IOException{
			String Value="";
			try {
				FluentWait<WebDriver> waitforelement  = new FluentWait<WebDriver>(driver)
					       .withTimeout(60, TimeUnit.SECONDS)
					       .pollingEvery(10, TimeUnit.SECONDS)
					       .ignoring(NoSuchElementException.class);
				waitforelement.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
				WebElement element = driver.findElement(By.id(id));
				Value = element.getText();
				} catch (NoSuchElementException exc) {
					exc.printStackTrace();
				} 
			return Value;
		}
	
		
		public void PressEnterKeyUsingXpath(WebDriver driver, String xpath)throws IOException{
			try {
				FluentWait<WebDriver> waitforelement  = new FluentWait<WebDriver>(driver)
					       .withTimeout(60, TimeUnit.SECONDS)
					       .pollingEvery(10, TimeUnit.SECONDS)
					       .ignoring(NoSuchElementException.class);
				waitforelement.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
				WebElement element = driver.findElement(By.xpath(xpath));
				element.sendKeys(Keys.ENTER);
				} catch (NoSuchElementException exc) {
					exc.printStackTrace();
				} 
		}
		
		public void rightClick(WebDriver driver, WebElement element) {
			try {
				Actions action = new Actions(driver).contextClick(element);
				action.build().perform();
				//System.out.println("Sucessfully Right clicked on the element");
			} catch (StaleElementReferenceException e) {
				//System.out.println("Element is not attached to the page document " + e.getStackTrace());
			} catch (NoSuchElementException e) {
				//System.out.println("Element " + element + " was not found in DOM " + e.getStackTrace());
			} catch (Exception e) {
				//System.out.println("Element " + element + " was not clickable " + e.getStackTrace());
			}
		}
		
		public void WaitForSpinner(WebDriver driver, String locator) throws IOException, InterruptedException
		{
			try {
				FluentWait<WebDriver> WaitForSpinner  = new FluentWait<WebDriver>(driver)
					       .withTimeout(30, TimeUnit.SECONDS)
					        .pollingEvery(5, TimeUnit.SECONDS)
					       .ignoring(NoSuchElementException.class);
				WaitForSpinner.until(ExpectedConditions.invisibilityOfElementLocated(By.id(locator)));
				} catch (NoSuchElementException exc) {
					exc.printStackTrace();
					
				} catch (WebDriverException e) {
					e.printStackTrace();
					
				} 
			}

		
		public void WaitForLoader(WebDriver driver, String locator) throws IOException, InterruptedException
		{
			try {
				FluentWait<WebDriver> WaitForSpinner  = new FluentWait<WebDriver>(driver)
					       .withTimeout(30, TimeUnit.SECONDS)
					        .pollingEvery(5, TimeUnit.SECONDS)
					       .ignoring(NoSuchElementException.class);
				WaitForSpinner.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(locator)));
				} catch (NoSuchElementException exc) {
					exc.printStackTrace();
					
				} catch (WebDriverException e) {
					e.printStackTrace();
					
				} 
			}

		
		public static void reportStep(String input, String Description, String Status, String ExpectedResult, String ActualResults,String Screenshot){
		    
			if(Status.toUpperCase().equals("SUCCESS") && Screenshot.toUpperCase().equals("Y"))
			{
				//ATUReports.add("Pass Step 1", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		        ATUReports.add(Description,input,ExpectedResult,ActualResults, LogAs.PASSED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
			} else if(Status.toUpperCase().equals("SUCCESS")&& Screenshot.toUpperCase().equals("N"))
			{
				//ATUReports.add("Pass Step 1", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		        ATUReports.add(Description,input,ExpectedResult,ActualResults, LogAs.PASSED, null);
			} else if(Status.toUpperCase().equals("FAILED")&& Screenshot.toUpperCase().equals("Y"))
			{
				//ATUReports.add("Pass Step 1", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		        ATUReports.add(Description,input,ExpectedResult,"Error Occurred: Please Check the Logs", LogAs.FAILED, new CaptureScreen(ScreenshotOf.BROWSER_PAGE));
		     } else if(Status.toUpperCase().equals("FAILED")&& Screenshot.toUpperCase().equals("N"))
			{
				//ATUReports.add("Pass Step 1", LogAs.PASSED, new CaptureScreen(ScreenshotOf.DESKTOP));
		        ATUReports.add(Description,input,ExpectedResult,"Error Occurred: Please Check the Logs", LogAs.FAILED, null);
			}
		}
		
		 private void setAuthorInfoReports(){
			   ATUReports.setAuthorInfo("BCTab Application Automation", Utils.getCurrentTime(), "1.0");
		 }
}
