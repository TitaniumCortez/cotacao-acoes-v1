package com.crawler.app.cotacao.cotacaoService;

import org.apache.http.HttpException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.LinkedHashMap;
import com.crawler.app.cotacao.model.Acao;
import com.crawler.app.cotacao.model.SpreadSheet;
import com.crawler.app.cotacao.repositoy.GoogleApiRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class CotacaoService {

	Logger log = LogManager.getLogger(CotacaoService.class);

	@Autowired
	GoogleApiRepository googleApiRepository;

	LinkedHashMap<String, Acao> acoes;

	public void acoes() {
		log.info("Iniciando Processo de cotacao");
		ObjectMapper mapper = new ObjectMapper();

		try {
			final String sheetsValuesJson = googleApiRepository.getCotacao();
			SpreadSheet sheetsValues = mapper.readValue(sheetsValuesJson, SpreadSheet.class);

			
			log.info("Processo de cotacao Finalizado com Sucesso");

		} catch (final HttpException e) {
			log.error("Processo nao executado");
			log.catching(e);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


}
