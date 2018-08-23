package webelementstest;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class WebElementTest {

	public WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://treinoautomacao.hol.es/elementsweb.html");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testValidaNome() throws InterruptedException {
		WebElement txtNome = driver.findElement(By.name("txtbox1"));
		if (txtNome.isEnabled()) {
			txtNome.sendKeys("Flávia");
		}
		Thread.sleep(3000);
		assertEquals("Nome não é o esperado","Flávia", txtNome.getAttribute("value"));
	}

	@Test
	public void testValidaCampoDesabilitado() throws InterruptedException {
		WebElement txtNome = driver.findElement(By.name("txtbox2"));
		assertFalse("Componente deveria estar desabilitado", txtNome.isEnabled());
	}

	@Test
	public void testValidaRadioButton() throws InterruptedException {
		List <WebElement> elementsRadioButton = driver.findElements(By.name("radioGroup1"));
		for (WebElement e: elementsRadioButton) {
			if (e.getAttribute("values") == "Radio Button 3 selecionado") {
				e.click();
			}
		}
		assertTrue("Radio não está marcado",elementsRadioButton.get(2).isSelected());
	}


	@Test
	public void testValidaCheckBox() throws InterruptedException {
		List <WebElement> elementsCheckbox = driver.findElements(By.name("chkbox"));
		elementsCheckbox.get(2).click();
		elementsCheckbox.get(3).click();
		assertTrue("CheckBox 3 não está marcado", elementsCheckbox.get(2).isSelected());
		assertTrue("CheckBox 4 não está marcado", elementsCheckbox.get(3).isSelected());

		//		for (WebElement e: elementsCheckbox ) {
		//			assertFalse("Deveria estar selecionado!", e.isSelected());
		//			if
		//		}

	}

	@Test
	public void testValidaDropDownListSingle() throws InterruptedException {
		Thread.sleep(3000);
		WebElement elementsListSingle = driver.findElement(By.name("dropdownlist"));
		Select listboxselements = new Select(elementsListSingle);
		List <WebElement> allListboxselements = listboxselements.getOptions();
		listboxselements.selectByIndex(3);
		WebElement opc = allListboxselements.get(3);
		
		Thread.sleep(3000);
		assertTrue("Item 4 selecionado", opc.isSelected());
	}
	
	@Test
	public void testValidaDropDownListMultiSelected() throws InterruptedException {
		Thread.sleep(3000);
		
		WebElement elementsListMultiSelected = driver.findElement(By.name("multiselectdropdown"));
		Select listboxselements = new Select(elementsListMultiSelected);
		List <WebElement> allListboxselements = listboxselements.getOptions();
		listboxselements.selectByIndex(3);
		listboxselements.selectByIndex(4);
		
		
		if(listboxselements.isMultiple()) {
			listboxselements.selectByIndex(4);
			listboxselements.selectByIndex(7);
			listboxselements.selectByIndex(8);
		}
		
		
		
		
		Thread.sleep(3000);
	
		assertTrue("Item 4 selecionado", allListboxselements.get(3).isSelected() && allListboxselements.get(4).isSelected() );
		
	}
	
	
	@Test
	public void testValidaFrameTargettrust() throws InterruptedException {
	driver.switchTo().frame(1);
	driver.switchTo().defaultContent();
	driver.switchTo().frame("iframe_b");
	WebElement campoBusca = driver.findElement(By.id("s"));
	campoBusca.sendKeys("Flávia");
	
	assertEquals("Nome não é o esperado","Flávia", campoBusca.getAttribute("value"));
	}
	
		
}
