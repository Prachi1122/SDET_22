package com.crm.vtiger.GenericUtils;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class IListnerNormal implements ITestListener {
	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		
		EventFiringWebDriver edriver= new EventFiringWebDriver(BaseClass.sdriver);
		File srcfile = edriver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(srcfile,new File("./screenshot/"+testname+" "+JavaUtility.getCurrentDate()+" "+".png"));
		
			
		}catch(IOException e ) {
			e.printStackTrace();
			
		}
		
	}
}
