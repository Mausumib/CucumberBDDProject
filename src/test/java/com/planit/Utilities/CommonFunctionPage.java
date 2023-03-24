package com.planit.Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctionPage {	
	
	static WebDriver driver;

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {

		}
	}
	
	public WebElement wait(WebElement element, int time) {
		WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(time))
				.until(ExpectedConditions.visibilityOf(element));
		return ele;
	}
}
