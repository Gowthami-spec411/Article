package Pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteArticle {
	
	WebDriver driver;
	
	@FindBy(xpath="//button[contains(text(), 'Delete Article')]")
	WebElement delArt;
	
	@FindBy(xpath="//button[@class='nav-link active']")
	WebElement gblFeed;
	
	@FindAll({@FindBy(tagName="h1")})
	List<WebElement> chkTag;
	
	
	public DeleteArticle(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void removeArticle(String strArtTitle) {
		delArt.click();
		String parentWin=driver.getWindowHandle();
		
		Alert delAlert=driver.switchTo().alert();
		delAlert.accept();
		
		driver.switchTo().window(parentWin);
		gblFeed.click();
		
	}
	public boolean isArticleDeleted(String strTit) {
		String tmpTitle;
		for(int i=0; i<chkTag.size(); i++) {
			tmpTitle=chkTag.get(i).getText();
			if(!tmpTitle.equalsIgnoreCase(strTit)) {
				System.out.println("Article Deletion is successfull!!");
				return true;
			}
		}
		return false;
	}

}
