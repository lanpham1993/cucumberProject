package pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class LoginPage {
	
    protected WebDriver driver;
	private By txt_username = By.id("user-name");
	private By txt_password = By.id("password");
	private By btn_login = By.id("login-button");
	private By msg_error = By.xpath("//h3[@data-test='error']");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		if(!driver.getTitle().equals("Swag Labs")) {
			throw new IllegalStateException("this is not Login page. The current page is:" + driver.getCurrentUrl());
		}
	}
	
	public void enterUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	

	public void clickLogin() {
		driver.findElement(btn_login).click();
	}
	
	public void loginValidUser(String username,String password) {
		driver.findElement(txt_username).sendKeys(username);
		driver.findElement(txt_password).sendKeys(password);
		driver.findElement(btn_login).click();
	}
	
	public void checkTitle() {
		 assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());
	}
	
	public void checkErrorMessage() {
		String msg = driver.findElement(msg_error).getText();
		assertEquals("Epic sadface: Sorry, this user has been locked out.",msg );
	}
}
