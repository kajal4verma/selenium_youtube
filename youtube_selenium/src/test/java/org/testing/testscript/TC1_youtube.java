package org.testing.testscript;

import java.io.IOException;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.assertion.assetions;
import org.testing.base.base;
import org.testing.pages.home_page;
import org.testing.pages.login_page;
import org.testing.pages.logout_page;
import org.testing.reporthandling.loghandling;
import org.testing.reporthandling.report_handling;
import org.testing.utilities.properties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC1_youtube extends base{
	
	
	@Test
	public void tc1() throws InterruptedException, IOException {
		ExtentReports report= report_handling.report();
		ExtentTest tc1=report.startTest("TC1_youtube");
		login_page login=new login_page(driver, p);
		login.sigin("kajal9999v@gmail.com", "Rani@1997");
		String actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/",actual_url);
		loghandling.log_capture("TC1_youtube", "url is matching after signin");
		home_page home=new home_page(driver, p);
		home.click_trending();
		loghandling.log_capture("TC1_youtube", "able to click on trending");
		actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/feed/trending?bp=6gQJRkVleHBsb3Jl", actual_url);

		logout_page logout=new logout_page(driver, p);
		logout.logout();	
		loghandling.log_capture("TC1_youtube", "url is  matching after logout");
		actual_url=driver.getCurrentUrl();
		Boolean res= assetions.assertttt("https://www.youtube.com/",actual_url);
		
		if(res) {
			tc1.log(LogStatus.PASS, "TestCase1 of UI is getting passed");
			loghandling.log_capture("TC1_youtube", "testcase1 is getting pass");

		}
		else {
			tc1.log(LogStatus.FAIL,"TestCase1 of ui is not getting passed");
			loghandling.log_capture("TC1_youtube", "testcase1 is getting fail");

		}
		report.endTest(tc1);
		report.flush();
		
		
	
	}
	

	
	

}
