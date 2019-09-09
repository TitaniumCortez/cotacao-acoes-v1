package com.crawler.app.cotacao.model;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.crawler.app.cotacao.handlersFile.HandlerFileObjectAcao;

@Component
public class Acoes implements Serializable {

	private static final long serialVersionUID = 1L;
	private final Long identifier = "acoes".hashCode() + serialVersionUID;

	transient HandlerFileObjectAcao handlerFileObjectAcao = new HandlerFileObjectAcao();

	LinkedHashMap<String, Acao> acoes;

	public Acoes() {
		this.acoes = verifySerializeObject();
	}

	public void addCotacao(AddCotacao cotacao) {
		if (this.acoes.get(cotacao.codigo_acao) == null)
			this.acoes.put(cotacao.codigo_acao, new Acao());

		Acao acao = this.acoes.get(cotacao.codigo_acao);
		acao.addCotacaoDiario(cotacao.valor);
		serializeObject();
	}

	public List<Acao> getHistorico() {
		return null;
	}

	@SuppressWarnings("unchecked")
	private LinkedHashMap<String, Acao> verifySerializeObject() {
		Acoes obSer = (Acoes) handlerFileObjectAcao.Deserialized(identifier.toString(), this.getClass());
		return obSer != null ? obSer.acoes : new LinkedHashMap<String, Acao>();
	}

	public LinkedHashMap<String, Acao> getAcoes() {
		return this.acoes;
	}

	private void serializeObject() {
		handlerFileObjectAcao.Serialized(identifier.toString(), this);
	}

	@Override
	public String toString() {
		return "Acoes [acoes=" + acoes + ", getHistorico()=" + getHistorico() + ", verifySerializeObject()="
				+ verifySerializeObject() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
