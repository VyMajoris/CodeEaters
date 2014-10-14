package br.com.helpradar.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;






public class EntityManagerFactorySingleton {

	private static EntityManagerFactory factory;
	
	private EntityManagerFactorySingleton(){
		super();
	}
	
	public static EntityManagerFactory getInstance(){
		if (factory == null){
			EntityManagerFactory persistence = Persistence.createEntityManagerFactory("CLIENTE_ORACLE");
			factory = persistence;
		}
		return factory;
	}
}
