package Junit.extent;

import java.util.HashMap;
import java.util.Map;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Extentutil {
	static ExtentReports  extent=null;
	// Make a List of Tset Case
	static Map<Integer,ExtentTest> extentTestMap= new HashMap<Integer, ExtentTest>();
	
	public static ExtentReports createReporter(String FileName){
		ExtentHtmlReporter htmlreporter = new ExtentHtmlReporter(FileName);
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setReportName("JUNIT sample ExtentReport report");
		htmlreporter.config().setChartVisibilityOnOpen(true);
		// Extentx Reporter initialized 
		extent= new ExtentReports();
		extent.attachReporter(htmlreporter);
		return extent;
	}
	// To Fush the Extent report or Record the Extent report 
public static void saveReporter(){
	if (extent!=null){
	extent.flush();
	}
}
	// create test name
	public static synchronized ExtentTest createTest(String TestName){
 ExtentTest extentTest =extent.createTest(TestName);
  extentTestMap.put((int)Thread.currentThread().getId(),extentTest);
  return extentTest;
	}
	// Create Testcase with description
	public static synchronized ExtentTest createTest(String TestName,String description){
		 ExtentTest extentTest= extent.createTest(TestName,description);
		 extentTestMap.put((int)Thread.currentThread().getId(), extentTest);
		 return extentTest;
			}
	public static synchronized ExtentTest fetchTest(){
		return extentTestMap.get(Thread.currentThread().getId());
		
			}
	
}
