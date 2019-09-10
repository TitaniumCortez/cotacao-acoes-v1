# cotacao-acoes
Crawler google cotação de acoes 

# descricao

Realiza cotacoes de acoes pelo google chrome utilizando o selenium para realizar as buscas e obter as cotaçoes, 
Objecto é serializado para o carregamento do historico. 


# Dependencias

- WebDriver.crome.driver = driver do google chrome
- dc.cotacao  = json com a lista de acoes a serem cotadas. 
	
	modelo : ["ABEV3", "AZUL4" ]

Variaveis de ambiente :
- webdriver.chrome.driver = "Path para chromedriver.exe"
- dc.cotacao = "Path jsonFile"
