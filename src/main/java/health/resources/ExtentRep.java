package health.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRep {
	
	
	public ExtentReports config()
	{
	String path = System.getProperty("user.dir")+"//report//index.html";
	ExtentSparkReporter report = new ExtentSparkReporter(path);
	report.config().setDocumentTitle("Health Ministry");
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(report);
	extent.setSystemInfo("Tester", "Nikhil");
//	extent.createTest(path);
	return extent;
}}
