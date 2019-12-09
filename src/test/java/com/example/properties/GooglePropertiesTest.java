package com.example.properties;


import com.crawler.app.cotacao.properties.GoogleProperties;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { GooglePropertiesTest.TestConfiguration.class })
public class GooglePropertiesTest {

	@Autowired
	GoogleProperties googleProperties;

	@Test
	public void loadProperties() {
        System.out.println(googleProperties.getUrl());
	}

	@EnableConfigurationProperties(GoogleProperties.class)
    public static class TestConfiguration {
        // nothing
    }

}
