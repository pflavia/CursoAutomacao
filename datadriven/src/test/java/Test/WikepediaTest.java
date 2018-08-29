package Test;

import org.testng.annotations.Test;

import com.utils.SpreadsheetData;
import com.utils.WebDriverUtils;

import Page.WikepediaPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;

public class WikepediaTest {
	public WebDriver driver;

	@BeforeTest
	public void setUp() throws Exception {
//		System.setProperty("webdriver.chrome.driver",
//				"C:\\Drivers\\chromedriver.exe");
		driver = WebDriverUtils.getDriver(WebDriverUtils.getSeleniumProperties("selenium.browser")); 
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://en.wikipedia.org/wiki/Main_Page");
	}

	@AfterTest
	public void tearDown() throws Exception {
		driver.quit();
	}


	
	@Test(dataProvider = "dbPaises")
	public void testPesquisaWike(String nome) throws InterruptedException {
		WikepediaPage wikepedia = new WikepediaPage(driver);
		wikepedia.pesquisar(nome);
		assertEquals( wikepedia.tituloTela(), nome + " - Wikipedia","Não pesquisou pelo pais certo");
	}




	@DataProvider (name = "dbPaises")
	public Object[][] createData() {
		Object[][] testData = SpreadsheetData.readExcelData("Paises", "src/test/resources/paises.xls", "Dados");
		return testData;
		
	}
}
