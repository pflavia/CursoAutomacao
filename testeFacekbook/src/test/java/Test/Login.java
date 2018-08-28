package Test;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Page.LoginPage;

public class Login {

	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.facebook.com/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}


	@Test
	public void testLoginFacebookValido() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.logar("treinoautomacao01@gmail.com","teste1000");
		assertTrue("Não está na tela de logado",loginPage.telaLogado());
	}
	
	@Test
	public void testLoginFacebookInvalido() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.logar("treinoautomacao01@gmail.com1","teste1000");
		assertFalse("Não está na tela de logado",loginPage.telaLogado());
	}
	
	

}
