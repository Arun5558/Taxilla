package com.selenium.DataDriven.TestCases;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.DataDriven.Base.BaseClass;
import com.selenium.DataDriven.Util.DataUtil;
import com.selenium.DataDriven.Util.Xls_Reader;

public class BridgeCases  extends BaseClass{
	
	Xls_Reader xls;
	
	@Test(priority=1,dataProvider="LoginTest")
	public void PartnerMangMenu(Hashtable<String, String> data)
	{
		//extentTest= extentReport.createTest("Test"); 
		String TestCaseName1="1)Verifying Partner Management Menuitem is Displaying or not";
		test=  rep.startTest("1)Verifying Partner Management Menuitem is Displaying or not");
				
		//rep.
		//rep.st
		
		test.log(LogStatus.INFO, "Start the test");
		test.log(LogStatus.INFO, data.toString());
		
		System.out.println(data.get("Runmode"));
		
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
	     if(dologin(data.get("Username"), data.get("Password"))==true)
	     {
			entSecAnswers(data.get("Security_Ans1"),data.get("Security_Ans2"));
			//wait(300);
			 pageLoaderwait("PageLoader_xpath");
	     
	     test.log(LogStatus.INFO, "Checking whether PartnerManagment menu item is displaying or not");
			if (driver.getPageSource().contains("Partner Management"))
			{
				reportPass("PartnerManagment menu item is displaying");
				//reportPass("Unlock user option is not displaying for user who doesnt have create user role");
			}
			else
			{
				reportFailure("PartnerManagment menu item is not displaying");
			}
	     }
	    // softAssert.assertAll();
	}
			

}
