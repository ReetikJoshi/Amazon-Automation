package testCases;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.AmazonBasicsPage;
import pageObjects.HomePage;
import pageObjects.ProductsPage;
import pageObjects.ShoppingCartPage;
import pageObjects.SignInPage;
import parent.Base;

public class Add_To_Cart extends Base {

	protected WebDriver driver;// fields
	protected ShoppingCartPage sc;

	@BeforeTest
	public void setUp() throws IOException {

		// Go to the URL and maximize the browser
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();

	}

	@Test
	public void add() throws Exception {

		HomePage home = new HomePage(driver);

		Actions a = new Actions(driver);

		// Click on the dropdown hamburger icon
		a.moveToElement(home.hamburgerMenu()).click().build().perform();

		// Scroll to the Computers category and click it
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", home.computer());
		Thread.sleep(3000);
		home.computer().click();

		// Validate if 'main menu' appears in the top of the dropdown box
		Assert.assertEquals(home.mainMenu().isDisplayed(), true);

		// Click on Laptop Accessories
		home.laptop().click();

		// Verify the title of the page
		Assert.assertEquals(driver.getTitle(), "Amazon.com");

		// Selects 1st product among the displayed products
		ProductsPage prod = new ProductsPage(driver);
		prod.item().click();

		// Verify the title of the page
		Assert.assertEquals(driver.getTitle(),
				"Amazon.com: AmazonBasics Ventilated Adjustable Laptop Computer Holder Desk Stand");

		// Click on Add to Cart button
		AmazonBasicsPage basics = new AmazonBasicsPage(driver);
		basics.addToCart().click();
		Thread.sleep(6000);

		try {

			// Click on close icon inside the sliding side-sheet only if it is present
			a.moveToElement(basics.close()).click().build().perform();
			Thread.sleep(2000);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Click on cart link at the header of the page
			sc = new ShoppingCartPage(driver);
			a.moveToElement(sc.cart()).click().build().perform();
			Thread.sleep(3000);

			// Verify the title of the page
			Assert.assertEquals(driver.getTitle(), "Amazon.com Shopping Cart");

			// Click on Proceed To Checkout button
			a.moveToElement(sc.checkout()).click().build().perform();

			// Verify if we landed on Sign-In page or not
			SignInPage signin = new SignInPage(driver);
			Assert.assertEquals(signin.email().isDisplayed(), true);
			Assert.assertEquals(driver.getTitle(), "Amazon Sign-In");
		}

	}

	@AfterTest
	public void tearDown() {

		// Close the current browser window
		driver.close();

		// Instantiate the driver object to null
		driver = null;
	}

	// NOTE:- Also there is an Extent Reports folder to view the result in nice format
}
