package bhagatkher.appium;

import static interfaces.ClassObjects.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

import org.testng.annotations.Test;
import static reports.ExtentManager.*;

import setUp.baseTest;
public class loginFlowTest extends baseTest{

	@Test
	public void LoginWithValidCredentials() throws MalformedURLException, URISyntaxException, InterruptedException {
				
		// maintenace and first login button screen and usename and password screen
		startTest("LoginWithValidCredentials");
				
		loginScreenObj.validatemaintanaceAndNewLoginScreen();
		loginScreenObj.loginWithUser("alten103", "Pass1234&&");
		
		//otp selection screen
		otpScreenSelectionObj.clickOnContinueButton();
		
		//enter otp screen
		
		enterotpObj.enterOTPAndSubmit("234567");
		
		// set up passcode and biometric info screen
		setUpLoginBioScreenObj.clickOnContinueButton();
		
		// second otp selection and enter otp screen
		otpScreenSelectionObj.clickOnContinueButton();
		
		enterotpObj.enterOTPAndSubmit("234567");
		
		//passcode screen
		enterPasscodeObj.enterPasscode(2);
		enterPasscodeObj.enterPasscode(2);
		enterPasscodeObj.enterPasscode(2);
		enterPasscodeObj.enterPasscode(8);
		enterPasscodeObj.enterPasscode(9);
		enterPasscodeObj.enterPasscode(2);
		
		//confirm passcode screen
		
		enterPasscodeObj.enterPasscode(2);
		enterPasscodeObj.enterPasscode(2);
		enterPasscodeObj.enterPasscode(2);
		enterPasscodeObj.enterPasscode(8);
		enterPasscodeObj.enterPasscode(9);
		enterPasscodeObj.enterPasscode(2);
		
		// click login button from confirmation screen

		loginSuccessScreenObj.clickOnLoginButtonForConfimLogin();
		
		productSummaryScreenObj.validateProductSummaryScreenElement();
				
	}
}
