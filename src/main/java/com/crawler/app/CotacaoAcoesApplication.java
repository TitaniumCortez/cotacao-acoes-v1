package com.crawler.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableScheduling
@SpringBootApplication
@ComponentScan(basePackages = { "com.crawler.app.cotacao.schedule", "com.crawler.app.cotacao.cotacaoService",
		"com.crawler.app.cotacao.handlersFile", "com.crawler.app.cotacao.model","com.crawler.app.cotacao.repositoy" ,"com.crawler.app.cotacao.properties" })
public class CotacaoAcoesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CotacaoAcoesApplication.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
