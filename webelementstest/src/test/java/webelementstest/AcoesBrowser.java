package webelementstest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AcoesBrowser {

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
	public void test() {
		WebElement linkCalculadora = driver.findElement(By.linkText("Calculadora"));
		linkCalculadora.click();
		assertEquals("Desafio Automação Cálculos", driver.getTitle());

		WebElement linkLocalizarTable = driver.findElement(By.linkText("Localizar Table"));
		linkLocalizarTable.click();
		assertEquals("Trabalhando com tables", driver.getTitle());

		driver.navigate().back();
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		driver.navigate().back();
		assertEquals("Treino Automação de Testes", driver.getTitle());

		driver.navigate().forward();
		assertEquals("Desafio Automação Cálculos", driver.getTitle());
		driver.navigate().forward();
		assertEquals("Trabalhando com tables", driver.getTitle());
	}

}
