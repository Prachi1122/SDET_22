package testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.FileUtility;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class TC_16 {
	@Test
	public void createPurchaseOrder5() throws Throwable {
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
WebElement status = driver.findElement(By.name("postatus"));
wb.SelectOption(status, 1);
}
}