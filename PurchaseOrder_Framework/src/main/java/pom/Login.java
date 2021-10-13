package pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.FileUtility;

public class Login {
	
	public Login(WebDriver driver) {
		//TO point all the element to login page
		PageFactory.initElements(driver,this);
		
	}
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement userPasswordEdt;
	
 @FindBy(xpath="//input[@id='submitButton']")

	private WebElement loginBtn;
 //right click,source,generate getter and setter take only getter
public WebElement getUserNameEdt() {
	return userNameEdt;
}

public WebElement getUserPasswordEdt() {
	return userPasswordEdt;
}

public WebElement getLoginBtn() {
	return loginBtn;
}
public void loginToApp(WebDriver driver) throws Throwable {
	FileUtility fu = new FileUtility();
	
	String URL = fu.getPropertyKeyValue("url");
	String USERNAME = fu.getPropertyKeyValue("username");
	String PASSWORD = fu.getPropertyKeyValue("password");
	driver.get(URL);
	userNameEdt.sendKeys(USERNAME );
	userPasswordEdt.sendKeys(PASSWORD);
	loginBtn.click();
	}
 
}