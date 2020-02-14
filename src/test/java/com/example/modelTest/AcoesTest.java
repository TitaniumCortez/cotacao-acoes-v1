package com.example.modelTest;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import com.crawler.app.cotacao.model.Acao;
import com.crawler.app.cotacao.model.ValorAcao;

public class AcoesTest {

	@Test
	public void aplicaDiferencaoPercentualPositiva() {
		Acao acao = new Acao();
		assertEquals("percentual positivo", 4.5482483097726, acao.applyDifferencePercentual(new ValorAcao(16.27, 17.01)), 0.001);
	}

	@Test
	public void aplicaDiferencaoPercentualNegativa() {
		Acao acao = new Acao();
		assertEquals("percentual negativo", -4.350382128159917, acao.applyDifferencePercentual(new ValorAcao(17.01, 16.27)), 0.001);
	}
}
