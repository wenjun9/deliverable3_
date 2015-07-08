
//User story:
// As a user of Amazon, I want to sign in so that I can buy things

//Scenarios:
//Given the sign-in page, when I enter the correct username and correct password, then I am signed into my account.
//Given the sign-in page, when I enter the incorrect username and incorrect password, then I am prevented from signing into my account and get an error message.
//Given the sign-in page, when I enter the incorrect username and correct password, then I am prevented from signing into my account and get an error message.
//Given the sign-in page, when I enter the correct username and incorrect password, then I am prevented from signing into my account and receive an error message.

package deliverable3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SignInTest {
	WebDriver driver = new FirefoxDriver();
	
	@Before
	public void setUp() throws Exception {
		driver.get("https://www.amazon.com");

		// Navigate to sign in page
		driver.findElement(By.cssSelector("#nav-signin-tooltip > a.nav-action-button > span.nav-action-inner")).click();
	
	}
	
	 // Given the Amazon sign-in page, when I enter the correct username and correct
	 //password, then I am signed into my account.
	 
	@Test
	public void testCorrectUsernameAndPassword() {
		

		// Click on text box for email address and enter correct email
		driver.findElement(By.id("ap_email")).sendKeys("testingsoftware2955@gmail.com");

		// Click on text box for password and enter correct password
		driver.findElement(By.id("ap_password")).sendKeys("qwertyasdf");

		// Click "Sign in using our secure server"
		driver.findElement(By.id("signInSubmit-input")).click();

		// Assertion
		WebElement element = driver.findElement(By.id("nav-your-amazon"));
		assertEquals(element.getText(), "testing...'s Amazon.com");
		driver.quit();
	}
	
		//Given the sign-in page, when I enter the incorrect username and correct password, then I am prevented
		//from signing into my account and get an error message.	
		@Test
	    public void testIncorrectUsername() {
		
		driver.findElement(By.id("ap_email")).sendKeys("gudm@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("qwertyasdf");

		// Click "Sign in using our secure server"
		driver.findElement(By.id("signInSubmit-input")).click();

		// Assertion
		WebElement element = driver.findElement(By.id("message_error"));
		assertNotNull(element);
		driver.quit();
	}
		
		//Given the sign-in page, when I enter the correct username and incorrect password, then I am prevented
		//from signing into my account and get an error message.
		@Test
		public void testIncorrectPassword() {
			
			driver.findElement(By.id("ap_email")).sendKeys("testingsoftware2955@gmail.com");
			driver.findElement(By.id("ap_password")).sendKeys("kjloy");
	
			// Click "Sign in using our secure server"
			driver.findElement(By.id("signInSubmit-input")).click();
	
			// Assertion
			WebElement element = driver.findElement(By.id("message_error"));
			assertNotNull(element);
			driver.quit();
		}
	
	
		//Given the sign-in page, when I enter the incorrect username and incorrect password, then I am prevented
		//from signing into my account and get an error message.
		@Test
		public void testIncorrectUsernameAndPassword() {
			
			driver.findElement(By.id("ap_email")).sendKeys("gudm@gmail.com");
			driver.findElement(By.id("ap_password")).sendKeys("dhfgh");
	
			// Click "Sign in using our secure server"
			driver.findElement(By.id("signInSubmit-input")).click();
	
			// Assertion
			WebElement element = driver.findElement(By.id("message_error"));
			assertNotNull(element);
			driver.quit();;
		}
	
}
