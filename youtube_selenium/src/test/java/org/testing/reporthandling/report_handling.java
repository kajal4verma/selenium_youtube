package org.testing.reporthandling;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class report_handling {
	public static ExtentSparkReporter report() {
	ExtentSparkReporter report=new ExtentSparkReporter("/youtube_selenium/report.html");
//	String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
//	ExtentSparkReporter spark = new ExtentSparkReporter("reports/report_" + timestamp + ".html");
//	ExtentSparkReporter report=new ExtentSparkReporter("C:\\\\Users\\\\Nishant Kumar\\\\Documents\\\\report"+timestamp+".html");
	
	
	
	
	return report;
	}

}
