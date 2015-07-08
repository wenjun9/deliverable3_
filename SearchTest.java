//User Story:
//As a searcher, I want to search items so that I can see if they are available

//Scenarios:
// Given the Amazon home page, when I type a product in the search box and press enter,
//then the product shows up in the results.

//Given the Amazon home page, when I click on the dropdown menu beside the search box and select
//the department and search within that department, then the correct product is displayed

package deliverable3;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.junit.Before;
import org.junit.Test;

public class SearchTest {
	WebDriver driver = new FirefoxDriver();
	
    
	@Before
	public void setUp() throws Exception {
		
		driver.get("http://www.amazon.com");
	}
	
	//Given the Amazon home page, when I type a product in the search box 
	//and press enter,then the product shows up in the results.

	@Test
	public void testSearch() {
	
		//Click on search box and type product name
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("3 idiots");
		
		//Click search icon
		driver.findElement(By.cssSelector("input.nav-input")).click();
		
		//Click on first result
		try {
			driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/a/h2")).click();
		} catch (NoSuchElementException ex) {
			fail();
		}
		
		//assertion
		assertEquals("3 Idiots (English Subtitled) 2009 PG CC", driver.findElement(By.id("aiv-content-title")).getText());
		driver.quit();
	}
	
	//Given the Amazon home page, when I click on the dropdown menu beside the search box and select
	//the department and search within that department, the correct product is displayed
	
	@Test
	public void testDropDown(){
		
	    //click on dropdown menu and scroll to "Beauty"
		new Select(driver.findElement(By.id("searchDropdownBox"))).selectByVisibleText("Beauty");
		
		//click on "Beauty"
		driver.findElement(By.cssSelector("option[value=\"search-alias=beauty\"]")).click();
		
		//Click on search box and type "sunscreen"
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("sunscreen");
		
		//click on search icon
		driver.findElement(By.cssSelector("input.nav-input")).click();
		
		//click on first result
		driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/a/h2")).click();
		
	    //assertion
		assertEquals("Neutrogena Ultra Sheer Sunscreen SPF 45 Twin Pack, 6 oz.", driver.findElement(By.id("productTitle")).getText());
        driver.quit();
	}

}
















