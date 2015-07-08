
//User story:
// As a user of Amazon, I want to sign in so that I can buy things

//Scenarios:
//Given the sign-in page, when I enter the correct username and correct password, then I am signed into my account.
//Given the sign-in page, when I enter the incorrect username and incorrect password, then I am prevented from signing into my account and get an error message.
//Given the sign-in page, when I enter the incorrect username and correct password, then I am prevented from signing into my account and get an error message.
//Given the sign-in page, when I enter the correct username and incorrect password, then I am prevented from signing into my account and receive an error message.



package deliverable3;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;




public class SignInTest {
	
	 // Given the Amazon sign-in page, when I enter the correct username and correct
	 //password, then I am signed into my account.
	 
	@Test
	public void testCorrectUsernameandPassword() {
		

		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.com");

		// Navigate to sign-in page
		driver.findElement(By.cssSelector("#nav-signin-tooltip > a.nav-action-button > span.nav-action-inner")).click();

		// Click on text box for email address and enter correct email
		driver.findElement(By.id("ap_email")).sendKeys("testingsoftware2955@gmail.com");

		// Click on text box for password and enter correct password
		driver.findElement(By.id("ap_password")).sendKeys("qwertyasdf");
		//driver.findElement(By.id("ap_captcha_guess")).sendKeys("$captcha");

		// Click "Sign in using our secure server"
		driver.findElement(By.id("signInSubmit-input")).click();
/* 
driver.findElement(By.id("ap_captcha_guess")).sendKeys("y4e4f8");
driver.findElement(By.id("signInSubmit-input")).click();
driver.findElement(By.id("ap_password")).clear();
driver.findElement(By.id("ap_password")).sendKeys("qwertyasdf");
driver.findElement(By.id("ap_captcha_guess")).clear();

driver.findElement(By.id("signInSubmit-input")).click();
assertEquals("testing...'s Amazon.com", driver.findElement(By.id("nav-your-amazon")).getText());

*/
		// Assertion - signed in
		WebElement element = driver.findElement(By.id("nav-your-amazon"));
		assertEquals(element.getText(), "testing...'s Amazon.com");
		driver.quit();
	}
	


	//Given the sign-in page, when I enter the correct username and incorrect password, then I am prevented
	//from signing into my account and get an error message.
	
	
	@Test
	public void testIncorrectPassword() {
		
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.com");

		// Navigate to sign-in page
		driver.findElement(By.cssSelector("#nav-signin-tooltip > a.nav-action-button > span.nav-action-inner")).click();
		driver.findElement(By.id("ap_email")).sendKeys("testingsoftware2955@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("qwerty");

		// Click "Sign in using our secure server"
		driver.findElement(By.id("signInSubmit-input")).click();

		// Assertion
		WebElement element = driver.findElement(By.id("message_error"));
		assertNotNull(element);
		driver.quit();
	}
	
	//Given the sign-in page, when I enter the incorrect username and correct password, then I am prevented
		//from signing into my account and get an error message.
		
	@Test
	public void testIncorrectUsername() {
		
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.com");

		// Navigate to sign-in page
		driver.findElement(By.cssSelector("#nav-signin-tooltip > a.nav-action-button > span.nav-action-inner")).click();
		driver.findElement(By.id("ap_email")).sendKeys("testingsoftware@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("qwertyasdf");

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
		
		
		WebDriver driver = new FirefoxDriver();
		driver.get("https://amazon.com");

		// Navigate to sign-in page
		driver.findElement(By.cssSelector("#nav-signin-tooltip > a.nav-action-button > span.nav-action-inner")).click();
		driver.findElement(By.id("ap_email")).sendKeys("testingsoftware@gmail.com");
		driver.findElement(By.id("ap_password")).sendKeys("qwerty");

		// Click "Sign in using our secure server"
		driver.findElement(By.id("signInSubmit-input")).click();

		// Assertion
		WebElement element = driver.findElement(By.id("message_error"));
		assertNotNull(element);
		driver.quit();;
	}
	
	
	
		
	
}
