package com.selenium.DataDriven.TestCases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.SkipException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;
import com.selenium.DataDriven.Base.BaseClass;
import com.selenium.DataDriven.Util.DataUtil;
import com.selenium.DataDriven.Util.Xls_Reader;

public class UnlockingLockedUserAccount extends BaseClass{

	 SoftAssert softAssert;
		Xls_Reader xls;
		
		String TestCaseName="UnlockingLockedUserAccount";
		//String testName= "TestA";
		
		@Test(dataProvider="lockingUserAcc")
		public void lockingUserAcc(Hashtable<String, String> data)
		{

			
			test=  rep.startTest("Locking User Account With 5 WrongAttemts");
			//rep.
			//rep.st
			
			test.log(LogStatus.INFO, "Start the test");
			test.log(LogStatus.INFO, data.toString());
			
			System.out.println(data.get("Runmode"));
			
			if(!DataUtil.isRunnable(TestCaseName, xls) || data.get("Runmode").equals("N"))
			{
				test.log(LogStatus.SKIP, "Test case is skipped as Runmode is SN");
				throw new SkipException("Test case is skipped as Runmode is N");
			}
			super.init();
			openBrowser(data.get("Browser"));
			test.log(LogStatus.INFO, "Browser has oppened");
			
			navigateURL("AppURl");
			test.log(LogStatus.INFO, "URL has opened");
			dologinWrongDetails(data.get("Username"),data.get("Password"));
		     

			
		}
		@Test(dependsOnMethods = {"lockingUserAcc"},dataProvider="permVerfUserUnLock")
		public void permVerfUserUnLock(Hashtable<String, String> data)
		{

			
			test=  rep.startTest("Verify whether UserMangement is dislaying based on premissions assigned");
			//rep.
			//rep.st
			
			test.log(LogStatus.INFO, "Start the test");
			test.log(LogStatus.INFO, data.toString());
			
			
			System.out.println(data.get("Runmode"));
			if(!DataUtil.isRunnable(TestCaseName, xls) || data.get("Runmode").equals("N"))
			{
				test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
				throw new SkipException("Test case is skipped as Runmode is N");
			}
			super.init();
			openBrowser(data.get("Browser"));
			test.log(LogStatus.INFO, "Browser has oppened");
			
			navigateURL("AppURl");
			test.log(LogStatus.INFO, "URL has oppened");
		     boolean l= dologin(data.get("Username"), data.get("Password"));
		     if(l= true){
				entSecAnswers(data.get("Security_Ans1"),data.get("Security_Ans2"));
		     
		     wait(7000);
		     //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				//lick("UserManagemnet_xpath");
				//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				//waitForPageToLoad();
				//wait(13000);
				//JavascriptException js = (JavascriptException)driver;
				//JavascriptExecutor js = (JavascriptExecutor)driver;
				//js.e
				
				/*click("USerActions_xpath");
				//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				waitForPageToLoad();
				test.log(LogStatus.INFO, "Unlocking the user");
				wait(1000);
				boolean p=isElementPresent("Unlockuser_xpath");*/
		     test.log(LogStatus.INFO, "Checking whether serManagment menu item is displaying or not");
		if (driver.getPageSource().contains("User Management"))
			reportFailure("UserManagment menu item is displaying even after not giving create user permission");
			//reportPass("Unlock user option is not displaying for user who doesnt have create user role");
		else
			reportPass("UserManagment menu item is not displaying as create user permission is not given");
				
				/*click("Unlockuser_xpath");
				//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				//waitForPageToLoad();
				wait(3000);
				if (driver.getPageSource().contains("User unlocked successfully"))
					                                 
				{
					//takeScreenShot();
					reportPass("User unlocked successfully");
					
				}else
				{
					
					reportFailure("User unlock failed");
				}
		     }else
		    	 
		    	 reportFailure("User login failed");*/
					
			
		}
		}
		

		@Test(dependsOnMethods = {"lockingUserAcc"},dataProvider="unlockingUserAcc")
		public void unlockingUserAcc(Hashtable<String, String> data)
		{

			
			test=  rep.startTest("Unlocking Locked User Account");
			//rep.
			//rep.st
			
			test.log(LogStatus.INFO, "Start the test");
			
			test.log(LogStatus.INFO, data.toString());
			
			
			System.out.println(data.get("Runmode"));
			
			if(!DataUtil.isRunnable(TestCaseName, xls) || data.get("Runmode").equals("N"))
			{
				test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
				throw new SkipException("Test case is skipped as Runmode is N");
			}
			super.init();
			openBrowser(data.get("Browser"));
			test.log(LogStatus.INFO, "Browser has oppened");
			
			navigateURL("AppURl");
			test.log(LogStatus.INFO, "URL has oppened");
		     boolean l= dologin(data.get("Username"), data.get("Password"));
		     if(l= true){
				entSecAnswers(data.get("Security_Ans1"),data.get("Security_Ans2"));
		     
		     wait(7000);
		     //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				click("UserManagemnet_xpath");
				//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				waitForPageToLoad();
				wait(5000);
				//JavascriptException js = (JavascriptException)driver;
				//JavascriptExecutor js = (JavascriptExecutor)driver;
				//js.e
				
				click("USerActions_xpath");
				//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				waitForPageToLoad();
				test.log(LogStatus.INFO, "Unlocking the user");
				wait(1000);
				click("Unlockuser_xpath");
				//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
				//waitForPageToLoad();
				wait(3000);
				if (driver.getPageSource().contains("User unlocked successfully"))
					                                 
				{
					//takeScreenShot();
					reportPass("User unlocked successfully");
					
				}else
				{
					
					reportFailure("User unlock failed");
				}
		     }else
		    	 
		    	 reportFailure("User login failed");
		}
		     
		     @Test(dependsOnMethods = {"unlockingUserAcc"},dataProvider="unlockingUserAcc")
				public void verifyEventForUnlock(Hashtable<String, String> data)
				{

					
					
		    	 test=  rep.startTest("Vetifying whether event is getting logged in Notifcations after Unlocking User");
					
					test.log(LogStatus.INFO, "Start the test");
					test.log(LogStatus.INFO, data.toString());
					
					System.out.println(data.get("Runmode"));
					
					if(!DataUtil.isRunnable(TestCaseName, xls) || data.get("Runmode").equals("N"))
					{
						test.log(LogStatus.SKIP, "Test case is skipped as Runmode is N");
						throw new SkipException("Test case is skipped as Runmode is N");
					}
					super.init();
					openBrowser(data.get("Browser"));
					test.log(LogStatus.INFO, "Browser has oppened");
					
					navigateURL("AppURl");
					test.log(LogStatus.INFO, "URL has oppened");
				     boolean l= dologin(data.get("Username"), data.get("Password"));
				     if(l= true){
						entSecAnswers(data.get("Security_Ans1"),data.get("Security_Ans2"));
				     
				     wait(5000);
				     //driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
						//click("UserManagemnet_xpath");
						//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
						waitForPageToLoad();
						wait(5000);
						//JavascriptException js = (JavascriptException)driver;
						//JavascriptExecutor js = (JavascriptExecutor)driver;
						//js.e
						test.log(LogStatus.INFO, "Clicking on Settings Link");
						click("Settings_xpath");
						waitForPageToLoad();
						
						wait(2500);
						takeScreenShot();
						test.log(LogStatus.INFO, "Clicking on Notifications Link to check for the Event");
						click("Notifications_xpath");
						//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
						waitForPageToLoad();
						//test.log(LogStatus.INFO, "Unlocking the user");
						wait(3000);
						//click("Unlockuser_xpath");
						//driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
						//waitForPageToLoad();
						//wait(3000);
						if (driver.getPageSource().contains("'test5558' user is unlocked by 'Honourmobile' user. "))
							                                 
						{
							//takeScreenShot();
							reportPass("Event got Logged in Notifications");
							
						}else
						{
							
							reportFailure("Event didn't get Logged in Notifications");
						}
				     }else
				    	 
				    	 reportFailure("User login failed");
				     
				     	
			
		}
		
		
		@BeforeTest
		public void init()
		{
			softAssert  = new SoftAssert();
			
			
		}
		@AfterTest
		public void quit()
		{
		try{
			softAssert.assertAll();
			
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, e.getMessage());
			takeScreenShot();
		}
		if(rep!=null){
			rep.endTest(test);
			rep.flush();
	
		}
			if(driver!=null)
			driver.quit();
		
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
	}

	


