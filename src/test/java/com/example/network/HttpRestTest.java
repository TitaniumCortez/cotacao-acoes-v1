package com.example.network;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.crawler.app.cotacao.CotacaoAcoesApplication;
import com.crawler.app.cotacao.model.SpreadSheet;
import com.crawler.app.cotacao.model.ValueRanges;
import com.crawler.app.cotacao.repositoy.GoogleApiRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.apache.http.HttpException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CotacaoAcoesApplication.class })
public class HttpRestTest {

    @Autowired
    GoogleApiRepository googleApiRepository;

    @Test
    public void deveRetornarAsCotacoesNaPlanilha()
            throws HttpException, JsonParseException, JsonMappingException, IOException {

    }
}