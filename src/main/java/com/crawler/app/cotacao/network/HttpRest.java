package com.crawler.app.cotacao.network;

import java.util.Map;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HttpRest {

    Logger log = LogManager.getLogger(HttpRest.class);

    @Autowired
    RestTemplate restTemplate;

    public String getRest(String url, Map<String, String> urivariables, Map<String, String> queryParams)
            throws HttpException {
        String newurl = builderQueryParams(url, queryParams);
        log.info("GET url: {}", newurl);

        ResponseEntity<String> response = restTemplate.getForEntity(newurl, String.class, urivariables);
        httpStatus(response);
        return response.getBody();
    }

    /**
     * Adiciona query params na Url
     * 
     * @param url
     * @param queryParams
     * @return String Url
     */
    private String builderQueryParams(String url, Map<String, String> queryParams) {
        if (queryParams == null)
            return url;

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url);
        queryParams.forEach((key, value) -> {
            builder.queryParam(key, value);
        });
        return builder.build().toString();
    }

    private void httpStatus(ResponseEntity<?> response) throws HttpException {
        if (response.getStatusCode().value() >= 400)
            throw new HttpException(" Error Status Http code : " + response.getStatusCode().value());
    }

    private ByteArrayHttpMessageConverter messageConvertByte() {
        return new ByteArrayHttpMessageConverter();
    }

    private JsonbHttpMessageConverter messageConvertJson() {
        return new JsonbHttpMessageConverter();
    }

}