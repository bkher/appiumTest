package DemoAppTests;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.github.ashwith.flutter.FlutterElement;
import io.github.ashwith.flutter.FlutterFinder;
import setUp.baseTest;
import setUp.iOSBaseTest;

public class iOSTests extends iOSBaseTest{

	@Test
	public void iOSFirstAppTest() {
		
		driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
		 
	}
	
}
