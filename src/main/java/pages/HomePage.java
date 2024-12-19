package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverSingleton;

public class HomePage {
	private WebDriver driver;
	
	public HomePage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "user-name")
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement logInButton;
	
	@FindBy(id = "item_4_title_link")
	WebElement backPack_item;
	
	@FindBy(css = "#inventory_item_container > div > div > div.inventory_details_desc_container > div.inventory_details_name.large_size")
	WebElement itemName;
	
	@FindBy(id = "add-to-cart")
	WebElement addToCartButton;
	
	
	public void clickSignIn(String email, String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(logInButton));
		userName.sendKeys(email);
		this.password.sendKeys(password);
		logInButton.click();
	}
	
	public void addItemToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(backPack_item));
		backPack_item.click();
		addToCartButton.click();
	}
	
	public String getItemName() {
		return itemName.getText();
	}
	
	
	
	
	
	
	
	
	
	
}
