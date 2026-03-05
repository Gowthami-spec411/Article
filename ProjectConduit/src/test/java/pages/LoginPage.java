package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy(xpath="//input[@name='email']")
	WebElement uname;
	@FindBy(xpath="//input[@name='password']")
	WebElement pwd;
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement loginBtn;
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public void logIntoApp(String strUser,String strPwd) {
		uname.sendKeys(strUser);
		pwd.sendKeys(strPwd);
		loginBtn.click();
	}
	


}
