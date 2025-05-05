package org.testing.base;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testing.assertion.assetions;
import org.testing.reporthandling.report_handling;
import org.testing.utilities.properties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class base {
   public	ChromeDriver driver;
    public Properties p;  
   
	@BeforeMethod
	public void open_browser() throws IOException {
		p=	properties.properties_handle("../youtube_selenium/object.properties");
		driver=new ChromeDriver();
		driver.get("http://www.youtube.com");
		driver.manage().window().maximize();
	       
	}

	@AfterMethod
	public void close_browser() {
		driver.close();
//		driver.getTitle();
		
	}

}
