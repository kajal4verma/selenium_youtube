package org.testing.pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class logout_page {
	ChromeDriver driver;
	Properties p;
	public logout_page(ChromeDriver driver,Properties p)
	{
		this.driver=driver;
	this.p=p;
		
	}
	public void logout() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement profile=driver.findElement(By.xpath(p.getProperty("profile")));
		profile.click();
		Thread.sleep(2000);
		WebElement signout=driver.findElement(By.xpath(p.getProperty("signout")));
		signout.click();
		Thread.sleep(2000);

		
	}

}
