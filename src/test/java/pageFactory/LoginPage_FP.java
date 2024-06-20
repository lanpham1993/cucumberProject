package pageFactory;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage_FP {

	@FindBy(id="user-name")
	WebElement txt_username;
	
	@FindBy(id="password")
	WebElement txt_password;
	
	@FindBy(id="login-button")
	WebElement btn_login;
	
	@FindBy(xpath="//h3[@data-test='error']")
	WebElement msg_error;
	
	WebDriver driver;
	
	public LoginPage_FP(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String pass) {
		txt_password.sendKeys(pass);
	}
	
	public void clickLogin() {
		btn_login.click();
	}
	
	public void checkTitle() {
		 assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
	}
	
	public void checkErrorMessage() {
		String msg = msg_error.getText();
		assertEquals("Epic sadface: Sorry, this user has been locked out.",msg );
	}
}
