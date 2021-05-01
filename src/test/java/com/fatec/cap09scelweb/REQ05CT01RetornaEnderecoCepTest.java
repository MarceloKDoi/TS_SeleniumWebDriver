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

public class REQ05CT01RetornaEnderecoCepTest {
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
	public void rEQ05CT01RetornaEnderecoCep() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1050, 708));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Alunos")).click();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("2042");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("Luiza Brunnet");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("luizabrunet@email.com");
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys("04345001");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		assertEquals("Avenida Engenheiro George Corbisier",
				driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(6)")).getText());
		driver.findElement(By.cssSelector("tr:nth-child(2) .delete")).click();
		driver.findElement(By.linkText("Excluir")).click();
		driver.findElement(By.linkText("Sair")).click();
	}
}
