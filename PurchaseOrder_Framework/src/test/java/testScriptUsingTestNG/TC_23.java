package testScriptUsingTestNG;



import static org.testng.Assert.fail;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

import pom.CreateNewPurchaseOrder;
import pom.Home;
import pom.PurchaseOrder;
@Listeners(com.crm.vtiger.GenericUtils.IListnerNormal.class)
public class TC_23 extends BaseClass {
	@Test
	public void tc_23() throws Throwable {
		Home h=new Home(driver);
		h.homePage(driver);
		h.getPurchaseOrder().click();
		PurchaseOrder po=new PurchaseOrder(driver);
		po.getCreatepurchaseOrder().click();
		Thread.sleep(1000);
		CreateNewPurchaseOrder c=new CreateNewPurchaseOrder(driver);
		c.groupMarketing();
		Assert.fail();
	
	}

}
