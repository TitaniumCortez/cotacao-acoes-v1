package com.crawler.app.cotacao.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Acao {

	double diferencaPercentual;
	List<ValorDiario> valorDiario;

	public void addCotacaoDiario(String valor) {
		this.valorDiario = valorDiario != null ? valorDiario : new ArrayList<ValorDiario>();
		this.valorDiario.add(new ValorDiario(valor));
		applyDifferencePercentual();
	}

	private void applyDifferencePercentual() {
		if (valorDiario.size() - 1 <= 0)
			return;
		
		ValorDiario antecessor, atual;

		antecessor = valorDiario.get(valorDiario.size() - 1);
		atual = valorDiario.get(valorDiario.size());
		//52,00 - 54,00 / 54,00 * 100 = -3.70
		this.diferencaPercentual =  calculatePercentual(antecessor.valor , atual.valor);

	}

	private double calculatePercentual(String antecessor, String atual) {
		double x1, x2;
		try {
			x1 = new Double(antecessor);
			x2 = new Double(atual);
		} catch (NumberFormatException ex) {
			return 0;
		}
		return x2 - x1 / x1 * 100;
	}

	@Override
	public String toString() {
		return "Acao [valorDiario=" + valorDiario + " diferencaPercentual=" + diferencaPercentual + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(diferencaPercentual);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((valorDiario == null) ? 0 : valorDiario.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acao other = (Acao) obj;
		if (Double.doubleToLongBits(diferencaPercentual) != Double.doubleToLongBits(other.diferencaPercentual))
			return false;
		if (valorDiario == null) {
			if (other.valorDiario != null)
				return false;
		} else if (!valorDiario.equals(other.valorDiario))
			return false;
		return true;
	}

}

class ValorDiario  {

	String valor;
	Date date;

	public ValorDiario(String valor) {
		this.valor = valor;
		this.date = new Date();
	}

	@Override
	public String toString() {
		return "ValorDiario [valor=" + valor + ", Date=" + date + "]";
	}

}
