package com.fatec.cap09scelweb;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;

public class REQ04CT01EntradasInvalidasRAExistenteTest {
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;

	@BeforeEach
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "browserDriver/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@AfterEach
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void rEQ04CT01EntradasInvalidasRAExistente() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1050, 708));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Alunos")).click();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("204");
		driver.findElement(By.id("ra")).sendKeys(Keys.ENTER);
		assertEquals("RA deve ter 4 caracteres",
				driver.findElement(By.cssSelector(".col-md-4 > .text-danger")).getText());
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("20410");
		driver.findElement(By.id("ra")).sendKeys(Keys.ENTER);
		assertEquals("RA deve ter 4 caracteres",
				driver.findElement(By.cssSelector(".col-md-4 > .text-danger")).getText());
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("2041");
		driver.findElement(By.id("ra")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("Lucia da Silva");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("lucia@email.com");
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys("04345001");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.linkText("Voltar")).click();
		driver.findElement(By.linkText("Alunos")).click();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("2041");
		driver.findElement(By.id("ra")).sendKeys("2041");
		driver.findElement(By.id("ra")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("Lucas do Carmo");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("lucas@email.com");
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys("04345001");
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("2042");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		assertEquals(
				"Sistema de Controle de Emprestimo\\\\nSair\\\\nVoltar\\\\nLista de alunos\\\\nID RA Nome e-mail CEP Endereço\\\\n3 2041 Lucia da Silva lucia@email.com 04345001 Avenida Engenheiro George Corbisier\\\\nEditar\\\\nExcluir\\\\n5 2042 Lucas do Carmo lucas@email.com 04345001 Avenida Engenheiro George Corbisier\\\\nEditar\\\\nExcluir",
				driver.findElement(By.cssSelector("html")).getText());
		driver.findElement(By.cssSelector("tr:nth-child(2) .delete")).click();
		driver.findElement(By.linkText("Excluir")).click();
		driver.findElement(By.linkText("Sair")).click();
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		assertEquals("Dados invalidos", driver.findElement(By.cssSelector(".text-danger")).getText());
	}
}
