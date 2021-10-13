package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganization {
public CreateNewOrganization(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
@FindBy(name="accountname")
private WebElement orgNameEdt;

@FindBy(xpath="//input[@title='Save [Alt+S]']")
private WebElement saveBtn;

public WebElement getOrgNameEdt() {
	return orgNameEdt;
}
public WebElement getSaveBtn() {
	return saveBtn;
}

	public void CreateContactWithOrg() {
		
	}
	//driver.findElement(By.xpath("//a[text()='Udmey 101']")).click();
	

public void createOrg(String OrgName) {
	orgNameEdt.sendKeys(OrgName);
	saveBtn.click();
}

}
