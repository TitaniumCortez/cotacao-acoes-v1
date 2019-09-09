package com.crawler.app.cotacao.seleniumWebDrivers;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.stereotype.Component;


public class GoogleChrome {

	// xPatch for get information page
	static final String VALOR = "//*[@id=\"knowledge-finance-wholepage__entity-summary\"]/div/g-card-section/div/g-card-section/div[2]/span[1]/span/span[1]";
	static final String NOME = "//*[@id=\"knowledge-finance-wholepage__entity-summary\"]/div/g-card-section/div/g-card-section/div[1]/div";

	private static ChromeDriverService service;
	private WebDriver driver;

	public GoogleChrome() {

	}

	public void inicializar() throws IOException {
		criarServieChrome();
		iniciarDriverChrome();
	}

	public void finalizar() {
		service.stop();
		driver.close();
	}

	private void criarServieChrome() throws IOException {
		service = new ChromeDriverService.Builder()
				.usingDriverExecutable(new File(System.getProperty("webdriver.chrome.driver"))).usingAnyFreePort()
				.build();
		service.start();
	}

	private void iniciarDriverChrome() {
		driver = new RemoteWebDriver(service.getUrl(), DesiredCapabilities.chrome());
	}

	public String cotar(String codigoAcao) {
		// And now use this to visit Google
		driver.get("http://www.google.com");
		// Alternatively the same thing can be done like this
		// DRIVER.navigate().to("http://www.google.com");

		// Find the text input element by its name
		WebElement search = driver.findElement(By.name("q"));

		// Enter something to search for
		search.sendKeys(codigoAcao);
		// Now submit the form. WebDriver will find the form for us from the element
		search.submit();

		// get cotation
		WebElement cotacao = driver.findElement(By.xpath(VALOR));
		WebElement nome = driver.findElement(By.xpath(NOME));
		System.out.println(nome.getText() + " " + cotacao.getText());

		return cotacao.getText();
	}

}
