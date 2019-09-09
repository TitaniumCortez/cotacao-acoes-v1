package com.crawler.app.cotacao.cotacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crawler.app.cotacao.handlersFile.HandlerFileJsonCotacao;
import com.crawler.app.cotacao.model.Acoes;
import com.crawler.app.cotacao.model.AddCotacao;
import com.crawler.app.cotacao.seleniumWebDrivers.GoogleChrome;

@Component
public class Cotacao {

	@Autowired
	HandlerFileJsonCotacao lista_acoes;
	//@Autowired
	GoogleChrome cotarGoogleChrome = new GoogleChrome();
	@Autowired
	Acoes acoes;

	public void acoes() {

		try {
			cotarGoogleChrome.inicializar();
			for (String a : lista_acoes.getAcoes()) {
				String valor = cotarGoogleChrome.cotar(a);
				acoes.addCotacao(new AddCotacao(a, valor));
			}
			cotarGoogleChrome.finalizar();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
