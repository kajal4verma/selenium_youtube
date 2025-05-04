package org.testing.reporthandling;

import com.relevantcodes.extentreports.ExtentReports;

public class report_handling {
	public static ExtentReports report() {
	ExtentReports reports=new ExtentReports("C:\\Users\\Nishant Kumar\\Documents\\report.html", false);
	return reports;
	}

}
