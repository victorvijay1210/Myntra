package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class webcommon {
	
	WebDriver driver;

	public void lunch_myntrawebapp() {
		
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public void Screenshot_OnFail(Scenario scenario) {
		
				if (scenario.isFailed()) {
		
					TakesScreenshot ts = (TakesScreenshot) driver;
					byte[] src = ts.getScreenshotAs(OutputType.BYTES);
					scenario.attach(src, "image/png", "screenshot");
					driver.quit();
		
				}		}

}
