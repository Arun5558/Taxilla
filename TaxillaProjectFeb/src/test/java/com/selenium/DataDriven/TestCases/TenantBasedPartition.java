package com.selenium.DataDriven.TestCases;


import java.awt.AWTException;
import java.nio.channels.ClosedByInterruptException;
import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.DataDriven.Base.BaseClass;
import com.selenium.DataDriven.Functions.AppActions;
import com.selenium.DataDriven.Util.DataUtil;
import com.selenium.DataDriven.Util.Xls_Reader;
	//import com.sun.xml.internal.ws.Closeable;

	public class TenantBasedPartition  extends AppActions
	{


			Xls_Reader xls;
			
		
			//String testName= "TestA";
			
			@Test(priority=1,dataProvider="TenantBasedPartition1")
			public void VerifyAppDis(Hashtable<String, String> data)
			{
				softAssert = new SoftAssert();
				//extentTest= extentReport.createTest("Test"); 
				String TestCaseName1="1)Verifying whether app is getting displayed under select app drop-down";
				test=  rep.startTest("1)Verifying whether app is getting displayed under select app drop-down");
				test.assignCategory("TenantBasedPartitioning");	
				//rep.
				//rep.st
				
				test.log(LogStatus.INFO, "Start the test");
				test.log(LogStatus.INFO, data.toString());
				
				//System.out.println(data.get("Runmode"));
				
				if(!DataUtil.isRunnable(TestCaseName1, xls) || data.get("Runmode").equals("N"))
				{
					test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
					throw new SkipException("Test case is skipped as Runmode is N");
				}
				super.init();
				openBrowser(data.get("Browser"));
				//test.log(LogStatus.INFO, "Browser has oppened");
				
				navigateURL("AppURl");
				//test.log(LogStatus.INFO, "URL has oppened");
				dologin(data.get("CustomerName"), data.get("CustomerPassword"),"First level Login is succesfull","First level Login is not succesfull","hardassert");
			     
				entSecAnswers(data.get("SecurityAnswer1"),data.get("SecurityAnswer2"),"Login succesfully","Login unsuccesfully","hardassert");
			     
					
					 pageLoaderwait("PageLoader_xpath");
					 test.log(LogStatus.INFO, "Verifying Page Title");
					 verifyTitle("pageTitle", "softassert");
					 click("orgapp_xpath");
					 
				isEnabled("typeapp_xpath","AppSearch text box is enabled","AppSearch text box is not enabled","hardassert");
				type("typeapp_xpath", prop.getProperty("TenAppName"));
					 verifyText("appname_xpath", "TenAppName","Able to search app","Unable to find the app","hardassert");
					wait(5000);
					 test.log(LogStatus.INFO, "Clicking on app");
						click("appname_xpath");
					 
					 
					 softAssert.assertAll();
					 //driver.close();
					 //rep.endTest(test);
					 
			     }
			
			@Test(priority=2,dataProvider="TenantBasedPartition1",dependsOnMethods="VerifyAppDis")
			public void UploadTenInputfile(Hashtable<String, String> data) throws AWTException
			{
				softAssert = new SoftAssert();
				//extentTest= extentReport.createTest("Test"); 
				String TestCaseName1="2)Verifying whether user is able to uploaf tenant based input file";
				test=  rep.startTest("2)Verifying whether user is able to uploaf tenant based input file");
				test.assignCategory("TenantBasedPartitioning");	
				//rep.
				//rep.st
				
				test.log(LogStatus.INFO, "Start the test");
				test.log(LogStatus.INFO, data.toString());
				
				//System.out.println(data.get("Runmode"));
				
				if(!DataUtil.isRunnable(TestCaseName1, xls) || data.get("Runmode").equals("N"))
				{
					test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
					throw new SkipException("Test case is skipped as Runmode is N");
				}
				super.init();
				//openBrowser(data.get("Browser"));
				//test.log(LogStatus.INFO, "Browser has oppened");
				
				//navigateURL("AppURl");
				//test.log(LogStatus.INFO, "URL has oppened");
				//dologin(data.get("CustomerName"), data.get("CustomerPassword"),"First level Login is succesfull","First level Login is not succesfull","hardassert");
			     
				//entSecAnswers(data.get("SecurityAnswer1"),data.get("SecurityAnswer2"),"Login succesfully","Login unsuccesfully","hardassert");
			     
				
					 pageLoaderwait("PageLoader_xpath");
					 test.log(LogStatus.INFO, "Verifying whether process now button is getting displayed or not");
					 verifyText("processnow_xpath", "processnow", "Process now button is getting displayed","Process Now button is not getting displayed","hardassert");
					 test.log(LogStatus.INFO, "Clicking in Process now button");
					 click("processnow_xpath");
					 pageLoaderwait("PageLoader_xpath");
					 test.log(LogStatus.INFO, "Verifying whether Initiate procress screen is getting displayed or not");
					 verifyText("InitiateProcess_xpath", "InitiateProcess", "Initiate procress screen is getting displayed", "Initiate procress screen is not getting displayed", "hardassert");
					 //verifyTextinPage("", passm, failm, asserttype);
					 test.log(LogStatus.INFO, "Verifying whether Select Transfromation drop-down is getting displayed or not");
					 isElementPresent("clickTransformation_xpath", "Select Transfromation drop-down is getting displayed", "Select Transfromation drop-down is getting displayed", "hardassert");
					 click("clickTransformation_xpath");
					 test.log(LogStatus.INFO, "Verifying whether Transfromation is getting displayed or not");
					 verifyText("selectTransformation_xpath", "selectTransformation", "Transformation  is getting displayed", "Transformation  is not getting displayed", "hardassert");
					 test.log(LogStatus.INFO, "Selecting the transformation");
					 click("selectTransformation_xpath");
					 test.log(LogStatus.INFO, "Verifying whether Choosse file option is getting displayed or not");
					 isElementPresent("clickChoosefile_xpath", "Choosse file option is getting displayed", "Choosse file option is not getting displayed", "hardassert");
					 test.log(LogStatus.INFO, "Clicking on choose file button");
					click("clickChoosefile_xpath");
					//wait(2000);
					test.log(LogStatus.INFO, "uplaoding file");
					 fileupload("/home/aknandigam/workspace/TaxillaProjectFeb/Inputfiles/Tenant/inbound.xlsx");
					 pageLoaderwait("PageLoader_xpath");
					// test.log(LogStatus.INFO, "Clicking on view related inbound transimmissons page");
				        //click("viewinboundtransmissions_xpath");
				        //pageLoaderwait("PageLoader_xpath");
					 test.log(LogStatus.INFO, "Verifying whether notification page is getting displayed or not");
					 verifyTextinPage("Notifications ","Notifications page is getting displayed", "Notifications page is not getting displayed", "hard");
					 test.log(LogStatus.INFO, "Click on notification close button");
					 click("notificationclosebutton_xpath");
				        softAssert.assertAll();
				        
			}
				        

						@Test(priority=3,dataProvider="TenantBasedPartition1",dependsOnMethods="UploadTenInputfile")
						public void verinstancestatus(Hashtable<String, String> data) throws AWTException
						{
							softAssert = new SoftAssert();
							//extentTest= extentReport.createTest("Test"); 
							String TestCaseName1="3)Verifying whether instance is completed or not";
							test=  rep.startTest("3)Verifying whether instance is completed or not");
							test.assignCategory("TenantBasedPartitioning");	
							//rep.
							//rep.st
							
							test.log(LogStatus.INFO, "Start the test");
							test.log(LogStatus.INFO, data.toString());
							
							//System.out.println(data.get("Runmode"));
							
							if(!DataUtil.isRunnable(TestCaseName1, xls) || data.get("Runmode").equals("N"))
							{
								test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
								throw new SkipException("Test case is skipped as Runmode is N");
							}
							super.init();			        
				        
				        wait(1000);
					 test.log(LogStatus.INFO, "Clicking on view process");
				        click("viewprocess_xpath");
				        navigateinsiderequest();
				        pageLoaderwait("PageLoader_xpath");
				        test.log(LogStatus.INFO, "Verifying whether all processes page is displaying or not");
				        verifyTextinPage("All Processes", "ALL Processes page is getting displayed", "ALL Processes page is not getting displayed", "hard");
				        wait(1000);
				        test.log(LogStatus.INFO, "Verifying instance status");
				        verifyTextinPage("Rules Execution successful", "Status is displaying as 'Rules Execution successful'", "Status is not displaying as 'Rules Execution successful'", "hard");
				        softAssert.assertAll();
						}
				        
				        @Test(priority=4,dataProvider="TenantBasedPartition1",dependsOnMethods="verinstancestatus")
						public void versrcbiskey(Hashtable<String, String> data) throws AWTException
						{
							softAssert = new SoftAssert();
							//extentTest= extentReport.createTest("Test"); 
							String TestCaseName1="4)Verifying whether source business key got created or not";
							test=  rep.startTest("4)Verifying whether source business key got created or not");
							test.assignCategory("TenantBasedPartitioning");	
							//rep.
							//rep.st
							
							test.log(LogStatus.INFO, "Start the test");
							test.log(LogStatus.INFO, data.toString());
							
							//System.out.println(data.get("Runmode"));
							
							if(!DataUtil.isRunnable(TestCaseName1, xls) || data.get("Runmode").equals("N"))
							{
								test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
								throw new SkipException("Test case is skipped as Runmode is N");
							}
							super.init();		        
				        
				        
				        test.log(LogStatus.INFO, "Verifying data is present in primary entity business key field");
				        getsoubiskey("srcprimaryData_xpath", "Businesky Data is present", "Businesky Data is not present", "hard");
				        softAssert.assertAll();
						}	        
				        
				        @Test(priority=5,dataProvider="TenantBasedPartition1",dependsOnMethods="versrcbiskey")
						public void versrcevntdet(Hashtable<String, String> data) throws AWTException
						{
							softAssert = new SoftAssert();
							//extentTest= extentReport.createTest("Test"); 
							String TestCaseName1="5)Verifying whether event trigger notification got generated at source asset or not";
							test=  rep.startTest("5)Verifying whether event trigger notification got generated at source asset or not");
							test.assignCategory("TenantBasedPartitioning");	
							//rep.
							//rep.st
							
							test.log(LogStatus.INFO, "Start the test");
							test.log(LogStatus.INFO, data.toString());
							
							//System.out.println(data.get("Runmode"));
							
							if(!DataUtil.isRunnable(TestCaseName1, xls) || data.get("Runmode").equals("N"))
							{
								test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
								throw new SkipException("Test case is skipped as Runmode is N");
							}
							super.init();        
				        test.log(LogStatus.INFO, "Click on notifications at instance level");
				        click("srcNotifications_xpath");
				        pageLoaderwait("PageLoader_xpath");
				        test.log(LogStatus.INFO, "Verifying whether notifications page is displaying or not");
				        verifyTextinPage("Notifications", "Notifications page is displaying", "Notifications page is not displaying", "soft");
				        wait(1000);
				        test.log(LogStatus.INFO, "Click on refresh button");
				        click("refreshbutton_xpath");
				        pageLoaderwait("PageLoader_xpath");
				        test.log(LogStatus.INFO, "Validating event type");
				        verifyText("eventtype_xpath", "ExpectedeventType", "Event type is displaying as expected", "Event type is not displaying as expected", "hard");
				        test.log(LogStatus.INFO, "Validating event type deatils");
				        verifyText("details_xpath", "ExpectedeventDetails", "Event type deatils are displaying as expected", "Event type deatils are not displaying as expected", "hard");
				        softAssert.assertAll();
						} 
				        
				        @Test(priority=6,dataProvider="TenantBasedPartition1",dependsOnMethods="versrcevntdet")
						public void verswitchtoLoc(Hashtable<String, String> data) throws AWTException
						{
							softAssert = new SoftAssert();
							//extentTest= extentReport.createTest("Test"); 
							String TestCaseName1="6)Verifying whether user is able to switch to location or not";
							test=  rep.startTest("6)Verifying whether user is able to switch to location or not");
							test.assignCategory("TenantBasedPartitioning");	
							//rep.
							//rep.st
							
							test.log(LogStatus.INFO, "Start the test");
							test.log(LogStatus.INFO, data.toString());
							
							//System.out.println(data.get("Runmode"));
							
							if(!DataUtil.isRunnable(TestCaseName1, xls) || data.get("Runmode").equals("N"))
							{
								test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
								throw new SkipException("Test case is skipped as Runmode is N");
							}
							super.init();    
				        test.log(LogStatus.INFO, "Click on App tenant drop-down");
				        click("clickorg_xpath");
				        test.log(LogStatus.INFO, "Click on location in app tenantdrop-down ");
				        click("selectlocation_xpath");
				        pageLoaderwait("PageLoader_xpath");
				        test.log(LogStatus.INFO, "Verifying whether location has been switched succesfuly or not");
                      verifyTextinPage("dmartorg  |  dmartlocation1", "Loction swicthed succesfully", "Loction swicthed not succesfully", "hard");
                      softAssert.assertAll();
						}

				        @Test(priority=7,dataProvider="TenantBasedPartition1",dependsOnMethods="verswitchtoLoc")
						public void verrequestTargApp(Hashtable<String, String> data) throws AWTException
						{
							softAssert = new SoftAssert();
							//extentTest= extentReport.createTest("Test"); 
							String TestCaseName1="7)Verifying whether request got created in Target asset at location level WRT source asset business key";
							test=  rep.startTest("7)Verifying whether request got created in Target asset at location level WRT source asset business key");
							test.assignCategory("TenantBasedPartitioning");	
							//rep.
							//rep.st
							
							test.log(LogStatus.INFO, "Start the test");
							test.log(LogStatus.INFO, data.toString());
							
							//System.out.println(data.get("Runmode"));
							
							if(!DataUtil.isRunnable(TestCaseName1, xls) || data.get("Runmode").equals("N"))
							{
								test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
								throw new SkipException("Test case is skipped as Runmode is N");
							}
							super.init();    

test.log(LogStatus.INFO, "Click on App tenant drop-down");
click("locapp_xpath");
test.log(LogStatus.INFO, "typing app name");
type("typelocapp_xpath", "Tenant_Asset_Src");
test.log(LogStatus.INFO, "Verify whether app is displaying or not");
verifyText("appname_xpath", "AppName", "App is displaying", "App is not displaying", "hard");
test.log(LogStatus.INFO, "Click on app in app drop-down");
click("locappname_xpath");
pageLoaderwait("PageLoader_xpath");
test.log(LogStatus.INFO, "Clicking on view related inbound transimmissons page");
click("viewinboundtransmissions_xpath");
pageLoaderwait("PageLoader_xpath");
wait(1000);
test.log(LogStatus.INFO, "Verifying whether inbound transimmison page is displaying or not");
verifyTextinPage("All Inbound Transmissions", "Inbound Transmision page is displaying", "Inbound Transmision page is not displaying", "soft");
test.log(LogStatus.INFO, "Clicking on view process");
click("viewprocess_xpath");
navigateinsiderequest();
pageLoaderwait("PageLoader_xpath");
test.log(LogStatus.INFO, "Verifying whether all processes page is displaying or not");
verifyTextinPage("All Processes", "ALL Processes page is getting displayed", "ALL Processes page is not getting displayed", "hard");
wait(1000);
test.log(LogStatus.INFO, "Validating source business key and target business key");
validatetargbiskey("trgPrimaryData_xpath", "Source & target bussiness keys are equal", "Source & target bussiness keys are not equal", "hard");

					 //type("clickChoosefile_xpath", "/home/aknandigam/workspace/TaxillaProjectFeb/Inputfiles/inbound.xlsx");
					 //wait(5000);
					 //test.log(LogStatus.INFO, "Selecting the transformation");
					 //click("selectTransformation_xpath");
					 //test.log(LogStatus.INFO, "click iniate");
					// click("initiateprocess_xpath");
					 
					 
					 
					
					
					 
					 
					 
					 softAssert.assertAll();
					 driver.close();
					 //rep.endTest(test);
					 
			     }		
			
			
			
			@AfterMethod
			  public void endtest()
			  {
				  rep.endTest(test); 
			  }
					 
					 @BeforeTest
						public void init()
						{
							//softAssert  = new SoftAssert();
							
							
						}
						@AfterTest
						public void quit()
						{
						
							 //softAssert.assertAll();	
						
						if(rep!=null){
							//rep.endTest(test);
							rep.flush();
					
						}
							if(driver!=null)
							driver.quit();
						
						}
						@DataProvider
						public Object[][] TenantBasedPartition1()
						{
							super.init();
							xls =new Xls_Reader("/home/aknandigam/workspace/TaxillaProjectFeb/src/project/resources/TestData.xlsx");
							return DataUtil.getTestData(xls, "TenantBasedPartition");
						}

			}
	
