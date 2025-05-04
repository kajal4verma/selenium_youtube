package org.testing.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class vedio_play_page {
	ChromeDriver driver;
	Properties p;
	public vedio_play_page(ChromeDriver driver,Properties p) {
		this.p=p;
		this.driver=driver;
		
	}
	public void play_vedio() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement vedio= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("vedio_link"))));
		vedio.click();
//		WebElement vedio=driver.findElement(By.xpath(p.getProperty("vedio_link")));
//		vedio.click();
		Thread.sleep(2000);
		WebElement like=driver.findElement(By.xpath(p.getProperty("like")));
		like.click();
		Thread.sleep(2000);
		WebElement unlike=driver.findElement(By.xpath(p.getProperty("dislike")));
		unlike.click();
		Thread.sleep(2000);
	}
	public void play_vedio2() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement vedio= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("vedio_link2"))));
		vedio.click();
Thread.sleep(2000);

	}
	public void comment() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(1000);
		WebElement  sort=driver.findElement(By.xpath(p.getProperty("sort")));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",sort);
//		Thread.sleep(1000);
		WebElement comment=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("comment"))));
		js.executeScript("arguments[0].click()",comment);

//		comment.click();
		Thread.sleep(2000);
		WebElement write_comment=driver.findElement(By.xpath(p.getProperty("comment_write")));
	   write_comment.sendKeys("radha krishana");
		Thread.sleep(2000);
	   WebElement comment2=driver.findElement(By.xpath(p.getProperty("comment_send")));
//	   comment2.click();
		js.executeScript("arguments[0].click()",comment2);

		Thread.sleep(2000);

	}
	public void subscribe() throws InterruptedException {
		WebElement subscribe1=driver.findElement(By.xpath(p.getProperty("subscribe")));
		subscribe1.click();
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement subscribe=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("subscribe_notification"))));

		subscribe.click();
		Thread.sleep(2000);
		WebElement unsubscribe=driver.findElement(By.xpath(p.getProperty("unsubscribe")));
		unsubscribe.click();
		Thread.sleep(2000);

		WebElement unsubscribe1=driver.findElement(By.xpath(p.getProperty("click_unsubscribe")));
		unsubscribe1.click();
		Thread.sleep(2000);

	

	}

}
