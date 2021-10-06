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

public class InboundwithoutPartitions extends AppActions {
	
	Xls_Reader xls;
	
	
	@Test(priority=1,dataProvider="InboundwithoutPartition")
	public void VerifyAppDis(Hashtable<String, String> data)
	{
		softAssert = new SoftAssert();
		//extentTest= extentReport.createTest("Test"); 
		String TestCaseName1="1)Verifying whether inboundapp is getting displayed under select app drop-down";
		test=  rep.startTest("1)Verifying whether inboundapp is getting displayed under select app drop-down");
		test.assignCategory("InboundwithoutPartitions");	
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
		type("typeapp_xpath", prop.getProperty("InboundwithoutpartitionAppName"));
			 verifyText("InboundSuiteA_appname_xpath", "InboundwithoutpartitionAppName","Able to search app","Unable to find the app","hardassert");
			wait(5000);
			 test.log(LogStatus.INFO, "Clicking on app");
				click("InboundSuiteA_appname_xpath");
			 
			 
			 softAssert.assertAll();
			 //driver.close();
			 //rep.endTest(test);
			 
	     }
	
	@Test(priority=2,dataProvider="InboundwithoutPartition",dependsOnMethods="VerifyAppDis")
	public void UploadTenInputfile(Hashtable<String, String> data) throws AWTException
	{
		softAssert = new SoftAssert();
		//extentTest= extentReport.createTest("Test"); 
		String TestCaseName1="2)Verifying whether user is able to upload excel input file";
		test=  rep.startTest("2)Verifying whether user is able to upload excel input file");
		test.assignCategory("InboundwithoutPartitions");	
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
			 verifyText("selectExcelTransformation_xpath", "excelTransformationName", "Transformation  is getting displayed", "Transformation  is not getting displayed", "hardassert");
			 test.log(LogStatus.INFO, "Selecting the transformation");
			 click("selectExcelTransformation_xpath");
			 test.log(LogStatus.INFO, "Verifying whether Choosse file option is getting displayed or not");
			 isElementPresent("clickChoosefile_xpath", "Choosse file option is getting displayed", "Choosse file option is not getting displayed", "hardassert");
			 test.log(LogStatus.INFO, "Clicking on choose file button");
			click("clickChoosefile_xpath");
			//wait(2000);
			test.log(LogStatus.INFO, "uplaoding file");
			 fileupload(prop.getProperty("Inboundwithoutpartitions_xlsx"));
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
	
	@Test(priority=3,dataProvider="InboundwithoutPartition",dependsOnMethods="UploadTenInputfile")
	public void verinstancestatus(Hashtable<String, String> data) throws Exception
	{
		softAssert = new SoftAssert();
		//extentTest= extentReport.createTest("Test"); 
		String TestCaseName1="3)Verifying whether excel upload instance is completed or not";
		test=  rep.startTest("3)Verifying whether excel upload instance is completed or not");
		test.assignCategory("InboundwithoutPartitions");	
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
 test.log(LogStatus.INFO, "Clicking on view processes button");
    click("viewprocess_xpath");
    navigateinsiderequest();
    pageLoaderwait("PageLoader_xpath");
    test.log(LogStatus.INFO, "Verifying whether all processes page is displaying or not");
    verifyTextinPage("All Processes", "ALL Processes page is getting displayed", "ALL Processes page is not getting displayed", "hard");
    wait(1000);
    test.log(LogStatus.INFO, "Verifying instance status");
    verifyTextinPage("Rules Execution successful", "Status is displaying as 'Rules Execution successful'", "Status is not displaying as 'Rules Execution successful'", "hard");
    
    test.log(LogStatus.INFO, "Clicking on view process button");
    click("viewProcessButton_xpath");
    pageLoaderwait("PageLoader_xpath");
    test.log(LogStatus.INFO, "Verifying whether processing screen is displaying or not");
    verifyTextinPage("Create New","Processing screen is displaying", "Processing screen is not displaying", "hardassert");
    test.log(LogStatus.INFO, "Clicking on non-primary entity");
    click("entity2_xpath");
    pageLoaderwait("PageLoader_xpath");
    test.log(LogStatus.INFO, "Verifying whether entity details are displaying or not");
    verifyTextinPage("Actions","entity details are displaying", "entity details are not displaying", "hardassert");
    test.log(LogStatus.INFO, "Clicking on Actions button");
    click("entityMenu_xpath");
    test.log(LogStatus.INFO, "Verifying whether Actions menu drop-down is displaying or not");
    verifyTextinPage("Apply","Actions menu drop-down is displaying", "Actions menu drop-down is not displaying", "hardassert");
    
    
    test.log(LogStatus.INFO, "Clicking on Select All button");
    click("selectAll_xpath");
    test.log(LogStatus.INFO, "Clicking on Apply button");
    click("apply_xpath");
    
    readExcelData();
    /*xml*/
    test.log(LogStatus.INFO, "Clicking on Create new button");
    click("CreateNew_xpath");
    pageLoaderwait("PageLoader_xpath");
    
    test.log(LogStatus.INFO, "Verifying whether Initiate procress screen is getting displayed or not");
	 verifyText("InitiateProcess_xpath", "InitiateProcess", "Initiate procress screen is getting displayed", "Initiate procress screen is not getting displayed", "hardassert");
	 //verifyTextinPage("", passm, failm, asserttype);
	 test.log(LogStatus.INFO, "Verifying whether Select Transfromation drop-down is getting displayed or not");
	 isElementPresent("clickTransformation_xpath", "Select Transfromation drop-down is getting displayed", "Select Transfromation drop-down is getting displayed", "hardassert");
	 click("clickTransformation_xpath");
	 test.log(LogStatus.INFO, "Verifying whether Transfromation is getting displayed or not");
	 verifyText("selectXmlTransformation_xpath", "excelTransformationName", "Transformation  is getting displayed", "Transformation  is not getting displayed", "hardassert");
	 test.log(LogStatus.INFO, "Selecting the transformation");
	 click("selectXmlTransformation_xpath");
	 test.log(LogStatus.INFO, "Verifying whether Choosse file option is getting displayed or not");
	 isElementPresent("clickChoosefile_xpath", "Choosse file option is getting displayed", "Choosse file option is not getting displayed", "hardassert");
	 test.log(LogStatus.INFO, "Clicking on choose file button");
	click("clickChoosefile_xpath");
	//wait(2000);
	test.log(LogStatus.INFO, "uplaoding file");
	fileupload(prop.getProperty("Inboundwithoutpartitions_xml"));
	 pageLoaderwait("PageLoader_xpath");
	// test.log(LogStatus.INFO, "Clicking on view related inbound transimmissons page");
       //click("viewinboundtransmissions_xpath");
       //pageLoaderwait("PageLoader_xpath");
	 test.log(LogStatus.INFO, "Verifying whether notification page is getting displayed or not");
	 verifyTextinPage("Notifications ","Notifications page is getting displayed", "Notifications page is not getting displayed", "hard");
	 test.log(LogStatus.INFO, "Click on notification close button");
	 click("notificationclosebutton_xpath");
	 wait(1000);
	 test.log(LogStatus.INFO, "Clicking on view processes button");
	    click("viewprocess_xpath");
	    navigateinsiderequest();
	    pageLoaderwait("PageLoader_xpath");
	    test.log(LogStatus.INFO, "Verifying whether all processes page is displaying or not");
	    verifyTextinPage("All Processes", "ALL Processes page is getting displayed", "ALL Processes page is not getting displayed", "hard");
	    wait(1000);
	    test.log(LogStatus.INFO, "Verifying instance status");
	    verifyTextinPage("Rules Execution successful", "Status is displaying as 'Rules Execution successful'", "Status is not displaying as 'Rules Execution successful'", "hard");
	    
	    test.log(LogStatus.INFO, "Clicking on view process button");
	    click("viewProcessButton_xpath");
	    pageLoaderwait("PageLoader_xpath");
	    test.log(LogStatus.INFO, "Verifying whether processing screen is displaying or not");
	    verifyTextinPage("Create New","Processing screen is displaying", "Processing screen is not displaying", "hardassert");
	    test.log(LogStatus.INFO, "Clicking on non-primary entity");
	    click("entity2_xpath");
	    pageLoaderwait("PageLoader_xpath");
	    test.log(LogStatus.INFO, "Verifying whether entity details are displaying or not");
	    verifyTextinPage("Actions","entity details are displaying", "entity details are not displaying", "hardassert");
	    test.log(LogStatus.INFO, "Clicking on Actions button");
	    click("entityMenu_xpath");
	    test.log(LogStatus.INFO, "Verifying whether Actions menu drop-down is displaying or not");
	    verifyTextinPage("Apply","Actions menu drop-down is displaying", "Actions menu drop-down is not displaying", "hardassert");
	    test.log(LogStatus.INFO, "Clicking on Select All button");
	    click("selectAll_xpath");
	    test.log(LogStatus.INFO, "Clicking on Apply button");
	    click("apply_xpath");
	    readXMLData();
	    
    
    softAssert.assertAll();
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
				public Object[][] InboundwithoutPartition()
				{
					super.init();
					xls =new Xls_Reader("/home/aknandigam/workspace/TaxillaProjectFeb/src/project/resources/TestData.xlsx");
					return DataUtil.getTestData(xls, "TenantBasedPartition");
				}

	}


