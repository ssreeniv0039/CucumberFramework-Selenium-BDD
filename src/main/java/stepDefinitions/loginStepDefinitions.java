//package stepDefinitions;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
//
//import com.crm.pages.HomePage;
//import com.crm.pages.LoginPage;
//import com.crm.util.TestBase;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class loginStepDefinitions extends TestBase{
//	LoginPage loginPage;
//	HomePage homePage;
//	
//	@Given("^user is already on login page$")
//	public void user_is_already_on_login_page(){
//			TestBase.initialization();
//		//to fetch the data from workbook
//	}
//
//	@When("^title of the login page is Free CRM$")
//	public void title_of_the_login_page_is_Free_CRM(){
//		loginPage = new LoginPage();
//		String loginTitle = loginPage.validateLoginPageTitle();
//		System.out.println(loginTitle);
//		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.", loginTitle);
//	}
//
//	@Then("^user logs into the app$")
//	public void user_logs_into_the_app() {
//		homePage = loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
//	}
//
//	@Then("^user clicks on login button$")
//	public void user_clicks_on_login_button(){
//	  driver.findElement(By.xpath("//input[@type = 'submit' and @value = 'Login']")).click();
//	}
//	
//	@Then("^validate home page title$")
//	public void validate_home_page_title(){
//		String homePageTitle = homePage.verifyHomePageTitle();
//		Assert.assertEquals("CRMPRO", homePageTitle);
//	}
//	
//	@Then("^validate logged in username$")
//	public void validate_logged_in_username() {
//	boolean flag =  homePage.verifyCorrectUserName();
//	Assert.assertTrue(flag);
//	}
//	@Then("^Close the browser$")
//	public void close_the_browser(){
//		driver.quit();
//	}
//	
//	
//
//}
