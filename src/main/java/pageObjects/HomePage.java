package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "nav-hamburger-menu")
	WebElement hamburgerMenu;

	@FindBy(xpath = "//div[text()='Computers']")
	WebElement computer;

	@FindBy(xpath = "//ul[@class='hmenu hmenu-visible hmenu-translateX']//div[contains(text(),'main menu')]")
	WebElement mainMenu;

	@FindBy(xpath = "//a[text()='Laptop Accessories']")
	WebElement laptop;

	public WebElement hamburgerMenu() {
		return hamburgerMenu;
	}

	public WebElement computer() {
		return computer;
	}

	public WebElement mainMenu() {
		return mainMenu;
	}

	public WebElement laptop() {
		return laptop;
	}

}
