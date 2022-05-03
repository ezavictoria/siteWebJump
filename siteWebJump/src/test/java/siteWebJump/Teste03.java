package siteWebJump;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

//2 - Bibliotecas
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


// 3 - Classe
public class Teste03 {
	// 3.1 Atributos / Características
	String url;               // endereço do site alvo
	WebDriver driver;         // objeto do Selenium WebDriver
	
	// 3.2 Métodos ou Funções
	@Before
	public void iniciar() {
		url = "https://wj-qa-automation-test.github.io/qa-test/";
		System.setProperty("webdriver.chrome.driver", 
		"C:\\Users\\PC\\eclipse-workspace\\SiteUnDosTres\\drivers\\chrome\\100.0.4896.60\\chromedriver.exe");
		driver = new ChromeDriver ();
		driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}
		
	@After
	public void finalizar() {
		driver.quit();
	}
	
	@Test
	public void consultarSite() {
		// Página inicial
		
		String name = "ExempleTwo";
		
		driver.get(url);
		driver.findElement(By.id("btn_one")).click();
		driver.findElement(By.xpath("/html/body/div/div[2]/div[1]/div/div[2]/div[3]/label/input")).click();
		driver.findElement(By.id("select_box")).getAttribute(name);
		driver.findElement(By.xpath("/html/body/div/div[2]/div[2]/div/div[2]/div/p[1]/input")).sendKeys(Keys.chord("Eza"));
		
		//Resultado esperado
		
		String image = "Selenium Webdriver";		
		assertEquals(image, driver.findElement(By.xpath("/html/body/div/div[2]/div[3]/div/div[2]/img[4]")).getText());

	
	}
	
}

