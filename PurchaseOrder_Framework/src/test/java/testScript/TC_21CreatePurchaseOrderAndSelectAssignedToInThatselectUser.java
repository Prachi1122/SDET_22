package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_21CreatePurchaseOrderAndSelectAssignedToInThatselectUser {
	@Test
	public void createPurchaseOrder() throws Throwable {
		WebDriver driver=new ChromeDriver();
		FileUtility fu = new FileUtility();
		
		String URL = fu.getPropertyKeyValue("url");
		String USERNAME = fu.getPropertyKeyValue("username");
		String PASSWORD = fu.getPropertyKeyValue("password");
		driver.get(URL);
		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		
		WebElement more = driver.findElement(By.xpath("//a[.='More']"));
		
		WebDriverUtility wb = new WebDriverUtility();
wb.mouseOver(driver,more );
driver.findElement(By.name("Purchase Order")).click();
driver.findElement(By.xpath("//img[@title='Create Purchase Order...']")).click();
driver.findElement(By.xpath("//input[@value='U']")).click();
WebElement user = driver.findElement(By.xpath("//select[@name='assigned_user_id']"));
wb.SelectOption(user,0);
String title = driver.getTitle();
SoftAssert a=new SoftAssert();
a.assertEquals(title,  "Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
Thread.sleep(1000);
WebElement signout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
wb.mouseOver(driver,signout );

driver.findElement(By.xpath("//a[.='Sign Out']")).click();



	}

}