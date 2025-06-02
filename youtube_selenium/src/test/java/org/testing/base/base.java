package org.testing.base;

import java.io.IOException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testing.assertion.assetions;
import org.testing.reporthandling.report_handling;
import org.testing.utilities.properties;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;



public class base {
	protected  	ChromeDriver driver;
    public Properties p;  
	static boolean isLogoutDisplayed;
    public ExtentReports report;
    public ExtentTest test;
	@BeforeMethod(alwaysRun = true)
	public void open_browser() throws IOException {
		p=	properties.properties_handle("../youtube_selenium/object.properties");
        WebDriverManager.chromedriver().setup();

//	    System.setProperty("webdriver.chrome.driver", "C:/Users/Nishant Kumar/Downloads/chromedriver/chromedriver.exe");

		driver=new ChromeDriver();
		driver.get("http://www.youtube.com");
		driver.manage().window().maximize();
		String title=  driver.getTitle();
		System.out.println(title);
		ExtentSparkReporter spark= report_handling.report();
		report =new ExtentReports();
		report.attachReporter(spark);
		

	}

	
	@AfterMethod
	public void close_browser() {
		
//		report.flush();
		driver.close();


		
	}

}
