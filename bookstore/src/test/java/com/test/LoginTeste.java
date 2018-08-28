package com.test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.page.LoginPage;
import com.page.HomePage;

public class LoginTeste {

	public WebDriver driver;
	
	@BeforeClass
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://sahitest.com/demo/training/login.htm");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testLoginValido() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.open();
		loginPage.sendUser("test");
		loginPage.sendPassword("secret");
		
		HomePage homePage = loginPage.logar();
		homePage.isLogged();
		assertTrue(true);
		
	}

}
