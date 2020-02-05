package com.crawler.app.cotacao.cotacaoService;

import org.apache.http.HttpException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.crawler.app.cotacao.model.Acao;
import com.crawler.app.cotacao.repositoy.GoogleApiRepository;

@Component
public class CotacaoService {

	Logger log = LogManager.getLogger(CotacaoService.class);

	@Autowired
	GoogleApiRepository googleApiRepository;

	@Autowired
	LinkedHashMap<String, Acao> acoes;

	public void acoes() {
		log.info("Iniciando Processo de cotacao");
		try {
			final Object sheetsValues = googleApiRepository.getCotacaoCSV();

			log.info("Processo de cotacao Finalizado com Sucesso");
			csv.remove(0);
			csv.forEach(cotar -> {
			//	acoes.addCotacao(new AddCotacao(cotar[0], cotar[1]));
			});

			
		} catch (final HttpException e) {
			log.error("Processo nao executado");
			log.catching(e);
		}
	}



	private List<String[]> formatDataCsv(final String data) {
		log.info("Format Data receive");
		final List<String> formating = Arrays.asList(data.replaceAll("\r", "").split("\n"));
		final List<String[]> row = new ArrayList<>();
		for (final String columns : formating) {
			row.add(columns.split(",", 2));
		}
		log.debug("Format finish");
		return row;
	}
}
