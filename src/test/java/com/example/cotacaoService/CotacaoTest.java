package com.example.cotacaoService;

import static org.mockito.Mockito.when;

import java.io.IOException;

import com.crawler.app.cotacao.cotacaoService.CotacaoService;
import com.crawler.app.cotacao.model.Acao;
import com.crawler.app.cotacao.model.Acoes;
import com.crawler.app.cotacao.model.SpreadSheet;
import com.crawler.app.cotacao.repositoy.GoogleApiRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
@ContextConfiguration(classes = { Acao.class })
public class CotacaoTest {

	@Mock
	private GoogleApiRepository googleApiRepository;

	@InjectMocks
	private CotacaoService cotacao;

	@InjectMocks
	Acao acao;

	@Before
	public void setMockOutput() throws HttpException, JsonParseException, JsonMappingException, IOException {
		when(googleApiRepository.getCotacao()).thenReturn(new ObjectMapper().readValue(mockData(), SpreadSheet.class));
	}

	@Test
	public void contextLoads() {
		cotacao.acoes();
	}

	private String mockData() {
		return "{ \"spreadsheetId\": \"1qDbs87EcHD3W1xRAsxmY8zqfqGe8zXr6UQZt1yvQ7iA\", \"valueRanges\": [{\"range\": \"'Página1'!A2:B69\",\"majorDimension\": \"COLUMNS\",	\"values\": [[\"ABEV3\",\"AZUL4\",\"B3SA3\" ],[\"16,41\",\"59,24\",	\"50,2\" ]]}] }";
	}

}
