package br.com.stefanini.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Lucas Carvalho
 * @since 17/15/2020
 * */
public class JPAUtil {

	public static final String CADASTRO_PU = "cadastroPU";

	private static EntityManagerFactory factory;

	private static EntityManagerFactory getFactory() {
		if (factory == null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory(CADASTRO_PU);
		}
		return factory;

	}

	public static EntityManager getEntityManager() {
		return getFactory().createEntityManager();
	}

	public static void closeEm() {
		if (factory != null || factory.isOpen()) {
			factory.close();
			getEntityManager().close();
		}
	}
}
