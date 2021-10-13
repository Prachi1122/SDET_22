package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.FileUtility;

public class ContactCases {
@Test
public void createContact() throws Throwable {
	WebDriver driver=new ChromeDriver();
	FileUtility fu = new FileUtility();
	
	String URL = fu.getPropertyKeyValue("url");
	String USERNAME = fu.getPropertyKeyValue("username");
	String PASSWORD = fu.getPropertyKeyValue("password");
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[.='Contacts']")).click();
	driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
	driver.findElement(By.id("department")).sendKeys("software");
	driver.findElement(By.id("title")).sendKeys("tssy");
	driver.findElement(By.xpath("//input[@name='button'][1]")).click();
	
}
}