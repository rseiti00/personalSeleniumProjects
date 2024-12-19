package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import drivers.DriverSingleton;

public class SignInPage {
	private WebDriver driver;
	
	public SignInPage(){
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	private WebElement signInEmail;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "login-button")
	private WebElement logInButton;
	
	public void logIn(String email, String password) {
		signInEmail.sendKeys(email);
		this.password.sendKeys(password);
		logInButton.click();
	}

}
