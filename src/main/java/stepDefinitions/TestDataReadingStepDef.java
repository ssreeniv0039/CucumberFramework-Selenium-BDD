package stepDefinitions;

import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.crm.excel.utility.ExcelHandler;

import com.crm.excel.utility.TestDataHandler;
import com.crm.excel.utility.Xls_Reader;
import com.crm.pages.HomePage;
import com.crm.pages.LoginPage;
import com.crm.util.TestBase;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestDataReadingStepDef extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestDataHandler testdata = new TestDataHandler();

	@Given("^read testdata for (\\w+)$")
	public void read_testdata_for_tc_(String arg1) throws Throwable {
		Map<String, String> testDataInMap = ExcelHandler.getTestDataInMap(prop.getProperty("testdatafilepath"),prop.getProperty("sheetname"), arg1);
		String data = testDataInMap.get("Scenarios");
		System.out.println(data);
		testdata.setTestDataInMap(testDataInMap);
	}

	@When("^user is already on login page$")
	public void user_is_already_on_login_page() throws Throwable {
		TestBase.initialization();
		loginPage = new LoginPage();
		String loginTitle = loginPage.validateLoginPageTitle();
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.",
				loginTitle);
	}

	@Then("^user enters username and password$")
	public void user_enters_username_and_password() throws Throwable {
		Map<String, String> testdataINMap = testdata.getTestDataInMap();
		String usn = testdataINMap.get("Username");
		Map<String, String> testdataINMap1 = testdata.getTestDataInMap();
		String pwd = testdataINMap1.get("Password");
		homePage = loginPage.login(usn, pwd);

	}

	@Then("^validate home page title$")
	public void validate_home_page_title() throws Throwable {
		String homePageTitle = homePage.verifyHomePageTitle();	
		Assert.assertEquals("CRMPRO", homePageTitle);
	}
	@Then("^user updates the result into the excelfile for (\\w+)$")
	public void user_updates_the_result_into_the_excelfile_for_tc_(String arg1) throws Throwable {
		String homePageTitle = homePage.verifyHomePageTitle();	
		String tcStatus = null;
		if(homePageTitle.equalsIgnoreCase("CRMPRO")) {
			tcStatus = "PASS";
		}else {
			tcStatus = "FAIL";
		}
		ExcelHandler.UpdateTestResultsToExcel(prop.getProperty("testdatafilepath"), prop.getProperty("sheetname"), tcStatus, arg1);
	}

@Then("^user quits the browser$")
public void user_quits_the_browser() throws Throwable {
	driver.quit();
}
}
