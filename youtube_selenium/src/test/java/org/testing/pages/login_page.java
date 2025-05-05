package org.testing.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class login_page {
	ChromeDriver driver;
	Properties p;
	public login_page(ChromeDriver driver,Properties p)
	{ this.driver=driver;
	this.p=p;
		
	}

	public void sigin(String user,String pass) throws InterruptedException {
		WebElement login=driver.findElement(By.xpath(p.getProperty("signin")));
		login.click();
		WebElement userid=driver.findElement(By.xpath(p.getProperty("user_id")));
		userid.sendKeys(user);
		WebElement next=driver.findElement(By.xpath(p.getProperty("next")));
		next.click();


		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("password"))));				
		password.sendKeys(pass);
		Thread.sleep(2000);

		WebElement next1=driver.findElement(By.xpath(p.getProperty("next")));
		next1.click();
		Thread.sleep(4000);

	}
	
}
