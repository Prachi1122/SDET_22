package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.BaseClass;

public class OrgLookUp extends  BaseClass{

	@FindBy(xpath="//a[@id='1']")
	private WebElement FirstOrgName;
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchBox;
	@FindBy(xpath="//input[@type ='button']")
	private WebElement searchBtn;
	
	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getFirstOrgName() {
		return FirstOrgName;
	}
	
	public OrgLookUp(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void selectOrg() throws InterruptedException
	{
		searchBox.sendKeys("TYSs");
		getSearchBtn().click();
	}
		
}