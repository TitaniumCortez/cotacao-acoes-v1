package com.example.seleniumWebDriverTest;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crawler.app.cotacao.seleniumWebDrivers.GoogleChrome;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = GoogleChromeTest.class)
public class GoogleChromeTest {

	static GoogleChrome googleChrome;
	String[] acoes = new String[] { "MGLU3", "ABEV3", "BRAP4" };

	@BeforeClass
	public static void setEnvironment() throws IOException {
		System.setProperty("webdriver.chrome.driver", "..\\chromedriver\\tools\\chromedriver.exe");
		googleChrome = new GoogleChrome();
		googleChrome.inicializar();
	}
	

	@AfterClass
	public static void encerrarSessao() {
		googleChrome.finalizar();
	}

	@Test
	public void realizarUmaCotacao() {
		String valor = googleChrome.cotar(acoes[0]);
		System.out.println(valor);
	}

	@Test
	public void realizarCotacaoDeUmOuMaisAcao() {
		for (String a : acoes) {
			String valor = googleChrome.cotar(a);
			System.out.println(valor);
		}
	}
}
