package StepDef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import Base.TestBase;
import Pages.DeleteArticle;
import Pages.EditArticle;
import Pages.LoginPage;
import Pages.NewArticle;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArticleStepDef {
	WebDriver driver;
	LoginPage loginPage;
	NewArticle newArticle;
	EditArticle uptArticle;
	DeleteArticle deleteArticle;
	public ArticleStepDef() {
		driver=TestBase.getDriver();
		loginPage=new LoginPage(driver);
		newArticle=new NewArticle(driver);
		uptArticle=new EditArticle(driver);
		deleteArticle=new DeleteArticle(driver);

		
	}
	
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");

	}
	@When("User enters {string} and {string}")
	public void user_enters_and(String strUser, String StrPwd) {
		loginPage.loginIntoApp(strUser, StrPwd);
	    
	}
	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
		Assert.assertTrue(loginPage.isLoginPage());
	 
	}
	@When("User creates new article {string} {string} {string} {string}")
	public void user_creates_new_article(String artTitle, String artDesc, String artMain, String artTag) {
	    newArticle.articleInput(artTitle, artDesc, artMain, artTag);
	}

	@Given("Article is Created {string}")
	public void article_is_created(String strTitle) {
		Assert.assertTrue(newArticle.isArticleCreated(strTitle));
	}
	@When("User updates article")
	public void user_updates_article(DataTable dataTable) throws InterruptedException {
		List<List<String>> uptTit=dataTable.asLists();
		String tit=uptTit.get(0).get(0);
		uptArticle.updateArticle(tit);
    
	}
	@Then("Article is Updated {string}")
	public void article_is_updated(String strTitle) throws InterruptedException{
		Assert.assertTrue(uptArticle.isArticleUpdated(strTitle));
		
		
	}

	@When("User deletes article")
	public void user_deletes_article(io.cucumber.datatable.DataTable dataTable) {
		List<Map<String,String>> uptTit=dataTable.asMaps();
		String tit=uptTit.get(0).get("title");
		deleteArticle.removeArticle(tit);
		
	  
	}
	@Then("Article is Deleted {string}")
	public void article_is_deleted(String string) {
	    
	}


}
