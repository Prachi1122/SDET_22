package testScript;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.ExcelUtility;
import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.JavaUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

import pom.Home;
import pom.Login;
import pom.Organisation;
import pom.OrganisationInfo;
import pom.CreateNewOrganization;

public class createOrgTest {


	public static void main(String[] args) throws Throwable {
		/* create object */
		ExcelUtility elib = new ExcelUtility();
		FileUtility flib= new FileUtility();
		JavaUtility jlib= new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		WebDriver driver=null;
		//Login l=new Login(driver);
		//l.loginToApp(driver);

		/* read common data */
		String URL = flib.getPropertyKeyValue("url");
		String BROWSER = flib.getPropertyKeyValue("browser");
		String USERNAME = flib.getPropertyKeyValue("username");
		String PASSWORD = flib.getPropertyKeyValue("password");
		/* read test data*/
		String OrgName = elib.getExcelData("OrgName", 10, 2)+" "+jlib.getRandomData();

		/*Step 1: Launch the browser */
		if (BROWSER.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (BROWSER.equals("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else 
		{
			driver=new ChromeDriver();
		}
		/* Step 2: Login to app*/
		driver.get(URL);
		Login l=new Login(driver);
		l.loginToApp(driver);
		//l.loginToApp(USERNAME,PASSWORD,URL);
		
		/*Step 3: navigate to organizations */
		Home hp=new Home(driver);
		hp.getOrglink().click();
		
/*Step 4: navigate to create org page */
		
		Organisation op=new Organisation(driver);
		op.getCreateOrgImg().click();
		
/* step 5 :create  new Org*/
		CreateNewOrganization cno= new CreateNewOrganization(driver);
		cno.createOrg(OrgName);
		
		/* step 6: verify*/
		OrganisationInfo oi=new OrganisationInfo(driver);
wlib.waitForElementVisibility(driver, oi.getSucessFullMsg());
String actSucMsg = oi.getSucessFullMsg().getText();
if(actSucMsg.contains(OrgName)) {
	System.out.println("org is created sucessfully----->PASS");
	}
else {
	System.out.println("org is not created sucessfully----->FAIL");
}
/* step 7: logout*/
hp.signOut(driver);
/* step 8: close the browser */
driver.close();
	
	}	
}
