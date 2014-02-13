package com.fiap.loja.singleton;

import java.io.IOException;
import java.util.Properties;

public class PropertySingleton {

	private static Properties p;
	private static final String NOME_ARQUIVO = "/loja.properties";
	
	public static Properties getInstance(){
		if (p == null){
			p = new Properties();
			try {
				p.load(PropertySingleton.class.getResourceAsStream(NOME_ARQUIVO));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return p;
	}
}





