//User Story:
//As a user, I want to search items so that I can buy them

//Scenarios:
// Given the Amazon home page, when I type a product in the search box and press enter,then the product shows up in the results.
// Given the Amazon home page, when I click the correct department pertaining to a product and search within that department , the product is shown
package deliverable3;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
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
	
		//Click on text box for search and enter product 
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
	
	@Test
	//Given the Amazon home page, when I click the correct department pertaining to a product
	//and search within that department , the product is shown
	
	public void testDepartment(){
		
			
		//Click on Shop by Department
		//System.out.println(driver.getPageSource());
		driver.findElement(By.cssSelector("span.nav-line-2")).click();
		//driver.findElement(By.linkText("Department")).click();
		
		//Click Movies & TV
		System.out.println(driver.getPageSource());
		//driver.findElement(By.xpath("//div[@id='nav-flyout-shopAll']/div[3]/div[10]/div/a/span")).click();
		//driver.findElement(By.linkText("Movies & TV")).click();
		//driver.findElement(By.linkText("Movies")).click();
		//driver.findElement(By.xpath("//td[2]/div[4]/ul/li/a")).click();
		driver.findElement(By.xpath("//a[contains(@href, '/movies-tv-dvd-bluray/b/ref=sd_allcat_mov?ie=UTF8&node=2625373011')]")).click();
		//driver.findElement(By.xpath("//a[contains(text(),'Movies & TV')]")).click();
		//driver.findElement(By.linkText("Movies & TV")).click();
		//driver.findElement(By.xpath("//table[@id='shopAllLinks']/tbody/tr/td[2]/div[4]/ul/li/a")).click();
		//driver.findElement(By.xpath("//table[@id='shopAllLinks']/tbody/tr/td[2]/div[4]/ul/li/a")).click();

		

		
		//Click on text box for search and enter product 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("3 idiots");
		
		//Click submit button
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
	


}


//driver.get(baseUrl + "/ref=nav_logo");
//driver.findElement(By.xpath("//div[@id='nav-flyout-shopAll']/div[3]/div[10]/div/a/span")).click();
//driver.findElement(By.xpath("//div[@id='nav-flyout-shopAll']/div[3]/div[10]/div/a/span")).click();
//driver.findElement(By.linkText("Movies")).click();

/*driver.get(baseUrl + "/Brother-Feature-Rich-Stitches-Auto-Size-Buttonholes/dp/B000JQM1DE/ref=sr_1_1?s=home-garden&ie=UTF8&qid=1436138574&sr=1-1&keywords=sewing+machine");
driver.findElement(By.cssSelector("span.nav-logo-base.nav-sprite")).click();
driver.findElement(By.id("dp")).click();
driver.findElement(By.cssSelector("span.nav-line-2")).click();
driver.findElement(By.xpath("//a[contains(text(),'Movies & TV')]")).click();
driver.findElement(By.id("twotabsearchtextbox")).clear();
driver.findElement(By.id("twotabsearchtextbox")).sendKeys("3 idiots");
driver.findElement(By.cssSelector("input.nav-input")).click();
driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/a/h2")).click();
assertTrue(isElementPresent(By.id("aiv-content-title")));
driver.findElement(By.xpath("//div[@id='nav-flyout-shopAll']/div[3]/div[10]/div/a/span")).click();
driver.findElement(By.xpath("//div[10]/div/a/span")).click();
driver.findElement(By.xpath("//a[@id='nav-link-shopall']/span[2]")).click();
driver.get(baseUrl + "/movies-tv-dvd-bluray/b/ref=nav_shopall_mov?ie=UTF8&node=2625373011");
driver.findElement(By.cssSelector("span.nav-logo-base.nav-sprite")).click();
driver.findElement(By.xpath("//a[contains(text(),'Movies & TV')]")).click();

*/













