package App_automation.Flow_login.Pages;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.net.MalformedURLException;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import java.net.URL;
import java.time.Duration;


import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
 import io.appium.java_client.android.options.UiAutomator2Options;


public class Login {
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
	    options.setApp("/Users/lord_ajinkya/eclipse-workspace/Flow_login/src/test/resources/apps/new_automation_build.apk");
		
	    
	    //setup the appium server using url
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		
//		options.setAutoGrantPermissions(true);
		
		
		//Wait, locate and click on continue
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

	}
	
	@Test
   	public void login() throws InterruptedException {
			
	    	
	    	//find element for "continue" and click
		WebElement continu =driver.findElement(AppiumBy.accessibilityId("Continue"));
		continu.click();
	    	
	    	//Find element for USERID on login page and send keys

//				WebElement userId = driver.findElements(AppiumBy.className("android.widget.EditText")).get(0);
                Thread.sleep(3000);
	    	    WebElement userId = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='4']"));
				userId.click();
				userId.sendKeys("IOSTEST");

			//Find element for password on login page and send keys
                Thread.sleep(3000);
				WebElement password = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='7']"));
				password.isDisplayed();
	    	    password.click();
				password.sendKeys("Astha@123");
				
				//this command closes the keyboard on login screen
				driver.hideKeyboard();
//				driver.pressKey(new KeyEvent(AndroidKey.BACK));				
				
		    //Find element for sign in button and click
				Thread.sleep(2000);
				WebElement signin =driver.findElement(AppiumBy.accessibilityId("Sign in"));
				signin.isDisplayed();
				signin.click();
			//FInd number key on keypad and click a digit
				Thread.sleep(5000);
			    driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
			    driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_2));
			    driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
			    driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_4));
			    driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_5));
			    driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_6));
			    Thread.sleep(100);

			    //click on verify after entering TOTP
			    WebElement verify=driver.findElement(AppiumBy.accessibilityId("Verify"));
			    verify.isDisplayed();
			    verify.click();
				
				
			    WebElement do_it_later=driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"I’ll do it later\"]"));
			    do_it_later.isDisplayed();
			    do_it_later.click();
				driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Enable Device Lock\"]")).click();

				
				//Enter numbers from the keypad
				Thread.sleep(5000);
			    driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_1));
			    driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_2));
			    driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_3));
			    driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_4));
			    driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_5));
			    driver.pressKey(new KeyEvent().withKey(AndroidKey.DIGIT_6));
			    Thread.sleep(100);
			    
			    //Press ENTER after entering auth
			    driver.pressKey(new KeyEvent().withKey(AndroidKey.ENTER)); 
			    
			    
			    //Press on SKIPTOUR
			    Thread.sleep(5000);
				WebElement skiptour = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Skip Tour\"]"));
		    	skiptour.click();
		    	
                driver.findElement(AppiumBy.accessibilityId("Ok, got it!")).click();
				
                //Add stock to watchlist
                
//				driver.findElement(AppiumBy.accessibilityId("Search & Add Stock")).click();
//                
//                Thread.sleep(2000);
//				List<String> stockList = List.of("WIPRO", "INFY", "RCF","HDFCBANK","RELIANCE","ZOMATO");
//		        for(int i= 0;i<stockList.size();i++) {
//		        	WebElement searchStocks = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']"));
//		        	searchStocks.sendKeys(stockList.get(i));
//		        	
//		        	Thread.sleep(3000);
////		        	WebElement addStock = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@index='0']"));
////		        	addStock.click();
////		        	System.out.println(addStock);
//			        driver.findElement(AppiumBy.accessibilityId("Clear")).click();	
//		        }
//		        
//		        driver.findElement(AppiumBy.accessibilityId("Done")).click();

				driver.findElement(AppiumBy.accessibilityId("Search & Add Stock")).click();

				Thread.sleep(3000);
				WebElement searchStock = driver.findElement(AppiumBy.xpath("//android.widget.EditText[@index='0']"));
				searchStock.click();
				searchStock.sendKeys("TCS");
				
				Thread.sleep(2000);
				WebElement AddToWatchlist = driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc=\"EQ\n"
						+ "TCS\n"
						+ "NSE\n"
						+ "Tata Consultancy Serv Lt\"]/android.widget.ImageView"));
				AddToWatchlist.click();
				
				driver.findElement(AppiumBy.accessibilityId("Done")).click();
				
				
								
				//Place order
				Thread.sleep(5000);

				WebElement Addbuy = driver.findElement(AppiumBy.xpath("//*[contains(@content-desc,'TCS')]"));
				Addbuy.click();
				
				driver.findElement(AppiumBy.accessibilityId("Buy")).click();

				driver.findElement(AppiumBy.accessibilityId("Ok, got it!")).click();

				driver.findElement(AppiumBy.accessibilityId("Sell")).click();
				
				driver.findElement(AppiumBy.accessibilityId("Delivery\n"
						+ "1.0X\n"
						+ "Max Qty 0\n"
						+ "Tab 3 of 3")).click();
				
			
				WebElement clickBuy = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc=\"Buy\"]"));
				clickBuy.click();
				
				

				
                
     //tools tab
                
                Thread.sleep(5000);
				driver.findElement(AppiumBy.accessibilityId("Tools\n"
						+ "Tab 3 of 5")).click();
				
				//delete basket before executing a strategy
				WebElement deleteBasket = driver.findElement(AppiumBy.xpath("android.widget.ImageView[@index='2']"));
				deleteBasket.click();
				
				driver.findElement(AppiumBy.accessibilityId("Edit")).click();

				
				WebElement basketDelete = driver.findElement(AppiumBy.xpath("android.widget.ImageView[@index='1']"));
				basketDelete.click();
				
				driver.findElement(AppiumBy.accessibilityId("Done")).click();
				
				WebElement backToTools = driver.findElement(AppiumBy.xpath("android.widget.ImageView[@index='0']"));
				backToTools.click();
				
				//strategy store
				driver.findElement(AppiumBy.accessibilityId("Strategy store\n"
						+ "Pre-defined strategies to help you make your decision easier")).click();
				
				WebElement strategyStore = driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@index='10']"));
			
				strategyStore.click();
				
				driver.findElement(AppiumBy.accessibilityId("Bull Call Spread\n"
						+ "View all")).click();
				driver.findElement(AppiumBy.accessibilityId("Continue")).click();

				driver.findElement(AppiumBy.accessibilityId("Execute")).click();
				
				//stock details and chart
				Thread.sleep(3000);
				driver.findElement(AppiumBy.accessibilityId("Watchlist\n"
						+ "Tab 2 of 5")).click();
//				
     			driver.findElement(AppiumBy.accessibilityId("Default\n"
     					+ "Tab 3 of 3")).click();
     			
     			driver.findElement(AppiumBy.accessibilityId("NIFTY\n"
     					+ "NSE\n"
     					+ "Nifty\n"
     					+ "20133.30\n"
     					+ "59.05(0.29%)")).click();
     			
     			driver.findElement(AppiumBy.accessibilityId("View Chart")).click();
     			
     			WebElement timeFrame = driver.findElement(AppiumBy.xpath("android.widget.TextView[@index='0']"));
     			timeFrame.click();
				

     			WebElement chooseTime = driver.findElement(AppiumBy.xpath("android.view.View[@index='14']"));
     			chooseTime.click();
     			
     			WebElement go_back_toBottomsheet = driver.findElement(AppiumBy.xpath("android.widget.ImageView[@index='4']"));
     			go_back_toBottomsheet.click();
		}


}
    





