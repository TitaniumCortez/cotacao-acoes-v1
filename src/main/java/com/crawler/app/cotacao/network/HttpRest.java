package com.crawler.app.cotacao.network;

import java.util.Map;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.json.JsonbHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class HttpRest {

    @Autowired
    RestTemplate restTemplate;

    public Object getRest(String url, Map<String,String> urivariables, ) throws HttpException {
        // restTemplate.getMessageConverters().add(messageConvertByte());
        restTemplate.getMessageConverters().add(messageConvertJson());
        // ResponseEntity<byte[]> response = restTemplate.exchange(google.getUrl(),
        // HttpMethod.GET, entity, byte[].class);
        ResponseEntity<Object> response = restTemplate.getForEntity(url, Object.class, urivariables);
        httpStatus(response);
        return response.getBody();
    }

    /**
     * Adiciona query params na Url
     * @param url
     * @param queryParams
     * @return
     */
    private String builderQueryParams(String url, Map<String, String> queryParams) {
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