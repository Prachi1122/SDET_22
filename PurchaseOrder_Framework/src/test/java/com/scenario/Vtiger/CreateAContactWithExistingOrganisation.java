package com.scenario.Vtiger;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.BaseClass;

import pom.ContactsPage;
import pom.CreateNewContact;
import pom.Home;
import pom.OrgLookUp;

public class CreateAContactWithExistingOrganisation extends BaseClass {
@Test
public void test() throws Throwable {
	Home h= new Home(driver);
	//h.homePage(driver);
	h.getContactLink().click();
	Thread.sleep(3000);
	ContactsPage cp = new ContactsPage(driver);
	cp.getContactLink().click();
	
	CreateNewContact cnc = new CreateNewContact(driver);
	
	//cnc.getLeadsource().click();
	cnc.getContactLink().click();
	cnc.getOrgBtn().click();
	wLib.switchToWindow(driver, "module=Accounts&action=");
	Thread.sleep(2000);
	
	//cnc.leadSource();
	OrgLookUp olu = new OrgLookUp(driver);
	
	olu.selectOrg();
	Thread.sleep(3000);
	olu.getFirstOrgName().click();

	
	
	wLib.switchToWindow(driver, "EditView&return_action=Detai");
	
	cnc.getLeadsource();
	cnc.organisatio();
	
	
}
	
	

}
