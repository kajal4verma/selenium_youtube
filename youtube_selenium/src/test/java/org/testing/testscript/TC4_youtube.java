package org.testing.testscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.assertion.assetions;
import org.testing.base.base;
import org.testing.pages.home_page;
import org.testing.pages.login_page;
import org.testing.pages.logout_page;
import org.testing.reporthandling.loghandling;
import org.testing.reporthandling.report_handling;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC4_youtube extends base {

	
	@Test	
	public void tc4() throws InterruptedException {
		
		   
				ExtentReports report= report_handling.report();
				ExtentTest tc4=report.startTest("TC4_youtube");
		login_page login=new login_page(driver, p);
		login.sigin("kajal9999v@gmail.com", "Rani@1997");
		String actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/",actual_url);
    	loghandling.log_capture("TC4_youtube", "url is matching after signin");

		home_page home=new home_page(driver, p);
	    home.subscription();
	    actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/feed/subscriptions",actual_url);
    	loghandling.log_capture("TC4_youtube", "able to click on subscription");

	    logout_page logout=new logout_page(driver, p);
	    logout.logout();
	    loghandling.log_capture("TC2_youtube", "url is match after signout");
	    actual_url=driver.getCurrentUrl();
		Boolean res= assetions.assertttt("https://www.youtube.com/",actual_url);
	    if(res) {
	    	tc4.log(LogStatus.PASS,"testcase4 is getting pass");
	    	loghandling.log_capture("TC4_youtube", "testcase4 is getting pass");

	    }
	    else
	    {
	    	tc4.log(LogStatus.FAIL, "testcase4 is getting fail");
	    	loghandling.log_capture("TC4_youtube", "testcase4 is getting fail");
	    }
	    report.endTest(tc4);
		report.flush();
		
	}
   
}
