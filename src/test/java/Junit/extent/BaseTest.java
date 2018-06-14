package Junit.extent;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.AssumptionViolatedException;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class BaseTest extends Extentutil {
	@BeforeClass
	public static  void setUp()
	{
		if(Extentutil.extent==null){
			Extentutil.createReporter("extentReport.html");
		}
	}
	@AfterClass
	public static void tearDown(){
		Extentutil.saveReporter();
	}
	@Rule
	public final TestRule testrule= new TestWatcher() {
	
		@Override
		protected void  succeeded(Description description) {
			
	     Extentutil.fetchTest().pass("PASS");
		}
		@Override
		protected void  failed(Throwable e, Description description) {
			try{
	     Extentutil.fetchTest().fail("Failed").addScreenCaptureFromPath("Images.png");
			}catch(IOException e1){
				e1.printStackTrace();
			}
			}
		
		@Override
		protected void  skipped(AssumptionViolatedException e, Description description) {
			
	     Extentutil.fetchTest().pass("PASS");
		}

		@Override
		protected void  starting( Description description) {
			
	     Extentutil.createTest(description.getMethodName());
		}

		@Override
		protected void  finished(Description description) {
		}
		
	};

}
