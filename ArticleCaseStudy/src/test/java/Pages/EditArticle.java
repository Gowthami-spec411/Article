package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditArticle {
	
	WebDriver driver;
	WebDriverWait expWait;
	
	@FindBy(xpath="//a[text()=' Edit Article']")
	WebElement editArt;
	
	@FindBy(xpath="//input[@name='title']")
	WebElement artTitle;
	
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement updateArt;
	
	@FindBy(tagName="h1")
	WebElement chkUpdArt;
	
	
	public EditArticle(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		expWait=new WebDriverWait(driver, Duration.ofSeconds(20));
	}
	
	
	public void updateArticle(String strTitle) throws InterruptedException{
		editArt.click();
		artTitle.clear();
		artTitle.sendKeys(strTitle);
		updateArt.click();
		//Thread.sleep(1000);
	}
	
	
	public boolean isArticleUpdated(String strTit) throws InterruptedException{
		
		expWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.tagName("h1")),strTit));
		if(chkUpdArt.isDisplayed()) {
			
			System.out.println("Article Update is Successful!!"+chkUpdArt.getText());
			return true;
			
		}
		else {
			return false;
		}
		
	}
	
	
}
