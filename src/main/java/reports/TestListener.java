package reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;

import setUp.baseTest;

public class TestListener extends baseTest implements ITestListener {

	public static  String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getDescription();
	}

	public void onStart(ITestContext iTestContext) {
		Log.startLog(iTestContext.getClass().getName());
	}

	public void onFinish(ITestContext iTestContext) {
		reports.ExtentManager.endTest();
		reports.ExtentManager.getReporter().flush();
	}

	public void onTestStart(ITestResult iTestResult) {
		Log.info(getTestMethodName((iTestResult)));
	}

	public void onTestSuccess(ITestResult iTestResult) {
		try {
			Log.info("Testcase " + getTestMethodName(iTestResult) + " passed");      
			Object testClass = iTestResult.getInstance();
			String base64Screenshot = null;
			if (getDriver() != null){
				base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) getDriver()).
						getScreenshotAs(OutputType.BASE64);
			}
			reports.ExtentManager.getTest().log(LogStatus.PASS,  " <b style='color:Green;'> Testcase: " + getTestMethodName(iTestResult) + " is passed </b>",
					reports.ExtentManager.getTest().addBase64ScreenShot(base64Screenshot));
		} catch (Exception e) {
			System.out.println("Something Went Wrong" + e);
		}
	}

	public void onTestFailure(ITestResult iTestResult) {
		try {
			Log.info("Testcase for " + getTestMethodName(iTestResult) + " failed.");
			Object testClass = iTestResult.getInstance();
			String base64Screenshot = null;
			if (getDriver() != null){
				base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) getDriver()).
						getScreenshotAs(OutputType.BASE64);
			}
			reports.ExtentManager.getTest().log(LogStatus.INFO, iTestResult.getThrowable().getMessage());
			reports.ExtentManager.getTest().log(LogStatus.FAIL, " <b style='color:Red;'> Testcase: " + getTestMethodName(iTestResult) + " is failed </b>",
					reports.ExtentManager.getTest().addBase64ScreenShot(base64Screenshot));
		} catch (Exception e) {
			System.out.println("Something Went Wrong" + e);
		}
	}

	public void onTestSkipped(ITestResult iTestResult) {
		String base64Screenshot = null;
		if (getDriver() != null){
			base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) getDriver()).
					getScreenshotAs(OutputType.BASE64);
		}
		reports.ExtentManager.getTest().log(LogStatus.INFO, iTestResult.getThrowable().getMessage());
		reports.ExtentManager.getTest().log(LogStatus.SKIP, " <b style='color:Blue;'>  Testcase: " + iTestResult.getMethod().getDescription() + " is skipped </b>", 
				reports.ExtentManager.getTest().addBase64ScreenShot(base64Screenshot));
		Log.info(iTestResult.getName() + " is skipped");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		Log.info("Testcase " + getTestMethodName(iTestResult) + " failed but it is in defined success ratio");
	}
}