package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.BaseClass;
import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class CreateNewContact extends BaseClass {
	public CreateNewContact(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(xpath="//select[@name='leadsource']")
	private WebElement leadsource;
	
	@FindBy(xpath="//input[@name='emailoptout']")
	private WebElement emailoptout;
	
	@FindBy(xpath="//input[@type='text' and @name ='search_text']")
	private WebElement searchText;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement search;
	
	@FindBy(xpath="//a[@href='javascript:window.close();']")
	private WebElement orgName;
	@FindBy(id="search_txt")
	private WebElement searchbtn;
	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement contactLink;
	
	public WebElement getContactLink() {
		return contactLink;
	}
	
	public WebElement getOrgName() {
		return orgName;
	}
	public WebElement getSearch() {
		return search;
	}
	public WebElement getSearchText() {
		return searchText;
	}
	public WebElement getEmailoptout() {
		return emailoptout;
	}
	public WebElement getLeadsource() {
		return leadsource;
	}
	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getOrgBtn() {
		return orgBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void organisatio() throws Throwable {
		getLastName().sendKeys("pachi"+jLib.getRandomData());
		getLeadsource().click();
		wLib.SelectOption(leadsource, 4);
		getEmailoptout().click();
		getSaveBtn().click();
		
		
	}
}
