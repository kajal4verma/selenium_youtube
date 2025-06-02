package org.testing.testscript;

import java.io.IOException;
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
import org.testing.reporthandling.screenCapture;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;



public class TC7_youtube extends base {
	
	@Test
	public void tc7() throws InterruptedException, IOException {
		test=report.createTest("test_case7");
		login_page login=new login_page(driver, p);
		login.sigin("kajal9999v@gmail.com", "Rani@1997");
		String actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/",actual_url);
		loghandling.log_capture("TC7_youtube", "url is matching after sigin ");
		home_page home=new home_page(driver, p);
	    home.watchlist();
	    actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/playlist?list=WL",actual_url);	 
		loghandling.log_capture("TC7_youtube", "able to click on watchlist ");
		screenCapture screen=new screenCapture(driver);
		String sceen1= screen.screenshot("C:\\Users\\Nishant Kumar\\Documents\\watchlist.png");
         test.addScreenCaptureFromPath(sceen1 );
	    logout_page logout=new logout_page(driver, p);
	    logout.logout();
	    loghandling.log_capture("TC7_youtube", "url is matching after signout ");
	    actual_url=driver.getCurrentUrl();
		Boolean res= assetions.assertttt("https://www.youtube.com/",actual_url);

	if(res)
	{
		test.pass("test case geting pass...");
//		tc7.log(LogStatus.PASS, "testcase7 is getting pass");
		loghandling.log_capture("TC7_youtube", "testcase 7 is getting pass");
	}
	else
	{
		test.fail("test case getting fail..");
		//		tc7.log(LogStatus.FAIL, "testcase7 is getting fail");
		loghandling.log_capture("TC7_youtube", "testcase 7 is getting fail");

	}
//	report.endTest(tc7);
	report.flush();
	}
	}



