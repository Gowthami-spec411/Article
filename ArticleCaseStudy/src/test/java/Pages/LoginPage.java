package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	@FindBy(name="email")
	WebElement uname;
	
	
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//button[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(linkText="New Article")
	WebElement newArt;
	
	@FindBy(xpath="//img[@alt='gowthami']")
	WebElement succLogin;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginIntoApp(String strUser, String StrPwd) {
		System.out.println("LOGIN METHOD");
		uname.sendKeys(strUser);
		pwd.sendKeys(StrPwd);
		loginBtn.click();
		newArt.click();
	}
	
	public boolean isLoginPage() {
		if(succLogin.isDisplayed()) {
			System.out.println("Login is Successfull!!");
			return true;
		}
		else {
			return false;
		}
	}

}
