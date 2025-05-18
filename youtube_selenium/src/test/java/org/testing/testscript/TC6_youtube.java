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
import org.testing.pages.vedio_play_page;
import org.testing.reporthandling.loghandling;
import org.testing.reporthandling.report_handling;
import org.testing.reporthandling.screenCapture;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class TC6_youtube extends base{
	
	@Test
	public void tc6() throws InterruptedException, IOException {	
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

		test=report.createTest("test_case6");
		login_page login=new login_page(driver, p);
		login.sigin("kajal9999v@gmail.com", "Rani@1997");
		String actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/",actual_url);
		loghandling.log_capture("TC6_youtube", "url is matching after sigin ");
        home_page home=new home_page(driver, p);
        home.search2();
        actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/results?search_query=aarti",actual_url);
		loghandling.log_capture("TC6_youtube", "able to hit search query ");
        vedio_play_page vedio=new vedio_play_page(driver, p);
        vedio.play_vedio2();
        actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/watch?v=3ucCEjXS9n8",actual_url);
		loghandling.log_capture("TC6_youtube", "able to play vedio and subscribe channel");
        vedio_play_page subscribe=new vedio_play_page(driver, p);
        subscribe.subscribe();
        screenCapture screen=new screenCapture(driver);
		String sceen1= screen.screenshot("C:\\Users\\Nishant Kumar\\Documents\\subscribe.png");
         test.addScreenCaptureFromPath(sceen1 );
        logout_page logout=new logout_page(driver, p);
        logout.logout();
        loghandling.log_capture("TC6_youtube", "url is matching after signout ");
        actual_url=driver.getCurrentUrl();
		Boolean res= assetions.assertttt("https://www.youtube.com/",actual_url);

	if(res)
	{   
		test.pass("test case getting pass...");
//		tc6.log(LogStatus.PASS, "testcase6 is getting pass");
		loghandling.log_capture("TC6_youtube", "testcase 6 is getting pass");
	}
	else
	{
		test.fail("test case getting fail...");
//		tc6.log(LogStatus.FAIL, "testcase6 is getting fail");
		loghandling.log_capture("TC6_youtube", "testcase 6 is getting fail");

	}
//	report.endTest(tc6);
	report.flush();
	}
	}
	


