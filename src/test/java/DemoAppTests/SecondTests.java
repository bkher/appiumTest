package DemoAppTests;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.testng.annotations.Test;

import io.github.ashwith.flutter.FlutterElement;
import io.github.ashwith.flutter.FlutterFinder;
import setUp.baseTest;

public class SecondTests extends baseTest{

	@Test
	public void flutterAppTest() {
		
		 try {
	           
	         //   FlutterFinder find = new FlutterFinder(driver);
	            FlutterFinder find =  new FlutterFinder(driver);
	            Thread.sleep(3000);

	           // FlutterElement txt_username = find.
	            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]")).click();
	            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]")).click();
	            driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Next\"]")).click();
	           
	            
	            driver.findElement(By.xpath("//android.widget.EditText")).click();
	            driver.findElement(By.xpath("//android.widget.EditText")).sendKeys("1234gfhf");
	           // FlutterElement txt_password = find.byValueKey("txt_password");
	           // FlutterElement button_login = find.byValueKey("button_login");


	           

	            //txt_password.sendKeys("123456");
	           // button_login.click();
	          
	            Thread.sleep(5000);

	        } catch (TimeoutException | InterruptedException e) {
	           System.out.println("catch block");
	        }

		
	}
	
}
