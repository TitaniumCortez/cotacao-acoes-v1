package com.example.handlersFile;

import java.io.Serializable;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.crawler.app.cotacao.handlersFile.HandlerFileObjectAcao;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = HandlerFileObjectAcaoTest.class)
public class HandlerFileObjectAcaoTest {

	static TestSerDer testSerDer;
	static HandlerFileObjectAcao handlerFileObjectAcao;
	static final String handlerFileObjectAcaoTest = "HandlerFileObjectAcaoTest";
	
	@BeforeClass
	public static void criarObjecto() {
		testSerDer = new  TestSerDer(1, "ew");
		handlerFileObjectAcao = new HandlerFileObjectAcao();
	}

	@Test
	public void serializaObject() {		
		handlerFileObjectAcao.Serialized(handlerFileObjectAcaoTest, testSerDer);
	}

	@Test
	public void deserializaObject() {
		handlerFileObjectAcao.Serialized(handlerFileObjectAcaoTest, testSerDer);
		TestSerDer testDer = (TestSerDer) handlerFileObjectAcao.Deserialized(handlerFileObjectAcaoTest, testSerDer.getClass());
		System.out.println(testDer.toString());
	}	


}

class TestSerDer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public int a; 
    public String b; 
  
    // Default constructor 
    public TestSerDer(int a, String b) 
    { 
        this.a = a; 
        this.b = b; 
    }

	@Override
	public String toString() {
		return "TestSerDer [a=" + a + ", b=" + b + "]";
	} 
    
}
