package br.com.stefanini.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.stefanini.model.Usuario;
import br.com.stefanini.util.JPAUtil;



public class UsuarioRepository { 

	private static EntityManager em = JPAUtil.getEntityManager();
	private static EntityTransaction transaction = em.getTransaction();


	public UsuarioRepository() {
	}
	
	public void salvar(Usuario usuario) {
			try {
				if( !transaction.isActive() ) transaction.begin();
				   em.persist(usuario);
				   em.getTransaction().commit();
			} catch (Exception e) {
				System.out.println(" Não foi possível salvar o usuário ");
				e.printStackTrace();
			}
		}

	public Usuario buscar(String login, String senha) {
			try {
				return em.createNamedQuery(Usuario.LOGIN, Usuario.class).setParameter(1,login).setParameter(2, senha).getSingleResult();
			} catch (Exception e) {
				System.out.println(" Login não Localizado! ");
				return null;
			}
			
	}
	
	public List<Usuario> listar() {
		try {
			return em.createNamedQuery(Usuario.TODOS, Usuario.class).getResultList();
		} catch (Exception e) {
			System.out.println(" Login não Localizado! ");
			return null;
		}
		
}
}
