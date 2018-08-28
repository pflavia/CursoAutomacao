package Test;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.Test;

import Page.CalculadoraPage;
import Page.CaptureScreenShot;

import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class CalculadoraTest {
	public WebDriver driver;

	@Test
	public void SomadoismaisdoisTeste() {
		CalculadoraPage calculadoraPage = new CalculadoraPage (driver);
		String resultado = calculadoraPage.Soma("1", "1");
		assertEquals(resultado, "3");
		
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://treinoautomacao.hol.es/desafiosoma.html");

	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws IOException {
		System.out.println(testResult.getStatus());
		if (testResult.getStatus() == ITestResult.FAILURE) {
			new CaptureScreenShot(driver).captureScreenShot(testResult.getName());
		}
		driver.quit();
	}

}
