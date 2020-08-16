package br.com.stefanini.repository;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.stefanini.model.Pessoa;
import br.com.stefanini.util.JPAUtil;

public class PessoaRepository implements JPARepository<Pessoa,Long> {


	private EntityManager em;


	public PessoaRepository() {
		em = JPAUtil.getEntityManager();
	}

	@Override
	public List<Pessoa> listarTodos() {
		try {
			return em.createNamedQuery(Pessoa.LISTAR_TODOS, Pessoa.class).getResultList();
		} catch (Exception e) {
			System.out.println("Não foi possível listar todos os usuários.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Pessoa buscarPorId(Long id)  throws Exception {
		try {
			return em.find(Pessoa.class, id);
		} catch (Exception e) {
			System.out.println("Não foi possível buscarPorId o usuário.");
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void salvar(Pessoa entity)  throws Exception  {
		try {
			em.getTransaction().begin();
			em.persist(entity);
			if( em.getTransaction().isActive() ) {
				em.getTransaction().commit();
			}else {
				em.getTransaction().begin();
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			System.out.println(" Não foi possível salvar o usuário ");
			e.printStackTrace();
		}
	}

	@Override
	public Pessoa atualizar(Pessoa entity) throws Exception {
		try {
			em.getTransaction().begin();
			Pessoa pessoa = em.merge(entity);
			em.getTransaction().commit();
			return pessoa;
		} catch (Exception e) {
			System.out.println(" Não foi possível atualizar o usuário ");
			e.printStackTrace();
		}finally {
			em.close();
		}
		return entity;
	}

	@Override
	public void excluir(Pessoa entity)  throws Exception  {
		try {
			em.getTransaction().begin();
			em.remove( buscarPorId( entity.getId() ));
			if( em.getTransaction().isActive() ) {
				em.getTransaction().commit();
			}else {
				em.getTransaction().begin();
				em.getTransaction().commit();
			}
		} catch (Exception e) {
			System.out.println(" Não foi possível excluir o usuário ");
			e.printStackTrace();
		}finally {
			em.close();
		}
	}

	
	public Pessoa buscarPorCPF(final String cpf) throws Exception {
		try {
			return em.createNamedQuery( Pessoa.BUSCAR_POR_CPF, Pessoa.class).setParameter(1, cpf).getSingleResult();
		} catch (Exception e) {
			System.out.println(" Não foi possível Localizar por CPF o usuário. ");
			return null;
		}
		
	}
	
  
}
	 
