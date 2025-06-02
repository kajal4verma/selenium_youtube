package org.testing.testscript;

import java.io.IOException;



import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
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
import org.testing.reporthandling.screenCapture;
import org.testing.utilities.properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import com.relevantcodes.extentreports.LogStatus;



public class TC1_youtube extends base{
	
	
	@Test
	public void tc1() throws InterruptedException, IOException {
		
   test=report.createTest("test_case1");
			//		ExtentTest tc1=report.startTest("TC1_youtube");
//   screenCapture screen=new screenCapture();
//  String screen=screenCapture.screenshot("C:\\Users\\Nishant Kumar\\Documents\\treanding");
		login_page login=new login_page(driver, p);
		login.sigin("kajal9999v@gmail.com", "Rani@1997");
		String actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/",actual_url);

		loghandling.log_capture("TC1_youtube", "url is matching after signin");
		home_page home=new home_page(driver, p);
		home.click_trending();
		loghandling.log_capture("TC1_youtube", "able to click on trending");
		actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/feed/trending?bp=6gQJRkVleHBsb3Jl...", actual_url);
		screenCapture screen=new screenCapture(driver);
		String screen1= screen.screenshot("C:\\Users\\Nishant Kumar\\Documents\\trending.png");
		logout_page logout=new logout_page(driver, p);
		logout.logout();	
//      Assert.assertTrue(logout.is, "Logout button not displayed");

		loghandling.log_capture("TC1_youtube", "url is  matching after logout");
		actual_url=driver.getCurrentUrl();
		Boolean res= assetions.assertttt("https://www.youtube.com/",actual_url);
		
		if(res) {
			test.pass("test case getting passed..");
			test.addScreenCaptureFromPath(screen1);
//			String screen= screenCapture.screenshot("C:\\Users\\Nishant Kumar\\Documents\\screenshot.png");
			loghandling.log_capture("TC1_youtube", "testcase1 is getting pass");

		}
		else {
//			tc1.log(LogStatus.FAIL,"TestCase1 of ui is not getting passed");
			test.fail("test case getting failed");
			test.addScreenCaptureFromPath(screen1);
		
//			test.addScreenCaptureFromPath(screen1);
			loghandling.log_capture("TC1_youtube", "testcase1 is getting fail");

		}
//		report.endTest(tc1);
		report.flush();
		
		
	
	}
	

	
	

}
