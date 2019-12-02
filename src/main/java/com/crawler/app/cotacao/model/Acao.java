package com.crawler.app.cotacao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Acao implements Serializable{

	private static final long serialVersionUID = -5792577008399059426L;
	
	String codigo;
	List<ValorDiario> valorDiario;

	public void addCotacaoDiario(String valor) {
		this.valorDiario = valorDiario != null ? valorDiario : new ArrayList<ValorDiario>(); 
		this.valorDiario.add(new ValorDiario(valor));
	}

	@Override
	public String toString() {
		return "Acao [codigo=" + codigo + ", valorDiario=" + valorDiario + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}

class ValorDiario implements Serializable{

	private static final long serialVersionUID = 4587974467839101675L;
	
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