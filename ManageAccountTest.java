//User Story:
//As a user I want to manage my account so that I can view my orders, gift card balance and
//other details related to my account 

//Scenarios:
//Given a signed in account page, I can view my archived orders when i click "View Archived Orders"
// Given a signed in Amazon account page, when I click
//"View Gift Card Balance," then my current gift card balance is shown.


package deliverable3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ManageAccountTest{
		WebDriver driver = new FirefoxDriver();
		
		@Before
		public void setUp() throws Exception {
			driver.get("https://www.amazon.com");

			// Navigate to sign in page
			driver.findElement(By.cssSelector("#nav-signin-tooltip > a.nav-action-button > span.nav-action-inner")).click();

			//Signing in and going to My Account
			driver.findElement(By.id("ap_email")).sendKeys("testingsoftware2955@gmail.com");
			driver.findElement(By.id("ap_password")).sendKeys("qwertyasdf");
			driver.findElement(By.id("signInSubmit-input")).click();
			driver.findElement(By.linkText("Your Account")).click();
		
		}
		
		//Given a signed in account page, I can view my archived orders when i click "View Archived Orders"
		
		@Test
		public void testViewArchivedOrders(){
			
			System.out.println(driver.getPageSource());
			//Click on View Archived orders
			driver.findElement(By.linkText("View Archived Orders")).click();

			//assertion
			// ordersContainer search failing without getPageSource
			System.out.println(driver.getPageSource());
			String observed = driver.findElement(By.id("ordersContainer")).getText();
			assertTrue(observed.contains("There are no archived orders in your account."));
			driver.quit();

		}
		
		// Given a signed in Amazon account page, when I click
		//"View Gift Card Balance," then my current gift card balance is shown.
		@Test
		public void testViewGiftCardBalance() {
			
			// Click on "View Gift Card Balance"
			driver.findElement(By.linkText("View Gift Card Balance")).click();

			// Assertion
			//unable to locate element "h3>span" without getPageSource
			System.out.println(driver.getPageSource());
			String observed = driver.findElement(By.cssSelector("h3 > span")).getText();
			assertTrue(observed.contains("$0.00"));
			driver.quit();
			
		}
	
}












	
	