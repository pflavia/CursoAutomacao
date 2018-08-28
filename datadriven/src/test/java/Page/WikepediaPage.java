package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikepediaPage {

	public WebDriver driver;

	public WikepediaPage (WebDriver driver) {
		this.driver = driver;
	}

	public WikepediaPage pesquisar (String campoPesquisa) {
		driver.findElement(By.id("searchInput")).sendKeys(campoPesquisa);
		driver.findElement(By.id("searchButton")).click();
		return this;
	}

	public String tituloTela () {
		return driver.findElement(By.id("firstHeading")).getAttribute("value");


	}

}
