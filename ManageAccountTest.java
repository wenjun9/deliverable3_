//As a user I want to manage my account so that I can edit my details or orders

//Scenarios:
//GIvem a signed in account page, I can add a new address


package deliverable3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;


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
			//driver.findElement(By.xpath("//li[3]/a")).click();
			//driver.findElement(By.xpath("//a[contains(@href, 'https://www.amazon.com/gp/your-account/order-history?ie=UTF8&orderFilter=archived&ref_=ya_view_archived_orders_link')]")).click();


			//assertion
			// ordersContainer search failing without this
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
			System.out.println(driver.getPageSource());
			String observed = driver.findElement(By.cssSelector("h3 > span")).getText();
			// () xpath("//div[@id='ordersContainer']/div/div")).getText();
			assertTrue(observed.contains("$0.00"));
			//assertEquals("$0.00", driver.findElement(By.cssSelector("h3 > span")).getText());
			driver.quit();
		}
		

	
}

/*
 * assertEquals("$0.00", driver.findElement(By.xpath("//h3/span")).getText());
driver.get(baseUrl + "/gp/your-account/order-history?ie=UTF8&orderFilter=archived&ref_=ya_view_archived_orders_link");
driver.findElement(By.xpath("//a[contains(text(),'Your Account')]")).click();
driver.findElement(By.linkText("View Gift Card Balance")).click();
assertEquals("$0.00", driver.findElement(By.cssSelector("h3 > span")).getText());

 * driver.get(baseUrl + "/ap/signin?_encoding=UTF8&openid.assoc_handle=usflex&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.mode=checkid_setup&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&openid.ns.pape=http%3A%2F%2Fspecs.openid.net%2Fextensions%2Fpape%2F1.0&openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2Fgp%2Fyourstore%2Fhome%3Fie%3DUTF8%26action%3Dsign-out%26path%3D%252Fgp%252Fyourstore%252Fhome%26ref_%3Dnav_youraccount_signout%26signIn%3D1%26useRedirectOnSuccess%3D1");
driver.findElement(By.id("ap_password")).clear();
driver.findElement(By.id("ap_password")).sendKeys("qwertyasdf");
driver.findElement(By.id("ap_email")).clear();
driver.findElement(By.id("ap_email")).sendKeys("testingsoftware2955@gmail.com");
driver.findElement(By.id("signInSubmit-input")).click();
driver.findElement(By.xpath("//a[contains(text(),'Your Account')]")).click();
driver.findElement(By.linkText("View Archived Orders")).click();
assertTrue(isElementPresent(By.xpath("//div[@id='ordersContainer']/div/div")));*/












	
	