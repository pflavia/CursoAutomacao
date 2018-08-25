package webelementstest;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.qameta.allure.Allure;
import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.Link;
import io.qameta.allure.Issue;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Attachment;

public class TesteAllure {

	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("http://treinoautomacao.hol.es/index.html");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	@DisplayName("Human-readable test name")
	public void testSomething() throws Exception {
		WebElement linkCalculadora = driver.findElement(By.linkText("Calculadora"));
		linkCalculadora.click();
		assertEquals("Desafio Automação Cálculos", driver.getTitle());

		Allure.addAttachment("My attachment", "My attachment content");
		
	}

//		@Attachment
//		public String performedActions(ActionSequence actionSequence) {
//		    return actionSequence.toString();
//		}
//
//		@Attachment(value = "Page screenshot", type = "image/png")
//		public byte[] saveScreenshot(byte[] screenShot) {
//		    return screenShot;
//		}

	}

