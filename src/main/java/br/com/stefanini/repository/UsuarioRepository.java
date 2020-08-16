package br.com.stefanini.repository;

import javax.persistence.EntityManager;

import br.com.stefanini.model.Usuario;
import br.com.stefanini.util.JPAUtil;



public class UsuarioRepository { 

	private EntityManager em;


	public UsuarioRepository() {
		em = JPAUtil.getEntityManager();	
	}
	
	public void salvar(Usuario usuario) {
			try {
				em.getTransaction().begin();
				em.persist(usuario);
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

	public Usuario buscar(String login, String senha) {
			try {
				return em.createNamedQuery(Usuario.LOGIN, Usuario.class).setParameter(1,login).setParameter(2, senha).getSingleResult();
			} catch (Exception e) {
				System.out.println(" Login não Localizado! ");
				return null;
			}
			
	}
	

}
