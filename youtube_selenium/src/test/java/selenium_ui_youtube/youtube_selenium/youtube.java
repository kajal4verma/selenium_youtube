package selenium_ui_youtube.youtube_selenium;



import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



;


public class youtube {
public static void main(String[] args) throws InterruptedException {
	ChromeDriver driver=new ChromeDriver();
	driver.get("http://www.youtube.com");
	driver.manage().window().maximize();
Thread.sleep(2000);
	WebElement user=driver.findElement(By.xpath("//*[text()='Sign in' and @role='text']"));
	JavascriptExecutor executor=(JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", user);
	
	WebElement pass=driver.findElement(By.xpath("//*[@*='identifier']"));
	pass.sendKeys("kajal4555v@gmail.com");
	//*[@*='identifier']
//	WebElement pass=driver.findElement(By.xpath("//input[@*='pass']"));
//	pass.sendKeys("kajal12234");
//	WebElement login=driver.findElement(By.xpath("//button[@*='login']"));
//	login.click();
	

}
}
