package com.amazon.Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.amazon.common.BaseTest;

public class amazonPage extends BaseTest {
	
	public WebDriver driver;
	//public String allinfo="//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small']";
	public String allinfo="(//div[@class='sg-col-inner'])[3]";
	public String phonelist="//div[contains(@class,'a-section a-spacing-none a-spacing')]//h2//span";
	public String priceList="//span[@class='a-price-whole']";

	public amazonPage(WebDriver driver) 
	{

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
	
	//All List
	@FindBy(xpath="//div[@class='a-section a-spacing-small puis-padding-left-small puis-padding-right-small']") 
	List<WebElement> all;
	
	
	public List<WebElement> getAll() {
		return all;
	}
	
	public int getAllsize() {
		return all.size();
		
	}

	@FindBy(xpath="(//input[@type='text'])[1]") WebElement textEnter;

	public WebElement getTextEnter()
	{
		return textEnter;
	}
	//click on samsung checkbox
	@FindBy(xpath="//*[text()='SAMSUNG']") WebElement samsung;

	public WebElement getSamsung() {
		return samsung;
	}
	
	@FindBy(xpath="(//*[text()='$100 & above'])[1]") WebElement price;

	public WebElement getPrice() {
		return price;
	}
	
	

}
