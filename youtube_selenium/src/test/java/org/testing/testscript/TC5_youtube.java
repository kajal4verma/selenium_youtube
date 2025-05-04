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
import org.testing.pages.vedio_play_page;
import org.testing.reporthandling.loghandling;
import org.testing.reporthandling.report_handling;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TC5_youtube extends base {
	
	@Test
	public void tc5() throws InterruptedException {
		ExtentReports report= report_handling.report();
		ExtentTest tc5=report.startTest("TC5_youtube");
		login_page login=new login_page(driver, p);
		login.sigin("kajal9999v@gmail.com", "Rani@1997");
		String actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/",actual_url);
		loghandling.log_capture("TC5_youtube", "url is matching after sigin ");

        home_page home=new home_page(driver, p);
        home.search2();
        actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/results?search_query=aarti",actual_url);
		loghandling.log_capture("TC5_youtube", "able to hit search  query");

        vedio_play_page vedio=new vedio_play_page(driver, p);
        vedio.play_vedio2();
        actual_url=driver.getCurrentUrl();
		assetions.assertttt("https://www.youtube.com/watch?v=3ucCEjXS9n8",actual_url);
		loghandling.log_capture("TC5_youtube", "able to play vedio and send comment ");

        vedio_play_page comment=new vedio_play_page(driver, p);
        comment.comment();
        logout_page logout=new logout_page(driver, p);
        logout.logout();
		loghandling.log_capture("TC5_youtube", "url is matching after signout");

        actual_url=driver.getCurrentUrl();
		Boolean res= assetions.assertttt("https://www.youtube.com/",actual_url);

	if(res)
	{
		tc5.log(LogStatus.PASS, "testcase5 is getting pass");
		loghandling.log_capture("TC5_youtube", "testcase 5 is getting pass");
	}
	else
	{
		tc5.log(LogStatus.FAIL, "testcase5 is getting fail");
		loghandling.log_capture("TC5_youtube", "testcase 5 is getting fail");

	}
	report.endTest(tc5);
	report.flush();
	}
	

}

