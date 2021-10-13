package testScript;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.crm.vtiger.GenericUtils.BaseClass;
import junit.framework.Assert;
import pom.CreateNewOrganization;
import pom.Home;
import pom.Organisation;
import pom.OrganisationInfo;
public class CreateOrganizationTest extends BaseClass {
	@Test
	public void createOrganizationTest() throws Throwable {
		//read test data from excel
		String ORGName = eLib.getExcelData("OrgName", 10, 2)+jLib.getRandomData();
		System.out.println(ORGName);
		//click on organization link
		Home h=new Home(driver);
		h.getOrglink().click();
		//click on create organization image
		Organisation o=new Organisation(driver);
		o.getCreateOrgImg().click();
		//enter mandatory details
		CreateNewOrganization cno = new CreateNewOrganization(driver);
		cno.createOrg(ORGName);
		//validation
		OrganisationInfo oi = new OrganisationInfo(driver);
		String actData = oi.getSucessFullMsg().getText();
		System.out.println(actData);
		Assert.assertTrue(actData.contains(ORGName));
		System.out.println("organization created sucessfully");
	}
}

