package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonBasicsPage {

	protected WebDriver driver;

	public AmazonBasicsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "add-to-cart-button")
	WebElement addToCart;

	@FindBy(id = "attach-close_sideSheet-link")
	WebElement close;

	public WebElement addToCart() {
		return addToCart;
	}

	public WebElement close() {
		return close;
	}

}
