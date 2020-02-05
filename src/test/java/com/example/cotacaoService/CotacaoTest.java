package com.example.cotacaoService;

import static org.mockito.Mockito.when;

import com.crawler.app.cotacao.cotacaoService.CotacaoService;
import com.crawler.app.cotacao.model.Acoes;
import com.crawler.app.cotacao.repositoy.GoogleApiRepository;

import org.apache.http.HttpException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {  Acoes.class })
public class CotacaoTest {

	@Mock
	private GoogleApiRepository googleApiRepository;

	@InjectMocks
	private CotacaoService cotacao;

	@InjectMocks
	Acoes acoes;

	@Before
	public void setMockOutput() throws HttpException {
		when(googleApiRepository.getCotacaoCSV()).thenReturn(" ");
	}

	@Test
	public void contextLoads() {
		cotacao.acoes();
	}

}
