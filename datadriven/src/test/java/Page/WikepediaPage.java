package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikepediaPage {

	public WebDriver driver;

	public WikepediaPage (WebDriver driver) {
		this.driver = driver;
	}

	public WikepediaPage pesquisar (String campoPesquisa) throws InterruptedException {
		driver.findElement(By.id("searchInput")).sendKeys(campoPesquisa);
		//Thread.sleep(4000);
		driver.findElement(By.id("searchButton")).click();
		return this;
	}

	public String tituloTela () {
		return driver.getTitle();


	}

}
