package org.testing.testscript;

import java.io.IOException;
import java.time.Duration;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testing.assertion.assetions;
import org.testing.base.base;
import org.testing.pages.login_page;
import org.testing.pages.logout_page;
import org.testing.pages.vedio_play_page;
import org.testing.reporthandling.loghandling;
import org.testing.reporthandling.report_handling;
import org.testing.reporthandling.screenCapture;
import org.testng.annotations.Test;


public class TC9_youtube extends base {
	@Test
	public void tc9() throws InterruptedException, IOException {
           test=report.createTest("test_case9");
		login_page login=new login_page(driver,p);
		login.sigin("kajal9999v@gmail.com", "Rani@1997");
		String actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/", actual_url);
		 loghandling.log_capture("TC9_youtube","url is getting matched after signin");
		vedio_play_page play=new vedio_play_page(driver, p);
		play.play_all_vedio();
		screenCapture screen=new screenCapture(driver);
		String sceen1= screen.screenshot("C:\\Users\\Nishant Kumar\\Documents\\playlist.png");
         test.addScreenCaptureFromPath(sceen1 );
		
		logout_page logout=new logout_page(driver, p);
		logout.logout();
		 loghandling.log_capture("TC9_youtube","url is getting matched after signout");
        actual_url=driver.getCurrentUrl();
		 Boolean res= assetions.assertttt("https://www.youtube.com/", actual_url);
		 if(res) {
			 test.pass("test case getting pass..");
//			 tc9.log(LogStatus.PASS, "testcase 9 getting passed");
			 loghandling.log_capture("TC9_youtube","testcase 9 is getting pass");
			 
		 }
		 else
		 {
			 test.fail("test case getting fail..");

//			 tc9.log(LogStatus.FAIL, "testcase 9 getting failed");
			 loghandling.log_capture("TC9_youtube","testcase 9 is getting fail"); 
		 }
//		 report.endTest(tc9);
			report.flush();
	}

}
