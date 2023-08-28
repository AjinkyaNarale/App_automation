package App_automation.Flow_login.Pages;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

//import org.openqa.selenium.By;
//import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;



import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class First_test {
	public AndroidDriver driver;


	
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		
		
		// set up all the phone's capabilities
		UiAutomator2Options options=new UiAutomator2Options();
		options.setDeviceName("sdk_gphone64_arm64");
		options.setUdid("emulator-5554");
		options.setAutomationName("UiAutomator2");
		options.setPlatformName("Android");
//		options.setCapability("goog:chromeOptions", options);
		
		
		//setup app's details using the app's path
	    options.setApp("/Users/lord_ajinkya/eclipse-workspace/Flow_login/src/test/resources/apps/app-prod-release.apk");
		
	    
	    //setup the appium server using url
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		
//		options.setAutoGrantPermissions(true);
		
		
		//Wait, locate and click on continue
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

	}
	    @Test
		public void login() {
			
	    	
	    	//find element for "continue" and click
	    	driver.findElement(AppiumBy.accessibilityId("Continue")).click();
			
	    	
	    	//Find element for USERID on login page and send keys

//				WebElement userId = driver.findElements(AppiumBy.className("android.widget.EditText")).get(0);
	    	    WebElement userId = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='4']"));
				userId.click();
				userId.sendKeys("IOSTEST");

			//Find element for USERID on login page and send keys
	    	    WebElement password = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='7']"));
	    	    password.click();
				password.sendKeys("Astha@123");
				
		    //FInd element for eye icon and show the password
				driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@index='0']"));
				
				
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.navigate().back();				
		    //Find element for sign in button and click
				driver.findElement(AppiumBy.accessibilityId("Sign in")).click();
				
				driver.findElement(AppiumBy.accessibilityId("Login with OTP\n"
						+ " instead")).click();
				
		 
				
				  WebElement totp = driver.findElement(AppiumBy.xpath("//android.view.View[@index='1']"));
				  totp.click();
				  totp.sendKeys("123456");

			//Wait, locate and click on forgot password
//			driver.findElement(AppiumBy.accessibilityId("Forgot Password?")).click();
			
			
			//locate and click back on forgot password
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//			driver.findElement(AppiumBy.className("android.widget.ImageView")).click();
			
			//locate and click on "Open an account"
//			driver.findElement(AppiumBy.accessibilityId("Open an account")).click();
			
			//Enter mobile number for registration and send keys
//			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

//			MobileElement mobileNumberInput = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"0%\"]/android.view.View/android.widget.EditText"));
//		    mobileNumberInput.sendKeys("9172695674");
		
		
//        WebElement elementToClick = driver.findElement(AppiumBy.id("com.google.android.apps.nexuslauncher:id/overview_actions_view"));
//        elementToClick.click();


//		driver.quit();
//		driver.findElement(find)
	}


}
    





