package com.example.seleniumWebDriverTest;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SeleniumDriverChromeTest.class)
public class SeleniumDriverChromeTest {

	private static ChromeDriverService service;
	private WebDriver driver;

	@BeforeClass
	public static void criarEIniciarService() throws IOException {
		service = new ChromeDriverService.Builder().usingDriverExecutable(new File("..\\chromedriver\\tools\\chromedriver.exe"))
				.usingAnyFreePort().build();
		service.start();
	}

	@AfterClass
	public static void createAndStopService() {
		service.stop();
	}

	@Before
	public void criarDriver() {
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
	}

	@After
	public void quitDriver() {
		driver.quit();
	}

	@Test
	public void realizarBuscaChrome() {
		driver.get("http://www.google.com");
		WebElement search = driver.findElement(By.name("q"));
		search.sendKeys("webdriver");
		search.submit();
	}
}
