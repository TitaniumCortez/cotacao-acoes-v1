package com.crawler.app.cotacao.repositoy;

import com.crawler.app.cotacao.network.HttpRest;
import com.crawler.app.cotacao.properties.GoogleProperties;

import org.apache.http.HttpException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GoogleApiRepository extends HttpRest {

    Logger log = LogManager.getLogger(GoogleApiRepository.class);

    @Autowired
    GoogleProperties googleProperties;

    /**
     * Retorna cotacao das acoes existente no
     * google sheets 
     * @return - <p>Object</p> da Planilha 
     * @throws HttpException
     */
    public Object getCotacaoCSV() throws HttpException {
        log.info("Iniciando getCotacaoCSV operacao api :values:batchGet");
        String url = googleProperties.getUrl().concat("{spreadsheetId}/values:batchGet");
        Object sheetsValues = this.getRest(url, null);

        log.info("Finalizado getCotacaoCSV - realizado chamada google api");
        log.debug("Finalizado getCotacaoCSV - realizado chamada google api : {}", sheetsValues);
        return sheetsValues;
    }    

}