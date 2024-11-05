package setUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import reports.Log;

public class iOSBaseTest {


		public static IOSDriver driver;
		public Properties prop;
		public iOSBaseTest() {
			try {
				prop = new Properties();
				FileInputStream fileInput = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/config/config.properties");
				prop.load(fileInput);
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}catch (IOException e) {
				e.printStackTrace();
			}
			PageFactory.initElements(driver, this);
		}

		public IOSDriver getDriver() {
			return driver;
		}

		

		@BeforeSuite(alwaysRun = true)
		public void launchApp() throws InterruptedException, MalformedURLException {
		/*	
			UiAutomator2Options options = new UiAutomator2Options();
			//options.setDeviceName(prop.getProperty("Pixel 8 Pro API 30")); //emulator
			options.setDeviceName("Pixel 8 Pro API 30");// real device		
		
		//	options.setChromedriverExecutable("//Users//rahulshetty//documents//chromedriver 11");
			
			options.setApp(System.getProperty("user.dir")+"//src//test//resources//applicationsFile//M3-demo.apk");
			options.setAutomationName("Flutter");
		
		//	options.setApp("//Users//bhagatsinhk//Documents//bgtkher002//appiumTest//src//test//resources//applicationsFile//General-Store.apk");
		//	 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
			*/
			
			XCUITestOptions options = new XCUITestOptions();
			options.setDeviceName("iPhone 16 Pro");
			options.setApp("/Users/bhagatsinhk/Library/Developer/Xcode/DerivedData/UIKitCatalog-fugohounqgbvxpejxqvsprjcdpwe/Build/Products/Debug-iphonesimulator/UIKitCatalog.app");
			options.setPlatformVersion("18.1");
			options.setWdaLaunchTimeout(Duration.ofSeconds(20));
			
			/*
			
			DesiredCapabilities flutterCapabilities = new DesiredCapabilities();
	        flutterCapabilities.setCapability( "appium:deviceName", "Pixel 8 Pro API 30" );
	        flutterCapabilities.setCapability( "platformName", "Android" );
	     
	        flutterCapabilities.setCapability("appium:automationName", "uiAutomator2");
	        
	     
	        flutterCapabilities.setCapability("appium:app",System.getProperty("user.dir")+"//src//test//resources//applicationsFile//CourierDost_v.apk");
	       */ 
			driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
		}

		@BeforeClass(alwaysRun = true)
		public void initialize() throws Exception {
			Log.startLog(this.getClass().getSimpleName());      
		}

		@BeforeMethod(alwaysRun = true)
		public void startReportForMethod(Method method) {
			reports.ExtentManager.startTest(method.getAnnotation(Test.class).description());
		}

		@AfterSuite(alwaysRun = true)
		public void CloseBrowser() {
			driver.quit();
		}
	


}
