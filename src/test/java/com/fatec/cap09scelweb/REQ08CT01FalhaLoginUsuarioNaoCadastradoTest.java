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


public class REQ08CT01FalhaLoginUsuarioNaoCadastradoTest {
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
	public void rEQ08CT01FalhaLoginUsuarioNaoCadastrado() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1050, 708));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("oswaldo");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("589");
		driver.findElement(By.cssSelector("button")).click();
		assertEquals("Invalid username and password.\\\\nLOGIN\\\\nNão cadastrado? Crie uma conta",
				driver.findElement(By.cssSelector("body")).getText());
	}
}
