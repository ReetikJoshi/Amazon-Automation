package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	protected WebDriver driver;

	public ShoppingCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-cart")
	WebElement cart;

	@FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
	WebElement checkout;

	public WebElement cart() {
		return cart;
	}

	public WebElement checkout() {
		return checkout;
	}
}
