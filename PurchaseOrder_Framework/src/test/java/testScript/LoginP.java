package testScript;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pom.CreateNewPurchaseOrder;
import pom.Home;
import pom.Login;
import pom.PurchaseOrder;

public class LoginP {
	@Test
	public void loginpa() throws Throwable	{
			
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	Login l=new Login(driver);
		l.loginToApp(driver);
Home h= new Home(driver);
h.homePage(driver);
h.getPurchaseOrder().click();
PurchaseOrder po = new PurchaseOrder(driver);
po.getCreatepurchaseOrder().click();
Thread.sleep(1000);
CreateNewPurchaseOrder cnpo = new CreateNewPurchaseOrder(driver);
cnpo.newPurchaseOrder();
Thread.sleep(2000);
cnpo.newPurchaseOrder();
h.signOut(driver);
driver.close();

	}
}
