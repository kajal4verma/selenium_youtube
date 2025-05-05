package org.testing.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class home_page {
	ChromeDriver driver;
	Properties p;
	public home_page(ChromeDriver driver,Properties p)
	{ 
		this.driver=driver;
	    this.p=p;
		
	}
	public void click_trending() throws InterruptedException
	{
		Thread.sleep(2000);
		WebElement trending=driver.findElement(By.xpath(p.getProperty("trending")));
		trending.click();
		Thread.sleep(2000);
	}
	public void click_history() throws InterruptedException {
		Thread.sleep(2000);
		WebElement history=driver.findElement(By.xpath(p.getProperty("history")));
		history.click();
		Thread.sleep(2000);
	}
	public void search() throws InterruptedException {
		Thread.sleep(2000);
		WebElement search=driver.findElement(By.xpath(p.getProperty("search")));
		search.sendKeys("chhota bheem");
		WebElement search_btn=driver.findElement(By.xpath(p.getProperty("search_btn")));
		search_btn.click();	
		Thread.sleep(2000);
		
	}
	public void search2() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement search=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(p.getProperty("search"))));
		search.sendKeys("aarti");
		Thread.sleep(2000);
		WebElement search_btn=driver.findElement(By.xpath(p.getProperty("search_btn")));
		search_btn.click();	
		Thread.sleep(2000);

		}
	public void subscription() throws InterruptedException {
		Thread.sleep(2000);
		WebElement subscription=driver.findElement(By.xpath(p.getProperty("subs")));
		subscription.click();
		Thread.sleep(2000);
	
	}
    public void watchlist() throws InterruptedException {
		Thread.sleep(2000);
	WebElement subscription=driver.findElement(By.xpath(p.getProperty("watchlist")));
	subscription.click();
	Thread.sleep(2000);
	
    }
    public void playlist() throws InterruptedException {
    	Thread.sleep(2000);
    	WebElement p_list=driver.findElement(By.xpath(p.getProperty("playlist")));
		p_list.click();
		Thread.sleep(2000);
    }
}
