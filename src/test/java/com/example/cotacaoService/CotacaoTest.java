package com.example.cotacaoService;

import static org.mockito.Mockito.when;

import com.crawler.app.cotacao.cotacaoService.Cotacao;
import com.crawler.app.cotacao.repositoy.GoogleApiRepository;

import org.apache.http.HttpException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CotacaoTest.class)
public class CotacaoTest {

	@Mock
	private GoogleApiRepository googleApiRepository;

	@InjectMocks
	private Cotacao cotacao;

	@Before
	public void setMockOutput() throws HttpException {
		when(googleApiRepository.getCotacaoCSV()).thenReturn(" INDICE,VALOR \n ABEV3,\"18,45\"	\n	AZUL4,\"54,7\"");
	}

	@Test
	public void contextLoads() {
		cotacao.acoes();
	}

}
