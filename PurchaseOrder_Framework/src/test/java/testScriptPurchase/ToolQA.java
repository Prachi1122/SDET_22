package testScriptPurchase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.crm.vtiger.GenericUtils.FileUtility;

import com.crm.vtiger.GenericUtils.WebDriverUtility;


public class ToolQA {
	
public static void main (String[] args) throws Throwable {
	WebDriver driver= new ChromeDriver();
	WebDriverUtility wlib= new WebDriverUtility();
	FileUtility flib = new FileUtility();
	wlib.waitUntilPageLoad(driver);
	String URL = flib.getPropertyKeyValue("url1");
	driver.get(URL);
	WebElement move = driver.findElement(By.xpath("//button[@id='toolTipButton']"));
	wlib.mouseOver(driver, move);
	WebElement tool = driver.findElement(By.xpath("//div[text()='You hovered over the Button']"));
	String text = tool.getText();
	driver.findElement(By.id("toolTipTextField")).sendKeys(text);
}
}