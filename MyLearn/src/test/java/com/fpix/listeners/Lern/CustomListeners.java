package com.fpix.listeners.Lern;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.SkipException;

import com.fpix.base.Lern.TestBase;
import com.fpix.utilities.Lern.TestUtilities;
import com.relevantcodes.extentreports.LogStatus;

public class CustomListeners extends TestBase implements ITestListener {

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		System.out.println("TEst listener");
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		
		
		/*try {
			TestUtilities.captureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(LogStatus.FAIL, arg0.getName().toUpperCase()+" Failed with exception : "+arg0.getThrowable());
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtilities.screenshotName));
		

		
		rep.endTest(test);
		rep.flush();*/
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		test.log(LogStatus.SKIP, arg0.getName().toUpperCase()+" Skipped the test as the Run mode is NO");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		System.out.println("testing");
		test = rep.startTest(arg0.getName().toUpperCase());
		
	}

	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		test.log(LogStatus.PASS, arg0.getName().toUpperCase()+"PASS");
		
		if(TestUtilities.isTestRunnable(arg0.getName(), excel)){
			throw new SkipException("Skipping the test " +arg0.getName()+ "as the run mode is No");
		}
	rep.endTest(test);
	rep.flush();
		
	
	
	}

}
