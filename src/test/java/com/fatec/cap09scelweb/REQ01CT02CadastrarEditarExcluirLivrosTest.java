package com.fatec.cap09scelweb;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.Dimension;

import org.openqa.selenium.JavascriptExecutor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

public class REQ01CT02CadastrarEditarExcluirLivrosTest {
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
	public void rEQ01CT02CadastrarEditarExcluirLivros() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1050, 708));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("2043");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("Marco Nanini");
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("Os loucos enxergam a paz no caos");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.cssSelector("tr:nth-child(2) .btn-primary")).click();
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("Loucos enxergam a paz no caos");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("Loucos enxergam a paz no caos de São Paulo");
		driver.findElement(By.cssSelector(".btn")).click();
		assertEquals("Loucos enxergam a paz no caos de São Paulo",
				driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(3)")).getText());
		driver.findElement(By.cssSelector("tr:nth-child(2) .delete")).click();
	}
}
