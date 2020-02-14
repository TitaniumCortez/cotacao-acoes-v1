package com.crawler.app.cotacao.model;

import org.springframework.stereotype.Component;

@Component
public class Acao {

	double diferencaPercentual;

	public double applyDifferencePercentual(ValorAcao valorAcao) {
		// 52,00 - 54,00 / 54,00 * 100 = -3.70
		return this.diferencaPercentual = calculatePercentual(ValorAcao.value_predecessor, ValorAcao.value_current);
	}

	private double calculatePercentual(Double antecessor, Double atual) {
		double x1, x2;
		try {
			x1 = new Double(antecessor);
			x2 = new Double(atual);
		} catch (NumberFormatException ex) {
			return 0;
		}
		return ((x2 - x1) / x1) * 100;
	}

	@Override
	public String toString() {
		return "Acao [ diferencaPercentual=" + diferencaPercentual + "]";
	}

}
