package App_automation.Flow_login.Pages;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class Watchlist extends Login {
    @Test()
	public void testWatchlist() throws InterruptedException {
    	WebElement skiptour = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Skip Tour\"]"));
    	skiptour.click();
		driver.findElement(AppiumBy.accessibilityId("Ok, got it!")).click();
		driver.findElement(AppiumBy.accessibilityId("Search & Add Stock")).click();

		Thread.sleep(3000);
		WebElement searchStock = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']"));
		searchStock.click();
		searchStock.sendKeys("TCS");
	}

}
