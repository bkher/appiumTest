package setUp;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import common.DriverFactory;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import reports.Log;

public class baseTest {

	//public static AndroidDriver driver;
	public static AppiumDriver driver;
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
			return (AndroidDriver) driver;
		}

		

		@BeforeSuite(alwaysRun = true)
	/*	public void launchApp() throws InterruptedException, MalformedURLException {
			
			UiAutomator2Options options = new UiAutomator2Options();
			//options.setDeviceName(prop.getProperty("Pixel 8 Pro API 30")); //emulator
			options.setDeviceName(prop.getProperty("Pixel 4 API 35"));// real device
		//	options.setChromedriverExecutable("//Users//rahulshetty//documents//chromedriver 11");
		//	options.setApp(System.getProperty("user.dir")+"//src//test//resources//applicationsFile//ApiDemos-debug.apk");
			options.setApp("C:\\Users\\abhij\\Downloads\\appiumTest-develop-Bhagat\\appiumTest-develop-Bhagat\\src\\test\\resources\\applicationsFile\\General-Store.apk");
			 driver = new AndroidDriver(new URL("http://127.0.0.1:4723"),options);
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}*/
	@Parameters({"platform"})
	public void setup(String platform) throws IOException, MalformedURLException {
		loadConfig(platform);
			driver= DriverFactory.getDriver(platform, prop);
		//(platform, prop);
	}
	private void loadConfig(String platform) throws IOException {
		prop = new Properties();
		String configFilePath = platform.equalsIgnoreCase("Android")
				? "src/test/resources/config/android-config.properties"
				: "src/test/resources/config/ios-config.properties";
		FileInputStream configFile = new FileInputStream(configFilePath);
		prop.load(configFile);
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
