package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.build.HashCodeAndEqualsPlugin.Identity;

public class Article {
	@FindBy(xpath="//*[@id=\"root\"]/header/nav/div/ul[2]/li[3]/div[1]")
	WebElement user;
	
	@FindBy(xpath="//*[@id=\"root\"]/header/nav/div/ul[2]/li[3]/div[2]/a[1]")
	WebElement profile;
	
	@FindBy(xpath="//*[@id=\"root\"]/main/div/div[2]/div/div/div[*]/a")
	WebElement articles;
	
	@FindBy(xpath="//a[normalize-space()='New Article']")
	WebElement newArticle;
	
	@FindBy(css="input[placeholder='Article Title']")
	WebElement title;
	
	@FindBy(css="input[placeholder=\"What's this article about?\"]")
	WebElement about;
	
	@FindBy(css="textarea[placeholder='Write your article (in markdown)']")
	WebElement content;
	
	@FindBy(css="input[placeholder='Enter tags']")
	WebElement tags;
	
	@FindBy(xpath="//button[contains(text(), 'Publish Article')]")
	WebElement pubBtn;
	
	@FindBy(css="a.nav-link")
	WebElement editArticle;
	
	
	@FindBy(xpath="//button[contains(text(), 'Delete Article')]")
	WebElement deleteArticle;


	public Article(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public boolean isUserLoggedin() {
		return user.isDisplayed();
	}
	public void publishArticle(String strTitle,String strAbout,String strContent,String strTags) {
		newArticle.click();
		title.sendKeys(strTitle);
		about.sendKeys(strAbout);
		content.sendKeys(strContent);
		tags.sendKeys(strTags);
		pubBtn.click();
	}
	public boolean isArticlePublished() {
		user.click();
		profile.click();
		return articles.isSelected();
	}
	public void editArticle(String strTitle,String strAbout,String strContent,String strTags) {
		editArticle.click();
		title.clear();
		title.sendKeys(strTitle);
		about.sendKeys(strAbout);
		content.sendKeys(strContent);
		tags.sendKeys(strTags);
		pubBtn.click();
	}
	public void deleteArticle() {
		deleteArticle.click();
	}

}
