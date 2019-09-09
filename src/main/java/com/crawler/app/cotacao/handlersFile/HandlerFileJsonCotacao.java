package com.crawler.app.cotacao.handlersFile;


import java.io.FileNotFoundException;
import java.io.FileReader;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

@Component
public class HandlerFileJsonCotacao {
	Gson gson;

	public HandlerFileJsonCotacao() {
		gson = new Gson();
	}

	public String[] getAcoes() throws JsonSyntaxException, JsonIOException, FileNotFoundException {
		return gson.fromJson(new FileReader(System.getProperty("dc.cotacao")), String[].class);		
	}
}
