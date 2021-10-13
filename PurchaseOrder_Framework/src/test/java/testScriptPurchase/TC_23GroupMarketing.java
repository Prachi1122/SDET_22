package testScriptPurchase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

import pom.CreateNewPurchaseOrder;
import pom.Home;
import pom.Login;
import pom.PurchaseOrder;

public class TC_23GroupMarketing {
	@Test
	public void tc_23GroupMarketing() throws Throwable	{
		WebDriverUtility wLib=new WebDriverUtility();
		
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
Login l=new Login(driver);
	l.loginToApp(driver);
	Home h=new Home(driver);
	h.homePage(driver);
	h.getPurchaseOrder().click();
	PurchaseOrder po=new PurchaseOrder(driver);
	po.getCreatepurchaseOrder().click();
	Thread.sleep(1000);
	CreateNewPurchaseOrder c=new CreateNewPurchaseOrder(driver);
	c.groupMarketing();
	Thread.sleep(1000);
	h.signOut(driver);
}
}