package com.crawler.app.cotacao.model;

public class ValorAcao {

	static Double value_predecessor = 0.00;
	static Double value_current = 0.00;

	public ValorAcao(Double value_antecessor, Double value_current) {
		ValorAcao.value_predecessor = value_antecessor;
		ValorAcao.value_current = value_current;
	}

}