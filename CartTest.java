//User story:
// As a user of Amazon, I want to manage my cart so that I can manage what I want to buy finally

//Scenarios:
//Given a product's page, when I click on "Add to Cart", the item is visible in my Cart
//Given the Cart , when I add one more of the same product, the cart is updated with the item's new quantity

package deliverable3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CartTest {
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception{
		driver.get("http://www.amazon.com");
	}
	
	//Given the amazon homepage, when I click on the cart without adding any items, it shows,
	//"Your shopping cart is empty"
	@Test
	public void testCartWithNoItems(){
		
		//Click on the Cart icon
		driver.findElement(By.cssSelector("span.nav-cart-icon.nav-sprite")).click();
		
		//assertion
		System.out.println(driver.getPageSource());
		assertEquals("Your Shopping Cart is empty.", driver.findElement(By.cssSelector("h1")).getText());
		driver.quit();

	}
	
	//Given a products page on Amazon, when I click "Add to Cart", then the item is visible in the Cart.
	@Test
	public void testAddToCart() {
		
		//Click on search box and type the product name
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("tale of two cities");
		
		//Click search icon on the right of text box
		driver.findElement(By.cssSelector("input.nav-input")).click();
		
		//Click on first result
		try {
			driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//Click add to cart
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Click on cart
		driver.findElement(By.cssSelector("span.nav-cart-icon.nav-sprite")).click();
		
		//assertion
		WebElement element = driver.findElement(By.id("activeCartViewForm"));
		assertTrue(element.getText().contains("A Tale of Two Cities"));
		//assertEquals("A Tale of Two Cities (Dover Thrift Editions)", driver.findElement(By.xpath("//form[@id='activeCartViewForm']/div[2]/div/div[4]/div[2]/div/div/div/div[2]/ul/li/span/a/span")).getText());
		driver.quit();
	}
	
		
	//Given the Cart , when I add one more of the same product, the cart is updated with the item's new quantity
	@Test
	public void testItemQuantity(){

		
		//Click on search bar and type the product name
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("tale of two cities");
		
		//click on the search icon
		driver.findElement(By.cssSelector("input.nav-input")).click();
		
		//click on the first result
		try {
			driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//click on add to cart button
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//Click on search bar and type the product name
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("tale of two cities");
		
		//click on the search icon
		driver.findElement(By.cssSelector("input.nav-input")).click();
		
		//click on the first result
		try {
			driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//click on add to cart button
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.findElement(By.id("add-to-cart-button")).click();
		
		//click on cart button
		System.out.println(driver.getPageSource());
		driver.findElement(By.cssSelector("span.nav-cart-icon.nav-sprite")).click();
		
		//assertion
		WebElement element = driver.findElement(By.cssSelector("p.a-spacing-none.a-spacing-top-mini"));
		assertTrue(element.getText().contains("updated to 2"));
			driver.quit();
				
		}
		
		
		
}


