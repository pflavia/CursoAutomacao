package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	public WebDriver driver;
	public LoginPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public LoginPage logar (String email, String senha) {
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("pass")).sendKeys(senha);
		driver.findElement(By.id("u_0_2")).click();
		
		return this;
	}
	
	public boolean telaLogado() {
		return driver.findElement(By.id("js_3")).isDisplayed();
	}
}
