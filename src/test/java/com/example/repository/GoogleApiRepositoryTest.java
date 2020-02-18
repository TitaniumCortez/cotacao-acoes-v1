package com.example.repository;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;

import com.crawler.app.cotacao.CotacaoAcoesApplication;
import com.crawler.app.cotacao.model.SpreadSheet;
import com.crawler.app.cotacao.model.ValueRanges;
import com.crawler.app.cotacao.network.HttpRest;
import com.crawler.app.cotacao.properties.GoogleProperties;
import com.crawler.app.cotacao.repositoy.GoogleApiRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.apache.http.HttpException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CotacaoAcoesApplication.class, GoogleApiRepositoryTest.ConfigurationGoogleProperties.class })
public class GoogleApiRepositoryTest {

    @Autowired
    GoogleApiRepository googleApiRepository;

    @Test
    public void deveRetornarAsCotacoesNaPlanilha()
            throws HttpException, JsonParseException, JsonMappingException, IOException {
        SpreadSheet spreadSheet = googleApiRepository.getCotacao();
        assertNotNull(spreadSheet);
        assertNotNull("value spreadsheetId", spreadSheet.getSpreadsheetId());
        assertNotNull("value valueRanges", spreadSheet.getValueRanges());
        List<ValueRanges> values = spreadSheet.getValueRanges();
        assertNotNull("range", values.get(0).getRange());
    }

    @EnableConfigurationProperties(GoogleProperties.class)
    public static class ConfigurationGoogleProperties {
        // nothing
    }

}