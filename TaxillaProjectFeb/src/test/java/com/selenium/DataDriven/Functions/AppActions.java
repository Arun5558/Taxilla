package com.selenium.DataDriven.Functions;
import static org.testng.Assert.fail;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.io.File;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import jdk.internal.org.xml.sax.SAXException;
import jdk.nashorn.internal.scripts.JS;

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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.DataDriven.Base.BaseClass;
import com.selenium.DataDriven.Util.Xls_Reader;


public class AppActions extends GenericActions {
//public  ExtentTest test;
	 String srcbiskey1=null;
	private List<String> WebTableList = new ArrayList<String>();
	private List<String> InputFileList = new ArrayList<String>();
	//**********************************Doing first level login and verifying whether it is successful or not****************************
	
	public boolean dologin(String username,String password,String passm,String failm,String asserttype) 
	{
		test.log(LogStatus.INFO, "Trying to login"+":" +username+ "," +password );
		//takeScreenShot();
		type("UserId_xpath", username);
		type("Password_xpath", password);
		//wait(1000);
		click("SignInButton_xpath");
		
		//wait(1200);
		//driver.wait(5);
		
		boolean Firstloginstatus=isElementPresent("SignInSuccesscheck_xpath",passm,failm,asserttype);
			
			wait(1000);
			takeScreenShot();
		
		return Firstloginstatus;
	}
//***********************Locking the user account by enter wrong login details for 5 times and verify whether proper message is cming or not***********************
	public void VerifyAccountLocking(String username,String password,String assertype) 
	{
		test.log(LogStatus.INFO, "Trying to login with wrong password"+":" +username+ "," +password );
		//wait(2000);
		//waitForPageToLoad();
		type("UserId_xpath", username);
		type("Password_xpath", password);
		
	for(int i=1;i<=5;i++){
		click("SignInButton_xpath");
		//wait(500);
	}
	
		//wait(2000);
		
		if (driver.getPageSource().contains("Your account is temporarily locked. Please contact Admin to unlock your Account."))
		{
			
			reportPass("User Account locked after 5 wrong attemts");
			
		}else
		{
			
			reportFailure("User Account is not locked after 5 wrong attemts",assertype);
		}
		
	}
			
		
		
	public void entSecAnswers(String answ1,String answ2,String passm,String failm,String assertype) 
	{
		test.log(LogStatus.INFO, "Trying to enter security answers"+":" +answ1+ "," +answ2 );
		//wait(2000);
		//waitForPageToLoad();
		//takeScreenShot();
		type("SecurityAnswer1_xpath", answ1);
		type("SecurityAnswer2_xpath", answ2);
		click("Submitbutton_xpath");
		//pageLoaderwait("PageLoader_xpath");
		//wait(500);
		//driver.manage().
		//driver.wait(5);
		
		
		isElementPresent("SignInhomepageSuccesscheck_xpath",passm,failm,assertype);
	}

	//******************************VerifyTitle of the page***************************************
			public void verifyTitle(String text,String assertype)
			{
				String ActualText= driver.getTitle();
				String ExpectedText= prop.getProperty(text);
				if(ActualText.equals(ExpectedText))
				{
				reportPass("Title is matching the expected page tile");
				}
			else
			{
					reportFailure("Title is not matching the expected page tile",assertype);
			}
}
			
			public boolean isElementnotPresent(String locatorkey,String passm,String failm,String asserttype)
			{
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
				reportPass(passm);
				
				return false;
				}
			
			else
			{
				reportFailure(failm,asserttype);
				return true;
			}
				
			}
			
			//*******************************************File Upload********************************************8
			public void fileupload(String filepath) throws AWTException 
			
		
			{
				Actions ac = new Actions(driver);
				//ac.click(driver.findElement(By.xpath("//span[contains(text(),'Choose File')]"))).build().perform();
				
				//click("clickChoosefile_xpath");
				wait(2000);
				 //String Parent_Window =driver.getWindowHandle();
				 
				 
				//System.out.println(filepath);
				Robot rb = new Robot();
				
				// System.out.println("abc");
			    // copying File path to Clipboard
				 String filepath1=filepath;
			    StringSelection str = new StringSelection(filepath1);
			   // System.out.println(str);
			    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
			    //System.out.println("bcv");
			     // press Contol+V for pasting
			     rb.keyPress(KeyEvent.VK_CONTROL);
			     rb.keyPress(KeyEvent.VK_V);
			 
			    // release Contol+V for pasting
			    rb.keyRelease(KeyEvent.VK_CONTROL);
			    rb.keyRelease(KeyEvent.VK_V);
			 
			    // for pressing and releasing Enter
			    rb.keyPress(KeyEvent.VK_ENTER);
			    rb.keyRelease(KeyEvent.VK_ENTER);
			    
			    //rb.delay(2000);
			    
			    wait(2000);
			    test.log(LogStatus.INFO, "Clicking on Initiate button");
			   jsclick("initiateprocess_xpath");
			    //ac.click(getElement("initiateprocess_xpath")).build().perform();
			    
			    //test.log(LogStatus.INFO, "Clicking on Initiate process");
				//click("initiateprocess_xpath");
				 
			   // ac.click(driver.findElement(By.xpath("//span[contains(text(),'Select Transformation')]"))).build().perform();
			   // driver.findElement(By.xpath("//span[contains(text(),'Select Transformation')]")).click();
			   // driver.findElement(By.xpath("//span[contains(text(),'Select Transformation')]")).click();
			    
			  //driver.switchTo().parentFrame();
			 // driver.switchTo().activeElement();
			  
			  
			    
			    //rb.delay(5000);
			    
			    //rb.keyPress(KeyEvent.VK_ENTER);
			   // rb.keyRelease(KeyEvent.VK_ENTER);
			    
			    //rb.keyRelease(KeyEvent.VK_ENTER);
			    //driver.switchTo().defaultContent();
			    
			    //String parent = driver.getWindowHandle();
			    
			   // driver.switchTo().window(parent);
			    
			    //rb.keyRelease(KeyEvent.VK_CONTROL);
			   // rb.keyRelease(KeyEvent.VK_V);
			    
			    //rb.keyPress(KeyEvent.VK_ENTER);
			    //rb.keyRelease(KeyEvent.VK_ENTER);
			    
			    //rb.mousePress(InputEvent.BUTTON1_MASK);
			    //rb.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}
			   
			 //*******************************************Navigating inside the request********************************************
			   
			   public void navigateinsiderequest()
			   
			   {
				   int i;
				   for(i=0;i<=100;i++)
				   {
					   if (driver.getPageSource().contains("All Processes"))
					   {
						   break;
					   }
					   else
					   {
						   wait(5000);
						   click("viewprocess_xpath");
					   }
				   } 
			   }
			   public boolean getsoubiskey(String locatorkey,String passm,String failm,String asserttype)
				{
					   String srcbiskey= getElement(locatorkey).getText().trim();
					   srcbiskey1=srcbiskey;
					 System.out.println(srcbiskey);
					//String ExpectedText= prop.getProperty(text);
					if(srcbiskey!=null)
					{
					reportPass(passm);
					return true;
					
					}
				else{
			
						reportFailure(failm,asserttype);
					
					return false;
				}
					
				}
			   
			   public boolean validatetargbiskey(String locatorkey,String passm,String failm,String asserttype)
				{
				  // getsoubiskey();
				   System.out.println(srcbiskey1);
					String tarbiskey= getElement(locatorkey).getText().trim();
					System.out.println(tarbiskey);
					//String ExpectedText= prop.getProperty(text);
					if(srcbiskey1.equals(tarbiskey))
					{
					reportPass(passm);
					return true;
					
					}
				else{
			
						reportFailure(failm,asserttype);
					
					return false;
				}
					
				}
			   
			   
			   public void readExcelData() throws Exception
				{
					
					InputFileList.clear();
					//System.out.println("Read Data from Excel File");	
					//System.out.println(prop.getProperty(testName+"_xlsx"));		
					//xls =new Xls_Reader("/home/aknandigam/workspace/TaxillaProjectFeb/src/project/resources/TestData.xlsx");
					Xls_Reader  excelInputData=new Xls_Reader(prop.getProperty("Inboundwithoutpartitions_xlsx"));		
					
					
					int excelRows = excelInputData.getRowCount(prop.getProperty("xlsx_PersonalInformation"));
					System.out.println("Rows :" + excelRows);
					int excelCols = excelInputData.getColumnCount(prop.getProperty("xlsx_PersonalInformation"));
					System.out.println("Columns :" + excelCols);
					
					for(int rNum=1;rNum<=excelRows;rNum++)
					{
						for(int cNum=0;cNum<excelCols;cNum++) 
						{
						String personal = excelInputData.getCellData(prop.getProperty("xlsx_PersonalInformation"),cNum,rNum);
						System.out.println(personal);
						
						InputFileList.add(personal);
						
						}
					}
					
				}   
			   public void readXMLData() throws ParserConfigurationException,IOException, org.xml.sax.SAXException 
				{
					InputFileList.clear();
					DocumentBuilderFactory dBfactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = dBfactory.newDocumentBuilder();
					// Fetch XML File
					Document document = builder.parse(new File(prop.getProperty("Inboundwithoutpartitions_xml")));
					//Document document = builder.parse(new File("C:\\Users\\user\\eclipse-workspace\\TaxillaSuite\\InputFile\\InboundTestSuiteA_InputFiles\\xml_asset.xml"));
					document.getDocumentElement().normalize();
					//Get root node
					Element root = document.getDocumentElement();
					NodeList nList = document.getElementsByTagName("entity2");
					//List<String> StrList3 = new ArrayList<String>();
					for (int i = 0; i < nList.getLength(); i++)
					{
						Node node = nList.item(i);
						System.out.println();    //Just a separator
						if (node.getNodeType() == Node.ELEMENT_NODE)
						{
							
							Element element = (Element) node;
							
							//System.out.println("field1 : "  + element.getElementsByTagName("f1").item(0).getTextContent());
							//System.out.println("field2 : "   + element.getElementsByTagName("f2").item(0).getTextContent());
							
							//str3[j++]=element.getElementsByTagName("f1").item(0).getTextContent();
							//str3[j++]=element.getElementsByTagName("f2").item(0).getTextContent();
							
							InputFileList.add(element.getElementsByTagName("f1").item(0).getTextContent());
							InputFileList.add(element.getElementsByTagName("f2").item(0).getTextContent());
							InputFileList.add(element.getElementsByTagName("f3").item(0).getTextContent());
							 
							
						}
						
					}
					 System.out.println(InputFileList);		
					
					
				}	  
			
}
