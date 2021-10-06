package com.selenium.DataDriven.Util;

//http://relevantcodes.com/Tools/ExtentReports2/javadoc/index.html?com/relevantcodes/extentreports/ExtentReports.html


import java.io.File;
import java.io.IOException;
import java.util.Date;

//import com.aventstack.extentreports.ExtentReports;





import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentManager {
	public ExtentTest test;
	public ExtentTest test1;
	public WebDriver driver;
	private static ExtentReports extent;
	static Date d=new Date();
	public String folderName=d.toString().replace(":", "_").replace(" ", "_");
	public String reportFolderPath= System.getProperty("user.dir")+"/reports/"+folderName+"/";
	public static ExtentReports getInstance() {
		if (extent == null) {
			//Date d=new Date();
			String folderName=d.toString().replace(":", "_").replace(" ", "_");
			String fileName=d.toString().replace(":", "_").replace(" ", "_")+".html";
			 File f =new File("/home/aknandigam/workspace/TaxillaProjectFeb/reports/"+folderName+"/screenshot");
			 //System.out.println(f);
			 f.mkdirs();
			 //File s =new File("/home/aknandigam/workspace/TaxillaProjectFeb/reports/"+folderName+);
			// System.out.println(f);
			  String reportFolderPath= System.getProperty("user.dir")+"/reports/"+folderName+"/";
			// System.out.println(reportFolderPath);
			 
			//String reportFolderPath = System.getProperty("/home/aknandigam/workspace/TaxillaProjectFeb/reports/"+d.toString().replaceAll(":", "-"));
			extent = new ExtentReports(reportFolderPath+fileName, false, DisplayOrder.OLDEST_FIRST);

			
			extent.loadConfig(new File(System.getProperty("user.dir")+"/ReportsConfig.xml"));
			// optional
			extent.addSystemInfo("Selenium Version", "2.53.0").addSystemInfo(
					"Environment", "QA");
		}
		return extent;
	}
}
		
		
		
	
