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

    public String getCotacaoCSV() throws HttpException {
        log.info("Iniciando getCotacaoCSV");
        byte[] csv = this.getRest(googleProperties.getUrl());
        String data = new String(csv, 0, csv.length);

        log.info("Finalizado getCotacaoCSV - realizado chamada google api");
        log.debug("Finalizado getCotacaoCSV - realizado chamada google api : {}", data);
        return data;
    }

}