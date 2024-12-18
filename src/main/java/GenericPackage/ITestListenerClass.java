package GenericPackage;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass implements ITestListener {
	//public WebDriver driver;
	@Override
	public void onTestStart(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--start");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--success");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--failure");
		WebDriverUtility w = new WebDriverUtility();
		//JavaUtility j = new JavaUtility();
		//String screenshot = methodName+j.toFetchDateAndTime();
		String screenshot = methodName+"1";
		try {
			w.toperformScreenshotOnWebpage(BaseClass.sdriver, screenshot);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"--skipped");
	}
/* context means it just prints */
	@Override
	public void onStart(ITestContext context) {
		System.out.println("Suite excecution started");
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Suite excecution completed");
	}
	
}
