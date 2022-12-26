package com.amazon.common;
/** @author Reshma Chachar
 * @date Dec 1, 2022
 * 
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest 
{
	public static WebDriver driver;
	public static Properties pro;

	@BeforeMethod
	public void setup() throws IOException 
	{
		pro = new Properties();
		String path = System.getProperty("user.dir") + "./src/test/java/com/amazon/Utility/config.properties";

		FileInputStream file1 = new FileInputStream(path);
		pro.load(file1);

		ChromeOptions co = new ChromeOptions();
		EdgeOptions eo = new EdgeOptions();

		String Browsername = pro.getProperty("browser");
		if (Browsername.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(co);
		} else if (Browsername.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver(eo);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		driver.get(pro.getProperty("baseurl"));
	}
	public static String takesScreenshot(String testName) throws IOException
	{		
		File s=(File)((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String d = System.getProperty("user.dir")+"\\Screenshots\\"+testName+".png";
		FileUtils.copyFile(s, new File(d));
		return d;
	}

//	@AfterMethod
//
//	public void TearDown() {
//		driver.quit();
//	}


}
