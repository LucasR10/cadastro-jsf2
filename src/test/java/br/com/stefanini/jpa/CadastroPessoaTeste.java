package br.com.stefanini.jpa;

import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.stefanini.costante.Genero;
import br.com.stefanini.model.Pessoa;
import br.com.stefanini.phaseListener.JPAFilter;

public class CadastroPessoaTeste {

	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(JPAFilter.CADASTRO_PU);
	private EntityManager entityManager;
	Pessoa pessoa =  new Pessoa(null,"Lucas", Genero.F, "email", new Date(), Calendar.getInstance(), Calendar.getInstance(), "naturalidade", "nacionalidade", "cpf");
	
	@BeforeClass
	public void initEntityManager() throws Exception {
		 
	    entityManager = entityManagerFactory.createEntityManager();
	    entityManager.getTransaction().begin();
	    
	}

	@After
	public void closeEntityManager() throws Exception {
		 entityManager.getTransaction().commit();
	    if(entityManager != null){
	        entityManager.close();
	    }
	}

	
	@Test
	public void salvar() throws Exception {
	    try {
	    	Pessoa p =pessoa;
	    	entityManager.persist( entityManager.merge(p) );
	    	p = entityManager.find( Pessoa.class, 1L);
	    	System.out.println( p );
	    	assertTrue( entityManager.find( Pessoa.class, 1L).getId() != null);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println( e.getMessage() );
		}
	    
	}
	
	@Test
	public void atualizar() throws Exception {
	    try {
	    	Pessoa p = entityManager.find( Pessoa.class, 1L);
	    	String nome = "Pedro Silva";
			p.setNome(nome);
	    	entityManager.persist(p);
	    	Pessoa pessoaUpdate = entityManager.find( Pessoa.class, 1L);
	    	System.out.println( pessoaUpdate );
	    	
	    	assertTrue( pessoaUpdate.getNome().equalsIgnoreCase( nome) );
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println( e.getMessage() );
		}
	    
	}
	
	@Test
	public void buscarPorId() throws Exception {
	    try {
	    	Pessoa p = entityManager.find( Pessoa.class, 1L);
	    	System.out.println( p );
	    	assertTrue( p.getCpf() != null );
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println( e.getMessage() );
		}
	    
	}
	
	@Test
	public void listarTodos ()throws Exception {
	    try {
	    	List<Pessoa> ps = entityManager.createNamedQuery( Pessoa.LISTAR_TODOS, Pessoa.class).getResultList();
	    	assertTrue( ps.size() >= 0 );
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println( e.getMessage() );
		}
	    
	}
	
	
	@Test
	public void validarDoisCadastrosComMesmoCPF()throws Exception {
		Pessoa p = pessoa;
    	Pessoa pessoaCpf = entityManager.createNamedQuery(Pessoa.BUSCAR_POR_CPF, Pessoa.class).setParameter(1, p.getCpf() ).getSingleResult(); 
		System.out.println( pessoaCpf );
		assertTrue( p.getCpf().equals(pessoaCpf.getCpf()) );
	}

}
