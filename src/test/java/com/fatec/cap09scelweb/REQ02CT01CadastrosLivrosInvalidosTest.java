package com.fatec.cap09scelweb;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.JavascriptExecutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.Keys;
import java.util.*;

public class REQ02CT01CadastrosLivrosInvalidosTest {
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
	public void rEQ02CT01CadastrosLivrosInvalidos() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1050, 708));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("204");
		driver.findElement(By.id("isbn")).sendKeys(Keys.ENTER);
		assertEquals("ISBN deve ter 4 caracteres",
				driver.findElement(By.cssSelector(".col-md-4 > .text-danger")).getText());
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("2043");
		driver.findElement(By.id("isbn")).sendKeys("2043");
		driver.findElement(By.id("isbn")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys(Keys.ENTER);
		assertEquals("Autor deve ter entre 1 e 50 caracteres",
				driver.findElement(By.cssSelector(".row:nth-child(3) .text-danger")).getText());
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("Marco Nanini");
		driver.findElement(By.id("autor")).sendKeys("Marco Nanini");
		driver.findElement(By.id("autor")).sendKeys(Keys.ENTER);
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys(Keys.ENTER);
		assertEquals("Titulo deve ter entre 1 e 50 caracteres",
				driver.findElement(By.cssSelector(".text-danger:nth-child(3)")).getText());
		driver.findElement(By.linkText("Sair")).click();
	}
}
