package org.testing.reporthandling;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

public class screenCapture {
 ChromeDriver driver;
 public screenCapture(ChromeDriver driver) {
	 this.driver=driver;
 }

public  String screenshot(String filePath) throws IOException {
	File f=	driver.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(f,new File(filePath));
	return filePath;

}
}
