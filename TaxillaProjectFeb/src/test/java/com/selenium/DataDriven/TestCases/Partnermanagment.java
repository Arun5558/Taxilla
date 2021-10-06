package com.selenium.DataDriven.TestCases;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.DataDriven.Base.BaseClass;
import com.selenium.DataDriven.Functions.AppActions;
import com.selenium.DataDriven.Functions.GenericActions;
import com.selenium.DataDriven.Util.DataUtil;
import com.selenium.DataDriven.Util.Xls_Reader;
//import com.sun.xml.internal.ws.Closeable;





public class Partnermanagment extends AppActions {
	//public ExtentTest test;

	//public ExtentTest test;
		Xls_Reader xls;
		
//		@BeforeTest
//		public void testa()
//		{
//			test=  rep.startTest("Partner Manegement TestCases");
//			
//			
//			
//			}
//		@AfterClass
//		public void testb()
//		{
//			test1.log(LogStatus.PASS, "abc");
//			if(rep!=null){
//				rep.endTest(test1);
//				//rep.endTest(test);
//				rep.flush();
//				
//			}
//			}
		
		
		//String testName= "TestA";
		//test=  rep.
		@Test(priority=1,dataProvider="LoginTest")
		public void PartnerMangMenu(Hashtable<String, String> data)
		{
			//public static ExtentTest test;
			
			//extentTest= extentReport.createTest("Test"); 
			String TestCaseName1="1)Verifying Partner Management Menuitem is Displaying or not";
			test=rep.startTest("1)Verifying Partner Management Menuitem is Displaying or not");
			//test=rep.
					test.assignCategory("PartnerMangement");
			//String testCategory="PartnerMangement";
					
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
		   //  boolean l= dologin(data.get("Username"), data.get("Password"));
		  dologin(data.get("Username"), data.get("Password"),"First level Login is succesfull","First level Login is not succesfull","hardassert");
		     
				entSecAnswers(data.get("Security_Ans1"),data.get("Security_Ans2"),"Login succesfully","Login unsuccesfully","hardassert");
				//wait(300);
				 pageLoaderwait("PageLoader_xpath");
		     
		     test.log(LogStatus.INFO, "Checking whether PartnerManagment menu item is displaying or not");
		     
		   verifyTextinPage("Partner Management", "PartnerManagment menu item is displaying", "PartnerManagment menu item is not displaying","hardassert");
		   //rep.endTest(test);
		     }
		    // softAssert.assertAll();
		
				
				
				@Test(priority=2,dataProvider="LoginTest",dependsOnMethods="PartnerMangMenu")
				public void PartneDeatilsPage(Hashtable<String, String> data)
				{
				String TestCaseName2="2)Verifying whether all the menu items are displaying in Partner details page or not";
				test=rep.startTest("2)Verifying whether all the menu items are displaying in Partner details page or not");
				//rep.
				//rep.st
				test.assignCategory("PartnerMangement");
				//String testCategory="PartnerMangement";
				test.log(LogStatus.INFO, "Start the test");
				test.log(LogStatus.INFO, data.toString());
				
				
				//System.out.println(data.get("Runmode"));
				if(!DataUtil.isRunnable(TestCaseName2, xls) || data.get("Runmode").equals("N"))
				{
					test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
					throw new SkipException("Test case is skipped as Runmode is N");
				}
				super.init();
				pageLoaderwaiting("PageLoader_xpath");
				test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
				
			     click("PartnerMangement_xpath");
			     pageLoaderwait("PageLoader_xpath");
			     //wait(2000);
			     test.log(LogStatus.INFO, "Verifying Partner details Page");
			     verifyText("AssociatePartner_xpath", "AssociatePartner","AssociatePartner menu item is displaying","AssociatePartner menu item is not displaying","hardassert");
							
			
							verifyText("ManagePartner_xpath", "ManagePartner","ManagePartner menu item is displaying","ManagePartner menu item is not displaying","hardassert");
							isElementPresent("AddPartner_xpath", " Add Partner button are displaying", "AddPartner button is not displaying","hardassert");
								
							//rep.endTest(test);
							//softAssert.assertAll();
				}
							
				@Test(priority=3,dataProvider="LoginTest",dependsOnMethods="PartneDeatilsPage")
				public void NonServiceProvider(Hashtable<String, String> data)
				{
					softAssert = new SoftAssert();
				String TestCaseName3="3)Verifying whether Non Service provider organization is getting displayed under Associate Partners";
				test=  rep.startTest("3)Verifying whether Non Service provider organization is getting displayed under Associate Partners");
				//rep.
				//rep.st
				//VerifyPartnerAssociation(data);
				test.assignCategory("PartnerMangement");
				test.log(LogStatus.INFO, "Start the test");
				test.log(LogStatus.INFO, data.toString());
				
				
				//System.out.println(data.get("Runmode"));
				if(!DataUtil.isRunnable(TestCaseName3, xls) || data.get("Runmode").equals("N"))
				{
					test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
					throw new SkipException("Test case is skipped as Runmode is N");
				}
				super.init();
				pageLoaderwaiting("PageLoader_xpath");
				test.log(LogStatus.INFO, "Clicking on Add Partner Button");
			    // pageLoaderwait("PageLoader_xpath");
			     click("AddPartner_xpath");
			    // wait(2000);
			     pageLoaderwait("PageLoader_xpath");
			     type("PartnerSearchOrg_xpath", "NonPartner");
			     test.log(LogStatus.INFO, "Searching whether 'NonPartner' org which is not a service provider is displaying or not");
			    // boolean n = isElementPresent("NonPartner_xpath");
			     isElementnotPresent("NonPartner_xpath", "'NonPartner' org which is not a service provider, so it is not displaying", "'NonPartner' org which is not a service provider but it is still displaying","softassert");
			     
			     test.log(LogStatus.INFO, "Clikcing on close button");
			     click("ClosePartnerspage_xpath");
			   softAssert.assertAll();	
			     
	
}






@Test(priority=4,dataProvider="LoginTest",dependsOnMethods="PartnerMangMenu")
public void PartnerAssociation(Hashtable<String, String> data)
{

String TestCaseName4="4)Verifying whether we are able to associate organization as partner";
test=  rep.startTest("4)Verifying whether we are able to associate organization as partner");
//rep.
//rep.st
test.assignCategory("PartnerMangement");
test.log(LogStatus.INFO, "Start the test");
test.log(LogStatus.INFO, data.toString());


//System.out.println(data.get("Runmode"));
if(!DataUtil.isRunnable(TestCaseName4, xls) || data.get("Runmode").equals("N"))
{
	test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
	throw new SkipException("Test case is skipped as Runmode is N");
}
super.init();
//openBrowser(data.get("Browser"));


//navigateURL("AppURl");

 //boolean l= dologin(data.get("Username"), data.get("Password"));
 //if(dologin(data.get("Username"), data.get("Password"))== true){
	//entSecAnswers(data.get("Security_Ans1"),data.get("Security_Ans2"));
	// pageLoaderwait("PageLoader_xpath");
     //test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
    // click("PartnerMangement_xpath");
     //pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on Add Partner Button");
     click("AddPartner_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Searching for partner org 'searchorg'");
     type("PartnerSearchOrg_xpath", "searchorg");
     click("searchorg_xpath");
    // wait(500);
     test.log(LogStatus.INFO, "Selecting partner org for association");
     click("selectingsearchorg_xpath");
    // wait(1000);
     test.log(LogStatus.INFO, "Clicking on Associate button");
     click("Associate_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Checking for the success message");
 
     test.log(LogStatus.INFO, "Checking whether 'searchorg' related record has been inserted and also status is displaying as pending under Associate Partner tab"); 
isElementPresent("PartnerStatus_xpath", " Partnership related record has been inserted and also status is displaying as pending", "Partnership org related record has not been inserted","hardassert");
    // boolean s= verifyText("PartnerStatus_xpath", "PENDING");
   
// softAssert.assertAll();	
 
}	

@Test(priority=5,dataProvider="LoginTest")
public void AddAlreadyAddedPartner(Hashtable<String, String> data)
{
 softAssert  = new SoftAssert();
String TestCaseName5="5)Verifying whether proper error message is getting displayed when trying to add already Partner";
test=  rep.startTest("5)Verifying whether proper error message is getting displayed when trying to add already Partner");
//rep.
//rep.st
test.assignCategory("PartnerMangement");
test.log(LogStatus.INFO, "Start the test");
test.log(LogStatus.INFO, data.toString());


//System.out.println(data.get("Runmode"));
if(!DataUtil.isRunnable(TestCaseName5, xls) || data.get("Runmode").equals("N"))
{
	test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
	throw new SkipException("Test case is skipped as Runmode is N");
}
super.init();
pageLoaderwaiting("PageLoader_xpath");
test.log(LogStatus.INFO, "Clicking on Add Partner Button");
 click("AddPartner_xpath");
 pageLoaderwait("PageLoader_xpath");
 test.log(LogStatus.INFO, "Searching for partner org 'searchorg' which is already added as partner");
 type("PartnerSearchOrg_xpath", "searchorg");
 click("searchorg_xpath");
 //wait(500);
 test.log(LogStatus.INFO, "Selecting partner org for association");
 click("selectingsearchorg_xpath");
// wait(1000);
 click("Associate_xpath");
 pageLoaderwait("PageLoader_xpath");
 test.log(LogStatus.INFO, "Checking for the success message");
 verifyTextinPage("Already associated organizations", "Proper error message is getting displayed when trying to added already add organization as Partner", "Proper error message is getting not displayed when trying to added already add organization as Partner","softassert");
 wait(800);
softAssert.assertAll();
}

 
 @Test(priority=6,dataProvider="LoginTest")
	public void RejectPartnerShipbeforAction(Hashtable<String, String> data)
	{
	 softAssert  = new SoftAssert();

 String TestCaseName6="6)Verifying whether we are able to reject the partnership before any action is performed on the partnership request from Partner org";
	test=  rep.startTest("6)Verifying whether we are able to reject the partnership before any action is performed on the partnership request from Partner org");
	//rep.
	//rep.st
	test.assignCategory("PartnerMangement");
	test.log(LogStatus.INFO, "Start the test");
	test.log(LogStatus.INFO, data.toString());
	
	
	//System.out.println(data.get("Runmode"));
	if(!DataUtil.isRunnable(TestCaseName6, xls) || data.get("Runmode").equals("N"))
	{
		test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
		throw new SkipException("Test case is skipped as Runmode is N");
	}
	super.init();
	pageLoaderwaiting("PageLoader_xpath");
	test.log(LogStatus.INFO, "Clicking on Close button");
     click("ClosePartnerspage_xpath");
     //pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on action menu button aganist searchorg record");
     click("searchorgactionmenu_xpath");
     //wait(500);
     test.log(LogStatus.INFO, "Clicking on Reject button");
     click("PartnershipParentReject_xpath");
     test.log(LogStatus.INFO, "Clicking on ok button to confirm the rejection");
     //wait(500);
     click("Rejectionconfirmationok_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Checking for the success message");
     
     
     test.log(LogStatus.INFO, "Checking whether 'searchorg' related record has been deleted g under Associate Partner tab"); 
isElementnotPresent("Partnertext_xpath", "Succes message is displaying and 'searchorg' related record is got deleted", "Succes message is not displaying and 'searchorg' related record is still displaying", "hardassert");
     
     
    softAssert.assertAll();

 }
 
 

//driver.close();



@Test(priority=7,dataProvider="PartnerOrg")
public void WQandMangePartners(Hashtable<String, String> data)
{

softAssert  = new SoftAssert();

String TestCaseName7="7)Verifying whether WQ is getting generated at partner org for partnership approval and also partnership related record is getting added at Manage Partners Tab";
test=  rep.startTest("7)Verifying whether WQ is getting generated at partner org for partnership approval and also partnership related record is getting added at Manage Partners Tab");
//rep.
//rep.st

//VerifyPartnerAssociation();
test.assignCategory("PartnerMangement");
test.log(LogStatus.INFO, "Start the test");
test.log(LogStatus.INFO, data.toString());


//System.out.println(data.get("Runmode"));
if(!DataUtil.isRunnable(TestCaseName7, xls) || data.get("Runmode").equals("N"))
{
test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
throw new SkipException("Test case is skipped as Runmode is N");
}
super.init();
//openBrowser(data.get("Browser"));


//navigateURL("AppURl");

//  boolean l= dologin(data.get("OrgUsername"), data.get("OrgPassword"));
//if(dologin(data.get("OrgUsername"), data.get("OrgPassword"))== true)
//{
//entSecAnswers(data.get("OrgSecurity_Ans1"),data.get("OrgSecurity_Ans2"));
// pageLoaderwait("PageLoader_xpath");
//test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
//click("PartnerMangement_xpath");
//  pageLoaderwait("PageLoader_xpath");
wait(300);
test.log(LogStatus.INFO, "Clicking on Add Partner Button");
click("AddPartner_xpath");
pageLoaderwait("PageLoader_xpath");
test.log(LogStatus.INFO, "Searching for partner org 'searchorg'");
type("PartnerSearchOrg_xpath", "searchorg");

click("searchorg_xpath");
// wait(500);
test.log(LogStatus.INFO, "Selecting partner org for association");
click("selectingsearchorg_xpath");
// wait(1000);
test.log(LogStatus.INFO, "Clicking on Associate button");
click("Associate_xpath");
pageLoaderwait("PageLoader_xpath");
click("PersonIcon_xpath");
test.log(LogStatus.INFO, "Logging out from main org");
click("Signout_xpath");
pageLoaderwait("PageLoader_xpath");


test.log(LogStatus.INFO, "Logging into Patner Org");
//boolean pl= dologin(data.get("PatnerUsername"), data.get("PatnerPassword"));
dologin(data.get("PatnerUsername"), data.get("PatnerPassword"),"First level Login successful","First level Login successful","hardassert");
		entSecAnswers(data.get("PatnerSecurity_Ans1"),data.get("PatnerSecurity_Ans2"),"Login is successful","Login is not successful","hardassert");
 pageLoaderwait("PageLoader_xpath");
test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
 click("PartnerMangement_xpath");
 pageLoaderwait("PageLoader_xpath");
 test.log(LogStatus.INFO, "Clicking on ManagePartner Tab");
 click("ManagePartnerTab_xpath");
 pageLoaderwait("PageLoader_xpath");
 test.log(LogStatus.INFO, "Verifying whether Org related record is getting displayed or not");
//  boolean s= verifyText("OrgStatus_xpath", "PENDING");
 isElementPresent("OrgStatus_xpath","Org related record is getting displayed in Manage Partners","Org related record is not getting displayed in Manage Partners ","softassert");
 

pageLoaderwaiting("PageLoader_xpath");
  test.log(LogStatus.INFO, "Clicking on WorkQueues");
click("PartnerWorkQueue_xpath");
pageLoaderwait("PageLoader_xpath");
//wait(1000);
  test.log(LogStatus.INFO, "Selecting Partner WorkQueue");
click("SelectPartnerWorkQueue_xpath");
pageLoaderwait("PageLoader_xpath");
  test.log(LogStatus.INFO, "Verifying whether WorkQueue is related to patnership request from main org");
//boolean p= isElementPresent("PartnerWorkqueueverify_xpath");
 isElementPresent("PartnerWorkqueueverify_xpath","W.Q for partner approval request has been generated","W.Q for partner approval request is not been generated","hardassert");
 
 

softAssert.assertAll();
}

	@Test(priority=8,dataProvider="PartnerOrg")
	public void RejectPartnershipWQ(Hashtable<String, String> data)
	{
		softAssert  = new SoftAssert();
	String TestCaseName8="8)Verifying whether Partner org user is able to reject the partnership approval from WQ,once rejected related record is getting deleted in main org";
	test=  rep.startTest("8)Verifying whether Partner org user is able to reject the partnership approval from WQ,once rejected related record is getting deleted in main org");
	//rep.
	//rep.st
	
	//VerifyPartnerAssociation();
	test.assignCategory("PartnerMangement");
	test.log(LogStatus.INFO, "Start the test");
	test.log(LogStatus.INFO, data.toString());
	
	
	//System.out.println(data.get("Runmode"));
	if(!DataUtil.isRunnable(TestCaseName8, xls) || data.get("Runmode").equals("N"))
	{
		test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
		throw new SkipException("Test case is skipped as Runmode is N");
	}
	super.init();
	 pageLoaderwaiting("PageLoader_xpath");
	 //wait(1000);
	test.log(LogStatus.INFO, "Clicking on 'click here' link");
	click("WqClickhere_xpath");
	pageLoaderwait("PageLoader_xpath");
	test.log(LogStatus.INFO, "Clicking on reject button");
	click("Partnerreject_xpath");
	pageLoaderwait("PageLoader_xpath");
	test.log(LogStatus.INFO, "Verifying the success message");
	verifyTextinPage("Organization Association rejected", "Succes message is getting displayed", "Succes message is not getting displayed", "softassert");

	 pageLoaderwaiting("PageLoader_xpath");
	 click("PersonIcon_xpath");
     test.log(LogStatus.INFO, "Logging out from main org");
     click("Signout_xpath");
     pageLoaderwait("PageLoader_xpath");

	 test.log(LogStatus.INFO, "Logging into Main Org to verify the respective request has been deleted");     
    // boolean o= dologin(data.get("OrgUsername"), data.get("OrgPassword"));
     dologin(data.get("OrgUsername"), data.get("OrgPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
     
		entSecAnswers(data.get("OrgSecurity_Ans1"),data.get("OrgSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
		 pageLoaderwait("PageLoader_xpath");
	     test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
	     click("PartnerMangement_xpath");
	     pageLoaderwait("PageLoader_xpath");
	     isElementnotPresent("Partnertext_xpath", "searchorg' related record is still displaying", " 'searchorg' related record got deleted", "hardassert");
	     
	     pageLoaderwaiting("PageLoader_xpath");
	     click("PersonIcon_xpath");
	     test.log(LogStatus.INFO, "Logging out from main org");
	     click("Signout_xpath");
	     pageLoaderwait("PageLoader_xpath");

     
     softAssert.assertAll();
	}
	// test.log(LogStatus.INFO, "Logging into Patner Org");
	     
	     @Test(priority=9,dataProvider="PartnerOrg")
			public void RejectPartnershipWQMessage(Hashtable<String, String> data)
			{
	    	 softAssert  = new SoftAssert();
	     String TestCaseName9="9)Verifying whether proper error message is getting displayed when we try to access the WQ for which rejection action is already performed";
			test=  rep.startTest("9)Verifying whether proper error message is getting displayed when we try to access the WQ for which rejection action is already performed");
			//rep.
			//rep.st
			
			//VerifyPartnerAssociation();
			test.assignCategory("PartnerMangement");
			test.log(LogStatus.INFO, "Start the test");
			test.log(LogStatus.INFO, data.toString());
			
			
			//System.out.println(data.get("Runmode"));
			if(!DataUtil.isRunnable(TestCaseName9, xls) || data.get("Runmode").equals("N"))
			{
				test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
				throw new SkipException("Test case is skipped as Runmode is N");
			}
			super.init();
	     //boolean pp= dologin(data.get("PatnerUsername"), data.get("PatnerPassword"));
	     dologin(data.get("PatnerUsername"), data.get("PatnerPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
	     
			entSecAnswers(data.get("PatnerSecurity_Ans1"),data.get("PatnerSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
	 //wait(500);
			 pageLoaderwait("PageLoader_xpath");
		test.log(LogStatus.INFO, "Clicking on WorkQueues");
		click("PartnerWorkQueue_xpath");
		pageLoaderwait("PageLoader_xpath");
		  test.log(LogStatus.INFO, "Selecting Partner WorkQueue");
		click("SelectPartnerWorkQueue_xpath");
		//pageLoaderwait("PageLoader_xpath");
		//wait(1000);
		test.log(LogStatus.INFO, "Clicking on 'click here' link ");
		click("WqClickhere_xpath");
		pageLoaderwait("PageLoader_xpath");
		test.log(LogStatus.INFO, "Verifying whether proper error message is getting displayed or not");
		verifyTextinPage("Partnership has already been rejected from the requester", "Error message is getting displayed", "Error message is not getting displayed", "softassert");
		 
		 pageLoaderwaiting("PageLoader_xpath");
		 click("PersonIcon_xpath");
	     test.log(LogStatus.INFO, "Logging out from partner org");
	     click("Signout_xpath");
	     pageLoaderwait("PageLoader_xpath");
	     
	     
	    softAssert.assertAll();
			}
		 
	     @Test(priority=10,dataProvider="PartnerOrg")
			public void RejectPartnershipManagePart(Hashtable<String, String> data)
			{
	    	 softAssert  = new SoftAssert();
		 String TestCaseName10="10)Verifying whether Partner org user is able to reject the partnership approval from Manage Partner tab,once rejected related record is getting deleted in main org";
			test=  rep.startTest("10)Verifying whether Partner org user is able to reject the partnership approval from Manage Partner tab,once rejected related record is getting deleted in main org");
			//rep.
			//rep.st
			
			//VerifyPartnerAssociation();
			test.assignCategory("PartnerMangement");
			test.log(LogStatus.INFO, "Start the test");
			test.log(LogStatus.INFO, data.toString());
			
			
			//System.out.println(data.get("Runmode"));
			if(!DataUtil.isRunnable(TestCaseName10, xls) || data.get("Runmode").equals("N"))
			{
				test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
				throw new SkipException("Test case is skipped as Runmode is N");
			}
			super.init();
			
			dologin(data.get("OrgUsername"), data.get("OrgPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
		     
				entSecAnswers(data.get("OrgSecurity_Ans1"),data.get("OrgSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
				 pageLoaderwait("PageLoader_xpath");
			
	//click("Encomplylogo_xpath");
	//pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
     click("PartnerMangement_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on Add Partner Button");
     click("AddPartner_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Searching for partner org 'searchorg'");
     type("PartnerSearchOrg_xpath", "searchorg");
     click("searchorg_xpath");
    // wait(500);
     test.log(LogStatus.INFO, "Selecting partner org for association");
     click("selectingsearchorg_xpath");
    // wait(1000);
     click("Associate_xpath");
     pageLoaderwait("PageLoader_xpath");
     click("PersonIcon_xpath");
     test.log(LogStatus.INFO, "Logging out from main org");
     click("Signout_xpath");
     pageLoaderwait("PageLoader_xpath");
     
     test.log(LogStatus.INFO, "Logging into Patner Org");
     //boolean pn= dologin(data.get("PatnerUsername"), data.get("PatnerPassword"));
     dologin(data.get("PatnerUsername"), data.get("PatnerPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
     
		entSecAnswers(data.get("PatnerSecurity_Ans1"),data.get("PatnerSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
		pageLoaderwait("PageLoader_xpath");
		test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
	     click("PartnerMangement_xpath");
	     pageLoaderwait("PageLoader_xpath");
	     test.log(LogStatus.INFO, "Clicking on ManagePartner Tab");
	     click("ManagePartnerTab_xpath");
	     pageLoaderwait("PageLoader_xpath");
	     test.log(LogStatus.INFO, "Clicking on Action menu item against main org record");
	     click("honourmobileactionmenu_xpath");
	     test.log(LogStatus.INFO, "Clicking on Reject button");
	     click("Partnerrejcetmanagepartner_xpath");
	     test.log(LogStatus.INFO, "Clicking on ok button to confirm");
	     click("Rejectionconfirmationok_xpath");
	     pageLoaderwait("PageLoader_xpath");
	     verifyTextinPage("Organization Association rejected", "Succes message is getting displayed", "Succes message is not getting displayed", "softassert");
	    
	     pageLoaderwaiting("PageLoader_xpath");
	     click("PersonIcon_xpath");
	     test.log(LogStatus.INFO, "Logging out from main org");
	     click("Signout_xpath");
	     pageLoaderwait("PageLoader_xpath");
	     
	     
	     test.log(LogStatus.INFO, "Logging back again into main org to confirm record related to the parternship request has been deleted");
	     //boolean ol= dologin(data.get("OrgUsername"), data.get("OrgPassword"));
	     dologin(data.get("OrgUsername"), data.get("OrgPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
	     
			entSecAnswers(data.get("OrgSecurity_Ans1"),data.get("OrgSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
			 pageLoaderwait("PageLoader_xpath");
		     test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
		     click("PartnerMangement_xpath");
		     pageLoaderwait("PageLoader_xpath");
		     
		     test.log(LogStatus.INFO, "Checking whether parternship request related record has been deleted under Associate Partner tab"); 
	isElementnotPresent("Partnertext_xpath", " Parternship request related record is still displaying", "Parternship request related record is not displaying", "softassert");
		     
		     //click("PersonIcon_xpath");
		    // test.log(LogStatus.INFO, "Logging out from main org");
		    // click("Signout_xpath");
		    // pageLoaderwait("PageLoader_xpath");
     
    


     softAssert.assertAll();

}



@Test(priority=11,dataProvider="PartnerOrg")
public void ApprovePartnerReqFromWQ(Hashtable<String, String> data)
{
//softAssert  = new SoftAssert();


String TestCaseName11="11)Verifying whether Partner org user is able to Approve the partnership request from W.Q's,once approved verifying below steps";
test=  rep.startTest("11)Verifying whether Partner org user is able to Approve the partnership request from W.Q's,once approved verifying below steps: <br />"
		+ "a)Checking whether succes message is displaying or not <br />"
		+ "b)Status related to the request record is changing to Approved or not<br />"
		+ "c)In Assign Users page,partner org is displaying or not <br />"
		+ "d)Verify whether we are able to assign role for partner org user <br />"
		+ "e)Verify whether partner org user is able to switch to main org");
//rep.
//rep.st

//VerifyPartnerAssociation();
test.assignCategory("PartnerMangement");
test.log(LogStatus.INFO, "Start the test");
test.log(LogStatus.INFO, data.toString());


//System.out.println(data.get("Runmode"));
if(!DataUtil.isRunnable(TestCaseName11, xls) || data.get("Runmode").equals("N"))
{
	test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
	throw new SkipException("Test case is skipped as Runmode is N");
}
super.init();


     test.log(LogStatus.INFO, "Clicking on Add Partner Button");
     click("AddPartner_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Searching for partner org 'searchorg'");
     type("PartnerSearchOrg_xpath", "searchorg");
     click("searchorg_xpath");
    // wait(500);
     test.log(LogStatus.INFO, "Selecting partner org for association");
     click("selectingsearchorg_xpath");
    // wait(1000);
     click("Associate_xpath");
     pageLoaderwait("PageLoader_xpath");
     click("PersonIcon_xpath");
     test.log(LogStatus.INFO, "Logging out from main org");
     click("Signout_xpath");
     pageLoaderwait("PageLoader_xpath");
     
     test.log(LogStatus.INFO, "Logging into Patner Org");
     //boolean pl= dologin(data.get("PatnerUsername"), data.get("PatnerPassword"));
     dologin(data.get("PatnerUsername"), data.get("PatnerPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
     
		entSecAnswers(data.get("PatnerSecurity_Ans1"),data.get("PatnerSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
		//wait(500);
		pageLoaderwait("PageLoader_xpath");
	    test.log(LogStatus.INFO, "Clicking on WorkQueues");
		click("PartnerWorkQueue_xpath");
		pageLoaderwait("PageLoader_xpath");
		  test.log(LogStatus.INFO, "Selecting Partner WorkQueue for which rejection action is already performed");
		click("SelectPartnerWorkQueue_xpath");
		pageLoaderwait("PageLoader_xpath");
		test.log(LogStatus.INFO, "Clicking on 'click here' link ");
		click("WqClickhere_xpath");
		pageLoaderwait("PageLoader_xpath");
		test.log(LogStatus.INFO, "Clicking on Approve button");
		click("PartnerWQApprove_xpath");
		pageLoaderwait("PageLoader_xpath");
		test.log(LogStatus.INFO, "a)Checking whether succes message is displaying or not");
	    verifyTextinPage("Organization Association approved", "Succes message is getting displayed", "Succes message is not getting displayed", "softassert");
			
			 
			 pageLoaderwaiting("PageLoader_xpath");
			 click("PersonIcon_xpath");
		     test.log(LogStatus.INFO, "Logging out from main org");
		     click("Signout_xpath");
		     pageLoaderwait("PageLoader_xpath");
		     test.log(LogStatus.INFO, "Login into Main Org");
		     //boolean ol= dologin(data.get("OrgUsername"), data.get("OrgPassword"));
		     dologin(data.get("OrgUsername"), data.get("OrgPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
		     
				entSecAnswers(data.get("OrgSecurity_Ans1"),data.get("OrgSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
				 pageLoaderwait("PageLoader_xpath");
			     test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
			     click("PartnerMangement_xpath");
			     pageLoaderwait("PageLoader_xpath");
			     
			     test.log(LogStatus.INFO, "b)Status related to the request record is changing to Approved or not"); 
		
			     //boolean s= verifyText("PartnerStatus_xpath", "APPROVED");
			     verifyText("PartnerStatus_xpath", "PartnerStatusApproved", "Status has changed to APPROVED for the requested record", "Status is still displaying as Pending for the requested record", "hardassert");
			      
			     pageLoaderwaiting("PageLoader_xpath");
			     test.log(LogStatus.INFO, "Clicking on Roles & Permissions Menu Item");
			     click("RolesPermission_xpath");
			     pageLoaderwait("PageLoader_xpath");
			     test.log(LogStatus.INFO, "Clicking on Action menu for one of the role");
			     click("TestRoleactionmenu_xpath");
			     test.log(LogStatus.INFO, "Clicking on Assign users link");
			     click("Assignusers_xpath");
			     pageLoaderwait("PageLoader_xpath");
			     test.log(LogStatus.INFO, "Clicking on drop-down in assign users page");
			     click("Assignuserdropdown_xpath");
			     test.log(LogStatus.INFO, "c)Verifying whether partner org is displaying int the drop-down list");
			    //boolean p =isElementPresent("assignusersearchorgdisplaydropdown_xpath");
			     isElementPresent("assignusersearchorgdisplaydropdown_xpath","Partner org is displaying in the assignuers drop-down","Partner org is  not displaying in the assignuers drop-down","hardassert");
			      
			  
			     test.log(LogStatus.INFO, "Selecting Partner org from the drop-down list");
			     click("assignusersearchorgdisplaydropdown_xpath");
			     pageLoaderwait("PageLoader_xpath");
			     test.log(LogStatus.INFO, "Clicking the check-box against partner org user ");
			     click("selectingpartnerorguser_xpath");
			     test.log(LogStatus.INFO, "Clicking the assign users button");
			     click("AssignUsersbutton_xpath");
			     pageLoaderwait("PageLoader_xpath");
			     test.log(LogStatus.INFO, "d)Verifying whether we are able to assign role to partner org user");
			     verifyTextinPage("Users assigned successfully", "Succes message is getting displayed", "Succes message is not getting displayed", "hardassert");
				 
				 pageLoaderwaiting("PageLoader_xpath");
				// pageLoaderwait("PageLoader_xpath");
			     click("PersonIcon_xpath");
			     test.log(LogStatus.INFO, "Logging out from main org");
			     click("Signout_xpath");
			     pageLoaderwait("PageLoader_xpath");
			    
			     test.log(LogStatus.INFO, "Logging into Patner Org");
			     //boolean pll= dologin(data.get("PatnerUsername"), data.get("PatnerPassword"));
			     dologin(data.get("PatnerUsername"), data.get("PatnerPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
			     
					entSecAnswers(data.get("PatnerSecurity_Ans1"),data.get("PatnerSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
					pageLoaderwait("PageLoader_xpath");
					test.log(LogStatus.INFO, "Click on tentant drop-down");				
click("TenantdropdownPartnerorg_xpath");
test.log(LogStatus.INFO, "Checking whether main org is displaying and selecting the main org");	
click("LeftMainOrgselection_xpath");
test.log(LogStatus.INFO, "Clicking on tenant of the main org ");	
click("RightTenantmainorgselection_xpath");
pageLoaderwait("PageLoader_xpath");
test.log(LogStatus.INFO, "e)Verifying whether we are able to switch from partner org to main org ");	
//boolean mo=verifyText("//span[contains(text(),'Honourmobile')]", "Honourmobile");
		     
verifyText("PartnertoMainorgswitch_xpath", "MainOrgName", "Able to swicth from Partner org to main org successfully", "Swicthing from partner org to main org was not successful", "hardassert");
   
     
 }
//softAssert.assertAll();

		     
     
			     

@Test(priority=12,dataProvider="PartnerOrg")
public void AccWQAprroActionAlredPerf(Hashtable<String, String> data)
{
	softAssert  = new SoftAssert();
String TestCaseName12="12)Verifying whether proper error message is getting displayed when we try to access the WQ for which Approved action is already performed";
test=  rep.startTest("12)Verifying whether proper error message is getting displayed when we try to access the WQ for which Approved action is already performed");
//rep.
//rep.st

//VerifyPartnerAssociation();
test.assignCategory("PartnerMangement");
test.log(LogStatus.INFO, "Start the test");
test.log(LogStatus.INFO, data.toString());


//System.out.println(data.get("Runmode"));
if(!DataUtil.isRunnable(TestCaseName12, xls) || data.get("Runmode").equals("N"))
{
	test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
	throw new SkipException("Test case is skipped as Runmode is N");
}
super.init();
 pageLoaderwaiting("PageLoader_xpath");
test.log(LogStatus.INFO, "Click on tentant drop-down");				
click("Tenantdropdownmainorg_xpath");
test.log(LogStatus.INFO, "Selecting Partner Org from tenant pop-up");	
click("LeftMainOrgselectionPartner_xpath");
test.log(LogStatus.INFO, "Clicking on partner tenant org/loc ");	
click("RightTenantmainorgselectionPartner_xpath");
wait(500);
pageLoaderwait("PageLoader_xpath");
test.log(LogStatus.INFO, "Clicking on WorkQueues");
click("PartnerWorkQueue_xpath");
pageLoaderwait("PageLoader_xpath");
  test.log(LogStatus.INFO, "Selecting Partner WorkQueue for which Approved action is already performed");
click("SelectPartnerWorkQueue_xpath");
test.log(LogStatus.INFO, "Clicking on 'click here' link ");
click("WqClickhere_xpath");
pageLoaderwait("PageLoader_xpath");
test.log(LogStatus.INFO, "Clicking on Approve button");
click("PartnerWQApprove_xpath");
//pageLoaderwait("PageLoader_xpath");
test.log(LogStatus.INFO, "Verifying whether proper error message is getting displayed or not");
verifyTextinPage("Organization Association Already Approved", "Error message is getting displayed", "Error message is not getting displayed", "softassert");

 wait(300);
 click("CancelPartnerAssignmentpopup_xpath");
 click("PersonIcon_xpath");
 test.log(LogStatus.INFO, "Logging out from main org");
 click("Signout_xpath");
 pageLoaderwait("PageLoader_xpath");
 
 softAssert.assertAll();
			     }
		     
		     

 
 
 //driver.close(); 
 
 

@Test(priority=13,dataProvider="PartnerOrg")
public void RejectApprovedRequestFromMainOrg(Hashtable<String, String> data)
{

softAssert  = new SoftAssert();

String TestCaseName13="13)Verifying below steps after rejecting the approved partnership for main org";
		
test=  rep.startTest("13)Verifying below steps after rejecting the approved partnership for main org: <br />"
		+ "a)Checking whether we are able to reject the already approved partnership <br />"
		+ "b)Checking whether relevant record is getting deleted in main org <br />"
		+ "c)Checking whether partner is displaying under assign users drop-down <br />"
		+ "d)Checking whether relevant record is getting deleted at partner org <br />"
		+ "e)Checking whether partner org user is able to switch to main org");
//rep.
//rep.st
test.assignCategory("PartnerMangement");
//VerifyPartnerAssociation();

test.log(LogStatus.INFO, "Start the test");
test.log(LogStatus.INFO, data.toString());


//System.out.println(data.get("Runmode"));
if(!DataUtil.isRunnable(TestCaseName13, xls) || data.get("Runmode").equals("N"))
{
	test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
	throw new SkipException("Test case is skipped as Runmode is N");
}
super.init();
 // openBrowser(data.get("Browser"));


//navigateURL("AppURl");

//boolean l= dologin(data.get("OrgUsername"), data.get("OrgPassword"));
dologin(data.get("OrgUsername"), data.get("OrgPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
 
entSecAnswers(data.get("OrgSecurity_Ans1"),data.get("OrgSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
	 pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
     click("PartnerMangement_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on action menu button aganist searchorg record");
     click("searchorgactionmenu_xpath");
     //wait(500);
     test.log(LogStatus.INFO, "Clicking on Reject button");
     click("PartnershipParentReject_xpath");
     test.log(LogStatus.INFO, "Clicking on ok button to confirm the rejection");
     //wait(500);
     click("Rejectionconfirmationok_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Checking for the success message");
     
     
     test.log(LogStatus.INFO, "a&b)Verifying whether we are able to reject the partnership and relevant record is getting deleted after rejection"); 
isElementnotPresent("Partnertext_xpath", "Succes message is displaying and relavant related record also got deleted", "Succes message is not displaying and relavant related record is still displaying", "hardassert");
    
     pageLoaderwaiting("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on Roles & Permissions Menu Item");
     click("RolesPermission_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on Action menu for one of the role");
     click("TestRoleactionmenu_xpath");
     test.log(LogStatus.INFO, "Clicking on Assign users link");
     click("Assignusers_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on drop-down in assign users page");
     click("Assignuserdropdown_xpath");
     test.log(LogStatus.INFO, "c)Verifying whether partner org is displaying in the drop-down list or not");
    //boolean p =isElementPresent("assignusersearchorgdisplaydropdown_xpath");
     isElementnotPresent("assignusersearchorgdisplaydropdown_xpath", "Partner org is  not displaying in the assignuers drop-down", "Partner org is still displaying in the assignuers drop-down", "hardassert");
     
     //pageLoaderwait("PageLoader_xpath");
     click("PleaseSelect_xpath");
     click("PersonIcon_xpath");
     test.log(LogStatus.INFO, "Logging out from main org");
     click("Signout_xpath");
     pageLoaderwait("PageLoader_xpath");
     
     
     test.log(LogStatus.INFO, "Logging into Patner Org");
     //boolean pll= dologin(data.get("PatnerUsername"), data.get("PatnerPassword"));
     dologin(data.get("PatnerUsername"), data.get("PatnerPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
     
		entSecAnswers(data.get("PatnerSecurity_Ans1"),data.get("PatnerSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
		pageLoaderwait("PageLoader_xpath");
		  test.log(LogStatus.INFO, "Clicking on Partner Management menu item");
		click("PartnerMangement_xpath");
	     pageLoaderwait("PageLoader_xpath");
	     test.log(LogStatus.INFO, "Clicking on ManagePartner Tab");
	     click("ManagePartnerTab_xpath");
	     pageLoaderwait("PageLoader_xpath");
	     test.log(LogStatus.INFO, "d)Verifying whether Relavant record got deleted at partner org after partnership rejection");	
	    // boolean og=isElementPresent("OrgStatus_xpath");
	     isElementnotPresent("OrgStatus_xpath", "Relavant record got deleted at partner org as well", "Relavant record is still displaying in partner org", "hardassert");
	     
	     pageLoaderwaiting("PageLoader_xpath");
	     test.log(LogStatus.INFO, "Click on tentant drop-down");				
		    click("TenantdropdownPartnerorg_xpath");
		    test.log(LogStatus.INFO, "e)Verifying whether Partner org user is able to switch to main org after partnership rejection");	
		    //boolean lf=isElementPresent("LeftMainOrgselection_xpath");
		    isElementnotPresent("LeftMainOrgselection_xpath","Main org is not displaying in the tenant drop-down after partnership rejection","Main org is still displaying in the tenant drop-down after partnership rejection","softassert");
		    
		    wait(200);
		    click("ReselectRightTenantmainorgselectionPartner_xpath");
		    pageLoaderwait("PageLoader_xpath");
		    click("PersonIcon_xpath");
		     test.log(LogStatus.INFO, "Logging out from main org");
		     click("Signout_xpath");
		     pageLoaderwait("PageLoader_xpath");
		     
 

 softAssert.assertAll();
   //driver.close();
}

     
     
     
@Test(priority=14,dataProvider="PartnerOrg")
public void ApprovePartnerReqFromManagePartners(Hashtable<String, String> data)
{

softAssert  = new SoftAssert();

String TestCaseName14="14)Verifying whether Partner org user is able to Approve the partnership request from Manage Partner tab,once approved verifying below steps";
		
test=  rep.startTest("14)Verifying whether Partner org user is able to Approve the partnership request from Manage Partner tab,once approved verifying below steps: <br />"
		+ "a)Checking whether success message is displayed and status is getting updated to Approved in partner org <br />"
		+ "b)Status related to the request record is changing to Approved in main org <br />"
		+ "c)In Assign Users page,partner org is displaying or not <br />"
		+ "d)Verify whether we are able to assign role for partner org user <br />"
		+ "e)Verify whether partner org user is able to switch to main org");
//rep.
//rep.st
test.assignCategory("PartnerMangement");
//VerifyPartnerAssociation();

test.log(LogStatus.INFO, "Start the test");
test.log(LogStatus.INFO, data.toString());


//System.out.println(data.get("Runmode"));
if(!DataUtil.isRunnable(TestCaseName14, xls) || data.get("Runmode").equals("N"))
{
	test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
	throw new SkipException("Test case is skipped as Runmode is N");
}
super.init();
  //openBrowser(data.get("Browser"));


//navigateURL("AppURl");

//boolean l= dologin(data.get("OrgUsername"), data.get("OrgPassword"));
dologin(data.get("OrgUsername"), data.get("OrgPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
 
entSecAnswers(data.get("OrgSecurity_Ans1"),data.get("OrgSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
	 pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
     click("PartnerMangement_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on Add Partner Button");
     click("AddPartner_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Searching for partner org 'searchorg'");
     type("PartnerSearchOrg_xpath", "searchorg");
     click("searchorg_xpath");
    // wait(500);
     test.log(LogStatus.INFO, "Selecting partner org for association");
     click("selectingsearchorg_xpath");
    // wait(1000);
     click("Associate_xpath");
     pageLoaderwait("PageLoader_xpath");
     click("PersonIcon_xpath");
     test.log(LogStatus.INFO, "Logging out from main org");
     click("Signout_xpath");
     pageLoaderwait("PageLoader_xpath");
     
     
     test.log(LogStatus.INFO, "Logging into Patner Org");
    // boolean pl= dologin(data.get("PatnerUsername"), data.get("PatnerPassword"));
     dologin(data.get("PatnerUsername"), data.get("PatnerPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
     
		entSecAnswers(data.get("PatnerSecurity_Ans1"),data.get("PatnerSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
		pageLoaderwait("PageLoader_xpath");
		//pageLoaderwaiting("PageLoader_xpath");
		test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
	     click("PartnerMangement_xpath");
	     pageLoaderwait("PageLoader_xpath");
	     test.log(LogStatus.INFO, "Clicking on ManagePartner Tab");
	     click("ManagePartnerTab_xpath");
	     pageLoaderwait("PageLoader_xpath");
	     test.log(LogStatus.INFO, "Clicking on Action menu item against main org record");
	     click("honourmobileactionmenu_xpath");
	     test.log(LogStatus.INFO, "Clicking on Approve button");
	     click("PartnerApprovemanagepartner_xpath");
	    pageLoaderwait("PageLoader_xpath");
	    //wait(300);
	    test.log(LogStatus.INFO, "Verify step a) whether succes message is getting displayed and status is getting changed to approved");
	  verifyText("OrgStatus_xpath", "OrgStatusApproved", "Succes is getting displayed and status is marked as approved", "Succes is not getting displayed and status is  not marked as approvedd", "hardassert");
	     
		// pageLoaderwaiting("PageLoader_xpath");
	 click("PersonIcon_xpath");
		     test.log(LogStatus.INFO, "Logging out from Partner org");
		     click("Signout_xpath");
		     pageLoaderwait("PageLoader_xpath");
		     
		     test.log(LogStatus.INFO, "Login into Main Org");
		     //boolean ol= dologin(data.get("OrgUsername"), data.get("OrgPassword"));
		     dologin(data.get("OrgUsername"), data.get("OrgPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
		     
				entSecAnswers(data.get("OrgSecurity_Ans1"),data.get("OrgSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
				 pageLoaderwait("PageLoader_xpath");
			     test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
			     click("PartnerMangement_xpath");
			     pageLoaderwait("PageLoader_xpath");
			    
			     
			     test.log(LogStatus.INFO, "Verifying step b) Checking whether status as been changed to approved for the respective record in mainorg"); 
		
			     //boolean s= verifyText("PartnerStatus_xpath", "APPROVED");
			     
			     verifyText("PartnerStatus_xpath", "PartnerStatusApproved", "Status has changed to APPROVED for the requested record", "Status is still displaying as Pending for the requested record", "hardassert");
			     
			     pageLoaderwaiting("PageLoader_xpath");
			     test.log(LogStatus.INFO, "Clicking on Roles & Permissions Menu Item");
			     click("RolesPermission_xpath");
			     pageLoaderwait("PageLoader_xpath");
			     test.log(LogStatus.INFO, "Clicking on Action menu for one of the role");
			     click("TestRoleactionmenu_xpath");
			     test.log(LogStatus.INFO, "Clicking on Assign users link");
			     click("Assignusers_xpath");
			     pageLoaderwait("PageLoader_xpath");
			     test.log(LogStatus.INFO, "Clicking on drop-down in assign users page");
			     click("Assignuserdropdown_xpath");
			     test.log(LogStatus.INFO, "Verifying Step c) Where partner org is displaying the drop-down list");
			    //boolean p =isElementPresent("assignusersearchorgdisplaydropdown_xpath");
			     isElementPresent("assignusersearchorgdisplaydropdown_xpath", "Partner org is displaying in the assignuers drop-down", "Partner org is  not displaying in the assignuers drop-down", "hardassert");
			      
			   
			     test.log(LogStatus.INFO, "Selecting Partner org from the drop-down list");
			     click("assignusersearchorgdisplaydropdown_xpath");
			     pageLoaderwait("PageLoader_xpath");
			     test.log(LogStatus.INFO, "Clicking the check-box against partner org user ");
			     click("selectingpartnerorguser_xpath");
			     test.log(LogStatus.INFO, "Clicking the assign users button");
			     click("AssignUsersbutton_xpath");
			     pageLoaderwait("PageLoader_xpath");
			     test.log(LogStatus.INFO, "Verify step d) whether succes message is getting displayed or not");
			     verifyTextinPage("Users assigned successfully", "Succes message is getting displayed", "Succes message is not getting displayed", "softassert");
				  
				 //pageLoaderwait("PageLoader_xpath");
			     click("PersonIcon_xpath");
			     test.log(LogStatus.INFO, "Logging out from main org");
			     click("Signout_xpath");
			     pageLoaderwait("PageLoader_xpath");
			    
			     test.log(LogStatus.INFO, "Logging into Patner Org");
			     //boolean pll= dologin(data.get("PatnerUsername"), data.get("PatnerPassword"));
			     dologin(data.get("PatnerUsername"), data.get("PatnerPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
			     
					entSecAnswers(data.get("PatnerSecurity_Ans1"),data.get("PatnerSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
					pageLoaderwait("PageLoader_xpath");
					test.log(LogStatus.INFO, "Click on tentant drop-down");				
click("TenantdropdownPartnerorg_xpath");
test.log(LogStatus.INFO, "Checking whether main org is displaying and selecting the main org");	
click("LeftMainOrgselection_xpath");
test.log(LogStatus.INFO, "Clicking on tenant of the main org ");	
click("RightTenantmainorgselection_xpath");
pageLoaderwait("PageLoader_xpath");
test.log(LogStatus.INFO, "Verifying Step e)Whether we are able to switch from partner org to main org ");	
//boolean mo=verifyText("PartnertoMainorgswitch_xpath", "Honourmobile");
verifyText("PartnertoMainorgswitch_xpath", "MainOrgName", "Able to swicth from Partner org to main org successfully", "Swicthing from partner org to main org was not successful", "hardassert");
 
test.log(LogStatus.INFO, "Clicking on tenant drop-down ");	
click("Tenantdropdownmainorg_xpath");
test.log(LogStatus.INFO, "Swicthing back to partner org");
click("LeftMainOrgselectionPartner_xpath");
click("RightTenantmainorgselectionPartner_xpath");
//click("PersonIcon_xpath");
// test.log(LogStatus.INFO, "Logging out from main org");
// click("Signout_xpath");
 pageLoaderwait("PageLoader_xpath");
			     
			     
	
 softAssert.assertAll();
// driver.close();   
 }

			 
@Test(priority=15,dataProvider="PartnerOrg")
public void RejectApprovedRequestFromPartnerOrgManagePartners(Hashtable<String, String> data)
{
softAssert  = new SoftAssert();
String TestCaseName15="15)Verifying below steps after rejecting the approved partnership for Partner org";
		
test=  rep.startTest("15)Verifying below steps after rejecting the approved partnership for Partner org: <br />"
		+ "a)Checking whether we are able to reject the already approved partnership <br />"
		+ "b)Checking whether relevant record is getting deleted in Partner org <br />"
		+ "c)Checking whether partner is displaying under assign users drop-down <br />"
		+ "d)Checking whether relevant record is getting deleted at partner org <br />"
		+ "e)Checking whether partner org user is able to switch to main org");
//rep.
//rep.st
test.assignCategory("PartnerMangement");
//VerifyPartnerAssociation();

test.log(LogStatus.INFO, "Start the test");
test.log(LogStatus.INFO, data.toString());


//System.out.println(data.get("Runmode"));
if(!DataUtil.isRunnable(TestCaseName15, xls) || data.get("Runmode").equals("N"))
{
	test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
	throw new SkipException("Test case is skipped as Runmode is N");
}
super.init();
  //openBrowser(data.get("Browser"));


//navigateURL("AppURl");

//boolean l= dologin(data.get("PatnerUsername"), data.get("PatnerOrgPassword"));
// if(dologin(data.get("PatnerUsername"), data.get("PatnerOrgPassword"))== true){
//	entSecAnswers(data.get("PatnerSecurity_Ans1"),data.get("PatnerSecurity_Ans2"));
pageLoaderwaiting("PageLoader_xpath");
	test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
     click("PartnerMangement_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on ManagePartner Tab");
     click("ManagePartnerTab_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on Action menu item against main org record");
     click("honourmobileactionmenu_xpath");
     test.log(LogStatus.INFO, "Clicking on Reject button");
     click("Partnerrejcetmanagepartner_xpath");
     test.log(LogStatus.INFO, "Clicking on ok button to confirm");
     click("Rejectionconfirmationok_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Verifying Step a) Success message is getting displayed or not");
     verifyTextinPage("Organization Association rejected", "Succes message is getting displayed", "Succes message is not getting displayed","softassert");
     
     test.log(LogStatus.INFO, "Verifying Step b)Whether Relevant record got deleted in partner");
    //boolean el= isElementPresent("honourmobileactionmenu_xpath");
   isElementnotPresent("honourmobileactionmenu_xpath", "Relavant record got deleted succesfully", "Relavant record is still displaying", "hardassert");
    
//click("Encomplylogo_xpath");
   
    driver.navigate().refresh();
pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Click on tentant drop-down");				
	    click("TenantdropdownPartnerorg_xpath");
	    test.log(LogStatus.INFO, "Verifying Step e)Whether Partner org user is able to switch to main org as partnership rejection");	
	    //boolean lf=isElementPresent("LeftMainOrgselection_xpath");
	   isElementnotPresent("LeftMainOrgselection_xpath", "Main org is not displaying in the tenant drop-down after partnership rejection", "Main org is still displaying in the tenant drop-down after partnership rejection", "hardassert");
	    
	 
	    click("ReselectRightTenantmainorgselectionPartner_xpath");
	    pageLoaderwait("PageLoader_xpath");
     click("PersonIcon_xpath");
     test.log(LogStatus.INFO, "Logging out from main org");
     click("Signout_xpath");
     pageLoaderwait("PageLoader_xpath");
     
     test.log(LogStatus.INFO, "Login into Main Org");
     //boolean ol= dologin(data.get("OrgUsername"), data.get("OrgPassword"));
     dologin(data.get("OrgUsername"), data.get("OrgPassword"),"First level login is successful","First level login is unsuccessful","hardassert");
     
		entSecAnswers(data.get("OrgSecurity_Ans1"),data.get("OrgSecurity_Ans2"),"Login is successful","Login is unsuccessful","hardassert");
		 pageLoaderwait("PageLoader_xpath");
	     //test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
		 //pageLoaderwait("PageLoader_xpath");
	     test.log(LogStatus.INFO, "Clicking on PartnerMangement Menu Item");
	     click("PartnerMangement_xpath");
	     pageLoaderwait("PageLoader_xpath");
		 
	     test.log(LogStatus.INFO, "Verify Step d)Checking whether relevant record is getting deleted at main org"); 
isElementnotPresent("Partnertext_xpath", "Relavant related record also got deleted", "Relavant related record is still displaying", "hardassert");
	     
     test.log(LogStatus.INFO, "Clicking on Roles & Permissions Menu Item");
     click("RolesPermission_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on Action menu for one of the role");
     click("TestRoleactionmenu_xpath");
     test.log(LogStatus.INFO, "Clicking on Assign users link");
     click("Assignusers_xpath");
     pageLoaderwait("PageLoader_xpath");
     test.log(LogStatus.INFO, "Clicking on drop-down in assign users page");
     click("Assignuserdropdown_xpath");
     test.log(LogStatus.INFO, "Verifying Step c) Where partner org is displaying the drop-down list");
    //boolean p =isElementPresent("assignusersearchorgdisplaydropdown_xpath");
     isElementnotPresent("assignusersearchorgdisplaydropdown_xpath", "Partner org is  not displaying in the assignuers drop-down", "Partner org is still displaying in the assignuers drop-down", "hardassert");
     
     //pageLoaderwait("PageLoader_xpath");
    // softAssert.assertAll();
     
		    //driver.close();
     
 
     softAssert.assertAll();
     driver.close();
}
				    
				  @AfterMethod
				  public void endtest()
				  {
					  rep.endTest(test); 
				  }
				     
		    	
		
		@BeforeTest
		public void init()
		{
			
			
			
			
		}
		
//		@AfterTest
//		public void assign ( String[] testCategory)
//		{
//        test.assignCategory(testCategory);
//		}
		@AfterTest
		public void quit()
		{
			//test.assignCategory("PartnerMangement");
		//test.assignCategory(testCategory);
			 //softAssert.assertAll();	
		
		//if(rep!=null){
			//rep.flush();
			//rep.endTest(test);
			rep.flush();
		//rep.endTest(test);
	
		//}
			if(driver!=null)
			driver.quit();
		
		}
		@DataProvider
		public Object[][] LoginTest()
		{
			super.init();
			xls =new Xls_Reader("/home/aknandigam/workspace/TaxillaProjectFeb/src/project/resources/TestData.xlsx");
			return DataUtil.getTestData(xls, "LoginTest");
		}
		@DataProvider
		public Object[][] unlockingUserAcc()
		{
			super.init();
			xls =new Xls_Reader("/home/aknandigam/workspace/TaxillaProjectFeb/src/project/resources/TestData.xlsx");
			return DataUtil.getTestData(xls, "unlockingUserAcc");
		}
		@DataProvider
		public Object[][] lockingUserAcc()
		{
			super.init();
			xls =new Xls_Reader("/home/aknandigam/workspace/TaxillaProjectFeb/src/project/resources/TestData.xlsx");
			return DataUtil.getTestData(xls, "lockingUserAcc");
		}
		@DataProvider
		public Object[][] permVerfUserUnLock()
		{
			super.init();
			xls =new Xls_Reader("/home/aknandigam/workspace/TaxillaProjectFeb/src/project/resources/TestData.xlsx");
			return DataUtil.getTestData(xls, "permVerfUserUnLock");
		}
		@DataProvider
		public Object[][] PartnerOrg()
		{
			super.init();
			xls =new Xls_Reader("/home/aknandigam/workspace/TaxillaProjectFeb/src/project/resources/TestData.xlsx");
			return DataUtil.getTestData(xls, "PartnerOrg");
			//return DataUtil.getTestData(xls, "LoginTest");
		}
		
		
		//softAssert.assertAll();	
}

