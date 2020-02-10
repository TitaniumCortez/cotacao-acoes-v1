package com.example.repository;

import com.crawler.app.cotacao.network.HttpRest;
import com.crawler.app.cotacao.properties.GoogleProperties;
import com.crawler.app.cotacao.repositoy.GoogleApiRepository;

import org.apache.http.HttpException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {GoogleApiRepository.class, HttpRest.class, GoogleApiRepositoryTest.ConfigurationGoogleProperties.class})
public class GoogleApiRepositoryTest {

    @Autowired
    GoogleApiRepository googleApiRepository;

    @Test
    public void deveRetornarAsCotacoesNaPlanilha() throws HttpException {
        String ob = googleApiRepository.getCotacao();
        System.out.println(ob);
    }

    @EnableConfigurationProperties(GoogleProperties.class)
    public static class ConfigurationGoogleProperties {
        // nothing
    }
    //@SpringBootTest(classes = { GoogleApiRepository.class, GoogleApiRepositoryTest.ConfigurationGoogleProperties.class })

}