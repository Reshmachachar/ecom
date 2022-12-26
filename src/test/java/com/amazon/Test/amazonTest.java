package com.amazon.Test;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.Pages.amazonPage;
import com.amazon.common.BaseTest;

public class amazonTest extends BaseTest
{
	public int maxVal=1000;
	amazonPage am;
	Actions act;
	String namepath;
	String pricepath;
	
	@Test
	public void amazonInfo() throws InterruptedException
	{
		 am=new amazonPage(driver);
		 Thread.sleep(2);
		 am.getTextEnter().sendKeys("phone",Keys.ENTER);
		
		 am.getSamsung().click();
		 //Assert.assertTrue(am.getSamsung().isSelected());
		 
		 am.getPrice().click();
		 System.out.println("size"+am.getAllsize());
		 
		 
		// List<WebElement> list=driver.findElements(By.xpath(am.priceList));
		 List<WebElement> list = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-4']"));
		 
		 for(WebElement list1:list)
		 {
			 System.out.println(list1.getText());
		 }
	
	}
	
}
