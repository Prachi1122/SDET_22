package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;



public class Home {
	public Home(WebDriver driver) {
		//TO point all the element to login page
		PageFactory.initElements(driver,this);
	}
		@FindBy(xpath="//a[.='More']")
		private WebElement More;
		@FindBy(linkText="Organizations")
		private WebElement orglink;
		@FindBy(name="Purchase Order")
		private WebElement PurchaseOrderLink;
		@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
		private WebElement admin;
		@FindBy(xpath="//a[.='Sign Out']")
		private WebElement signoutbtn;
		
		@FindBy(linkText="Contacts")
		private WebElement contactLink;
		
		public WebElement getContactLink() {
			return contactLink;
		}
		public WebElement getMore() {
			return More;
		}
		public WebElement getOrglink() {
			return orglink;
		}
		public WebElement getPurchaseOrder() {
			return PurchaseOrderLink;
		}
		public WebElement getAdmin() {
			return admin;
		}
		public WebElement getSignoutbtn() {
			return signoutbtn;
		}
		public void homePage(WebDriver driver) {
			WebDriverUtility wu = new WebDriverUtility();
			wu.mouseOver(driver, More);
		}
			public void signOut(WebDriver driver) {
				WebDriverUtility wu = new WebDriverUtility();
				wu.mouseOver(driver,admin );
				signoutbtn.click();
			
		}
}
