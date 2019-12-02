package com.crawler.app.cotacao.cotacaoService;

import org.apache.http.HttpException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crawler.app.cotacao.handlersFile.HandlerFileJsonCotacao;
import com.crawler.app.cotacao.model.Acoes;
import com.crawler.app.cotacao.repositoy.GoogleApiRepository;

@Component
public class Cotacao {

	Logger log = LogManager.getLogger(Cotacao.class);

	@Autowired
	GoogleApiRepository googleApiRepository;

	@Autowired
	Acoes acoes;

	public void acoes() {
		log.info("Iniciando Processo de cotacao");
		try {
			googleApiRepository.getCotacaoCSV();
			log.info("Processo de cotacao Finalizado com Sucesso");
		} catch (HttpException e) {
			log.error("Processo nao executado");
			log.catching(e);
		}
	}

}
