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
import com.crawler.app.cotacao.model.Acoes;
import com.crawler.app.cotacao.model.AddCotacao;
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
			String data = googleApiRepository.getCotacaoCSV();
			List<String[]> csv = formatDataCsv(data);
			log.info("Processo de cotacao Finalizado com Sucesso");
			csv.remove(0);
			csv.forEach(cotar -> {
				acoes.addCotacao(new AddCotacao(cotar[0], cotar[1]));
			});
			LinkedHashMap<String, Acao>  listacoes = acoes.getAcoes();
			listacoes.forEach((k,v) -> {
				Acao a = v;
				
				System.out.println(k + "- " + a);
			});
		} catch (HttpException e) {
			log.error("Processo nao executado");
			log.catching(e);
		}
	}

	private List<String[]> formatDataCsv(String data) {
		log.info("Format Data receive");
		List<String> formating = Arrays.asList(data.replaceAll("\r", "").split("\n"));
		List<String[]> row = new ArrayList<>();
		for (String columns : formating) {
			row.add(columns.split(",", 2));
		}
		log.debug("Format finish");
		return row;
	}
}
