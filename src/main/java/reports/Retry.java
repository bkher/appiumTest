package reports;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	private int retryCount = 0;
	private  final int maxRetryCount = 1;

	public boolean retry(ITestResult result) {
		if (retryCount < maxRetryCount) {
			Log.info("Retrying test" + result.getName() + " with status " + getResultStatusName(result.getStatus()) +
					" for the " + (retryCount + 1) + " time(s)");
			retryCount++;
			return true;
		}
		return false;
	}

	public String getResultStatusName(int status) {
		String resultName = null;
		if (status == 1) resultName = "SUCCESS";
		if (status == 2) resultName = "FAILURE";
		if (status == 3) resultName = "SKIP";
		return resultName;
	}
}
