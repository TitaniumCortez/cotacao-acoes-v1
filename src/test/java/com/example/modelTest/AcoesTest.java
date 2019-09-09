package com.example.modelTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crawler.app.cotacao.model.Acoes;
import com.crawler.app.cotacao.model.AddCotacao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AcoesTest.class)
public class AcoesTest {

	Acoes acoes;

	@Test
	public void adicionarUmaNovaAcaoCotada() {
		acoes = new Acoes();
		acoes.addCotacao(new AddCotacao("RCE", "18,80"));
		System.out.println(acoes.toString());
	}
	
	@Test
	public void adicionar2NovaAcaoCotada() {
		acoes = new Acoes();
		acoes.addCotacao(new AddCotacao("RCE", "18,80"));
		acoes.addCotacao(new AddCotacao("EDS", "23,80"));
		System.out.println(acoes.toString());
	}
}
