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

public class REQ06CT01EmprestimoLivroISBNAoRATest {
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
	public void rEQ06CT01EmprestimoLivroISBNAoRA() {
		driver.get("https://ts-scel.herokuapp.com/login");
		driver.manage().window().setSize(new Dimension(1050, 708));
		driver.findElement(By.name("username")).click();
		driver.findElement(By.name("username")).sendKeys("jose");
		driver.findElement(By.name("password")).click();
		driver.findElement(By.name("password")).sendKeys("123");
		driver.findElement(By.cssSelector("button")).click();
		driver.findElement(By.linkText("Alunos")).click();
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("2987");
		driver.findElement(By.id("nome")).click();
		driver.findElement(By.id("nome")).sendKeys("Sara");
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).sendKeys("sara@email.com");
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys("04343001");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.id("cep")).click();
		driver.findElement(By.id("cep")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("cep")).sendKeys("04345001");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.linkText("Voltar")).click();
		driver.findElement(By.linkText("Livros")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("8911");
		driver.findElement(By.id("autor")).click();
		driver.findElement(By.id("autor")).sendKeys("Marvin");
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).click();
		driver.findElement(By.id("titulo")).sendKeys("Mar um Sonho Bom");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		driver.findElement(By.linkText("Editar")).click();
		driver.findElement(By.linkText("Voltar")).click();
		driver.findElement(By.linkText("Empréstimo")).click();
		driver.findElement(By.id("isbn")).click();
		driver.findElement(By.id("isbn")).sendKeys("8911");
		driver.findElement(By.id("ra")).click();
		driver.findElement(By.id("ra")).sendKeys("2987");
		driver.findElement(By.cssSelector(".btn:nth-child(1)")).click();
		vars.put("window_handles", driver.getWindowHandles());
		driver.findElement(By.cssSelector(".btn:nth-child(2)")).click();
		vars.put("win332", waitForWindow(2000));
		driver.switchTo().window(vars.get("win332").toString());
		assertEquals("8911", driver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(2)")).getText());
		assertEquals("2987", driver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(3)")).getText());
		assertEquals("2021/05/01", driver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(4)")).getText());
		assertEquals("2021/05/09", driver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(5)")).getText());
		driver.findElement(By.linkText("Voltar")).click();
		driver.findElement(By.linkText("Logout")).click();
	}
}
