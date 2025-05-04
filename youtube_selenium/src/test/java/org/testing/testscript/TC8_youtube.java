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

public class TC8_youtube  extends base{
	
	@Test
	public void tc8() throws InterruptedException {
		ExtentReports report= report_handling.report();
		ExtentTest tc8=report.startTest("TC8_youtube");
		login_page login=new login_page(driver, p);
		login.sigin("kajal9999v@gmail.com", "Rani@1997");
		String actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/",actual_url);
		loghandling.log_capture("TC8_youtube", "url is matching after sigin ");
		home_page home=new home_page(driver, p);
	    home.playlist();
	    actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/feed/playlists",actual_url);
		loghandling.log_capture("TC8_youtube", "able to click on playlist");
	    logout_page logout=new logout_page(driver, p);
	    logout.logout();
		loghandling.log_capture("TC8_youtube", "url is matching after signout ");

		 actual_url=driver.getCurrentUrl();
			Boolean res= assetions.assertttt("https://www.youtube.com/",actual_url);

		if(res)
		{
			tc8.log(LogStatus.PASS, "testcase8 is getting pass");
			loghandling.log_capture("TC8_youtube", "testcase 8 is getting pass");
		}
		else
		{
			tc8.log(LogStatus.FAIL, "testcase8 is getting fail");
			loghandling.log_capture("TC8_youtube", "testcase 8 is getting fail");

		}
		report.endTest(tc8);
		report.flush();
				
	}


	}


