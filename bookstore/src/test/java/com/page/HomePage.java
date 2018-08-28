package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	private WebDriver driver;
	public HomePage (WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isLogged () {
		if (driver.findElement(By.id("available")) != null) {
			return true;
		}
		return false;
	}
	
}
