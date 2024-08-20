package DemoAppTests;

import static reports.ExtentManager.startTest;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.annotations.Test;
import static  interfaces.ClassObjects.*;

import setUp.baseTest;

public class firstTest extends baseTest {

	@Test
	public void submitForm() throws MalformedURLException, URISyntaxException, InterruptedException {
		
		// maintenace and first login button screen and usename and password screen
		startTest("LoginWithValidCredentials");
		formPageObj.setGender("Male");
		formPageObj.setNameField("Bhagat");
		formPageObj.setCountrySelection("Brazil");
		formPageObj.submitForm();
		
	}
}
