package com.crawler.app.cotacao.schedule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.crawler.app.cotacao.cotacaoService.Cotacao;

@Component
public class Schedule {

	@Autowired
	Cotacao cotar;
	
	//@Scheduled(cron = "*1 * * * * *")
	@Scheduled(fixedDelay = 2000)
	public void cotacao() {
		cotar.acoes();
	}
}
