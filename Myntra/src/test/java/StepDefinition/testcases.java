package StepDefinition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
        pg.lowtohigh();
	}
	
	
	@Then("^verify product prices are arranged in ascending order$")
	public void verify_product_prices_are_arranged_in_ascending_order() throws Exception {
		
		Thread.sleep(10000);	
		
		//after low to high filter
	List<WebElement> afterfilter=	driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
   List<Double> afterfilterlist = new ArrayList<>();
	
for(WebElement p:afterfilter ) {
	afterfilterlist.add(Double.valueOf(p.getText().replace("Rs.", "")));
}

driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
Thread.sleep(2000);
driver.findElement(By.xpath("//*[contains(text(),'Price: High to Low')]")).click();
	   
Thread.sleep(10000);  

// high to low filter
List<WebElement> withoutlowtohighfilter=	driver.findElements(By.xpath("//span[@class='product-discountedPrice']"));
List<Double> withoutlowtohighfilterlist = new ArrayList<>();
	
for(WebElement b:withoutlowtohighfilter ) {
	withoutlowtohighfilterlist.add(Double.valueOf(b.getText().replace("Rs.", "")));
}

//validate
Collections.sort(withoutlowtohighfilterlist);
softasssert.assertEquals(withoutlowtohighfilterlist, afterfilterlist);
	
	}
	}
	

   
    
