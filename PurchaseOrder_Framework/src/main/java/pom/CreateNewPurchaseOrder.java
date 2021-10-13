package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateNewPurchaseOrder extends WebDriverUtility {
	WebDriver driver;
	public  CreateNewPurchaseOrder(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	 @FindBy(xpath="//input[@value='U']")
		private WebElement userbtn;
	 
	 public WebElement getUserbtn() {
			return userbtn;
			
		}
	 
	 @FindBy(xpath="//select[@name='assigned_user_id']")
		private WebElement selectOption;
	 
	 public WebElement getSelectOption() {
			return selectOption;
	 }
	 
	 @FindBy(xpath="//input[@value='T']")
	 private WebElement groupBtn;
	 
	 public WebElement getGroupBtn() {
		return groupBtn;
	}
	@FindBy(xpath="//select[@name='assigned_group_id']")
	 private WebElement selectGroupOption;
	 
	public WebElement getSelectGroupOption() {
		return selectGroupOption;
	}

		public void groupMarketing() {
		waitForElementVisibility(driver,getGroupBtn());
		getGroupBtn().click();
		
		WebDriverUtility wb = new WebDriverUtility();

	wb.SelectOption(selectGroupOption,0);
}

		public void groupSupport() {
		waitForElementVisibility(driver,getGroupBtn());
		getGroupBtn().click();
		
		WebDriverUtility wb = new WebDriverUtility();

	wb.SelectOption(selectGroupOption,1);
}
		public void groupSellingTeam() {
			waitForElementVisibility(driver,getGroupBtn());
			getGroupBtn().click();
			
			WebDriverUtility wb = new WebDriverUtility();

		wb.SelectOption(selectGroupOption,2);
	}	
}


