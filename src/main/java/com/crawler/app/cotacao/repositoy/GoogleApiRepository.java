package com.crawler.app.cotacao.repositoy;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import com.crawler.app.cotacao.model.SpreadSheet;
import com.crawler.app.cotacao.network.HttpRest;
import com.crawler.app.cotacao.properties.GoogleProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
     * @throws IOException
     * @throws JsonMappingException
     * @throws JsonParseException
     */
    public SpreadSheet getCotacao() throws HttpException, JsonParseException, JsonMappingException, IOException {
        log.info("Iniciando getCotacaoCSV operacao api :values:batchGet");
        String url = googleProperties.getUrl().concat("{spreadsheetId}/values:batchGet");

        // adiciona os urlParams
        urlParams = new LinkedHashMap<>();
        urlParams.put("spreadsheetId", googleProperties.getSpreadsheetId());

        // Adiciona os queryParams
        queryParams = new LinkedHashMap<>();
        queryParams.put("majorDimension", "COLUMNS");
        queryParams.put("ranges", googleProperties.getRanges());
        queryParams.put("key", googleProperties.getAppKey());
        
        //Request to endpoint
        String sheetsValues = this.getRest(url, urlParams, queryParams);

        SpreadSheet spreadSheet = new ObjectMapper().readValue(sheetsValues, SpreadSheet.class);

        log.info("Finalizado getCotacaoCSV - realizado chamada google api");
        log.debug("Finalizado getCotacaoCSV - realizado chamada google api : {}", sheetsValues);
        return spreadSheet;
    }

    public SpreadSheet insertData() throws HttpException {
        log.info("Iniciando insertData operacao api :append");
        String url = googleProperties.getUrl().concat("{spreadsheetId}/values/{sheetsName}:append");
        // adiciona os urlParams
        urlParams = new LinkedHashMap<>();
        urlParams.put("spreadsheetId", googleProperties.getSpreadsheetId());
        urlParams.put("sheetsName", googleProperties.getInsertData());
        

         // Adiciona os queryParams
         queryParams = new LinkedHashMap<>();
         queryParams.put("includeValuesInResponse", "true");
         queryParams.put("insertDataOption", "INSERT_ROWS");
         queryParams.put("responseDateTimeRenderOption", "FORMATTED_STRING");
         queryParams.put("responseValueRenderOption", "FORMATTED_VALUE");
         queryParams.put("valueInputOption", "RAW");
         queryParams.put("key", googleProperties.getAppKey());

         String sheetsValues = this.getRest(url, urlParams, queryParams);

        
         log.info("Finalizado insertData - realizado chamada google api");
         log.debug("Finalizado insertData - realizado chamada google api : {}", sheetsValues);
        return null;
    }

}