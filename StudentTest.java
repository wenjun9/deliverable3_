//User story : As a student, I want to be able to search for textbooks so that I can buy them

//Scenarios:
//Given the amazon home page, when I enter the textbook's ISBN number, then the correct textbook is displayed in the results
//Given the Amazon home page, when I enter an ISBN number incorrectly, then the correct textbook is not displayed in the results
//Given the Amazon homepage, when I enter the author's name correctly, the correct textbook is displayed in the results
//Given the Amazon homepage, when I enter the author's name incorrectly, the correct textbook is not displayed in the results
//Given the Amazon homepage , when I enter the publisher's name, the correct textbook is displayed in the results


package deliverable3;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StudentTest
{
	WebDriver driver = new FirefoxDriver();
	
    @Before
	public void setUp() throws Exception {
		driver.get("http://www.amazon.com");
		
	}
		
	//Given the Amazon home page, when I enter the textbook's ISBN number, then the correct textbook is displayed in the results.
	@Test
	public void testSearchISBN() {
		
		
		//Click on search textbox and type the ISBN number
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("978-0672327988");
		
		//Click on search icon
		driver.findElement(By.cssSelector("input.nav-input")).click();
		
		//Click on first result
		try {
			driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//assertion
		//productTitle failing without PageSource
		System.out.println(driver.getPageSource());
		assertEquals("Software Testing (2nd Edition)", driver.findElement(By.id("productTitle")).getText());
		driver.quit();
	}
	
	//Given the Amazon home page, when I enter an incorrect ISBN number, 
	//then the correct textbook is not displayed in the results.
	@Test
	public void testSearchIncorrectISBN() {
		
		//Click on search textbox and type the ISBN number
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("978-1413304541");
		
		//Click on search icon
		driver.findElement(By.cssSelector("input.nav-input")).click();
				
		//Click on first result
		try {
			driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//assertion
		//productTitle failing without PageSource
		System.out.println(driver.getPageSource());
		assertNotEquals("Software Testing (2nd Edition)", driver.findElement(By.id("productTitle")).getText());
		driver.quit();
	}
	
	//Given the Amazon homepage, when I enter the author's name correctly, the correct textbook is displayed in the results
	@Test
	public void testSearchCorrectAuthor(){
		
		//Click on search textbox and type the author's name
	    driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Ron Patton");
		
		//Click on search icon
		driver.findElement(By.cssSelector("input.nav-input")).click();
				
		//Click on first result
		try {
			driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//assertion
		//productTitle failing without PageSource
		System.out.println(driver.getPageSource());
		assertEquals("Software Testing (2nd Edition)", driver.findElement(By.id("productTitle")).getText());
		driver.quit();
		
	}
	
	//Given the Amazon homepage, when I enter the author's name incorrectly, the correct textbook is not displayed in the 
	//results
	@Test
	public void testSearchIncorrectAuthor(){
		
		//CLick on the search box and type the author's name
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Ron Paten");
		
		//Click on the search icon
		driver.findElement(By.cssSelector("input.nav-input")).click();
		
		//Click on first result
		try {
			driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//assertion
		//productTitle failing without PageSource
	    System.out.println(driver.getPageSource());
		assertNotEquals("Software Testing (2nd Edition)", driver.findElement(By.id("productTitle")).getText());
		driver.quit();	
	}
	
	//Given the Amazon homepage , when I enter the publisher's name, the correct textbook is displayed in the results
	@Test
	public void testSearchPublisher(){
        //CLick on the search box and type the publisher's name
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Sams Publishing Software Testing");
		
		//Click on the search icon
		driver.findElement(By.cssSelector("input.nav-input")).click();
		
		//Click on first result
		try {
			driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//assertion
		//productTitle failing without PageSource
	    System.out.println(driver.getPageSource());
		assertEquals("Software Testing (2nd Edition)", driver.findElement(By.id("productTitle")).getText());
		driver.quit();
	}
	
}







