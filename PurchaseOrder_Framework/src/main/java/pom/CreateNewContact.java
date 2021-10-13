package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContact {
	public CreateNewContact(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name="lastname")
	private WebElement lastName;
	
	@FindBy(xpath="//img[@src='themes/softed/images/select.gif']")
	private WebElement orgBtn;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getOrgBtn() {
		return orgBtn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
}
