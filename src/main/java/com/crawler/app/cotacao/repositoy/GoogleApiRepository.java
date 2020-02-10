package com.crawler.app.cotacao.repositoy;

import java.util.LinkedHashMap;
import java.util.Map;

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
    Map<String, String> urlParams;
    Map<String, String> queryParams;

    /**
     * Retorna cotacao das acoes existente no google sheets
     * 
     * @return -
     *         <p>
     *         Object
     *         </p>
     *         da Planilha
     * @throws HttpException
     */
    public String getCotacao() throws HttpException {
        log.info("Iniciando getCotacaoCSV operacao api :values:batchGet");
        String url = googleProperties.getUrl().concat("{spreadsheetId}/values:batchGet");

        // adiciona os urlParams
        urlParams = new LinkedHashMap<>();
        urlParams.put("spreadsheetId", googleProperties.getSpreadsheetId());

        // Adiciona os queryParams
        queryParams = new LinkedHashMap<>();
        queryParams.put("majorDimension", "COLUMNS");
        queryParams.put("ranges", "Página1!A2:B69");
        queryParams.put("key", "AIzaSyAqlGCc8oqPxXDKXpcLYMOHAcMxT21kigA");

        String sheetsValues = this.getRest(url, urlParams, queryParams);

        log.info("Finalizado getCotacaoCSV - realizado chamada google api");
        log.debug("Finalizado getCotacaoCSV - realizado chamada google api : {}", sheetsValues);
        return sheetsValues;
    }

}