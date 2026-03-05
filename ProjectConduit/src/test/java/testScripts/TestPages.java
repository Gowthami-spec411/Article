package testScripts;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.TestBase;
import pages.Article;
import pages.LoginPage;


public class TestPages {
	WebDriver driver;
	LoginPage login;
	Article newArt;
	
	@BeforeTest
	public void setup() {
		TestBase.initDriver();
		driver=TestBase.getDriver();
		TestBase.OpenUrl("https://conduit-realworld-example-app.fly.dev/#/login");
		login=new LoginPage(driver);
		newArt=new Article(driver);
		
		
	}
	@Test(priority=1)
	public void validLoginTest() {
		login.logIntoApp("thupakulagowthami@gmail.com", "Ganeshu@123");
	}
	
	
	@Test(priority=2)
	public void publishArticleTest() {
		Assert.assertTrue(newArt.isUserLoggedin());
		newArt.publishArticle("Gowthami", "My First Article", "Testing purpose", "#gowthu");
	}
	
	
	//@Test(priority=3)
	//public void editArticleTest() {
		//newArt.publishArticle("ganesh", "My First Article edit", "Testing purpose edit", "#gowthu");
		//Assert.assertTrue(newArt.isArticlePublished());
//	}
	
	//@Test(priority=4)
	
	//public void deleteArticleTest() {
	//	newArt.deleteArticle();
	//}
	//@AfterTest
	//public void closeApp() {
	//	TestBase.tearDown();
//	}

	
	

}
