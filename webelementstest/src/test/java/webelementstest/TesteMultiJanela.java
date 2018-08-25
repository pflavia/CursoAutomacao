package webelementstest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TesteMultiJanela {

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
	public void trocadePágina() {
		WebElement linkDragDrop = driver.findElement(By.linkText("Drag and Drop"));
		linkDragDrop.click();

		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		//troca de página
		driver.switchTo().window(tabs.get(1));
		assertEquals("Mootools Drag and Drop Example", driver.getTitle());
		//volta página anterior
		driver.switchTo().window(tabs.get(0));

		assertEquals("Treino Automação de Testes", driver.getTitle());

	}

}
