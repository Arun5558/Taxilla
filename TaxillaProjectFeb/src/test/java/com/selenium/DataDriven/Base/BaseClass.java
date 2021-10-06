package com.selenium.DataDriven.Base;

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
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;











import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
//import com.aventstack.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.selenium.DataDriven.Functions.AppActions;
import com.selenium.DataDriven.Util.ExtentManager;

//import com.sun.org.glassfish.external.arc.Taxonomy;
//import com.sun.xml.internal.txw2.Document;
//import com.aventstack.extentreports.ExtentReports;
//import com.aventstack.extentreports.ExtentTest;
//import com.aventstack.extentreports.Status;
//import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

//import com.selenium.DataDriven.Util.ExtentManager;


public class BaseClass extends ExtentManager{
public	SoftAssert softAssert;
public WebDriver driver;
public ExtentReports rep =ExtentManager.getInstance();
public TakesScreenshot sc;
public ExtentTest test;
//public ExtentTest test1;
//public SoftAssert softAssert;
public Properties prop;
//******************************Initialzing and loading properties file***************************************
//AppActions app =new AppActions();

public void init(){
	
if(prop==null){
	prop = new Properties();
	try {
		FileInputStream  fs = new FileInputStream (System.getProperty("user.dir")+"/src/project/resources/Projectconf.properties");
		prop.load(fs);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	
}
}


	
	
	
	
	
	
	//******************************Report Failure***************************************
	
	public  void reportFailure(String msg,String asserttype)
	{
		//System.out.println("Locatorykey not found"+"---------" + msg);
		if (asserttype == "softassert")
			
		{
			softAssert  = new SoftAssert();
			//SoftAssert softAssertions = new SoftAssert();
			//System.out.println("Locatorykey not found"+"---------" + msg);
			test.log(LogStatus.FAIL, msg);
			takeScreenShot();
			softAssert.fail(msg);
		}
		//driver.close();
		else
	{
		
		//Assert.fail(msg);
		//driver.close();
		
		test.log(LogStatus.FAIL, msg);
		takeScreenShot();
		Assert.fail(msg);
	}
	}
	
	//******************************Report Pass***************************************
	public  void reportPass(String msg)
	{
		test.log(LogStatus.PASS, msg);
		takeScreenShot();
		
	}
	
	//******************************Taking screen-shots***************************************
	public void takeScreenShot(){
		// fileName of the screenshot
		Date d=new Date();
		//String folderName=d.toString().replace(":", "_").replace(" ", "_");
		String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
		// store screenshot in that file
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File("./reports/"+folderName+"/screenshot/"+screenshotFile));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//put screenshot file in reports
		String test1 = "./reports/"+folderName+"/screenshot/"+screenshotFile;
		//System.out.println("new=" + test1);
		test.log(LogStatus.INFO,"Screenshot-> "+ test.addScreenCapture("./screenshot/"+screenshotFile));
		
}
	

	
	
	
	
}