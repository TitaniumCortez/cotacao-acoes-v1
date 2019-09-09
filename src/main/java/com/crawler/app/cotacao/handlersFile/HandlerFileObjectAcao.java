package com.crawler.app.cotacao.handlersFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.springframework.stereotype.Service;

public class HandlerFileObjectAcao {

	private static String prefix = ".ser";

	public HandlerFileObjectAcao() {
	}

	public void Serialized(String fileName, Object object) {
		FileOutputStream file;
		ObjectOutputStream out;

		try {
			file = new FileOutputStream(fileName.concat(prefix));
			out = new ObjectOutputStream(file);
			out.writeObject(object);

			out.close();
			file.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Object Deserialized(String fileName, Class classz) {
		// Reading the object from a file
		FileInputStream file;
		ObjectInputStream in;

		try {
			file = new FileInputStream(fileName.concat(prefix));
			in = new ObjectInputStream(file);

			// Method for deserialization of object
			Object ob = classz.cast(in.readObject());
			in.close();
			file.close();
			return ob;

		} catch (Exception e) {}

		return null;
	}

}
