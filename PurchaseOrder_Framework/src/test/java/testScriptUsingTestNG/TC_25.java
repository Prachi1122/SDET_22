package testScriptUsingTestNG;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

import pom.CreateNewPurchaseOrder;
import pom.Home;
import pom.PurchaseOrder;

public class TC_25 extends BaseClass {
@Test
public void tc_25() throws InterruptedException {
	Home h=new Home(driver);
	h.homePage(driver);
	h.getPurchaseOrder().click();
	PurchaseOrder po=new PurchaseOrder(driver);
	po.getCreatepurchaseOrder().click();
	Thread.sleep(1000);
	CreateNewPurchaseOrder c=new CreateNewPurchaseOrder(driver);
	c.groupSellingTeam();
}
}
