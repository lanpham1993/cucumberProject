package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageFactory.LoginPage_FP;

public class LoginSteps_PF {
	WebDriver driver = null;
	LoginPage_FP login;
	
	@Given("^browser is open$")
	public void browser_is_open() {
	    String projectPath= System.getProperty("user.dir");
	    System.out.println("Project path:" + projectPath);
	    System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/drivers/chromedriver.exe");
	    		
	    driver = new ChromeDriver();
	    
	    driver.manage().timeouts().implicitlyWait(40,TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
	    
	    driver.manage().window().maximize();
	    
	} 
	
	@And("^user is on login page$")
	public void user_is_on_login_page() {
	    driver.navigate().to("https://www.saucedemo.com/");
	}

	@When("^user enters (.*) and (.*)$")
	public void user_enters_username_and_password(String user, String pass) throws InterruptedException {
		login = new LoginPage_FP(driver);
		login.enterUsername(user);
		login.enterPassword(pass);
	   Thread.sleep(2000);
	}
	
	@And("^user clicks on login$")
	public void user_clicks_on_login() {
		login.clickLogin();
		   
	}


	@Then("^user is navigated to the home page$")
	public void user_is_navigated_to_the_home_page() throws InterruptedException {
		
		login.checkTitle();
	Thread.sleep(2000);
	   driver.quit();
	}
	

@Then("^Error will be displayed$")
public void error_will_be_displayed() throws InterruptedException {
	 Thread.sleep(2000);
    login.checkErrorMessage();
	driver.quit();
}


}
