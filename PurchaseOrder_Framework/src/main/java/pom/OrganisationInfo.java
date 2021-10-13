package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfo {
public OrganisationInfo(WebDriver driver) {
		
		PageFactory.initElements(driver,this);
	}
@FindBy(xpath="//span[@class='dvHeaderText']")
private WebElement sucessFullMsg;
public WebElement getSucessFullMsg() {
	return sucessFullMsg;
}

}


