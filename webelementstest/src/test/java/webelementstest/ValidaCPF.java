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

public class ValidaCPF {
	
	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.geradordecpf.org/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void test() {
		
		WebElement btngerarcpf = driver.findElement(By.id("btn-gerar-cpf"));
		btngerarcpf.click();
		
		WebElement numeroCPF = driver.findElement(By.id("numero"));
		String cpfGerado ;
		Boolean cpfValido;
		
		assertEquals("","");
		
		
		//CPF Sem Ponto
		btngerarcpf.click();
		cpfGerado = numeroCPF.getAttribute("value");
		cpfValido = cpfGerado.matches("^[0-9]{11}$");
		assertTrue(cpfValido);
		
		//CPF com Ponto
		WebElement cbPonto = driver.findElement(By.id("cbPontos"));
		cbPonto.click();
		btngerarcpf.click();
		
		cpfGerado = numeroCPF.getAttribute("value");
	
		cpfValido = cpfGerado.matches("^[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$");
		assertTrue(cpfValido);
		
		
		
	}

}
