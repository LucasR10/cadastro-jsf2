package br.com.stefanini.phaseListener;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class JPAFilter implements Filter {

	public static final String CADASTRO_PU = "cadastroPU";
	public  static final String ENTITY_MANAGER_NAME_REQ = "EntityManager";
	
	private EntityManagerFactory factory;
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.factory = Persistence.createEntityManagerFactory(CADASTRO_PU);
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		
		EntityManager entityManager = this.factory.createEntityManager();
		request.setAttribute( ENTITY_MANAGER_NAME_REQ , entityManager);
		entityManager.getTransaction().begin();
		
		chain.doFilter(request, response);
		
		try {
			if(! entityManager.isOpen() ) {
				entityManager.getTransaction().begin();
			}
			entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
		}finally{
			entityManager.close();
		}
	}
	
	@Override
	public void destroy() {		this.factory.close();
		
	}

}
