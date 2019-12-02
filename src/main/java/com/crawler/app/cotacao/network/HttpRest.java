package com.crawler.app.cotacao.network;

import org.apache.http.HttpException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class HttpRest {

    @Autowired
    RestTemplate restTemplate;

    public byte[] getRest(String url) throws HttpException {
        restTemplate.getMessageConverters().add(messageConvertByte());
        // ResponseEntity<byte[]> response = restTemplate.exchange(google.getUrl(),
        // HttpMethod.GET, entity, byte[].class);
        ResponseEntity<byte[]> response = restTemplate.getForEntity(url, byte[].class);
        httpStatus(response);
        return response.getBody();
    }

    private void httpStatus(ResponseEntity<?> response) throws HttpException {
        if (response.getStatusCode().value() >= 400)
            throw new HttpException(" Error Status Http code : " + response.getStatusCode().value());
    }

    private ByteArrayHttpMessageConverter messageConvertByte() {
        return new ByteArrayHttpMessageConverter();
    }

}