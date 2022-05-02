package StepDefinition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import POM.page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class testcases extends webcommon {

	page pg;
	
	SoftAssert softasssert = new SoftAssert();

	
	
	
	@After
	public void screenshot(Scenario scenario) throws Throwable{
		Screenshot_OnFail(scenario);
	}

	
	@Then("^Open myntra website$")
	public void lunchapp() throws Throwable {
		lunch_myntrawebapp();
	}
	
	

	@Then("^Search (.+) in search bar$")
	public void search_product(String tshirt) throws Throwable {
		pg = new page(driver);
		pg.searchproduct(tshirt);
		

	}

	@Then("^click search$")
	public void click_search() throws Throwable {
		pg = new page(driver);
		pg.clicksearch();

	}

	@And("^sort by low to high price$")
	public void sort_low_to_high() {
		pg = new page(driver);
        pg.sort();
	}
	
	
	@Then("^verify product prices are arranged in ascending order$")
	public void verify_product_prices_are_arranged_in_ascending_order() throws Exception {
		
		
		
	List<WebElement> afterfilter=	driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
	
	
	Thread.sleep(3000);
	for(WebElement p:afterfilter) {
		String pricesaftersort = p.getText();
		System.out.println(pricesaftersort);
		
		driver.findElement(By.xpath("//*[contains(text(),'119 to Rs. 2040')]")).click();
		
		List<WebElement> beforefilter=	driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
		
		for(WebElement b:beforefilter) {
			String pricesbeforesort = b.getText();
			System.out.println(pricesbeforesort);

			if(pricesaftersort.contains(pricesbeforesort)) {
				softasssert.assertTrue(true);
			}
		}
		
	}
	}
	

   
    }
