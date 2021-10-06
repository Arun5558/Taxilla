package com.selenium.DataDriven.Functions;
import static org.testng.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.Webdriver.ChromeOptions;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.DataDriven.Base.BaseClass;
import com.selenium.DataDriven.Util.ExtentManager;


public class GenericActions extends BaseClass {
	
	
	//public ExtentTest test;
	//******************************Launching different Browsers***************************************
	
	public void openBrowser(String browserlanuch)
	{
		//System.out.println(prop.getProperty("Browserlaunch"));
		if (browserlanuch.equals("Chrome")){
			//options = Options();
			System.setProperty("webdriver.chrome.driver","chromedriver");
			ChromeOptions opts = new ChromeOptions();
			opts.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			//For running in non gui mode from jenkins
		//*****************	
//			opts.setBinary("/opt/google/chrome/chrome");
//			
//			opts.addArguments("--no-sandbox");
//			opts.addArguments("-disable-dev-shm-usage");
//			opts.addArguments("--headless");
//			
//			opts.addArguments("enable-automation");
//			
//			opts.addArguments("--window-size=1920,1080");
//			opts.setExperimentalOption("useAutomationExtension", false);
//			opts.addArguments("--disable-extensions");
//			opts.addArguments("--disable-gpu");
		//***************************	
			
			
			
			driver =new ChromeDriver(opts);
			 driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		}
		else if (browserlanuch.equals("Mozilla")){
			System.setProperty("webdriver.gecko.driver", "/home/aknandigam/Automation&softwares/Jars/geckodriver-v0.26.0-linux64/geckodriver");
			driver =new FirefoxDriver();
			 driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		}
		else if (browserlanuch.equals(prop.getProperty("Browserlaunch"))){
			System.setProperty("webriver.chrome.driver","/home/aknandigam/Automation&softwares/Jars/chromedriver_linux64/chromedriver");
		driver =new InternetExplorerDriver();
		}
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		test.log(LogStatus.INFO, "Browser has oppened");

		
	}
	//******************************Openning URL***************************************
		public void navigateURL(String apURlkey)
		{
			wait(500);
			driver.get(prop.getProperty(apURlkey));
			//driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			wait(500);
			//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			test.log(LogStatus.INFO, "URL has oppened");
			//wait(3000);
			//waitForPageToLoad();
			//takeScreenShot();
		}
		//******************************Finding Elements by xpath,name and id***************************************
		public WebElement getElement(String locatorkey)
		
		{
			
				WebElement  e = null;
				try {
			if(locatorkey.endsWith("_xpath"))
				e= driver.findElement(By.xpath(prop.getProperty(locatorkey)));
			else if (locatorkey.endsWith("_id"))
				e = driver.findElement(By.id(prop.getProperty(locatorkey)));
			
			else if (locatorkey.endsWith("_name"))
				e =driver.findElement(By.name(prop.getProperty(locatorkey)));
			
			else
			   {System.out.println("Locatorykey is not correct" + " " + locatorkey);
				Assert.fail();}
				//return e;
			
			}	
		
			catch(Exception ex)
			{
				//ex= null;
				reportFailure(ex.getMessage(),"hardassert");
				ex.printStackTrace();
				Assert.fail("Fail the test"+ ex.getMessage());
			}
			return e;
			
		}
		
		
		//******************************Typing***************************************
		public void type(String locatorkey,String data) 
		{
			isEnabled(locatorkey, "Text-box  is enabled", "Text-box is not enabled","hardassert");
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(getElement(locatorkey))).sendKeys((data));
			//wait(2000);
			//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			
		}
		
		//******************************Click on webelement***************************************
		public void click(String locatorkey) 
		
		{
			isEnabled(locatorkey, "Element is clickable", "Element is not clickable","hardassert");
			//JavascriptExecutor jss = (JavascriptExecutor)driver;
			try {
			//wait(2000);
			//waitForPageToLoad();
				//System.out.println(locatorkey+"start" );
				
				new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(getElement(locatorkey))).click();
			//WebElement c=getElement(locatorkey);
			
			//jss.executeScript("aruguments[0].click()", c);
			//c.click();
			//Thread.sleep(10);
			//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
				//takeScreenShot();
		}	

		catch(Exception ex)
		{
			reportFailure(ex.getMessage(),"hardassert");
			ex.printStackTrace();
			Assert.fail("Fail the test"+ ex.getMessage());
		}
		}
		

		//******************************jsClick on webelement***************************************
		public void jsclick(String locatorkey) 
		
		{
			isEnabled(locatorkey, "Element is clickable", "Element is not clickable","hardassert");
			//JavascriptExecutor jss = (JavascriptExecutor)driver;
			try {
			//wait(2000);
			//waitForPageToLoad();
				//System.out.println(locatorkey+"start" );
				JavascriptExecutor executor = (JavascriptExecutor)driver;
		        executor.executeScript("arguments[0].click();", new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(getElement(locatorkey))));
				
				//new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(getElement(locatorkey))).click();
			//WebElement c=getElement(locatorkey);
			
			//jss.executeScript("aruguments[0].click()", c);
			//c.click();
			//Thread.sleep(10);
			//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			
				//takeScreenShot();
		}	

		catch(Exception ex)
		{
			reportFailure(ex.getMessage(),"hardassert");
			ex.printStackTrace();
			Assert.fail("Fail the test"+ ex.getMessage());
		}
		}

		//******************************Validations***************************************
		
		
		//******************************IsElementPresent***************************************
//arug1=locatarkey for xpath ,arug2=Pass message has to be sent,arug3=Fail message has to be sent,arg4=If you want to do soft you need to send "softassert" value as argument or else you can send any value which will do hardassert

		
		public boolean isElementPresent(String locatorkey,String passm,String failm,String asserttype)
		{
			try{//new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(getElement(locatorkey)));
			List<WebElement> webelementlist = null;
			
			if(locatorkey.endsWith("_xpath"))
				webelementlist= driver.findElements(By.xpath(prop.getProperty(locatorkey)));
			else if (locatorkey.endsWith("_id"))
				webelementlist = driver.findElements(By.id(prop.getProperty(locatorkey)));
			
			else if (locatorkey.endsWith("_name"))
				webelementlist =driver.findElements(By.name(prop.getProperty(locatorkey)));
			
			else
			   {
				takeScreenShot();
				reportFailure("Locator not found" + locatorkey,asserttype);
				Assert.fail("Locator not found" + locatorkey);
			   }
				//return e;
		if (webelementlist.size()==0)
		{
			
			reportFailure(failm,asserttype);
			return false;
			}
		
		else
		{
			reportPass(passm);
			return true;
		}
			}
			catch(Exception ex)
			{
				reportFailure(ex.getMessage(),"hardassert");
				ex.printStackTrace();
				Assert.fail("Fail the test"+ ex.getMessage());
				return false;
			}
			
			
		}
		
		//******************************VerifyText(Based on locator get the text and compare to the expected text which we provide)***************************************
//arug1=locatarkey for xpath ,arug2= expectedText has been sent , arug3=Pass message has to be sent,arug4=Fail message has to be sent,arug5=If you want to do soft you need to send "softassert" value as argument or else you can send any value which will do hardassert
		public boolean verifyText(String locatorkey,String text,String passm,String failm,String asserttype)
		{
			String ActualText= getElement(locatorkey).getText().trim();
			String ExpectedText= prop.getProperty(text);
			if(ActualText.equals(ExpectedText))
			{
			reportPass(passm);
			return true;
			
			}
		else{
	
				reportFailure(failm,asserttype);
			
			return false;
		}
			
		}
		
		//******************************GetText(Based on locator get the text and compare to the expected text which we provide)***************************************
		//arug1=locatarkey for xpath ,arug2= expectedText has been sent , arug3=Pass message has to be sent,arug4=Fail message has to be sent,arug5=If you want to do soft you need to send "softassert" value as argument or else you can send any value which will do hardassert
				
		
	//******************************Verify Whether some text message is present in the page based on page source***************************************
		//arug1=Send the text which you want to verify ,arug2=Pass message has to be sent,arug3=Fail message has to be sent,arg4=If you want to do soft you need to send "softassert" value as argument or else you can send any value which will do hardassert	
		public void  verifyTextinPage(String text,String passm,String failm,String asserttype)
		{
			
			
			//String m="sdf";
			//String n="xcvcx";
			if (driver.getPageSource().contains(text))
			{
				reportPass(passm);
				//reportPass("Unlock user option is not displaying for user who doesnt have create user role");
			}
			else
			{
				reportFailure(failm,asserttype);
			}
			
		}
		
		//******************************Verifying whether text box is enabled or not***************************************	
//arug1=locatorkey for xpath ,arug2=Pass message has to be sent,arug3=Fail message has to be sent,arg4=If you want to do soft you need to send "softassert" value as argument or else you can send any value which will do hardassert		
		public void  isEnabled(String locatorkey,String passm,String failm,String asserttype)
		{
			
			new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(getElement(locatorkey)));
			//String m="sdf";
			//String n="xcvcx";
			test.log(LogStatus.INFO, "Verifying whether element is enabled/clickable");
			 String actualValue=Boolean.toString(getElement(locatorkey).isEnabled());
			 String expectedValue="true";
			
			 if(actualValue.equals(expectedValue))
				{
				reportPass(passm);
				}
			else
			{
					reportFailure(failm,asserttype);
			}
			
		}	 
		
			//**********************************************Wait**************************************
			 public void pageLoaderwait(String locatorkey)
			 {
			 	
			 	new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(getElement(locatorkey)));
			 	//wait(5000);
			 	new WebDriverWait(driver, 50).until(ExpectedConditions.invisibilityOf(getElement(locatorkey)));
			 	
			 	}
			 public void pageLoaderwaiting(String locatorkey)
			 {
			 	//WebDriverWait wait = new WebDriverWait(driver, 50);
			     //wait(500);
			 		//WebElement w = wait.until(ExpectedConditions.visibilityOf(getElement(locatorkey)));
			 	//WebDriverWait wait= new WebDriverWait(driver, 60);
			 	//WebElement w = (WebElement) wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(getElement(locatorkey)));
			 	//boolean element = wait.until(ExpectedConditions.invisibilityOf(getElement(locatorkey)));
			 	//new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(getElement(locatorkey)));
			 	new WebDriverWait(driver, 30).until(ExpectedConditions.invisibilityOf(getElement(locatorkey)));
			 	//new WebDriverWait(driver,30).until(ExpectedConditions.)
			 	}
			 //******************************explictwait**************************************
//			 public void explictwait(String locatorkey)
//			 {
//			 	//WebDriverWait wait = new WebDriverWait(driver, 50);
//			     //wait(500);
//			 		//WebElement w = wait.until(ExpectedConditions.visibilityOf(getElement(locatorkey)));
//			 	//WebDriverWait wait= new WebDriverWait(driver, 60);
//			 	//WebElement w = (WebElement) wait.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(getElement(locatorkey)));
//			 	//boolean element = wait.until(ExpectedConditions.invisibilityOf(getElement(locatorkey)));
//			 	//new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(getElement(locatorkey)));
//			 	new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(getElement(locatorkey)));
//			 	new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(getElement(locatorkey)));
//			 	//new WebDriverWait(driver,30).until(ExpectedConditions.)
//			 	}
			 
			 public void wait(int milliseconds)
				{
					try {
						Thread.sleep(milliseconds);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
		
}
