package org.testing.testscript;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

//import com.relevantcodes.extentreports.LogStatus;

public class TC2_youtube extends base{
     
	

	@Test
	public void tc2() throws InterruptedException, IOException 
	{
//		   
//		
		test=report.createTest("test_case2");
			login_page login=new login_page(driver, p);
			login.sigin("kajal9999v@gmail.com", "Rani@1997");
			String actual_url=driver.getCurrentUrl();
			assetions.assertttt("https://www.youtube.com/",actual_url);
			loghandling.log_capture("TC2_youtube", "url is match after signin");

			home_page home=new home_page(driver, p);
		    home.click_history();
		    actual_url=driver.getCurrentUrl();
		    assetions.assertttt("https://www.youtube.com/feed/history", actual_url);
			loghandling.log_capture("TC2_youtube", "able to click on history");
			screenCapture screen=new screenCapture(driver);
			String screen1= screen.screenshot("C:\\\\Users\\\\Nishant Kumar\\\\Documents\\\\history.png");
            test.addScreenCaptureFromPath(screen1);
		    logout_page logout=new logout_page(driver, p);
		    logout.logout();
		   
			loghandling.log_capture("TC2_youtube", "url is match after signout");
			actual_url=driver.getCurrentUrl();
			Boolean res= assetions.assertttt("https://www.youtube.com/",actual_url);
			if(res) {
				test.pass("test cases getting passed..");
//				tc2.log(LogStatus.PASS,"testcase2 is getting pass");
				loghandling.log_capture("TC2_youtube", "testcase2 is getting pass");
			}
			else
			{
				test.fail("test cases getting failed...");
//				tc2.log(LogStatus.FAIL,"testcase2 is getting fail");
				loghandling.log_capture("TC2_youtube", "testcase2 is getting fail");

			}
			
			report.flush();
			
	
	}


}
