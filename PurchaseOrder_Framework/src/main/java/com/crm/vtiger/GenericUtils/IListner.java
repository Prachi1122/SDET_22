package com.crm.vtiger.GenericUtils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.google.common.io.Files;

public class IListner extends BaseClass implements ITestListener  {
	ExtentReports report;
	ExtentTest test;
	

	public void onTestStart(ITestResult result) {
		//step3: create test method
		test=report.createTest(result.getMethod().getMethodName());
		
	}

	
	public void onTestSuccess(ITestResult result) {
		//step4: log for Pass methods
		test.log(Status.PASS, result.getMethod().getMethodName()+" is Passed");
	}

	public void onTestFailure(ITestResult result) {
		
		Object obj = result.getInstance();
		WebDriver driver=null;
		try {
			try {
				driver=(WebDriver)result.getTestClass().getRealClass().getSuperclass().getDeclaredField("driver").get(obj);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalArgumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		EventFiringWebDriver takescreenshot=new EventFiringWebDriver(driver);
		File source=takescreenshot.getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")
				+"//screenshot//"+result.getMethod().getMethodName()+
				"_"+JavaUtility.getCurrentDate()+".PNG";
		File dest=new File(screenshotPath);
		try {
			Files.copy(source, dest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//step5:log for failure methods
		test.log(Status.FAIL, result.getMethod().getMethodName()+" is Failed");
		test.log(Status.FAIL, result.getThrowable());
		test.addScreenCaptureFromPath(screenshotPath);
		
	}


	public void onTestSkipped(ITestResult result) {
		//step6: log for skip methods
		test.log(Status.SKIP, result.getMethod().getMethodName()+" is Skipped");
		test.log(Status.SKIP, result.getThrowable());
		
	}


	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}


	public void onStart(ITestContext context) {
		//Step1: Configuration
		ExtentSparkReporter htmlReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/extentreport"+JavaUtility.getCurrentDate()+".html");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("Vtiger Automation Report");
		htmlReporter.config().setReportName("Execution Report");
		//step2: attaching report and system info
		 report=new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("OS", "Windows");
		report.setSystemInfo("Url", "http://localhost:8888/");
		report.setSystemInfo("Platform", "Windows10");
		report.setSystemInfo("Repoter Name", "Nithesh");
	}


	public void onFinish(ITestContext context) {
		//step7: flush the report
		report.flush();
		
	}
}
