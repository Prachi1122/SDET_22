package com.crm.vtiger.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import pom.Home;
import pom.Login;

/**
 * This class contains basic configuration annotations of TestNG
 * @author Prachi
 *
 */
public class BaseClass {
public DataBaseUtility dLib = new DataBaseUtility();
public FileUtility fLib = new FileUtility();
public WebDriverUtility wLib= new WebDriverUtility();
public ExcelUtility eLib = new ExcelUtility();
public JavaUtility jLib = new JavaUtility();
public WebDriver driver;
public static WebDriver sdriver=null;

@BeforeSuite(groups = {"smoketest"})
public void connectToDB() {
//dLib.connectToDB();
System.out.println("===========DB Connection Sucessfull=============");
}
@BeforeClass(groups = {"smoketest"})
public void launchBrowser() throws Throwable {
	//read data from property file
	String BROWSER = fLib.getPropertyKeyValue("browser");
	String URL = fLib.getPropertyKeyValue("url");
	if(BROWSER.equalsIgnoreCase("chrome")) {
		driver=new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox")) {
		driver = new FirefoxDriver();
	}
	else {
		System.out.println("Invalid Browser Name");
	}
	WebDriverListner regDriver=new WebDriverListner();
	 EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
	eventDriver.register(regDriver);
	System.out.println("===========Browser Launch Sucessfully===========");
	wLib.maximiseWindow(driver);
	wLib.waitUntilPageLoad(driver);
	driver.get(URL);
	sdriver=driver;
}
@BeforeMethod(groups = {"smoketest"})
public void loginToApp() throws Throwable {
//read data from property file
	String USERNAME = fLib.getPropertyKeyValue("username");
	String PASSWORD = fLib.getPropertyKeyValue("password");
	// login to app
	Login l= new Login(driver);
	l.loginToApp(driver);
	System.out.println("=============login sucessfull===========");
}
@AfterMethod(groups = {"smoketest"})
public void logoutApp() {
	//sign out of home page
	Home h= new Home(driver);
	h.signOut(driver);
	System.out.println("==========sign out sucessfull==========");
}
@AfterClass(groups = {"smoketest"})
public void closeBrowser() {
	driver.close();
	System.out.println("=====Browser close sucessfull============");
}
@AfterSuite(groups = {"smoketest"})
public void closeDB() {
	//dLib.closeDB();
	System.out.println("=============DB connection closed sucessfully======");
}
}