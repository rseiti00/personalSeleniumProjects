package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import drivers.DriverSingleton;
import utils.Constants;

public class CartPage {
	
	private WebDriver driver;
	
	public CartPage() {
		driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id = "user-name")
	WebElement userName;
	
	@FindBy(id = "password")
	WebElement password;
	
	@FindBy(id = "login-button")
	WebElement logInButton;
	
	@FindBy(id = "item_0_title_link")
	WebElement itemToBeAdded;
	
	@FindBy(id = "add-to-cart-sauce-labs-bike-light")
	WebElement addToCartButton;
	
	@FindBy(css = "#shopping_cart_container > a > span")
	WebElement cartButton;
	
	@FindBy(css = "#header_container > div.header_secondary_container > span")
	WebElement cartText;

	@FindBy(id = "checkout")
	WebElement checkOutButton;
	
	@FindBy(id = "first-name")
	WebElement firstName;
	
	@FindBy(id = "last-name")
	WebElement lastName;
	
	@FindBy(id = "postal-code")
	WebElement zipCode;
	
	@FindBy(id = "continue")
	WebElement continueButton;
	
	@FindBy(id = "finish")
	WebElement finishButton;
	
	@FindBy(css = "#checkout_complete_container > h2")
	WebElement finishText;
	
	public void clickSignIn(String email, String password) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(logInButton));
		userName.sendKeys(email);
		this.password.sendKeys(password);
		logInButton.click();
	}
	
	public void addItemToCart() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
		
		if(itemToBeAdded.getText().equals("Sauce Labs Bike Light") ) {
			addToCartButton.click();
		}else {
			System.out.println("item não localizado");
		}
		
		if(cartButton.getText().contains(Constants.CART_QUANTITY)) {
			System.out.println("Cart has been updated!");
		}else {
			System.out.println("Cart has NOT been updated!");
		}
	}
	
	public void proceedToCheckOut(String firstName, String lastName, String zipCode) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.elementToBeClickable(cartButton));
		
		cartButton.click();
		
		if(cartText.getText().equals("Your Cart")) {
			System.out.println("Cart has accessed");
		}else {
			System.out.println("Cart has not been accessed");
		}
		
		if(itemToBeAdded.getText().equals("Sauce Labs Bike Light") ) {
			checkOutButton.click();
			this.firstName.sendKeys(firstName);
			this.lastName.sendKeys(lastName);
			this.zipCode.sendKeys(zipCode);
			continueButton.click();
			finishButton.click();
			
			if(finishText.getText().equals("Thank you for your order!")) {
				System.out.println("Test end-to-end passed");
			}else {
				System.out.println("Test failed");
			}
		}
		
	}
	
	
	

}
