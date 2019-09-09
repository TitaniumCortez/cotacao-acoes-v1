package com.crawler.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = { "com.crawler.app.cotacao.google.schedule", "com.crawler.app.cotacao.cotacaoService",
		"com.crawler.app.cotacao.handlersFile", "com.crawler.app.cotacao.seleniumWebDrivers",
		"com.crawler.app.cotacao.model" })
public class CotacaoAcoesApplication {

	public static void main(String[] args) {		
		SpringApplication.run(CotacaoAcoesApplication.class, args);
		validEnvAndSettingDefault();
	}

	static void validEnvAndSettingDefault() {

		if (System.getProperty("webdriver.chrome.driver") == null) {
			System.setProperty("webdriver.chrome.driver", "..\\chromedriver\\tools\\chromedriver.exe");
			System.out.println("missing webdriver.chrome.driver environment, setting default webdriver.chrome.driver: "
					+ System.getProperty("webdriver.chrome.driver"));
		}

		if (System.getProperty("dc.cotacao") == null) {
			System.setProperty("dc.cotacao", "..\\cotacao.json");
			System.out.println(
					"missing dc.cotacao environment, setting default dc.cotacao: " + System.getProperty("dc.cotacao"));
		}

	}
}
