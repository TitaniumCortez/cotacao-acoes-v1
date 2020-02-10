package com.example.network;

import com.crawler.app.cotacao.CotacaoAcoesApplication;
import com.crawler.app.cotacao.network.HttpRest;
import com.crawler.app.cotacao.properties.GoogleProperties;
import com.crawler.app.cotacao.repositoy.GoogleApiRepository;

import org.apache.http.HttpException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { CotacaoAcoesApplication.class })
public class HttpRestTest {

    @Autowired
    GoogleApiRepository googleApiRepository;

    @Test
    public void deveRetornarAsCotacoesNaPlanilha() throws HttpException {

        String response = googleApiRepository.getCotacao();
        System.out.println(response);
    }

}