

import org.openqa.selenium.WebDriver;

import drivers.DriverSingleton;
import pages.CartPage;
import pages.HomePage;

public class Main {
	public static void main(String[] args) {
		//FrameworkProperties frameworkProperties = new FrameworkProperties();
		DriverSingleton driverSingleton = DriverSingleton.getInstance();
		WebDriver driver = DriverSingleton.getDriver();
		driver.get("https://www.saucedemo.com/");

		
		CartPage cartPage = new CartPage();
		
		cartPage.clickSignIn("standard_user", "secret_sauce");
		cartPage.addItemToCart();
		cartPage.proceedToCheckOut("Renato", "Tsuchida", "01010010");
		
		DriverSingleton.closedObjectInstance();
	}
	
	
}
