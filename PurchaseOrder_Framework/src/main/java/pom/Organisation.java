package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Organisation {
	WebDriver driver;
	public Organisation(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement createOrgImg;
	public WebElement getCreateOrgImg() {
		return createOrgImg;
	}
	
	@FindBy(xpath="//input[@name='search_text']")
	private WebElement searchTextBox;
	public WebElement getSearchTextBox() {
		return searchTextBox;
	}
	@FindBy(name="search")
	private WebElement searchButton;
	public WebElement getSearchButton() {
		return searchButton;
	}
	
	}
	

