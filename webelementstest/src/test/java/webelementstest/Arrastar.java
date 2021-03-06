package webelementstest;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class Arrastar {

	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://jqueryui.com/resources/demos/droppable/default.html");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {

		WebElement Origem = driver.findElement(By.id("draggable"));

		WebElement Destino = driver.findElement(By.id("droppable"));
		new Actions(driver).dragAndDrop(Origem, Destino).perform();

		assertEquals("Dropped!",Destino.getText());

	}
	@Test
	public void print() throws InterruptedException, IOException {

		WebElement Origem = driver.findElement(By.id("draggable"));

		WebElement Destino = driver.findElement(By.id("droppable"));
		new Actions(driver).dragAndDrop(Origem, Destino).perform();

		File scrnShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrnShot , new File("c:\\Users\\aluno\\flavia-workspace\\main_page.png"));


	}


}
