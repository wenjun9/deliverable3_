//User story:
// As a user of Amazon I want to manage my wish lists so that I can store future potential purchases.

//Scenarios:
//Given a signed in Amazon account Wish List page, when I click "Create another Wish List," then a new wish list appears. 	
//Given a signed in Amazon account Wish List page, when I click "Delete item," then the item is no longer found in the wish list. 
// Given a signed in Amazon account Wish List page, when I click "add to the cart," then the item will show in the shopping cart.

package deliverable3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WishListsTest {
    
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
		driver.get("https://www.amazon.com");

		// Navigate to sign in page
		driver.findElement(By.cssSelector("#nav-signin-tooltip > a.nav-action-button > span.nav-action-inner")).click();

		//Signing in 
		driver.findElement(By.id("ap_email")).sendKeys("testingsoftware2955@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("qwertyasdf");
		driver.findElement(By.id("signInSubmit-input")).click();
		
		

	}
	
	
//	Given a signed in Amazon account page, 
//	when I click "Create another Wish List," then a new wish list appears. 
		
	@Test
	public void testCreateWishList(){
		
		System.out.println(driver.getPageSource());
		
		// Navigate to wish list page
		driver.findElement(By.id("nav-link-wishlist")).click();
		driver.findElement(By.linkText("Create a Wish List")).click();
		
		//Click on Create new Wish List 
		driver.findElement(By.linkText("Create another Wish List")).click();
		
		
		//Click on button to finish the new list
		driver.findElement(By.cssSelector("#a-autoid-15 > span.a-button-inner > input.a-button-input.a-declarative")).click();
	



		//assertion
		//the new wish list named:"testingsoftware" have been exist
		System.out.println(driver.getPageSource());
		String observed = driver.findElement(By.id("profile-list-name")).getText();
		assertTrue(observed.contains("testingsoftware's"));
		driver.quit();	

	}
	
	
		
	
//	Given a signed in Amazon account page, when I click
//	when I click "Delete item," then the item is no longer found in the wish list. 
			
			@Test
			public void testDeleteitem() {
				
				System.out.println(driver.getPageSource());
				
				// Navigate to wish list page
				driver.findElement(By.id("nav-link-wishlist")).click();
				driver.findElement(By.linkText("Create a Wish List")).click();
//				driver.findElement(By.id("nav-flyout-wishlist")).click();
				
//				driver.findElement(By.linkText("New Wish List")).click();
				
				//Click on delete button 
				driver.findElement(By.cssSelector("#a-autoid-12 > span.a-button-inner > input.a-button-input.a-declarative")).click();
				
				
				//assertion
				
				// Navigate to wish list page
				driver.findElement(By.id("nav-link-wishlist")).click();
				driver.findElement(By.linkText("Create a Wish List")).click();	
				//the item has been deleted 
				System.out.println(driver.getPageSource());
				String observed = driver.findElement(By.id("no-item-view")).getText();
				assertTrue(observed.contains("0 items on list"));
				driver.quit();	
			
				
			}
			
	
//	 Given a signed in Amazon account page, when I click
//   when I click "add to the cart," then the item will show in the shopping cart.
					
			@Test
			public void testAdditemtoCart() {
				
				System.out.println(driver.getPageSource());
						
			    // Navigate to wish list page
//				driver.findElement(By.id("nav-link-wishlist.nav-text")).click();
//////				driver.findElement(By.linkText("Find a Gift")).click();	
//			    driver.findElement(By.linkText("List1")).click();
			    
			    driver.findElement(By.id("nav-link-wishlist")).click();
				driver.findElement(By.linkText("Create a Wish List")).click();
//				driver.findElement(By.linkText("New wish list")).click();
//				driver.findElement(By.linkText("New Wish List(1)")).click();
				
//				driver.findElement(By.cssSelector("a#nav-link-wishlist.nav-a.nav-a-2")).click();
//				driver.findElement(By.cssSelector("nav-link.nav-item")).click();
				
				
				//Click on add to cart button 
//				driver.findElement(By.cssSelector("#a-autoid-10 > span.a-button-inner > input.a-button-input.a-declarative")).click();
//				
                
				//assertion
				
				// Navigate to cart page
				driver.findElement(By.cssSelector("span.nav-cart-icon.nav-sprite")).click();
				
				//the item has been added to the cart 
				System.out.println(driver.getPageSource());
				WebElement element = driver.findElement(By.id("activeCartViewForm"));
				assertTrue(element.getText().contains("The Gift of Music"));
				driver.quit();
				
				
						
					}
						
						

}
