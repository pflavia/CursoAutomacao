package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CalculadoraPage {
	public WebDriver driver;
	
	public CalculadoraPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public String Soma (String numeroum , String numerodois) {
		driver.findElement(By.id("number1")).sendKeys(numeroum);
		driver.findElement(By.id("number2")).sendKeys(numerodois);
		driver.findElement(By.id("somar")).click();
		return driver.findElement(By.id("total")).getAttribute("value");
	}
	
	public String Total() {
		return driver.findElement(By.id("total")).getText();
	}
	
	
	

}
