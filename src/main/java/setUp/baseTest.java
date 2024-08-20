package setUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import reports.Log;

public class baseTest {


		public static AndroidDriver driver;
		public Properties prop;
		public baseTest() {
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

		public AndroidDriver getDriver() {
			return driver;
		}

		

		@BeforeSuite(alwaysRun = true)
		public void launchApp() throws InterruptedException, MalformedURLException {
			
			UiAutomator2Options options = new UiAutomator2Options();
			//options.setDeviceName(prop.getProperty("Pixel 8 Pro API 30")); //emulator
			options.setDeviceName("Pixel 8 Pro API 30");// real device		
		//	options.setChromedriverExecutable("//Users//rahulshetty//documents//chromedriver 11");
		//	options.setApp(System.getProperty("user.dir")+"//src//test//resources//applicationsFile//ApiDemos-debug.apk");
			options.setApp("//Users//bhagatsinhk//Documents//bgtkher002//appiumTest//src//test//resources//applicationsFile//General-Store.apk");
			 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
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
