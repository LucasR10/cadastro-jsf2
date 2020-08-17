package br.com.stefanini.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.stefanini.model.Pessoa;
import br.com.stefanini.util.JPAUtil;

public class PessoaRepository implements JPARepository<Pessoa,Long> , Serializable{

	private static final long serialVersionUID = 1L;
	private static EntityManager em = JPAUtil.getEntityManager();
	private static EntityTransaction transaction = em.getTransaction();


	public PessoaRepository() {
	}

	@Override
	public List<Pessoa> listarTodos() {
		try {
			return JPAUtil.getEntityManager().createNamedQuery(Pessoa.LISTAR_TODOS, Pessoa.class).getResultList();
		} catch (Exception e) {
			System.out.println("Não foi possível listar todos os usuários.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Pessoa buscarPorId(Long id)  throws Exception {
		try {
			return JPAUtil.getEntityManager().find(Pessoa.class, id);
		} catch (Exception e) {
			System.out.println("Não foi possível buscarPorId o usuário.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void salvar(Pessoa entity)  throws Exception  {
		try {
			if( !transaction.isActive() ) transaction.begin();
                em.persist(entity); 
			    transaction.commit();
		} catch (Exception e) {
			System.out.println(" Não foi possível salvar o usuário ");
			e.printStackTrace();
		}
	}

	@Override
	public Pessoa atualizar(Pessoa entity) throws Exception {
		try {
			if( !transaction.isActive() ) transaction.begin();
			 Pessoa pessoa = em.merge(entity);
			transaction.commit();
			return pessoa;
		} catch (Exception e) {
			System.out.println(" Não foi possível atualizar o usuário ");
			e.printStackTrace();
		}
		return entity;
	}

	@Override
	public void excluir(Pessoa entity)  throws Exception  {
		try {
			if( !transaction.isActive() ) transaction.begin();
			em.remove( em.merge(buscarPorId( entity.getId() )) );
			transaction.commit();
		} catch (Exception e) {
			System.out.println(" Não foi possível excluir o usuário ");
			e.printStackTrace();
		}
	}

	
	public Pessoa buscarPorCPF(final String cpf) throws Exception {
		try {
			return JPAUtil.getEntityManager().createNamedQuery( Pessoa.BUSCAR_POR_CPF, Pessoa.class).setParameter(1, cpf).getSingleResult();
		} catch (Exception e) {
			System.out.println(" Não foi possível Localizar por CPF o usuário. ");
			return null;
		}
		
	}
	
  
}
	 
