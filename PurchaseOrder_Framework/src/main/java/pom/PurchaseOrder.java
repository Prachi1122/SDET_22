package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrder {

	public  PurchaseOrder(WebDriver driver) {
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(xpath="//img[@title='Create Purchase Order...']")
	private WebElement createpurchaseOrder;
	public WebElement getCreatepurchaseOrder() {
		return createpurchaseOrder;
	}
}
