package POM;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class page {
	
	
	
	
	@FindBy(xpath = "//input[@placeholder='Search for products, brands and more']")
	WebElement searchbar;
	
	@FindBy(xpath = "//li[contains(text(),'Tshirts For Men')]")
	WebElement searchicon;
	
	@FindBy(xpath = "//div[@class='sort-sortBy']")
	WebElement sort;
	
	@FindBy(xpath = "//*[contains(text(),'Price: Low to High')]")
	WebElement lowtohigh;
		
	WebDriver driver;
	WebDriverWait wait;
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	
	public page(WebDriver driver) {
		this.driver = driver;
	PageFactory.initElements(driver, this);
	
	}
	
	
	
	
	public void searchproduct(String tshirt) throws Exception {
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(searchbar));
		searchbar.sendKeys(tshirt);
		Thread.sleep(3000);
		
		
	}
	
	public void clicksearch() {
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(searchicon));
		searchicon.click();
	}
	
	public void sort() {
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(sort));
		 sort.click();
	}
	
	public void lowtohigh() {
		wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(sort));
		lowtohigh.click();
	}
	
}
