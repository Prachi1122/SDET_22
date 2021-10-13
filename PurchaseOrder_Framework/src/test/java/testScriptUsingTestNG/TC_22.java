package testScriptUsingTestNG;
import org.testng.annotations.Test;
import com.crm.vtiger.GenericUtils.BaseClass;
import pom.CreateNewPurchaseOrder;
import pom.Home;
import pom.PurchaseOrder;

public class TC_22 extends BaseClass {
	@Test
	public void tc_22() throws Throwable {
		Home h=new Home(driver);
		h.homePage(driver);
		h.getPurchaseOrder().click();
		PurchaseOrder po=new PurchaseOrder(driver);
		po.getCreatepurchaseOrder().click();
		Thread.sleep(1000);
		CreateNewPurchaseOrder c=new CreateNewPurchaseOrder(driver);
		c.getGroupBtn().click();
	}

}
