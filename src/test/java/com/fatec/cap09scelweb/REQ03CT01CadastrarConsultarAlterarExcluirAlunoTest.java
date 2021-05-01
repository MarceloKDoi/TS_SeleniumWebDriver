package com.fatec.cap09scelweb;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
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

public class REQ03CT01CadastrarConsultarAlterarExcluirAlunoTest {
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

	public String waitForWindow(int timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Set<String> whNow = driver.getWindowHandles();
		Set<String> whThen = (Set<String>) vars.get("window_handles");
		if (whNow.size() > whThen.size()) {
			whNow.removeAll(whThen);
		}
		return whNow.iterator().next();
	}

	@Test
	public void rEQ03CT01CadastrarConsultarAlterarExcluirAluno() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1050, 708));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Alunos")).click();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("2041");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("Lucas do Carmo");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("lucas@email.com");
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys("04345001");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		assertEquals("04345001", driver.findElement(By.cssSelector("td:nth-child(5)")).getText());
		driver.findElement(By.linkText("Voltar")).click();
		driver.findElement(By.linkText("Alunos")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
		vars.put("win3500", waitForWindow(2000));
		driver.switchTo().window(vars.get("win3500").toString());
		assertEquals("lucas@email.com", driver.findElement(By.cssSelector("td:nth-child(4)")).getText());
		driver.findElement(By.linkText("Editar")).click();
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("Lucas do Carmo e Silva");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		assertEquals("Lucas do Carmo e Silva", driver.findElement(By.cssSelector("td:nth-child(3)")).getText());
		driver.findElement(By.linkText("Excluir")).click();
		assertEquals("ID RA Nome e-mail CEP Endereço", driver.findElement(By.cssSelector(".panel-body")).getText());
		driver.findElement(By.linkText("Sair")).click();
	}
}
